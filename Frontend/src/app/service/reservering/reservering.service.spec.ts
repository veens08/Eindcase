import { ReserveringService } from './reservering.service';
import {TestBed} from '@angular/core/testing';

describe('ReserveringService', () => {
  let service: ReserveringService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReserveringService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return true when checking if reserveringen array is truthy', () => {
    expect(service.getAll()).toBeTruthy();
  });

});
