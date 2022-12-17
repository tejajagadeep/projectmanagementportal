import { HttpBackend, HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { USER_API_URL } from 'src/app/app.contants';
import { MessageResponse } from 'src/app/model/message-response';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  messageResponse!: MessageResponse

  private httpClient: HttpClient;
  constructor(
    private http: HttpClient,
    private handler: HttpBackend,
  ) {
    this.httpClient = new HttpClient(handler);
  }

  

  


  public saveUser(user: User): Observable<any> {
    return this.httpClient.post<any>(`${USER_API_URL}/userSignUp`, user);
  }



  getAllUsers(): Observable<any> {
   
    return this.http.get<User[]>(`${USER_API_URL}`);
  }

  getUserById(userId: string): Observable<any> {
    return this.http.get<User>(`${USER_API_URL}/getUserById/${userId}`);
  }

  getUserByUserName(username: string) {
    return this.http.get<User>(`${USER_API_URL}/userName/${username}`);
  }

  getUserByName(name: string) {
    return this.http.get<User>(`${USER_API_URL}/name/${name}`);
  }

  getUserEmailId() {
    return this.http.get<string[]>(`${USER_API_URL}/emails`);
  }

  getNames() {
    return this.http.get<string[]>(`${USER_API_URL}/names`);
  }


  getUserIds() {
    return this.http.get<string[]>(`${USER_API_URL}/userIds`);
  }
}
