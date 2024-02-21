package com.ems.payment_service.core.processors;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${api.stripe.secret.key}")
    private String apiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = apiKey;
    }

    public void chargeEmployee(/*Employee employee*/) throws StripeException {
//        Map<String, Object> params = new HashMap<>();
//        params.put("amount", employee.getSalary().getAmount());
//        params.put("currency", "usd");
//        params.put("source", employee.getStripeCustomerId()); // can use a token here as well
//        params.put("description", "Monthly salary for employee: " + employee.getId());
//
//        Charge.create(params);
    }
}
