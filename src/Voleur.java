import java.util.Random;

public class Voleur extends Combattant {
	private double esquive;
	
	public Voleur() {
		
	}
	public Voleur(String unNom,int unPv,int unPvMax,int uneAttaque,int uneDefense,double uneEsquive) {
		super(unNom,unPv,unPvMax,uneAttaque,uneDefense);
		this.esquive = uneEsquive;
				
		
	}
	public int attaquer(Combattant cible) {

	    Random random = new Random();

	    int degats = getAttaque();

	    if (random.nextInt(100) < 25) {
	        degats = degats * 2;
	    }

	    cible.subirDegats(degats);

	    return degats;
	}
	 @Override
	    public void subirDegats(int d) {

	        Random random = new Random();

	        if (random.nextInt(100) < esquive) {
	            return;
	        }

	        super.subirDegats(d);;
	    }
	 @Override
	 public String getClasse() {
		// TODO Auto-generated method stub
		return null;
	 }
	 
	
	

}