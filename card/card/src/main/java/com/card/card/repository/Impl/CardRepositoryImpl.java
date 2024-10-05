package com.card.card.repository.Impl;

import com.card.card.entity.Cards;
import com.card.card.repository.CardRepository;
import com.card.card.repository.JPA.CardJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {
    @Autowired
    private CardJpaRepository jpaRepository;

    @Override
    public Cards save(Cards cards) {
        return  jpaRepository.save(cards) ;
    }



    @Override
    public List<Cards> findAll() {
        return  jpaRepository.findAll();
    }

    @Override
    public Cards getByUUId(String uuid) {
        return  jpaRepository.getByCardUUId(uuid);
    }
}
