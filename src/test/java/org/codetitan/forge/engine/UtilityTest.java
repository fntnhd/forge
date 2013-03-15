package org.codetitan.forge.engine;

import java.util.List;

import org.codetitan.forge.engine.Context;
import org.codetitan.forge.engine.TransformException;
import org.codetitan.forge.engine.UtilityInput;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilityTest {
    public UtilityTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getTemplateInput method, of class Context.
     */
    @Test
    public void testGetUtility() {
        System.out.println("getUtility");
        try{
            List<UtilityInput> utilities = Context.getUtilityInputs();
            assertEquals(utilities.size(), 1);
            UtilityInput utility = utilities.get(0);
            assertEquals("org.codetitan.forge.util.ExampleUtility", utility.getImpl());
            assertEquals("exampleUtil", utility.getName());
        }
        catch(TransformException e){
            fail("TransformationException thrown"+e);
        }
    }
}
