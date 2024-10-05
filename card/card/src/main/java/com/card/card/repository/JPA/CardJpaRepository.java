package com.card.card.repository.JPA;

import com.card.card.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardJpaRepository  extends JpaRepository<Cards,Integer> {
    //accountUUId
    Cards getByCardUUId(String UUId);
}
