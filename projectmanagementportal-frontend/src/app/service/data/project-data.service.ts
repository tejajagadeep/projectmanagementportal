import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PROJECT_API_URL } from 'src/app/app.constants';
import { Project } from 'src/app/model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectDataService {

  constructor(private http: HttpClient) { }

  getAllProjects(){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getAllProjects`)
  }

  getProjectsByProjectManagerEmailId(projectManagerEmailId: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectManagerEmailId/${projectManagerEmailId}`);
  }

  getProjectsByProjectName(projectName: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectName/${projectName}`);
  }

  getProjectsByProjectManagerName(projectManagerName: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectManagerName/${projectManagerName}`);
  }

  getProjectsByStatus(status: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByStatus/${status}`);
  }

  getProjectById(projectId: string){
    return this.http.get<Project>(`${PROJECT_API_URL}/getProjectById/${projectId}`);
  }

  saveProject(project: Project){
    return this.http.post<Project>(`${PROJECT_API_URL}/projectRegistration`,project);
  }

  updateProjectById(projectId: string, project: Project){
    return this.http.put<Project>(`${PROJECT_API_URL}/updateProjectById/${projectId}`,project);
  }

  deleteProjectById(projectId: string){
    return this.http.delete<Project>(`${PROJECT_API_URL}/deleteProjectById/${projectId}`);
  }

  ProjectAssign(username: string, projectId:string, project: Project){
    return this.http.put<Project>(`${PROJECT_API_URL}/project/updateProjectAssign/${username}/story/${projectId}`,Project);
  }
}
