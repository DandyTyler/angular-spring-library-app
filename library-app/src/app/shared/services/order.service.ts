import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Order} from "../models/order";
import {number} from "ng2-validation/dist/number";

@Injectable()
export class OrderService {

  private url = "api/orders";

  constructor(private http: HttpClient) { }

  getAllOrders(){
    return this.http.get<Order[]>(this.url+"/all")
  }

  getOrders(username: string){
    const params = new HttpParams().set('username', username);

    return this.http.get(this.url,{params})
  }

  getFilteredOrders(username: string, page:number){
    const params = new HttpParams().set('username', username).set('page',page.toString());

    return this.http.get<Order[]>(this.url,{params})
  }

  placeOrder(bookId: number){
    return this.http.post<Order>("api/users/order/" + bookId, null)
  }

  acceptOrder(orderId: number){
    return this.http.post<Order>(this.url+"/accept/"+orderId, null)
  }

  closeOrder(orderId: number){
    return this.http.post<Order>(this.url+"/close/"+orderId, null)
  }

  deleteOrder(orderId: number){
    return this.http.delete(this.url+"/"+orderId)
  }

}
