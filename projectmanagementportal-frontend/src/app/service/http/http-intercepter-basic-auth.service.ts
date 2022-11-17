import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationDataService } from '../auth/authentication-data.service';
import { BasicAuthenticationService } from '../auth/basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthService implements HttpInterceptor{

  constructor(
    private basicAuthenticationService : BasicAuthenticationService,
    private authDataService: AuthenticationDataService
  ) { }

  // intercept(request: HttpRequest<any>, next: HttpHandler){
  //   let basicAuthHeaderString = this.basicAuthenticationService.getAuthenticatedToken();
  //   let username = this.basicAuthenticationService.getLoggedInUserName()

  //   if(basicAuthHeaderString && username) { 
  //     request = request.clone({
  //       setHeaders : {
  //           Authorization : basicAuthHeaderString
  //         }
  //       }) 
  //   }
  //   return next.handle(request);
  // }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {


    if (this.authDataService.isUserLoggedIn() && (req.url.indexOf('basicauth') === -1 || req.url.indexOf('userSignUp') === 0)) {
        const authReq = req.clone({
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': `Basic ${window.btoa(this.authDataService.username + ":" + this.authDataService.password)}`
            })
        });
        return next.handle(authReq);
    } else {
        return next.handle(req);
    }
}
}
