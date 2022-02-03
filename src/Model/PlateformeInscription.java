package Model;

import java.util.ArrayList;

public class PlateformeInscription {
    private ArrayList<ColonneCartesInscription> colonnes;

    public PlateformeInscription() {
        this.colonnes=new ArrayList<>();
    }

    /**
     *
     * @return liste des {@link ColonneCartesInscription}
     */
    public ArrayList<ColonneCartesInscription> getColonnes() {
        return colonnes;
    }

    /**
     * récupère la colonne d'index i
     * @param numColonne
     * @return colonne d'index i
     */
    public ColonneCartesInscription takeColonneI(int numColonne) {
        ColonneCartesInscription tempColonne = colonnes.get(numColonne);
        colonnes.remove(numColonne);
        return tempColonne;
    }


    /**
     *
     * @return liste des {@link ColonneCartesInscription}
     */
    public ArrayList<ColonneCartesInscription> getCartes() {
        return colonnes;
    }

    /**
     *  ajoute une liste de {@link ColonneCartesInscription} à la {@link PlateformeInscription}
     * @param colonnes
     */
    public void addColonnes(ArrayList<ColonneCartesInscription> colonnes) {
        this.colonnes.addAll(colonnes);
    }
}
