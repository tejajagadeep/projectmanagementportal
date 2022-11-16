import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Story } from '../model/story';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { StoryDataService } from '../service/data/story-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-project-story-registration',
  templateUrl: './project-story-registration.component.html',
  styleUrls: ['./project-story-registration.component.css']
})
export class ProjectStoryRegistrationComponent implements OnInit {

  story! : Story
  storyId!: string
  projectId!: string
  dateDummy!: Date
  errorMessageResponse!: string
  temp!: string
  username!: string
  storyAssigned!:  string[]

  user!: User
  
  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private storyDataService: StoryDataService,
    private authService: AuthenticationDataService,
    private location: Location,
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    console.log('project-story-registration.component.ts')
    this.projectId = this.route.snapshot.params['projectId']
    this.story = new Story('','','','','',new Date(),new Date(),'To-Do','','','',this.storyAssigned);
    this.username = this.authService.getLoggedInUserName();
    this.getUser(this.username)
    this.story.assignee = this.user.name
    console.log(this.story.assignee)
    this.story.assigneeEmailId = this.user.name
  }

  navBack(){
    this.location.back()
  }

  getUser(userName: string) {
    console.log()
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

  saveProjectStory(){
    this.storyDataService.saveStory(this.story)
    .subscribe(
      response => {
        console.log("Response Recieved" + response.storyId)
        // response.assignee = this.user.name;
        // response.assigneeEmailId = this.user.emailAddress;
        this.storyDataService.StoryAssign(this.projectId, this.story.storyId,this.story).subscribe(
          response => {
            console.log("projectId"+this.projectId+"is assigned"+response.storyId)
          }
        )
        this.router.navigate(['view-project-story-status/',this.projectId,response.storyId])
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
      
    )
 }


 handleErrorMessage(error: any){
  // this.errorMessageResponse = error
    this.errorMessageResponse = error.error.message
 }
}
