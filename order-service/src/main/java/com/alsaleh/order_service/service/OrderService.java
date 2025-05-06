package com.alsaleh.order_service.service;


import com.alsaleh.order_service.dto.InventoryResponse;
import com.alsaleh.order_service.dto.OrderLineItemDto;
import com.alsaleh.order_service.dto.OrderRequest;
import com.alsaleh.order_service.model.Order;
import com.alsaleh.order_service.model.OrderLineItmes;
import com.alsaleh.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest){

        Order order =new Order();
        order.setOrderNumber(UUID.randomUUID().toString());


         List<OrderLineItmes> orderLineItmes= orderRequest.getOrderLineItemDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();


        order.setOrderLineItmesList(orderLineItmes);

        List<String> skuCodes = order.getOrderLineItmesList().stream().map(OrderLineItmes::getSkuCode).toList();


       InventoryResponse[] inventoryResponArray= webClient.get()
                .uri("http://localhost:8082/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCodes",skuCodes).build())
                        .retrieve()
                                .bodyToMono(InventoryResponse[].class)
                                        .block();


       boolean allProductsInStock= Arrays.stream(inventoryResponArray).allMatch(inventoryResponse -> inventoryResponse.getIsInStock());

       if (allProductsInStock){
           orderRepository.save(order);
       }else
       {
           throw new IllegalArgumentException("Product is not in stock");
       }

    }
    private OrderLineItmes mapToDto(OrderLineItemDto orderLineItemDto){

        OrderLineItmes orderLineItmes=new OrderLineItmes();

        orderLineItmes.setPrice(orderLineItmes.getPrice());
        orderLineItmes.setQuantity(orderLineItmes.getQuantity());
        orderLineItmes.setSkuCode(orderLineItmes.getSkuCode());

        return orderLineItmes;

    }
}
