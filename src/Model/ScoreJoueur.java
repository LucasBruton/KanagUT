package Model;

// Classe contenant le numéro d'un joueur ainsi que son score
public class ScoreJoueur {
    // Numéro du joueur
    private final int numJoueur;
    // Score du joueur
    private final int score;

    /**
     * Constructeur de la classe
     * @param numJoueur
     *  Numéro du joueur
     * @param score
     * Score du joueur
     */
    public ScoreJoueur(int numJoueur, int score) {
        this.numJoueur = numJoueur;
        this.score = score;
    }

    /**
     * 
     * @return numéro du joueur
     */
    public int getNumJoueur() {
        return numJoueur;
    }

    /**
     * 
     * @return score du joueur
     */
    public int getScore() {
        return score;
    }
}
