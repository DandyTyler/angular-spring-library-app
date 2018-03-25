import { Component, OnInit } from '@angular/core';
import {BookService} from "../../services/book.service";

@Component({
  selector: 'app-admin-books',
  templateUrl: './admin-books.component.html',
  styleUrls: ['./admin-books.component.css']
})
export class AdminBooksComponent implements OnInit {

  books$;

  constructor(private bookService: BookService ) {
    this.books$ = this.bookService.getAll()
  }

  ngOnInit() {
  }

}
