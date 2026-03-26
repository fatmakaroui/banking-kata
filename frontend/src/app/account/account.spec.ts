import { TestBed } from '@angular/core/testing';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';

import { Account } from './account';

describe('Account', () => {
  let service: Account;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        Account,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(Account);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should call POST /accounts/account-1/deposit', () => {
    service.deposit('account-1', 1000).subscribe();

    const req = httpMock.expectOne(
      'http://localhost:8080/accounts/account-1/deposit?amount=1000'
    );
    expect(req.request.method).toBe('POST');
    req.flush(null);
  });

  it('should call POST /accounts/account-1/withdraw', () => {
  service.withdraw('account-1', 1000).subscribe();

  const req = httpMock.expectOne(
    'http://localhost:8080/accounts/account-1/withdraw?amount=1000'
  );
  expect(req.request.method).toBe('POST');
  req.flush(null);
});

});
