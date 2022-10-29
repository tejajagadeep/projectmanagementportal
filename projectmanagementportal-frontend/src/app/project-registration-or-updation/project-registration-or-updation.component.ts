import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectDataServiceService } from '../service/data/project-data-service.service';

export class Project{
  projectId!: string;
    projectName!: string;
    projectDescription!: string;
    teamName!: string;
    teamSize!: string;
    projectManagerName!: string;
    projectManagerEmailId!: string;
    techLeadName!: string;
    techLeadEmailId!: string;
    projectStartDate!: Date;
    projectEndDate!: Date;
    techStack!: string;
    status!: string;
    remarks!: string;
  constructor(
    

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
  dateDummy! : Date

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private projectDataService: ProjectDataServiceService,
  ) { }

  ngOnInit(): void {
    // this.projectId = this.route.snapshot.params['userId'];
    // this.project = new Project('','','','','','','','','', this.dateDummy, this.dateDummy, '', '', '')
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
