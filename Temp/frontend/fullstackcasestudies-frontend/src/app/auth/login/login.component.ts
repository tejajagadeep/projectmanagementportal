import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse } from 'src/app/model/message-response';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username!: string
  password!: string
  errorMessage!: string
  invalidLogin = false
  isLogin = false
  messageResponse!: MessageResponse

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private authenticateLoginService: AuthenticationDataService,
  ) { }

  ngOnInit(): void {
    console.log('login.component.ts')
    this.username = ''
    this.password = 'ABCabc@123'
    this.isLogin = this.authenticateLoginService.isUserLoggedIn();
    console.log(this.isLogin)
  }

  navLink() {
    console.log('navLink')
    this.router.navigate(["home"]);
  }

  handleErrorResponse(error: any) {
    this.errorMessage = error.error.message
  }

  checkLogin1() {

    if (this.username === '') {
      this.errorMessage = 'User Id is required'
    } else if (this.password===''){
      this.errorMessage = 'Password is required'
     } else {
      this.authenticateLoginService.authenticate(this.username, this.password).subscribe(
        response => {
          this.router.navigate(['/home', this.username])
        },
        error => {
          this.errorMessage = "Invalid Credentials"
        }

      );
    }
  }
}