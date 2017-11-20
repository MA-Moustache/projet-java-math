package Core;

import Erreur.NumberUnderLimitException;

public class Matrice {


	private double matrice[][];
	
	public Matrice(int nbContrainte, int nbVariable)throws NumberUnderLimitException{
		if(nbContrainte>0 && nbVariable>0){
			this.matrice=new double[nbContrainte][nbVariable];
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
		return this.matrice[0].length;
	}


	public int getNbContraintes() {
		return this.matrice.length;
	}
	public boolean equals(Object o){
		if(o instanceof Matrice){
			Matrice m=(Matrice)o;
			for(int x=0;x<this.matrice.length;x++){
				for(int y=0;y<this.matrice[x].length;y++){
					if(this.matrice[x][y] != m.matrice[x][y]){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	public String toString(){
		String str="";
		for(int x=0;x<matrice.length;x++){
			for(int y=0;y<matrice[x].length;y++){
				str+=matrice[x][y]+" ";
			}
			str+="\n";
		}
		return str;
	}
	
}
