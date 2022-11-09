import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MemberSignUpComponent } from './member-sign-up/member-sign-up.component';
import { ProjectRegistrationOrUpdationComponent } from './project-registration-or-updation/project-registration-or-updation.component';
import { ProjectStoriesRegistrationOrUpdationComponent } from './project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { AuthGuardDataService } from './service/auth/auth-guard-data.service';
import { ViewProjectStatusComponent } from './view-project-status/view-project-status.component';

const routes: Routes = [
  { path: '', component: LoginComponent},
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
  { path: 'home/:userName', component: HomeComponent, canActivate: [AuthGuardDataService]},
  { path: 'member-signUp', component: MemberSignUpComponent},
  { path: 'view-project-status', component: ViewProjectStatusComponent, canActivate: [AuthGuardDataService]},
  { path: 'project-registration', component: ProjectRegistrationOrUpdationComponent, canActivate: [AuthGuardDataService]},
  { path: 'project-registration/:projectId', component: ProjectRegistrationOrUpdationComponent, canActivate: [AuthGuardDataService]},
  { path: 'project-story-registration', component: ProjectStoriesRegistrationOrUpdationComponent, canActivate: [AuthGuardDataService]},
  { path: 'project-story-registration/:storyId', component: ProjectStoriesRegistrationOrUpdationComponent, canActivate: [AuthGuardDataService]},
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGuardDataService] },
  { path: '**', component: LoginComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
