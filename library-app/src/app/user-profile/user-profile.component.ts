import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user.service";
import {User} from "../models/user";
import {ActivatedRoute} from "@angular/router";
import {AuthService} from "../services/auth.service";
import {FormGroup, NgForm} from "@angular/forms";
import {Vote} from "../models/vote";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user: User;

  userVotes : Vote[] = [];

  profileForm: NgForm;

  isEditing: boolean;

  constructor(private route: ActivatedRoute, private userService: UserService, private authService: AuthService) {
  }

  edit(f: NgForm) {
    this.profileForm = f;
    if (this.isEditing) {
      this.isEditing = false;
    } else {
      this.isEditing = true;
    }
  }

  save(f: NgForm) {
    this.userService.updateUser(this.user.username, f.value).subscribe(updatedUser=> this.user = updatedUser,
      error => {
        f.setValue({
          "firstName": this.user.firstName,
          "lastName": this.user.lastName,
          "email": this.user.email
        });
      });
    this.isEditing = false;
  }

  cancel(){
    this.profileForm.setValue({
      "firstName": this.user.firstName,
      "lastName": this.user.lastName,
      "email": this.user.email
    });
    this.isEditing = false;
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {

      let username = params.get("username");
      if (username) {
        this.userService.getUser(username).subscribe(user => {
          this.user = user;
          this.userService.getVotes(username).subscribe(userVotes => this.userVotes = userVotes);
        });
      } else {
        this.userService.getCurrentUser().subscribe(user => {
          this.user = user;
          this.userService.getVotes(username).subscribe(userVotes => this.userVotes = userVotes);
        });
      }
    });
  }

}
