package Core;

import java.io.Serializable;

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
		if(m != null){
			Matrice matriceT=this.transposition();
			if(matriceT.matrice.length==m.matrice.length){
				for(int x=0;x<matriceT.matrice.length;x++){
					if(matriceT.matrice[x].length != m.matrice[x].length){
						return null;
					}
					//faire reponse 
				}
			}
			else{
				return null;
			}
		}
		else{
			throw new ObjectNullException();
		}
	}
	
}
