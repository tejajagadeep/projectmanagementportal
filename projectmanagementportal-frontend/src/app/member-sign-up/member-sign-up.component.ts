import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDataServiceService } from '../service/data/user-data-service.service';

export class User {

  // userId!: string;
  //   name!: string;
  //   emailAddress!: string;
  //   contactNo!: number;
  //   dateOfBirth!: string;
  //   userType!: string;
  //   password!: string;
  constructor(

    // public userId: string,
    public userName: string,
    public name: string,
    public emailAddress: string,
    public contactNo: number,
    public dateOfBirth: Date,
    public role: string,
    public password: string

  ) { }
}

@Component({
  selector: 'app-member-sign-up',
  templateUrl: './member-sign-up.component.html',
  styleUrls: ['./member-sign-up.component.css']
})
export class MemberSignUpComponent implements OnInit {

  // user = new User()
  user!: User
  userId!: number
  errorMessageResponse!: string
  dummyNumber!: number
  dummyDate!: Date

  constructor(private userDataService: UserDataServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    // this.user = new User('','','',this.dummyNumber,this.dummyDate,'','');
    this.user = new User('', '', '', this.dummyNumber, new Date(), 'Admin', '');
    // this.user = new User('','','',this.dummyNumber,'','','');
    // this.user = new User();
    // this.userId = this.route.snapshot.params['userId'];


  }

  navLink(){
    this.router.navigate(["home"]);
  }

  navLogin(){
    this.router.navigate(["login"]);
  }

  registerUser() {
    this.userDataService.saveUser(this.user)
      .subscribe(
        response => {
          console.log("Response Recieved")
          this.router.navigate(["login"]);
        },
        error => {
          console.log("Exception Occured")
          this.handleErrorMessage(error);
        }
      )
  }

  saveUser() {
    this.userDataService.saveUser(this.user)
      .subscribe(
        response => {
          this.user = response
          this.navLink()
        },
        error => {
          this.handleErrorMessage(error)
        } 
        
      )
  }

  getByUserId(userId: string) {
    this.userDataService.getUserById(userId)
      .subscribe(
        response => this.user = response
      )
  }

  handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
    this.errorMessageResponse = error.error.message
  }

}
