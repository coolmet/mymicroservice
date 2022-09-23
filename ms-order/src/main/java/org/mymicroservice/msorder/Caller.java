package org.mymicroservice.msorder;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Caller implements CommandLineRunner {

    @Autowired
    private Callee callee;

    @Autowired
    private RetryRegistry retryRegistry;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Override
    public void run(String... args) throws Exception {
        Retry retry = retryRegistry.retry("accounting_retry");
        Retry.Metrics metrics = retry.getMetrics();
        RetryConfig retryConfig = retry.getRetryConfig();
        System.out.println("retry config : " + retryConfig.getMaxAttempts());
        retry.getEventPublisher()
                .onRetry(rr -> System.out.println(rr.toString()));
        CircuitBreaker accounting_cb = circuitBreakerRegistry.circuitBreaker("accounting_cb");
        accounting_cb.getEventPublisher()
                .onStateTransition(cbe -> System.out.println("State Changed : " + cbe.getStateTransition()));
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(500);
                String callme = callee.callme("c" + i);
                System.out.println(callme);
                System.out.println("index : " + i + " State : " + accounting_cb.getState());
                // System.out.println("Retry fail: " + metrics.getNumberOfFailedCallsWithRetryAttempt() + " success : " + metrics.getNumberOfSuccessfulCallsWithoutRetryAttempt() + " totalf : " + metrics.getNumberOfFailedCallsWithRetryAttempt());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
