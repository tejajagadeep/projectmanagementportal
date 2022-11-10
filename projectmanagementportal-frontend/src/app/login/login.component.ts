import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../member-sign-up/member-sign-up.component';
import { Project } from '../project-registration-or-updation/project-registration-or-updation.component';
import { Story } from '../project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username!: string
  password!: string
  errorMessage = 'Invalid Credentials'
  successMessage!: string
  invalidLogin = false
  loginSuccess = false

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private authenticateLoginService: AuthenticationDataService
  ) { }

  ngOnInit(): void {

  }

  navLink() {
    this.router.navigate(["home"]);
  }

  handleJWTAuthLogin() {
    // console.log(this.username);
    if (this.username === 'in28minutes' && this.password === 'dummy') {
      this.router.navigate(['home', this.username])
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
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
    if (this.authenticateLoginService.authenticate(this.username, this.password)
    ) {
      this.router.navigate(['home', this.username])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }

  checkLogin1() {
    this.authenticateLoginService.authenticationService(this.username, this.password).subscribe(result=> {
      console.log(result)
      this.invalidLogin = false,
      this.loginSuccess = true,
      console.log(this.loginSuccess)
      this.successMessage = 'Login Successful.',
      this.router.navigate(['/home',this.username])
    }, error => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }



}
