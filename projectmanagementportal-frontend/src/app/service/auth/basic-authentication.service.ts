import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { USER_API_URL } from 'src/app/app.constants';

// export const TOKEN = 'token'
// export const AUTHENTICATED_USER = 'authenticaterUser'

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {


  public TOKEN = 'token'
  public AUTHENTICATED_USER = 'authenticaterUser'

  constructor(private http: HttpClient) { }

  executeJWTAuthenticationService(username: string, password: string) {

    return this.http.post<any>(
      `http://localhost:8093/project-management/authenticate`, {
      username,
      password
    }).pipe(
      map(
        data => {
          sessionStorage.setItem(this.AUTHENTICATED_USER, username);
          sessionStorage.setItem(this.TOKEN, `Bearer ${data.token}`);
          return data;
        }
      )
    );
    //console.log("Execute Hello World Bean Service")
  }


  executeAuthenticationService(username: string, password: string) {

    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);

    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })

    return this.http.get<any>(
      `http://localhost:8093/project-management/**`,
      { headers }).pipe(
        map(
          data => {
            sessionStorage.setItem(this.AUTHENTICATED_USER, username);
            sessionStorage.setItem(this.TOKEN, basicAuthHeaderString);
            return data;
          }
        )
      );
    //console.log("Execute Hello World Bean Service")
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.AUTHENTICATED_USER)
    if (user === null) return ''
    return user
  }

  getAuthenticatedToken() {
    if (this.getLoggedInUserName())
      return sessionStorage.getItem(this.TOKEN)
    return;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.AUTHENTICATED_USER)
    if (user === null) return false
    return true
  }

  logout() {
    sessionStorage.removeItem(this.AUTHENTICATED_USER)
    sessionStorage.removeItem(this.TOKEN)
  }

}

export class AuthenticationBean {
  constructor(public message: string) { }
}