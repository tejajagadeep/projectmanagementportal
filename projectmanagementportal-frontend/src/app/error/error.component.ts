import { Component, OnInit } from '@angular/core';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  errorMessage = 'An Error Occured! Redirecting...'

  isUserLoggedIn! : boolean
  username!:string

  constructor(
    private authService : AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.isUserLoggedIn = this.authService.isUserLoggedIn();

  }
}
