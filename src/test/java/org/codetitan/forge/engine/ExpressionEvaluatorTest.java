package org.codetitan.forge.engine;
import static org.junit.Assert.*;

import org.codetitan.forge.engine.ExpressionEvaluator;
import org.codetitan.forge.engine.TransformException;
import org.codetitan.forge.model.Entity;
import org.codetitan.forge.model.Tag;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpressionEvaluatorTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testSimpleExpression() throws TransformException {
    	Entity entity = new Entity();
    	entity.setName("Test");
    	
    	Tag tag = new Tag();
    	tag.setName("transient");
    	tag.setValue("true");

    	entity.addTag(tag);
    	
    	ExpressionEvaluator eval = ExpressionEvaluator.instance();
    	boolean result = eval.evaluateExpression("${type.hasTag('transient')}", entity);
    	boolean result2 = eval.evaluateExpression("!${type.hasTag('transient')}", entity);
    	assertTrue(result);
    	assertFalse(result2);
    }
    
    @Test
    public void testComplexExpression() throws TransformException {
    	Entity entity = new Entity();
    	entity.setName("Test");
    	
    	Tag tag = new Tag();
    	tag.setName("transient");
    	tag.setValue("true");

    	entity.addTag(tag);
    	
    	ExpressionEvaluator eval = ExpressionEvaluator.instance();
    	boolean result = eval.evaluateExpression("${type.hasTag('transient')} || ${type.hasTag('composite')}", entity);
    	boolean result2 = eval.evaluateExpression("!(${type.hasTag('transient')} || ${type.hasTag('composite')})", entity);
    	assertTrue(result);
    	assertFalse(result2);
    }
    
    @Test
    public void testUtilityExpression() throws TransformException {
    	Entity entity = new Entity();
    	entity.setName("Test");
    	
    	Tag tag = new Tag();
    	tag.setName("transient");
    	tag.setValue("true");

    	entity.addTag(tag);
    	
    	ExpressionEvaluator eval = ExpressionEvaluator.instance();
    	boolean result = eval.evaluateExpression("${evaluator.boolTag(type, 'transient')} || ${evaluator.boolTag(type, 'composite')}", entity);
    	assertTrue(result);
    }
}
