import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormControl, Validators } from '@angular/forms';
import { AppOperationComponent } from '../app-operation/app-operation.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { IngresoHospedaje } from '../models/IngresoHospedaje';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-app-ingreso-hospedaje',
  standalone: true,
  imports: [AppOperationComponent,
    ReactiveFormsModule,
    DropdownModule,
    CommonModule,
    FormsModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    FloatLabelModule],
  templateUrl: './app-ingreso-hospedaje.component.html',
  styleUrl: './app-ingreso-hospedaje.component.css'
})

export class AppIngresoHospedajeComponent {
  idHospedaje = new FormControl('',[Validators.required, Validators.pattern(/^[0-9]+$/)]);
  metodoPago?: string;
  monto = new FormControl('',[Validators.required, Validators.pattern(/^[0-9]+$/)] );

  ingresoHospedaje: IngresoHospedaje[] = [];
  selectedIngresoHospedajes: IngresoHospedaje[] = [];
  isVisible: boolean = false;
  opcionesMetodosPago = [
    { label: 'Efectivo', value: 'efectivo' },
    { label: 'Transacción', value: 'transaccion' },
    { label: 'Tarjeta', value: 'tarjeta' },
    { label: 'QR', value: 'qr' }
  ];

  toggleSelectAll(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    this.selectedIngresoHospedajes = isChecked ? [...this.ingresoHospedaje] : [];
  }

  isAllSelected(): boolean { 
    return this.selectedIngresoHospedajes.length === this.ingresoHospedaje.length && this.ingresoHospedaje.length > 0;
  }

  cancelRecord() {
    this.isVisible = false;
    this.metodoPago = undefined;
    this.monto.reset();
    this.idHospedaje.reset();
  }
}
