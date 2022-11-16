import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { UserDataService } from '../service/data/user-data.service';

@Injectable({
  providedIn: 'root'
})
export class GetUserDetialsMethodsService {

  user!: User

  errorMessage!: string

  constructor(
    private userService: UserDataService
  ) { }

  getUser(userName: string) {
    console.log()
    this.userService.getUserByUserName(userName).subscribe(
      response => {
        console.log("response")
        this.user = response;
      },
      error => {
        console.log("error")
        this.handleErrorMessage(error);
        console.log(error.error.message)

      }
    )
  }
  
  handleErrorMessage(error: any){
    this.errorMessage = error.error.message;
  }

}
