package com.example.inventoryservice;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repo.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepo)
{
	return  args -> {
		Inventory inventory=new Inventory();
		inventory.setQuantity(0);
		inventory.setSkuCode("I-Phone-13");
		inventoryRepo.save(inventory);

		Inventory inventory1=new Inventory();
		inventory1.setQuantity(1);
		inventory1.setSkuCode("Boat-Headset");
		inventoryRepo.save(inventory1);

	};
}
}
