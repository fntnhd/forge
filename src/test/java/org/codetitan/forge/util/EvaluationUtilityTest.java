package org.codetitan.forge.util;

import org.codetitan.forge.model.Tag;
import org.codetitan.forge.model.Entity;
import org.codetitan.forge.util.EvaluationUtility;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrews
 */
public class EvaluationUtilityTest {
    
    public EvaluationUtilityTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hasTagWithValue() {
        Entity e = new Entity();
        e.setName("Entity");
        Tag t = new Tag();
        t.setName("transient");
        t.setValue("true");
        e.addTag(t);
        
        assertTrue(EvaluationUtility.hasTagWithValue(e, "transient", "true"));
    }
}
