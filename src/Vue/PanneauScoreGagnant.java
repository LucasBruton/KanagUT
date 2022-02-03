package Vue;

import Model.ScoreJoueur;
import javax.swing.*;
import java.awt.*;

// Panneau affichant le score du gagnant
public class PanneauScoreGagnant extends javax.swing.JPanel {
    /**
     * Constructeur de la classe
     * 
     * @param fenetre
     *   Fenetre de l'application
     */
    public PanneauScoreGagnant(Fenetre fenetre) {
        setLayout(new BorderLayout());
        JLabel titre = new JLabel("Score");
        add(titre, BorderLayout.NORTH);

        ScoreJoueur gagnant = fenetre.getKanagUT().getGagnant();
        String text = "1e\nJoueur ";
        text += ""+(gagnant.getNumJoueur()+1)+"\nScore: ";
        text += ""+gagnant.getScore();
        JTextArea textArea = new JTextArea(text);
        textArea.setBackground(getBackground());

        JPanel centrerTextArea = new JPanel(new GridBagLayout());
        centrerTextArea.add(textArea);
        add(centrerTextArea);
    }
}
