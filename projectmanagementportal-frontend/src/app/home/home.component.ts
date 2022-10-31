import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../member-sign-up/member-sign-up.component';
import { Project } from '../project-registration-or-updation/project-registration-or-updation.component';
import { Story } from '../project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { UserDataServiceService } from '../service/data/user-data-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  message = ''
  errorMessageResponse=""
  name=''
  user!:User[]
  story!: Story[]
  project!:Project[]

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private userService: UserDataServiceService
  ) { }

  ngOnInit(): void {
    this.getAllUsers();
    

  }

  getAllUsers(){
    this.userService.getAllUsers().subscribe(
      response => this.handleGetUsers(response)
      // {
      //   // console.log(response);
      //   this.user = response;
      //   // console.log(this.user)
      // }
    );
   }

   handleGetUsers(response : any){
    this.user = response
   }

   
}
