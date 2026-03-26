import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Account {

  private readonly apiUrl = 'http://localhost:8080/accounts';

  constructor(private http: HttpClient) {}

  deposit(accountId: string, amount: number): Observable<void> {
    return this.http.post<void>(
      `${this.apiUrl}/${accountId}/deposit`,
      null,
      { params: { amount: amount.toString() } }
    );
  }
}