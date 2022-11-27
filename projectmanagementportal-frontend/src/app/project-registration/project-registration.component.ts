import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-project-registration',
  templateUrl: './project-registration.component.html',
  styleUrls: ['./project-registration.component.css']
})
export class ProjectRegistrationComponent implements OnInit {

  project!: Project
  errorMessageResponse!: string
  projectId!: string
  username!: string
  projectAssigned!: string[]
  dateDummy!: Date

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
    this.project = new Project('', '', '', '', '', '', '', '', '', this.dateDummy, this.dateDummy, '', 'To-Do', '', '', this.projectAssigned,[])
    this.username = this.authService.getLoggedInUserName();
    this.getUser(this.username)
    console.log('projects-reistration.component.ts')
  }

  getUser(userName: string) {
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
        // this.getAllProjectsMN(response.name)
        // this.getAllProjectsTL(response.name)
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }

  navBack() {
    this.location.back();
  }
  navLink() {
    this.router.navigate(['view-project-status', this.projectId]);
  }

  saveProject() {
    this.projectDataService.saveProject(this.project)
      .subscribe(
        response => {
          this.project = response,
            this.projectDataService.ProjectAssign(this.username, this.project.projectId, this.project).subscribe(
              response => console.log("usename: " + this.username + "assigned : " + this.project.projectId)
            )
          console.log("Response Recieved")
          this.router.navigate(['view-project-status/', response.projectId]);
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
