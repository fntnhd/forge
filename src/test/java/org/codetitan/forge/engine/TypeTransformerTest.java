package org.codetitan.forge.engine;

import java.io.File;

import org.codetitan.forge.engine.*;
import org.codetitan.forge.model.Entity;
import org.codetitan.forge.model.Stereotype;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrews
 */
public class TypeTransformerTest {

    public TypeTransformerTest() {
    }

    /**
     * Test of transform method, of class TypeTransformer.
     */
    @Test
    public void testTransform() throws TransformException, OverwriteException {
        System.out.println("transform");


        Target target = Context.getTargets(Stereotype.entity).get(0);

        Entity entity = new Entity();
        entity.setName("Sample");

        File outputFile = TypeTransformer.transform(target, entity);
        assertTrue(outputFile.exists());

         outputFile.delete();
    }

}