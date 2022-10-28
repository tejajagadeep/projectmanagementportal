import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../member-sign-up/member-sign-up.component';
import { Project } from '../project-registration-or-updation/project-registration-or-updation.component';
import { Story } from '../project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { ProjectDataServiceService } from '../service/data/project-data-service.service';
import { StoryDataServiceService } from '../service/data/story-data-service.service';
import { UserDataServiceService } from '../service/data/user-data-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  message = ''
  errorMessageResponse=""
  name=''
  user!:User[]
  story!: Story[]
  project!:Project[]

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private userService: UserDataServiceService,
    private projectService: ProjectDataServiceService,
    private storyService: StoryDataServiceService
  ) { }

  ngOnInit(): void {
    this.getAllUsers();
    this.getAllProjects();
    this.getAllStories();

  }

  getAllUsers(){
    this.userService.getAllUsers().subscribe(
      response => this.handleGetUsers(response)
      // {
      //   // console.log(response);
      //   this.user = response;
      //   // console.log(this.user)
      // }
    );
   }

   handleGetUsers(response : any){
    this.user = response
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
}
