package Vue;

import javax.swing.*;

import Listeners.FinNouveauxChoixListener;
import Listeners.NouveauChoixListener;

import java.awt.*;
import java.util.ArrayList;

import Model.KanagUT;
import Model.CarteComp;

// Panneau permettant de placer des nouveaux choix de compétences
public class PanneauNouveauxChoixCompetences extends javax.swing.JPanel {
    /**
     * Constructeur de la classe
     * 
     * @param fenetre
     *  Fenetre de l'application
     */
    public PanneauNouveauxChoixCompetences(Fenetre fenetre) {
        setLayout(new BorderLayout());
        KanagUT kanagUT= fenetre.getKanagUT();
        // Affichage du nombre de nouveaux choix
        JLabel nbChoix = new JLabel("Nombre de nouveaux choix: "+kanagUT.getNbNouveauxChoixJoueur());
        add(nbChoix, BorderLayout.NORTH);

        // Affiche des cartes de compétences + un bouton si on peut poser un choix de compétence dessus
        ArrayList<CarteComp> comp = kanagUT.getCartesAcquis();
        JPanel panelCartes = new JPanel(new GridLayout(1, comp.size()+1));
        GridBagConstraints gbc = new GridBagConstraints();
        for(int i = 0; i<comp.size(); ++i) {
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

            // On affiche un bouton si la carte n'est pas déjà sélectionné. Sinon, on affiche du text
            if(!comp.get(i).isSelected()) {
                JButton valider = new JButton("Ajouter nouveau choix");
                valider.addActionListener(new NouveauChoixListener(fenetre, i));
                JPanel centrerValider = new JPanel(new GridBagLayout());
                centrerValider.add(valider);

                panelCarte.add(centrerValider, gbc);
            }else {
                JPanel panelDejaOccupe = new JPanel(new GridBagLayout());
                JLabel dejaOccupe = new JLabel("Carte sélectionnée");
                panelDejaOccupe.add(dejaOccupe);
                panelCarte.add(panelDejaOccupe, gbc);
            }

            panelCartes.add(panelCarte);
        }

        // Bouton permettant de passer au visuel du déplacements des choix de compétences
        JButton finNvChoix = new JButton("Fin des nouveaux choix");
        finNvChoix.addActionListener(new FinNouveauxChoixListener(fenetre));
        JPanel centrerFinNvChoix = new JPanel(new GridBagLayout());
        centrerFinNvChoix.add(finNvChoix);
        panelCartes.add(centrerFinNvChoix);

        add(panelCartes);
    }
}
