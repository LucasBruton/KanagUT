package Vue;

import javax.swing.*;

import Model.KanagUT;

import java.awt.*;

public class Fenetre extends javax.swing.JFrame{
    // Panneau du haut de l'application
    private final PanneauSup panneauSup;
    // Panneau du bas de l'application
    private final PanneauInf panneauInf;
    // Accès au modèle de l'application
    private final KanagUT kanagUT;

    /**
     * Constructeur de la classe
     * 
     * @param kanagUT
     *   Objet permettant d'utiliser le modèle de l'application
     */
    public Fenetre(KanagUT kanagUT) {
        //call the constructor of the JFrame swing class
        super("KanagUT");
        this.kanagUT = kanagUT;
        GridLayout layout = new GridLayout(2, 1);
        this.setLayout(layout);
        panneauSup = new PanneauSup(this);
        add(panneauSup);

        panneauInf = new PanneauInf(this);
        add(panneauInf);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920,1080);
        setVisible(true);
    }

    /**
     * 
     * @return KanagUT
     *  Classe permettant d'accéder au modèle de l'application
     */
    public KanagUT getKanagUT() {
        return kanagUT;
    }

    /**
     * 
     * @return le panneau inférieur de la fenetre
     */
    public PanneauInf getPanneauInf() {
        return panneauInf;
    }

    /**
     * 
     * @return le panneau supérieur de la fenetre
     */
    public PanneauSup getPanneauSup() {
        return panneauSup;
    }

    // Affiche la plateforme d'inscription
    public void afficherPlateau() {
        panneauSup.afficherChoixAction();
        panneauInf.afficherParcours();
    }

    // Affiche la sélection de la destination des cartes choisis aucours de la plateforme d'inscription
    public void afficherChoixCartes() {
        panneauSup.afficherChoixCartes();
        panneauInf.afficherParcours();
    }

    // Affichage du score des joueurs en fin de partie
    public void affichageScore() {
        panneauSup.afficherScoreGagnant();
        panneauInf.afficherScorePerdants();
    }

    // Affiche le visuel permettant de placer des nouveaux choix de compétences
    public void afficherNouveauxChoixCompetences() {
        panneauSup.afficherUVRestants();
        panneauInf.afficherNouveauxChoixCompetences();
    }

    // Affiche le visuel permettant de déplacer les choix de compétences
    public void afficherDeplacementsChoixCompetences() {
        panneauSup.afficherUVRestants();
        panneauInf.afficherDeplacementChoixCompetences();
    }

    // Affiche le visuel permettant de sélectionner une spécialité de diplome
    public void afficherSpecialites() {
        panneauSup.afficherSpecialites();
        panneauInf.afficherParcours();
    }
}
