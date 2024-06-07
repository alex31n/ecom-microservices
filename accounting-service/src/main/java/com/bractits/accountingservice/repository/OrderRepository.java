package com.bractits.accountingservice.repository;

import com.bractits.accountingservice.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Account, Long> {
}
