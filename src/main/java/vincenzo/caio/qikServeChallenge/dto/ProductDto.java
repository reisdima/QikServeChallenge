package vincenzo.caio.qikServeChallenge.dto;

import vincenzo.caio.qikServeChallenge.model.Product;

import java.util.List;

public record ProductDto(String id, String name, Double price, List<PromotionDto> promotions){

    public ProductDto withPrice(Double price) {
        return new ProductDto(id(), name(), price, promotions());
    }

    public static ProductDto toDto(Product product ){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getPromotions().stream().map(PromotionDto::fromPromotion).toList()
        );
    }
    public static Product toDomain(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.id);
        product.setName(productDto.name);
        product.setPrice(productDto.price);
        product.setPromotions(productDto.promotions.stream().map(PromotionDto::toDomain).toList());
        return product;
    }
}
