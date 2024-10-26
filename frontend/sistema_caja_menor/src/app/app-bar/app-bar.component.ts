import { Component } from '@angular/core';
import { MenubarModule } from 'primeng/menubar';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-app-bar',
  standalone: true,
  imports: [MenubarModule, ButtonModule],
  template: `
    <p-menubar [style]="{
        'position': 'fixed',
        'top': '-1px',
        'left': '-1px',
        'right': '-1px',
        'border-radius': '0px',
        'background-color': 'black',
    }">
      <ng-template pTemplate="start">
        <img src="logoHotelGordonita.png" height="40" class="mr-2" />
      </ng-template>
      <ng-template pTemplate="end">
        <label>{{username}}</label>
        <p-button icon="pi pi-user" [rounded]="true" [text]="true" [style]="{ 'color': 'white' }" />
        <p-button icon="pi pi-sun" [rounded]="true" [text]="true" [style]="{ 
          'color': 'white',
          'margin-left':'15px'}"/>
        <p-button icon="pi pi-sign-out" [rounded]="true" [text]="true" [style]="{ 
          'color': 'white',
          'margin-left':'15px',
          'margin-right':'5px'}"/>
      </ng-template>
    </p-menubar>
  `,
  styles: `
    label {
      font-size: 14px;  
      color: white;
      margin-right: 20px;
      line-height: 45px; 
    }
  `
})
export class AppBarComponent {
  username: string = "Miguel Angel Quiceno";

  setUserName(name: string) {
    this.username = name;
  }
}
