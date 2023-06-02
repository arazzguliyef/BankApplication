/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package bankapplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Araz
 */
public class CurrentTest {
    
    public CurrentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of deposit method, of class Current.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        int amount = 0;
        Current instance = null;
        instance.deposit(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class Current.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        int amount = 0;
        Current instance = null;
        instance.withdraw(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateBenefit method, of class Current.
     */
    @Test
    public void testCalculateBenefit() {
        System.out.println("calculateBenefit");
        Current instance = null;
        double expResult = 0.0;
        double result = instance.calculateBenefit();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
