package com.davideromito;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class CaseTest {

    ShoppingTicket st;

    /**
     * Input 1:
     * 1 book at 12.49
     * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
     */
    @Test
    public void testInput1() throws Exception {
        st = new ShoppingTicket();
        Item book = new Item("book", 1, new BigDecimal(12.49), ItemType.BOOKS, OriginItem.NOT_IMPORTED);
        Item cd = new Item("music CD", 1, new BigDecimal(14.99), ItemType.OTHER, OriginItem.NOT_IMPORTED);
        Item chocolate = new Item("chocolate bar", 1, new BigDecimal(0.85), ItemType.FOOD, OriginItem.NOT_IMPORTED);
        st.setItemList(Arrays.asList(book, cd, chocolate));

        System.out.printf("Input 1:");
        System.out.println(st.print());
    }

    /**
     * Input 2:
     * 1 imported box of chocolates at 10.00
     * 1 imported bottle of perfume at 47.50
     */
    @Test
    public void testInput2() throws Exception {
        st = new ShoppingTicket();
        Item chocolate = new Item("imported box of chocolates", 1, new BigDecimal(10.00), ItemType.FOOD, OriginItem.IMPORTED);
        Item perfume = new Item("imported bottle of perfume", 1, new BigDecimal(47.50), ItemType.OTHER, OriginItem.IMPORTED);
        st.setItemList(Arrays.asList(chocolate, perfume));

        System.out.printf("Input 2:");
        System.out.println(st.print());
    }

    /**
     * Input 3:
     * 1 imported bottle of perfume at 27.99
     * 1 bottle of perfume at 18.99
     * 1 packet of headache pills at 9.75
     * 1 box of imported chocolates at 11.25
     */
    @Test
    public void testInput3() throws Exception {
        st = new ShoppingTicket();
        Item importedperfume = new Item("imported bottle of perfume", 1, new BigDecimal(27.99), ItemType.OTHER, OriginItem.IMPORTED);
        Item perfume = new Item("bottle of perfume", 1, new BigDecimal(18.99), ItemType.OTHER, OriginItem.NOT_IMPORTED);
        Item pills = new Item("packet of headache pills", 1, new BigDecimal(9.75), ItemType.MEDICAL, OriginItem.NOT_IMPORTED);
        Item chocolate = new Item("box of imported chocolates", 1, new BigDecimal(11.25), ItemType.FOOD, OriginItem.IMPORTED);
        st.setItemList(Arrays.asList(importedperfume, perfume, pills, chocolate));

        System.out.printf("Input 3:");
        System.out.println(st.print());
    }
}

