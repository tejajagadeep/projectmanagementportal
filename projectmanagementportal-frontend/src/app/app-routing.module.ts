import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MemberSignUpComponent } from './member-sign-up/member-sign-up.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { ProjectRegistrationOrUpdationComponent } from './project-registration-or-updation/project-registration-or-updation.component';
import { ProjectRegistrationComponent } from './project-registration/project-registration.component';
import { ProjectStoriesRegistrationOrUpdationComponent } from './project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { ProjectUpdateComponent } from './project-update/project-update.component';
import { AuthGuardDataService } from './service/auth/auth-guard-data.service';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ViewProjectStatusComponent } from './view-project-status/view-project-status.component';
import { ViewProjectStoryStatusComponent } from './view-project-story-status/view-project-story-status.component';

const routes: Routes = [
  { path: '', component: ErrorComponent},
  { path: 'login', component: LoginComponent},
  // { path: 'home', component: HomeComponent},
  // { path: 'home/:userId', component: HomeComponent},
  // { path: 'member-signUp', component: MemberSignUpComponent},
  // { path: 'view-project-status', component: ViewProjectStatusComponent},
  // { path: 'project-registration', component: ProjectRegistrationOrUpdationComponent},
  // { path: 'project-registration/:projectId', component: ProjectRegistrationOrUpdationComponent},
  // { path: 'project-story-registration', component: ProjectStoriesRegistrationOrUpdationComponent},
  // { path: 'project-story-registration/:storyId', component: ProjectStoriesRegistrationOrUpdationComponent}
  // { path:'**', component: LoginComponent}
  { path: 'member-signUp', component: MemberSignUpComponent},
  { path: 'home/:userName', component: HomeComponent, canActivate: [AuthGuardDataService]},
  { path: 'profiles/:userName', component: ProfilesComponent, canActivate: [AuthGuardDataService]},
  { path: 'user-profile/:userName', component: UserProfileComponent, canActivate: [AuthGuardDataService]},
  { path: 'view-project-status', component: HomeComponent, canActivate: [AuthGuardDataService]},
  { path: 'view-project-status/:projectId', component: ViewProjectStatusComponent, canActivate: [AuthGuardDataService]},
  { path: 'project-registration', component: ProjectRegistrationOrUpdationComponent, canActivate: [AuthGuardDataService]},
  { path: 'view-project-story-status/:storyId', component: ViewProjectStoryStatusComponent, canActivate: [AuthGuardDataService]},
  { path: 'project-registration/:projectId', component: ProjectUpdateComponent, canActivate: [AuthGuardDataService]},
  { path: 'view-project-status/:projectId/project-story-registration', component: ProjectStoriesRegistrationOrUpdationComponent, canActivate: [AuthGuardDataService]},
  { path: 'project-story-registration', component: ProjectStoriesRegistrationOrUpdationComponent, canActivate: [AuthGuardDataService]},
  { path: 'project-story-registration/:storyId', component: ProjectStoriesRegistrationOrUpdationComponent, canActivate: [AuthGuardDataService]},

  { path: 'logout', component: LogoutComponent, canActivate: [AuthGuardDataService] },
  { path: '**', component: ErrorComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
