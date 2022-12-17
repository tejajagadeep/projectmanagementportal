import { TestBed } from '@angular/core/testing';

import { RoleRouteGuardService } from './role-route-guard.service';

describe('RoleRouteGuardService', () => {
  let service: RoleRouteGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoleRouteGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
