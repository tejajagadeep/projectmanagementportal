import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { Story } from '../model/story';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { StoryDataService } from '../service/data/story-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-view-project-status',
  templateUrl: './view-project-status.component.html',
  styleUrls: ['./view-project-status.component.css']
})
export class ViewProjectStatusComponent implements OnInit {

  story!: Story[]
  // projects!:Project[]
  project!:Project
  storyData!: Story
  message!: string
  errorMessage!: string
  projectId!: string 
  user!: User
  username!: string

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private userService: UserDataService,
    private projectService: ProjectDataService,
    private storyService: StoryDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.projectId = this.route.snapshot.params['projectId']
    console.log(this.route.snapshot.params['projectId'])
    this.getProejctsById(this.projectId);
    // this.getAllProjects();
    this.getAllStories();
    this.getUsername();
    this.getUser(this.username);
  }

  getUsername(){
    this.username=this.authService.getLoggedInUserName();
  }

  navLink() {
    this.router.navigate(['view-project-status']);
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

  getProejctsById(projectId: string) {
    this.projectService.getProjectById(projectId).subscribe(
      response => {
        console.log("response")
        this.handleGetProject(response)
        // this.project = response;
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  // getAllProjects(){
  //   this.projectService.getAllProjects().subscribe(
  //     response => this.handleGetProjects(response)
  //   );
  //  }

  updateProject(projectId: string){
    console.log(`update ${projectId}`);
    this.router.navigate([`project-update/${projectId}`])
    // this.router.navigate([`view-project-status/${projectId}`])
  }

  deleteProject(projectId: string){
    this.projectService.deleteProjectById(projectId).subscribe(
      response =>  {
        this.message = `Deleted Project with Id ${projectId}`;
        console.log(this.message)
        this.navLink();
        // this.getAllProjects();
        this.getAllStories();
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
    )
  }

  // handleGetProjects(response : any){
  //   this.projects = response
  //  }

   handleGetProject(response : any){
    this.project = response
   }

   getAllStories(){
    this.storyService.getAllStories().subscribe(
      response => this.handleGetStories(response)
    );
   }

  

  handleGetStories(response : any){
    this.story = response
    // console.log(response)
  }

  handleErrorMessage(error: any){
    this.errorMessage = error.error.message;
  }

}
