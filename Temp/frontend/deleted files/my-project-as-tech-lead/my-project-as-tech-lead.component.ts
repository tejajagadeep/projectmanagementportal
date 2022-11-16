import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { MessageResponse, UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-my-project-as-tech-lead',
  templateUrl: './my-project-as-tech-lead.component.html',
  styleUrls: ['./my-project-as-tech-lead.component.css']
})
export class MyProjectAsTechLeadComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse=""
  helloWorldMessage!: MessageResponse
  project!:Project[]
  user!: User

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private projectService: ProjectDataService,
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

  getAllProjects(techLeadName: string){
    this.projectService.getProjectsByTechLeadName(techLeadName).subscribe(
      response => 
    this.project = response
    // this.handleGetProjects(response)
      // console.log(projectOwner)
    );
   }
   
   handleGetProjects(response : any){
    this.project = response
   }

}
