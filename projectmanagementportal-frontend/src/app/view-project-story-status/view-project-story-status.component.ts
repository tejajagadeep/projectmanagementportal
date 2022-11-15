import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { StoryDataService } from '../service/data/story-data.service';
import { Location} from '@angular/common';
import { Story } from '../model/story';
import { UserDataService } from '../service/data/user-data.service';
import { User } from '../model/user';

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

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private location: Location,
    private userService: UserDataService,
    private storyService: StoryDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.storyId = this.route.snapshot.params['storyId'];
    this.getStoryById(this.storyId);
    this.getUsername();
    this.getUser(this.username);
  }

  getUsername(){
    this.username=this.authService.getLoggedInUserName();
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

  navBack(){
    this.location.back();
  }

  getStoryById(storyId: string){
    this.storyService.getStoryById(storyId).subscribe(
      response => {
        this.story = response;
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

   updateStory(storyId: string){
    console.log(`update ${storyId}`);
    // this.router.navigate(['view-project-status/project-story-registration',storyId]);
    this.router.navigate([`project-story-update/${storyId}`])
  }

  
  deleteStory(storyId: string){
    this.storyService.deleteStoryById(storyId).subscribe(
      response =>  {
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

  getAllStories(){
    this.storyService.getAllStories().subscribe(
      response => this.handleGetStories(response)
    );
   }

   handleGetStories(response : any){
    this.story = response
    // console.log(response)
  }
}
