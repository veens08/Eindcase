import { TestBed } from '@angular/core/testing';

import { BezoekService } from './bezoek.service';

describe('BezoekService', () => {
  let service: BezoekService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BezoekService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
