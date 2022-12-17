import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Story } from 'src/app/model/story';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { StoryDataService } from 'src/app/service/data/story-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-project-story-registration',
  templateUrl: './project-story-registration.component.html',
  styleUrls: ['./project-story-registration.component.css']
})
export class ProjectStoryRegistrationComponent implements OnInit {

  story!: Story
  storyId!: string
  projectId!: string
  dateDummy!: Date
  errorMessageResponse!: string
  temp!: string
  username!: string
  storyAssigned!: string[]

  emailIds!: string[]
  names!: string[]
  user!: User
  users!: User[]

   storyIdT!: boolean
     storyTitleT!: boolean
     storyDescriptionT!: boolean
     assigneeT!: boolean
     assigneeEmailIdT!: boolean
     assignmentDateT!: boolean
     targetDateT!: boolean
     statusT!: boolean

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private storyDataService: StoryDataService,
    private authService: AuthenticationDataService,
    private location: Location,
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    console.log('project-story-registration.component.ts')
    this.projectId = this.route.snapshot.params['projectId']
    this.story = new Story('', '', '', '', '', this.dateDummy, this.dateDummy, '', '', '', this.storyAssigned);
    
    this.getAllUsers()
    this.username = this.authService.getLoggedInUserName();
    this.getUser(this.username)
    this.story.assignee = this.user.name
    console.log(this.story.assignee)
    this.story.assigneeEmailId = this.user.emailAddress
    
  }

  navBack() {
    this.location.back()
  }

  getAllUsers() {
    this.userService.getAllUsers().subscribe(
      response => this.handleGetUsers(response)
      // {
      //   // console.log(response);
      //   this.user = response;
      //   // console.log(this.user)
      // }
    );
    console.log('getAllUsers')

  }

  handleGetUsers(response: any) {
    this.users = response
    console.log('handle getUsers')

  }

  OnlyAlbhabets(event: any):boolean{

    const charCode = (event.which)?event.which: event.keyCode;

    if (charCode == 32 || ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))) {
       return true
    }


    return false;
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

  

  saveProjectStory() {

    if(this.story.storyId===''){
      this.storyIdT=true
    }
    if(this.story.storyTitle===''){
      this.storyTitleT=true
    }
    if(this.story.storyDescription===''){
      this.storyDescriptionT=true
    }
    if(this.story.assignee===''){
      this.assigneeT=true
    }
    if(this.story.assigneeEmailId===''){
      this.assigneeEmailIdT=true
    }
    if(this.story.assignmentDate===this.dateDummy){
      this.assignmentDateT=true
    }
    if(this.story.targetDate===this.dateDummy){
      this.targetDateT=true
    }
    
    if(this.story.status===''){
      this.statusT=true
    } 
    this.storyDataService.saveStory(this.story)
      .subscribe(
        response => {
          console.log("Response Recieved" + response.storyId)
          // response.assignee = this.user.name;
          // response.assigneeEmailId = this.user.emailAddress;
          this.storyDataService.StoryAssign(this.projectId, this.story.storyId, this.story).subscribe(
            response => {
              console.log("projectId" + this.projectId + "is assigned" + response.storyId)
            }
          )
          this.router.navigate(['view-project-story-status/', this.projectId, response.storyId])
        },
        error => {
          console.log("Exception Occured")
          this.handleErrorMessage(error);
        }

      )
  }


  handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
    this.errorMessageResponse = error.error.message
  }
}
