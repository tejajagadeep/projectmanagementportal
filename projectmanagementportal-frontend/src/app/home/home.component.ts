import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../project-registration-or-updation/project-registration-or-updation.component';
import { ProjectDataService } from '../service/data/project-data.service';
import { StoryDataService } from '../service/data/story-data.service';
import { MessageResponse, UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse=""
  helloWorldMessage!: MessageResponse
  project!:Project[]

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private projectService: ProjectDataService,
    private storyService: StoryDataService
  ) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['userName'];
    console.log(this.username)
    console.log('home.component.ts')
    this.getAllProjects();
    // this.helloWorld();
  }

  getAllProjects(){
    this.projectService.getAllProjects().subscribe(
      response => this.handleGetProjects(response)
    );
   }
   
   handleGetProjects(response : any){
    this.project = response
   }
}
