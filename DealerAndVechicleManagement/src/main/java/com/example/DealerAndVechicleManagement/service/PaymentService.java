package com.example.DealerAndVechicleManagement.service;

import com.example.DealerAndVechicleManagement.dto.PaymentRequest;
import com.example.DealerAndVechicleManagement.dto.PaymentResponse;
import com.example.DealerAndVechicleManagement.model.PaymentTransaction;
import com.example.DealerAndVechicleManagement.repository.PaymentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentTransactionRepository paymentRepository;

    public PaymentResponse initiatePayment(PaymentRequest request) {
        // 1. Create and save the transaction with "PENDING" status.
        PaymentTransaction transaction = new PaymentTransaction();
        transaction.setDealerId(request.getDealerId());
        transaction.setAmount(request.getAmount());
        transaction.setMethod(request.getMethod());
        transaction.setStatus("PENDING");
        transaction.setCreatedAt(LocalDateTime.now());

        PaymentTransaction savedTransaction = paymentRepository.save(transaction);

        // 2. Trigger the asynchronous process for the delayed update.
        processPaymentCallback(savedTransaction.getId());

        // 3. Immediately return a response to the client.
        PaymentResponse response = new PaymentResponse();
        response.setTransactionId(savedTransaction.getId());
        response.setStatus(savedTransaction.getStatus());
        response.setMessage("Payment initiated. Awaiting confirmation.");

        return response;
    }

    @Async // This tells Spring to run this method in a separate background thread.
    public void processPaymentCallback(Long transactionId) {
        try {
            // Simulate the 5-second delay from the payment gateway.
            System.out.println("Simulating 5-second payment processing for transaction: " + transactionId);
            Thread.sleep(5000);

            // Fetch the transaction from the DB.
            PaymentTransaction transaction = paymentRepository.findById(transactionId)
                    .orElseThrow(() -> new RuntimeException("Transaction not found"));

            // Update the status to "SUCCESS".
            transaction.setStatus("SUCCESS");
            paymentRepository.save(transaction);
            System.out.println("Payment SUCCESS for transaction: " + transactionId);

        } catch (InterruptedException e) {
            System.err.println("Payment simulation was interrupted for transaction: " + transactionId);
            Thread.currentThread().interrupt();
        }
    }
}