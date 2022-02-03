package Model;

import java.util.ArrayList;

public class ColonneCartesInscription {
    private ArrayList<Carte> colonne;


    public ColonneCartesInscription(Carte carte) {
        this.colonne = new ArrayList<>();
        this.colonne.add(carte);
    }

    /**
     *
     * @return la liste des cartes de la colonne
     */
    public ArrayList<Carte> getColonne() {
        return colonne;
    }

    /**
     *  ajoute une carte à la colonne
     * @param carte
     */
    public void addCarte(Carte carte){
        colonne.add(carte);
    }

    /**
     *
     * @return liste des cartes Uvs contenus dans la colonne : c'est celles qui n'ont pas été choisis en-temps que compétences
     */
    public ArrayList<CarteUV> getCartesUvNonChoisis() {
        ArrayList<CarteUV> carteUVS = new ArrayList<>();
        for (Carte carte :
                this.colonne) {
            //on récupère uniquement les cartes Uvs contenus dans les cartes restantes
            carteUVS.add(carte.getCarteUV());
        }
        return carteUVS;
    }
}
