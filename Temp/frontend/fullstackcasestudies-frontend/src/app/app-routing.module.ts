import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { LogoutComponent } from './auth/logout/logout.component';
import { HomeComponent } from './home/home/home.component';
import { MyProjectsComponent } from './project/my-projects/my-projects.component';
import { ProjectRegistrationComponent } from './project/project-registration/project-registration.component';
import { ProjectUpdateComponent } from './project/project-update/project-update.component';
import { ViewProjectStatusComponent } from './project/view-project-status/view-project-status.component';
import { AuthRouteGuardService } from './service/guard/auth-route-guard.service';
import { LoginRouteGuardService } from './service/guard/login-route-guard.service';
import { RoleRouteGuardService } from './service/guard/role-route-guard.service';
import { MemberSignUpComponent } from './sign-up/member-sign-up/member-sign-up.component';
import { ProjectStoryRegistrationComponent } from './story/project-story-registration/project-story-registration.component';
import { ProjectStoryUpdateComponent } from './story/project-story-update/project-story-update.component';
import { ViewProjectStoryStatusComponent } from './story/view-project-story-status/view-project-story-status.component';
import { ProfilesComponent } from './user/profiles/profiles.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, canActivate: [LoginRouteGuardService] },
  { path: 'member-signUp', component: MemberSignUpComponent, canActivate: [LoginRouteGuardService] },
  { path: 'home/:userName', component: HomeComponent, canActivate: [AuthRouteGuardService] },
  { path: 'profiles/:userName', component: ProfilesComponent, canActivate: [AuthRouteGuardService] },
  { path: 'user-profile/:userName', component: UserProfileComponent, canActivate: [AuthRouteGuardService] },
  { path: 'view-project-status', component: HomeComponent, canActivate: [AuthRouteGuardService] },
  { path: 'my-projects', component: MyProjectsComponent, canActivate: [AuthRouteGuardService] },
  { path: 'view-project-status/:projectId', component: ViewProjectStatusComponent, canActivate: [AuthRouteGuardService] },
  { path: 'project-registration', component: ProjectRegistrationComponent, canActivate: [RoleRouteGuardService], data: {roles:['Admin']} },
  { path: 'view-project-story-status/:projectId/:storyId', component: ViewProjectStoryStatusComponent, canActivate: [AuthRouteGuardService] },
  { path: 'project-update/:projectId', component: ProjectUpdateComponent, canActivate: [RoleRouteGuardService], data: {roles:['Admin']}  },
  { path: 'project-story-registration/:projectId', component: ProjectStoryRegistrationComponent, canActivate: [RoleRouteGuardService], data: {roles:['Admin']}  },
  { path: 'project-story-update/:storyId', component: ProjectStoryUpdateComponent, canActivate: [AuthRouteGuardService] },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthRouteGuardService] },
  { path: '**', redirectTo: 'login', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
