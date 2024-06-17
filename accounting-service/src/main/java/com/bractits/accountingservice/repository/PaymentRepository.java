package com.bractits.accountingservice.repository;

import com.bractits.accountingservice.data.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findAllByTransactionId(String transactionId);

    Optional<Payment> findByOrderId(Long id);

    Optional<Payment> findByUid(String uid);
}
