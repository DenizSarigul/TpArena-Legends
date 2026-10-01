public class Mage extends Combattant {

    private int mana;
    
    public Mage() {
    	
    }

    public Mage(String unNom, int unPv, int unPvMax,
                int uneAttaque, int uneDefense,int uneMana) {

        super(unNom, unPv, unPvMax, uneAttaque, uneDefense);
        this.mana = uneMana;

        mana = 100;
    }

    
    public int attaquer(Combattant cible) {

        if (mana >= 30) {

            mana -= 30;

            int degats = getAttaque() * 2;

            cible.subirDegatsBruts(degats);

            return degats;

        } else {

            int degats = getAttaque() / 2;

            mana += 15;

            cible.subirDegats(degats);

            return degats;
        }
    }


	@Override
	public String getClasse() {
		// TODO Auto-generated method stub
		return null;
	}
}