import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDataServiceService } from '../service/data/user-data-service.service';

export class User{
  constructor(
    
    public userId: String,
    public name: String,
    public emailAddress: String,
    public contactNo: number,
    public dOB: Date,
    public userType: String,
    public password: String,

  ){}
}

@Component({
  selector: 'app-member-sign-up',
  templateUrl: './member-sign-up.component.html',
  styleUrls: ['./member-sign-up.component.css']
})
export class MemberSignUpComponent implements OnInit {

  user! : User

  constructor(private userDataService: UserDataServiceService,
      private route : ActivatedRoute,
      private router: Router
    ) { }

  ngOnInit(): void {
  }

  navLogin(){
    this.router.navigate(['login'])
  }

 saveUser(){
    this.userDataService.saveUserDetailsDataService(this.user)
    .subscribe(
      userData => {
        console.log(userData)
        this.router.navigate(['login']);
      }
    )
 }

 

}
