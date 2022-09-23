package org.mymicroservice.msorder.integrations.accounting;

import org.mymicroservice.msorder.integrations.accounting.models.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("ACCOUNTING")
public interface IAccountIntegration {

    @PostMapping("/api/v1/payment/service/pay")
    public String payFeign(@RequestBody PaymentRequest paymentRequest);

}
