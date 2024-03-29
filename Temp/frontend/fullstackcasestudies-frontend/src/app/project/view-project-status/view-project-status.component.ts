import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse } from 'src/app/model/message-response';
import { Project } from 'src/app/model/project';
import { Story } from 'src/app/model/story';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { ProjectDataService } from 'src/app/service/data/project-data.service';
import { StoryDataService } from 'src/app/service/data/story-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-view-project-status',
  templateUrl: './view-project-status.component.html',
  styleUrls: ['./view-project-status.component.css']
})
export class ViewProjectStatusComponent implements OnInit {

  story!: Story[]
  // projects!:Project[]
  project!: Project
  storyData!: Story
  message!: string
  errorMessage!: string
  projectId!: string

  user!: User
  userByName!: User
  name!: string
  username!: string
  userIDs!: string[]
  users!: User[]

  messageAssigned!: string
  assignedTo!: string

  messageResponse!: MessageResponse
  messageAssignedNUll!: string
  assignUndefined = false

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserDataService,
    private projectService: ProjectDataService,
    private storyService: StoryDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {

    this.getUsername();
    this.getUser(this.username);

    this.projectId = this.route.snapshot.params['projectId']
    console.log(this.route.snapshot.params['projectId'])
    this.getProejctsById(this.projectId);

    console.log(this.username)
    console.log('view-project-status.component.ts')

    this.getAllStories();

    this.getAllUserIds()

  }

  getUsername() {
    this.username = this.authService.getLoggedInUserName();

  }
  getAllUserIds(){
    this.userService.getAllUsers().subscribe(
      response => this.users = response
    )
  }

  navLink() {
    this.router.navigate(['view-project-status']);
  }

  getUser(userName: string) {
    console.log()
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
        // this.name = response.name
        this.getuserByName(response.name)
        console.log(response.name)
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  projectAssign() {
    this.projectService.assignProjectToUser(this.assignedTo, this.projectId, this.messageResponse).subscribe(
      response => {
        this.messageAssigned = response.message,
        this.getProejctsById(this.projectId)
      },
      error => this.messageAssigned = error.error.message

    )

    if(this.assignedTo==undefined){
      this.assignUndefined = true
      this.messageAssigned = this.messageAssignedNUll
    }

  }

  getuserByName(name: string) {
    console.log()
    this.userService.getUserByName(name).subscribe(
      response => {
        console.log("response")
        this.userByName = response;

        console.log(this.userByName.name)
      },

      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  getProejctsById(projectId: string) {
    console.log()
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

  updateProject(projectId: string) {
    console.log(`update ${projectId}`);
    this.router.navigate([`project-update/${projectId}`])
    // this.router.navigate([`view-project-status/${projectId}`])
  }

  deleteProject(projectId: string) {
    if(confirm('Are you sure you want to delete this Project?'))
    this.projectService.deleteProjectById(projectId).subscribe(
      response => {
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

  handleGetProject(response: any) {
    this.project = response
  }

  getAllStories() {
    console.log()
    this.storyService.getAllStories().subscribe(
      response => this.handleGetStories(response)
    );
  }



  handleGetStories(response: any) {
    this.story = response
    // console.log(response)
  }

  handleErrorMessage(error: any) {
    this.errorMessage = error.error.message;
  }

}
