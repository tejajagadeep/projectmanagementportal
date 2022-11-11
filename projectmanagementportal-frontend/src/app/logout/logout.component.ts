import { Component, OnInit } from '@angular/core';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private AuthGaurdService: AuthenticationDataService
  ) { }

  ngOnInit(
    
  ): void {

    this.AuthGaurdService.logOut();

  }

}
