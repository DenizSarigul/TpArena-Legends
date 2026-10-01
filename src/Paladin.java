public class Paladin extends Guerrier {

    public Paladin(String unNom, int unPvMax, int unPv,
                   int uneAttaque, int uneDefense) {

        super();
    }

    @Override
    public int attaquer(Combattant cible) {

        int degats = super.attaquer(cible);

        int soin = degats / 10;

        soigner(soin);

        return degats;
    }

    @Override
    public String getClasse() {
        return "Paladin";
    }
}