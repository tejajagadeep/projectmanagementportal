import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StoryDataServiceService } from '../service/data/story-data-service.service';

export class Story{
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

  

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private storyService: StoryDataServiceService
  ) { }

  ngOnInit(): void {

  }

  

}
