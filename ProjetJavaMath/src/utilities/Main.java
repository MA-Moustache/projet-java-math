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
			System.out.println("Terme independant: ");
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
		
		System.out.println("\n\n\nMatrice de départ\n--------------\n\n");
		System.out.println(m.toString());
		
		m.calcul();
		
		System.out.println("Matrice finale:\n-------------\n");
		System.out.println(m.toString());
		
		System.out.println("======================");
		System.out.println("|      SOLUTION      |");
		System.out.println("======================");
		
		String str = "";
		
		for(int i = 0; i < nbVariables; i++)
		{
			str += "x" + i + "*: " + m.donnerSolutionBase().get(i) + "\n";
			System.out.println("x" + i + "*: " + m.donnerSolutionBase().get(i));
		}
		System.out.println("Z*: " + m.donnerZ() );
		str += "Z*: " + m.donnerZ() + "\n";
		
		Serialisation.ecrireFichierTexte(m.toString() + "\n" + str , "Solution");
		
	}

}
