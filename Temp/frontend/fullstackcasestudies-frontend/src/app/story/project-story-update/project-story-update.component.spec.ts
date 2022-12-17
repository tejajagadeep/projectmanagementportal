import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectStoryUpdateComponent } from './project-story-update.component';

describe('ProjectStoryUpdateComponent', () => {
  let component: ProjectStoryUpdateComponent;
  let fixture: ComponentFixture<ProjectStoryUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProjectStoryUpdateComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectStoryUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
