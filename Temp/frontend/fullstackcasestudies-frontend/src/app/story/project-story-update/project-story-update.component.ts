import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Story } from 'src/app/model/story';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { StoryDataService } from 'src/app/service/data/story-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-project-story-update',
  templateUrl: './project-story-update.component.html',
  styleUrls: ['./project-story-update.component.css']
})
export class ProjectStoryUpdateComponent implements OnInit {

  story!: Story
  storyId!: string
  dateDummy!: Date
  errorMessageResponse!: string
  temp!: string
  storyAssigned!: string[]
  username!: string
  emailIds!: string[]
  names!: string[]

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private storyDataService: StoryDataService,
    private authService: AuthenticationDataService,
    private userService: UserDataService,
    private location: Location
  ) { }

  ngOnInit(): void {
    console.log('project-story-update.component.ts')
    this.storyId = this.route.snapshot.params['storyId'];
    this.getStoryById(this.storyId);
    this.getUserEmailId()
    this.getUsernames()
    this.username = this.authService.getLoggedInUserName();
  }

  navBack() {
    this.location.back()
  }

  getUserEmailId() {
    this.userService.getUserEmailId().subscribe(
      response => {
        this.emailIds = response;
      }
    )
  }

  getUsernames() {
    this.userService.getNames().subscribe(
      response => {
        this.names = response;
      }
    )
  }

  OnlyAlbhabets(event: any):boolean{

    const charCode = (event.which)?event.which: event.keyCode;

    if (charCode == 32 || ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))) {
       return true
    }


    return false;
  }

  getStoryById(storyId: string) {
    this.storyDataService.getStoryById(storyId).subscribe(
      response => {
        this.story = response;
      },
      error => {
        console.log("Exception Occured")
        this.handleErrorMessage(error);
      }
    )
  }

  updateStoryById() {
    this.storyDataService.updateStoryAdmin(this.storyId, this.story)
      .subscribe(
        response => {
          console.log(`updated story with Id ${this.storyId}`)
          this.navBack()
        },
        error => {
          console.log("Exception Occured")
          this.handleErrorMessage(error);
        }
      )
  }

  handleErrorMessage(error: any) {
    // this.errorMessageResponse = error
    this.errorMessageResponse = error.error.message
  }
}
