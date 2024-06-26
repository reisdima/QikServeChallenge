package vincenzo.caio.qikServeChallenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vincenzo.caio.qikServeChallenge.dto.AddToOrderDto;
import vincenzo.caio.qikServeChallenge.dto.OrderDto;
import vincenzo.caio.qikServeChallenge.model.Order;
import vincenzo.caio.qikServeChallenge.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addItem")
    public ResponseEntity<OrderDto> addProduct (@RequestBody AddToOrderDto addToOrderDto) {
        Order order = orderService.addProductToOrder(addToOrderDto);
        return ResponseEntity.status(HttpStatus.OK).body(OrderDto.fromDomain(order));
    }
}
