import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectDataServiceService } from '../service/data/project-data-service.service';

export class Project{
  constructor(
    public projectId: string,
    public projectName: string,
    public projectDescription: string,
    public teamName: string,
    public teamSize: string,
    public projectManagerName: string,
    public projectManagerEmailId: string,
    public techLeadName: string,
    public techLeadEmailId: string,
    public projectStartDate: Date,
    public projectEndDate: Date,
    public techStack: string,
    public status: string,
    public remarks: string,

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
