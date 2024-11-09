import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-app-inicio',
  standalone: true,
  imports: [CommonModule],
  template:`
        <p class="p1">{{ currentDate | date: 'shortDate'}}</p> 
        <p class="p2">Total:{{ saldo }}</p>
  `,
  styles:`
     .p1{
      font-size: 35px;
      color: black;
      position: relative;
      top: 320px;
    }
    .p2{
      font-size: 45px;
      color: black;
      position: relative;
      top: 170px;
    }
  `
})
export class AppInicioComponent {
currentDate: Date = new Date();
  saldo: string = "3450000"; 

  setSaldo(saldo : string){
    this.saldo = saldo;
  }
}
