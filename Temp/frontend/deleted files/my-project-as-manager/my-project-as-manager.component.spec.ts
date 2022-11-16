import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyProjectAsManagerComponent } from './my-project-as-manager.component';

describe('MyProjectAsManagerComponent', () => {
  let component: MyProjectAsManagerComponent;
  let fixture: ComponentFixture<MyProjectAsManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyProjectAsManagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyProjectAsManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
