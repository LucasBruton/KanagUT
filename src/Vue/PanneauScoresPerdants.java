package Vue;

import Model.KanagUT;
import Model.ScoreJoueur;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Panneau affichant les scores des perdants
public class PanneauScoresPerdants extends javax.swing.JPanel {
    /**
    * Constructeur de la classe
    * @param fenetre
    *   Fenetre de l'application
    */
    public PanneauScoresPerdants(Fenetre fenetre) {
        setLayout(new GridLayout(1, 3));

        ArrayList<ScoreJoueur> perdants = fenetre.getKanagUT().getPerdants();
        int num = 2;
        for(ScoreJoueur perdant: perdants) {
            String text = ""+num+"e\nJoueur ";
            ++num;
            text += "" + (perdant.getNumJoueur()+1) + "\nScore: ";
            text += "" + perdant.getScore();
            JTextArea textArea = new JTextArea(text);
            textArea.setBackground(getBackground());

            JPanel centrerTextArea = new JPanel(new GridBagLayout());
            centrerTextArea.add(textArea);
            add(centrerTextArea);   
        }
    }
}