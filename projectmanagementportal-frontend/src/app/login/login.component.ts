import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse } from '../model/message-response';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { BasicAuthenticationService } from '../service/auth/basic-authentication.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username!: string
  password!: string
  errorMessage!: string
  successMessage!: string
  invalidLogin = false
  isLogin = false
  user!: User
  messageResponse!: MessageResponse

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private authenticateLoginService: AuthenticationDataService,
    private basicAuthService: BasicAuthenticationService,
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    console.log('login.component.ts')
    this.isLogin = this.authenticateLoginService.isUserLoggedIn();
    console.log(this.isLogin)
  }

  navLink() {
    console.log('navLink')
    this.router.navigate(["home"]);
  }

  handleJWTAuthLogin() {
    this.basicAuthService.executeJWTAuthenticationService(this.username, this.password)
      .subscribe(
        data => {
          console.log(data)
          this.router.navigate(['welcome', this.username])
          this.invalidLogin = false
          // },
          // error => {
          //   console.log(error)
          //   this.invalidLogin = true
        }
      )
  }


  handleSuccessResponse(response: any) {
    // console.log(response);
    this.successMessage = response.message
  }

  handleErrorResponse(error: any) {
    // console.log(response);
    this.errorMessage = error.error.message
  }


  checkLogin() {
    if (this.basicAuthService.executeJWTAuthenticationService(this.username, this.password)
    ) {
      this.router.navigate(['home', this.username])
      this.invalidLogin = false
    } else
      this.invalidLogin = true

  }

  checkLogin1() {
    // this.authenticateLoginService.authenticationService(this.username, this.password).subscribe(
    //   // {
    //   response => {
    //     this.user = response
    //     this.router.navigate(['/home', this.username])

    //   }



    // );
    // this.userService.login(this.username, this.password, this.user).subscribe(
    //   (data: User) => { this.user = data },
    //   error => this.errorMessage = "Invalid Credantials"
    // )

    this.authenticateLoginService.authenticate(this.username, this.password).subscribe(
      response => {
        this.user = response
        this.router.navigate(['/home', this.username])
      },
      error => {
        this.errorMessage = "Invalid Credentials"
      }

    );
  }
}