import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse } from '../model/message-response';
import { Project } from '../model/project';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { StoryDataService } from '../service/data/story-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-my-projects',
  templateUrl: './my-projects.component.html',
  styleUrls: ['./my-projects.component.css']
})
export class MyProjectsComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse=""
  helloWorldMessage!: MessageResponse

  project!:Project[]
  projectMN!:Project[]
  projectTL!:Project[]
  projectAT!:Project[]
  user!: User

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
    this.getAllProjects(this.username);
    this.getAllProjectsAT(this.username)
  }
  getUser(userName: string) {
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
        this.getAllProjectsMN(response.name)
        this.getAllProjectsTL(response.name)
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

  getAllProjects(projectOwner: string){
    this.projectService.getProjectsByProjectOwner(projectOwner).subscribe(
      response =>     this.project = response
      // console.log(projectOwner)
    );
   }

   getAllProjectsMN(projectManagerName: string){
    this.projectService.getProjectsByProjectManagerName(projectManagerName).subscribe(
      response => this.projectMN = response
    );
   }

   getAllProjectsTL(techLeadName: string){
    this.projectService.getProjectsByTechLeadName(techLeadName).subscribe(
      response => 
    this.projectTL = response
    );
   }

   getAllProjectsAT(projectAssignedTo: string){
    this.projectService.getProjectByAssignedTo(projectAssignedTo).subscribe(
      response => 
    this.projectAT = response
    );
   }
   
   handleGetProjects(response : any){
    this.project = response
   }

}
