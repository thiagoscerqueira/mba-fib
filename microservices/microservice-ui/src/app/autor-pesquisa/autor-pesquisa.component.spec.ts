import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorPesquisaComponent } from './autor-pesquisa.component';

describe('AutorPesquisaComponent', () => {
  let component: AutorPesquisaComponent;
  let fixture: ComponentFixture<AutorPesquisaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorPesquisaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorPesquisaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
