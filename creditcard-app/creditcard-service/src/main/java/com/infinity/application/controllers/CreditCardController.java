package com.infinity.application.controllers;

import com.infinity.application.entities.CreditCard;
import com.infinity.application.repositories.CreditCardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated // class level
@CrossOrigin(origins = "http://localhost:4200")
public class CreditCardController {

    private final CreditCardRepository creditCardRepository;

    public CreditCardController(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @GetMapping("/creditcards")
    public List<CreditCard> getCreditCards() {
        return (List<CreditCard>) creditCardRepository.findAll();
    }

    @PostMapping("/addCreditcard")
    @ResponseStatus(HttpStatus.CREATED)
    void addCreditCard(@RequestBody @Valid CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }
}
