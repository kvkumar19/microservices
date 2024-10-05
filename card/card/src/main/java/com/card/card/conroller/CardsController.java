package com.card.card.conroller;

import com.card.card.dto.CardDto;
import com.card.card.dto.ResponseAccountDto;
import com.card.card.dto.ResponseCardDto;
import com.card.card.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @PostMapping()
    public ResponseEntity<String> saveAccount(@RequestBody CardDto cardDto) {
        String response = cardsService.saveCardData(cardDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public List<CardDto> getAllCars() {
        return cardsService.getCardData();
    }
    @GetMapping("/{uuid}")
    public ResponseEntity<ResponseCardDto> getById(@PathVariable("uuid")  String uuid){
        ResponseCardDto response = cardsService.getCardByUUId(uuid);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping("/accounts")
    public List<ResponseAccountDto> getExternalAccounts() {
        return cardsService.getAccountData(); // This will call the external service
    }
}
