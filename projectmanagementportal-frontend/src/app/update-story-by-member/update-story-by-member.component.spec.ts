import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateStoryByMemberComponent } from './update-story-by-member.component';

describe('UpdateStoryByMemberComponent', () => {
  let component: UpdateStoryByMemberComponent;
  let fixture: ComponentFixture<UpdateStoryByMemberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateStoryByMemberComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateStoryByMemberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
