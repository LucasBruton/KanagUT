package Listeners;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JCheckBox;

import Model.Carte;
import Model.CarteComp;
import Model.CarteUV;
import Vue.Fenetre;

// Listener permettant d'indiquer la destinations des cartes de la colonne de cartes sélectionnée au cours de l'inscription du semestre 
public class ChoixCartesListener implements ActionListener{
    // Fenetre de l'application
    private final ArrayList<JCheckBox> checkBoxs;
    // Cartes de la colonne de cartes sélectionnés au cours de l'inscription du semestre
    private final ArrayList<Carte> cartes;
    // Checkboxs indiquant les destinations des cartes
    private final Fenetre fenetre;

    /**
     * Constructeur de la classe
     * @param f
     *  Fenetre de l'application
     * @param c
     *  Cartes de la colonne de cartes sélectionnés au cours de l'inscription du semestre
     * @param cb
     *  Checkboxs indiquant les destinations des cartes
     */
    public ChoixCartesListener(Fenetre f, ArrayList<Carte> c, ArrayList<JCheckBox> cb) {
        fenetre = f;
        cartes = c;
        checkBoxs = cb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Integer> numCompChoisis = new ArrayList<>();
        // destinations des cartes
        for(int i = 0; i<checkBoxs.size(); ++i) {
            if(checkBoxs.get(i).isSelected()) {
                fenetre.getKanagUT().addCompToAcquis(cartes.get(i).getCarteComp());
                numCompChoisis.add(i);
            }
        }

        int num;
        for (int i = 0; i < numCompChoisis.size(); i++) {
            //comme on enlève une carte à chaque fois l’index pris précédemment n’est plus valable donc on le décale du nombre de cartes retirées
            num = numCompChoisis.get(i) - i;
            fenetre.getKanagUT().retirerCarteFromColonneChoisis(num);
        }

        // Affiche la vue suivante en fonction du nombre de nouveaux choix du joueur
        if(fenetre.getKanagUT().getNbNouveauxChoixJoueur()>0) {
            fenetre.afficherNouveauxChoixCompetences();
        }else {
            fenetre.afficherDeplacementsChoixCompetences();
        }
        
    }
}
