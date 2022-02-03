package Vue;

import javax.swing.*;

import Listeners.DeplacementChoixListener;
import Listeners.FinDeplacementChoixListener;
import Listeners.FinNouveauxChoixListener;
import Listeners.NouveauChoixListener;

import java.awt.*;
import java.util.ArrayList;

import Model.KanagUT;
import Model.CarteComp;

// Panneau permettant de déplacer les choix de compétences
public class PanneauDeplacementChoixCompetences extends javax.swing.JPanel {
    /**
     * Constructeur de la classe
     * 
     * @param fenetre
     *                Fenetre de l'application
     */
    public PanneauDeplacementChoixCompetences(Fenetre fenetre) {
        setLayout(new BorderLayout());
        KanagUT kanagUT = fenetre.getKanagUT();
        // Affichage du nombre de déplacements des choix
        JLabel nbChoix = new JLabel("Nombre de déplacements des choix: " + kanagUT.getDeplacementsRestantsChoixJoueur());
        add(nbChoix, BorderLayout.NORTH);

        // Affiche des cartes de compétences + des boutons pour déplacer les choix de compétences posés sur des cartes
        ArrayList<CarteComp> comp = kanagUT.getCartesAcquis();
        JPanel panelCartes = new JPanel(new GridLayout(1, comp.size() + 1));
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < comp.size(); ++i) {
            JPanel panelCarte = new JPanel(new GridBagLayout());
            // Affichage de la carte
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            gbc.weightx = 1;
            gbc.weighty = 3;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 2;
            panelCarte.add(new CompetenceComponent(comp.get(i)), gbc);

            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            // Si la carte est sélectionné et que la carte à une carte voisine à sa gauche 
            // et que celle-ci n'est pas sélectionné, on ajoute un bouton pour déplacer le choix à gauche
            ArrayList<JButton> boutons = new ArrayList<JButton>();
            if((i>0) && (comp.get(i).isSelected()) && (!comp.get(i-1).isSelected())) {
                JButton gauche = new JButton("<-");
                gauche.addActionListener(new DeplacementChoixListener(fenetre, i, -1));
                boutons.add(gauche);
            }
            // Si la carte est sélectionné et que la carte à une carte voisine à sa droite
            // et que celle-ci n'est pas sélectionné, on ajoute un bouton pour déplacer le choix à droite
            if((i<(comp.size()-1)) && (comp.get(i).isSelected()) && (!comp.get(i+1).isSelected())) {
                JButton droite = new JButton("->");
                droite.addActionListener(new DeplacementChoixListener(fenetre, i, 1));
                boutons.add(droite);
            }
            // Si la carte a des boutons pour déplacer son choix de compétences, alors on affiche les boutons.
            // Sinon, on affiche un message indiquant que la carte est sélectionné si cela est le cas (sinon on affiche rien)
            if(boutons.size()>0) {
                JPanel boutonsPanel = new JPanel(new GridLayout(1, boutons.size()));
                for(JButton bouton: boutons) {
                    JPanel centrerBouton = new JPanel(new GridBagLayout());
                    centrerBouton.add(bouton);
                    boutonsPanel.add(centrerBouton);
                }
                panelCarte.add(boutonsPanel, gbc);
            }else {
                JPanel panneauSansBoutons = new JPanel(new GridBagLayout());
                if(comp.get(i).isSelected()) {
                    JLabel carteChoisi = new JLabel("Carte sélectionnée");
                    panneauSansBoutons.add(carteChoisi);
                }
                panelCarte.add(panneauSansBoutons, gbc);
            }

            panelCartes.add(panelCarte);
        }

        // Bouton permettant de passer au visuel du choix des spécilités de diplomes
        JButton finDepChoix = new JButton("Fin des déplacements choix");
        finDepChoix.addActionListener(new FinDeplacementChoixListener(fenetre));
        JPanel centrerDepNvChoix = new JPanel(new GridBagLayout());
        centrerDepNvChoix.add(finDepChoix);
        panelCartes.add(centrerDepNvChoix);

        add(panelCartes);
    }
}
