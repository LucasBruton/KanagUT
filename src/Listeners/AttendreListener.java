package Listeners;

import java.awt.event.*;

import Vue.Fenetre;

// Listener permettant au joueur d'attendre à la plateforme d'inscription
public class AttendreListener implements ActionListener {
    // Fenetre de l'application
    private final Fenetre fenetre;

    /**
     * Constructeur de la classe
     * @param f
     *  Fenetre de l'application
     */
    public AttendreListener(Fenetre f) {
        fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.getKanagUT().attendre();
        fenetre.getKanagUT().finTour();
        fenetre.afficherPlateau();
    }
}
