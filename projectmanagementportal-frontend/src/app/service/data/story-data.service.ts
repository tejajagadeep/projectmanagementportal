import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { STORY_API_URL } from 'src/app/app.constants';
import { Story } from 'src/app/project-stories-registration-or-updation/project-stories-registration-or-updation.component';

@Injectable({
  providedIn: 'root'
})
export class StoryDataService {

  constructor(private http: HttpClient) { }

  getAllStories(): Observable<any>{
    return this.http.get<Story[]>(`${STORY_API_URL}/getAllStories`)
  }

  getStoryById(storyId: string): Observable<any>{
    return this.http.get<Story>(`${STORY_API_URL}/getStoryById/${storyId}`)
  }

  saveStory(story: Story): Observable<any>{
    return this.http.post<Story>(`${STORY_API_URL}/storyRegistration`,story)
  }

  updateStory(storyId: string, story: Story): Observable<any>{
    return this.http.post<Story>(`${STORY_API_URL}/updateStory/${storyId}`,story)
  }

  deleteStoryById(storyId: string): Observable<any>{
    return this.http.delete<Story>(`${STORY_API_URL}/deleteStoryById/${storyId}`)
  }

}
