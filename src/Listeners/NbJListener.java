package Listeners;


import java.awt.event.ActionEvent;
import Vue.Fenetre;

// Listener permettant d'indiquer le nombre de joueurs de la partie
public class NbJListener implements java.awt.event.ActionListener {
    // Fenetre de l'application
    private final Fenetre fenetre;
    // Nombre de joueurs sélectionnés
    private final int nbJ;

    /**
     * Constructeur de la classe
     * 
     * @param f
     *  Fenetre de l'application
     * @nbJ
     *  Nombre de joueurs sélectionnés
     */

    public NbJListener(Fenetre f, int nbJ) {
        fenetre = f;
        this.nbJ = nbJ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.getKanagUT().createNJoueurs(nbJ);
        fenetre.getKanagUT().setUpPlateform();
        fenetre.afficherPlateau();
    }
}
