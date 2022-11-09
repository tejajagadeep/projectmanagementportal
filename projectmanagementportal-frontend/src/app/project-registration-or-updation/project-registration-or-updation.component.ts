import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProjectDataService } from '../service/data/project-data.service';

export class Project {
  // projectId!: string;
  // projectName!: string;
  // projectDescription!: string;
  // teamName!: string;
  // teamSize!: string;
  // projectManagerName!: string;
  // projectManagerEmailId!: string;
  // techLeadName!: string;
  // techLeadEmailId!: string;
  // projectStartDate!: Date;
  // projectEndDate!: Date;
  // techStack!: string;
  // status!: string;
  // remarks!: string;
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
    public remarks: string

  ) { }
}

@Component({
  selector: 'app-project-registration-or-updation',
  templateUrl: './project-registration-or-updation.component.html',
  styleUrls: ['./project-registration-or-updation.component.css']
})
export class ProjectRegistrationOrUpdationComponent implements OnInit {

  project!: Project
  errorMessageResponse!: string
  temp!: string
  projectId!: string
  dateDummy!: Date

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private projectDataService: ProjectDataService
  ) { }

  ngOnInit(): void {
    this.projectId = this.route.snapshot.params['projectId'];
    this.getProjectBId(this.projectId);

    this.project = new Project('', '', '', '', '', '', '', '', '', new Date(), new Date(), '', 'To-Do', '')
  }

  navLink() {
    this.router.navigate(['view-project-status']);
  }

  getProjectBId(projectId: string) {
    this.projectDataService.getProjectById(projectId).subscribe(
      response => {
        console.log("response")
        this.project = response;
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  saveUpdateProject() {
    if (this.projectId === this.project.projectId) {
      this.updateProjectById()
    } else {
      this.saveProject
    }
  }

  saveProject() {
    this.projectDataService.saveProject(this.project)
      .subscribe(
        response => {
          console.log("Response Recieved")
          this.navLink()
        },
        error => {
          console.log("Exception Occured")
          this.handleErrorMessage(error);
        }

      )
  }

  updateProjectById() {
    this.projectDataService.updateProjectById(this.projectId, this.project).subscribe(
      response => {
        console.log(`updated project ${this.projectId}`)
        this.navLink()
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
    )
  }

  handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
    if (this.projectId===undefined){
      this.errorMessageResponse = this.temp
    } else {
      this.errorMessageResponse = error.error.message
    }
  }

}
