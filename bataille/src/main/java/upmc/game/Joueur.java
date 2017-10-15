/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package upmc.game;
import java.util.*;
/**
 *
 * @author sena-
 */
public class Joueur {
    private ArrayList<Carte> Mains = new ArrayList();
    private int cpt_point = 0;
    private String nom;
    
    public Joueur(String nom){
        this.nom = nom;
        this.cpt_point = 0;
        this.Mains = new ArrayList();
    }


    public String getName(){
        return nom;
    }

    public int getScoreCounter(){
        return cpt_point;
    }
    
    public int getSizeMains(){
        return this.Mains.size();
    }  
    
    public void roundWon(Carte c1,Carte c2){
        this.cpt_point++;
        this.Mains.add(c1);
        this.Mains.add(c2);
    }
    
    public void roundWonBattle(Carte c1, Carte c2, Carte c3, Carte c4, Carte c5, Carte c6){
        this.cpt_point = this.cpt_point + 3 ;
        this.Mains.add(c1);
        this.Mains.add(c2);
        this.Mains.add(c3);
        this.Mains.add(c4);
        this.Mains.add(c5);
        this.Mains.add(c6);
    }
    
    public void addCarte(Carte c){
        this.Mains.add(c);
    }
    public void defineWinner(Joueur j){
        if(j.getScoreCounter()>this.getScoreCounter()){
            System.out.println("Le gagnant est "+j.getName()+" avec "+j.getScoreCounter()+" point.");
        }
        else{
            System.out.println("Le gagnant est "+this.getName()+" avec "+this.getScoreCounter()+" point.");
        }
    }
    
    public Carte pullCard(){
        Carte c = this.Mains.get(0);
        this.Mains.remove(0);
        return c;
    }
    
    public Carte choicePullCard(Joueur j2){
        Scanner console = new Scanner(System.in);
        System.out.println("C'est au tour de "+this.getName());
        System.out.println("Voulez vous tirer une carte ?(1/Oui,2/Quitter)");
            int continueLaPartie=console.nextInt();
            if(continueLaPartie==2){
                System.out.println("Fin de la partie");
                this.defineWinner(j2);
                System.exit(0);
                return null;
            }
            else{
                Carte c1 = this.pullCard();
                return c1;
            }
    }
    
    
}
