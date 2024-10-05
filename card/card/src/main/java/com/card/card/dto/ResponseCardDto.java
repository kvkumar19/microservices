package com.card.card.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCardDto {

    private  String cardUUId;
    private String accountNumber;
    private String accountHolderName;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private double balance;
    private String cardType;
    private String mobileNumber;
    private String cardNumber;
    private int totalLimit;
    private double amountUsed;
    private double availableAmount;

}