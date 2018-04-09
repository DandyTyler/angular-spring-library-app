import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {User} from "../../models/user";
import {UserService} from "../../services/user.service";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private userService: UserService, private router: Router,) {
  }

  user: any = {};

  alertMessage: string;

  onSubmit(form: NgForm) {
    this.userService.createUser(form.value)
      .subscribe(user => {
          this.alertMessage = null;
          this.resetForm(form);
          this.router.navigate(['/login']);
        },
        error => this.alertMessage = error)

  }

  resetForm(form?: NgForm) {

    if (form != null) {
      form.reset();
      this.alertMessage = null;
    }

    this.user = {
      username: '',
      password: '',
      email: '',
      firstName: '',
      lastName: ''
    }
  }

  ngOnInit() {
  }

}
