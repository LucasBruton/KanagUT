package Model;

public class Main {
    // Lancement de l'application
    public static void main(String[] args) {
        // Création d'un thread pour lancer la fenetre du jeu
        (new Thread(new Start())).start();
    }
}
