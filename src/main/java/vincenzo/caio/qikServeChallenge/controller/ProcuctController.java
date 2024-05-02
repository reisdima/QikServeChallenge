package vincenzo.caio.qikServeChallenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vincenzo.caio.qikServeChallenge.dto.ProductDto;
import vincenzo.caio.qikServeChallenge.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProcuctController {

    private final ProductService productService;

    public ProcuctController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(products);
    }


}
