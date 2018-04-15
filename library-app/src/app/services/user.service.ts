import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from "@angular/common/http";
import {User} from "../models/user";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import {Vote} from "../models/vote";

@Injectable()
export class UserService {

  private url = "api/users";

  constructor(private http: HttpClient) {
  }

  voteBook(vote) {
    return this.http.post(this.url + "/current/vote", vote);
  }

  getVote(username: string, bookId: number) {
    return this.http.get<Vote>(this.url + "/vote/" + username + "/" + bookId);
  }

  getVotes(username: string) {
    return this.http.get<Vote[]>(this.url + "/user/" + username + "/votes");
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url);
  }

  getCurrentUser(): Observable<User> {
    return this.http.get<User>(this.url + "/current");
  }

  getUser(username: string): Observable<User> {
    return this.http.get<User>(this.url + "/" + username);
  }

  updateUser(username: string, user: User) : Observable<User> {
    return this.http.put<User>(this.url + "/" + username, user);
  }

  createUser(user: User): Observable<User>  {
    return this.http.post<User>(this.url, user)
      .catch(this.errorHandler);
  }

  setEnable(username: string, enable: boolean): Observable<User> {
    const params = new HttpParams().set('setEnabled', enable.toString());

    return this.http.post<User>(this.url + "/user/" + username + "/status", null, {params});
  }

  errorHandler(error: HttpErrorResponse){
    if(error.status == 409)
    return Observable.throw( "This username already used");

    return Observable.throw("Unexpected error occurred, try again");
  }

}
