import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
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
import { AdminRouteGuardService } from './service/role/admin-route-guard.service';
import { MemberRouteGuardService } from './service/role/member-route-guard.service';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ViewProjectStatusComponent } from './view-project-status/view-project-status.component';
import { ViewProjectStoryStatusComponent } from './view-project-story-status/view-project-story-status.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, canActivate: [MemberRouteGuardService] },
  { path: 'member-signUp', component: MemberSignUpComponent, canActivate: [MemberRouteGuardService] },
  { path: 'home/:userName', component: HomeComponent, canActivate: [AuthGuardDataService] },
  { path: 'profiles/:userName', component: ProfilesComponent, canActivate: [AuthGuardDataService] },
  { path: 'user-profile/:userName', component: UserProfileComponent, canActivate: [AuthGuardDataService] },
  { path: 'view-project-status', component: HomeComponent, canActivate: [AuthGuardDataService] },
  { path: 'my-projects', component: MyProjectsComponent, canActivate: [AuthGuardDataService] },
  { path: 'view-project-status/:projectId', component: ViewProjectStatusComponent, canActivate: [AuthGuardDataService] },
  { path: 'project-registration', component: ProjectRegistrationComponent, canActivate: [AdminRouteGuardService], data: {roles:['Admin']} },
  { path: 'view-project-story-status/:projectId/:storyId', component: ViewProjectStoryStatusComponent, canActivate: [AuthGuardDataService] },
  { path: 'project-update/:projectId', component: ProjectUpdateComponent, canActivate: [AdminRouteGuardService], data: {roles:['Admin']}  },
  { path: 'project-story-registration/:projectId', component: ProjectStoryRegistrationComponent, canActivate: [AdminRouteGuardService], data: {roles:['Admin']}  },
  { path: 'project-story-update/:storyId', component: ProjectStoryUpdateComponent, canActivate: [AuthGuardDataService] },
  { path: 'error', component: ErrorComponent, canActivate: [AuthGuardDataService] },
  { path: 'forbidden', component: ForbiddenComponent, canActivate: [AuthGuardDataService] },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGuardDataService] },
  { path: '**', redirectTo: 'login', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
