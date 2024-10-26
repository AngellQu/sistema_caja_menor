import { Component } from '@angular/core';
import { AppBarComponent } from './app-bar/app-bar.component';
import { AppTabComponent } from './app-tab/app-tab.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [AppBarComponent, AppTabComponent],
  template:`
   <app-app-bar></app-app-bar>
   <app-app-tab></app-app-tab>
  `
})
export class AppComponent {
  title = 'sistema_caja_menor';
}
