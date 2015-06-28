package com.davideromito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the ticket
 */
public class ShoppingTicket {
    private List<Item> itemList;
    private BigDecimal totalTax;
    private BigDecimal total;

    public ShoppingTicket() {
        this.itemList = new ArrayList<Item>();
        this.totalTax = BigDecimal.ZERO;
        this.total = BigDecimal.ZERO;
    }

    /**
     * Method return the output of the ticket calculating the taxes
     *
     * @return a string representing the ticket to print
     */
    public String print() {
        StringBuffer sb = new StringBuffer();
        for (Item item : itemList) {
            sb.append(item.toString());
            calculateTotal(item.getPrice(), item.getTax().getTaxValue());
        }
        sb.append("Sales Taxes: ").append(this.totalTax.toString()).append("\n");
        sb.append("Total: ").append(this.total.toString()).append("\n");
        return sb.toString();
    }

    /**
     * Calculate the final price of the ticket
     *
     * @param price     of the item
     * @param taxAmount of the item
     */
    private void calculateTotal(BigDecimal price, BigDecimal taxAmount) {
        calculateTotalTax(taxAmount);
        this.total = this.total.add(price).add(taxAmount);
    }

    /**
     * Calculate the final amount of the total taxes
     *
     * @param taxAmount of the item
     */
    private void calculateTotalTax(BigDecimal taxAmount) {
        this.totalTax = this.totalTax.add(taxAmount);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setSingleItem(Item item) {
        this.itemList.add(item);
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
