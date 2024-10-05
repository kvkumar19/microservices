package com.card.card.service;


import com.card.card.dto.CardDto;
import com.card.card.dto.ResponseAccountDto;
import com.card.card.dto.ResponseCardDto;

import java.util.List;

public interface CardsService {

    String saveCardData(CardDto dto );
    List<CardDto> getCardData();
    ResponseCardDto getCardByUUId(String uuid);
    List<ResponseAccountDto> getAccountData();
}
