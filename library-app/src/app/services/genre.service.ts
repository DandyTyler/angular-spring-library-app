import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Genre} from "../genre";


@Injectable()
export class GenreService {

  private url = "api/genres";

  constructor(private http: HttpClient) {
  }

  getGenres(): Observable<Genre[]> {
    return this.http.get<Genre[]>(this.url);
  }

}
