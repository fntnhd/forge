package org.codetitan.forge.engine;

import org.codetitan.forge.engine.*;
import org.codetitan.forge.model.Stereotype;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrews
 */
public class ContextTest {

    public ContextTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void getProperties() throws TransformException {
        System.out.println("getProperties");

        assertEquals("target/testoutput", Context.getProperty("generated.source.root"));
        assertEquals("src/test/resources", Context.getProperty("test.resource.root"));
        assertEquals("org.codetitan.forge.test", Context.getProperty("namespace"));

    }

    /**
     * Test of getTemplateInput method, of class Context.
     */
    @Test
    public void getTemplates() throws TransformException {
        System.out.println("getTemplates");
        String expResult = "src/test/resources/templates";
        String result = Context.getTemplates();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModelInputs method, of class Context.
     */
    @Test
    public void getModels() throws TransformException {
        System.out.println("getModels");
        String expResult = "src/test/resources/project.xml";
        List<ModelInput> result = null;
        result = Context.getModelInputs();
        assertEquals(1, result.size());
        assertEquals(expResult, result.get(0).getFile());
    }


    /**
     * Test of getPrimitives method, of class Context.
     */
    @Test
    public void getPrimitives() throws TransformException {
        System.out.println("getPrimitives");
        String expResult = "src/test/resources/primitives.xml";
        String result = Context.getPrimitives();
        assertEquals(expResult, result);
    }

    @Test
    public void getUtility() throws TransformException {
        System.out.println("getUtility");
        UtilityInput u = Context.getUtilityInputs().get(0);
        assertEquals("exampleUtil", u.getName());
        assertEquals("org.codetitan.forge.util.ExampleUtility", u.getImpl());
        assertNotNull(Context.getUtility("naming"));
    }

    @Test
    public void getTarget() throws TransformException {
        System.out.println("getTargets");

        List<Target> targets = Context.getTargets(Stereotype.entity);

        assertEquals(1, targets.size());

        Target t = targets.get(0);
        assertEquals("entity", t.getName());
        assertEquals(Stereotype.entity, t.getTargetStereotype());
        assertEquals("entity.vm", t.getTemplate());
        assertEquals("${name}.xml", t.getOutputFile());
        assertEquals("org.codetitan.forge.test.entity", t.getProperty("namespace"));
        assertTrue(Boolean.valueOf(t.getOverwrite()));
    }
}
