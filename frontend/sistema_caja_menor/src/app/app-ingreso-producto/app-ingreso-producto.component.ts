import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormControl, Validators } from '@angular/forms';
import { AppOperationComponent } from '../app-operation/app-operation.component';
import { TabViewModule } from 'primeng/tabview';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { IngresoProducto } from '../models/IngresoProducto';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-app-ingreso-producto',
  standalone: true,
  imports: [AppOperationComponent,
    ReactiveFormsModule,
    DropdownModule,
    CommonModule,
    FormsModule,
    TabViewModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    FloatLabelModule],
  templateUrl: './app-ingreso-producto.component.html',
  styleUrl: './app-ingreso-producto.component.css'
})

export class AppIngresoProductoComponent {
  nombre =  new FormControl('', [Validators.required, Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúÑñ]+$/)]);
  cantidad = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  metodoPago?: string;
  idHuesped = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)])

  ingresoProducto: IngresoProducto[] = [];
  selectedIngresoProducto: IngresoProducto[] = [];
  isVisible: boolean = false;
  opcionesMetodosPago = [
    { label: 'Efectivo', value: 'efectivo' },
    { label: 'Transacción', value: 'transaccion' },
    { label: 'Tarjeta', value: 'tarjeta' },
    { label: 'QR', value: 'qr' }
  ];

  toggleSelectAll(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    this.selectedIngresoProducto = isChecked ? [...this.ingresoProducto] : [];
  }

  isAllSelected(): boolean { 
    return this.selectedIngresoProducto.length === this.ingresoProducto.length && this.ingresoProducto.length > 0;
  }

  cancelRecord() {
    this.isVisible = false;
    this.nombre.reset();
    this.cantidad.reset();
    this.idHuesped.reset();
    this.metodoPago = undefined;
  }
}
