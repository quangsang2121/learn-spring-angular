import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailSuiteComponent } from './detail-suite.component';

describe('DetailSuiteComponent', () => {
  let component: DetailSuiteComponent;
  let fixture: ComponentFixture<DetailSuiteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DetailSuiteComponent]
    });
    fixture = TestBed.createComponent(DetailSuiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
