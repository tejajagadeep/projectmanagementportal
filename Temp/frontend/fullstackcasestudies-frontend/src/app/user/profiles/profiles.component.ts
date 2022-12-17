import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse } from 'src/app/model/message-response';
import { Project } from 'src/app/model/project';
import { Story } from 'src/app/model/story';
import { User } from 'src/app/model/user';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

  username!: string
  message!: string
  errorMessageResponse = ""
  name = ''
  user!: User[]
  story!: Story[]
  project!: Project[]
  helloWorldMessage!: MessageResponse

  searchText!: string

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['userName'];
    this.getAllUsers();
    console.log(this.username)
    console.log('profiles.component.ts')
    // this.helloWorld();
  }

  getAllUsers() {
    this.userService.getAllUsers().subscribe(
      response => this.handleGetUsers(response)
      // {
      //   // console.log(response);
      //   this.user = response;
      //   // console.log(this.user)
      // }
    );
    console.log('getAllUsers')

  }

  handleGetUsers(response: any) {
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
