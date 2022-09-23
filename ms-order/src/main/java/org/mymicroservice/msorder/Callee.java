package org.mymicroservice.msorder;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
public class Callee {

    private int counter = 0;

    // @Retry(name = "accounting_retry",fallbackMethod = "callmeFallback")
    @CircuitBreaker(name = "accounting_cb",fallbackMethod = "callmeFallback")
    public String callme(String str) {
        counter++;
        if (counter < 22) {
            if ((counter % 2) == 0) {
                System.out.println("Throwing : " + counter);
                throw new IllegalArgumentException("test1");
            }
        }
        return "Hello " + str + " counter : " + counter;
    }

    public String callmeFallback(String str,Throwable throwable) {
        return "Fallbacked Hello " + str;
    }

}
