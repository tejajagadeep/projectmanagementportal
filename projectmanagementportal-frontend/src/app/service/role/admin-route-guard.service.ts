import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from '../auth/authentication-data.service';
import { UserDataService } from '../data/user-data.service';

@Injectable({
  providedIn: 'root'
})
export class AdminRouteGuardService implements CanActivate {

  userDetails!: User
  constructor(
    private router: Router,
    private authService: AuthenticationDataService,
    private userSerivce: UserDataService
    ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {



    this.userSerivce.getUserByUserName(this.authService.getLoggedInUserName()).subscribe(
      resposne =>{
        this.userDetails=resposne
      }
    )

    if (this.authService.isUserLoggedIn() && this.userDetails.role=='Admin'){
      return true;
    }
    else if (this.authService.isUserLoggedIn() && this.userDetails.role=='Member'){
      this.router.navigate(['error']);
      return true;
    }
    this.router.navigate(['login']);
    return false;

  }
}
