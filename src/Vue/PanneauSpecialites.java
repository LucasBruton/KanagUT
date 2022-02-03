package Vue;

import javax.swing.*;

import Listeners.SpecialiteListener;
import Model.CarteUV;
import Model.KanagUT;
import Model.Specialisation;

import java.awt.*;
import java.util.ArrayList;

// Panneau permettant de sélectionner une spécialité de diplôme
public class PanneauSpecialites extends javax.swing.JPanel {
    /**
     * Constructeur de la classe
     * 
     * @param fenetre
     *                Fenetre de l'application
     */
    public PanneauSpecialites(Fenetre fenetre) {
        setLayout(new BorderLayout());
        KanagUT kanagUT = fenetre.getKanagUT();
        // Affichage du numéro du joueur + numéro du semestre
        JPanel semestreNumJoueur = new JPanel(new GridLayout(2, 1));
        JLabel semestre = new JLabel("Semestre " + (kanagUT.getNumSemestre() + 1));
        JLabel numJoueur = new JLabel("Joueur " + (kanagUT.getNumJoueur() + 1) + "  ");
        semestre.setHorizontalAlignment(JLabel.LEFT);
        numJoueur.setHorizontalAlignment(JLabel.RIGHT);
        semestreNumJoueur.add(semestre);
        semestreNumJoueur.add(numJoueur);
        add(semestreNumJoueur, BorderLayout.NORTH);

        // Affichage des spécialités de diplômes
        GridBagConstraints gbc = new GridBagConstraints();
        ArrayList<Specialisation> specialisations = kanagUT.getSpecialisations();
        JPanel panneauSpes = new JPanel(new GridLayout(1, specialisations.size()+1));
        for(int i = 0; i<specialisations.size(); ++i) {
            JPanel panneauSpe = new JPanel(new GridBagLayout());
            // Ajout du visuel de la spécialisation
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            gbc.weightx = 1;
            gbc.weighty = 3;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 2;
            panneauSpe.add(new SpecialiteComponent(specialisations.get(i)), gbc);

            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;

            // Si le joueur peut prendre la spécialité, on affiche un bouton permettant de prendre cette spécialité
            // Sinon, on affiche rien
            if(kanagUT.verifierPossibiliteeChoixSpe(i)) {
                JButton boutonSpe = new JButton("Prendre spé");
                boutonSpe.addActionListener(new SpecialiteListener(fenetre, i));
                JPanel centrerBoutonSpe = new JPanel(new GridBagLayout());
                centrerBoutonSpe.add(boutonSpe);
                panneauSpe.add(centrerBoutonSpe, gbc);
            }else {
                panneauSpe.add(new JPanel(), gbc);
            }
            panneauSpes.add(panneauSpe);
        }

        // Bouton permettant de ne rien prendre
        JButton finSpe = new JButton("Rien prendre");
        finSpe.addActionListener(new SpecialiteListener(fenetre, -1));
        JPanel centrerFinSpe = new JPanel(new GridBagLayout());
        centrerFinSpe.add(finSpe);
        panneauSpes.add(centrerFinSpe);

        add(panneauSpes);
    }
}
