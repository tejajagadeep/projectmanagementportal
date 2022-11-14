import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectStoriesRegistrationOrUpdationComponent } from './project-stories-registration-or-updation.component';

describe('ProjectStoriesRegistrationOrUpdationComponent', () => {
  let component: ProjectStoriesRegistrationOrUpdationComponent;
  let fixture: ComponentFixture<ProjectStoriesRegistrationOrUpdationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectStoriesRegistrationOrUpdationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectStoriesRegistrationOrUpdationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
