import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReserveringDetailComponent } from './reservering-detail.component';

describe('ReserveringDetailComponent', () => {
  let component: ReserveringDetailComponent;
  let fixture: ComponentFixture<ReserveringDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReserveringDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReserveringDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
