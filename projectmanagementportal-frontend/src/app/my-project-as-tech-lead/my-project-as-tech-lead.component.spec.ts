import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyProjectAsTechLeadComponent } from './my-project-as-tech-lead.component';

describe('MyProjectAsTechLeadComponent', () => {
  let component: MyProjectAsTechLeadComponent;
  let fixture: ComponentFixture<MyProjectAsTechLeadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyProjectAsTechLeadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyProjectAsTechLeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
