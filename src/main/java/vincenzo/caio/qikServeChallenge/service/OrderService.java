package vincenzo.caio.qikServeChallenge.service;

import org.springframework.stereotype.Service;
import vincenzo.caio.qikServeChallenge.dto.ProductDto;
import vincenzo.caio.qikServeChallenge.dto.OrderDto;
import vincenzo.caio.qikServeChallenge.model.Order;

@Service
public class OrderService {

    ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public Order addProductToOrder(OrderDto orderDto) {
        Order order;
        if(orderDto.items() == null || orderDto.items().isEmpty()) {
            order = new Order();
        } else {
            order = OrderDto.toDomain(orderDto);
        }
        ProductDto product = productService.getProductById(orderDto.item().product().id());
        order.addItem(ProductDto.toDomain(product), orderDto.item().quantity());
        return order;
    }
}
