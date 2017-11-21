package Erreur;

public class ObjectNullException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ObjectNullException(){
		super("Object can't be null");
	}
}
