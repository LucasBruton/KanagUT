package Vue;

import javax.swing.*;

import Model.CarteUV;

import java.awt.*;
import java.util.ArrayList;

// Panneau affichant les cartes UV que le joueur va ajouter à son parcours une fois que les 
// bonnes compétences ont été sélectionnés
public class PanneauUVRestants extends javax.swing.JPanel {
    /**
     * Constructeur de la classe
     * 
     * @param fenetre
     *  Fenetre de l'application
     */
    public PanneauUVRestants(Fenetre fenetre) {
        setLayout(new BorderLayout());
        // Affichage de text
        JLabel text = new JLabel("Voici les cartes destinées pour votre parcours");
        text.setHorizontalAlignment(JLabel.CENTER);
        add(text, BorderLayout.NORTH);

        ArrayList<CarteUV> uvs = fenetre.getKanagUT().getCartesUvRestantes();
        JPanel grille = new JPanel(new GridLayout(1, uvs.size()));
        // Affichage des cartes UV
        for(CarteUV carte: uvs) {
            grille.add(new UVComponent(carte));
        }

        add(grille);
    }
}
