
import java.util.Random;
import java.util.Arrays;

public class StatsArene {

    public static double moyenne(int[] t) {
        if (t.length == 0) {
            throw new IllegalArgumentException("Le tableau est vide.");
        }

        int somme = 0;

        for (int i = 0; i < t.length; i++) {
            somme += t[i];
        }

        return (double) somme / t.length;
    }

    public static int max(int[] t) {
        

        int max = t[0];

        for (int i = 1; i < t.length; i++) {
            if (t[i] > max) {
            	max = t[i];
            }
        }

        return max;
    }

    public static int min(int[] t) {
        

        int min = t[0];

        for (int i = 1; i < t.length; i++) {
            if (t[i] < min) {
            	min = t[i];
            }
        }

        return min;
    }

    public static int[] trierDecroissant(int[] t) {
        int compteur = 0;

        for (int i = 0; i < t.length - 1; i++) {
            boolean echanges = false;

            for (int j = 0; j < t.length - 1 - i; j++) {
                if (t[j] < t[j + 1]) {
                    int temp = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = temp;

                    echanges = true;
                    compteur++;
                }
            }

            if (!echanges) {
                break;
            }
        }

        System.out.println("Nombre d'échanges : " + compteur);

        return t;
    }

    public static int[] sansDoublons(int[] t) {
        int[] temporaire = new int[t.length];
        int taille = 0;

        for (int i = 0; i < t.length; i++) {
            boolean existe = false;

            for (int j = 0; j < taille; j++) {
                if (t[i] == temporaire[j]) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                temporaire[taille] = t[i];
                taille++;
            }
        }

        int[] resultat = new int[taille];

        for (int i = 0; i < taille; i++) {
            resultat[i] = temporaire[i];
        }

        return resultat;
    }

    public static char[][] creerGrille() {
        char[][] grille = new char[8][8];
        Random random = new Random();

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = '.';
            }
        }

        int obstacles = 0;

        while (obstacles < 6) {
            int ligne = random.nextInt(8);
            int colonne = random.nextInt(8);

            if (grille[ligne][colonne] == '.') {
                grille[ligne][colonne] = '#';
                obstacles++;
            }
        }

        placerCombattant(grille, 'A', random);
        placerCombattant(grille, 'B', random);

        return grille;
    }

    private static void placerCombattant(
        char[][] grille, char combattant, Random random
    ) {
        while (true) {
            int ligne = random.nextInt(8);
            int colonne = random.nextInt(8);

            if (grille[ligne][colonne] == '.') {
                grille[ligne][colonne] = combattant;
                return;
            }
        }
    }

    public static void afficherGrille(char[][] grille) {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(grille[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static int distance(char[][] grille) {
        int ligneA = -1;
        int colonneA = -1;
        int ligneB = -1;
        int colonneB = -1;

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if (grille[i][j] == 'A') {
                    ligneA = i;
                    colonneA = j;
                } else if (grille[i][j] == 'B') {
                    ligneB = i;
                    colonneB = j;
                }
            }
        }

        if (ligneA == -1 || ligneB == -1) {
            throw new IllegalArgumentException(
                "La grille doit contenir A et B."
            );
        }

        return Math.abs(ligneA - ligneB)
             + Math.abs(colonneA - colonneB);
    }
}
