import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormControl, Validators } from '@angular/forms';
import { AppOperationComponent } from '../app-operation/app-operation.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { Retirante } from '../models/Retirante';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-app-retirante',
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
  templateUrl: './app-retirante.component.html',
  styleUrl: './app-retirante.component.css'
})

export class AppRetiranteComponent {
  id = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  nombre = new FormControl('', [Validators.required, Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúÑñ]+$/)]);
  telefono = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  direccion = new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z0-9]$/)]);

  retirante: Retirante[] = [];
  selectedRetirante: Retirante[] = [];
  isVisible: boolean = false;

  toggleSelectAll(event: Event): void {
    const isChecked = (event.target as HTMLInputElement).checked;
    this.selectedRetirante = isChecked ? [...this.retirante] : [];
  }

  isAllSelected(): boolean {
    return this.selectedRetirante.length === this.retirante.length && this.retirante.length > 0;
  }

  cancelRecord() {
    this.isVisible = false;
    this.id.reset();
    this.nombre.reset();
    this.telefono.reset();
    this.direccion.reset();
  }
}
