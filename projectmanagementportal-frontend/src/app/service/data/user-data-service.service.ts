import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { USER_API_URL } from 'src/app/app.constants';
import { User } from 'src/app/member-sign-up/member-sign-up.component';
import { Observable } from 'rxjs';

export class helloWorldBean{
  constructor(
    public message: String,
    public id: number,
  ){}
}

export class userException{
  constructor(
    public userId: string,
    public name: string,
    public emailAddress: string,
    public contactNo: number,
    public dOB: Date,
    public userType: string,
    public password: string,

  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class UserDataServiceService {

  constructor(private http: HttpClient) { }

  public loginUser(user: User): Observable<any>{
    return this.http.post<any>(`${USER_API_URL}/login`,user);
  }

  public saveUser(user: User): Observable<any>{
    return this.http.post<any>(`${USER_API_URL}/userSignUp`,user);
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

  getUserById(userId: number){
    return this.http.get<User>(`${USER_API_URL}/getUserById/${userId}`);
  }

}
