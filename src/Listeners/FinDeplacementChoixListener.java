package Listeners;

import java.awt.event.*;

import Vue.Fenetre;

// Listener permettant d'indiquer la fin de déplacements des choix de compétences
public class FinDeplacementChoixListener implements ActionListener {
    // Fenetre de l'application
    private final Fenetre fenetre;

    /**
     * Contructeur de la classe
     * 
     * @param f
     *          Fenetre de l'application
     */
    public FinDeplacementChoixListener(Fenetre f) {
        fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Affiche les spécliatés*
        fenetre.getKanagUT().ajouterUvToParcours();
        fenetre.afficherSpecialites();
    }
}