import {BrowserModule} from '@angular/platform-browser';
import {FormsModule } from '@angular/forms';
import {NgModule} from '@angular/core';
import {RouterModule} from "@angular/router";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {HttpClientModule} from '@angular/common/http';
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
