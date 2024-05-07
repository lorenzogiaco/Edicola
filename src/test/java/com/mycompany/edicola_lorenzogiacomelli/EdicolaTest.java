/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.edicola_lorenzogiacomelli;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
public class EdicolaTest {
    
    Edicola e;
    
    public EdicolaTest() 
    {
        e=new Edicola();
    }
    
    /**
     * Test of getNUM_MAX_GIORNALE method, of class Edificio.
     */
    @Test
    public void testGetNUM_MAX_GIORNALE() 
    {
        System.out.println("getNUM_MAX_GIORNALE");
        Edicola e2 = new Edicola();
        int max = 1000;
        int result = e2.getNUM_MAX_GIORNALE();
        assertEquals(max, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of getnGiornaliPresenti method, of class Edificio.
     */
    @Test
    public void testGetnGiornaliPresenti() 
    {
        System.out.println("getnGiornaliPresenti");
        Edicola instance = new Edicola();
        int expResult = 1;
        int result = instance.getnGiornalePresenti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGiornale method, of class Edificio.
     */
    @Test
    public void testGetGiornale() 
    {
        System.out.println("getGiornale");
        int posizione = 0;
        Edicola instance = new Edicola();
        Giornale expResult = null;
        Giornale result = instance.getGiornale(posizione);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetId method, of class Edificio.
     */
    @Test
    public void testGetId() 
    {
        System.out.println("getId");
        int posizione = 0;
        Edicola instance = new Edicola();
        int expResult = 0;
        int result = instance.getId(posizione);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumGiornali method, of class Edificio.
     */
    @Test
    public void testGetNumGiornali() 
    {
        System.out.println("getNumGiornali");
        Edicola instance = new Edicola();
        int expResult = 0;
        int result = instance.getNumGiornale();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
}