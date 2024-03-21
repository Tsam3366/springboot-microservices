package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepo inventoryRepo;

    @Transactional(readOnly = true)
    public List<InventoryResponse> inStock(List<String> skucode) {

        return inventoryRepo.findBySkuCodeIn(skucode).stream()
                .map(inventory ->
                        InventoryResponse.builder().inStock(inventory.getQuantity() > 0).skucode(inventory.getSkuCode()).build()
                    ).toList();
    }
}
