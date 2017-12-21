package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import Core.Simplexe;


public class Serialisation {
	/**
	 * Cette m�thode permet de cr�er un ficher reprennant la matrice finale et ses solutions
	 * @param s La chaine de caract�re a �crire dans le fichier
	 * @param fileName Le nom du fichier
	 */
	public static void ecrireFichierTexte(String s, String fileName){
		try(PrintWriter print = new PrintWriter(fileName + ".txt")){
			print.println(s);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
}
