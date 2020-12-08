import { ReserveringComponent } from './reservering.component';
import {ComponentFixture, TestBed} from '@angular/core/testing';

describe('ReserveringComponent', () => {
  let component: ReserveringComponent;
  let fixture: ComponentFixture<ReserveringComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReserveringComponent ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReserveringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should return true when checked if array of reserveringen is truthy', () => {
    expect(component.getReserveringen()).toBeTruthy();
  });

  it('should return true when checking if reserveringen array is of type array', () => {
    expect(Array.isArray(component.getReserveringen())).toBeTrue();
  });

});
