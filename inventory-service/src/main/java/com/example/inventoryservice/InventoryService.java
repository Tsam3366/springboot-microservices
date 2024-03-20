package com.example.inventoryservice;

import com.example.inventoryservice.repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepo inventoryRepo;

    @Transactional(readOnly = true)
    public boolean inStock(String skucode) {
        return inventoryRepo.findBySkuCode(skucode).isPresent();
    }
}
