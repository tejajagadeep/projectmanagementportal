import { Component, OnInit } from '@angular/core';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';

@Component({
  selector: 'app-nav-bar-handler',
  templateUrl: './nav-bar-handler.component.html',
  styleUrls: ['./nav-bar-handler.component.css']
})
export class NavBarHandlerComponent implements OnInit {

  isUserLoggedIn!: boolean

  constructor(
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.isUserLoggedIn = this.authService.isUserLoggedIn1();
    console.log(this.authService.isUserLoggedIn1());
    console.log(this.isUserLoggedIn);
  }

}
