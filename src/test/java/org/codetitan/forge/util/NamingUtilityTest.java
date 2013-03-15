package org.codetitan.forge.util;

import org.codetitan.forge.util.NamingUtility;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrews
 */
public class NamingUtilityTest {

    public NamingUtilityTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of addSpacerToCamelCase method, of class AtlasStringUtils.
     */
    @Test
    public void testAddSpacerToCamelCase() {
        System.out.println("addSpacerToCamelCase");
        String input = "thisIsATest";
        String spacer = "_";
        String expResult = "this_Is_A_Test";
        String result = NamingUtility.addSpacerToCamelCase(input, spacer);
        assertEquals(expResult, result);

        input = "test";
        expResult = "test";
        result = NamingUtility.addSpacerToCamelCase(input, spacer);
        assertEquals(expResult, result);

    }

    /**
     * Test of addSpacerToCamelCase method, of class AtlasStringUtils.
     */
    @Test
    public void testAddSpacerToCamelCaseUpper() {
        System.out.println("addSpacerToCamelCaseUpper");
        String input = "thisIsATest";
        String spacer = "_";
        String expResult = "THIS_IS_A_TEST";
        String result = NamingUtility.addSpacerToCamelCaseUpper(input, spacer);
        assertEquals(expResult, result);

        input = "test";
        expResult = "TEST";
        result = NamingUtility.addSpacerToCamelCaseUpper(input, spacer);
        assertEquals(expResult, result);

    }


}