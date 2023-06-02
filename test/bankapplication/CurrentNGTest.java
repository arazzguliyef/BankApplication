/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package bankapplication;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Araz
 */
public class CurrentNGTest {
    
    public CurrentNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
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
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
