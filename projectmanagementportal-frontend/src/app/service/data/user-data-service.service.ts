import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { USER_API_URL } from 'src/app/app.constants';
import { User } from 'src/app/member-sign-up/member-sign-up.component';

export class helloWorldBean{
  constructor(
    public message: String,
    public id: number
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class UserDataServiceService {

  constructor(private http: HttpClient) { }

  saveUser(user: User){
    return this.http.post<User>(`${USER_API_URL}/userSignUp`,user);
  }

  helloWorldDataService(){
    // console.log("Hello World Front-End Data Service");
    return this.http.get<helloWorldBean>(`${USER_API_URL}/helloWorld`);
  }

  helloWorldPathVariableDataService(username: String){
    return this.http.get<helloWorldBean>(`${USER_API_URL}/helloWorld/${username}`);
  }

  getAllUsers(){
    return this.http.get<User[]>(`${USER_API_URL}/getAllUsers`);
    
  }

}
