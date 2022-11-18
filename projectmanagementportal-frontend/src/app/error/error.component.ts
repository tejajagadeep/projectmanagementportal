import { Component, OnInit } from '@angular/core';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  errorMessage = 'An Error Occured! Redirecting...'

  isUserLoggedIn!: boolean
  username!: string
  userNull!: boolean

  constructor(
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    console.log('error.component.ts')
    this.isUserLoggedIn = this.authService.isUserLoggedIn();

    this.username = this.authService.getLoggedInUserName();

    // if(this.username == null){
    //   this.userNull = true
    // } else {
    //   this.userNull = false
    // }
  }
}
