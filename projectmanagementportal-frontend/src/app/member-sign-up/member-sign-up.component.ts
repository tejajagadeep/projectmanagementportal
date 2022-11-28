import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { UserDataService } from '../service/data/user-data.service';



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

  registerForm!: FormGroup

   userNameT!: boolean
     nameT!: boolean
     emailAddressT!: boolean
     contactNoT!: boolean
     dateOfBirthT!: boolean
     passwordT!: boolean

  constructor(private userDataService: UserDataService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  OnlyAlbhabets(event: any):boolean{

    const charCode = (event.which)?event.which: event.keyCode;

    if(charCode > 31 && (charCode < 48 || charCode > 57) || charCode == ' ') {
       return true
    }


    return false;
  }


  ngOnInit(): void {
    // this.user = new User('','','',this.dummyNumber,this.dummyDate,'','');
    
    this.user = new User('', '', '', this.dummyNumber, this.dummyDate, 'Admin', '',[]);
    // this.user = new User('','','',this.dummyNumber,'','','');
    // this.user = new User();
    // this.userId = this.route.snapshot.params['userId'];

    console.log('memeber-sign-up.compenent.ts')

  }

  // controllerPare(dateString: string): Date {
  //   if (dateString) {
  //     return new Date(dateString);
  //   } else {
  //   return null
  // }
  // }

  navLink() {
    this.router.navigate(["home"]);
  }

  navLogin() {
    this.router.navigate(["login"]);
  }

  registerUser() {
    if(this.user.userName===''){
      this.userNameT=true
    }
    if(this.user.name===''){
      this.nameT=true
    }
    if(this.user.emailAddress===''){
      this.emailAddressT=true
    }
    if(this.user.contactNo===this.dummyNumber){
      this.contactNoT=true
    }
    if(this.user.dateOfBirth===this.dummyDate){
      this.dateOfBirthT=true
    }
    if(this.user.password===''){
      this.passwordT=true
    }
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
