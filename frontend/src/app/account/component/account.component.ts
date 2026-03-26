import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AccountService } from '../service/account.service';

@Component({
  selector: 'app-account-component',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './account.component.html',
  styleUrl: './account.component.css',
})
export class AccountComponent implements OnInit {
  statement: string = '';
  accountId: string = 'account-1';
  amount: number = 0;

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.loadStatement();
  }

  loadStatement(): void {
    this.accountService.getStatement(this.accountId).subscribe((data) => (this.statement = data));
  }

  deposit(): void {
    this.accountService.deposit(this.accountId, this.amount).subscribe(() => this.loadStatement());
  }
}
