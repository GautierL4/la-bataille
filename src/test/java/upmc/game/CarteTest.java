/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import junit.framework.TestCase;

/**
 *
 * @author sena-
 */
public class CarteTest extends TestCase {
    
    private Carte c1;
    private Carte c2;
    private Carte c3;
    private Carte c4;
    
    public CarteTest(String testName) {
        super(testName);
        this.c1 = new Carte("coeur",10);
        this.c2 = new Carte("trefle",7);
        this.c3 = new Carte("coeur",12);
        this.c4 = new Carte("pique",5);
    }

    /**
     * Test of compare method, of class Carte.
     */
    public void testCompare() {
        Carte result ;
        if(c1.getValue()>c2.getValue()){
            result = c1;
        }
        else{
            result = c2;
        }
        assertTrue("c1 est supérieur",c1.compare(c2)==result);
        if(c2.getValue()>c4.getValue()){
            result = c2;
        }
        else{
            result = c4;
        }
        assertTrue("c2 est supérieur",c4.compare(c2)==result);
    }

    
}
