package Core;

import java.io.Serializable;

import Erreur.NegatifNumberException;
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
		for(int i=0;i<nbContrainte;i++){
			try {
				this.matrice.setVariable(i, nbVariable+i, 1);
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

		
	}
	public String toString(){
		return this.matrice.toString();
	}
	public void calcul(){
		/*
		 * verif il y a au moins un nombre positif dans la derniere ligne or derniere colonne
		 * si faux on sort de la methode
		 */
		boolean verifPositif=false;
		
		for(int i=0;i<this.matrice.getNumberColonne()-1;i++){
			try {
				if(this.matrice.getVariable(this.matrice.getNumberLigne()-1, i)>0){
					verifPositif=true;
				}
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(verifPositif == false){
			return;
		}
		
		
		/*
		 * recherche de la colonne du pivot
		 * celle ci est le plus grand nombre sur la derniere ligne sauf derniere colonne
		 */
		double colonnePivot=-1;
		int cooColonnePivot = 0;
		for(int i=0;i<this.matrice.getNumberColonne()-1;i++){
			try {
				if(colonnePivot<this.matrice.getVariable(this.matrice.getNumberLigne()-1, i)){
					colonnePivot=this.matrice.getVariable(this.matrice.getNumberLigne()-1, i);
					cooColonnePivot=i;
				}
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * recherche de la ligne du pivot
		 * divise le therme independant par la colonne du pivot on prend le plus petit quotient
		 */
		double testPivot[]=new double[this.matrice.getNumberLigne()-1];
		for(int i=0;i<this.matrice.getNumberLigne()-1;i++){
			try {
				testPivot[i]=this.matrice.getVariable(i, this.matrice.getNumberColonne()-1)/this.matrice.getVariable(i, cooColonnePivot);
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int cooLignePivot=0;
		double pivot=testPivot[0];
		
		for(int i=0;i<testPivot.length;i++){
			if(testPivot[i]<pivot){
				cooLignePivot=i;
				pivot=testPivot[i];
			}
		}
		/*
		 * rendre la ligne du pivot unitaire
		 */
		for(int i=0;i<this.matrice.getNumberColonne();i++){
			try {
				this.matrice.setVariable(cooLignePivot, i, this.matrice.getVariable(cooLignePivot, i)/pivot);
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public void setVariable(int ligne,int colonne,double valeur)throws NegatifNumberException,NumberUnderLimitException{
		if(ligne <0 || colonne <0){
			throw new NegatifNumberException();
		}
		if(ligne>= this.matrice.getNumberLigne() || colonne>=this.matrice.getNumberColonne()){
			throw new NumberUnderLimitException();
		}
		this.matrice.setVariable(ligne, colonne, valeur);
	}
}