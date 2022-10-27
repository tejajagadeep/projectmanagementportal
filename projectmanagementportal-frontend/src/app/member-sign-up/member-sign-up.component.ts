import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDataServiceService } from '../service/data/user-data-service.service';

export class User{
  constructor(
    
    public userId: string,
    public name: string,
    public emailAddress: string,
    public contactNo: number,
    public dOB: Date,
    public userType: string,
    public password: string,

  ){}
}

@Component({
  selector: 'app-member-sign-up',
  templateUrl: './member-sign-up.component.html',
  styleUrls: ['./member-sign-up.component.css']
})
export class MemberSignUpComponent implements OnInit {

  user! : User
  userId! : number
  errorMessageResponse!: string

  constructor(private userDataService: UserDataServiceService,
      private route : ActivatedRoute,
      private router: Router
    ) { }

  ngOnInit(): void {
    this.user = new User('','','',0,new Date(),'','');
    // this.userId = this.route.snapshot.params['userId'];


  }

  navLogin(){
    this.router.navigate(['login'])    
  }

 saveUser(){
    this.userDataService.saveUser(this.user)
    .subscribe(
      response => this.user = response,
      error => this.handleErrorMessage(error)
      
    )
 }

 handleErrorMessage(error: any){
  // this.errorMessageResponse = error
  this.errorMessageResponse = error.message
 }

 getByUserId(userId: number){
  this.userDataService.getUserById(userId)
  .subscribe(
    response => this.user = response
  )
 }
 

}
