package Listeners;

import java.awt.event.*;

import Vue.Fenetre;

// Listener permettant d'indiquer la fin de placements de nouveaux choix de compétences
public class FinNouveauxChoixListener implements ActionListener {
    // Fenetre de l'application
    private final Fenetre fenetre;

    /**
     * Contructeur de la classe
     * @param f
     *  Fenetre de l'application
     */
    public FinNouveauxChoixListener(Fenetre f) {
        fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Affiche les déplacements des choix de compétences
        fenetre.afficherDeplacementsChoixCompetences();
    }
}
