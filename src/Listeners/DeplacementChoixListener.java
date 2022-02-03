package Listeners;

import java.awt.event.*;

import Vue.Fenetre;

// Listener permettant de déplacer un choix de compétence
public class DeplacementChoixListener implements ActionListener {
    private final Fenetre fenetre;
    private final int idCarte;
    private final int deplacement;

    /**
     * Contructeur de la classe
     * 
     * @param f
     *                Fenetre de l'application
     * @param idCarte
     *                Identifiant de la carte compétence
     */
    public DeplacementChoixListener(Fenetre f, int idCarte, int deplacement) {
        fenetre = f;
        this.idCarte = idCarte;
        this.deplacement = deplacement;
    }

    /**
     * On déplace le choix d'une carte compétence à droite ou à gauche. 
     * On rafraichit le visuel des déplacements des choix de compétences si le joueur possède encore des déplacements. 
     * Sinon, on affiche la sélection des spécialités.
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.getKanagUT().deplacementChoixCompetence(idCarte, deplacement);
        if (fenetre.getKanagUT().getDeplacementsRestantsChoixJoueur() > 0) {
            fenetre.afficherDeplacementsChoixCompetences();
        } else {
            fenetre.getKanagUT().ajouterUvToParcours();
            fenetre.afficherSpecialites();
        }
    }
}