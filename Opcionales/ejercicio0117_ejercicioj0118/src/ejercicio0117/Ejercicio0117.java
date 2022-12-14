package ejercicio0117;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Serializar y deserializar datos de personas
 * @author Javi
 *
 */
public class Ejercicio0117 {
	public static void main(String[] args) {

		Persona p1 = new Persona("Javier", "javi@gmail.com", 
				LocalDate.of(1979, 11, 19));
		
		Persona p2 = new Persona("Ana", "ana@gmail.com", 
				LocalDate.of(1978, 9, 27));
		
		List<Persona> personas = new ArrayList<>();
		personas.add(p1);
		personas.add(p2);
		
		try {
			Serializar(personas);
			System.out.println("Personas serializadas correctamente");
		}catch(FileNotFoundException fne) {
			System.err.println("El fichero no existe: " + fne.getMessage());
		}catch(IOException ioe) {
			System.err.println("Error de escritura en el fichero: " + 
					ioe.getMessage());
		}
		
		personas.clear();
		System.out.println("Lista de personas vacia");
		
		System.out.println("Deserializacion:");		
		try {
			personas = Deserializar(personas);
			
			for (Persona p : personas)
				System.out.println(p);
				
		}catch (FileNotFoundException fne) {
			fne.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
	}
	
	private static void Serializar(List<Persona> listaPersonas) 
		throws FileNotFoundException, IOException{
			FileOutputStream ficheroSalida = new FileOutputStream(
					new File("personas.dat"));
			ObjectOutputStream oos = new ObjectOutputStream(ficheroSalida);
			
			oos.writeObject(listaPersonas);					
	}
	
	private static List<Persona> Deserializar(List<Persona> listaPersonas)
		throws FileNotFoundException, IOException, EOFException, 
		ClassNotFoundException {
		
		File fichero = new File("personas.dat");
		FileInputStream fis = new FileInputStream(fichero);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		return listaPersonas = (List<Persona>)ois.readObject();
	}
}
