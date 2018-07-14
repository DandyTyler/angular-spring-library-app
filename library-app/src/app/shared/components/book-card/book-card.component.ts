import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../../models/book";

@Component({
  selector: 'book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.css']
})
export class BookCardComponent{

  @Input('book') book: Book;
  @Input('show-actions') showActions = true;

  constructor() { }

}
