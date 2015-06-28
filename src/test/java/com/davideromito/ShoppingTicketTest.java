package com.davideromito;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShoppingTicketTest {

    ShoppingTicket st;

    @Before
    public void setUp() throws Exception {
        st = new ShoppingTicket();
    }

    @Test
    public void testPrintEmtpy() throws Exception {
        String expectedOutput = "Sales Taxes: 0\nTotal: 0\n";
        assertEquals(expectedOutput, st.print());
    }

    @Test
    public void testPrintOneItem() throws Exception {
        Item item = new Item("ITEM", 1, new BigDecimal(10.00), ItemType.OTHER, OriginItem.NOT_IMPORTED);
        st.setSingleItem(item);
        String expectedOutput = "1 ITEM : 11.00\nSales Taxes: 1.00\nTotal: 11.00\n";
        assertEquals(expectedOutput, st.print());
    }

    @Test
    public void testPrintTwoItems() throws Exception {
        Item item1 = new Item("ITEM1", 1, new BigDecimal(10.00), ItemType.OTHER, OriginItem.NOT_IMPORTED);
        Item item2 = new Item("ITEM2", 1, new BigDecimal(5.00), ItemType.BOOKS, OriginItem.IMPORTED);
        List<Item> list = Arrays.asList(item1, item2);
        st.setItemList(list);
        String expectedOutput = "1 ITEM1 : 11.00\n" + "1 ITEM2 : 5.25\n" + "Sales Taxes: 1.25\n" + "Total: 16.25\n";
        assertEquals(expectedOutput, st.print());
    }
}