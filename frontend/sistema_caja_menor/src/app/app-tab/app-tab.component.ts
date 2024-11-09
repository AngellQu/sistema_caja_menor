import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabViewModule } from 'primeng/tabview';
import { RouterModule, Router } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { AppInicioComponent } from '../app-inicio/app-inicio.component';
import { AppHuespedComponent } from "../app-huesped/app-huesped.component";
import { AppHospedajeComponent } from '../app-hospedaje/app-hospedaje.component';
import { AppIngresoHospedajeComponent } from '../app-ingreso-hospedaje/app-ingreso-hospedaje.component';
import { AppIngresoProductoComponent } from '../app-ingreso-producto/app-ingreso-producto.component';
import { AppProductoComponent } from '../app-producto/app-producto.component';
import { AppRetiranteComponent } from '../app-retirante/app-retirante.component';
import { AppRetiroComponent } from '../app-retiro/app-retiro.component';

@Component({
  selector: 'app-app-tab',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    AppRetiranteComponent,
    AppRetiranteComponent,
    AppProductoComponent,
    AppIngresoProductoComponent,
    TabViewModule,
    ButtonModule,
    AppInicioComponent,
    AppHuespedComponent,
    AppHospedajeComponent,
    AppIngresoHospedajeComponent,
    AppRetiroComponent
  ],
  template: `
    <p-tabView (onChange)="onTabChange($event)" [activeIndex]="activeTabIndex" [style]="{
          'position': 'fixed',
          'top': '61px',
          'left': '-1px',
          'right': '-1px',
          'border-radius': '0px'}">
                
      <p-tabPanel header="Inicio">
        <ng-container *ngIf="activeTabIndex === 0">
          <router-outlet></router-outlet>
        </ng-container>
      </p-tabPanel>

      <p-tabPanel header="Huésped">
        <ng-container *ngIf="activeTabIndex === 1">
          <router-outlet></router-outlet>
        </ng-container>
      </p-tabPanel>

      <p-tabPanel header="Hospedaje">
        <ng-container *ngIf="activeTabIndex === 2">
          <router-outlet></router-outlet>
        </ng-container>
      </p-tabPanel>
      
      <p-tabPanel header="Ingreso Hospedaje">
        <ng-container *ngIf="activeTabIndex === 3">
          <router-outlet></router-outlet>
        </ng-container>
      </p-tabPanel>
      
      <p-tabPanel header="Ingreso Producto">
        <ng-container *ngIf="activeTabIndex === 4">
          <router-outlet></router-outlet>
        </ng-container>
      </p-tabPanel>
      
      <p-tabPanel header="Producto">
        <ng-container *ngIf="activeTabIndex === 5">
          <router-outlet></router-outlet>
        </ng-container>
      </p-tabPanel>
      
      <p-tabPanel header="Retirante">
        <ng-container *ngIf="activeTabIndex === 6">
          <router-outlet></router-outlet>
        </ng-container>
      </p-tabPanel>
      
      <p-tabPanel header="Retiro">
        <ng-container *ngIf="activeTabIndex === 7">
          <router-outlet></router-outlet>
        </ng-container>
      </p-tabPanel>
    </p-tabView>
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
export class AppTabComponent {
  activeTabIndex: number = 0;

  tabRoutes = [
    '/inicio',
    '/huespedes',
    '/hospedajes',
    '/ingresos-hospedajes',
    '/ingresos-productos',
    '/productos',
    '/retirantes',
    '/retiros'
  ];

  constructor(private router: Router) { }

  onTabChange(event: any) {
    this.activeTabIndex = event.index;
    this.router.navigate([this.tabRoutes[this.activeTabIndex]]);
  }
}