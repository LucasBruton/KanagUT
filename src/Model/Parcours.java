package Model;

import java.util.ArrayList;

public class Parcours {
    private final ArrayList<CarteUV> listeUvs;

    public Parcours() {
        listeUvs = new ArrayList<CarteUV>();
    }

    /**
     *
     * @return liste des uvs
     */
    public ArrayList<CarteUV> getListeUvs() {
        return listeUvs;
    }

    /**
     *
     * @param carteUVS
     */
    public void addUvs(ArrayList<CarteUV> carteUVS) {
        listeUvs.addAll(carteUVS);
    }

    /**
     *
     * @param carteUV
     */
    public void addUv(CarteUV carteUV) {
        listeUvs.add(carteUV);
    }
}
