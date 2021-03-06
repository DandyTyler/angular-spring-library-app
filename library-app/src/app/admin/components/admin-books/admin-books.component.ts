import {Component, OnDestroy, OnInit} from '@angular/core';
import {BookService} from "../../../shared/services/book.service";
import {Book} from "../../../shared/models/book";
import {Subscription} from "rxjs/Subscription";
import {DataTableResource} from 'angular5-data-table';

@Component({
  selector: 'app-admin-books',
  templateUrl: './admin-books.component.html',
  styleUrls: ['./admin-books.component.css']
})
export class AdminBooksComponent implements OnDestroy {

  books: Book[];

  subscription: Subscription;

  tableResource : DataTableResource<Book>;

  items: Book[] = [];
  itemCount: number;

  constructor(private bookService: BookService) {
    this.subscription = this.bookService.getAll().subscribe(books => {
      this.books = books;
      this.initializeTable(books);
    });
  }

  private initializeTable(books: Book[]){
    this.tableResource = new DataTableResource(books);
    this.tableResource.query({offset: 0})
      .then(items=> this.items = items);
    this.tableResource.count()
      .then(count=> this.itemCount = count);
  }

  reloadItems(params){
    if(!this.tableResource) return;

    this.tableResource.query(params)
      .then(items=> this.items = items);
  }

  filter(query: string) {
    console.log(query);
    let filteredBooks = (query)?
      this.books.filter(b=> b.name.toLowerCase().includes(query.toLowerCase())):
      this.books;

    this.initializeTable(filteredBooks)
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
