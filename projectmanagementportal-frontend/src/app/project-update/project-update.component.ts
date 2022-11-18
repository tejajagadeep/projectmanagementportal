import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { AuthGuardDataService } from '../service/auth/auth-guard-data.service';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';

@Component({
  selector: 'app-project-update',
  templateUrl: './project-update.component.html',
  styleUrls: ['./project-update.component.css']
})
export class ProjectUpdateComponent implements OnInit {

  project!: Project
  errorMessageResponse!: string
  userNameError!: string
  username!: string
  temp!: string
  projectId!: string
  dateDummy!: Date
  assign!: string

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private projectDataService: ProjectDataService,
    private authService: AuthenticationDataService,
    private location: Location
  ) { }

  ngOnInit(): void {
    console.log('project-update.component.ts')
    this.projectId = this.route.snapshot.params['projectId'];
    this.getProjectBId(this.projectId);
    this.username = this.authService.getLoggedInUserName();
  }

  navBack() {
    this.location.back()
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

  updateProjectById() {
    this.projectDataService.updateProjectById(this.projectId, this.project).subscribe(
      response => {
        console.log(`updated project ${this.projectId}`)
        this.router.navigate(['view-project-status', response.projectId]);
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
    )
  }

  handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
    this.errorMessageResponse = error.error.message
  }

}
