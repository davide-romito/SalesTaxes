package com.davideromito;

import java.math.BigDecimal;

public interface Taxable {
    BigDecimal OTHER_PRODUCTS_TAX = new BigDecimal(0.1);
    BigDecimal IMPORTED_PRODUCTS_TAX = new BigDecimal(0.05);
    BigDecimal ROUND_VALUE = new BigDecimal("0.05");

    /**
     * This method return the value of the tax for the item
     *
     * @return the value of the tax
     */
    BigDecimal getTaxValue();
}
