import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {


  username!: string
  isUserLoggedIn!: boolean

  constructor(
    private router : Router, 
    private route: ActivatedRoute, 
    private userService: UserDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.username = this.route.snapshot.params['userName'];
    console.log(this.username)
    console.log('home.component.ts')
    this.isUserLoggedIn = this.authService.isUserLoggedIn();
  }

  getUsername(){
    this.username=this.authService.getLoggedInUserName();
  }

}
