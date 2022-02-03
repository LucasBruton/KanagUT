package Vue;

import Model.CarteUV;
import Model.e_filiere;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

// JComponent représentant une carte UV
public class UVComponent extends JComponent {
    // Carte UV que la classe représente
    private final CarteUV carte;

    /**
     * Constructeur de la classe
     * 
     * @param c
     *  Carte compétence
     */
    public UVComponent(CarteUV c) {
        carte = c;
    }

    /**
     * Paint la carte
     * 
     * @param pinceau
     */
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();
        // Modifie la couleur du fond de la carte en fonction de sa filière
        e_filiere filiere = carte.getFiliere();
        if (filiere == e_filiere.DATASCIENCE) {
            secondPinceau.setColor(new Color(163, 3, 54));
        } else if (filiere == e_filiere.LOGICIEL) {
            secondPinceau.setColor(new Color(10, 7, 162));
        } else if (filiere == e_filiere.EMBARQUE) {
            secondPinceau.setColor(new Color(24, 121, 16));
        } else if (filiere == e_filiere.VIRTUEL) {
            secondPinceau.setColor(new Color(188, 112, 1));
        } else {
            secondPinceau.setColor(Color.BLACK);
        }

        // On affiche des informations de la carte
        secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
        secondPinceau.setColor(Color.WHITE);
        secondPinceau.drawString("Carte UV", (int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.2));
        secondPinceau.drawString("Nombre de crédits: "+carte.getNbCreditDonne(), (int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.35));
        secondPinceau.drawString(("Besoin de "+carte.getNbPntCompNecessaire()+" compétences"), (int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.5));
        int bonus = carte.getBonusMention();
        if(bonus>0) {
            secondPinceau.drawString(("+"+bonus+" points"), (int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.65));
        }
        secondPinceau.drawRect(0, 0, this.getWidth(), this.getHeight());

        if (filiere == e_filiere.DATASCIENCE) {
            secondPinceau.drawString("Datascience", (int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.8));
        } else if (filiere == e_filiere.LOGICIEL) {
            secondPinceau.drawString("Logiciel", (int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.8));
        } else if (filiere == e_filiere.EMBARQUE) {
            secondPinceau.drawString("Embarqué", (int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.8));
        } else if (filiere == e_filiere.VIRTUEL) {
            secondPinceau.drawString("Virtuel", (int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.8));
        }
    }
}
