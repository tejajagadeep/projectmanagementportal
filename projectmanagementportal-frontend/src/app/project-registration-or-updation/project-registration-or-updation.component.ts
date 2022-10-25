import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectDataServiceService } from '../service/data/project-data-service.service';

export class Project{
  constructor(
    public projectId: String,
    public projectName: String,
    public projectDescription: String,
    public teamName: String,
    public teamSize: String,
    public projectManagerName: String,
    public projectManagerEmailId: String,
    public techLeadName: String,
    public techLeadEmailId: String,
    public projectStartDate: Date,
    public projectEndDate: Date,
    public techStack: String,
    public status: String,
    public remarks: String,

  ) {}
}

@Component({
  selector: 'app-project-registration-or-updation',
  templateUrl: './project-registration-or-updation.component.html',
  styleUrls: ['./project-registration-or-updation.component.css']
})
export class ProjectRegistrationOrUpdationComponent implements OnInit {

  project!:Project[]

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private projectService: ProjectDataServiceService,
  ) { }

  ngOnInit(): void {
    this.getAllProjects();
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
