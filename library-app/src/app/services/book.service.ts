import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "../models/book";
import {Observable} from "rxjs/Observable";
import {ResponseContentType} from "@angular/http";

@Injectable()
export class BookService {

  private url = "api/books";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Book[]>{
    return  this.http.get<Book[]>(this.url);
  }

  get(bookId) : Observable<Book>{
    return this.http.get<Book>(this.url+ '/'+bookId)
  }

  update(bookId, book) : Observable<Book>{
    return this.http.put<Book>(this.url+ '/'+bookId, book)
  }

  updateContent(bookId, file: File){
    let fd = new FormData();
    fd.append('content', file, file.name);

    return this.http.put(this.url+ '/pdf/'+bookId, fd)
  }

  delete(bookId){
    return this.http.delete(this.url+'/'+bookId);
  }

  create(bookFormData: FormData): Observable<Book> {
    return this.http.post<Book>(this.url, bookFormData);
  }

  getContent(bookId) {
    return this.http.get(this.url+ '/pdf/'+bookId,{responseType: 'blob' })
  }

}
