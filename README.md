# la-bataille
Jeu de carte "la bataille" dans le cadre du cours Java/UPMC

Instructions
============

Le jeu se compile avec la commande `mvn compile`.

Vous pouvez lancer une partie avec `mvn exec:java -Dexec.mainClass="upmc.game.Bataille"`

TP 1
====

* Le début de l'énoncé du TP se trouve à la fin du cours 1
* En plus, on vous demande de proposer un mode interactif dans lequel :
  1. Le système indique quelle joueur doit jouer.
  2. L'utilisateur peut décider de tirer une carte (simplement en appuyant sur "enter").
* Proposer un menu à 2 entrées : (1) Tirer la prochaine carte (2) Quitter.
* Permettez aux deux joueurs d'entrer leurs noms.
* Proposer un mode où un joueur peut jouer contre un ordinateur.
* Rendre le projet le plus ergonomique et soigné possible.
* Étendez les règles à votre sauce pour rendre le tout plus intéressant.
* Faites un rapport d'une page maximum pour expliquer les nouvelles règles implémentées.
* Veuillez à respecter la grille d'évaluation.

La date de rendu est sur le [site du cours](http://hyc.io/teaching/java.html).

TP 2
====

* Lire le code de l'interface `LecturePseudo` fournie.
Elle indique que les classes qui implémenteront cette interface permettent de lire le pseudo d'un joueur.
* Implémenter cette interface avec les classes `LectureConsole` et `LectureFichier`.
Elles permettent de lire respectivement les pseudos d'un fichier et de la console.
* La classe `LectureFichier` demandera à l'utilisateur le nom d'un fichier à lire.
Dans ce fichier, il y aura les pseudos utilisateurs à raison d'un par ligne.
* Ensuite vous ajoutez une classe `MenuPseudo` qui propose une méthode `public LecturePseudo modeLecturePseudo()`.
Elle propose un menu dans lequel l'utilisateur peut choisir de quelles manières il veut lire les pseudos: via un fichier ou via la console.
La méthode renvoie la classe correspondante (i.e. `LectureConsole` ou `LectureFichier`): vu qu'elles implémentent toutes deux `LecturePseudo`, on peut juste les manipuler via `LecturePseudo`.
Un exemple:
```
LecturePseudo lecturePseudo = menu.modeLecturePseudo();
ArrayList<String> pseudos = lecturePseudo.lirePseudo();
...
```
On peut utiliser `lirePseudo` sur `LecturePseudo` de manière générique.

* Utiliser `MenuPseudo` dans votre méthode `main` principale.

La date de rendu est sur le [site du cours](http://hyc.io/teaching/java.html).

TP 3
====

* Ajouter des tests JUnits pour les méthodes qui calculent ou vérifient des résultats.
* Vous devrez probablement refactorer votre code, n'hésitez pas à découper en plusieurs méthodes et à créer d'autres classes.
* NOTE: on ne peut pas tester les méthodes privées mais si vous avez besoin d'en tester une, il se peut que cette méthode devrait être dans une autre classe.
* BONUS: Utiliser des *mock objects* pour tester les entrées utilisateurs (voir chapitre 10 de ''Pragmatic unit testing in Java 8 with JUnit'').

Info
====

Synchroniser un fork avec son répertoire courant:

```
git remote add upstream https://github.com/ptal/la-bataille.git
git fetch upstream
git checkout master
git merge upstream/master
```
Source: [synchroniser un fork](https://help.github.com/articles/syncing-a-fork/)
