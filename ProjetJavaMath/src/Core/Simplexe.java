package Core;

import java.io.Serializable;

import Erreur.NumberUnderLimitException;

public class Simplexe implements Serializable{
	private static final long serialVersionUID = 1L;
	private Matrice matrice;
	public Simplexe(int nbContrainte,int nbVariable)throws NumberUnderLimitException{
		
		int nbLigne = nbContrainte+1;
		int nbColonne=nbContrainte+nbVariable+1;
		
		try {
			this.matrice=new Matrice(nbLigne,nbColonne);
		} 
		catch (NumberUnderLimitException e) {
			e.printStackTrace();
		}
		//remplissage de la matrice simplexe, rentrer matrice indentité

		for(int x=0;x<nbContrainte;x++){
			try {
				this.matrice.setVariable(x, nbVariable+x, 1);
			} 
			catch (NumberUnderLimitException e) {
				e.printStackTrace();
			}
		}
	}
	public String toString(){
		return this.matrice.toString();
	}
}