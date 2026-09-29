public class Mage extends Combattant {
	private int mana;
	
	public Mage() {
		
	}
	public Mage(String unNom,int unPvMax,int unPv,int uneAttaque,int uneDefense,int unMana) {
		super(unNom,unPvMax,unPv,uneAttaque,uneDefense);
		this.mana = unMana;
				
		
	}
	public int attaquer(Combattant cible) {
		return 0;
	}
	
	

}