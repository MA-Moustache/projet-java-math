package Core;

import java.io.Serializable;

import Erreur.NegatifNumberException;
import Erreur.NumberUnderLimitException;
import Erreur.ObjectNullException;

public class Matrice{


	private double matrice[][];
	
	public Matrice(int nbContrainte, int nbVariable)throws NumberUnderLimitException{
		if(nbContrainte>0 && nbVariable>0){
			this.matrice=new double[nbContrainte][nbVariable];
		}
		else{
			throw new NumberUnderLimitException();
		}
	}
	public void setVariable(int x, int y, double contenu)throws NegatifNumberException, NumberUnderLimitException{
		if(x>=0 && x<=this.matrice.length){
			if(y>=0 && y<=this.matrice[x].length){
				this.matrice[x][y]=contenu;
			}
			else if(y<0){
				throw new NegatifNumberException();
			}
			else{
				throw new NumberUnderLimitException();
			}
		}
		else if(x<0){
			throw new NegatifNumberException();
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
				str+=matrice[x][y]+"| ";
			}
			str+="\n";
		}
		return str;
	}
	public Matrice sommeMatrice(Matrice m)throws ObjectNullException{
	if(m != null){
		if(this.matrice.length==m.matrice.length){
				for(int x=0;x<this.matrice.length;x++){
					if(this.matrice[x].length!=m.matrice[x].length){
						return null;
					}
				}
				Matrice rep = null;
				try {
					rep=new Matrice(this.matrice.length,this.matrice[0].length);
					
				} catch (NumberUnderLimitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int x=0;x<this.matrice.length;x++){
					for(int y=0;y<this.matrice[x].length;y++){
						rep.matrice[x][y]=this.matrice[x][y]+m.matrice[x][y];
					}
				}
				return rep;
			}
			return null;
		}
		else{
			throw new ObjectNullException();
		}
	}
	public Matrice transposition(Matrice m)throws ObjectNullException{
		if(m != null){
			Matrice rep=null;
			try {
				rep=new Matrice(m.matrice[0].length,m.matrice.length);
			} 
			catch (NumberUnderLimitException e) {
				e.printStackTrace();
			}
			for(int x=0;x<m.matrice.length;x++){
				for(int y=0;y<m.matrice[x].length;y++){
					rep.matrice[y][x]=m.matrice[x][y];
				}
			}
			return rep;
		}
		else{
			throw new ObjectNullException();
		}
		
	}	
	public Matrice transposition()throws ObjectNullException{
		if(this.matrice != null){
			Matrice rep=null;
			try {
				rep=new Matrice(this.matrice[0].length,this.matrice.length);
			} 
			catch (NumberUnderLimitException e) {
				e.printStackTrace();
			}
			for(int x=0;x<this.matrice.length;x++){
				for(int y=0;y<this.matrice[x].length;y++){
					rep.matrice[y][x]=this.matrice[x][y];
				}
			}
			return rep;
		}
		else{
			throw new ObjectNullException();
		}
		
	}
	public Matrice produitMatrice(Matrice m)throws ObjectNullException{
		//nombre de colonnes de la premiere egale au nombre de lignes de la seconde
		if(m != null){
			if(this.transposition().matrice.length == m.matrice.length){
				int taille=m.matrice.length;
				Matrice rep=null;
				try {
					rep=new Matrice(this.matrice.length,m.transposition().matrice.length);
				} 
				catch (NumberUnderLimitException e) {
					e.printStackTrace();
				}
				for(int ligne=0;ligne<rep.matrice.length;ligne++){
					for(int colonne=0;colonne<rep.matrice[ligne].length;colonne++){
						for(int z=0;z<taille;z++){
							rep.matrice[ligne][colonne]+=this.matrice[ligne][taille]+m.matrice[taille][colonne];
						}
						
					}
				}
				return rep;
			}
			else{
				return null;
			}
		}
		else{
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
		Matrice nouvelleMatrice =null;
		
		try {
			nouvelleMatrice =new Matrice(this.matrice.length,this.matrice[0].length);
		}
		catch (NumberUnderLimitException e) {
			e.printStackTrace();
		}
		for(int x=0;x<this.matrice.length;x++){
			for(int y=0;y<this.matrice[x].length;y++){
				nouvelleMatrice.matrice[x][y]=this.matrice[x][y];
			}
		}
		return nouvelleMatrice;
	}
}
