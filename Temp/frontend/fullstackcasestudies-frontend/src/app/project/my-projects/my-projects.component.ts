import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse } from 'src/app/model/message-response';
import { Project } from 'src/app/model/project';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { ProjectDataService } from 'src/app/service/data/project-data.service';
import { StoryDataService } from 'src/app/service/data/story-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-my-projects',
  templateUrl: './my-projects.component.html',
  styleUrls: ['./my-projects.component.css']
})
export class MyProjectsComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse = ""
  helloWorldMessage!: MessageResponse

  project!: Project[]
  projectC!: number
  // projectO!:Project[]
  // projectMN!:Project[]
  // projectTL!:Project[]
  // projectAT!:Project[]
  user!: User

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private projectService: ProjectDataService,
    private storyService: StoryDataService,
    private authService: AuthenticationDataService,
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    this.username = this.authService.getLoggedInUserName();
    console.log(this.username)
    console.log('my-projects.component.ts')
    this.getUser(this.username);
    this.getAllProjects()
    // this.getAllProjectsO(this.username);
    // this.getAllProjectsAT(this.username)
    console.log(typeof this.project.length)
  }
  getUser(userName: string) {
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
        // this.getAllProjectsMN(response.name)
        // this.getAllProjectsTL(response.name)
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
    this.errorMessageResponse = error.error.message
  }

  getAllProjects() {
    this.projectService.getAllProjects().subscribe(
      response => this.project = response
      // console.log(projectOwner)
    );

  }

  getAllProjectsC() {
    this.projectService.getAllProjects().subscribe(
      response => {
        this.projectC = response.length,
        console.log(this.projectC)
      }

    );
    return this.projectC

  }
  //  getAllProjectsO(projectOwner: string){
  //   this.projectService.getProjectsByProjectOwner(projectOwner).subscribe(
  //     response =>     this.projectO = response
  //     // console.log(projectOwner)
  //   );
  //  }
  //  getAllProjectsMN(projectManagerName: string){
  //   this.projectService.getProjectsByProjectManagerName(projectManagerName).subscribe(
  //     response => this.projectMN = response
  //   );
  //  }

  //  getAllProjectsTL(techLeadName: string){
  //   this.projectService.getProjectsByTechLeadName(techLeadName).subscribe(
  //     response => 
  //   this.projectTL = response
  //   );
  //  }

  //  getAllProjectsAT(projectAssignedTo: string){
  //   this.projectService.getProjectByAssignedTo(projectAssignedTo).subscribe(
  //     response => 
  //   this.projectAT = response
  //   );
  //  }

  handleGetProjects(response: any) {
    this.project = response
  }

}
