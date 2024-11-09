import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormControl, Validators } from '@angular/forms';
import { AppOperationComponent } from '../app-operation/app-operation.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { Producto } from '../models/Producto';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-app-producto',
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
  templateUrl: './app-producto.component.html',
  styleUrl: './app-producto.component.css'
})
export class AppProductoComponent {
  id = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  nombre = new FormControl('', [Validators.required, Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúÑñ]+$/)]);
  precio = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);

  Producto: Producto[] = [];
  selectedProducto: Producto[] = [];
  isVisible: boolean = false;

  toggleSelectAll(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    this.selectedProducto = isChecked ? [...this.Producto] : [];
  }

  isAllSelected(): boolean {
    return this.selectedProducto.length === this.Producto.length && this.Producto.length > 0;
  }

  cancelRecord() {
    this.isVisible = false;
    this.id.reset();
    this.nombre.reset();
    this.precio.reset();
  }
}
