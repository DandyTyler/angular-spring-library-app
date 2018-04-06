import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {User} from "../models/user";
import {Observable} from "rxjs/Observable";

@Injectable()
export class UserService {

  private url = "api/users";

  constructor(private http: HttpClient) {
  }

  voteBook(vote) {
    return this.http.post(this.url + "/current/vote", vote);
  }

  getVote(username: string, bookId: number) {
    return this.http.get(this.url + "/vote/" + username + "/" + bookId);
  }

  getVotes(username: string) {
    return this.http.get(this.url + "/user/"+ username + "/votes");
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url);
  }

  getCurrentUser(): Observable<User>{
    return this.http.get<User>(this.url + "/current");
  }

  getUser(username:string): Observable<User>{
    return this.http.get<User>(this.url + "/"+ username);
  }

  setEnable(username: string, enable: boolean): Observable<User> {
    const params = new HttpParams().set('setEnabled', enable.toString());

    return this.http.post<User>(this.url + "/user/" + username+ "/status", null, {params});
  }

}
