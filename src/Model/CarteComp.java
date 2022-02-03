package Model;

public class CarteComp {
    private final e_filiere filiere;
    private boolean selected;
    private final boolean plusChoix;
    private final boolean plusDeplacement;

    public CarteComp(e_filiere filiere, boolean plusDeplacement, boolean plusChoix) {
        this.filiere = filiere;
        this.plusDeplacement = plusDeplacement;
        this.selected = false;
        this.plusChoix = plusChoix;
    }

    /**
     * @return l'état de sélection de la carte
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     *
     * @return la filière associée à la carte
     */
    public e_filiere getFiliere() {
        return filiere;
    }

    /**
     * set l'état de sélection de la carte
     * @param selected
     */
    public void setSelection(boolean selected) {
        this.selected = selected;
    }


    /**
     *
     * @return true si la carte offre un choix en plus
     */
    public boolean getplusChoix() {
        return plusChoix;
    }

    /**
     *
     * @return true si la carte offre un déplacement en plus
     */
    public boolean getPlusDeplacement() {
        return plusDeplacement;
    }
}
