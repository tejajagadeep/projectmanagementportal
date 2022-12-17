import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LogoutComponent } from './auth/logout/logout.component';
import { LoginComponent } from './auth/login/login.component';
import { HomeComponent } from './home/home/home.component';
import { MemberSignUpComponent } from './sign-up/member-sign-up/member-sign-up.component';
import { MenuComponent } from './navbar/menu/menu.component';
import { FooterComponent } from './navbar/footer/footer.component';
import { ViewProjectStatusComponent } from './project/view-project-status/view-project-status.component';
import { ProfilesComponent } from './user/profiles/profiles.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { ViewProjectStoryStatusComponent } from './story/view-project-story-status/view-project-story-status.component';
import { ProjectRegistrationComponent } from './project/project-registration/project-registration.component';
import { ProjectUpdateComponent } from './project/project-update/project-update.component';
import { ProjectStoryRegistrationComponent } from './story/project-story-registration/project-story-registration.component';
import { ProjectStoryUpdateComponent } from './story/project-story-update/project-story-update.component';
import { MyProjectsComponent } from './project/my-projects/my-projects.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { HttpIntercepterBasicAuthService } from './service/http/http-intercepter-basic-auth.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    HomeComponent,
    MemberSignUpComponent,
    MenuComponent,
    FooterComponent,
    ViewProjectStatusComponent,
    ProfilesComponent,
    UserProfileComponent,
    ViewProjectStoryStatusComponent,
    ProjectRegistrationComponent,
    ProjectUpdateComponent,
    ProjectStoryRegistrationComponent,
    ProjectStoryUpdateComponent,
    MyProjectsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatAutocompleteModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpIntercepterBasicAuthService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
