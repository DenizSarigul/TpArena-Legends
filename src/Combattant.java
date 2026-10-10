
public abstract class Combattant {

    private final String nom;
    private final int pvMax;
    private int pv;
    private int attaque;
    private int defense;

    private static int nbCombattants = 0;
    private int victoires = 0;

    public Combattant(String nom, int pvMax, int pv, int attaque, int defense) {

        if (nom == null || nom.length() < 3 || nom.length() > 15) {
            throw new IllegalArgumentException(
                "Le nom doit contenir entre 3 et 15 caractères."
            );
        }

        if (pvMax < 50 || pvMax > 300) {
            throw new IllegalArgumentException(
                "Les PV maximum doivent être entre 50 et 300."
            );
        }

        if (pv < 0 || pv > pvMax) {
            throw new IllegalArgumentException(
                "Les PV doivent être entre 0 et les PV maximum."
            );
        }

        if (attaque < 5 || attaque > 50) {
            throw new IllegalArgumentException(
                "L'attaque doit être entre 5 et 50."
            );
        }

        if (defense < 0 || defense > 30) {
            throw new IllegalArgumentException(
                "La défense doit être entre 0 et 30."
            );
        }

        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;

        nbCombattants++;
    }

    public String getNom() {
        return nom;
    }

    public int getPvMax() {
        return pvMax;
    }

    public int getPv() {
        return pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getDefense() {
        return defense;
    }

    public static int getNbCombattants() {
        return nbCombattants;
    }

    public int getVictoires() {
        return victoires;
    }

    public void ajouterVictoire() {
        victoires++;
    }

    public void subirDegats(int degats) {
        int degatsReels = degats - defense;

        if (degatsReels < 1) {
            degatsReels = 1;
        }

        pv -= degatsReels;

        if (pv < 0) {
            pv = 0;
        }
    }

    protected void subirDegatsBruts(int degats) {
        pv -= degats;

        if (pv < 0) {
            pv = 0;
        }
    }

    public void soigner(int soin) {
        if (estKO() || soin <= 0) {
            return;
        }

        pv += soin;

        if (pv > pvMax) {
            pv = pvMax;
        }
    }

    public boolean estKO() {
        return pv == 0;
    }

    public abstract int attaquer(Combattant cible);

    public abstract String getClasse();

    @Override
    public String toString() {
        return getClasse() + " " + nom
            + " [" + pv + "/" + pvMax + " PV]"
            + " ATK " + attaque
            + " DEF " + defense;
    }
}
