import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationDataService {

  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public username!: string
  public password!: string;

  constructor(private http: HttpClient) { }

  authenticate(username: string, password: string) {
    if (username === "in28minutes" && password === "password") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }

  authenticationService(username: string, password: string) {
    return this.http.post(`http://localhost:8093/project-management/basicauth`,
      { headers: { authorization: this.createBasicAuthToken1(username, password) } }).pipe(map((res) => {
        this.username = username;
        this.password = password;
        this.registerSuccessfulLogin1(username, password);
      }));
  }

  createBasicAuthToken1(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin1(username: string, password: string) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
  }

  logout1() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    // this.username = null;
    // this.password = null;
  }

  isUserLoggedIn1() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  getLoggedInUserName1() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }

}
