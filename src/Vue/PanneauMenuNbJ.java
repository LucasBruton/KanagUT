package Vue;

import Listeners.NbJListener;

import javax.swing.*;
import java.awt.*;

// Panneau affichant les boutons permettant de sélectionner le nombre de joueurs de la partie
public class PanneauMenuNbJ extends JPanel {
    /**
     * Constructeur de la classe
     * 
     * @param f
     *    Fenetre du jeu
     */
    public PanneauMenuNbJ(Fenetre f) {
        setLayout(new FlowLayout());
        // Création des boutons de sélection des joueurs
        JButton deuxJoueurs = new JButton("2 Joueurs");
        deuxJoueurs.addActionListener(new NbJListener(f, 2));
        JButton troisJoueurs = new JButton("3 Joueurs");
        troisJoueurs.addActionListener(new NbJListener(f, 3));
        JButton quatreJoueurs = new JButton("4 Joueurs");
        quatreJoueurs.addActionListener(new NbJListener(f, 4));
        add(deuxJoueurs);
        add(troisJoueurs);
        add(quatreJoueurs);
    }
}
