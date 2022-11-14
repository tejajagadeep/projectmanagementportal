import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectRegistrationOrUpdationComponent } from './project-registration-or-updation.component';

describe('ProjectRegistrationOrUpdationComponent', () => {
  let component: ProjectRegistrationOrUpdationComponent;
  let fixture: ComponentFixture<ProjectRegistrationOrUpdationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectRegistrationOrUpdationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectRegistrationOrUpdationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
