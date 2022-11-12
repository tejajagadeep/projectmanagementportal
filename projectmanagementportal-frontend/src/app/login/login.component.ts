import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { BasicAuthenticationService } from '../service/auth/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username!: string
  password: string ='ABCabc@123'
  errorMessage='invalidLogin'
  successMessage!: string
  invalidLogin = false
  loginSuccess = false

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private authenticateLoginService: AuthenticationDataService,
    private basicAuthService: BasicAuthenticationService
  ) { }

  ngOnInit(): void {
    console.log('login.component.ts')


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
          },
          error => {
            console.log(error)
            this.invalidLogin = true
          }
        )
  }


  handleSuccessResponse(response: any) {
    // console.log(response);
    this.successMessage = response.message
  }

  handleErrorResponse(error: any) {
    // console.log(response);
    this.errorMessage= error.error.message
  }


  checkLogin() {
    if (this.basicAuthService.executeAuthenticationService(this.username, this.password)
    ) {
      this.router.navigate(['home', this.username])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }

  checkLogin1() {
    this.authenticateLoginService.authenticationService(this.username, this.password).subscribe(
      // {
       response=> {
      console.log(response)
      this.invalidLogin = false,
      this.loginSuccess = true,
      console.log(this.loginSuccess)
      this.successMessage = 'Login Successful.',
      this.router.navigate(['/home',this.username])
    // }, error, () => {
    //   this.invalidLogin = true;
    //   this.loginSuccess = false;
    }
  
  );
  }



}
