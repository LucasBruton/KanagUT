package Vue;

import javax.swing.*;
import java.awt.*;

// Panneau affichant le titre du menu
public class PanneauMenuTitre extends javax.swing.JPanel{
    // Constructeur de la classe
    public PanneauMenuTitre() {
        setLayout(new BorderLayout());
        JLabel titre = new JLabel("KanagUT");
        titre.setHorizontalAlignment(JLabel.CENTER);
        add(titre, BorderLayout.NORTH);
        JLabel nbJ = new JLabel("Choix du nombre de joueurs");
        nbJ.setHorizontalAlignment(JLabel.CENTER);
        add(nbJ, BorderLayout.CENTER);
    }
}
