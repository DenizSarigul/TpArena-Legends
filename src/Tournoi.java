import java.util.ArrayList;

public class Tournoi {

    private ArrayList<Combattant> participants;

    public Tournoi() {
        participants = new ArrayList<>();
    }

    public boolean inscrire(Combattant c) {

        if (participants.size() >= 8) {
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

        for (int i = participants.size() - 1; i >= 0; i--) {

            Combattant participant = participants.get(i);

            if (participant.getNom().equalsIgnoreCase(nom)) {
                participants.remove(i);
                return true;
            }
        }

        return false;
    }
}