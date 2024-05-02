package vincenzo.caio.qikServeChallenge.service;

import org.springframework.stereotype.Service;
import vincenzo.caio.qikServeChallenge.dto.AddToOrderDto;
import vincenzo.caio.qikServeChallenge.dto.ProductDto;
import vincenzo.caio.qikServeChallenge.dto.OrderDto;
import vincenzo.caio.qikServeChallenge.model.Order;

@Service
public class OrderService {

    ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public Order addProductToOrder(AddToOrderDto addToOrderDto) {
        Order order;
        if (addToOrderDto.order() == null || addToOrderDto.order().items() == null || addToOrderDto.order().items().isEmpty()) {
            order = new Order();
        } else {
            order = OrderDto.toDomain(addToOrderDto.order());
        }
        ProductDto product = productService.getProductById(addToOrderDto.item().product().id());
        order.addItem(ProductDto.toDomain(product), addToOrderDto.item().quantity());
        return order;
    }
}
