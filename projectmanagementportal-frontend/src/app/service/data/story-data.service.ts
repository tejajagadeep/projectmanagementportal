import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { STORY_API_URL } from 'src/app/app.constants';
import { MessageResponse } from 'src/app/model/message-response';
import { Story } from 'src/app/model/story';

@Injectable({
  providedIn: 'root'
})
export class StoryDataService {

  constructor(private http: HttpClient) { }

  getAllStories() {
    return this.http.get<Story[]>(`${STORY_API_URL}/getAllStories`)
  }

  getStoryById(storyId: string) {
    return this.http.get<Story>(`${STORY_API_URL}/getStoryById/${storyId}`)
  }

  saveStory(story: Story) {
    return this.http.post<Story>(`${STORY_API_URL}/storyRegistration`, story)
  }

  updateStoryAdmin(storyId: string, story: Story) {
    return this.http.put<Story>(`${STORY_API_URL}/updateStoryAdmin/${storyId}`, story)
  }

  updateStoryMember(storyId: string, story: Story) {
    return this.http.put<Story>(`${STORY_API_URL}/updateStoryMember/${storyId}`, story)
  }

  deleteStoryById(storyId: string) {
    return this.http.delete<Story>(`${STORY_API_URL}/deleteStoryById/${storyId}`)
  }

  StoryAssign(projectId: string, storyId: string, project: Story) {
    return this.http.put<Story>(`${STORY_API_URL}/updateStoryAssignAdmin/${projectId}/story/${storyId}`, Story);
  }

  StoryAssignToUser(userName: string, storyId: string, messageResponse: MessageResponse) {
    return this.http.put<MessageResponse>(`${STORY_API_URL}/assignStoryToUsers/${userName}/story/${storyId}`, messageResponse);
  }

}
