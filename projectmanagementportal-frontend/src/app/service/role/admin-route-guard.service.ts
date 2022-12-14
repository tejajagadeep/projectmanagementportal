import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from '../auth/authentication-data.service';
import { UserDataService } from '../data/user-data.service';

@Injectable({
  providedIn: 'root'
})
export class AdminRouteGuardService implements CanActivate {

  constructor(private router: Router,
    private authService: AuthenticationDataService) { }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const role = route.data['roles'] as Array<string>
    if (role && this.authService.isUserLoggedIn()) {
      const match = (sessionStorage.getItem('userRole') === role[0])
      if (match) {
        return true
      } else {
        this.router.navigate(['forbidden']);
        return false
      }
    }
    // if (this.authService.isUserLoggedIn())
    //   return true;

    this.router.navigate(['login']);
    return false;

  }

}
