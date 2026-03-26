import { Component, signal, inject } from '@angular/core';
import { AccountService } from '../service/account.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { toSignal } from '@angular/core/rxjs-interop';
@Component({
  selector: 'app-account-component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './account.component.html',
  styleUrl: './account.component.css',
})
export class AccountComponent {
  private accountService = inject(AccountService);

  accountId = 'account-1';
  amount = signal(0);
  statement = signal('');

  constructor() {
    this.loadStatement();
  }

  loadStatement(): void {
    this.accountService.getStatement(this.accountId).subscribe((data) => this.statement.set(data));
  }

  deposit(): void {
    this.accountService
      .deposit(this.accountId, this.amount())
      .subscribe(() => this.loadStatement());
  }

  withdraw(): void {
    this.accountService
      .withdraw(this.accountId, this.amount())
      .subscribe(() => this.loadStatement());
  }
}
