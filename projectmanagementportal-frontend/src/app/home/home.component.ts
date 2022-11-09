import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../member-sign-up/member-sign-up.component';
import { Project } from '../project-registration-or-updation/project-registration-or-updation.component';
import { Story } from '../project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { MessageResponse, UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse=""
  name=''
  user!:User[]
  story!: Story[]
  project!:Project[]
  helloWorldMessage!: MessageResponse

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['userName'];
    this.getAllUsers();
    console.log(this.username)
    // this.helloWorld();
  }

  getAllUsers(){
    this.userService.getAllUsers(this.username).subscribe(
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

  //  helloWorld(){
  //   this.userService.helloWorldDataService().subscribe(
  //     response => {console.log(this.helloWorldMessage.message),
  //     this.helloWorldMessage = response,
  //     this.message = this.helloWorldMessage.message}
  //   )
  //  }

   
}
