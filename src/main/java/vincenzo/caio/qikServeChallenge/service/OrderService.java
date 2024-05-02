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
        Order order = orderDto.order();
        if(order == null) {
            order = new Order();
        }
        ProductDto product = productService.getProductById(orderDto.item().id());
        order.addItem(ProductDto.toDomain(product), orderDto.item().quantity());
        return order;
    }
}
