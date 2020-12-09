import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BesmettingReportComponent } from './besmetting-report.component';

describe('BesmettingReportComponent', () => {
  let component: BesmettingReportComponent;
  let fixture: ComponentFixture<BesmettingReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BesmettingReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BesmettingReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
