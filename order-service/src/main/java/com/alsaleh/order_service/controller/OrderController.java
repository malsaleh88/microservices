package com.alsaleh.order_service.controller;


import com.alsaleh.order_service.dto.OrderRequest;
import com.alsaleh.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){


        orderService.placeOrder(orderRequest);
        return "Order Passed Succefully";
    }
}
