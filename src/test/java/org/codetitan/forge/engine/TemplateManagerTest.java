package org.codetitan.forge.engine;

import org.codetitan.forge.engine.Context;
import org.codetitan.forge.engine.Target;
import org.codetitan.forge.engine.TemplateManager;
import org.codetitan.forge.model.Stereotype;
import org.apache.velocity.Template;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrews
 */
public class TemplateManagerTest {

    public TemplateManagerTest() {
    }

    /**
     * Test of getTemplate method, of class TemplateManager.
     */
    @Test
    public void testGetTemplate() throws Exception {
        System.out.println("getTemplate");

        TemplateManager templateManager = new TemplateManager();

        Target target = Context.getTargets(Stereotype.entity).get(0);
        Template result = templateManager.getTemplate(target);
        assertNotNull(result);
    }
}
