package Vue;

import Model.Carte;
import Model.ColonneCartesInscription;
import Model.ScoreJoueur;
import javax.swing.*;

import Listeners.ChoixCartesListener;

import java.awt.*;
import java.util.ArrayList;

// Panneau affichant le score du gagnant
public class PanneauChoixCartes extends javax.swing.JPanel {
    /**
     * Constructeur de la classe
     * 
     * @param fenetre
     *  Fenetre de l'application
     */
    public PanneauChoixCartes(Fenetre fenetre) {
        setLayout(new BorderLayout());
        // Texte indiquant ce qu'il faut faire
        JTextArea textArea = new JTextArea("Sélectionnez les cartes à ajouter à vos compétences.\nLes autres seront destinées à votre parcours.");
        textArea.setBackground(getBackground());
        add(textArea, BorderLayout.NORTH);

        ArrayList<Carte> colonne = fenetre.getKanagUT().getColonneCartesChoisi().getColonne();
        
        // Affichage des cartes + jcheckbox pour les destinations
        JPanel cartesPanel = new JPanel(new GridLayout(1, colonne.size()+1));
        GridBagConstraints gbc = new GridBagConstraints();
        ArrayList<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();
        for (Carte carte : colonne) {
            JPanel carteCheckBoxPanel = new JPanel(new GridBagLayout());
            JPanel cartePanel = new JPanel(new GridLayout(1, 2));
            cartePanel.add(new CompetenceComponent(carte.getCarteComp()));
            cartePanel.add(new UVComponent(carte.getCarteUV()));

            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            gbc.weightx = 1;
            gbc.weighty = 3;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 2;
            carteCheckBoxPanel.add(cartePanel, gbc);

            JCheckBox checkBox = new JCheckBox();
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            carteCheckBoxPanel.add(checkBox, gbc);
            checkBoxs.add(checkBox);

            cartesPanel.add(carteCheckBoxPanel);
        } 

        // Bouton pour valider les destinations des cartes
        JButton valider = new JButton("Valider");
        valider.addActionListener(new ChoixCartesListener(fenetre, colonne, checkBoxs));
        JPanel centrerValider = new JPanel(new GridBagLayout());
        centrerValider.add(valider);
        cartesPanel.add(centrerValider);
        add(cartesPanel);
    }
}
