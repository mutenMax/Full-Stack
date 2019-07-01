import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CreditCardService } from '../service/creditcard.service';
import { CreditCard } from '../model/creditcard';
import { HttpErrorResponse } from '@angular/common/http';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import 'rxjs/add/operator/catch';
import {catchError} from 'rxjs/operators';

@Component({
  selector: 'app-creditcard-form',
  templateUrl: './creditcard-form.component.html',
  styleUrls: ['./creditcard-form.component.css']
})
export class CreditCardFormComponent {

  creditCard: CreditCard;
  errors:any;

  public isCardAdded: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private creditCardService: CreditCardService) {
    this.creditCard = new CreditCard();
  }

  onSubmit() {
    this.creditCardService.save(this.creditCard).subscribe(
      result => {
        this.errors = '';
        this.creditCard = new CreditCard();
        this.isCardAdded = true;
      },
      error => {
        this.errors = error.error.errors;
      }
    );
  }

}
