import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CreditCard } from './../model/creditcard';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CreditCardService {

  private creditCardUrl: string;

  constructor(private http: HttpClient) {
    this.creditCardUrl = 'http://localhost:4201/';
  }

  public findAll(): Observable<CreditCard[]> {
    return this.http.get<CreditCard[]>(this.creditCardUrl + "creditcards");
  }

  public save(creditCard: CreditCard) {
    return this.http.post<CreditCard>(this.creditCardUrl + "addCreditcard", creditCard);
  }
}
