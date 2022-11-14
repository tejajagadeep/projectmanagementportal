import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Story } from '../project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { StoryDataService } from '../service/data/story-data.service';
import { Location } from '@angular/common';

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

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private location: Location,
    private projectService: ProjectDataService,
    private storyService: StoryDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.storyId = this.route.snapshot.params['storyId'];
    this.getStoryById(this.storyId);
    this.username=this.authService.getLoggedInUserName();
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
    this.router.navigate([`project-story-registration/${storyId}`])
  }

  
  deleteStory(storyId: string){
    this.storyService.deleteStoryById(storyId).subscribe(
      response =>  {
        this.message = `Deleted Story with Id ${storyId}`;
        console.log(this.message)

        this.getAllStories();
        this.location.back()
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
