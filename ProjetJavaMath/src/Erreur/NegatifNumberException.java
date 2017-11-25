package Erreur;

public class NegatifNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	public NegatifNumberException(){
		super("Negative position doesn't exist");
	}
}
