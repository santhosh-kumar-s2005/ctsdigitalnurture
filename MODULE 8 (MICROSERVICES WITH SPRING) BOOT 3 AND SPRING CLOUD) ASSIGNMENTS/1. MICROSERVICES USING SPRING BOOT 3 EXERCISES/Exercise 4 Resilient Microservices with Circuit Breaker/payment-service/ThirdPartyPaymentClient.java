package com.example.paymentservice.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ThirdPartyPaymentClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdPartyPaymentClient.class);

    private final WebClient webClient;

    public ThirdPartyPaymentClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://third-party-payment.example.com").build();
    }

    public String processPayment(double amount) {
        LOGGER.info("Calling third-party payment API for amount: {}", amount);
        return webClient.post()
                .uri("/process")
                .bodyValue("{\"amount\":" + amount + "}")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
