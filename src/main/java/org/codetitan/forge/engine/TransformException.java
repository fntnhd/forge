package org.codetitan.forge.engine;

/**
 *
 * @author andrews
 */
public class TransformException extends Exception {

    public TransformException(String message, Exception e) {
        super(message, e);
    }

    public TransformException(String message) {
        super(message);
    }

}
