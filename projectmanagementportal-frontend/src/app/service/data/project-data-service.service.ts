import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PROJECT_API_URL } from 'src/app/app.constants';
import { Project } from 'src/app/project-registration-or-updation/project-registration-or-updation.component';

@Injectable({
  providedIn: 'root'
})
export class ProjectDataServiceService {

  constructor(private http: HttpClient) { }

  getAllProjects(): Observable<any>{
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getAllProjects`)
  }

  getProjectsByProjectManagerEmailId(projectManagerEmailId: string): Observable<any>{
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectManagerEmailId/${projectManagerEmailId}`);
  }

  getProjectsByProjectName(projectName: string): Observable<any>{
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectName/${projectName}`);
  }

  getProjectsByProjectManagerName(projectManagerName: string): Observable<any>{
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectManagerName/${projectManagerName}`);
  }

  getProjectsByStatus(status: string): Observable<any>{
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByStatus/${status}`);
  }

  getProjectById(projectId: string): Observable<any>{
    return this.http.get<Project>(`${PROJECT_API_URL}/getProjectById/${projectId}`);
  }

  saveProject(project: Project): Observable<any>{
    return this.http.post<Project>(`${PROJECT_API_URL}/projectRegiration`,project);
  }

  updateProjectById(projectId: string, project: Project): Observable<any>{
    return this.http.put<Project>(`${PROJECT_API_URL}/updateProjectById/${projectId}`,project);
  }

  deleteProjectById(projectId: string): Observable<any>{
    return this.http.delete<Project>(`${PROJECT_API_URL}/deleteProjectById/${projectId}`);
  }

}
