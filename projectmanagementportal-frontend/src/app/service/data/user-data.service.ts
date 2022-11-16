import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { USER_API_URL } from 'src/app/app.constants';
import { User } from 'src/app/model/user';

export class MessageResponse{
  constructor(
    public message: string,
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  constructor(private http: HttpClient) { }

  createBasicAuthenticationHttpHeader(username: string, password: string){
    // let username = 'in28minutes'
    // let password = 'password'
    const basicAuthHeaderString = new HttpHeaders({Authorization: 'Basic '+window.btoa(username+":"+password)});
    return basicAuthHeaderString
  }

  public login(username: string, password : string,user:User){
    return this.http.post<User>(`${USER_API_URL}/login/${username}/${password}`,user);
  }

  // public login(username: string, password : string){
  //   this.http.get<any>(`${USER_API_URL}/login/${username}/${password}`);
  // }

  public loginUser(user: User): Observable<any>{
    return this.http.post<any>(`${USER_API_URL}/userlogin`,user);
  }

  public saveUser(user: User): Observable<any>{
    return this.http.post<any>(`${USER_API_URL}/userSignUp`,user);
  }

  helloWorldDataService(): Observable<any>{
    // console.log("Hello World Front-End Data Service");
    return this.http.get<MessageResponse>(`${USER_API_URL}/helloWorld`);
  }

  helloWorldPathVariableDataService(username: String): Observable<any>{
    return this.http.get<MessageResponse>(`${USER_API_URL}/helloWorld/${username}`);
  }
  
  getAllUsers(name: string): Observable<any>{
    // let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();
    // let headers = new HttpHeaders({
    //   Authorization: basicAuthHeaderString
    // })
    return this.http.get<User[]>(`${USER_API_URL}/getAllUsers/${name}`);
  }

  getUserById(userId: string): Observable<any>{
    return this.http.get<User>(`${USER_API_URL}/getUserById/${userId}`);
  }

  getUserByUserName(username: string){
    return this.http.get<User>(`${USER_API_URL}/getUserByUserName/${username}`);
  }

  getUserByName(name: string){
    return this.http.get<User>(`${USER_API_URL}/getUserByName/${name}`);
  }

}
