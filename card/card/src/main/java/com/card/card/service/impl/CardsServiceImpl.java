package com.card.card.service.impl;

import com.card.card.configuer.AccountFeignClient;
import com.card.card.dto.CardDto;
import com.card.card.dto.GenerateRandom;
import com.card.card.dto.ResponseAccountDto;
import com.card.card.dto.ResponseCardDto;
import com.card.card.entity.Cards;
import com.card.card.repository.CardRepository;
import com.card.card.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {

    @Autowired
    private CardRepository repository;

    @Autowired
    private AccountFeignClient configuer;

    @Override
    public String saveCardData(CardDto dto) {
        String responce;
        Cards cards = dtoToEntity(dto);
        cards.setCreatedAt(LocalDateTime.now());
        cards.setCreatedBy("Vinay");
        Cards save = repository.save(cards);
        if (save != null) {
            responce = " You are card saved successfully";
        } else{
            responce = " you are card invalid";
    }

        return responce;
    }

    @Override
    public List<CardDto> getCardData() {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public ResponseCardDto getCardByUUId(String uuid) {
        Cards card = repository.getByUUId(uuid);
        return mapToDto(card);
    }

    @Override
    public List<ResponseAccountDto> getAccountData() {
        return configuer.getAccountData(); // Feign will call the external service

    }



    private Cards dtoToEntity(CardDto dto) {
        Cards cards = new Cards();
        cards.setCardUUId(GenerateRandom.generateRandomNumber());
        cards.setCardNumber(GenerateRandom.generateCardNumber());
        cards.setAccountNumber(dto.getAccountNumber());
        cards.setTotalLimit(dto.getTotalLimit());
        cards.setBalance(dto.getBalance());
        cards.setAvailableAmount(dto.getAvailableAmount());
        cards.setMobileNumber(dto.getMobileNumber());
        cards.setAmountUsed(dto.getAmountUsed());
        cards.setCardType(dto.getCardType());

        cards.setCardHolderName(dto.getCardHolderName());
        return cards;
    }

    public CardDto entityToDto(Cards entity) {
        CardDto dto = new CardDto();
        dto.setCardNumber(entity.getCardNumber());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setTotalLimit(entity.getTotalLimit());
        dto.setBalance(entity.getBalance());
        dto.setAvailableAmount(entity.getAvailableAmount());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setAmountUsed(entity.getAmountUsed());
        dto.setCardHolderName(entity.getCardHolderName());
        dto.setCardType(entity.getCardType());

        return dto;
    }

    private ResponseCardDto mapToDto(Cards card) {
        ResponseCardDto responseCardDto = new ResponseCardDto();
        responseCardDto.setCardUUId(card.getCardUUId());
        responseCardDto.setAccountNumber(card.getAccountNumber());
        responseCardDto.setAccountHolderName(card.getCardHolderName());
        responseCardDto.setBalance(card.getBalance());
        responseCardDto.setCardType(card.getCardType());
        responseCardDto.setMobileNumber(card.getMobileNumber());
        responseCardDto.setCardNumber(card.getCardNumber());
        responseCardDto.setTotalLimit(card.getTotalLimit());
        responseCardDto.setAmountUsed(card.getAmountUsed());
        responseCardDto.setAvailableAmount(card.getAvailableAmount());
        responseCardDto.setCreatedAt(card.getCreatedAt());
        responseCardDto.setCreatedBy(card.getCreatedBy());
        responseCardDto.setUpdatedAt(card.getUpdatedAt());
        responseCardDto.setUpdatedBy(card.getUpdatedBy());
        return responseCardDto;
    }
}
