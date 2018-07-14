import {Component, OnDestroy, OnInit} from '@angular/core';
import {Order} from "../../../shared/models/order";
import {Subscription} from "rxjs/Subscription";
import {OrderService} from "../../../shared/services/order.service";
import {User} from "../../../shared/models/user";
import {DataTableResource} from "angular5-data-table";
import {UserService} from "../../../shared/services/user.service";

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent implements OnDestroy{

  orders : Order[];

  subscription: Subscription;

  tableResource: DataTableResource<Order>;

  items: Order[] = [];
  itemCount: number;

    constructor(private ordersService: OrderService, public userService: UserService) {

    this.subscription = this.ordersService.getAllOrders().subscribe(orders => {
      this.orders = orders;
      this.initializeTable(orders);
    })
  }

  private initializeTable(orders: Order[]){
    this.tableResource = new DataTableResource(orders);
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

  acceptOrder(order: Order){
    let index = this.orders.indexOf(order);
    this.ordersService.acceptOrder(order.id).subscribe((acceptedOrder)=>{
      this.orders.splice(index, 1, acceptedOrder);
      this.items.splice(index, 1, acceptedOrder);
    })
  }

  closeOrder(order: Order){
    let index = this.orders.indexOf(order);
    this.ordersService.closeOrder(order.id).subscribe((closedOrder)=>{
      this.orders.splice(index, 1, closedOrder);
      this.items.splice(index, 1, closedOrder);
    })
  }

  deleteOrder(order: Order){
      let index = this.orders.indexOf(order);
      this.ordersService.deleteOrder(order.id).subscribe(()=>{
        this.orders.splice(index, 1);
        this.items.splice(index, 1);
      })
  }

  filterId(query: number) {
      console.log(query);
    let filteredOrders = (query)?
      this.orders.filter(o=> o.id == query):
      this.orders;

    this.initializeTable(filteredOrders)
  }

  filterUsername(query: string) {
    console.log(query);
    let filteredOrders = (query)?
      this.orders.filter(o=> o.username.toLowerCase().includes(query.toLowerCase())):
      this.orders;

    this.initializeTable(filteredOrders)
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
