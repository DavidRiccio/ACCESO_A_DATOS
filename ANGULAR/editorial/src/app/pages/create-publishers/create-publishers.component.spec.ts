import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePublishersComponent } from './create-publishers.component';

describe('CreatePublishersComponent', () => {
  let component: CreatePublishersComponent;
  let fixture: ComponentFixture<CreatePublishersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreatePublishersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatePublishersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
