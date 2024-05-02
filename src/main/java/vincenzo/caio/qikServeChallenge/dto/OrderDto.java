package vincenzo.caio.qikServeChallenge.dto;

import vincenzo.caio.qikServeChallenge.model.Order;

import java.util.List;

public record OrderDto(List<OrderItemDto> items, Double normalPrice, Double finalPrice){

    public static OrderDto fromDomain(Order order) {
        return new OrderDto(
               order.getItems().stream().map(OrderItemDto::toDto).toList(),
               order.getNormalPrice(),
               order.getFinalPrice()
        );
    }

    public static Order toDomain(OrderDto orderDto) {
        Order order = new Order();
        order.setNormalPrice(orderDto.normalPrice);
        order.setFinalPrice(orderDto.finalPrice);
        order.setItems(orderDto.items.stream().map(OrderItemDto::toDomain).toList());
        return order;
    }
}
