package vincenzo.caio.qikServeChallenge.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private List<OrderItem> items;
    private Double normalPrice;
    private Double finalPrice;

    public void addItem(Product product, Integer quantity) {
        if(items == null) {
            items = new ArrayList<>();
        }
        // Verificar se produto já esta no carrinho
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        items.add(item);
        this.updatePrice();
    }

    public void updatePrice() {
        this.normalPrice = 0.0;
        this.finalPrice = 0.0;
        for (OrderItem item : items) {
            this.normalPrice += item.getProduct().getPrice() * item.getQuantity();
            item.updatePrice();
            this.finalPrice += item.getFinalPrice();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Double getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(Double normalPrice) {
        this.normalPrice = normalPrice;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
