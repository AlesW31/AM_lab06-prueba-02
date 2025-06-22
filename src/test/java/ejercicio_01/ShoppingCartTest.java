/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ejercicio_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alesw31
 */
public class ShoppingCartTest {
    private ShoppingCart carrito;
    public ShoppingCartTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        this.carrito= new ShoppingCart();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
 
    //HAPPY PATHS
    /**
     * Test of addProduct method, of class ShoppingCart.
     */
    @org.junit.jupiter.api.Test
    public void testAddProduct() {
        carrito.addProduct(10.0);
        assertEquals(1,carrito.getProductCount());
    }

    /**
     * Test of removeProduct method, of class ShoppingCart.
     */
    @org.junit.jupiter.api.Test
    public void testRemoveProduct() {
        carrito.addProduct(5.0);
        carrito.addProduct(4.0);
        carrito.removeProduct(5.0);
        assertEquals(1,carrito.getProductCount());
    }

    /**
     * Test of getTotal method, of class ShoppingCart.
     */
    @org.junit.jupiter.api.Test
    public void testGetTotal() {
        carrito.addProduct(5.0);
        carrito.addProduct(4.0);
        assertEquals(9,carrito.getTotal());
    }

    //UNHAPPY PATHS
    @org.junit.jupiter.api.Test
    public void testAddProductNegativePrice() {
        try {
            carrito.addProduct(-5.0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Price must be positive", e.getMessage());
        }
    }
    @org.junit.jupiter.api.Test
    public void testRemoveNonExistentProduct() {
        carrito.addProduct(10.0);
        carrito.removeProduct(99.0); // no está
        assertEquals(1, carrito.getProductCount()); // no cambia
    }
}
