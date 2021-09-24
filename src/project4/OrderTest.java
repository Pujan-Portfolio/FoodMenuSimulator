package project4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test class for JUnit testing of our Order.add(),Order.remove(), and Order.getList().
 * @author Martin Colucci and Pujan Patel.
 */
class OrderTest {

    /**
     * JUnit test method for Order.add().
     */
    @Test
    void add()
    {
        Sandwich san1 = new Chicken();
        Sandwich san2 = new Beef();
        Sandwich san3 = new Fish();
        Order order = new Order();
        OrderLine temp;
        temp = new OrderLine(1, san1, san1.price());
        assertTrue(order.add(temp));
        temp = new OrderLine(2, san2, san2.price());
        assertTrue(order.add(temp));
        temp = new OrderLine(3, san3, san3.price());
        assertTrue(order.add(temp));

        String test1 = "Hello";
        String test2 = "Professor";
        assertFalse(order.add(test1));
        assertFalse(order.add(test2));
    }
    /**
     * JUnit test method for Order.remove().
     */
    @Test
    void remove()
    {
        Sandwich san1 = new Chicken();
        Sandwich san2 = new Beef();
        Sandwich san3 = new Fish();
        Order order = new Order();
        OrderLine temp;
        OrderLine temp2;
        OrderLine temp3;
        temp = new OrderLine(1, san1, san1.price());
        order.add(temp);
        temp2 = new OrderLine(2, san2, san2.price());
        order.add(temp2);
        temp3 = new OrderLine(3, san3, san3.price());
        order.add(temp3);

        assertTrue(order.remove(temp));
        assertTrue(order.remove(temp2));
        assertTrue(order.remove(temp3));

        assertTrue(order.remove(temp));
        assertTrue(order.remove(temp2));
        assertTrue(order.remove(temp3));

    }
    /**
     * JUnit test method for Order.getList().
     */
    @Test
    void getList()
    {
        Sandwich san1 = new Chicken();
        Sandwich san2 = new Beef();
        Sandwich san3 = new Fish();
        Order order = new Order();
        OrderLine temp;
        OrderLine temp2;
        OrderLine temp3;
        ArrayList<OrderLine> list = new ArrayList<OrderLine>();
        temp = new OrderLine(1, san1, san1.price());
        order.add(temp);
        list.add(temp);
        temp2 = new OrderLine(2, san2, san2.price());
        order.add(temp2);
        list.add(temp2);
        temp3 = new OrderLine(3, san3, san3.price());
        order.add(temp3);
        list.add(temp3);

        assertEquals(order.getList(), list);
        order.add(temp3);
        assertNotEquals(order.getList(), list);
    }
}