import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookCardComponent} from "./components/book-card/book-card.component";
import {OrderDetailsComponent} from "./components/order-details/order-details.component";
import {AuthGuard} from "./services/auth-guard.service";
import {GenreService} from "./services/genre.service";
import {OrderService} from "./services/order.service";
import {AuthService} from "./services/auth.service";
import {AuthorService} from "./services/author.service";
import {BookService} from "./services/book.service";
import {UserService} from "./services/user.service";
import {RouterModule} from "@angular/router";
import {OrdersComponent} from "./components/orders/orders.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    NgbModule.forRoot(),
  ],
  declarations: [
    BookCardComponent,
    OrderDetailsComponent,
    OrdersComponent
  ],
  exports: [
    BookCardComponent,
    OrderDetailsComponent,
    OrdersComponent
  ],
  providers: [
    GenreService,
    BookService,
    AuthorService,
    AuthService,
    UserService,
    OrderService,
    AuthGuard,
  ]
})
export class SharedModule { }
