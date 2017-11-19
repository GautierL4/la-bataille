// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.game;

import java.util.Scanner;
import java.util.ArrayList;


public class Bataille
{

    public static int initialize(){
        System.out.println("C'est le jeu de la bataille!\n");
        System.out.flush();
        Scanner console = new Scanner(System.in);
        System.out.println("Souhaitez vous lancer le mode interactif contre un autre joueur ou jouer contre l'ordinateur ?(1/Oui,2/Non)");
        int choice = console.nextInt();
        return choice;
    }
    
    public static ArrayList<Joueur> createPlayers(){
        Scanner console = new Scanner(System.in);
        System.out.println("Veuillez rentrer le nom du joueur 1");
        String nomJoueur1 = console.nextLine();
        System.out.println("Veuillez rentrer le nom du joueur 2");
        String nomJoueur2 = console.nextLine();
        System.out.println("Installation des joueurs à la table");
        Joueur j1 = new Joueur(nomJoueur1);
        Joueur j2 = new Joueur(nomJoueur2);
        ArrayList<Joueur>Players = new ArrayList();
        Players.add(j1);
        Players.add(j2);
        return Players;
    }
    
    public static ArrayList<Joueur> createPlayer(){
        Scanner console = new Scanner(System.in);
        System.out.println("Veuillez rentrer votre nom");
        String nomJoueur1 = console.nextLine();
        System.out.println("Installation du joueur à la table");
        Joueur j1 = new Joueur(nomJoueur1);
        Joueur j2 = new Joueur("Ordinateur");
        ArrayList<Joueur>Players = new ArrayList();
        Players.add(j1);
        Players.add(j2);
        return Players;
    }
    
    public static ArrayList<Joueur> chooseName(int choice){
        ArrayList<Joueur> Players = new ArrayList<Joueur>();
        LecturePseudo nameReader = new MenuPseudo().chooseReaderType(choice);
        ArrayList<String> nameList = nameReader.readName(choice);
        Joueur j1 = new Joueur(nameList.get(0));
        Joueur j2 = new Joueur(nameList.get(1));
        Players.add(j1);Players.add(j2);
        return Players;
    }
    
    public static ArrayList<Carte> openDeck(){
        System.out.println("Ouverture du paquet de carte");
        ArrayList<Carte> Paquet= new ArrayList();
        String [] tabColor = {"Trefle","Pique","Coeur","Carreau"};
        int [] tabValue = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        for(String couleur: tabColor){
            for(int valeur: tabValue){
                Paquet.add(new Carte(couleur,valeur));
            }
        }
        return Paquet;
    }
    
    public static ArrayList<Carte> shuffleDeck(ArrayList<Carte> Paquet){
        System.out.println("Mélange du paquet de carte");
        for(int p=0;p<52;p++){
            int random= (int)(Math.random()*(51-0)+0);
            Paquet.set(random,Paquet.get(p));
        }
        return Paquet;
    }
    
    public static ArrayList<Joueur> distribute(Joueur j1,Joueur j2,ArrayList<Carte>Paquet){
        ArrayList<Joueur>Players = new ArrayList();
        System.out.println("Distribution des cartes");
        for(int k=0;k<52;k++){
            if(k%2 ==0){
                j1.addCarte(Paquet.get(k));
            }
            else{
                j2.addCarte(Paquet.get(k));
            }
        }
        Paquet.clear();
        Players.add(j1);
        Players.add(j2);
        return Players;
    }
    
    public static void battle(Joueur j1,Joueur j2,Carte c1, Carte c2){
        if(c1.getValue()==c2.getValue()){
                Carte c3 = j1.pullCard();
                Carte c4 = j2.pullCard();
                Carte c5 = j1.pullCard();
                Carte c6 = j2.pullCard();
                if(c5.compare(c6)==c5){
                    j1.roundWonBattle(c1,c2,c3,c4,c5,c6);
                    System.out.println("Le joueur "+j1.getName()+" remporte cette manche avec la carte "+c5.getValue());
                }
                else{
                    j2.roundWonBattle(c1, c2, c3, c4, c5, c6);
                    System.out.println("Le joueur "+j2.getName()+" remporte cette manche avec la carte "+c6.getValue());
                }
            }
            if(c1.compare(c2)==c1){
                j1.roundWon(c1,c2);
                System.out.println("Le joueur "+j1.getName()+" remporte cette manche avec la carte "+c1.getValue());
            }
            else{
                j2.roundWon(c1, c2);
                System.out.println("Le joueur "+j2.getName()+" remporte cette manche avec la carte "+c2.getValue());
            }
            System.out.println("Score de "+j1.getName()+" est de : "+j1.getScoreCounter());
            System.out.println("Score de "+j2.getName()+" est de : "+j2.getScoreCounter());
    }
    
    public static void interactiveGame(Joueur j1,Joueur j2){
        Scanner console = new Scanner(System.in);
        System.out.println("Début de la phase de jeu");
        while(j1.getSizeMains()!=0 || j2.getSizeMains()!=0){
            Carte c1=j1.choicePullCard(j2);
            Carte c2=j2.choicePullCard(j1);
            battle(j1,j2,c1,c2);
            }
        j1.defineWinner(j2);
    }
    
    public static void computerGame(Joueur j1,Joueur j2){
        Scanner console = new Scanner(System.in);
        System.out.println("Début de la phase de jeu");
        System.out.println("Ce mode de jeu est différent du mode interactif, la partie s'arrête lorqu'on atteint 100 point");
        while(j1.getScoreCounter()<100 || j2.getScoreCounter()<100){
            System.out.println("C'est à votre tour, veuillez tirer une carte. (Appuyer sur Entrée)");
            console.nextLine();
            Carte c1=j1.pullCard();
            Carte c2=j2.pullCard();
            battle(j1,j2,c1,c2);
        }
        j1.defineWinner(j2);
    }
    
    public static void interactiveBattle(int choice){
        ArrayList<Joueur> Players=chooseName(choice);
        Joueur j1=Players.get(0);
        Joueur j2=Players.get(1);
        ArrayList<Carte> Paquet=openDeck();
        Paquet=shuffleDeck(Paquet);
        Players=distribute(j1,j2,Paquet);
        j1=Players.get(0);
        j2=Players.get(1);
        interactiveGame(j1,j2);
    }
    
    public static void computerBattle(int choice){
        ArrayList<Joueur> Players=chooseName(choice);
        Joueur j1=Players.get(0);
        Joueur j2=Players.get(1);
        ArrayList<Carte> Paquet=openDeck();
        Paquet=shuffleDeck(Paquet);
        Players=distribute(j1,j2,Paquet);
        j1=Players.get(0);
        j2=Players.get(1);
        computerGame(j1,j2);
    }
    
    public static void demarrage(){
        int choice = initialize();
        Scanner console = new Scanner(System.in);
        if(choice == 1){
            interactiveBattle(choice);
        }
        else if(choice == 2){
            computerBattle(choice);
        }
        else{
            System.out.println("Vous n'avez pas saisie un choix valide, Appuyez sur entrée pour lancer une nouvelle partie");
            console.nextLine();
            demarrage();
        }
    }

    
  public static void main(String[] args){
        demarrage();
    }
}

    