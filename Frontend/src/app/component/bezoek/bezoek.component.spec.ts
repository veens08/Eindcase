import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BezoekComponent } from './bezoek.component';

describe('BezoekersComponent', () => {
  let component: BezoekComponent;
  let fixture: ComponentFixture<BezoekComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BezoekComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BezoekComponent);
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
