import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { User } from '../model/user';
import { AuthGuardDataService } from '../service/auth/auth-guard-data.service';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { UserDataService } from '../service/data/user-data.service';

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

  user!: User

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private projectDataService: ProjectDataService,
    private userService: UserDataService,
    private authService: AuthenticationDataService,
    private location: Location
  ) { }

  ngOnInit(): void {
    console.log('project-update.component.ts')
    this.projectId = this.route.snapshot.params['projectId'];
    this.getProjectBId(this.projectId);
    this.username = this.authService.getLoggedInUserName();
    this.getUser(this.username)
  }

  OnlyAlbhabets(event: any):boolean{

    const charCode = (event.which)?event.which: event.keyCode;

    if (charCode == 32 || ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))) {
       return true
    }


    return false;
  }
  
  getUser(userName: string) {
    console.log()
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
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
