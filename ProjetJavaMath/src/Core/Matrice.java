package Core;

import java.io.Serializable;

import Erreur.NegatifNumberException;
import Erreur.NumberUnderLimitException;
import Erreur.ObjectNullException;

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
	 * Retourne le nombre de variables (et donc de lignes) de la matrice
	 * 
	 * @return Le nombre de variables
	 */
	public int getNbVariables() {
		return this.matrice[0].length;
	}
	
	/**
	 * Retourne le nombre de contraintes (et donc de colonnes) de la matrice
	 * 
	 * @return Le nombre de contraintes
	 */
	public int getNbContraintes() {
		return this.matrice.length;
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
		String str="";
		for(int x=0;x<matrice.length;x++){
			for(int y=0;y<matrice[x].length;y++){
				str+=matrice[x][y]+"| ";
			}
			str+="\n";
		}
		return str;
	}
	
	/**
	 * 
	 * @param m Matrice à additionner
	 * @return Une matrice réponse si pas d'erreur, sinon null
	 * @throws ObjectNullException L'objet passé en paramètre est null
	 */
	public Matrice sommeMatrice(Matrice m)throws ObjectNullException
	{
	if(m != null)
	{
		if(this.matrice.length == m.matrice.length)
		{
				for(int x = 0; x < this.matrice.length; x++)
				{
					if(this.matrice[x].length != m.matrice[x].length)
					{
						return null;
					}
				}
				
				Matrice rep = null;
				
				try 
				{
					rep=new Matrice(this.matrice.length, this.matrice[0].length);
					
				} catch (NumberUnderLimitException e)
				{
					e.printStackTrace(); // Éviter de gerer les exceptions dans une méthode comme celle ci, autant faire un throw - Mike
				}
				
				for(int x = 0; x < this.matrice.length; x++)
				{
					for(int y = 0; y < this.matrice[x].length; y++)
					{
						rep.matrice[x][y]=this.matrice[x][y]+m.matrice[x][y];
					}
				}
				return rep;
			}
			return null;
		}
		else
		{
			throw new ObjectNullException();
		}
	}
	
	/**
	 * Transpose la matrice
	 * @return Une matrice transposée de celle sur laquelle on applique la méthode
	 * @throws ObjectNullException La matrice est nulle
	 */
	public Matrice transposition()throws ObjectNullException
	{
		if(this.matrice != null)
		{
			Matrice rep = null;
			try
			{
				rep = new Matrice(this.matrice[0].length, this.matrice.length);
			} 
			catch (NumberUnderLimitException e)
			{
				e.printStackTrace();
			}
			for(int x = 0; x < this.matrice.length; x++)
			{
				for(int y = 0; y < this.matrice[x].length; y++)
				{
					rep.matrice[y][x] = this.matrice[x][y];
				}
			}
			return rep;
		}
		else
		{
			throw new ObjectNullException();
		}
		
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 * @throws ObjectNullException
	 * @throws NumberUnderLimitException 
	 * @throws NegatifNumberException 
	 */
	public Matrice produitMatrice(Matrice m)throws ObjectNullException, NegatifNumberException, NumberUnderLimitException
	{
		
		if(m != null)
		{
			if(this.getSizeColonne() == m.getSizeLigne())
			{
				
				Matrice rep = null;
				
				try 
				{
					rep = new Matrice(this.getSizeLigne(), m.getSizeColonne());
				}
				catch (NumberUnderLimitException e)
				{
					e.printStackTrace();
				}
				
				for(int ligne = 0; ligne < rep.getSizeLigne(); ligne++)
				{
					for(int colonne = 0; colonne < rep.getSizeColonne(); colonne++)
					{
						rep.setVariable(ligne, colonne, 0);
					}
				}
				
				for(int i = 0; i < rep.getSizeLigne(); i++)
				{
					for(int y = 0; y < rep.getSizeColonne(); y++)
					{
						// A partir d'ici on parcours chaque case de notre matrice REP
						for(int z = 0; z < this.getSizeColonne(); z++)
						{
							rep.matrice[i][y] += this.matrice[i][z] * m.matrice[z][y];
						}
					}
				}
				return rep;
			}
			else
			{
				return null;
			}
		}
		else
		{
			throw new ObjectNullException();
		}
	}
	
	public int getSizeLigne(){
		return this.matrice.length;
	}
	
	public int getSizeColonne(){
		return this.matrice[0].length;
	}
	
	public Matrice clone(){
		return null; // Pour eviter erreurs
	}
}
