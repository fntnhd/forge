/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.codetitan.forge.adapter;

public class AdapterException extends Exception {

    public AdapterException(String message, Exception e) {
        super(message, e);
    }

    public AdapterException(String message) {
        super(message);
    }

}