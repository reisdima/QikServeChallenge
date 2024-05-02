package vincenzo.caio.qikServeChallenge.dto;

import vincenzo.caio.qikServeChallenge.model.Order;

public record OrderDto(Order order, OrderItemDto item){
}
