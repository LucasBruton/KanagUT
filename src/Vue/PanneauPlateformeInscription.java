package Vue;

import Model.*;
import javax.swing.*;
import Listeners.AttendreListener;
import Listeners.ColonneCarteListener;

import java.util.ArrayList;
import java.awt.*;

// Panneau affichant le tire du menu
public class PanneauPlateformeInscription extends javax.swing.JPanel {

    /**
     * Constructeur de la classe
     * @param fenetre
     */
    public PanneauPlateformeInscription(Fenetre fenetre) {
        KanagUT kanagUT = fenetre.getKanagUT();
        
        setLayout(new BorderLayout());
        // Affichage du numéro du joueur + numéro du semestre
        JPanel semestreNumJoueur = new JPanel(new GridLayout(2, 1));
        JLabel semestre = new JLabel("Semestre "+(kanagUT.getNumSemestre()+1));
        JLabel numJoueur = new JLabel("Joueur "+(kanagUT.getNumJoueur()+1)+"  ");
        semestre.setHorizontalAlignment(JLabel.LEFT);
        numJoueur.setHorizontalAlignment(JLabel.RIGHT);
        semestreNumJoueur.add(semestre);
        semestreNumJoueur.add(numJoueur);
        add(semestreNumJoueur, BorderLayout.NORTH);

        // Affichage des colonnes de cartes
        JPanel cartesColonnes = new JPanel(new GridLayout(1, 5));
        ArrayList<ColonneCartesInscription> colonnes = kanagUT.getCarteSurPlateforme();
        for(int i = 0; i<colonnes.size(); ++i) {
            ColonneCartesInscription colonne = colonnes.get(i);
            JPanel pannelColonne = new JPanel(new GridLayout(4, 1));
            ArrayList<Carte> cartes = colonne.getColonne();

            // Ajout bouton pour sélectionner la colonne
            JPanel centrerBoutonCol = new JPanel(new GridBagLayout());
            JButton col = new JButton("Colonne " + (i+1));
            col.addActionListener(new ColonneCarteListener(fenetre, i));
            centrerBoutonCol.add(col);
            pannelColonne.add(centrerBoutonCol);

            // Affichage des cartes de la colonne
            for(Carte carte: cartes) {
                JPanel panneauCarte = new JPanel(new GridLayout(1, 2));
                panneauCarte.add(new CompetenceComponent(carte.getCarteComp()));
                panneauCarte.add(new UVComponent(carte.getCarteUV()));
                pannelColonne.add(panneauCarte);
            }
            cartesColonnes.add(pannelColonne);
        }

        // Si le joueur peut attendre, on affiche le boutton attendre
        if (kanagUT.joueurPeutAttendre()) {
            JPanel centrerAttendre = new JPanel(new GridBagLayout());
            JButton attendre = new JButton("Attendre");
            attendre.addActionListener(new AttendreListener(fenetre));
            centrerAttendre.add(attendre);
            cartesColonnes.add(centrerAttendre);
        }

        add(cartesColonnes);
    }
}
