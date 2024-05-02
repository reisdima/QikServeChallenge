package vincenzo.caio.qikServeChallenge.dto;

import vincenzo.caio.qikServeChallenge.model.Promotion;
import vincenzo.caio.qikServeChallenge.model.PromotionEnum;

public record PromotionDto(String id, String type, Integer required_qty, Integer free_qty, Integer price, Integer amount) {

    public static PromotionDto fromPromotion(Promotion promotion) {
        return new PromotionDto(
                promotion.getId(),
                promotion.getPromotionType().name(),
                promotion.getRequiredQty(),
                promotion.getFreeQty(),
                promotion.getPrice(),
                promotion.getAmount()
        );
    }

    public static Promotion toDomain(PromotionDto promotionDto) {
        Promotion promotion = new Promotion();
        promotion.setId(promotionDto.id);
        promotion.setPromotionType(PromotionEnum.valueOf(promotionDto.type));
        promotion.setAmount(promotionDto.amount);
        promotion.setPrice(promotionDto.price);
        promotion.setRequiredQty(promotionDto.required_qty);
        promotion.setFreeQty(promotionDto.free_qty);
        return promotion;
    }
}
