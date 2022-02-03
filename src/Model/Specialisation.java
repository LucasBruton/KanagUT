package Model;

public class Specialisation {
    private final int creditNecessaire;
    private final e_filiere filiere;
    private final int mention;

    public Specialisation(int creditNecessaire, e_filiere filiere, int mention) {
        this.creditNecessaire = creditNecessaire;
        this.filiere = filiere;
        this.mention = mention;
    }

    /**
     *
     * @return nb creditNecessaire
     */
    public int getCreditNecessaire() {
        return creditNecessaire;
    }

    /**
     *
     * @return filiere
     */
    public e_filiere getFiliere() {
        return filiere;
    }

    /**
     *
     * @return mention
     */
    public int getMention() {
        return mention;
    }
}
