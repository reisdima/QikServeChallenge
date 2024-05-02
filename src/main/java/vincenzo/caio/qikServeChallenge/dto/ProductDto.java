package vincenzo.caio.qikServeChallenge.dto;

import java.util.List;

public record ProductDto(String id, String name, Integer price, List<PromotionDto> promotions){
}
