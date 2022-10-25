import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProjectDataServiceService {

  constructor(private http: HttpClient) { }

  getAllProjects(){
    // return this.http.get<>
  }

}
