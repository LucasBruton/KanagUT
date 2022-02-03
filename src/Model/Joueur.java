package Model;

import java.util.ArrayList;

public class Joueur {
    private final int numero;
    private boolean currentPlayer;
    private boolean waiting;
    private boolean tourFini;
    private int nbDeplacementRestants;
    //nombre de choix dont le joueur dispose encore à placer
    private int nbChoix;
    private ArrayList<Specialisation> specialisations;
    private Parcours parcours;
    private Acquis acquis;

    public Joueur(int numero) {
        this.numero = numero;
        this.nbChoix=2;
        this.nbDeplacementRestants = 2;
        this.waiting=false;
        this.tourFini=false;
        this.specialisations=new ArrayList<>();
        this.parcours =new Parcours();
        this.acquis=new Acquis();
    }

    //###############   Getters     ######################//
    /**
     *
     * @return si le joueur est celui entrain de jouer
     */
    public boolean isCurrentPlayer() {
        return currentPlayer;
    }

    /**
     *
     * @return numéro du joueur
     */
    public int getNumero() {
        return numero;
    }

    /**
     * renvoie si le joueur à terminer son tour
     * @return true or false
     */
    public boolean isTourFini() {
        return tourFini;
    }

    public ArrayList<CarteComp> getCartesComp() {
        return acquis.getListCompetences();
    }

    /**
     *
     * @return nombre de choix disponibles
     */
    public int getNbChoixDispo() {
        return nbChoix - acquis.getNbCartesSelected();
    }

    /**
     *
     * @return nombre de déplacements restants
     */
    public int getNbDeplacementRestants() {
        return nbDeplacementRestants;
    }

    /**
     *
     * @return les cartes compétences sélectionnées par le joueur
     */
    public ArrayList<CarteComp> getCartesCompActives() {
        return acquis.getCarteCompActives();
    }

    /**
     *
     * @param filiere
     * @return nombre de crédits du joueur pour la filière donnée en paramètres
     */
    public int getNbCreditFiliere(e_filiere filiere) {
        int tempNb=0;
        for (CarteUV carteUV :
                parcours.getListeUvs()) {
            if (carteUV.getFiliere() == filiere) {
                tempNb += carteUV.getNbCreditDonne();
            }
        }
        return tempNb;
    }

    /**
     *
     * @param filiere
     * @return nombre de crédits du joueur pour la filière donnée en paramètres
     */
    public int getNbPntCompFiliere(e_filiere filiere) {
        int tempNb=0;
        for (CarteComp carteComp :
                acquis.getListCompetences()) {
            if (carteComp.isSelected() && carteComp.getFiliere()==filiere){
                tempNb++;
            }
        }
        return tempNb;
    }

    /**
     *
     * @return liste des specialisations du joueur
     */
    public ArrayList<Specialisation> getSpecialisations() {
        return specialisations;
    }

    /**
     *
     * @return liste des cartes Uvs du joueur
     */
    public ArrayList<CarteUV> getCartesUv() {
        return parcours.getListeUvs();
    }


    /**
     *
     * @return nombre de déplacements du joueur
     */
    private int getNbDeplacements() {
        //nombre de déplacements d'un joueur à l'origine
        int nbDepl=2 ;
        for (CarteComp carteComp:
                acquis.getListCompetences()) {
            //les autres déplacements sont donnés par les cartes compétences du joueur
            if (carteComp.getPlusDeplacement()){
                nbDepl++;
            }
        }
        return nbDepl;
    }

    /**
     *
     * @return nb de points du joueur
     */
    public int getPoints() {
        int points= 0;
        //points donnés par le spécialisations
        for (Specialisation specialisation :
                specialisations) {
            points+= specialisation.getMention();
        }
        //points bonus donnés par les cartes Uvs
        for (CarteUV carteUV :
                parcours.getListeUvs()) {
            points += carteUV.getBonusMention();
        }
        return points;
    }



    /**
     *
     * @return si le joueur est en attente
     */
    public boolean isWaiting() {
        return waiting;
    }



    public void setTourFini(boolean tourFini) {
        this.tourFini = tourFini;
    }


    /**
     *  permet d'ajouter une liste de cartes de compétences aux acquis du joueur
     * @param carteComps
     */
    public void addCartesComp(ArrayList<CarteComp> carteComps) {
        for (CarteComp carteComp :
                carteComps) {
            addCarteComp(carteComp);
        }
    }

    /**
     * permet d'ajouter une carte compétence aux acquis du joueur
     * @param carteComp
     */
    public void addCarteComp(CarteComp carteComp) {
        if (carteComp.getplusChoix()){
            this.nbChoix++;
        }
        if (carteComp.getPlusDeplacement()){
            this.nbDeplacementRestants++;
        }
        acquis.addComp(carteComp);
    }

    /**
     *  permet d'ajouter une liste de cartes d'Uv au parcours du joueur
     * @param carteUVS
     */
    public void addCartesUvs(ArrayList<CarteUV> carteUVS) {
        parcours.addUvs(carteUVS);
    }

    /**
     * permet d'ajouter une carte Uv au parcours du joueur
     * @param carteUV
     */
    public void addCarteUv(CarteUV carteUV) {
        parcours.addUv(carteUV);
    }

    /**
     *
     * @return liste des cartes compétences du joueur
     */


    /**
     *  ajoute une spécialisation au joueur
     * @param specialisation
     */
    public void addSpe(Specialisation specialisation) {
        specialisations.add(specialisation);
    }




    /**
     *  permet de deplacer le choix situé sur la carte de numOldCarte à gauche ou à droite
     * @param numOldCarte
     * @param deplacement : >0 pour déplacer à droite et <0 pour déplacer à gauche
     */
    public void deplacerChoix(int numOldCarte, int deplacement){
        this.acquis.getListCompetences().get(numOldCarte).setSelection(false);
        this.acquis.getListCompetences().get(numOldCarte+deplacement).setSelection(true);
        nbDeplacementRestants --;
    }

    /**
     *  place un choix sur une carte
     * @param numCarteComp
     */
    public void placerChoix(int numCarteComp){
        acquis.getListCompetences().get(numCarteComp).setSelection(true);
    }


    /**
     * permet de placer un joueur en-temps que joueur courant ou l'inverse
     * @param currentPlayer
     */
    public void setCurrentPlayer(boolean currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    /**
     *  permet de mettre un joueur en attente
     * @param waiting
     */
    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }


    /**
     * remet le nombre de déplacements restant au joueur a sa valeur de début de tour
     */
    public void resetNbDeplacementRestants() {
        nbDeplacementRestants = getNbDeplacements();
    }


}

