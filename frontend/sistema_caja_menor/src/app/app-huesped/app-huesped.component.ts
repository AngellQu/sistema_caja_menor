import { Component } from '@angular/core';
import { AppOperationComponent } from '../app-operation/app-operation.component';
import { TabViewModule } from 'primeng/tabview';
import { TableModule } from 'primeng/table';
import { Huesped } from '../models/Huesped';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-app-huesped',
  standalone: true,
  imports: [AppOperationComponent, 
            TabViewModule,
            TableModule,
            ButtonModule],
  template:`
        <app-app-operation></app-app-operation>
        <p-table 
            [(selection)]="selectedHuespedes" 
            dataKey="cedula"
            [value]="huespedes" 
            scrollable="true"
            scrollHeight="300px"
            class="small-table" 
            [style]="{
              'height':'300px',
              'width': '700px',
              'border-radius': '5px',
              'overflow': 'hidden',
              'margin-top':'20px',
              'margin-left': '280px'}">
          <ng-template pTemplate="header">
            <tr>
              <th>Accion</th>
              <th>Cedula</th>
              <th>Nombre</th>
              <th>Telefono</th>
            </tr>
          </ng-template>
          <ng-template pTemplate="body" let-huesped>
            <tr>
              <td style="display: flex; align-item: center;">
                <p-tableCheckbox [value]="huesped" [style]="{
                  'margin-right':'5px',
                  'margin-top' : '-1px'
                }"/>
                <p-button icon="pi pi-pen-to-square" [text]="true" class="p-button-text" [style]="{ 
                  'color': 'orange',
                  'margin-top': '0', 
                  'border-radius': '5px', 
                  'margin-left':'5px',
                  'padding': '0px'
                   }" />
              </td>
              <td>{{ huesped.cedula }}</td>
              <td>{{ huesped.nombre }}</td>
              <td>{{ huesped.telefono }}</td>
            </tr>
          </ng-template>
        </p-table>
        <p class="p1">
          <input class = "box" type="checkbox" (change)="toggleSelectAll($event)" [checked]="isAllSelected()" /> Seleccionar todo
        </p>
        <p class="p2">Resultado:{{huespedes.length}}</p>
  `,
  styles:`
  .p1{
    margin-left: 200px;
    margin-top: 25px;
  }
  .p2{
    margin-top: -35px;
    margin-left:950px;
  }
  td{
    font-size: 14px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    padding: 0.5rem;
  }
  th{
    text-align: center; 
    font-size: 12px
  }`
})
export class AppHuespedComponent {
  huespedes: Huesped[] = [
    new Huesped('12345', 'Carlos Pérez rodriguez morales', '3238890003'),
    new Huesped('67890', 'Ana Gómez', '3126783450'),
    new Huesped('11223', 'María Ruiz', '3216782390'),
    new Huesped('67888', 'lola Gómez', '3126776550'),
  ];
  selectedHuespedes: Huesped[] = [];

  toggleSelectAll(event: Event): void {
      const isChecked = (event.target as HTMLInputElement).checked;
      this.selectedHuespedes = isChecked ? [...this.huespedes] : [];
  }
  
  isAllSelected(): boolean {
      return this.selectedHuespedes.length === this.huespedes.length && this.huespedes.length > 0;
  }
}
