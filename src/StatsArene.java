
public class StatsArene {
	
	
	public static int moyenne(int[]t) {
		int somme = 0;
		for (int i = 0;i<t.length;i++) {
			somme = somme + t[i];
			
		}
		return  somme / t.length;
		
	}
	public static int max(int[] t) {

	    int max = t[0];

	    for (int i = 1; i < t.length; i++) {

	        if (t[i] > max) {
	            max = t[i];
	        }

	    }

	    return max;
	}
	public static int min(int[]t) {
		int min = t[0];
		for(int i = 0;i<t.length;i++) {
			if(t[i]< min) {
				min = t[i];
			}
		}
		return min;
	}
	public static int[] trierDecroissant(int[]t) {
		
		int compteur = 0;
		boolean echanges;
		for (int i = 0; i < t.length; i++) {
			echanges = false;

            for (int j = i + 1; j < t.length; j++) {

                if (t[i] < t[j]) {

                    int temp = t[i];
                    t[i] = t[j];
                    t[j] = temp;
                    
                    echanges = true;
                    compteur ++;
                    
                }
            }
        }
		return t;
	}
	
	

		

}
