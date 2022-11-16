import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { StoryDataService } from '../service/data/story-data.service';
import { MessageResponse, UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-my-project-as-manager',
  templateUrl: './my-project-as-manager.component.html',
  styleUrls: ['./my-project-as-manager.component.css']
})
export class MyProjectAsManagerComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse=""
  helloWorldMessage!: MessageResponse
  project!:Project[]
  projectMN!: Project[]
  user!: User

  h2Show!: any

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private projectService: ProjectDataService,
    private storyService: StoryDataService,
    private authService: AuthenticationDataService,
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    this.username=this.authService.getLoggedInUserName();
    console.log(this.username)
    console.log('home.component.ts')
    this.getUser(this.username);
    // this.getAllProjects(this.username);
  }
  getUser(userName: string) {
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
        this.getAllProjects(response.name)
        this.getAllProjectsMN(response.name)
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  handleErrorMessage(error: any){
    // this.errorMessageResponse = error
      this.errorMessageResponse = error.error.message
   }

  getAllProjects(projectManagerName: string){
    this.projectService.getProjectsByProjectManagerName(projectManagerName).subscribe(
      response => this.project = response
    // console.log(projectOwner)
    );
   }

   getAllProjectsMN(techLeadName: string){
    this.projectService.getProjectsByTechLeadName(techLeadName).subscribe(
      response => 
    this.projectMN = response
    // this.handleGetProjects(response)
      // console.log(projectOwner)
    );
   }
   
   handleGetProjects(response : any){
    this.project = response
   }

}
