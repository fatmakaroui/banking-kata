import { TestBed } from '@angular/core/testing';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { AccountService } from './account.service';

describe('AccountService', () => {
  let service: AccountService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        AccountService,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(AccountService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should call POST deposit', () => {
    service.deposit('account-1', 1000).subscribe();
    const req = httpMock.expectOne(
      'http://localhost:8080/accounts/account-1/deposit?amount=1000'
    );
    expect(req.request.method).toBe('POST');
    req.flush(null);
  });

  it('should call POST withdraw', () => {
    service.withdraw('account-1', 500).subscribe();
    const req = httpMock.expectOne(
      'http://localhost:8080/accounts/account-1/withdraw?amount=500'
    );
    expect(req.request.method).toBe('POST');
    req.flush(null);
  });

  it('should call GET statement', () => {
    service.getStatement('account-1').subscribe();
    const req = httpMock.expectOne(
      'http://localhost:8080/accounts/account-1/statement'
    );
    expect(req.request.method).toBe('GET');
    req.flush('date | amount | balance');
  });
});