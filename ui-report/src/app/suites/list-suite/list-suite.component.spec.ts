import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSuiteComponent } from './list-suite.component';

describe('ListSuiteComponent', () => {
  let component: ListSuiteComponent;
  let fixture: ComponentFixture<ListSuiteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListSuiteComponent]
    });
    fixture = TestBed.createComponent(ListSuiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
