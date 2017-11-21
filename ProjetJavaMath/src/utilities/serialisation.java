package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Core.Simplexe;


public class serialisation {
	public static void saveRegistre(Simplexe o,String nomF){
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(nomF))){
			out.writeObject(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Simplexe readRegistre(String nomF){
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(nomF))){
			return (Simplexe)in.readObject();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
