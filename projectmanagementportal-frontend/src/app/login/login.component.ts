import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../member-sign-up/member-sign-up.component';
import { UserDataServiceService } from '../service/data/user-data-service.service';

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
  helloWorldMessage =""
  errorMessageResponse=""
  name=''
  user!:User[]

  constructor(private router : Router, private route: ActivatedRoute, private userService: UserDataServiceService) { }

  ngOnInit(): void {
    this.getAllUsers()
  }

  handleJWTAuthLogin() {
    // console.log(this.username);
    if (this.username==='in28minutes' && this.password==='dummy'){
      this.router.navigate(['home', this.username])
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
  }

  helloWorld(){
    // console.log("Hello World Front-End");
    // console.log(this.userService.helloWorldDataService());
    this.userService.helloWorldDataService().subscribe(
      response => this.handleSuccessResponse(response),
      error => this.handleErrorResponse(error)
      // response => console.log(response.message)
    );
   }

   helloWorldPathVariable(){
    // console.log("Hello World Front-End");
    // console.log(this.userService.helloWorldDataService());
    this.userService.helloWorldPathVariableDataService(this.username).subscribe(
      response => this.handleSuccessResponse(response),
      error => this.handleErrorResponse(error)
      // response => console.log(response.message)
    );
   }

   handleSuccessResponse(response: any){
    // console.log(response);
    this.helloWorldMessage = response.message
   }

   handleErrorResponse(error: any){
    // console.log(response);
    this.errorMessageResponse = error.error.message
   }

   getAllUsers(){
    this.userService.getAllUsers().subscribe(
      response => this.handleGetUsers(response)
      // {
      //   // console.log(response);
      //   this.user = response;
      //   // console.log(this.user)
      // }
    );
   }

   handleGetUsers(response : any){
    this.user = response
   }

   getAllProjects(){
    this.userService.getAllUsers().subscribe(
      response => this.handleGetUsers(response)
    );
   }

   handleGetProjectss(response : any){
    this.user = response
   }
}
