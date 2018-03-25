import {Component, OnInit} from '@angular/core';
import {BookService} from "../services/book.service";
import {Observable} from "rxjs/Observable";
import {Book} from "../models/book";
import {ActivatedRoute} from "@angular/router";
import 'rxjs/add/operator/switchMap'
import {Genre} from "../models/genre";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent {

  books: Book[] = [];
  filteredBooks: Book[] = [];

  genreId: number;

  constructor(
    route: ActivatedRoute,
    bookService: BookService
  ) {
    bookService
      .getAll()
      .switchMap(books => {
        this.books = books;
        return route.queryParamMap;
    })
      .subscribe(params => {
        this.genreId = +params.get('genre');

        this.filteredBooks = (this.genreId) ?
          this.books.filter(b => b.genre.id === this.genreId) :
          this.books;
      });
  }

}
