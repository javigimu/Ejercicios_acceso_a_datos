package com.fran.serializacion.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.fran.serializacion.entidades.Persona;

public class SerializacionUtils {

	/**
	 * @autor Javier
	 * @param directorio		Directorio donde se va a ubicar el fichero creado en la serialización
	 * @param nombreArchivo		Nombre del fichero
	 * @param p					Un objeto de la clase persona que se va a serializar
	 * @return
	 */
	// Serializa un objeto de la clase Persona
	public static boolean serializarPersona(String directorio, String nombreArchivo, Persona p) {
		
		File fichero = new File(directorio + "/" + nombreArchivo);
		try {
			FileOutputStream ficheroSalida = new FileOutputStream(fichero);
			ObjectOutputStream ficheroObjetos = new ObjectOutputStream(ficheroSalida);
			ficheroObjetos.writeObject(p);  // Serializa
			ficheroObjetos.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @autor Javier
	 * @param directorio		Directorio donde se va a ubicar el fichero creado en la serialización
	 * @param nombreArchivo		Nombre del fichero
	 * @param personas			Lista de Personas a serializar
	 * @return					Devuelve si la serialización ha sido correcta
	 */
	// Serializa una lista de la clase Persona
	public static boolean serializarListaPersonas(String directorio, String nombreArchivo, List<Persona> personas) {
		
		File fichero = new File(directorio + "/" + nombreArchivo);
		try {
			ObjectOutputStream ficheroObjetos = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroObjetos.writeObject(personas);  // Serializa
			ficheroObjetos.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @autor Javier
	 * @param directorio		Directorio donde se va a ubicar el fichero creado en la serialización
	 * @param nombreArchivo		Nombre del fichero
	 * @param objetos			Lista de objetos de cualquier clase a serializar
	 * @param <T>				El tipo de datos que va a llamar al método
	 * @return					Devuelve si la serialización ha sido correcta
	 */
	public static <T> boolean serializarListaObjetos(String directorio, String nombreArchivo, List<T> objetos) {
		
		File fichero = new File(directorio + "/" + nombreArchivo);
		try {
			ObjectOutputStream ficheroObjetos = new ObjectOutputStream(new FileOutputStream(fichero));
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

	/**
	 * @autor Javier
	 * @param directorio        Directorio donde se va a ubicar el fichero creado en la serialización
	 * @param nombreArchivo		Nombre del fichero
	 * @return					Devuelve un objeto de la clase Persona deserializada
	 */
	// Deserializa un fichero previamente serializado con un objeto de la clase Persona
	public static Persona desSerializarPersona(String directorio, String nombreArchivo) {
		
		File fichero = new File(directorio + "/" + nombreArchivo);
		try {
			FileInputStream ficheroSalida = new FileInputStream(fichero);
			ObjectInputStream ficheroObjetos = new ObjectInputStream(ficheroSalida);
			Persona p = (Persona) ficheroObjetos.readObject();  // DesSerializa
			ficheroObjetos.close();
			return p;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}

	/**
	 * @autor Javier
	 * @param directorio		Directorio donde se va a ubicar el fichero creado en la serialización
	 * @param nombreArchivo		Nombre del fichero
	 * @return					Devuelve una lista de objetos de la clase Persona deserializada
	 */
	// Deserializa un fichero previamente serializado con una lista de la clase Persona
	public static List<Persona> desSerializarListaPersonas(String directorio, String nombreArchivo) {
		
		File fichero = new File(directorio + "/" + nombreArchivo);
		try {
			FileInputStream ficheroSalida = new FileInputStream(fichero);
			ObjectInputStream ficheroObjetos = new ObjectInputStream(ficheroSalida);
			List<Persona> p = (List<Persona>) ficheroObjetos.readObject();  // DesSerializa
			ficheroObjetos.close();
			return p;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return null;
	}

	/**
	 * @autor Javier
	 * @param directorio		Directorio donde se va a ubicar el fichero creado en la serialización
	 * @param nombreArchivo		Nombre del fichero
	 * @param <T>				Tipo de objeto que llama al método
	 * @return					Devuelve una lista de objetos de cualquier deserializada
	 */
	// Deserializa un fichero previamente serializado con una lista de objetos genéricos
	// y devuelve una lista de objetos
	public static <T> List<T> desSerializarListaObjetos(String directorio, String nombreArchivo) {
	
		File fichero = new File(directorio + "/" + nombreArchivo);
		try {
			FileInputStream ficheroSalida = new FileInputStream(fichero);
			ObjectInputStream ficheroObjetos = new ObjectInputStream(ficheroSalida);
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
