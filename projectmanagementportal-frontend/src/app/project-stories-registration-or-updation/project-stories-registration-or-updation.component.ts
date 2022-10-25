import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StoryDataServiceService } from '../service/data/story-data-service.service';

export class Story{
  constructor(
    public storyId: String,
    public projectId: String,
    public storyTitle: String,
    public storyDescription: String,
    public assignee: String,
    public assigneeEmailId: String,
    public assignmentDate: Date,
    public targetDate: Date,
    public status: String,
    public remarks: String,

  ) {}
}

@Component({
  selector: 'app-project-stories-registration-or-updation',
  templateUrl: './project-stories-registration-or-updation.component.html',
  styleUrls: ['./project-stories-registration-or-updation.component.css']
})
export class ProjectStoriesRegistrationOrUpdationComponent implements OnInit {

  story!: Story[]

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private storyService: StoryDataServiceService
  ) { }

  ngOnInit(): void {
    this.getAllStories();

  }

  getAllStories(){
    this.storyService.getAllStories().subscribe(
      response => this.handleGetStories(response)
    );
   }

   handleGetStories(response : any){
    this.story = response
   }

}
