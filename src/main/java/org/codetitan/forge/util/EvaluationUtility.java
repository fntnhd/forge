package org.codetitan.forge.util;

import org.apache.commons.lang.StringUtils;
import org.codetitan.forge.engine.Context;
import org.codetitan.forge.engine.TransformException;
import org.codetitan.forge.model.Boundary;
import org.codetitan.forge.model.Control;
import org.codetitan.forge.model.Element;
import org.codetitan.forge.model.Entity;
import org.codetitan.forge.model.Property;
import org.codetitan.forge.model.Type;

public class EvaluationUtility {

    static public boolean hasTagWithValue(Element element, String tagName, String tagValue) {
        return (element.hasTag(tagName) && element.getTagValue(tagName).equals(tagValue)) ? true : false;
    }
    
    static public boolean hasBooleanPropertyTag(Type type, String tagName) {
        Entity entity = (Entity) type;

        for (Property property : entity.getProperties()) {
            for (String key : property.getTags().keySet()) {
                if (tagName.equals(key) && !StringUtils.isBlank(property.getTagValue(tagName)) && ("yes".equals(property.getTagValue(tagName)) || Boolean.parseBoolean(property.getTagValue(tagName)))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static public boolean boolTag(Element element, String tagName){
        if(element.getTags().containsKey(tagName) && !StringUtils.isBlank(element.getTagValue(tagName)) && ("yes".equals(element.getTagValue(tagName)) || Boolean.parseBoolean(element.getTagValue(tagName)))){
            return true;
        }
        return false;
    }

    
    static public boolean hasOperations(Entity entity){
    	if(entity.getOperations().size() > 0){
    		return true;
    	}
    	return false;
    }
    
    static public boolean hasOperations(Control control){
    	if(control.getOperations().size() > 0){;
    		return true;
    	}
    	return false;
    }
    
    static public boolean hasOperations(Boundary boundry){
    	if(boundry.getOperations().size() > 0){;
    		return true;
    	}
    	return false;
    }
}
