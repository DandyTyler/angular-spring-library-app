import {Component} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'bs-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class BsNavbarComponent {

  constructor(private router: Router, public authService: AuthService) {
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
  }

}
