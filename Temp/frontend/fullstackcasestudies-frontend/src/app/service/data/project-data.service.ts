import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PROJECT_API_URL } from 'src/app/app.contants';
import { MessageResponse } from 'src/app/model/message-response';
import { Project } from 'src/app/model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectDataService {

  messageRespone!: MessageResponse


  constructor(private http: HttpClient,
  ) { }

  getAllProjects() {
    return this.http.get<Project[]>(`${PROJECT_API_URL}`)
  }

  getProjectsByProjectOwner(projectOwner: string) {
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectOwner/${projectOwner}`);
  }

  getProjectsByProjectManagerName(projectManagerName: string) {
    return this.http.get<Project[]>(`${PROJECT_API_URL}/projectManagerName/${projectManagerName}`);
  }

  getProjectByAssignedTo(getProjectByAssignedTo: string) {
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectByAssignedTo/${getProjectByAssignedTo}`);
  }

  getProjectsByTechLeadName(techLeadName: string) {
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByTechLeadName/${techLeadName}`);
  }
  getProjectsByStatus(status: string) {
    return this.http.get<Project[]>(`${PROJECT_API_URL}/status/${status}`);
  }

  getProjectById(projectId: string) {
    return this.http.get<Project>(`${PROJECT_API_URL}/projectId/${projectId}`);
  }

  saveProject(project: Project) {
    return this.http.post<Project>(`${PROJECT_API_URL}`, project);
  }

  updateProjectById(projectId: string, project: Project) {
    return this.http.put<Project>(`${PROJECT_API_URL}/projectId/${projectId}`, project);
  }

  deleteProjectById(projectId: string) {
    return this.http.delete<Project>(`${PROJECT_API_URL}/projectId/${projectId}`);
  }

  ProjectAssign(username: string, projectId: string, project: Project) {
    return this.http.put<Project>(`${PROJECT_API_URL}/projectAssign/${username}/project/${projectId}`, project);
  }

  assignProjectToUser(username: string, projectId: string, messageResponse: MessageResponse) {
    return this.http.put<MessageResponse>(`${PROJECT_API_URL}/assignProjectToUser/${username}/project/${projectId}`, messageResponse);
  }
}
