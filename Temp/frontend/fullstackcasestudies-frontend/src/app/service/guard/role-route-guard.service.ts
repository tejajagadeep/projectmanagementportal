import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthenticationDataService } from '../auth/authentication-data.service';

@Injectable({
  providedIn: 'root'
})
export class RoleRouteGuardService implements CanActivate {

  constructor(private router: Router,
    private authService: AuthenticationDataService) { }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const role = route.data['roles'] as Array<string>
    const username = sessionStorage.getItem('authenticatedUser')
    if (role && this.authService.isUserLoggedIn()) {
      const match = (sessionStorage.getItem('userRole') === role[0])
      if (match) {
        return true
      } else {
        alert("You don't have access to this path. Redirect to home page.")
        this.router.navigate(['home',username]);
        return false
      }
    }

    this.router.navigate(['login']);
    return false;

  }
}
