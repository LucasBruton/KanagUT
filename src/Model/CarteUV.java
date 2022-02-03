package Model;

public class CarteUV {
    private final int nbCreditDonne;
    private final e_filiere filiere;
    private final int nbPntCompNecessaire;
    private final int bonusMention;

    public CarteUV(int nbCredit, e_filiere filiere, int nbPntCompNecessaire, int bonusMention) {
        this.nbCreditDonne = nbCredit;
        this.filiere = filiere;
        this.nbPntCompNecessaire = nbPntCompNecessaire;
        this.bonusMention = bonusMention;
    }

    /**
     *
     * @return le nombre de crédits donné par la carte
     */
    public int getNbCreditDonne() {
        return nbCreditDonne;
    }

    /**
     *
     * @return la filière de la carte
     */
    public e_filiere getFiliere() {
        return filiere;
    }

    /**
     *
     * @return le nombre de points de compétences nécessaire pour obtenir cette carte Uv
     */
    public int getNbPntCompNecessaire() {
        return nbPntCompNecessaire;
    }

    /**
     *
     * @return le nombre de points bonus donnés par la carte UV
     */
    public int getBonusMention() {
        return bonusMention;
    }
}
