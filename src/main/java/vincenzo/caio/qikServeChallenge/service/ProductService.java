package vincenzo.caio.qikServeChallenge.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vincenzo.caio.qikServeChallenge.dto.ProductDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @Cacheable("products")
    public List<ProductDto> getAllProducts() {
        System.out.println("Fetching data...");
        String uri = env.getProperty("data.api") + productEndpoint;
        RestTemplate restTemplate = new RestTemplate();
        List<ProductDto> products = new ArrayList<>();
        ProductDto[] result = restTemplate.getForObject(uri, ProductDto[].class);
        if(result != null) {
            for (ProductDto product : result) {
                ProductDto fetchedProduct = restTemplate.getForObject(String.format("%s/%s", uri, product.id()), ProductDto.class);
                if(fetchedProduct != null) {
                    fetchedProduct = fetchedProduct.withPrice(BigDecimal.valueOf(fetchedProduct.price() / 100).setScale(2, RoundingMode.HALF_UP).doubleValue());
                    products.add(fetchedProduct);
                }
            }
        }
        System.out.println("Finished fetching");

        return products;
    }

    @Cacheable("product")
    public ProductDto getProductById(String id) {
        List<ProductDto> productsDto = getAllProducts();
        Optional<ProductDto> product = Optional.of(productsDto.stream().filter(p -> p.id().equals(id)).toList().get(0));
        return product.get();
    }
}
