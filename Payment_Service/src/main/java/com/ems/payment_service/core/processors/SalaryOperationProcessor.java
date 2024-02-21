package com.ems.payment_service.core.processors;

import com.ems.payment_service.api.operations.salary.SalaryOperation;
import com.ems.payment_service.api.operations.salary.SalaryRequest;
import com.ems.payment_service.api.operations.salary.SalaryResponse;
import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;
import com.stripe.param.CustomerCreateParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class SalaryOperationProcessor implements SalaryOperation {
    @Value("${api.stripe.secret.key}")
    private String SECRET_KEY;

    @Value("${api.stripe.publishable.key}")
    private String PUBLISHABLE_KEY;

    @Override
    public SalaryResponse process(final SalaryRequest request) {
        StripeClient client = new StripeClient(SECRET_KEY);

        CustomerCreateParams params = CustomerCreateParams.builder()
                        .setDescription("Example description")
                        .setEmail("test@example.com")
                        .setPaymentMethod("pm_card_visa")  // obtained via Stripe.js
                        .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .setApiKey("sk_test_...")
                .setIdempotencyKey("a1b2c3...")
                .setStripeAccount("acct_...")
                .build();

        try {
            Customer customer = client.customers().create(params);

            client.customers().list(requestOptions);

            client.customers().retrieve("cus_123456789", requestOptions);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        StripeClient stripeClient = StripeClient.builder()
                .setMaxNetworkRetries(2)
                .build();

        RequestOptions options = RequestOptions.builder()
                .setMaxNetworkRetries(2)
                .build();

        try {
            client.customers().create(params, options);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

        RequestOptions optionsTimeout = RequestOptions.builder()
                .setConnectTimeout(30 * 1000) // in milliseconds
                .setReadTimeout(80 * 1000)
                .build();

        try {
            client.customers().create(params, options);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

////////////////////////////////////////////////////////////////////////////

        Token cardToken;

        try {
            cardToken = this.getCardToken(request);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

        Integer paymentPrice = Double.valueOf(request.getCartPrice() * 100).intValue();
        boolean isPaymentSuccessful;
        try {
            isPaymentSuccessful = this.isPaymentSuccessful(cardToken, paymentPrice);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

        return SalaryResponse.builder()
                .isSuccessful(isPaymentSuccessful)
                .build();
    }

    private Token getCardToken(SalaryRequest input) throws StripeException {
        Map<String, Object> cardData = new HashMap<>() {{
            put("number", input.getCardNumber());
            put("exp_month", input.getExpiryMonth());
            put("exp_year", input.getExpiryYear());
            put("cvc", input.getCvc());
        }};

        Map<String, Object> card = new HashMap<>() {{
            put("card", cardData);
        }};

        RequestOptions requestOptions = RequestOptions.builder().setApiKey(PUBLISHABLE_KEY).build();

        return Token.create(card, requestOptions);
    }

    private boolean isPaymentSuccessful(Token cardToken, Integer chargePrice) throws StripeException {
        Map<String, Object> params = new HashMap<>() {{
            put("amount", chargePrice);
            put("currency", "BGN");
            put("source", cardToken.getId());
        }};

        RequestOptions requestOptions = RequestOptions.builder().setApiKey(SECRET_KEY).build();
        return Charge.create(params, requestOptions).getPaid();

    }
}
