import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {NgModule} from '@angular/core';
import {RouterModule} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {CustomFormsModule} from "ng2-validation";
import {DataTableModule} from "angular5-data-table";

import {AppComponent} from './app.component';
import {BsNavbarComponent} from './core/navbar/navbar.component';
import {BooksComponent} from './core/books/books.component';
import {AdminBooksComponent} from './admin/components/admin-books/admin-books.component';
import {LoginComponent} from './membership/login/login.component';
import {BookFormComponent} from './admin/components/book-form/book-form.component';
import {BookFilterComponent} from './core/books/book-filter/book-filter.component';
import {AuthorDetailsComponent} from './core/author-details/author-details.component';
import {AuthorFormComponent} from './admin/components/author-form/author-form.component';
import {AdminAuthorsComponent} from './admin/components/admin-authors/admin-authors.component';
import {AuthGuard} from "./shared/services/auth-guard.service";
import {AdminAuthGuard} from "./admin/services/admin-auth-guard.service";
import {NgSelectModule} from "@ng-select/ng-select";
import {BookDetailsComponent} from './core/book-details/book-details.component';
import {AdminUsersComponent} from './admin/components/admin-users/admin-users.component';
import {UserProfileComponent} from './membership/user-profile/user-profile.component';
import {RegistrationComponent} from './membership/registration/registration.component';
import {BookReadComponent} from './core/book-details/book-read/book-read.component';
import {PdfViewerModule} from "ng2-pdf-viewer";
import {AdminOrdersComponent} from './admin/components/admin-orders/admin-orders.component';
import {OrdersComponent} from './shared/components/orders/orders.component';
import {BookSearchComponent} from './core/books/book-search/book-search.component';
import {SharedModule} from "./shared/shared.module";
import {AdminModule} from "./admin/admin.module";
import {TokenInterceptor} from "./shared/services/token.interceptor";

@NgModule({
  declarations: [
    AppComponent,
    BsNavbarComponent,
    BooksComponent,
    LoginComponent,
    BookFilterComponent,
    AuthorDetailsComponent,
    BookDetailsComponent,
    UserProfileComponent,
    RegistrationComponent,
    BookReadComponent,
    BookSearchComponent,
  ],
  imports: [
    SharedModule,
    AdminModule,
    BrowserModule,
    FormsModule,
    CustomFormsModule,
    DataTableModule,
    HttpClientModule,
    NgSelectModule,
    PdfViewerModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
      {path: '', component: BooksComponent},
      {path: 'registration', component: RegistrationComponent},
      {path: 'books', component: BooksComponent},
      {path: 'books/:id', component: BookDetailsComponent},
      {path: 'books/:id/read', component: BookReadComponent},
      {path: 'login', component: LoginComponent},
      {path: 'authors/:id', component: AuthorDetailsComponent},
      {path: 'user/:username', component: UserProfileComponent, canActivate: [AuthGuard]},
      {path: 'search', component: BookSearchComponent},
    ])
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
