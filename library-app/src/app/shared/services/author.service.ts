import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Author} from "../models/author";
import {Book} from "../models/book";

@Injectable()
export class AuthorService {

  private url = "api/authors";

  constructor(private http: HttpClient) { }


  getAll(): Observable<Author[]>{
    return this.http.get<Author[]>(this.url)
  }

  get(authorId): Observable<Author>{
    return this.http.get<Author>(this.url+'/'+ authorId)
  }

  create(author: Author){
    return this.http.post<Author>(this.url, author);
  }

  update(authorId, author){
    return this.http.post<Book>(this.url+ '/'+authorId, author)
  }

  delete(authorid){
    return this.http.delete(this.url+'/'+authorid);
  }
}
