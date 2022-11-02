import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StoryDataServiceService } from '../service/data/story-data-service.service';

export class Story{

  //  storyId!: string;
  //   projectId!: string;
  //   storyTitle!: string;
  //   storyDescription!: string;
  //   assignee!: string;
  //   assigneeEmailId!: string;
  //   assignmentDate!: Date;
  //   targetDate!: Date;
  //   status!: string;
  //   remarks!: string


  constructor(

    public storyId: string,
    public projectId: string,
    public storyTitle: string,
    public storyDescription: string,
    public assignee: string,
    public assigneeEmailId: string,
    public assignmentDate: Date,
    public targetDate: Date,
    public status: string,
    public remarks: string

  ) {}
}

@Component({
  selector: 'app-project-stories-registration-or-updation',
  templateUrl: './project-stories-registration-or-updation.component.html',
  styleUrls: ['./project-stories-registration-or-updation.component.css']
})
export class ProjectStoriesRegistrationOrUpdationComponent implements OnInit {

  story! : Story
  storyId!: string
  dateDummy!: Date
  errorMessageResponse!: string
  temp!: string

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private storyDataService: StoryDataServiceService
  ) { }

  ngOnInit(): void {
    this.storyId = this.route.snapshot.params['storyId'];
    this.getStoryById(this.storyId);
    this.story = new Story('','','','','','',new Date(),new Date(),'To-Do','');

  }

  navLink(){
    this.router.navigate(['view-project-status']) ;
  }

  getStoryById(storyId: string){
    this.storyDataService.getStoryById(storyId).subscribe(
      response => {
        this.story = response;
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
    )
   }

   saveUpdateProjectStory(){
    if( this.storyId===this.story.storyId){
      this.updateProjctById()
    } else {
      this.saveProjectStory()
    }
   }

  saveProjectStory(){
    this.storyDataService.saveStory(this.story)
    .subscribe(
      response => {
        console.log("Response Recieved")
        this.navLink()
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
      
    )
 }

 updateProjctById(){
  this.storyDataService.updateStory(this.storyId, this.story)
  .subscribe(
    response => {
      console.log(`updated story with Id ${this.storyId}`)
      this.navLink()
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
