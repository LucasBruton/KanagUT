package Listeners;

import java.awt.event.*;

import Model.KanagUT;
import Vue.Fenetre;

// Listener permettant d'indiquer quelle spécialité récupère le joueur
public class SpecialiteListener implements java.awt.event.ActionListener {
    // Fenetre de l'application
    private final Fenetre fenetre;
    // numéro de la colonne de carte sélectionnée
    private final int numSpe;

    /**
     * Constructeur de la classe
     * @param f
     *  Fenetre de l'application
     * @param numSpe
     *  Numéro de spécialité choisie
     *  Si numSpe == -1, le joueur finit son tour sans choisir de spécialité
     */
    public SpecialiteListener(Fenetre f, int numSpe) {
        fenetre = f;
        this.numSpe = numSpe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        KanagUT kanagUT = fenetre.getKanagUT();
        // Choix de spécialité
        if(numSpe > -1) {
            kanagUT.choixSpecialisation(numSpe);
        }
        // Si la partie est finie, on affiche les scores.
        // Sinon, on passe au tour du joueur suivant.
        if(kanagUT.checkFinJeu()) {
            fenetre.affichageScore();
        }else {
            kanagUT.setFinTourJoueur();
            kanagUT.finTour();
            fenetre.afficherPlateau();
        }
    }
}
