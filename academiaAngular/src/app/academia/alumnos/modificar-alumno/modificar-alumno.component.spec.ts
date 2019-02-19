import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificarAlumnoComponent } from './modificar-alumno.component';

describe('ModificarAlumnoComponent', () => {
  let component: ModificarAlumnoComponent;
  let fixture: ComponentFixture<ModificarAlumnoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModificarAlumnoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModificarAlumnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
