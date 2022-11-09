import { TestBed } from '@angular/core/testing';

import { AuthGuardDataService } from './auth-guard-data.service';

describe('AuthGuardDataService', () => {
  let service: AuthGuardDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthGuardDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
