import { Component, OnInit } from '@angular/core';
import { CreditCard } from '../model/creditcard';
import { CreditCardService } from '../service/creditcard.service';

@Component({
  selector: 'app-creditcard-list',
  templateUrl: './creditcard-list.component.html',
  styleUrls: ['./creditcard-list.component.css']
})
export class CreditCardListComponent implements OnInit {

  creditCards: CreditCard[];

  constructor(private creditCardService: CreditCardService) {

  }

  ngOnInit() {
    this.creditCardService.findAll().subscribe(data => {
      this.creditCards = data;
    });
  }
}
