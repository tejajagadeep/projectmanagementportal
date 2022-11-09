import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { MemberSignUpComponent } from './member-sign-up/member-sign-up.component';
import { ProjectRegistrationOrUpdationComponent } from './project-registration-or-updation/project-registration-or-updation.component';
import { ProjectStoriesRegistrationOrUpdationComponent } from './project-stories-registration-or-updation/project-stories-registration-or-updation.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { ViewProjectStatusComponent } from './view-project-status/view-project-status.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpIntercepterBasicAuthService } from './service/http/http-intercepter-basic-auth.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    MemberSignUpComponent,
    ProjectRegistrationOrUpdationComponent,
    ProjectStoriesRegistrationOrUpdationComponent,
    MenuComponent,
    FooterComponent,
    ViewProjectStatusComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: HttpIntercepterBasicAuthService,
    //   multi: true
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
