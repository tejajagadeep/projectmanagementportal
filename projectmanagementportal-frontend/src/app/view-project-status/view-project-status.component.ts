import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../project-registration-or-updation/project-registration-or-updation.component';
import { Story } from '../project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { ProjectDataServiceService } from '../service/data/project-data-service.service';
import { StoryDataServiceService } from '../service/data/story-data-service.service';

@Component({
  selector: 'app-view-project-status',
  templateUrl: './view-project-status.component.html',
  styleUrls: ['./view-project-status.component.css']
})
export class ViewProjectStatusComponent implements OnInit {

  story!: Story[]
  project!:Project[]
  projectId!: string
  storyId!: string
  message!: string

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private projectService: ProjectDataServiceService,
    private storyService: StoryDataServiceService
  ) { }

  ngOnInit(): void {
    this.projectId = this.route.snapshot.params['projectId'];
    this.storyId = this.route.snapshot.params['storyId'];
    this.getAllProjects();
    this.getAllStories();
  }

  getAllProjects(){
    this.projectService.getAllProjects().subscribe(
      response => this.handleGetProjects(response)
    );
   }

   handleGetProjects(response : any){
    this.project = response
   }

   getAllStories(){
    this.storyService.getAllStories().subscribe(
      response => this.handleGetStories(response)
    );
   }

   handleGetStories(response : any){
    this.story = response
    console.log(response)
  }

  updateProject(projectId: string){
    console.log(`update ${projectId}`);
    this.router.navigate([`view-project-status/${projectId}`])
    // this.router.navigate([`view-project-status/${projectId}`])
  }

  deleteProject(projectId: string){
    this.projectService.deleteProjectById(projectId).subscribe(
      response =>  {
        this.message = `Deleted Project with Id ${projectId}`;
        console.log(this.message)
      }
    )
  }

  updateStory(storyId: string){
    console.log(`update ${storyId}`);
    this.router.navigate(['view-project-status',storyId])
    // this.router.navigate([`view-project-status/${storyId}`])
  }

  deleteStory(storyId: string){
    this.storyService.deleteStoryById(storyId).subscribe(
      response =>  {
        this.message = `Deleted Story with Id ${storyId}`;
        console.log(this.message)
      }
    )
  }

}
