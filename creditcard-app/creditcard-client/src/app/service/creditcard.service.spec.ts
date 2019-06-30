import { TestBed } from '@angular/core/testing';

import { CreditCardService } from './service/creditcard.service';

describe('CreditcardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CreditCardService = TestBed.get(CreditCardService);
    expect(service).toBeTruthy();
  });
});
