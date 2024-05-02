package vincenzo.caio.qikServeChallenge.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public enum PromotionEnum {


    BUY_X_GET_Y_FREE {
        public double getUpdatedPrice(OrderItem item) {
            Promotion promotion = item.getProduct().getPromotions().get(0);
            if (item.getQuantity() >= promotion.getRequiredQty()) {
                Integer requiredQuantity = promotion.getRequiredQty();
                int amountForFree = promotion.getFreeQty() * (item.getQuantity() / requiredQuantity);
                double newPrice = item.getProduct().getPrice() * (item.getQuantity() - amountForFree);
                return newPrice;
            }

            return item.getProduct().getPrice() * item.getQuantity();
        }
    },
    FLAT_PERCENT {
        public double getUpdatedPrice(OrderItem item) {
            Promotion promotion = item.getProduct().getPromotions().get(0);
            double price = item.getProduct().getPrice() * item.getQuantity();
            double newPrice = price * ((100 - (double) promotion.getAmount()) / 100);
            newPrice = BigDecimal.valueOf(newPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
            return newPrice;
        }
    },
    QTY_BASED_PRICE_OVERRIDE {
        public double getUpdatedPrice(OrderItem item) {
            List<Promotion> promotions = item.getProduct().getPromotions();
            Promotion promotion = promotions.get(0);
            if (item.getQuantity() >= promotion.getRequiredQty()) {
                Integer quantity = item.getQuantity();
                Double productPrice = item.getProduct().getPrice();
                double newPrice = productPrice * (quantity % promotion.getRequiredQty());
                newPrice += (Math.floor((double) quantity / promotion.getRequiredQty())) * promotion.getPrice();
                return newPrice;
            }
            return item.getProduct().getPrice() * item.getQuantity();
        }
    };

    public abstract double getUpdatedPrice(OrderItem item);

}
