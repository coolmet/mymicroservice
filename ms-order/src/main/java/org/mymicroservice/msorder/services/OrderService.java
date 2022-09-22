package org.mymicroservice.msorder.services;

import org.mymicroservice.msorder.db.OrderDao;
import org.mymicroservice.msorder.integrations.accounting.AccountingIntegration;
import org.mymicroservice.msorder.integrations.accounting.models.PaymentRequest;
import org.mymicroservice.msorder.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountingIntegration accountingIntegration;

    public String placeOrder(Order order) {
        orderDao.insertOrder(order);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(1L);
        paymentRequest.setAmount(100.0F);
        paymentRequest.setOrderId(order.getOrderId());

        // ...
        return accountingIntegration.pay(paymentRequest);
    }

    public String placeOrder0(Order order) {
        orderDao.insertOrder(order);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(1L);
        paymentRequest.setAmount(100.0F);
        paymentRequest.setOrderId(order.getOrderId());

        // ...
        return accountingIntegration.pay0(paymentRequest);
    }

    public String placeOrder1(Order order) {
        orderDao.insertOrder(order);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(1L);
        paymentRequest.setAmount(100.0F);
        paymentRequest.setOrderId(order.getOrderId());

        // ...
        return accountingIntegration.pay1(paymentRequest);
    }
    public String placeOrder2(Order order) {
        orderDao.insertOrder(order);
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(1L);
        paymentRequest.setAmount(100.0F);
        paymentRequest.setOrderId(order.getOrderId());

        // ...
        return accountingIntegration.pay2(paymentRequest);
    }
}
