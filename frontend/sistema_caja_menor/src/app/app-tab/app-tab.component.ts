import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabViewModule } from 'primeng/tabview';
import { ButtonModule } from 'primeng/button';
import { AppInicioComponent } from '../app-inicio/app-inicio.component';
import { AppHuespedComponent } from "../app-huesped/app-huesped.component";
import { AppHospedajeComponent } from '../app-hospedaje/app-hospedaje.component';
import { AppIngresoHospedajeComponent } from '../app-ingreso-hospedaje/app-ingreso-hospedaje.component';
import { AppIngresoProductoComponent } from '../app-ingreso-producto/app-ingreso-producto.component';

@Component({
  selector: 'app-app-tab',
  standalone: true,
  imports: [
            CommonModule,
            AppIngresoProductoComponent,
            TabViewModule,
            ButtonModule,
            AppInicioComponent,
            AppHuespedComponent,
            AppHospedajeComponent,
            AppIngresoHospedajeComponent],
  template: `
    <p-tabView [style]="{
          'position': 'fixed',
          'top': '61px',
          'left': '-1px',
          'right': '-1px',
          'border-radius': '0px'}">
      <p-tabPanel header="Inicio">
        <app-app-inicio></app-app-inicio>
      </p-tabPanel>
      <p-tabPanel header="Huésped">
        <app-app-huesped></app-app-huesped>
      </p-tabPanel>
      <p-tabPanel header="Hospedaje">
        <app-app-hospedaje></app-app-hospedaje>
      </p-tabPanel>
      <p-tabPanel header="Ingreso Hospedaje" >
        <app-app-ingreso-hospedaje></app-app-ingreso-hospedaje>
      </p-tabPanel>
      <p-tabPanel header="Ingreso producto" >
        <app-app-ingreso-producto></app-app-ingreso-producto>
      </p-tabPanel>
      <p-tabPanel header="Producto" >
      </p-tabPanel>
      <p-tabPanel header="Retirante" >
      </p-tabPanel>
      <p-tabPanel header="Retiro" >
      </p-tabPanel>
  `,
  styles: `
   :host ::ng-deep .p-tabview-nav {
      background-color: #7CA49F;
    }
    :host ::ng-deep .p-tabview .p-tabview-panels {
      background: #EDEAEA;
      width: 100vw;
      height: 100vh;
    } 
   :host ::ng-deep .p-tabview .p-tabview-nav li .p-tabview-nav-link {
       background: #7CA49F; 
       color: black;
       font-size: 12px;
    }
  `
})
export class AppTabComponent {}
 