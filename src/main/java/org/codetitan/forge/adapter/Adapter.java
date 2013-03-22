package org.codetitan.forge.adapter;

import java.io.File;

import org.codetitan.forge.model.Model;

/**
 * Responsible for reading in a source model and normalizing it to the Forge metamodel
 *
 * @author andrews
 */
public interface Adapter {

    public Model adapt(File file, Model model) throws AdapterException;

}
