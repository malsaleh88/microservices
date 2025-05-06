package com.alsaleh.inventory_service.controller;


import com.alsaleh.inventory_service.dto.InventoryResponse;
import com.alsaleh.inventory_service.repository.InventoryRepository;
import com.alsaleh.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor

public class InventoryController {



    private final InventoryService inventoryService;
    private final InventoryRepository inventoryRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){

         return inventoryService.isInStock(skuCode);
    }



}
