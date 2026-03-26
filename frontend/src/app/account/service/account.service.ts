import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private readonly apiUrl = 'http://localhost:8080/accounts';

  constructor(private http: HttpClient) {}

  deposit(accountId: string, amount: number): Observable<void> {
    return this.http.post<void>(
      `${this.apiUrl}/${accountId}/deposit`,
      null,
      { params: { amount: amount.toString() } }
    );
  }

  withdraw(accountId: string, amount: number): Observable<void> {
    return this.http.post<void>(
      `${this.apiUrl}/${accountId}/withdraw`,
      null,
      { params: { amount: amount.toString() } }
    );
  }

  getStatement(accountId: string): Observable<string> {
    return this.http.get(
      `${this.apiUrl}/${accountId}/statement`,
      { responseType: 'text' }
    );
  }

}