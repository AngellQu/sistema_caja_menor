import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormControl, Validators } from '@angular/forms';
import { AppOperationComponent } from '../app-operation/app-operation.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { Retiro } from '../models/Retiro';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-app-retiro',
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
  templateUrl: './app-retiro.component.html',
  styleUrl: './app-retiro.component.css'
})

export class AppRetiroComponent {
  idRetirante = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  descripcion = new FormControl('', [Validators.required, Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúÑñ]+$/)]);
  monto = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);

  retiro: Retiro[] = [];
  selectedRetiro: Retiro[] = [];
  isVisible: boolean = false;

  toggleSelectAll(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    this.selectedRetiro = isChecked ? [...this.retiro] : [];
  }

  isAllSelected(): boolean {
    return this.selectedRetiro.length === this.retiro.length && this.retiro.length > 0;
  }

  cancelRecord() {
    this.isVisible = false;
    this.idRetirante.reset();
    this.descripcion.reset();
    this.monto.reset();
  }
}
