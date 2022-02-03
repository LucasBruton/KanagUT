package Model;

public class Carte {
    private int id;
    private boolean isPlaced;
    private CarteComp competence;
    private CarteUV uv;

    public Carte(CarteComp comp, CarteUV uv) {
        this.competence = comp;
        this.uv = uv;
    }

    /**
     *
     * @return la carte compétence de la carte globale
     */
    public CarteComp getCarteComp() {
        return competence;
    }

    /**
     *
     * @return la carte Uv de la carte globale
     */
    public CarteUV getCarteUV() {
        return uv;
    }
}
