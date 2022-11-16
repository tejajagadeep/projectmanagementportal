import { TestBed } from '@angular/core/testing';

import { GetUserDetialsMethodsService } from './get-user-detials-methods.service';

describe('GetUserDetialsMethodsService', () => {
  let service: GetUserDetialsMethodsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetUserDetialsMethodsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
