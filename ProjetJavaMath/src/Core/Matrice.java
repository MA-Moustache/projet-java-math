package Core;

import java.io.Serializable;

import Erreur.NegatifNumberException;
import Erreur.NumberUnderLimitException;
import Erreur.ObjectNullException;
import java.text.*;

public class Matrice{


	private double matrice[][];
	
	/**
	 * Constructeur de la classe Matrice
	 * 
	 * @param nbContrainte Le nombre de contraintes
	 * @param nbVariable Le nombre de variables
	 * @throws NumberUnderLimitException Le nombre de variable ou le nombre de contrainte est négatif
	 */
	public Matrice(int nbContrainte, int nbVariable)throws NumberUnderLimitException
	{
		if(nbContrainte > 0 && nbVariable > 0){
			this.matrice = new double[nbContrainte][nbVariable];
		}
		else{
			throw new NumberUnderLimitException();
		}
	}
	
	/**
	 * Cette méthode permet de remplir une case de la matrice avec une valeur de type double
	 * 
	 * @param x Le numéro de la colonne
	 * @param y Le numéro de la ligne
	 * @param contenu La valeur de la case
	 * @throws NegatifNumberException Valeur de la colonne / ligne négative
	 * @throws NumberUnderLimitException Dépassement de capacité de la valeur de la colonne / ligne
	 */
	public void setVariable(int x, int y, double contenu)throws NegatifNumberException, NumberUnderLimitException{
		if(x >= 0 && x <= this.matrice.length){
			if(y >= 0 && y <= this.matrice[x].length){
				this.matrice[x][y]=contenu;
			}
			else if(y < 0){
				throw new NegatifNumberException();
			}
			else{
				throw new NumberUnderLimitException();
			}
		}
		else if(x < 0){
			throw new NegatifNumberException();
		}
		else{
			throw new NumberUnderLimitException();
		}
	}
	

	/**
	 * Test l'égalité entre deux matrices en se basant sur leur contenu
	 * 
	 * @return True si elles sont égales, false sinon.
	 */
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
	
	
	/**
	 * Renvoie le contenu de la matrice sous forme d'une chaine de caractères
	 * 
	 * @return Le contenu de la matrice
	 */
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.00");
		
		String str="";
		for(int x=0;x<matrice.length;x++){
			for(int y=0;y<matrice[x].length;y++){
				str+=df.format(matrice[x][y])+"|";
			}
			str+="\n";
		}
		return str;
	}

	/**
	 * Retourne le nombre de ligne de la matrice
	 * @return Le nombre de ligne de la matrice
	 */
	public int getNumberLigne(){
		return this.matrice.length;
	}
	
	/**
	 * Retourne le nombre de colonne de la matrice
	 * @return Le nombre de colonne de la matrice
	 */
	public int getNumberColonne(){
		return this.matrice[0].length;
	}
	

	/**
	 * Récupère la valeur d'une variable en fonction de sa ligne et sa colonne dans la matrice du Simplexe
	 * @param ligne Ligne de la variable
	 * @param colonne Colonne de la variable
	 * @return La valeur de la variable
	 * @throws NegatifNumberException Valeur négative dans ligne ou colonne
	 * @throws NumberUnderLimitException Valeur de ligne ou colonne dépassant les limites de la matrice
	 */
	public double getVariable(int ligne,int colonne)throws NegatifNumberException,NumberUnderLimitException{
		if(ligne <0 || colonne<0){
			throw new NegatifNumberException();
		}
		if(ligne >=this.getNumberLigne() || colonne >= this.getNumberColonne()){
			throw new NumberUnderLimitException();
		}
		return this.matrice[ligne][colonne];
	}
}
