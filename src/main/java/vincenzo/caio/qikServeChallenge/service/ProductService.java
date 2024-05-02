package vincenzo.caio.qikServeChallenge.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vincenzo.caio.qikServeChallenge.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private Environment env;

    private final String productEndpoint = "/products";

    public ProductService(Environment env) {
        this.env = env;
    }

    public List<ProductDto> getAllProducts() {
        String uri = env.getProperty("data.api") + productEndpoint;
        RestTemplate restTemplate = new RestTemplate();
        List<ProductDto> products = new ArrayList<>();
        System.out.println("URI: " + uri);
        ProductDto[] result = restTemplate.getForObject(uri, ProductDto[].class);
        for (ProductDto product : result) {
            products.add(restTemplate.getForObject(String.format("%s/%s", uri, product.id()), ProductDto.class));
        }
        System.out.println("Finished fetching");

        return products;
    }

    public ProductDto getProductById(String id) {
        List<ProductDto> productsDto = getAllProducts();
        Optional<ProductDto> product = Optional.of(productsDto.stream().filter(p -> p.id().equals(id)).toList().get(0));
        return product.get();
    }
}
