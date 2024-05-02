package vincenzo.caio.qikServeChallenge.model;

import java.util.List;

public enum PromotionEnum {


    BUY_X_GET_Y_FREE {
        public double getUpdatedPrice(OrderItem item) {
            Promotion promotion = item.getProduct().getPromotions().get(0);
            if (item.getQuantity() >= promotion.getRequiredQty()) {
                Integer requiredQuantity = promotion.getRequiredQty();
                int amountForFree = promotion.getFreeQty() * (item.getQuantity() / requiredQuantity);
                double newPrice = item.getProduct().getPrice() * (item.getQuantity() - amountForFree);
                System.out.println("A quantidade de graça apra " + item.getQuantity() + " item é " + amountForFree);
                return newPrice;
            }

            return item.getProduct().getPrice() * item.getQuantity();
        }
    },
    FLAT_PERCENT {
        public double getUpdatedPrice(OrderItem item) {
            Promotion promotion = item.getProduct().getPromotions().get(0);
            double newPrice = item.getProduct().getPrice() * ((double) promotion.getAmount() / 100);
            System.out.println("The price was " + item.getProduct().getPrice()+ ". Applied " + promotion.getAmount() + " percent and now is " + newPrice);
            return newPrice;
        }
    },
    QTY_BASED_PRICE_OVERRIDE {
        // Testar com
        // 2, 2
        // 1, 2
        // 4, 3
        // 4, 2
        public double getUpdatedPrice(OrderItem item) {
            List<Promotion> promotions = item.getProduct().getPromotions();
            Promotion promotion = promotions.get(0);
            if (promotion.getRequiredQty() >= item.getQuantity()) {
                Integer quantity = item.getQuantity();
                Integer productPrice = item.getProduct().getPrice();
                double newPrice = productPrice * (quantity % promotion.getRequiredQty());
                newPrice += ((double) quantity / promotion.getRequiredQty()) * promotion.getPrice();
                System.out.println("The price was " + item.getProduct().getPrice() + " with " + quantity + ". Now is " + newPrice);
                return newPrice;
            }
            return item.getProduct().getPrice() * item.getQuantity();
        }
    };

    public abstract double getUpdatedPrice(OrderItem item);

}
