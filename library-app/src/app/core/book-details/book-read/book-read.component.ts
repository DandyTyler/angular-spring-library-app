import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-book-read',
  templateUrl: './book-read.component.html',
  styleUrls: ['./book-read.component.css']
})
export class BookReadComponent implements OnInit {

  bookId;

  page: number = 1;

  pdfSrc: string = null;

  constructor(private route: ActivatedRoute) {
    this.bookId = this.route.snapshot.paramMap.get('id');
    this.pdfSrc = '/api/books/pdf/' + this.bookId;
  }

  nextPage() {
    this.page++;
  }

  prevPage() {
    this.page--;
  }

 onLeft(event) {
    this.page--;
  }

  ngOnInit() {
  }

}
