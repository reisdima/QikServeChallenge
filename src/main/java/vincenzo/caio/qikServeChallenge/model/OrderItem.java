package vincenzo.caio.qikServeChallenge.model;

public class OrderItem {

    private Product product;
    private Integer quantity;
    private double finalPrice;
    private String promotionApplied;

    public void updatePrice() {
        double price = product.getPrice() * this.quantity;
        String promotionApplied = "";
        for (Promotion promotion : product.getPromotions()) {
            double newPrice = promotion.getPromotionType().getUpdatedPrice(this);
            if(newPrice < price) {
                promotionApplied = promotion.getId();
                price = newPrice;
            }
        }
        this.finalPrice = price;
        this.promotionApplied = promotionApplied;
    }

    public String getPromotionApplied() {
        return promotionApplied;
    }

    public void setPromotionApplied(String promotionApplied) {
        this.promotionApplied = promotionApplied;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
