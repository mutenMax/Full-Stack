package com.infinity.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;


@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Please provide a name.")
    private String name;

    @com.infinity.application.validator.CreditCard
    @NotEmpty(message = "Please provide a Credit Card Number.")
    private String creditCardNumber;

    private BigDecimal cardLimit;

    protected BigDecimal cardBalance;

    public CreditCard() {
        this.creditCardNumber = "";
    }

    public CreditCard(String name, String creditCardNumber, BigDecimal cardLimit, BigDecimal cardBalance) {
        this.name = name;
        this.creditCardNumber = creditCardNumber;
        this.cardLimit = cardLimit;
        this.cardBalance = cardBalance;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public BigDecimal getCardLimit() {
        return cardLimit;
    }

    public BigDecimal getCardBalance() {
        return cardBalance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", cardLimit=" + cardLimit +
                ", cardBalance=" + cardBalance +
                '}';
    }
}
