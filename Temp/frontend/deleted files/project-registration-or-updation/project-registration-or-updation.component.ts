import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { ProjectDataService } from '../service/data/project-data.service';

@Component({
  selector: 'app-project-registration-or-updation',
  templateUrl: './project-registration-or-updation.component.html',
  styleUrls: ['./project-registration-or-updation.component.css']
})
export class ProjectRegistrationOrUpdationComponent implements OnInit {

  project!: Project
  errorMessageResponse!: string
  userNameError!: string
  temp!: string
  projectId!: string
  dateDummy!: Date
  assign!:string

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
      this.saveProject()
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

  assignProject(username: string, projectId: string){
    this.projectDataService.ProjectAssign(username,this.projectId, this.project).subscribe(
      resposne => {
        console.log(resposne)
      },
      error => {this.userNameError = error.error.message}
      
      
      
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
