/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.tutorial;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import java.io.Serializable;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
@ComponentInfo(name="TutorialComponent01", category="TutorialPlugin/01")
public class TutorialComponent01 implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    public String doSomething() {
        return "Plugin works!";
    }
    
}
