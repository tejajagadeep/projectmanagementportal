import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorComponent } from '../error/error.component';
import { Project } from '../model/project';
import { Story } from '../model/story';
import { User } from '../model/user';
import { MessageResponse, UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

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
    console.log('home.component.ts')
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
    console.log('getAllUsers')

   }

   handleGetUsers(response : any){
    this.user = response
    console.log('handle getUsers')

   }

  //  helloWorld(){
  //   this.userService.helloWorldDataService().subscribe(
  //     response => {console.log(this.helloWorldMessage.message),
  //     this.helloWorldMessage = response,
  //     this.message = this.helloWorldMessage.message}
  //   )
  //  }

   

  //  helloWorld(){
  //   this.userService.helloWorldDataService().subscribe(
  //     response => {console.log(this.helloWorldMessage.message),
  //     this.helloWorldMessage = response,
  //     this.message = this.helloWorldMessage.message}
  //   )
  //  }

}
