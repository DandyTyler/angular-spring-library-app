import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'book-search',
  templateUrl: './book-search.component.html',
  styleUrls: ['./book-search.component.css']
})
export class BookSearchComponent implements OnInit {

  searchString: string;

  authorName: string

  constructor() { }

  search(){
    console.log(this.searchString, +", "+ this.authorName);
  }

  ngOnInit() {
  }

}
