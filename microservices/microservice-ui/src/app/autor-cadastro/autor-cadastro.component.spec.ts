import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorCadastroComponent } from './autor-cadastro.component';

describe('AutorCadastroComponent', () => {
  let component: AutorCadastroComponent;
  let fixture: ComponentFixture<AutorCadastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorCadastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
