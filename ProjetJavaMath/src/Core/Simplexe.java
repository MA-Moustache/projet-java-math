package Core;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Erreur.NegatifNumberException;
import Erreur.NumberUnderLimitException;

public class Simplexe implements Serializable{
	private static final long serialVersionUID = 1L;
	private Matrice matrice;
	private int nbIte;
	public Simplexe(int nbContrainte,int nbVariable)throws NumberUnderLimitException{
		
		int nbLigne = nbContrainte+1;
		int nbColonne=nbContrainte+nbVariable+1;
		nbIte = 1;
		
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
		int colonne = verifierLigne();
		
		if(colonne < 0)
		{
			System.out.println("Plus d'ittérations possible");
			return;
		}
		
		/*
		 * recherche de la colonne du pivot
		 * celle ci est le plus grand nombre sur la derniere ligne sauf derniere colonne
		 */
		int ligne = 0;
		double valLigne = Double.MAX_VALUE;
		
		for(int i = 0; i <= this.matrice.getNumberLigne() - 2; i++){
			try {
				if(this.matrice.getVariable(i, this.matrice.getNumberColonne()-1) / this.matrice.getVariable(i, colonne) < valLigne && (this.matrice.getVariable(i, this.matrice.getNumberColonne()-1) / this.matrice.getVariable(i, colonne) >= 0) ){
					valLigne = this.matrice.getVariable(i, this.matrice.getNumberColonne()-1) / this.matrice.getVariable(i, colonne);
					ligne = i;
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
		 * rendre la ligne du pivot unitaire
		 */
		double pivot=0;
		try {
			pivot = this.matrice.getVariable(ligne, colonne);
		} catch (NegatifNumberException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NumberUnderLimitException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i=0;i <= this.matrice.getNumberColonne()-1;i++){
			try {
				
				this.matrice.setVariable(ligne, i, this.matrice.getVariable(ligne, i) / pivot);
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// A partir d'ici, il faut siplement faire apparaitre des 0 dans les autres lignes du pivot
		pivot /= pivot;
		for(int i = 0; i <= this.matrice.getNumberLigne() - 1; i++)
		{
			if(i != ligne)
			{
				double nb = 0;
				try {
					nb = this.matrice.getVariable(i, colonne)/pivot;
				} catch (NegatifNumberException e) {
					e.printStackTrace();
				} catch (NumberUnderLimitException e) {
					e.printStackTrace();
				}
				
				for(int y = 0; y <= this.matrice.getNumberColonne() - 1; y++)
				{
					try {
						this.matrice.setVariable(i, y, this.matrice.getVariable(i, y) - this.matrice.getVariable(ligne, y)*nb);
					} catch (NegatifNumberException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NumberUnderLimitException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			
			
			
			}
		}
		
		System.out.println("Itération n°: " + nbIte + "\n");
		nbIte++;
		System.out.println(this.matrice.toString());
		System.out.println("Solution de base:");
		System.out.println(donnerSolutionBase().toString() + " Z = " + donnerZ() + "\n");
		this.calcul();
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
	

	public List<String> donnerSolutionBase(){
		List<String> sb = new ArrayList<>();
 		for(int j = 0 ; j < this.matrice.getNumberColonne() - 1; j++){
			int nbZero = 0;
			int nbUn = 0;
			int indLigne = 0;
			for(int i = 0 ; i < matrice.getNumberLigne(); i++){
				try {
					if(matrice.getVariable(i, j) == 1){
						nbUn++;
						indLigne = i;
					} else
						try {
							if(matrice.getVariable(i, j) == 0){
								nbZero++;
							}
						} catch (NegatifNumberException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NumberUnderLimitException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				} catch (NegatifNumberException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberUnderLimitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DecimalFormat df = new DecimalFormat("0.00");
			String adding;
			if(nbUn == 1 && nbZero == matrice.getNumberLigne()-1){
				try {
					adding = df.format(matrice.getVariable(indLigne, matrice.getNumberColonne()-1));
					sb.add(adding);
				} catch (NegatifNumberException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberUnderLimitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				sb.add("0");
			}
		}
		return sb;
	}
	
	
	public int verifierLigne()
	{
		int col = -1;
		double colVal = -1;
		for(int i = 0; i <= this.matrice.getNumberColonne() - 2; i++){
			try {
				if(this.matrice.getVariable(this.matrice.getNumberLigne()-1, i) > 0 && this.matrice.getVariable(this.matrice.getNumberLigne() - 1, i) > colVal){
					colVal = this.matrice.getVariable(this.matrice.getNumberLigne()-1, i);
					col = i;
				}
			} catch (NegatifNumberException e) {
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				e.printStackTrace();
			}
		}
		return col;
		
	}
	
	public double getVariable(int ligne, int colonne)
	{
		try {
			return this.matrice.getVariable(ligne, colonne);
		} catch (NegatifNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberUnderLimitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public double donnerZ()
	{
		try {
			return Math.abs(matrice.getVariable(matrice.getNumberLigne()-1, matrice.getNumberColonne()-1));
		} catch (NegatifNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberUnderLimitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}