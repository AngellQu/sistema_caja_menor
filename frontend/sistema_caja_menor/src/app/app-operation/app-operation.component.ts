import { Component } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-app-operation',
  standalone: true,
  imports: [InputTextModule, ButtonModule],
  template: `
      <div>
        <input  pInputText placeholder="Buscar" [style]="{
          'border-radius': '5px 0px 0px 5px',
          'border-color':'white',
          'margin-left':'50px'
        }"/>
        <p-button icon="pi pi-search"[style]="{
          'background-color': 'white',
          'border-color':'white',
          'margin-left':'1px',          
          'color':'black',
          'border-radius': '0px 5px 5px 0px'
        }"></p-button>
        <button pButton icon="pi pi-plus-circle" type="button" label="Añadir" class="p-button-sm" [style]="{
          'background-color':'yellow',
          'margin-left':'500px',
          'border-color':'yellow',
          'color':'black'
        }"></button>
        <button pButton icon="pi pi-trash" type="button" label="Eliminar" class="p-button-sm" [style]="{
          'background-color':'white',
          'margin-left':'15px',
          'border-color':'white',
          'color':'black'
        }"></button>
        <button pButton icon="pi pi-download" type="button" label="Descargar" class="p-button-sm" [style]="{
          'background-color':'white',
          'margin-left':'15px',
          'border-color':'white',
          'color':'black'
        }"></button>
      </div>
  `,
  styles:``
})
export class AppOperationComponent {}
