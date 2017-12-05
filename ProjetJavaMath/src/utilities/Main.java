package utilities;

import java.util.Scanner;

import Core.Matrice;
import Erreur.NegatifNumberException;
import Erreur.NumberUnderLimitException;

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
		//Pour le equals les test on �t� fait si la matrice est cloner et si on change les dimension mais pas les valeurs �galement. Donc une matrice est �agale � une autre si et seulement si elle 
		//ont les m�mes dimensions et les m�mes valeurs au m�me position.
		System.out.println("Matrice m equals Matrice m3 is "+m.equals(m3));
		Matrice m4=null;
		try{
			m4=new Matrice(2,2);
			m4.setVariable(0, 0, -1.);
			m4.setVariable(0, 1, -1.);
			m4.setVariable(1, 0, -1.);
			m4.setVariable(1, 1, -1.);
			m3=m3.sommeMatrice(m4);
			//la somme avec une matrice null donne la matrice, la somme avec des valeur postives ou n�gative modifie la valeur qui se trouve � la m�me postion dans la matrice r�sultat.
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
			System.out.println("Matrice identit�\n"+identite);
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
			System.out.println("Matrice m multipli�e par la matrice identit�\n" + mEtIdent);
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
			System.out.println("Matrice Mikes multipli�es\n" + mikeMult);
		}
		
		*/
		
		// �tape 1: Encoder les donn�es
		
		Matrice m = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nombre de contraintes: ");
		int nbContraintes = scan.nextInt();
		
		System.out.println("Nombre de variables: ");
		int nbVariables = scan.nextInt();
		
		try {
			m = new Matrice(nbContraintes + 1, (nbContraintes > nbVariables)? nbContraintes + nbVariables + 1 : nbVariables*2 + 1);
		} catch (NumberUnderLimitException e) {
			e.printStackTrace();
		}
		
		int valeur;
		for(int i = 1; i <= nbContraintes; i++)
		{
			System.out.println("Contrainte n�" + i);
			for(int y = 1; y <= nbVariables; y++)
			{
				System.out.println("Valeur de la variable n�" + y + ": ");
				valeur = scan.nextInt();
				try {
					m.setVariable(i-1, y-1, valeur);
				} catch (NegatifNumberException e) {
					e.printStackTrace();
				} catch (NumberUnderLimitException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(m.toString());

		// On remplit la partie identit�
		for(int i = nbVariables; i < m.getSizeColonne() - 1; i++)
		{
			try {
				m.setVariable(i - nbVariables, i, 1);
			} catch (NegatifNumberException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberUnderLimitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(m.toString());
		
		
		
		
		
		
		
	}

}
