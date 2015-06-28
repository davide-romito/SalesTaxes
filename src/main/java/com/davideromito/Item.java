package com.davideromito;

import java.math.BigDecimal;

/**
 * Class that represent the item
 */
public class Item {
    private String itemName;
    private Integer quantity;
    private BigDecimal price;

    private ItemType type;
    private OriginItem origin;

    private Taxable tax;

    public Item(String itemName, Integer quantity, BigDecimal price, ItemType type, OriginItem origin) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.type = type;
        this.origin = origin;
        this.tax = new Tax(type, origin, price);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public OriginItem getOrigin() {
        return origin;
    }

    public void setOrigin(OriginItem origin) {
        this.origin = origin;
    }

    public Taxable getTax() {
        return tax;
    }

    public void setTax(Taxable tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return this.quantity + " " + this.itemName + " : " + this.price.add(this.tax.getTaxValue()).toString() + "\n";
    }
}
