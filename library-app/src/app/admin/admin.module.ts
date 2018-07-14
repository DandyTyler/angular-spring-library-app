import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AdminBooksComponent} from "./components/admin-books/admin-books.component";
import {BookFormComponent} from "./components/book-form/book-form.component";
import {AuthorFormComponent} from "./components/author-form/author-form.component";
import {AdminAuthorsComponent} from "./components/admin-authors/admin-authors.component";
import {AdminUsersComponent} from "./components/admin-users/admin-users.component";
import {AdminOrdersComponent} from "./components/admin-orders/admin-orders.component";
import {TokenInterceptor} from "../shared/services/token.interceptor";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AdminAuthGuard} from "./services/admin-auth-guard.service";
import {DataTableModule} from "angular5-data-table";
import {FormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {CustomFormsModule} from "ng2-validation";
import {RouterModule} from "@angular/router";
import {SharedModule} from "../shared/shared.module";
import {NgSelectModule} from "@ng-select/ng-select";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {AuthGuard} from "../shared/services/auth-guard.service";

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule,
    FormsModule,
    CustomFormsModule,
    DataTableModule,
    HttpClientModule,
    NgSelectModule,
    NgbModule.forRoot(),
    RouterModule.forChild([
      {path: 'admin/authors/new', component: AuthorFormComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/authors/:id', component: AuthorFormComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/authors', component: AdminAuthorsComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/books/new', component: BookFormComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/books/:id', component: BookFormComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/books', component: AdminBooksComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/users', component: AdminUsersComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/orders', component: AdminOrdersComponent, canActivate: [AuthGuard, AdminAuthGuard]},
    ])
  ],
  declarations: [
    AdminBooksComponent,
    BookFormComponent,
    AuthorFormComponent,
    AdminAuthorsComponent,
    AdminUsersComponent,
    AdminOrdersComponent,
  ],
  providers: [
    AdminAuthGuard,
  ]
})
export class AdminModule { }
