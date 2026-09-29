public class Voleur extends Combattant {
	private double esquive;
	
	public Voleur() {
		
	}
	public Voleur(String unNom,int unPvMax,int unPv,int uneAttaque,int uneDefense,double uneEsquive) {
		super(unNom,unPvMax,unPv,uneAttaque,uneDefense);
		this.esquive = uneEsquive;
				
		
	}
	public int attaquer(Combattant cible) {
		return 0;
	}
	
	

}