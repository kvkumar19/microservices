package com.accounts.accounts.repository.JPA;

import com.accounts.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository  extends JpaRepository<Account ,Integer> {
    //accountUUId
    Account getByAccountUUId(String UUId);
}
