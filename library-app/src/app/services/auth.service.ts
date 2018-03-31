import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'
import {JwtHelper, tokenNotExpired} from "angular2-jwt";

@Injectable()
export class AuthService {

  public token: string;

  private url = "api/auth";

  constructor(private http: HttpClient) {
  }

  login(credentials) {
    return this.http.post(this.url, credentials).map((responseData: any) => {
      let result = responseData;
      if (result && result.token) {
        localStorage.setItem("token", result.token);
        return true;
      }
      return false;
    });
  }

  logout(): void {
    this.token = null;
    localStorage.removeItem('token');
  }

  public getToken(): string{
    return localStorage.getItem('token');
  }

  isAuthenticated() :boolean {
    const token = this.getToken();
   return tokenNotExpired(null, token);
  }

  getCurrentUser(): {sub: string, isAdmin: boolean }{
    const token = this.getToken();
    if(!token) return null;
    return new JwtHelper().decodeToken(token);
}
}
