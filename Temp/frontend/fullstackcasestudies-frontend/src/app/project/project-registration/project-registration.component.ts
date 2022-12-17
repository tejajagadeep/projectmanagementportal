import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from 'src/app/model/project';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { ProjectDataService } from 'src/app/service/data/project-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

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

  emails!: string[]

  user!: User
  users!: User[]
  emailIds!: string[]
  names!: string[]

  projectIdT!: boolean
  projectNameT!: boolean
  projectDescriptionT!: boolean
  teamNameT!: boolean
  teamSizeT!: boolean
  projectManagerNameT!: boolean
  projectManagerEmailIdT!: boolean
  techLeadNameT!: boolean
  techLeadEmailIdT!: boolean
  projectStartDateT!: boolean
  projectEndDateT!: boolean
  techStackT!: boolean
  statusT!: boolean
  remarksT!: boolean

  constructor(

    private router: Router,
    private route: ActivatedRoute,
    private projectDataService: ProjectDataService,
    private userService: UserDataService,
    private authService: AuthenticationDataService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.project = new Project('', '', '', '', '', '', '', '', '', this.dateDummy, this.dateDummy, '', '', '', '', this.projectAssigned, [])
    this.username = this.authService.getLoggedInUserName();
    this.getUser(this.username)
    this.getUserEmailId()
    this.getUsernames()
    console.log('projects-reistration.component.ts')
    this.users.forEach(element => {
      this.emails.forEach(element1 => {
        element1 = element.emailAddress
      });
    });
    console.log(this.emails)
  }

  getAllemail(){
    this.userService.getUserEmailId().subscribe(
      response => this.emails = response
    )
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

  nameAuto(event: any): string{

    return 's';
    
  }

  OnlyAlbhabets(event: any): boolean {

    const charCode = (event.which) ? event.which : event.keyCode;

    if (charCode == 32 || ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))) {
      return true
    }


    return false;
  }

  getUserEmailId() {
    this.userService.getUserEmailId().subscribe(
      response => {
        this.emailIds = response;
      }
    )
  }

  getUsernames() {
    this.userService.getNames().subscribe(
      response => {
        this.names = response;
      }
    )
  }
  saveProject() {
    if (this.project.projectId === '') {
      this.projectIdT = true
    }

    if (this.project.projectName === '') {
      this.projectNameT = true
    }
    if (this.project.projectDescription === '') {
      this.projectDescriptionT = true
    }
    if (this.project.teamName === '') {
      this.teamNameT = true
    }
    if (this.project.teamSize === '') {
      this.teamSizeT = true
    }
    if (this.project.projectManagerName === '') {
      this.projectManagerNameT = true
    }
    if (this.project.projectManagerEmailId === '') {
      this.projectManagerEmailIdT = true
    }
    if (this.project.techLeadName === '') {
      this.techLeadNameT = true
    }
    if (this.project.techLeadEmailId === '') {
      this.techLeadEmailIdT = true
    }
    if (this.project.projectStartDate === this.dateDummy) {
      this.projectStartDateT = true
    }
    if (this.project.projectEndDate === this.dateDummy) {
      this.projectEndDateT = true
    }
    if (this.project.techStack === '') {
      this.techStackT = true
    }
    if (this.project.remarks === '') {
      this.remarksT = true
    }

    if (this.project.status === '') {
      this.statusT = true
    }
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

  getAllUsers() {
    this.userService.getAllUsers().subscribe(
      response => this.users
      // {
      //   // console.log(response);
      //   this.user = response;
      //   // console.log(this.user)
      // }
    );
    console.log('getAllUsers')

  }
}
