package org.mymicroservice.msorder;

import org.mymicroservice.msorder.models.Order;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status(Status.UP)
                .withDetail("myh",
                        new Order())
                .build();
    }
}
