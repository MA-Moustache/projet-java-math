package Core;

import Erreur.NumberUnderLimitException;

public class Matrice {


	private double matrice[][];
	
	public Matrice(int x, int y)throws NumberUnderLimitException{
		if(x>0 && y>0){
			this.matrice=new double[x][y];
		}
		else{
			throw new NumberUnderLimitException();
		}
	}
	
	public void setVariable(int x, int y, double contenu)throws NumberUnderLimitException{
		if(x>0 && x<=this.matrice.length){
			if(y>0 && y<=this.matrice[x].length){
				this.matrice[x][y]=contenu;
			}
			else{
				throw new NumberUnderLimitException();
			}
		}
		else{
			throw new NumberUnderLimitException();
		}
	}
	
	public int getNbVariables() {
		return nbVariables;
	}


	public int getNbContraintes() {
		return nbContraintes;
	}
	
	
}
