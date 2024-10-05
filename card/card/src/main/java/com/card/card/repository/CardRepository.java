package com.card.card.repository;

import com.card.card.entity.Cards;

import java.util.List;

public interface CardRepository {

    Cards save(Cards cards);
    List<Cards> findAll();
    Cards getByUUId(String uuid);

}
