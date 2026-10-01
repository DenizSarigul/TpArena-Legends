
public class Guerrier extends Combattant {
	private int rage = 0;
	
	public Guerrier() {
		
	}
	public Guerrier(String unNom,int unPv,int unPvMax,int uneAttaque,int uneDefense,int uneRage) {
		super(unNom,unPv,unPvMax,uneAttaque,uneDefense);
		this.rage = uneRage;
				
		
	}
	public int attaquer(Combattant cible) {

	    rage += 20;

	    int attaque = getAttaque();

	    if (rage == 100) {
	        attaque = getAttaque() * 2;
	        rage = 0;
	    }

	    cible.subirDegats(attaque);

	    return attaque;
	}
	@Override
	public String getClasse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
