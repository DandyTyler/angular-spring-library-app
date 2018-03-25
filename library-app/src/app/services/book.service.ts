import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "../book";
import {Observable} from "rxjs/Observable";
import {Genre} from "../genre";

@Injectable()
export class BookService {

  private url = "api/books";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Book[]>{
    return  this.http.get<Book[]>(this.url);
  }

  create(book: Book): Observable<Book> {
    return this.http.post<Book>(this.url, book);
  }

  get(bookId) : Observable<Book>{
    return this.http.get<Book>(this.url+ '/'+bookId)
  }

  update(bookId, book) : Observable<Book>{
    return this.http.post<Book>(this.url+ '/'+bookId, book)
  }

}
