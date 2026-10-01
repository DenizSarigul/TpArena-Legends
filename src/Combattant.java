
public abstract class Combattant {
	private String nom;
	private int pvMax;
	private int pv;
	private int attaque;
	private int defense;
	private static int nbCombattants;
	
	public Combattant() {
		
	}
	public Combattant(String unNom, int unPv, int unPvMax, int uneAttaque, int uneDefense) {

	    if (unNom == null || unNom.length() < 3 || unNom.length() > 15) {
	        throw new IllegalArgumentException("Le nom doit être entre 3 et 15 caractères.");
	    }

	    if (unPvMax < 50 || unPvMax > 300) {
	        throw new IllegalArgumentException("pvMax doit être entre 50 et 300.");
	    }

	    if (unPv < 0 || unPv > unPvMax) {
	        throw new IllegalArgumentException("pv doit être entre 0 et pvMax.");
	    }

	    if (uneAttaque < 5 || uneAttaque > 50) {
	        throw new IllegalArgumentException("attaque doit être entre 5 et 50.");
	    }

	    if (uneDefense < 0 || uneDefense > 30) {
	        throw new IllegalArgumentException("defense doit être entre 0 et 30.");
	    }

	    this.nom = unNom;
	    this.pvMax = unPvMax;
	    this.pv = unPv;
	    this.attaque = uneAttaque;
	    this.defense = uneDefense;
	}
	protected String getNom() {
		return nom;
	}
	protected void setNom(String unNom) {
		this.nom = unNom;
	}
	protected int getPvMax() {
		return pvMax;
	}
	protected void setPvMax(int unPvMax) {
		this.pvMax = unPvMax;
	}
	protected int getPv() {
		return pv;
	}
	protected int getAttaque() {
		return attaque;
	}
	protected void setAttaque(int uneAttaque) {
		this.attaque = uneAttaque;
		
	}
	protected int getDefense() {
		return defense;
	}
	protected void setDefense(int uneDefense) {
		this.defense = uneDefense;
	}
	    
	public void subirDegats(int d) {

	    int degat = d - defense;

	    if (degat < 1) {
	        degat = 1;
	    }

	    pv = pv - degat;

	    if (pv < 0) {
	        pv = 0;
	    }
	}
	    
	    
	public void soigner(int s) {

	    if (pv == 0) {
	        return;
	    }

	    pv = pv + s;

	    if (pv > pvMax) {
	        pv = pvMax;
	    }
	}
	public boolean estKO() {
	    return pv == 0;
	}
	protected void subirDegatsBruts(int d) {

	    pv = pv - d;

	    if (pv < 0) {
	        pv = 0;
	    }
	}
	public abstract String getClasse();
	
	 @Override
	    public String toString() {
		   return getClasse() + " " + nom + " [" + pv + "/" + pvMax + " PV] ATK " + attaque + " DEF " + defense;
	    }
	 public abstract int attaquer(Combattant cible);
	
	
	

}
