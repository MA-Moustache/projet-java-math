package Erreur;

public class NumberUnderLimitException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NumberUnderLimitException(){
		super("Dimensions can be null or negative");
	}
}
