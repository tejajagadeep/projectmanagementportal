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
  dateDummy!: Date
  errorMessageResponse!: string

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private storyDataService: StoryDataServiceService
  ) { }

  ngOnInit(): void {

    // this.story = new Story('','','','','','',this.dateDummy,this.dateDummy,'','');

  }

  navLogin(){
    this.router.navigate(['login']) ;
  }

  saveProject(){
    this.storyDataService.saveStory(this.story)
    .subscribe(
      response => this.story = response,
      error => this.handleErrorMessage(error)
      
    )
    // this.navLogin();
 }

 handleErrorMessage(error: any){
  // this.errorMessageResponse = error
  this.errorMessageResponse = error.message
 }

}
