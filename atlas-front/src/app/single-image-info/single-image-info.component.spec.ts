import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleImageInfoComponent } from './single-image-info.component';

describe('SingleImageInfoComponent', () => {
  let component: SingleImageInfoComponent;
  let fixture: ComponentFixture<SingleImageInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SingleImageInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SingleImageInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
