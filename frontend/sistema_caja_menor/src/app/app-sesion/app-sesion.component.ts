import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormControl, Validators } from '@angular/forms';
import { TableModule } from 'primeng/table';
import { Credencial } from '../models/Credencial';
import { ButtonModule } from 'primeng/button';
import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';

@Component({
  selector: 'app-app-sesion',
  standalone: true,
  imports: [ReactiveFormsModule,
    PasswordModule,
    CommonModule,
    FormsModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    FloatLabelModule],
  templateUrl: './app-sesion.component.html',
  styleUrl: './app-sesion.component.css'
})
export class AppSesionComponent {
  cedula = new FormControl('', [Validators.required, Validators.pattern(/^[0-9]+$/)]);
  contrasenia = new FormControl('', Validators.required);


}
