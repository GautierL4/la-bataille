/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.Scanner;

/**
 *
 * @author sena-
 */
public class MenuPseudo {
    public LecturePseudo chooseReaderType(int choiceTypeGame){
        Scanner console = new Scanner(System.in);
        System.out.println("Souhaitez vous lire les noms des joueurs avec la Console ou un Fichier(1/Console,2/Fichier)");
        int choice = console.nextInt();
        if(choice==1){
            return new LectureConsole();
        }
        else if(choice==2){
            return new LectureFichier();
        }
        else{
            System.out.println("Vous avez saisie un choix invalide");
            System.exit(0);
            return null;
            
        }
    }
}
