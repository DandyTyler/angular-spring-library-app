import {BrowserModule} from '@angular/platform-browser';
import {FormsModule } from '@angular/forms';
import {NgModule} from '@angular/core';
import {RouterModule} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {CustomFormsModule} from "ng2-validation";
import {DataTableModule} from "angular5-data-table";

import {AppComponent} from './app.component';
import {BsNavbarComponent} from './bs-navbar/bs-navbar.component';
import {HomeComponent} from './home/home.component';
import {BooksComponent} from './books/books.component';
import {AdminBooksComponent} from './admin/admin-books/admin-books.component';
import {LoginComponent} from './login/login.component';
import { BookFormComponent } from './admin/book-form/book-form.component';
import {GenreService} from "./services/genre.service";
import {BookService} from "./services/book.service";
import { BookFilterComponent } from './books/book-filter/book-filter.component';
import { BookCardComponent } from './book-card/book-card.component';
import {AuthorService} from "./services/author.service";
import { AuthorDetailsComponent } from './author-details/author-details.component';
import { AuthorFormComponent } from './admin/author-form/author-form.component';
import { AdminAuthorsComponent } from './admin/admin-authors/admin-authors.component';
import {AuthService} from "./services/auth.service";
import {AuthGuard} from "./services/auth-guard.service";
import {TokenInterceptor} from "./services/token.interceptor";
import {AdminAuthGuard} from "./services/admin-auth-guard.service";

@NgModule({
  declarations: [
    AppComponent,
    BsNavbarComponent,
    HomeComponent,
    BooksComponent,
    AdminBooksComponent,
    LoginComponent,
    BookFormComponent,
    BookFilterComponent,
    BookCardComponent,
    AuthorDetailsComponent,
    AuthorFormComponent,
    AdminAuthorsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CustomFormsModule,
    DataTableModule,
    HttpClientModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
      {path: '', component: BooksComponent},
      {path: 'books', component: BooksComponent},
      {path: 'login', component: LoginComponent},
      {path: 'authors/:id', component: AuthorDetailsComponent},
      {path: 'admin/authors/new', component: AuthorFormComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/authors/:id', component: AuthorFormComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/authors', component: AdminAuthorsComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/books/new', component: BookFormComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/books/:id', component: BookFormComponent, canActivate: [AuthGuard, AdminAuthGuard]},
      {path: 'admin/books', component: AdminBooksComponent, canActivate: [AuthGuard, AdminAuthGuard]}
    ])
  ],
  providers: [
    GenreService,
    BookService,
    AuthorService,
    AuthService,
    AuthGuard,
    AdminAuthGuard,
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
