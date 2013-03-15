package org.codetitan.forge.util;

import java.util.Collection;

import org.codetitan.forge.engine.Context;
import org.codetitan.forge.engine.TransformException;
import org.codetitan.forge.model.Association;
import org.codetitan.forge.model.Boundary;
import org.codetitan.forge.model.Control;
import org.codetitan.forge.model.Entity;

/**
 * Provides utility methods for introspecting the model during transformation
 *
 * @author andrews
 */
public class ModelQuery {

    public static boolean isEntity(String type) throws TransformException {
        return Context.getModelManager().getModel().getEntity(type) != null;
    }

    public static boolean isEnumeration(String type) throws TransformException {
        return Context.getModelManager().getModel().getEnumeration(type) != null;
    }

    public static Collection<Entity> getEntities() throws TransformException {
        return Context.getModelManager().getModel().getEntities();
    }

    public static Collection<Control> getControls() throws TransformException {
        return Context.getModelManager().getModel().getControls();
    }

    public static Collection<Boundary> getBoundaries() throws TransformException {
        return Context.getModelManager().getModel().getBoundaries();
    }

    public static boolean hasManyManyOfType(Entity entity, String type) {
        for(Association a : entity.getManyToMany()) {
            if(type.equals(a.getEntity().getName())) {
                return true;
            }
        }

        return false;
    }

}
