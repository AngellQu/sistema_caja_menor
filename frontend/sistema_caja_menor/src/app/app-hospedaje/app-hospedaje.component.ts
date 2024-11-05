import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, FormControl, Validators, ReactiveFormsModule, AbstractControl, ValidationErrors} from '@angular/forms';
import { AppOperationComponent } from '../app-operation/app-operation.component';
import { TabViewModule } from 'primeng/tabview';
import { TableModule } from 'primeng/table';
import { Hospedaje } from '../models/Hospedaje';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { CalendarModule } from 'primeng/calendar';

@Component({
  selector: 'app-app-hospedaje',
  standalone: true,
  imports: [
    AppOperationComponent,
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
    TabViewModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    FloatLabelModule,
    CalendarModule],
  templateUrl: './app-hospedaje.component.html',
  styleUrl: './app-hospedaje.component.css'
})

export class AppHospedajeComponent {
  idHuesped = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  habitacion = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  fechaIngreso = new FormControl('', [Validators.required]);
  fechaSalida = new FormControl('', [Validators.required, this.fechaSalidaValida.bind(this)]);

  hospedajes: Hospedaje[] = [];
  selectedHospedajes: Hospedaje[] = [];
  isVisible: boolean = false;

  toggleSelectAll(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    this.selectedHospedajes = isChecked ? [...this.hospedajes] : [];
  }

  isAllSelected(): boolean {
    return this.selectedHospedajes.length === this.hospedajes.length && this.hospedajes.length > 0;
  }

  fechaSalidaValida(control: AbstractControl): ValidationErrors | null {
    const ingreso = this.fechaIngreso.value;
    const salida = control.value;

    if (!ingreso || !salida) return null;
    return new Date(salida) > new Date(ingreso) ? null : { fechaInvalida: true };
  }
  
  cancelRecord() {
    this.isVisible = false;
    this.idHuesped.reset();
    this.habitacion.reset();
    this.fechaIngreso.reset();
    this.fechaSalida.reset();
  }
}
