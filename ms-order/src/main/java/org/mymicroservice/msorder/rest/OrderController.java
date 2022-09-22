package org.mymicroservice.msorder.rest;

import org.mymicroservice.msorder.obj.mappings.OrderMapping;
import org.mymicroservice.msorder.rest.error.ErrorObj;
import org.mymicroservice.msorder.rest.models.OrderRest;
import org.mymicroservice.msorder.rest.models.OrderResult;
import org.mymicroservice.msorder.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public OrderResult placeOrder(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null) {
            throw new IllegalArgumentException("customer name null olamaz");
        }
        String s = orderService.placeOrder(OrderMapping.ORDER_MAPPING.toOrder(orderRest));
        return new OrderResult().setDesc("order alındı : " + s)
                .setOrderId(10L);
    }

    @PostMapping("/place0")
    public OrderResult placeOrder0(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null) {
            throw new IllegalArgumentException("customer name null olamaz");
        }
        String s = orderService.placeOrder0(OrderMapping.ORDER_MAPPING.toOrder(orderRest));
        return new OrderResult().setDesc("order alındı : " + s)
                .setOrderId(10L);
    }

    @PostMapping("/place1")
    public OrderResult placeOrder1(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null) {
            throw new IllegalArgumentException("customer name null olamaz");
        }
        String s = orderService.placeOrder1(OrderMapping.ORDER_MAPPING.toOrder(orderRest));
        return new OrderResult().setDesc("order alındı : " + s)
                .setOrderId(10L);
    }

    @PostMapping("/place2")
    public OrderResult placeOrder2(@Valid @RequestBody OrderRest orderRest) {
        if (orderRest.getCustomerName() == null) {
            throw new IllegalArgumentException("customer name null olamaz");
        }
        String s = orderService.placeOrder2(OrderMapping.ORDER_MAPPING.toOrder(orderRest));
        return new OrderResult().setDesc("order alındı : " + s)
                .setOrderId(10L);
    }

    @PostMapping("/cancel/{oid}")
    public String cancelOrder(@PathVariable("oid") Long orderId) {
        return "Order canceled : " + orderId;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exception) {
        return new ErrorObj().setMicroservice("ms-order")
                .setDesc("test error : " + exception.getMessage())
                .setCode(1024);
    }

}
