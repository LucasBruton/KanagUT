package Vue;

import javax.swing.*;
import java.awt.*;

// Panneau du haut de la fenetre
public class PanneauSup extends javax.swing.JPanel{
    // Fenetre principal du jeu 
    private final Fenetre fenetre;

    /**
     * Constructeur de la classe
     * 
     * @param f
     *  Fenetre du jeu
     */
    public PanneauSup(Fenetre f){
        fenetre = f;
        setLayout(new BorderLayout());
        PanneauMenuTitre panneauMenuTitre = new PanneauMenuTitre();
        add(panneauMenuTitre);
    }

    // Affiche la plateforme d'inscription
    public void afficherChoixAction() {
        removeAll();
        add(new PanneauPlateformeInscription(fenetre));
        repaint();
        revalidate();
    }

    // Affiche le score du gagnat
    public void afficherScoreGagnant() {
        removeAll();
        add(new PanneauScoreGagnant(fenetre));
        repaint();
        revalidate();
    }
    
    // Affiche la vue de la sélection de la destination des cartes
    public void afficherChoixCartes() {
        removeAll();
        add(new PanneauChoixCartes(fenetre));
        repaint();
        revalidate();
    }

    // Affiche les cartes UV dont le joueur doit utiliser les bonnes cartes compétences pour les obtenir
    public void afficherUVRestants() {
        removeAll();
        add(new PanneauUVRestants(fenetre));
        repaint();
        revalidate();
    }

    // Affiche la vue de sélection d'une spécialité de diplôme
    public void afficherSpecialites() {
        removeAll();
        add(new PanneauSpecialites(fenetre));
        repaint();
        revalidate();
    }
}
