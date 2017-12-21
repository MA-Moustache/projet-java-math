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
		
		Serialisation.ecrireFichierTexte(m.toString(), "Solution");
		
	}

}
