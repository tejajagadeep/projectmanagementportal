import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Story } from '../model/story';
import { StoryDataService } from '../service/data/story-data.service';

@Component({
  selector: 'app-update-story-by-member',
  templateUrl: './update-story-by-member.component.html',
  styleUrls: ['./update-story-by-member.component.css']
})
export class UpdateStoryByMemberComponent implements OnInit {

  story! : Story
  storyId!: string
  dateDummy!: Date
  errorMessageResponse!: string
  storyAssigned!:  string[]
  temp!: string

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private storyDataService: StoryDataService
  ) { }

  ngOnInit(): void {
    this.storyId = this.route.snapshot.params['storyId'];
    this.getStoryById(this.storyId);
    this.story = new Story('','','','','',new Date(),new Date(),'To-Do','','','',this.storyAssigned);

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
  this.storyDataService.updateStoryMember(this.storyId, this.story)
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
