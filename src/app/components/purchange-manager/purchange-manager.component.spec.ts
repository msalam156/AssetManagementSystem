import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchangeManagerComponent } from './purchange-manager.component';

describe('PurchangeManagerComponent', () => {
  let component: PurchangeManagerComponent;
  let fixture: ComponentFixture<PurchangeManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PurchangeManagerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PurchangeManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
