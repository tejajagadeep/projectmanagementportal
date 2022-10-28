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

  project!: Project
  errorMessageResponse!: string
  projectId!: string

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private projectDataService: ProjectDataServiceService,
  ) { }

  ngOnInit(): void {
    // this.projectId = this.route.snapshot.params['userId'];
    this.project = new Project('','','','','','','','','', new Date(), new Date(), '', '', '')
  }

  navLogin(){
    this.router.navigate(['login']) ;
  }

  saveProject(){
    this.projectDataService.saveProject(this.project)
    .subscribe(
      response => this.project = response,
      error => this.handleErrorMessage(error)
      
    )
    // this.navLogin();
 }

 handleErrorMessage(error: any){
  // this.errorMessageResponse = error
  this.errorMessageResponse = error.message
 }

}
