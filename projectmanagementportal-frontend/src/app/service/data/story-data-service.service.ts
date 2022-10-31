import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { STORY_API_URL } from 'src/app/app.constants';
import { Story } from 'src/app/project-stories-registration-or-updation/project-stories-registration-or-updation.component';

@Injectable({
  providedIn: 'root'
})
export class StoryDataServiceService {

  constructor(private http: HttpClient) { }

  getAllStories(){
    return this.http.get<Story[]>(`${STORY_API_URL}/getAllStories`)
  }

  getStoryById(storyId: string){
    return this.http.get<Story>(`${STORY_API_URL}/storyRegistration/${storyId}`)
  }

  saveStory(story: Story){
    return this.http.post<Story>(`${STORY_API_URL}/storyRegistration`,story)
  }

  updateStory(storyId: string, story: Story){
    return this.http.post<Story>(`${STORY_API_URL}/storyRegistration/${storyId}`,story)
  }

  deleteStoryById(storyId: string){
    return this.http.delete<Story>(`${STORY_API_URL}/storyRegistration/${storyId}`)
  }

}
