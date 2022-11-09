import { Component, OnInit } from '@angular/core';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  isUserLoggedIn! : boolean

  constructor(
    private authService : AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.isUserLoggedIn = this.authService.isUserLoggedIn();
  }

  

}
