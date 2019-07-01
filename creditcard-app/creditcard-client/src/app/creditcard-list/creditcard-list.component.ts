import { Component, OnInit, Input, SimpleChanges, OnChanges } from '@angular/core';
import { CreditCard } from '../model/creditcard';
import { CreditCardService } from '../service/creditcard.service';

@Component({
  selector: 'app-creditcard-list',
  templateUrl: './creditcard-list.component.html',
  styleUrls: ['./creditcard-list.component.css']
})
export class CreditCardListComponent implements OnChanges {

  creditCards: CreditCard[];
  @Input() doReload;

  constructor(private creditCardService: CreditCardService) {

  }

  ngOnChanges(changes: SimpleChanges) {
    this.getCreditCardList();
  } 

  getCreditCardList() {
    this.creditCardService.findAll().subscribe(data => {
      this.creditCards = data;
    });
  }
}
