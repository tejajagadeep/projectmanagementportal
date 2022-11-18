import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectStoryRegistrationComponent } from './project-story-registration.component';

describe('ProjectStoryRegistrationComponent', () => {
  let component: ProjectStoryRegistrationComponent;
  let fixture: ComponentFixture<ProjectStoryRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProjectStoryRegistrationComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectStoryRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
