package Vue;

import javax.swing.*;

import Model.*;

import java.awt.*;
import java.util.ArrayList;

// Panneau affichant le parcours du joueur
public class PanneauParcours extends javax.swing.JPanel {

    /**
     * Constructeur de la classe
     * 
     * @param fenetre
     *  Fenetre du jeu
     */
    public PanneauParcours(Fenetre fenetre) {
        setLayout(new BorderLayout());
        KanagUT kanagUT = fenetre.getKanagUT();

        // Text indiquant des informations sur le joueur
        String text = "Crédits:";
        text += "\n - Virtuel: "+kanagUT.getNbCreditFiliere(e_filiere.VIRTUEL);
        text += "\n - Logiciel: " + kanagUT.getNbCreditFiliere(e_filiere.LOGICIEL);
        text += "\n - Embarqué: " + kanagUT.getNbCreditFiliere(e_filiere.EMBARQUE);
        text += "\n - Datascience: " + kanagUT.getNbCreditFiliere(e_filiere.DATASCIENCE);
        text+="\nNouveaux Choix de compétences: "+kanagUT.getNbNouveauxChoixJoueur();
        text+="\nNombre de déplacements de choix: "+kanagUT.getDeplacementsRestantsChoixJoueur()+"  ";
        text+="\nDiplômes: ";
        for(Specialisation spe: kanagUT.getSpecialisationsJoueur()) {
            if(spe.getFiliere() == e_filiere.VIRTUEL) {
                text += "\n - Virtuel: ";
            }else if (spe.getFiliere() == e_filiere.LOGICIEL) {
                text += "\n - Logiciel: ";
            }else if (spe.getFiliere() == e_filiere.EMBARQUE) {
                text += "\n - Embarqué: ";
            }else if (spe.getFiliere() == e_filiere.DATASCIENCE) {
                text += "\n - Datascience: ";
            }

            if(spe.getMention() == 1) {
                text += "mention AB  ";
            }else if (spe.getMention() == 2) {
                text += "mention B  ";
            }else if (spe.getMention() == 3) {
                text += "mention TB  ";
            }
        }

        // Ajout du text à la fenetre
        JTextArea textArea = new JTextArea(text);
        textArea.setBackground(getBackground());
        JPanel centrerTextArea = new JPanel(new GridBagLayout());
        centrerTextArea.add(textArea);
        add(centrerTextArea, BorderLayout.EAST);

        // Le code suivant permet de créer l'aspect visuel des cartes du parcours du joueur
        ArrayList<CarteUV> uv = kanagUT.getCartesParcours();
        ArrayList<CarteComp> comp = kanagUT.getCartesAcquis();
        // On détermine la taille du tableau dédié au visuels des cartes
        int sizeCartesJoueur = 8, uvSize = uv.size(), compSize = comp.size();

        if(sizeCartesJoueur < uvSize) {
            sizeCartesJoueur = uvSize;
        }
        if(sizeCartesJoueur < compSize) {
            sizeCartesJoueur = compSize;
        }

        JPanel cartesJoueur = new JPanel(new GridLayout(2, sizeCartesJoueur));
        int compteur = 0;
        // Création des cartes UV
        for (CarteUV carteUV : uv) {
            ++compteur;
            cartesJoueur.add(new UVComponent(carteUV));
        }
        // Si la partie des cartes UV n'est pas pleine, on comble l'espace avec des JPanel vide
        for (int i = 1; i <= sizeCartesJoueur - compteur; ++i) {
            cartesJoueur.add(new JPanel());
        }

        compteur = 0;
        // Création des cartes compétences
        for (CarteComp carteComp : comp) {
            ++compteur;
            cartesJoueur.add(new CompetenceComponent(carteComp));
        }
        // Si la partie des cartes compétences n'est pas pleine, on comble l'espace avec des JPanel vide
        for (int i = 1; i <= sizeCartesJoueur - compteur; ++i) {
            cartesJoueur.add(new JPanel());
        }

        add(cartesJoueur);
    }
}
