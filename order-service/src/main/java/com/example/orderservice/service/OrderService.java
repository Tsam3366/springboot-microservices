package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItems;
import com.example.orderservice.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepo orderRepo;

    public void placeOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList = orderRequestDto.getOrderLineDtoList().stream()
                .map(e -> {
                    OrderLineItems orderLineItems = new OrderLineItems();
                    orderLineItems.setQuantity(e.getQuantity());
                    orderLineItems.setPrice(e.getPrice());
                    orderLineItems.setSkuCode(e.getSkuCode());
                    return orderLineItems;
                }).toList();
        order.setOrderLineItemsList(orderLineItemsList);
        orderRepo.save(order);
        log.info("Order Placed {}",order.getId());
    }
}
