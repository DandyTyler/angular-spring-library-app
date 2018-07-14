import { Injectable } from '@angular/core';
import {CanActivate, Router} from "@angular/router";
import {AuthService} from "../../shared/services/auth.service";

@Injectable()
export class AdminAuthGuard implements CanActivate{

  constructor(private auth: AuthService, private router: Router) { }

  canActivate(){
    if(this.auth.getCurrentUser().isAdmin)
      return true;

    this.router.navigate(['/'])

    return false;
  }

}
