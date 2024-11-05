import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormControl, Validators } from '@angular/forms';
import { AppOperationComponent } from '../app-operation/app-operation.component';
import { TabViewModule } from 'primeng/tabview';
import { TableModule } from 'primeng/table';
import { Huesped } from '../models/Huesped';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';

@Component({
  selector: 'app-app-huesped',
  standalone: true,
  imports: [AppOperationComponent,
    ReactiveFormsModule,
    CommonModule,
    TabViewModule,
    FormsModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    FloatLabelModule],
  templateUrl: './app-huesped.component.html',
  styleUrl: './app-huesped.component.css'
})
export class AppHuespedComponent {
  cedula = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  nombre = new FormControl('', [Validators.required, Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúÑñ]+$/)]);
  telefono = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);

  huespedes: Huesped[] = [];
  selectedHuespedes: Huesped[] = [];
  isVisible: boolean = false;

  toggleSelectAll(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    this.selectedHuespedes = isChecked ? [...this.huespedes] : [];
  }

  isAllSelected(): boolean {
    return this.selectedHuespedes.length === this.huespedes.length && this.huespedes.length > 0;
  }

  cancelRecord() {
    this.isVisible = false;
    this.nombre.reset();
    this.cedula.reset();
    this.telefono.reset();
  }
}
