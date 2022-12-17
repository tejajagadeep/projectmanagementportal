import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {


  username!: string
  errorMessageResponse!: string
  temp!: string
  isUserLoggedIn!: boolean
  user!: User

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.username = this.authService.getLoggedInUserName();
    console.log(this.username)
    console.log('user-profile.component.ts')
    this.isUserLoggedIn = this.authService.isUserLoggedIn();
    this.getUserByUserName(this.username)
  }

  getUsername() {
    this.username = this.authService.getLoggedInUserName();
    this.getUserByUserName(this.username);
  }

  getUserByUserName(userName: string) {
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
    if (this.username === undefined) {
      this.errorMessageResponse = this.temp
    } else {
      this.errorMessageResponse = error.error.message
    }
  }

}
