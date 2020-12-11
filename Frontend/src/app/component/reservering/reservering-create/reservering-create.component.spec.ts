import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReserveringCreateComponent } from './reservering-create.component';

describe('ReserveringCreateComponent', () => {
  let component: ReserveringCreateComponent;
  let fixture: ComponentFixture<ReserveringCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReserveringCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReserveringCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
