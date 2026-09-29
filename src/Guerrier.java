
public class Guerrier extends Combattant {
	private int rage = 0;
	
	public Guerrier() {
		
	}
	public Guerrier(String unNom,int unPvMax,int unPv,int uneAttaque,int uneDefense,int uneRage) {
		super(unNom,unPvMax,unPv,uneAttaque,uneDefense);
		this.rage = uneRage;
				
		
	}
	public int attaquer(Combattant cible) {
		rage += 20;
		int attaque = getAttaque();
		if(rage == 100) {
			 attaque = getAttaque()*2;
			 cible.subirDegats(attaque);
			 
		} return attaque;
	}
	
	

}
