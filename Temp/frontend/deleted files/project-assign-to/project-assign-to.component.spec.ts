import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectAssignToComponent } from './project-assign-to.component';

describe('ProjectAssignToComponent', () => {
  let component: ProjectAssignToComponent;
  let fixture: ComponentFixture<ProjectAssignToComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectAssignToComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectAssignToComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
