package com.card.card.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Cards",uniqueConstraints = @UniqueConstraint(columnNames = "account_number"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cards  extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String cardUUId;
    @Column(nullable = false, unique = true)

    private String accountNumber;
    @Column(nullable = false)
    private String cardHolderName;
    @Column(nullable = false)
    private double balance;
    @Column(nullable = false)
    private String cardType;

    private String mobileNumber;

    private String cardNumber;

    private int totalLimit;

    private double amountUsed;

    private double availableAmount;
}
