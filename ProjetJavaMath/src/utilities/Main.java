package utilities;

import java.util.Scanner;

import Core.Matrice;
import Core.Simplexe;
import Erreur.NegatifNumberException;
import Erreur.NumberUnderLimitException;
import Erreur.ObjectNullException;

public class Main
{

	public static void main(String[] args)
	{
		/*
		Matrice m=null;
		try
		{
			m=new Matrice(2,2);
			m.setVariable(0, 0, 2.);
			m.setVariable(0, 1, 1.);
			m.setVariable(1, 0, 0.);
			m.setVariable(1, 1, -2.);
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice m\n"+m);
		}
		System.out.println("nombre de variable "+m.getNbVariables());
		System.out.println("Nombre de contraintes "+m.getNbContraintes());
		Matrice m2=m;
		System.out.println("Matrice m equals Matrice m2 is "+m.equals(m2));
		Matrice m3=null;
		try{
			m3=new Matrice(2,2);
			m3.setVariable(0, 0, 1.);
			m3.setVariable(0, 1, 1.);
			m3.setVariable(1, 0, 0.);
			m3.setVariable(1, 1, -2.);
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice m3\n"+m3);
		}
		//Pour le equals les test on été fait si la matrice est cloner et si on change les dimension mais pas les valeurs également. Donc une matrice est éagale à une autre si et seulement si elle 
		//ont les mêmes dimensions et les mêmes valeurs au même position.
		System.out.println("Matrice m equals Matrice m3 is "+m.equals(m3));
		Matrice m4=null;
		try{
			m4=new Matrice(2,2);
			m4.setVariable(0, 0, -1.);
			m4.setVariable(0, 1, -1.);
			m4.setVariable(1, 0, -1.);
			m4.setVariable(1, 1, -1.);
			m3=m3.sommeMatrice(m4);
			//la somme avec une matrice null donne la matrice, la somme avec des valeur postives ou négative modifie la valeur qui se trouve à la même postion dans la matrice résultat.
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		catch(ObjectNullException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice m4\n"+m4);
			System.out.println("Modification de m3 par m3=m3+m4\n"+m3);
		}
		
		try {
			System.out.println("Transpotision de m\n"+m.transposition());
		} catch (ObjectNullException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		Matrice identite=null;
		try{
			identite=new Matrice(2,2);
			identite.setVariable(0, 0, 1.);
			identite.setVariable(0, 1, 0.);
			identite.setVariable(1, 0, 0.);
			identite.setVariable(1, 1, 1.);
			//erreur dans la multiplication
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice identité\n"+identite);
		}	
		
		Matrice mEtIdent = null;

		try {
			mEtIdent = m.produitMatrice(identite);
		} catch (ObjectNullException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NegatifNumberException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NumberUnderLimitException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally
		{
			System.out.println("Matrice m multipliée par la matrice identité\n" + mEtIdent);
		}
		
		Matrice mike = null;;
		try
		{
			mike = new Matrice(2, 3);
			mike.setVariable(0, 0, 1);
			mike.setVariable(0, 1, 3);
			mike.setVariable(0, 2, 2);
			mike.setVariable(1, 0, 1);
			mike.setVariable(1, 1, 0);
			mike.setVariable(1, 2, 2);
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice mike\n"+mike);
		}
		
		Matrice mike2 = null;
		try
		{
			mike2 = new Matrice(3, 2);
			mike2.setVariable(0, 0, 1);
			mike2.setVariable(0, 1, 4);
			mike2.setVariable(1, 0, 2);
			mike2.setVariable(1, 1, 0);
			mike2.setVariable(2, 0, 1);
			mike2.setVariable(2, 1, 3);
		}
		catch(NegatifNumberException e){
			System.err.println(e.getMessage());
		}
		catch(NumberUnderLimitException e){
			System.err.println(e.getMessage());
		}
		finally{
			System.out.println("Matrice mike2\n"+mike2);
		}
		
		
		Matrice mikeMult = null;
		try 
		{
			mikeMult = mike.produitMatrice(mike2);
		} catch (ObjectNullException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NegatifNumberException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberUnderLimitException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Matrice Mikes multipliées\n" + mikeMult);
		}
		*/
		
		
		// Étape 1: Encoder les données
		
		Simplexe m = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nombre de contraintes: ");
		int nbContraintes = scan.nextInt();
		
		System.out.println("Nombre de variables: ");
		int nbVariables = scan.nextInt();
		
		try {
			m=new Simplexe(nbContraintes,nbVariables);
		} catch (NumberUnderLimitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double valeur;
		System.out.println(m.toString());
		for(int i=0;i<nbContraintes;i++){
			int j=i+1;
			System.out.println("Contrainte n°"+j);
			for(int v=0;v<nbVariables;v++){
				int w=v+1;
				System.out.println("Valeur de la variable n°"+w);
				valeur=scan.nextDouble();
				try {
					m.setVariable(i, v, valeur);
				} catch (NegatifNumberException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NumberUnderLimitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Therme independant: ");
			valeur=scan.nextDouble();
			try {
				m.setVariable(i, nbContraintes+nbVariables, valeur);
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(m.toString());
		//fonction recherche
		System.out.println("Fonction objective");
		for(int i=0;i<nbVariables;i++){
			System.out.println("Valeur de la variable");
			valeur=scan.nextDouble();
			try {
				m.setVariable(nbContraintes, i, valeur);
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(m.toString());
		m.calcul();		
		System.out.println(m.toString());		
	}

}
