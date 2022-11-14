import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../project-registration-or-updation/project-registration-or-updation.component';
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

  constructor(
    
    private router: Router,
    private route: ActivatedRoute,
    private projectDataService: ProjectDataService
  ) { }

  ngOnInit(): void {
    this.project = new Project('', '', '', '', '', '', '', '', '', new Date(), new Date(), '', 'To-Do', '')
  }

  navLink() {
    this.router.navigate(['view-project-status',this.projectId]);
  }

  saveProject() {
    this.projectDataService.saveProject(this.project)
      .subscribe(
        response => {
          this.projectId = response.projectId
          console.log("Response Recieved")
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
      this.errorMessageResponse = error.error.message
  }

}
