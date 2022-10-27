import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../member-sign-up/member-sign-up.component';
import { Project } from '../project-registration-or-updation/project-registration-or-updation.component';
import { Story } from '../project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { ProjectDataServiceService } from '../service/data/project-data-service.service';
import { StoryDataServiceService } from '../service/data/story-data-service.service';
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
  story!: Story[]
  project!:Project[]

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private userService: UserDataServiceService,
    private projectService: ProjectDataServiceService,
    private storyService: StoryDataServiceService
    
    ) { }

  ngOnInit(): void {
    this.getAllUsers();
    this.getAllProjects();
    this.getAllStories();

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
    this.projectService.getAllProjects().subscribe(
      response => this.handleGetProjects(response)
    );
   }

   handleGetProjects(response : any){
    this.project = response
   }

   getAllStories(){
    this.storyService.getAllStories().subscribe(
      response => this.handleGetStories(response)
    );
   }

   handleGetStories(response : any){
    this.story = response
    console.log(response)
  }

   
}
