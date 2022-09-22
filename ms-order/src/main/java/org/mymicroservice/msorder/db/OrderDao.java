package org.mymicroservice.msorder.db;

import org.mymicroservice.msorder.models.Order;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderDao {
    private AtomicLong atomicLong = new AtomicLong();
    public void insertOrder(Order order){
        order.setOrderId(atomicLong.incrementAndGet());
        // Db
    }

}
