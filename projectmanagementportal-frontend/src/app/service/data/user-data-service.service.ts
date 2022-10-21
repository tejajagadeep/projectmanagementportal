import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { USER_API_URL } from 'src/app/app.constants';
import { User } from 'src/app/member-sign-up/member-sign-up.component';

@Injectable({
  providedIn: 'root'
})
export class UserDataServiceService {

  constructor(private http: HttpClient) { }

  saveUserDetailsDataService(user: User){
    return this.http.post<User>(`${USER_API_URL}/userSignUp`,user);
  }

}
