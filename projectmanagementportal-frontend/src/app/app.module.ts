import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';


// search module
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatAutocompleteModule } from '@angular/material/autocomplete';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MemberSignUpComponent } from './member-sign-up/member-sign-up.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { ViewProjectStatusComponent } from './view-project-status/view-project-status.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpIntercepterBasicAuthService } from './service/http/http-intercepter-basic-auth.service';
import { UpdateStoryByMemberComponent } from './update-story-by-member/update-story-by-member.component';
import { ErrorComponent } from './error/error.component';
import { ProfilesComponent } from './profiles/profiles.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ViewProjectStoryStatusComponent } from './view-project-story-status/view-project-story-status.component';
import { ProjectRegistrationComponent } from './project-registration/project-registration.component';
import { ProjectUpdateComponent } from './project-update/project-update.component';
import { ProjectStoryRegistrationComponent } from './project-story-registration/project-story-registration.component';
import { ProjectStoryUpdateComponent } from './project-story-update/project-story-update.component';
import { MyProjectsComponent } from './my-projects/my-projects.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MemberSignUpComponent,
    MenuComponent,
    FooterComponent,
    ViewProjectStatusComponent,
    LogoutComponent,
    UpdateStoryByMemberComponent,
    ErrorComponent,
    ProfilesComponent,
    UserProfileComponent,
    ViewProjectStoryStatusComponent,
    ProjectRegistrationComponent,
    ProjectUpdateComponent,
    ProjectStoryRegistrationComponent,
    ProjectStoryUpdateComponent,
    MyProjectsComponent,
    ForbiddenComponent
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
