import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  user!: User
  oldpassword!: string
  newpassword!: string
  confirmpassword!: string
  username!: string
  constructor(
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.username=this.authService.getLoggedInUserName();
  }

}
