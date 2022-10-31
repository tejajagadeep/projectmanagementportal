import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MemberSignUpComponent } from './member-sign-up/member-sign-up.component';
import { ProjectRegistrationOrUpdationComponent } from './project-registration-or-updation/project-registration-or-updation.component';
import { ProjectStoriesRegistrationOrUpdationComponent } from './project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { ViewProjectStatusComponent } from './view-project-status/view-project-status.component';

const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent},
  { path: 'home/:userId', component: HomeComponent},
  { path: 'member-signUp', component: MemberSignUpComponent},
  { path: 'view-project-status', component: ViewProjectStatusComponent},
  { path: 'view-project-status/:projectId', component: ProjectRegistrationOrUpdationComponent},
  { path: 'project-registration', component: ProjectRegistrationOrUpdationComponent},
  { path: 'view-project-status/:storyId', component: ProjectStoriesRegistrationOrUpdationComponent},
  { path: 'project-story-registration', component: ProjectStoriesRegistrationOrUpdationComponent}
  // { path:'**', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
