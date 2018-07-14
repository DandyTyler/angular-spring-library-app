import {Component, Input, OnInit} from '@angular/core';

import {OrderService} from "../../services/order.service";
import {Order} from "../../models/order";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  @Input('username') username: string;

  userOrders: Order[] = [];

  page = 1;

  size;

  closeResult: string;

  constructor(private orderService: OrderService, private modalService: NgbModal) { }

  deleteOrder(order: Order){
    this.orderService.deleteOrder(order.id).subscribe(()=>{
      let index: number;
      index = this.userOrders.indexOf(order);
      this.userOrders.splice(index,1)
    });
  }

  loadPage(){
    this.orderService.getFilteredOrders(this.username, this.page).subscribe((userOrdersPage: any)=> this.userOrders = userOrdersPage.content.reverse());
  }

  open(content) {
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  ngOnInit() {
    this.orderService.getFilteredOrders(this.username, this.page).subscribe((userOrdersPage: any)=> {
      this.userOrders = userOrdersPage.content.reverse();
      this.size =userOrdersPage.totalElements;
    });
  }

}
