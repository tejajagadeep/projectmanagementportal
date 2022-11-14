import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../model/project';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { ProjectDataService } from '../service/data/project-data.service';

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

  constructor(
    
    private router: Router,
    private route: ActivatedRoute,
    private projectDataService: ProjectDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.project = new Project('', '', '', '', '', '', '', '', '', new Date(), new Date(), '', 'To-Do', '')
    this.username = this.authService.getLoggedInUserName();
  }

  navLink() {
    this.router.navigate(['view-project-status',this.projectId]);
  }

  saveProject() {
    this.projectDataService.saveProject(this.project)
      .subscribe(
        response => {
          this.project = response,
          this.projectDataService.ProjectAssign(this.username, this.project.projectId, this.project).subscribe(
            response => console.log("usename: "+ this.username + "assigned : "+ this.project.projectId)
          )
          console.log("Response Recieved")
          this.router.navigate(['view-project-status/',response.projectId]);
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
