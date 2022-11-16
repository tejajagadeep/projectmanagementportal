import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse } from '../model/message-response';
import { Project } from '../model/project';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { BasicAuthenticationService } from '../service/auth/basic-authentication.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { StoryDataService } from '../service/data/story-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse=""
  helloWorldMessage!: MessageResponse

  // projectIdName!: string
  isUserLoggedIn! : boolean
  user!: User
  errorMessage!: string

  searchText: any;
  project!:Project[]

  // to get by value
  @ViewChild("status") status!: ElementRef
  @ViewChild("projectIdName") projectIdName!: ElementRef


  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private projectService: ProjectDataService,
    private storyService: StoryDataService,
    private authService: AuthenticationDataService,
    private userService: UserDataService,
    private basicAuthService: BasicAuthenticationService
  ) { }

  ngOnInit(): void {
    this.getUsername();
    console.log(this.username)
    console.log('home.component.ts')
    this.getAllProjects();
    this.isUserLoggedIn = this.authService.isUserLoggedIn();
    this.getUser(this.username);

    this.getByProjectStatus();
    // this.helloWorld();
  }

  getUsername(){
    this.username=this.authService.getLoggedInUserName();
  }

  getUser(userName: string) {
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  getAllProjects(){
    this.projectService.getAllProjects().subscribe(
      response => this.handleGetProjects(response)
    );
   }

   getByProjectStatus(){
    let status = this.status.nativeElement.value;
    if(status == 'Filter by status'){
      this.getAllProjects();
    }
    this.projectService.getProjectsByStatus(status).subscribe(
      response => this.handleGetProjects(response)
    )
   }

   getByProjectByIdOrManagerName(){
    let projectIdName = this.status.nativeElement.value;
      this.projectService.getProjectById(projectIdName).subscribe(
        response => this.handleGetProjects(response)
      )
   }
   
   handleGetProjects(response : any){
    this.project = response
   }

   handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
      this.errorMessage = error.error.message
  }
}
