
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Tournoi {

    private ArrayList<Combattant> participants;

    public Tournoi() {
        participants = new ArrayList<>();
    }

    public boolean inscrire(Combattant c) {
        if (c == null || participants.size() >= 8) {
            return false;
        }

        for (Combattant participant : participants) {
            if (participant.getNom().equalsIgnoreCase(c.getNom())) {
                return false;
            }
        }

        participants.add(c);
        return true;
    }

    public boolean desinscrire(String nom) {
        Iterator<Combattant> iterator = participants.iterator();

        while (iterator.hasNext()) {
            Combattant combattant = iterator.next();

            if (combattant.getNom().equalsIgnoreCase(nom)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public ArrayList<Combattant> getParticipants() {
        return new ArrayList<>(participants);
    }

    public Combattant duel(Combattant a, Combattant b) {
        System.out.println("\n=== DUEL : " + a.getNom()
            + " contre " + b.getNom() + " ===");

        Combattant premier;
        Combattant second;

        if (a.getAttaque() >= b.getAttaque()) {
            premier = a;
            second = b;
        } else {
            premier = b;
            second = a;
        }

        for (int tour = 1; tour <= 50; tour++) {

            Combattant attaquant;
            Combattant cible;

            if (tour % 2 == 1) {
                attaquant = premier;
                cible = second;
            } else {
                attaquant = second;
                cible = premier;
            }

            int degats = attaquant.attaquer(cible);

            System.out.println("Tour " + tour + " : "
                + attaquant.getNom() + " attaque "
                + cible.getNom() + " (" + degats
                + " dégâts bruts). PV restants de "
                + cible.getNom() + " : " + cible.getPv());

            if (cible.estKO()) {
                System.out.println(cible.getNom() + " est KO !");
                System.out.println("Vainqueur : "
                    + attaquant.getNom());

                return attaquant;
            }
        }

        double pourcentageA = (double) a.getPv() / a.getPvMax();
        double pourcentageB = (double) b.getPv() / b.getPvMax();

        Combattant vainqueur;

        if (pourcentageA >= pourcentageB) {
            vainqueur = a;
        } else {
            vainqueur = b;
        }

        System.out.println("Limite de 50 tours atteinte.");
        System.out.println("Vainqueur aux PV restants : "
            + vainqueur.getNom());

        return vainqueur;
    }

    public Combattant lancer() {
        if (participants.size() < 2) {
            System.out.println(
                "Il faut au moins 2 participants pour lancer le tournoi."
            );
            return null;
        }

        ArrayList<Combattant> restants =
            new ArrayList<>(participants);

        int manche = 1;

        while (restants.size() > 1) {
            System.out.println("\n========== MANCHE "
                + manche + " ==========");

            Collections.shuffle(restants);

            ArrayList<Combattant> gagnants = new ArrayList<>();

            int i = 0;

            while (i + 1 < restants.size()) {
                Combattant a = restants.get(i);
                Combattant b = restants.get(i + 1);

                Combattant gagnant = duel(a, b);

                gagnant.ajouterVictoire();
                gagnant.soigner(gagnant.getPvMax() - gagnant.getPv());

                gagnants.add(gagnant);

                i += 2;
            }

            if (i < restants.size()) {
                gagnants.add(restants.get(i));
                System.out.println(restants.get(i).getNom()
                    + " passe automatiquement à la manche suivante.");
            }

            restants = gagnants;
            manche++;
        }

        Combattant champion = restants.get(0);

        System.out.println("\n🏆 CHAMPION : "
            + champion.getNom() + " (" + champion.getClasse() + ")");

        return champion;
    }

    public ArrayList<Combattant> classement() {
        ArrayList<Combattant> resultat =
            new ArrayList<>(participants);

        for (int i = 0; i < resultat.size() - 1; i++) {
            for (int j = 0; j < resultat.size() - 1 - i; j++) {

                if (resultat.get(j).getVictoires()
                    < resultat.get(j + 1).getVictoires()) {

                    Combattant temp = resultat.get(j);
                    resultat.set(j, resultat.get(j + 1));
                    resultat.set(j + 1, temp);
                }
            }
        }

        return resultat;
    }

    public Map<String, Integer> statsParClasse() {
        Map<String, Integer> statistiques = new HashMap<>();

        for (Combattant participant : participants) {
            String classe = participant.getClasse();
            int victoires = participant.getVictoires();

            if (statistiques.containsKey(classe)) {
                statistiques.put(
                    classe,
                    statistiques.get(classe) + victoires
                );
            } else {
                statistiques.put(classe, victoires);
            }
        }

        return statistiques;
    }
}
