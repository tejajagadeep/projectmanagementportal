import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { MessageResponse } from 'src/app/model/message-response';
import { Project } from 'src/app/model/project';
import { Story } from 'src/app/model/story';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { ProjectDataService } from 'src/app/service/data/project-data.service';
import { StoryDataService } from 'src/app/service/data/story-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

declare var window: any;

@Component({
  selector: 'app-view-project-story-status',
  templateUrl: './view-project-story-status.component.html',
  styleUrls: ['./view-project-story-status.component.css']
})
export class ViewProjectStoryStatusComponent implements OnInit {

  username!: string;
  story!: Story;
  storyId!: string;
  errorMessageResponse!: string;
  temp!: string;
  message!: string
  user!: User
  userByName!: User
  userIDs!: string[]
  name!: string

  projectId!: string
  project!: Project

  assignedTo!: string
  messageResponse!: MessageResponse
  messageAssigned!: string
  messageAssignedNUll!: string
  assignUndefined = false

  formModal:any

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private location: Location,
    private userService: UserDataService,
    private projectService: ProjectDataService,
    private storyService: StoryDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.storyId = this.route.snapshot.params['storyId'];
    // this.projectId = this.route.snapshot.params['projectId'];
    console.log(this.projectId)
    console.log('view-project-story-status.component.ts')

    this.getStoryById(this.storyId);
    // this.getProjectsById(this.projectId)
    this.getUsername();
    this.getUser(this.username);
    this.getAllUserIds()

    // this.getuserByName(this.name)

    
  }

  openModal(){
    this.formModal.show()
  }

  getAllUserIds(){
    this.userService.getUserIds().subscribe(
      response => this.userIDs = response
    )
  }

  storyAssign() {
    
    this.storyService.StoryAssignToUser(this.assignedTo, this.storyId, this.messageResponse).subscribe(
      response => {
        this.messageAssigned = response.message,
        this.getStoryById(this.storyId)
      },
      
      error => this.messageAssigned = error.error.message

    )
    if(this.assignedTo==undefined){
      this.assignUndefined = true
      this.messageAssigned = this.messageAssignedNUll
  }
  }

  getUsername() {
    this.username = this.authService.getLoggedInUserName();
  }

  getUser(userName: string) {
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
        this.name = response.name
        console.log(this.name)
        this.getuserByName(this.name)
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  getuserByName(name: string) {
    this.userService.getUserByName(name).subscribe(
      response => {
        console.log("response")
        this.userByName = response;
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  navBack() {
    this.location.back();
  }

  getStoryById(storyId: string) {
    this.storyService.getStoryById(storyId).subscribe(
      response => {
        this.story = response;
        this.projectId = response.projectIdName
        this.getProjectsById(this.projectId)
        console.log("projectIdName:" + this.projectId)
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
    )
  }

  handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
    if (this.storyId === undefined) {
      this.errorMessageResponse = this.temp
    } else {
      this.errorMessageResponse = error.error.message
    }
  }

  updateStory(storyId: string) {
    console.log(`update ${storyId}`);
    // this.router.navigate(['view-project-status/project-story-registration',storyId]);
    this.router.navigate([`project-story-update/${storyId}`])
  }


  deleteStory(storyId: string) {
    if(confirm('Are you sure you want to delete this story?'))
    this.storyService.deleteStoryById(storyId).subscribe(
      response => {
        this.message = `Deleted Story with Id ${storyId}`;
        console.log(this.message)

        this.getAllStories();
        this.navBack()
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
    )
  }

  getAllStories() {
    this.storyService.getAllStories().subscribe(
      response => this.handleGetStories(response)
    );
  }

  handleGetStories(response: any) {
    this.story = response
    // console.log(response)
  }

  getProjectsById(projectId: string) {
    this.projectService.getProjectById(projectId).subscribe(
      response => {
        console.log("response")
        this.handleGetProject(response)
        this.name = response.projectManagerName
        // this.project = response;
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  handleGetProject(response: any) {
    this.project = response
  }
}