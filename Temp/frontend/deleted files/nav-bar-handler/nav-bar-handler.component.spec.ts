import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavBarHandlerComponent } from './nav-bar-handler.component';

describe('NavBarHandlerComponent', () => {
  let component: NavBarHandlerComponent;
  let fixture: ComponentFixture<NavBarHandlerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavBarHandlerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavBarHandlerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
