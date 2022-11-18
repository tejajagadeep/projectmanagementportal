import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProjectStatusComponent } from './view-project-status.component';

describe('ViewProjectStatusComponent', () => {
  let component: ViewProjectStatusComponent;
  let fixture: ComponentFixture<ViewProjectStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewProjectStatusComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProjectStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
