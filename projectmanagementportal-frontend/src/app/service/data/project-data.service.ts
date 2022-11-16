import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PROJECT_API_URL } from 'src/app/app.constants';
import { MessageResponse } from 'src/app/model/message-response';
import { Project } from 'src/app/model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectDataService {

  messageRespone!: MessageResponse


  constructor(private http: HttpClient,
    ) { }

  getAllProjects(){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getAllProjects`)
  }

  getProjectsByProjectOwner(projectOwner: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectOwner/${projectOwner}`);
  }

  getProjectsByProjectManagerName(projectManagerName: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByProjectManagerName/${projectManagerName}`);
  }

  getProjectByAssignedTo(getProjectByAssignedTo: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectByAssignedTo/${getProjectByAssignedTo}`);
  }

  getProjectsByTechLeadName(techLeadName: string){
    return this.http.get<Project[]>(`${PROJECT_API_URL}/getProjectsByTechLeadName/${techLeadName}`);
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
    return this.http.put<Project>(`${PROJECT_API_URL}/updateProjectAssign/${username}/project/${projectId}`,project);
  }

  assignProjectToUser(username: string, projectId:string, messageResponse: MessageResponse){
    return this.http.put<MessageResponse>(`${PROJECT_API_URL}/assignProjectToUser/${username}/project/${projectId}`,messageResponse);
  }
}
