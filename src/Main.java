import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
    	int [] scores = {42, 87, 15, 90, 63, 80, 5, 71, 90, 34, 50, 28};
    	
    	int moyenne = StatsArene.moyenne(scores);
    	int max = StatsArene.max(scores);
    	int min = StatsArene.min(scores);
    	int trierDecroissant = StatsArene.trierDecroissant(scores);
    	
    	System.out.println("La moyenne est : " + moyenne);
    	System.out.println("Le max est : " + max);
    	System.out.println("Le minimum est : " + min);
    	System.out.println(trierDecroissant);

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
                    System.out.print("?Nomre de faces ");
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
                    }else if (nombreSaisi < 499) {
                    	System.out.println("Argent");
                    }else if (nombreSaisi< 1499) {
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