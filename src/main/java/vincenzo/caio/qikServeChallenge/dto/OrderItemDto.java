package vincenzo.caio.qikServeChallenge.dto;

import vincenzo.caio.qikServeChallenge.model.OrderItem;
import vincenzo.caio.qikServeChallenge.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record OrderItemDto(ProductDto product, Integer quantity) {

    public static OrderItemDto toDto(OrderItem orderItem) {
        return new OrderItemDto(
                ProductDto.toDto(orderItem.getProduct()),
                orderItem.getQuantity()
        );
    }

    public static OrderItem toDomain(OrderItemDto orderItem) {
        OrderItem item = new OrderItem();
        Product product = new Product();
        product.setId(orderItem.product.id());
        product.setName(orderItem.product.name());
//        product.setPrice(BigDecimal.valueOf(orderItem.product.price() / 100).setScale(2, RoundingMode.HALF_UP).doubleValue());
        product.setPrice(orderItem.product.price());
        product.setPromotions(orderItem.product.promotions().stream().map(PromotionDto::toDomain).toList());
        item.setProduct(product);
        item.setQuantity(orderItem.quantity());
        return item;
    }


}
