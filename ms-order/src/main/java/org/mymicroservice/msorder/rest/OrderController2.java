package org.mymicroservice.msorder.rest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderController2 {

    @PutMapping
    public String placeOrder(){
        return null;

    }

}
