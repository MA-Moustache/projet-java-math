package utilities;

import Core.Simplexe;
import Erreur.NumberUnderLimitException;

public class Main {

	public static void main(String[] args) {
		Simplexe test01 = null;
		
		try {
			test01=new Simplexe(2,2);
		} 
		catch (NumberUnderLimitException e) {
			e.printStackTrace();
		}
		System.out.println(test01);
	}

}
