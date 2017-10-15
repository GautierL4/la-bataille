/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sena-
 */
public class LectureFichier implements LecturePseudo {

    public ArrayList<String> readName(int choice) {
        Scanner console = new Scanner(System.in);
        ArrayList<String> listePseudo = new ArrayList<String>();
        System.out.println("Veuillez saisir le nom du fichier à lire : ");
        String fichierNom = "src/main/java/upmc/game/"+console.nextLine();
        try{
            File file = new File(fichierNom);
            FileReader fileReader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String ligne = buffReader.readLine();
            while(ligne != null){
                listePseudo.add(ligne);
                ligne = buffReader.readLine();
            }
            buffReader.close();
            fileReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Le fichier n'a pas été trouvé");
        }
        catch(IOException e){
            System.out.println("Une erreur c'est produite lors de la lecture : "+e.getMessage());
        }
        return listePseudo;  
    }
}
