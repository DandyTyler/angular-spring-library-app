import {BrowserModule} from '@angular/platform-browser';
import {FormsModule } from '@angular/forms';
import {NgModule} from '@angular/core';
import {RouterModule} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {HttpClientModule} from '@angular/common/http';
import {CustomFormsModule} from "ng2-validation";

import {AppComponent} from './app.component';
import {BsNavbarComponent} from './bs-navbar/bs-navbar.component';
import {HomeComponent} from './home/home.component';
import {BooksComponent} from './books/books.component';
import {AdminBooksComponent} from './admin/admin-books/admin-books.component';
import {LoginComponent} from './login/login.component';
import { BookFormComponent } from './admin/book-form/book-form.component';
import {GenreService} from "./services/genre.service";
import {BookService} from "./services/book.service";


@NgModule({
  declarations: [
    AppComponent,
    BsNavbarComponent,
    HomeComponent,
    BooksComponent,
    AdminBooksComponent,
    LoginComponent,
    BookFormComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CustomFormsModule,
    HttpClientModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'books', component: BooksComponent},
      {path: 'login', component: LoginComponent},
      {path: 'admin/books/new', component: BookFormComponent},
      {path: 'admin/books/:id', component: BookFormComponent},
      {path: 'admin/books', component: AdminBooksComponent}
    ])
  ],
  providers: [
    GenreService,
    BookService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
