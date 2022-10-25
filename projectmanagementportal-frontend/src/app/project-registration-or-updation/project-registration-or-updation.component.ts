import { Component, OnInit } from '@angular/core';

export class Project{
  constructor(
    public projectId: String,
    public projectName: String,
    public projectDescription: String,
    public TeamName: String,

  ) {}
}

@Component({
  selector: 'app-project-registration-or-updation',
  templateUrl: './project-registration-or-updation.component.html',
  styleUrls: ['./project-registration-or-updation.component.css']
})
export class ProjectRegistrationOrUpdationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  getAllProject(){

  }

}
