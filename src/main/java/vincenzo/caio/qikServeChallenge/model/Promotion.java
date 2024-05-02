package vincenzo.caio.qikServeChallenge.model;

import vincenzo.caio.qikServeChallenge.model.strategy.Parameter;

import java.util.List;

public class Promotion {

    private String id;
    private PromotionEnum promotionType;
    private List<Parameter> parameters;
    private Integer requiredQty;
    private Integer freeQty;
    private Integer price;
    private Integer amount;

    public Integer getRequiredQty() {
        return requiredQty;
    }

    public void setRequiredQty(Integer requiredQty) {
        this.requiredQty = requiredQty;
    }

    public Integer getFreeQty() {
        return freeQty;
    }

    public void setFreeQty(Integer freeQty) {
        this.freeQty = freeQty;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PromotionEnum getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionEnum promotionType) {
        this.promotionType = promotionType;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
