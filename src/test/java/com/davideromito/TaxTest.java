package com.davideromito;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxTest {
    Taxable tax;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCalculateNoTax() throws Exception {
        tax = new Tax(ItemType.BOOKS, OriginItem.NOT_IMPORTED, new BigDecimal(10));
        assertEquals(tax.getTaxValue(), new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testCalculateAllTax() throws Exception {
        tax = new Tax(ItemType.OTHER, OriginItem.IMPORTED, new BigDecimal(10));
        assertEquals(tax.getTaxValue(), new BigDecimal(1.50).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testCalculateImportedTax() throws Exception {
        tax = new Tax(ItemType.MEDICAL, OriginItem.IMPORTED, new BigDecimal(10));
        assertEquals(tax.getTaxValue(), new BigDecimal(0.50).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testCalculateTax() throws Exception {
        tax = new Tax(ItemType.OTHER, OriginItem.NOT_IMPORTED, new BigDecimal(10));
        assertEquals(tax.getTaxValue(), new BigDecimal(1.00).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}