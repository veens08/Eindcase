import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BezoekersComponent } from './bezoekers.component';

describe('BezoekersComponent', () => {
  let component: BezoekersComponent;
  let fixture: ComponentFixture<BezoekersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BezoekersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BezoekersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
