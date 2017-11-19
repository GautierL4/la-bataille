/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sena-
 */
public class LectureConsole implements LecturePseudo {

    public ArrayList<String> readName(int choice) {
        ArrayList<String> listeNom = new ArrayList<String>();
        listeNom.add(this.writeName());
        listeNom.add(this.chooseTypeGame(choice));
        return listeNom;
    }
    
    public String writeName(){
        Scanner console = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du joueur : ");
        String nom = console.nextLine();
        return nom;
    }
    
    public String chooseTypeGame(int choice){
        Scanner console = new Scanner(System.in);
       // System.out.println("Souhaitez vous lancer le mode interactif contre un autre joueur ou jouer contre l'ordinateur ?(1/Oui,2/Non)");
       // int choice = console.nextInt();
        String name=null;
        switch (choice) {
            case 1:
                name = writeName();
                break;
            case 2:
                name = "Ordinateur";
                break;
            default:
                System.out.println("Vous n'avez pas saisie un choix valide");
                break;
        }
        return name;
    }
    
}
