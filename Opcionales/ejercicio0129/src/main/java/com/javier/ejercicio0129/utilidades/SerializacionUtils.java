package com.javier.ejercicio0129.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializacionUtils {
	
	public static <T> boolean serializarListaObjetos(String directorio, 
			String nombreArchivo, List<T> objetos) {
		
		File fichero = new File(directorio + "/" + nombreArchivo);
		try {
			ObjectOutputStream ficheroObjetos = new ObjectOutputStream(
					new FileOutputStream(fichero));
			ficheroObjetos.writeObject(objetos);  // Serializa
			ficheroObjetos.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public static <T> List<T> desSerializarListaObjetos(String directorio, 
			String nombreArchivo) {
	
		File fichero = new File(directorio + "/" + nombreArchivo);
		try {
			FileInputStream ficheroSalida = new FileInputStream(fichero);
			ObjectInputStream ficheroObjetos = 
					new ObjectInputStream(ficheroSalida);
			List<T> objetos = (List<T>) ficheroObjetos.readObject();  // DesSerializa
			ficheroObjetos.close();
			return objetos;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}	
}
