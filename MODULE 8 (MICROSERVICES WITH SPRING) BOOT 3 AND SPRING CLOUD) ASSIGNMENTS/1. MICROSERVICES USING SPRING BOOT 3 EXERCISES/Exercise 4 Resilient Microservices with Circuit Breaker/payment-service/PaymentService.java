package com.example.paymentservice.service;

import com.example.paymentservice.client.ThirdPartyPaymentClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private ThirdPartyPaymentClient paymentClient;

    @CircuitBreaker(name = "thirdPartyApi", fallbackMethod = "paymentFallback")
    @Retry(name = "thirdPartyApi")
    public String processPayment(double amount) {
        LOGGER.info("Processing payment of amount: {}", amount);
        return paymentClient.processPayment(amount);
    }

    public String paymentFallback(double amount, Throwable throwable) {
        LOGGER.warn("Fallback triggered for payment amount: {}. Reason: {}", amount, throwable.getMessage());
        return "Payment service is currently unavailable. Please try again later. Amount: " + amount;
    }
}
