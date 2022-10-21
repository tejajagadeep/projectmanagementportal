import { TestBed } from '@angular/core/testing';

import { StoryDataServiceService } from './story-data-service.service';

describe('StoryDataServiceService', () => {
  let service: StoryDataServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StoryDataServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
