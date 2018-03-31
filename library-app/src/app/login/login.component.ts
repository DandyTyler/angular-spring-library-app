import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  invalidLogin: boolean;

  constructor(private router: Router, private route: ActivatedRoute, private authService: AuthService) {
  }

  login(credentials) {
    this.authService.login(credentials).subscribe(result => {
      if (result) {
        let returnUrl = this.route.snapshot.queryParamMap.get('returnUrl');
        this.router.navigate([returnUrl || '/'])
      } else this.invalidLogin = true;
    }, () => this.invalidLogin = true)
    ;
  }
}
