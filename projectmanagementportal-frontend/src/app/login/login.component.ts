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

  username = 'in28minutes'
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false
  helloWorldMessage = ""
  errorMessageResponse = ""
  name = ''
  // user = new User();
  user!: User
  story!: Story[]
  project!: Project[]
  dummyNumber!: number;
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserDataService,
    private authenticateLoginService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.user = new User('', '', '', this.dummyNumber, new Date(), '', '');

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

  helloWorld() {
    // console.log("Hello World Front-End");
    // console.log(this.userService.helloWorldDataService());
    this.userService.helloWorldDataService().subscribe(
      response => this.handleSuccessResponse(response),
      error => this.handleErrorResponse(error)
      // response => console.log(response.message)
    );
  }

  helloWorldPathVariable() {
    // console.log("Hello World Front-End");
    // console.log(this.userService.helloWorldDataService());
    this.userService.helloWorldPathVariableDataService(this.username).subscribe(
      response => this.handleSuccessResponse(response),
      error => this.handleErrorResponse(error)
      // response => console.log(response.message)
    );
  }



  loginUser(){
    this.userService.login(this.username,this.password,this.user)
    .subscribe(
      (response: any) => {
        console.log("Response Recieved")
        this.navLink()
      },
      (      error: any) => {
        console.log("Exception Occured")
        this.handleErrorResponse(error);
      }
      
    )
 }

  handleSuccessResponse(response: any) {
    // console.log(response);
    this.helloWorldMessage = response.message
  }

  handleErrorResponse(error: any) {
    // console.log(response);
    this.errorMessageResponse = error.error.message
  }


  checkLogin() {
    if (this.authenticateLoginService.authenticate(this.username, this.password)
    ) {
      this.router.navigate(['home', this.username])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }


}
