import { TestBed } from '@angular/core/testing';

import { MemberRouteGuardService } from './member-route-guard.service';

describe('MemberRouteGuardService', () => {
  let service: MemberRouteGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MemberRouteGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
