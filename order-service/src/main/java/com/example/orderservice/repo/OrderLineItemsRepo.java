package com.example.orderservice.repo;

import com.example.orderservice.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemsRepo extends JpaRepository<OrderLineItems,Long> {
}
