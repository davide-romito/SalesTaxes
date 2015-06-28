package com.davideromito;

import java.math.BigDecimal;

/**
 * This class represent the tax object
 */
public class Tax implements Taxable {
    private BigDecimal tax;
    private ItemType itemType;
    private OriginItem itemOrigin;
    private BigDecimal itemPrice;

    public Tax(ItemType itemType, OriginItem itemOrigin, BigDecimal itemPrice) {
        this.itemType = itemType;
        this.itemOrigin = itemOrigin;
        this.itemPrice = itemPrice;
        calculateTax();
    }

    /**
     * This method calculate the value of the tax
     */
    private void calculateTax() {
        this.tax = BigDecimal.ZERO;
        if (itemType.equals(ItemType.OTHER)) {
            tax = tax.add(itemPrice.multiply(OTHER_PRODUCTS_TAX));
        }
        if (itemOrigin.equals(OriginItem.IMPORTED)) {
            tax = tax.add(itemPrice.multiply(IMPORTED_PRODUCTS_TAX));
        }
        this.tax = round(this.tax);
    }

    /**
     * This method round the value of the tax using the ROUND_VALUE
     */
    private BigDecimal round(BigDecimal value) {
        value = value.divide(ROUND_VALUE);
        value = new BigDecimal(Math.ceil(value.doubleValue()));
        return value.multiply(ROUND_VALUE);
    }

    public BigDecimal getTaxValue() {
        return tax;
    }
}
