import { Component, signal } from '@angular/core';
import { AccountComponent } from './account/component/account.component';

@Component({
  selector: 'app-root',
  imports: [AccountComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
