package vincenzo.caio.qikServeChallenge.dto;

import vincenzo.caio.qikServeChallenge.model.OrderItem;
import vincenzo.caio.qikServeChallenge.model.Product;

public record OrderItemDto(ProductDto product, Integer quantity){
    public static OrderItemDto toDto(OrderItem orderItem) {
        return new OrderItemDto(
                ProductDto.fromProduct(orderItem.getProduct()),
                orderItem.getQuantity()
        );
    }

    public static OrderItem toDomain(OrderItemDto orderItem) {
        OrderItem item = new OrderItem();
        Product product = new Product();
        product.setId(orderItem.product.id());
        product.setName(orderItem.product.name());
        product.setPrice(orderItem.product.price());
        item.setProduct(product);
        item.setQuantity(orderItem.quantity());
        return item;
    }


}
