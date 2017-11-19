/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

/**
 *
 * @author sena-
 */
public class Carte {
    private String couleur;
    private int valeur;
    

    
    public Carte(String couleur, int valeur){
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public String getCoulor(){
        return couleur;
    }

    public int getValue(){
        return valeur;
    }

    public void setCoulor(String couleur){
        this.couleur = couleur;
    }

    public void setValue(int valeur){
        this.valeur = valeur;
    }
    
    public Carte compare(Carte c){
        if(this.getValue()>c.getValue()){
            return this;
        }
        else{
            return c;
        }
    }
    
    
    public String toString(){
        return "La valeur de la carte est : "+this.valeur+"\nLa couleur de la carte est : "+this.couleur;
    }
    
    
    
}
