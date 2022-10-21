import { Component, OnInit } from '@angular/core';

export class User{
  constructor(
    
    public userId: String,
    public Name: String,
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

  constructor() { }

  ngOnInit(): void {
  }

 saveUser(){

 }

}
