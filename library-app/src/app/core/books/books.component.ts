import {Component, OnInit} from '@angular/core';

import {Observable} from "rxjs/Observable";
import {Book} from "../../shared/models/book";
import {ActivatedRoute} from "@angular/router";
import 'rxjs/add/operator/switchMap'
import {Genre} from "../../shared/models/genre";
import {BookService} from "../../shared/services/book.service";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = [];
  filteredBooks: Book[] = [];

  genreId: number = 0;
  searchString: string = "";
  authorName: string = null;

  showSearchForm: boolean;

  constructor(private route: ActivatedRoute,
              private bookService: BookService) {
    route.queryParamMap
      .subscribe(params => {
        this.genreId = +params.get('genre');
        bookService.getWithParams(this.searchString, this.genreId)
          .subscribe((page: any) => {
            this.books = page.content;
            this.filteredBooks = page.content;
          })
      });
  }

  // constructor(route: ActivatedRoute,
  //             bookService: BookService) {
  //   bookService
  //     .getAll()
  //     .switchMap(books => {
  //       this.books = books;
  //       return route.queryParamMap;
  //     })
  //     .subscribe(params => {
  //       this.genreId = +params.get('genre');
  //
  //       this.filteredBooks = this.filterByGenre()
  //       this.filterByQuery(this.searchString)
  //     });
  // }

  filterByQuery(query: string) {
    this.filteredBooks = (query) ?
      this.filterByGenre().filter(b => b.name.toLowerCase().includes(query.toLowerCase())) :
      this.filterByGenre();
  }

  filterByGenre(): Book[] {
    return (this.genreId) ?
      this.books.filter(b => b.genre.id === this.genreId) :
      this.books;
  }

  filterByAuthor(query: string) {
    if(query){
    this.filteredBooks = (query) ?
      this.books.filter(b => b.name.includes("It")) :
      this.books;
    }
  }

  search() {
    this.bookService.getWithParams(this.searchString, this.genreId)
      .subscribe((page: any) => {
        this.books = page.content;
        this.filteredBooks = page.content;
        this.filterByAuthor(this.authorName);
        console.log(11111);
        console.log(this.searchString)
      })
  }

  showSearchMenu() {
    this.showSearchForm = !this.showSearchForm;
  }

  ngOnInit() {

  }
}
