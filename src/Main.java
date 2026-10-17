import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
    	int [] scores = {42, 87, 15, 90, 63, 80, 5, 71, 72, 34, 50, 28};
    	
    	double moyenne = StatsArene.moyenne(scores);
    	int max = StatsArene.max(scores);
    	int min = StatsArene.min(scores);
    	int[] trierDecroissant = StatsArene.trierDecroissant(scores);
    	
    	System.out.println("La moyenne est : " + moyenne);
    	System.out.println("Le max est : " + max);
    	System.out.println("Le minimum est : " + min);
    	System.out.println("Décroissant : " + Arrays.toString(trierDecroissant));
    	
    	
    	Tournoi tournoi = new Tournoi();

    	// Création des 8 combattants
    	Combattant c1 = new Guerrier("Jax", 100, 100, 18, 6);
    	Combattant c2 = new Guerrier("Darius", 120, 120, 20, 8);

    	Combattant c3 = new Mage("Morgana", 100, 100, 18, 6);
    	Combattant c4 = new Mage("Merlin", 110, 110, 22, 5);

    	Combattant c5 = new Voleur("Talon", 100, 100, 16, 4, 30);
    	Combattant c6 = new Voleur("Ezio", 90, 90, 20, 5, 25);

    	Combattant c7 = new Paladin("Uther", 150, 150, 15, 10);
    	Combattant c8 = new Paladin("Arthur", 140, 140, 17, 8);

    	// Inscription des combattants
    	tournoi.inscrire(c1);
    	tournoi.inscrire(c2);
    	tournoi.inscrire(c3);
    	tournoi.inscrire(c4);
    	tournoi.inscrire(c5);
    	tournoi.inscrire(c6);
    	tournoi.inscrire(c7);
    	tournoi.inscrire(c8);

    	// Affichage des participants
    	System.out.println("===== PARTICIPANTS =====");
    	for (Combattant combattant : tournoi.getParticipants()) {
    	    System.out.println(combattant);
    	}

    	// Lancement du tournoi
    	Combattant champion = tournoi.lancer();

    	// Affichage du classement
    	System.out.println("\n===== CLASSEMENT =====");
    	for (Combattant combattant : tournoi.classement()) {
    	    System.out.println(
    	        combattant.getNom() + " - "
    	        + combattant.getVictoires() + " victoire(s)"
    	    );
    	}

    	// Statistiques par classe
    	System.out.println("\n===== STATISTIQUES PAR CLASSE =====");
    	System.out.println(tournoi.statsParClasse());
    	

        Scanner scanner = new Scanner(System.in);

        int choix;

        do {
            System.out.println("=== ARENA LEGENDS ===");
            System.out.println("1. Lancer un dé");
            System.out.println("2. Calculer un rang");
            System.out.println("3. Test de coup critique");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();

            switch (choix) {
            case 1:

                int faces = 0;

                do {
                    System.out.print("Nombre de faces ");
                    faces = scanner.nextInt();

                    if (faces < 4 || faces > 20) {
                        System.out.println("Le nombre de faces doit être entre 4 et 20.");
                    }

                } while (faces < 4 || faces > 20);

                Random random = new Random();

                int resultat = random.nextInt(faces) + 1;

                System.out.println("Résultat du dé : " + resultat);

                break;

                case 2:
                    System.out.println("Veuillez saisir un nombre de points");
                    int nombreSaisi = scanner.nextInt();
                    
                    if (nombreSaisi < 0) {
                        System.out.println("Erreur : le nombre de points ne peut pas être négatif.");
                    } 
                    else if(nombreSaisi < 100) {
                    	System.out.println("Bronze");
                    }else if (nombreSaisi < 500) {
                    	System.out.println("Argent");
                    }else if (nombreSaisi< 1500) {
                    	System.out.println("Or");
                    } else {
                    	System.out.println("Légende");
                    }
                    break;

                case 3:

                    Random random2 = new Random();

                    int critiques = 0;
                    int serie = 0;
                    int meilleureSerie = 0;

                    for (int i = 0; i < 10000; i++) {

                        int tirage = random2.nextInt(100);

                        if (tirage < 15) {

                            critiques++;
                            serie++;

                            if (serie > meilleureSerie) {
                                meilleureSerie = serie;
                            }

                        } else {

                            serie = 0;
                        }
                    }

                    double pourcentage = (critiques * 100.0) / 10000;

                    System.out.println("Nombre de critiques : " + critiques);
                    System.out.println("Pourcentage réel : " + pourcentage + "%");
                    System.out.println("Plus longue série de critiques : " + meilleureSerie);

                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        scanner.close();
    }
    
}