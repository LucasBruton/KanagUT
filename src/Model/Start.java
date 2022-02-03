package Model;

import Vue.Fenetre;

// Classe implémentant Runnable permettant de lancer la fenetre de l'application
public class Start implements java.lang.Runnable{
    // Accès au modèle 
    private final KanagUT kanagUT;
    // Constructeur de la classe
    public Start() {
        kanagUT = new KanagUT();
    }

    /**
     *     Lancement de la fenetre de l'application
      */
    public void run(){
        new Fenetre(kanagUT);

    }
}
