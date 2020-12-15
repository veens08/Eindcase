import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BezoekDetailComponent } from './bezoek-detail.component';

describe('BezoekersComponent', () => {
  let component: BezoekDetailComponent;
  let fixture: ComponentFixture<BezoekDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BezoekDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BezoekDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should return true when checked if reservering is truthy', () => {
    expect(component.getReserveringen()).toBeTruthy();
  });
});
