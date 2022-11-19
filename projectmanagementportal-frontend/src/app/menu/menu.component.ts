import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  LoggedIn = false
  username!: string
  user!: User
  errorMessage!: string

  constructor(
    private authService: AuthenticationDataService,
    private userService: UserDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // this.isUserLoggedIn = this.authService.isUserLoggedIn();
    this.getUsername();
    this.getUser(this.username);
    this.LoggedIn = this.authService.isUserLoggedIn();

  }

  logout() {
    this.authService.logOut()
    this.router.navigate(['logout'])
  }

  getUsername() {
    this.username = this.authService.getLoggedInUserName();
  }

  getUser(userName: string) {
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
    this.errorMessage = error.error.message
  }

}
