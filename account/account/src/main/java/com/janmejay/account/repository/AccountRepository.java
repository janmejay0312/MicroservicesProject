package com.janmejay.account.repository;

import com.janmejay.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

   public  Optional<Account> findByAccountNo(Long customerId);
   public  Optional<Account> findAllByCustomerId(Long customerId);
}
