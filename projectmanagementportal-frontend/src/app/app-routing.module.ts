import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MemberSignUpComponent } from './member-sign-up/member-sign-up.component';
import { MyProjectsComponent } from './my-projects/my-projects.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { ProjectRegistrationComponent } from './project-registration/project-registration.component';
import { ProjectStoryRegistrationComponent } from './project-story-registration/project-story-registration.component';
import { ProjectStoryUpdateComponent } from './project-story-update/project-story-update.component';
import { ProjectUpdateComponent } from './project-update/project-update.component';
import { AuthGuardDataService } from './service/auth/auth-guard-data.service';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ViewProjectStatusComponent } from './view-project-status/view-project-status.component';
import { ViewProjectStoryStatusComponent } from './view-project-story-status/view-project-story-status.component';

const routes: Routes = [
  { path: '', redirectTo: 'login' , pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'member-signUp', component: MemberSignUpComponent },
  { path: 'home/:userName', component: HomeComponent, canActivate: [AuthGuardDataService] },
  { path: 'profiles/:userName', component: ProfilesComponent, canActivate: [AuthGuardDataService] },
  { path: 'user-profile/:userName', component: UserProfileComponent, canActivate: [AuthGuardDataService] },
  { path: 'view-project-status', component: HomeComponent, canActivate: [AuthGuardDataService] },
  { path: 'my-projects', component: MyProjectsComponent, canActivate: [AuthGuardDataService] },
  { path: 'view-project-status/:projectId', component: ViewProjectStatusComponent, canActivate: [AuthGuardDataService] },
  { path: 'project-registration', component: ProjectRegistrationComponent, canActivate: [AuthGuardDataService] },
  { path: 'view-project-story-status/:projectId/:storyId', component: ViewProjectStoryStatusComponent, canActivate: [AuthGuardDataService] },
  { path: 'project-update/:projectId', component: ProjectUpdateComponent, canActivate: [AuthGuardDataService] },
  { path: 'project-story-registration/:projectId', component: ProjectStoryRegistrationComponent, canActivate: [AuthGuardDataService] },
  { path: 'project-story-update/:storyId', component: ProjectStoryUpdateComponent, canActivate: [AuthGuardDataService] },
  { path: '**', component: ErrorComponent, canActivate: [AuthGuardDataService] },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGuardDataService] }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
