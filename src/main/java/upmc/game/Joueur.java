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
    ArrayList<Carte> Mains = new ArrayList();
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
    
    public Carte getLastCarte(){
        int index = this.getSizeMains();
        Carte lastCard = this.Mains.get(index-1);
        return lastCard;
    }
    
    public Carte getCarte(int index){
        Carte card = this.Mains.get(index);
        return card;
    }

    public int getScoreCounter(){
        return cpt_point;
    }
    
    public void setScoreCounter(int cpt){
        this.cpt_point = cpt;
    }
    
    public int getSizeMains(){
        return this.Mains.size();
    }  
    
    public void roundWon(Carte c1,Carte c2){
        this.cpt_point++;
        this.addCarte(c1);
        this.addCarte(c2);
    }
    
    public void roundWonBattle(Carte c1, Carte c2, Carte c3, Carte c4, Carte c5, Carte c6){
        this.cpt_point = this.cpt_point + 3 ;
        this.addCarte(c1);
        this.addCarte(c2);
        this.addCarte(c3);
        this.addCarte(c4);
        this.addCarte(c5);
        this.addCarte(c6);
    }
    
    public void addCarte(Carte c){
        this.Mains.add(c);
    }
    
    public Joueur defineWinner(Joueur j){
        if(j.getScoreCounter()>this.getScoreCounter()){
            System.out.println("Le gagnant est "+j.getName()+" avec "+j.getScoreCounter()+" point.");
            return j;
        }
        else{
            System.out.println("Le gagnant est "+this.getName()+" avec "+this.getScoreCounter()+" point.");
            return this;
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
