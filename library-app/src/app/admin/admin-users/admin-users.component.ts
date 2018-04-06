import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {Subscription} from "rxjs/Subscription";
import {DataTableResource} from "angular5-data-table";

@Component({
  selector: 'admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnDestroy {

  users: User[];

  subscription: Subscription;

  tableResource: DataTableResource<User>;

  items: User[] = [];
  itemCount: number;

  searchQuery :string;

  constructor(private userService: UserService) {
    this.subscription = userService.getAllUsers().subscribe(users => {
      this.users = users;
      this.initializeTable(users);
    });
  }

  private initializeTable(users: User[]) {
    this.tableResource = new DataTableResource(users);
    this.tableResource.query({offset: 0})
      .then(items => this.items = items);
    this.tableResource.count()
      .then(count => this.itemCount = count);
  }

  reloadItems(params) {
    if (!this.tableResource) return;

    this.tableResource.query(params)
      .then(items => this.items = items);
  }

  filter(query: string) {
    let filteredUsers = (query) ?
      this.users.filter(u => u.username.toLowerCase().includes(query.toLowerCase())) :
      this.users;

    this.initializeTable(filteredUsers);

    this.searchQuery = query;
  }

  switchEnabled(user: User) {
    let index = this.users.indexOf(user);
    this.userService.setEnable(user.username, !user.enabled).subscribe(updatedUser => {
      this.users.splice(index,1, updatedUser);
     this.reloadItems(user)
      this.filter(this.searchQuery)
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
