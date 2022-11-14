import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Story } from '../model/story';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { StoryDataService } from '../service/data/story-data.service';

@Component({
  selector: 'app-project-story-registration',
  templateUrl: './project-story-registration.component.html',
  styleUrls: ['./project-story-registration.component.css']
})
export class ProjectStoryRegistrationComponent implements OnInit {

  story! : Story
  storyId!: string
  dateDummy!: Date
  errorMessageResponse!: string
  temp!: string
  username!: string
  
  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private storyDataService: StoryDataService,
    private authService: AuthenticationDataService,
    private location: Location
  ) { }

  ngOnInit(): void {

    this.story = new Story('','','','','',new Date(),new Date(),'To-Do','','');
    this.username = this.authService.getLoggedInUserName();
  }

  navBack(){
    this.location.back()
  }

  saveProjectStory(){
    this.storyDataService.saveStory(this.story)
    .subscribe(
      response => {
        console.log("Response Recieved")
        this.navBack()
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
      
    )
 }

 handleErrorMessage(error: any){
  // this.errorMessageResponse = error
  if (this.storyId===undefined){
    this.errorMessageResponse = this.temp
  } else {
    this.errorMessageResponse = error.error.message
  }
 }
}
