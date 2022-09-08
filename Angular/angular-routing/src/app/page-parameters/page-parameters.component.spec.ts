import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageParametersComponent } from './page-parameters.component';

describe('PageParametersComponent', () => {
  let component: PageParametersComponent;
  let fixture: ComponentFixture<PageParametersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageParametersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageParametersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
