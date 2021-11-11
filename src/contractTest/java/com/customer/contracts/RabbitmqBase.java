package com.customer.contracts;

import com.customer.app.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureMessageVerifier
@ActiveProfiles("contract-test")
public class RabbitmqBase {

    @Autowired
    EventPublisher eventPublisher;

    void publishEvent() {
        eventPublisher.publishEvent();
    }

}
