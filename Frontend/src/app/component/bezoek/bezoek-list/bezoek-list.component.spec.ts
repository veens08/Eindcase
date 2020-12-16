import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BezoekListComponent } from './bezoek-list.component';

describe('BezoekListComponent', () => {
  let component: BezoekListComponent;
  let fixture: ComponentFixture<BezoekListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BezoekListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BezoekListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
