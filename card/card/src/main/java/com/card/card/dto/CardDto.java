package com.card.card.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    private String accountNumber;
    private String cardHolderName;
    private double balance;
    private String cardType;
    private String mobileNumber;
    private String cardNumber;
    private int totalLimit;
    private double amountUsed;
    private double availableAmount;
}
