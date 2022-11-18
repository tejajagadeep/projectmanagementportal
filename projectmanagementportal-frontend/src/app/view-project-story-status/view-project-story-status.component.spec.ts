import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProjectStoryStatusComponent } from './view-project-story-status.component';

describe('ViewProjectStoryStatusComponent', () => {
  let component: ViewProjectStoryStatusComponent;
  let fixture: ComponentFixture<ViewProjectStoryStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewProjectStoryStatusComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProjectStoryStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
