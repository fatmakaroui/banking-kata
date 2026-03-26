import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AccountComponent } from './account.component';
import { AccountService } from '../service/account.service';
import { of } from 'rxjs';
import { vi } from 'vitest';

describe('AccountComponent', () => {
  let component: AccountComponent;
  let fixture: ComponentFixture<AccountComponent>;
  let mockAccountService: {
    deposit: ReturnType<typeof vi.fn>;
    withdraw: ReturnType<typeof vi.fn>;
    getStatement: ReturnType<typeof vi.fn>;
  };

  beforeEach(async () => {
    mockAccountService = {
      deposit: vi.fn(),
      withdraw: vi.fn(),
      getStatement: vi
        .fn()
        .mockReturnValue(of('date       | amount   | balance\n2026-03-25 | 1000.00 | 1000.00')),
    };

    await TestBed.configureTestingModule({
      imports: [AccountComponent],
      providers: [{ provide: AccountService, useValue: mockAccountService }],
    }).compileComponents();

    fixture = TestBed.createComponent(AccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should display statement on init', () => {
    expect(mockAccountService.getStatement).toHaveBeenCalledWith('account-1');
    expect(component.statement).toContain('date       | amount   | balance');
  });

  it('should call deposit when deposit button is clicked', () => {
    component.amount = 1000;
    mockAccountService.deposit.mockReturnValue(of(null));

    component.deposit();

    expect(mockAccountService.deposit).toHaveBeenCalledWith('account-1', 1000);
  });

  it('should call withdraw when withdraw button is clicked', () => {
  component.amount = 500;
  mockAccountService.withdraw.mockReturnValue(of(null));

  component.withdraw();

  expect(mockAccountService.withdraw).toHaveBeenCalledWith('account-1', 500);
});
});
