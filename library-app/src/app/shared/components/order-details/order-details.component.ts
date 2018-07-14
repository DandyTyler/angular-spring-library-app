import {Component, Input, OnInit} from '@angular/core';
import {OrderService} from "../../services/order.service";
import {Order} from "../../models/order";
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";

@Component({
  selector: 'order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  @Input('order') order: Order;

  user: User = new User(null,null,null,null,null);

  constructor(private orderService: OrderService, private userService: UserService) { }

  ngOnInit() {
    this.userService.getUser(this.order.username).subscribe(user=>{
      this.user = user;
    })
  }

}
