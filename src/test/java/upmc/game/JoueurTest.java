/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author sena-
 */
public class JoueurTest extends TestCase {
    private Joueur j1 ;
    private Joueur j2 ;
    private Carte c1 = new Carte("coeur",10);
    private Carte c2 = new Carte ("pique",7);
    private Carte c3 = new Carte("carreaux",12);
    private Carte c4 = new Carte("trefle",8);
    private Carte c5 = new Carte("pique",3);
    private Carte c6 = new Carte("coeur",6);
    
    public JoueurTest(String testName) {
        super(testName);
        this.j1 = new Joueur("Stephane");
        this.j2 = new Joueur("Gautier");
        this.j1.addCarte(c1);
        this.j2.addCarte(c1);
    }

    /**
     * Test of getSizeMains method, of class Joueur.
     */
    public void testGetSizeMains() {
        int size = j1.Mains.size();
        assertEquals(size,j1.getSizeMains());
    }

    /**
     * Test of roundWon method, of class Joueur.
     * @param c1
     * @param c2
     */
    public void testRoundWon(Carte c1,Carte c2) {
        int score = j1.getScoreCounter();
        score++;
        j1.setScoreCounter(score);
        j1.Mains.add(c1);
        j1.Mains.add(c2);
        j2.roundWon(c1, c2);
        assertEquals(j2,j1);
    }

    /**
     * Test of roundWonBattle method, of class Joueur.
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     * @param c5
     * @param c6
     */
    public void testRoundWonBattle(Carte c1,Carte c2,Carte c3,Carte c4,Carte c5,Carte c6) {
        int score = j1.getScoreCounter();
        score = score + 3;
        j1.setScoreCounter(score);
        j1.Mains.add(c1);
        j1.Mains.add(c2);
        j1.Mains.add(c3);
        j1.Mains.add(c4);
        j1.Mains.add(c5);
        j1.Mains.add(c6);
        j2.roundWonBattle(c1, c2, c3, c4, c5, c6);
        assertEquals(j2,j1);
    }

    /**
     * Test of addCarte method, of class Joueur.
     * @param c1
     */
    public void testAddCarte(Carte c1) {
        j1.Mains.add(c1);
        j2.addCarte(c1);
        assertTrue("Deux même carte ajoutés",j1.getLastCarte()==j2.getLastCarte());
    }

    /**
     * Test of defineWinner method, of class Joueur.
     */
    public void testDefineWinner() {
        Joueur winner;
        j1.setScoreCounter(3);
        if(j1.getScoreCounter()>j2.getScoreCounter()){
            winner = j1;
        }
        else{
            winner = j2;
        }
        assertTrue("j1 est gagnant",j1.defineWinner(j2)==winner);
        j2.setScoreCounter(5);
        if(j1.getScoreCounter()>j2.getScoreCounter()){
            winner = j1;
        }
        else{
            winner = j2;
        }
        assertTrue("j2 est gagnant",j1.defineWinner(j2)==winner);
    }

    /**
     * Test of pullCard method, of class Joueur.
     */
    public void testPullCard() {
        Carte c = j1.Mains.get(0);
        j1.Mains.remove(0);
        Carte c2 = j2.pullCard();
        assertEquals(c,c2);
    }

    
}
