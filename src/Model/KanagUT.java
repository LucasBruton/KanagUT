package Model;

import java.util.ArrayList;
import java.util.Random;

public class KanagUT {
    private ArrayList<Joueur> joueurs;
    private int nbJoueurs;
    private PlateformeInscription plateformeInscription;
    private ColonneCartesInscription colonneCartesCoisis;
    private int semestre;
    private ArrayList<Carte> cartesJeu;
    private ArrayList<Specialisation> specialisations;
    private Joueur gagnant;

    /**
     *  constructeur de la classe KanagUT
     */
    public KanagUT() {
        this.semestre = 0;
        this.joueurs=new ArrayList<>();
        plateformeInscription = new PlateformeInscription();
        specialisations = new ArrayList<>();
        for (e_filiere filiere :
                e_filiere.values()) {
            for (int i = 1; i < 4; i++) {
                specialisations.add(new Specialisation(i*2,filiere,i));
            }
        }
        cartesJeu = generateAllCartes();

    }

    /**
     * rempli la plateforme d'inscription avec un nombre de colonnes correspondant au nombre de joueurs
     */
    public void setUpPlateform() {
        ArrayList<ColonneCartesInscription> tempColonnes = new ArrayList<>();
        for (int i = 0; i < nbJoueurs; i++) {
            tempColonnes.add(new ColonneCartesInscription(cartesJeu.get(i)));
            cartesJeu.remove(i);
        }
        plateformeInscription.addColonnes(tempColonnes);
    }

    /**
     *  génère aléatoirement les cartes du jeu
     * @return
     */
    private ArrayList<Carte> generateAllCartes() {
        Random rand = new Random();
        ArrayList<Carte> tempCartes= new ArrayList<>();
        ArrayList<CarteComp> tempCartesComp = generateCartesComp();
        ArrayList<CarteUV> tempcartesUVS = generateCartesUvs();

        for (int i = 12*4; i >0; i--) {
            int indexcomp=rand.nextInt(i);
            int indexUv=rand.nextInt(i);

            tempCartes.add(new Carte(tempCartesComp.get(indexcomp),tempcartesUVS.get(indexUv)));
            tempCartesComp.remove(indexcomp);
            tempcartesUVS.remove(indexUv);
        }
        return tempCartes;
    }

    /**
     *
     * @return liste de cartes compétences générées aléatoirement
     */
    private ArrayList<CarteComp> generateCartesComp() {
        Random random = new Random();
        ArrayList<CarteComp> tempcarteCarteComps = new ArrayList<>();
        for (e_filiere filiere :
                e_filiere.values()) {
            for (int i = 1; i <= 12; i++) {
                tempcarteCarteComps.add(new CarteComp(filiere,random.nextBoolean(), random.nextBoolean()));
            }
        }
        return tempcarteCarteComps;
    }

    /**
     *
     * @return liste de cartes Uvs générées aléatoirement
     */
    private ArrayList<CarteUV> generateCartesUvs() {
        Random random = new Random();
        ArrayList<CarteUV> tempcarteUVS = new ArrayList<>();
        for (e_filiere filiere :
                e_filiere.values()) {
            for (int i = 1; i <= 12; i++) {
                tempcarteUVS.add(new CarteUV(random.nextInt(2)+1, filiere, random.nextInt(2)+1, random.nextInt(4)));
            }
        }
        return tempcarteUVS;
    }

    /**
     *  permet de créer un nombre de joueurs passé en paramètres
     * @param nbJoueurs
     */
    public void createNJoueurs(int nbJoueurs) {
        for (int i = 0; i < nbJoueurs; i++) {
            joueurs.add(new Joueur(i));
        }
        joueurs.get(0).setCurrentPlayer(true);
        this.nbJoueurs = nbJoueurs;
    }




    //#####     Getters         ####//

    /**
     *
     * @return le nombre de joueurs
     */
    public int getNbJoueurs() {
        return nbJoueurs;
    }

    /**
     *
     * @return le joueur entrain de jouer
     */
    public Joueur getJoueurCourant(){
        for (Joueur joueur :
                this.joueurs) {
            if (joueur.isCurrentPlayer()){
                return joueur;
            }
        }
        return null;
    }

    /**
     *
     * @param cartesChoisis
     * @return listes des compétences choisies par le joueur courant
     */
    public ArrayList<CarteComp> getCartesCompetencesChoisis(ArrayList<Boolean> cartesChoisis){
        return getJoueurCourant().getCartesCompActives();
    }

    /**
     *
     * @return le nombre de nouveaux choix du joueur courant
     */
    public int getNbNouveauxChoixJoueur(){
        return getJoueurCourant().getNbChoixDispo();
    }

    /**
     *
     * @return liste des cartes sur la plateforme d'inscription
     */
      public ArrayList<ColonneCartesInscription> getCarteSurPlateforme(){
          return plateformeInscription.getColonnes();
      }


    /**
     * Permet d'indiquer quelle colonne de carte a été choisi avant de quitter la plateforme d'inscription
     * @param numColonne
    */
    public void setColonneCartesChoisi(int numColonne) {
        this.colonneCartesCoisis=plateformeInscription.takeColonneI(numColonne);
    }

    /**
     *
     * @return la colonne de cartes choisies par le joueur courant
     */
     public ColonneCartesInscription getColonneCartesChoisi() {
         return colonneCartesCoisis;
     }


    /**
     *
     * @return les cartes competences du joueur courant
     */
      public ArrayList<CarteComp> getCartesAcquis(){
          return getJoueurCourant().getCartesComp();
      }

    /**
     *
     * @return liste des cartes Uvs restantes après le choix des compétences
     */
     public ArrayList<CarteUV> getCartesUvRestantes(){
         return colonneCartesCoisis.getCartesUvNonChoisis();
     }

    /**
     *
     * @return nombre de déplacements restants au joueur courant
     */
    public int getDeplacementsRestantsChoixJoueur() {
        return getJoueurCourant().getNbDeplacementRestants();
    }


    /**
     *
     * @return liste des cartes Uv du parcours du joueur courant
     */
      public ArrayList<CarteUV> getCartesParcours(){
          return getJoueurCourant().getCartesUv();
      }

    /**
     *
     * @param filiere
     * @return nombre de crédits du joueur courant pour la filière donnée en paramètres
     */
    public int getNbCreditFiliere(e_filiere filiere) {
        return getJoueurCourant().getNbCreditFiliere(filiere);
    }

    /**
     *
     * @return liste des specialisations du joueur courant
     */
    public ArrayList<Specialisation> getSpecialisationsJoueur() {
        return getJoueurCourant().getSpecialisations();
    }

    /**
     *
     * @return liste des spécialisations non sélectionnées restantes dans le jeu
     */
    public ArrayList<Specialisation> getSpecialisations() {
        return specialisations;
    }

    /**
     *
     * @return si au moins un joueur est en attente
     */
    private boolean isThereJoueurEnAttente() {
        for (Joueur joueur :
                joueurs) {
            if (joueur.isWaiting()){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return score du gagnant de la partie
     */
    public ScoreJoueur getGagnant() {
        int maxPoint=0,numGagnant =0;
        for (Joueur joueur :
                joueurs) {
            if (maxPoint < joueur.getPoints()){
                this.gagnant=joueur;
                maxPoint=joueur.getPoints();
                numGagnant = joueur.getNumero();
            }
        }
        return new ScoreJoueur(numGagnant, maxPoint);
    }

    /**
     *
     * @return liste des scores des perdants de la partie
     */
    public ArrayList<ScoreJoueur> getPerdants() {
        ArrayList<ScoreJoueur> perdants = new ArrayList<>();
        for (Joueur joueur :
                joueurs) {
            if (joueur != gagnant) {
                perdants.add(new ScoreJoueur(joueur.getNumero(), joueur.getPoints()));
            }
        }
        return perdants;
    }


    /**
     *     Renvoie le numéro du joueur actuel
     */
    public int getNumJoueur() {
        return getJoueurCourant().getNumero();
    }

    /**
     *     Renvoie le numéro du semestre en cours
     */
    public int getNumSemestre() {
        return semestre;
    }


    //####      Setters         ####//

    /**
     * place un choix sur la carte compétence d'index index
     * @param index
     */
    public void addNouveauChoixSurCarteComp(int index){
        getJoueurCourant().placerChoix(index);
        }

    /**
     * ajoute la carte compétence en paramètre aux acquis du joueur courant
     * @param carteComp
     */
    public void addCompToAcquis(CarteComp carteComp){
        getJoueurCourant().addCarteComp(carteComp);
    }

    /**
     * permet d'ajouter une carte à chaque colonne restante de la plateformeInscription
     */
    public void addCarteToColonnes(){
        for (ColonneCartesInscription colonne :
                plateformeInscription.getColonnes()){
            //pioche une carte
            colonne.addCarte(cartesJeu.get(0));
            cartesJeu.remove(0);
        }
    }

    /**
     *
     * @param cartesUV
     */
    public void addUvsToParcours(ArrayList<CarteUV> cartesUV){
        getJoueurCourant().addCartesUvs(cartesUV);
    }

    /**
     *  permet de vérifier si le choix de la spécialisation à l'index indexSpecialisation est possible pour le joueur courant
     * @param indexSpecialisation
     */
    public boolean verifierPossibiliteeChoixSpe(int indexSpecialisation){
        e_filiere filiere=specialisations.get(indexSpecialisation).getFiliere();
        //le nombre de crédits pour la filière désirée doit être supérieur ou égale aux besoins de la spécialisation
        for (Specialisation specialisation :
                getJoueurCourant().getSpecialisations()) {
            //on ne peut pas prendre 2 spécialités d'une même filière
            if (specialisation.getFiliere() == specialisations.get(indexSpecialisation).getFiliere()){
                return false;
            }
        }
        return specialisations.get(indexSpecialisation).getCreditNecessaire() <= getJoueurCourant().getNbCreditFiliere(filiere)  ;
    }

    /**
     *  choisi la spécialité voulue en fonction de la position du choix dans la liste visuelle
     * @param indexSpecialisation
     */
    public void choixSpecialisation(int indexSpecialisation ){
        getJoueurCourant().addSpe(specialisations.get(indexSpecialisation));
        //une spécialisation ne peut etre choisis que par une personne
        specialisations.remove(indexSpecialisation);
    }

    //#### Fonctions        ####//

    /**
     *  permet de déplacer le choix situé sur la carte de numOldCarte à gauche ou à droite
     * @param numOldCarte
     * @param deplacement : >0 pour déplacer à droite et <0 pour déplacer à gauche
     */
    public void deplacementChoixCompetence(int numOldCarte, int deplacement ){
        getJoueurCourant().deplacerChoix(numOldCarte,deplacement);
    }

    /**
     *  vérifie si le jeu a atteint la fin d'un semestre
     * @return
     */
    public boolean checkFinSemestre(){
        //vérifie si tous les joueurs ont fini leur tour
        for (Joueur joueur :
                joueurs) {
            if (!(joueur.isTourFini())) {
                return false;
            }
        }
        return true;
    }

    /**
     * vérifie si on a atteint une situation de fin de jeu
     * @return
     */
    public boolean checkFinJeu(){
        //on a plus assez de cartes pour relancer un semestre
        if (cartesJeu.size()<nbJoueurs){
            return true;
        }
        //il n'y a plus de spécialisation à prendre
        if (specialisations.isEmpty()){
            return true;
        }
        for (Joueur joueur :
                joueurs) {
            if (joueur.getCartesUv().size()>10){
                return true;
            }
        }
        return false;
    }


    /**
     * Renvoie vrai si le joueur peut attendre durant son tour, sinon renvoie false
     * @return
     */
    public boolean joueurPeutAttendre() {
        int nbJoueursWaiting=0;
        for (Joueur joueur :
                joueurs) {
            if (joueur.isWaiting()){
                nbJoueursWaiting++;
            }
        }
        //si le joueur est en attente et qu'il est le dernier à attendre
        if (getJoueurCourant().isWaiting() && nbJoueursWaiting <2){
            getJoueurCourant().setWaiting(false);
            return false;
        }
        //il n'y a plus assez de cartes
        if (cartesJeu.size()<nbJoueurs){
            return false;
        }
        return plateformeInscription.getColonnes().get(0).getColonne().size() != 3;
    }

    /**
     * Le joueur attend avant de quitter la plateforme d'inscription
     */
    public void attendre() {
        getJoueurCourant().setWaiting(true);
    }

    /**
     * change de joueur courant
     */
    private void joueurSuivant() {
        int numNouvJoueur= getJoueurCourant().getNumero()+1;
        getJoueurCourant().setCurrentPlayer(false);
        joueurs.get(numNouvJoueur).setCurrentPlayer(true);
    }


    /**
     *
     * @param index
     */
    public void retirerCarteFromColonneChoisis(int index) {
        colonneCartesCoisis.getColonne().remove(index);
    }



    /**
     * Finit le tour du joueur
     */
    public void finTour() {

        //tous les joueurs ont fini leur tour
        if (checkFinSemestre()){
            finSemestre();
        }
        else {
            if (getJoueurCourant().getNumero() == nbJoueurs-1){
                //tous les joueurs ont joué une fois on rajoute une carte à toutes les colonnes restantes
                addCarteToColonnes();
                getJoueurCourant().setCurrentPlayer(false);
                if (isThereJoueurEnAttente()){
                    for (Joueur joueur :
                            joueurs) {
                        if (joueur.isWaiting()){
                            joueur.setCurrentPlayer(true);
                            break;
                        }
                    }
                }
            }
            else{
                joueurSuivant();
            }
        }


    }

    /**
     * fini le semestre en remettant les variables nécessaires à leurs valeurs par défaut
     */
    private void finSemestre() {
        for (Joueur joueur :
                joueurs) {
            joueur.setCurrentPlayer(false);
            joueur.setWaiting(false);
            joueur.setTourFini(false);
            joueur.resetNbDeplacementRestants();
        }
        setUpPlateform();
        joueurs.get(0).setCurrentPlayer(true);
        semestre++;

    }


    /**
     * ajoute les cartes Uvs restantes après sélection des choix sur les compétences si le nombre de crédits est suffisant
     */
    public void ajouterUvToParcours() {
        for (CarteUV carteUV :
                getCartesUvRestantes()) {
            if (getJoueurCourant().getNbPntCompFiliere(carteUV.getFiliere())>= carteUV.getNbPntCompNecessaire()){
                getJoueurCourant().addCarteUv(carteUV);
            }
        }
    }


    /**
     * fini le tour du joueur courant
     */
    public void setFinTourJoueur() {
        getJoueurCourant().setTourFini(true);
    }
}
