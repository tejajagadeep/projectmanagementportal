import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MemberSignUpComponent } from './member-sign-up/member-sign-up.component';

const routes: Routes = [
  { path:'', component: LoginComponent},
  { path:'login', component: LoginComponent},
  { path:'home/:userId', component: HomeComponent},
  { path:'memberSignUp', component: MemberSignUpComponent}
  // { path:'**', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
