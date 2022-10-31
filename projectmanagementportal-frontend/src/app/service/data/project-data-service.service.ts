import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PROJECT_API_URL } from 'src/app/app.constants';
import { Project } from 'src/app/project-registration-or-updation/project-registration-or-updation.component';

@Injectable({
  providedIn: 'root'
})
export class ProjectDataServiceService {

  constructor(private http: HttpClient) { }

  getAllProjects(){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getAllProjects`)
  }

  getProjectsByProjectManagerEmailId(projectManagerEmailId: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getUserById/${projectManagerEmailId}`);
  }

  getProjectsByProjectName(projectName: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getUserById/${projectName}`);
  }

  getProjectsByProjectManagerName(projectManagerName: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getUserById/${projectManagerName}`);
  }

  getProjectsByStatus(status: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getUserById/${status}`);
  }

  getProjectById(projectId: string){
    return this.http.get<Project>(`${PROJECT_API_URL}/getUserById/${projectId}`);
  }

  saveProject(project: Project){
    return this.http.post<Project>(`${PROJECT_API_URL}/projectRegiration`,project);
  }

}
