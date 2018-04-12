import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../../models/book";
import {ActivatedRoute} from "@angular/router";
import {BookService} from "../../services/book.service";

@Component({
  selector: 'app-book-read',
  templateUrl: './book-read.component.html',
  styleUrls: ['./book-read.component.css']
})
export class BookReadComponent implements OnInit {

  id;

  book = {};

  pdfSrc: string = null;

  constructor( private route: ActivatedRoute, private bookService: BookService) {
    this.id = this.route.snapshot.paramMap.get('id');
    this.pdfSrc ='/api/books/pdf/'+this.id;
  }

  ngOnInit() {
  }

}
