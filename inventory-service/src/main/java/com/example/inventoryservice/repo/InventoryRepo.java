package com.example.inventoryservice.repo;

import com.example.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findBySkuCode(String skucode);

    List<Inventory> findBySkuCodeIn(List<String> skucode);
}
