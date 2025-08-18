package com.example.DealerAndVechicleManagement.repository;

import com.example.DealerAndVechicleManagement.model.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {}