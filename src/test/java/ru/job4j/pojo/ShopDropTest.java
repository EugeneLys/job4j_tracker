package ru.job4j.pojo;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ShopDropTest {
    @Test
    public void whenDropFirst() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.delete(products, 0);
        Assertions.assertEquals(rsl[0].getName(), "Bread");
        Assertions.assertNull(rsl[1]);
    }

    @Test
    public void whenDropLast() {
        Product[] products = new Product[2];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        Product[] rsl = ShopDrop.delete(products, 1);
        Assertions.assertEquals(rsl[0].getName(), "Milk");
        Assertions.assertNull(rsl[1]);
    }

    @Test
    public void whenArrayLengthIs4AndDeleteElementWithIndex1() {
        Product[] products = new Product[4];
        products[0] = new Product("Bread", 4);
        products[1] = new Product("Egg", 10);
        products[2] = new Product("Milk", 2);
        products[3] = new Product("Fish", 3);
        int index = 1;
        Product[] rsl = ShopDrop.delete(products, index);
        Assertions.assertEquals(rsl[index].getName(), "Milk");
        Assertions.assertEquals(rsl[2].getName(), "Fish");
        Assertions.assertNull(rsl[products.length - 1]);
    }

    @Test
    public void whenArrayLengthIs5AndDeleteElementWithIndex2() {
        Product[] products = new Product[5];
        products[0] = new Product("Bread", 4);
        products[1] = new Product("Egg", 10);
        products[2] = new Product("Milk", 2);
        products[3] = new Product("Fish", 3);
        products[4] = new Product("Fruit", 8);
        int index = 2;
        Product[] rsl = ShopDrop.delete(products, index);
        Assertions.assertEquals(rsl[1].getName(), "Egg");
        Assertions.assertEquals(rsl[index].getName(), "Fish");
        Assertions.assertEquals(rsl[3].getName(), "Fruit");
        Assertions.assertNull(rsl[products.length - 1]);
    }
}