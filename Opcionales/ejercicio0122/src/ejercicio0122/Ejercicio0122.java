package ejercicio0122;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ejercicio 0121 añadiendo la opción de importar datos de friends.xml 
 * como fichero de texto
 * @author Javi
 *
 */

public class Ejercicio0122 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte opcion;
		boolean salirMenu = false;
		List<Persona> listaPersonas = cargarDatosFichero();
		
		do {
			mostrarMenu();
			System.out.println();
			System.out.print("Selecciona una opcion: ");
			opcion = recogerOpcion(sc);
			sc.nextLine();
			
			switch (opcion) {
				case 1: anyadirPersona(sc, listaPersonas); break;
				case 2: verNombres(sc, listaPersonas); break;
				case 3: buscar(sc, listaPersonas); break;
				case 4: exportarAXML(listaPersonas); break;
				case 5: listaPersonas = importarDesdeXML(); break;
				case 0: salirMenu = salir(); break;
				default: System.out.println("Opcion incorrecta"); break;
			}
			
		}while (!salirMenu);		
		
	}
	
	private static void Serializar(List<Persona> listaPersonas) 
		throws FileNotFoundException, IOException{
			FileOutputStream ficheroSalida = new FileOutputStream(
					new File("personas.dat"));
			ObjectOutputStream oos = new ObjectOutputStream(ficheroSalida);
			
			oos.writeObject(listaPersonas);					
	}
	
	private static List<Persona> Deserializar()
		throws FileNotFoundException, IOException, ClassNotFoundException {
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		File fichero = new File("personas.dat");
		FileInputStream fis = new FileInputStream(fichero);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		return listaPersonas = (List<Persona>)ois.readObject();
	}
		
	private static void mostrarMenu() {
		System.out.println("1. Añadir una persona");
		System.out.println("2. Ver nombres de todos");
		System.out.println("3. Buscar");
		System.out.println("4. Exportar personas a friends.xml");
		System.out.println("5. Importar desde friends.xml");
		System.out.println("0. Salir");
	}
	
	private static byte recogerOpcion(Scanner sc) {
		return sc.nextByte();
	}
	
	private static boolean salir() {
		return true;
	}
	
	private static void anyadirPersona(Scanner sc, List<Persona> listaPersonas) {
		String nombre = pedirDato(sc, "nombre");
		String email = pedirDato(sc, "email");
		int edad = pedirDatoEntero(sc, "edad");
		String comentarios = pedirDato(sc, "comentarios");		
		
		listaPersonas.add(new Persona(nombre, email, edad, comentarios));
		
		try {
			Serializar(listaPersonas);
		}catch (FileNotFoundException fne) {
			fne.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private static String pedirDato(Scanner sc, String aviso) {
		System.out.print("Introduce " + aviso + ": ");		
		return sc.nextLine();
	}
	
	private static int pedirDatoEntero(Scanner sc, String aviso) {
		int dato = -1;
		try {
			System.out.print("Introduce " + aviso + ": ");
			dato = sc.nextInt();			
			sc.nextLine();
		}catch (NumberFormatException nfe) {
			System.err.println("No es una edad valida: " + nfe.getMessage());
		}
		
		return dato;
	}
	
	private static void verNombres(Scanner sc, List<Persona> listaPersonas) {
		if (listaPersonas.size() > 0) {
			for (Persona p : listaPersonas)
				System.out.println(p.getNombre());		
		}else {
			System.out.println("Lista de personas vacia");
		}
	}
	
	private static void buscar(Scanner sc, List<Persona> listaPersonas) {
		String texto = pedirDato(sc, "texto a buscar");
		boolean encontrado = false;
		
		for (Persona p : listaPersonas) {
			if (p.contiene(texto)) {
				System.out.println(p);
				encontrado = true;
			}
		}
		if (!encontrado)
			System.out.println("No se han encontrado coincidencias");			
	}
	
	private static List<Persona> cargarDatosFichero() {
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		try {
			listaPersonas = Deserializar();
		}catch (FileNotFoundException fne) {
			System.err.println("El fichero no existe: " + fne.getMessage());
		}catch (IOException ioe) {
			System.err.println("Error de lectura de fichero: " + ioe.getMessage());
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		return listaPersonas;
	}

	// Exporta los datos de los amigos al fichero friends.xml
	private static void exportarAXML(List<Persona> listaPersonas) {
		
		String nombreXML = "friends.xml";
		
		try (PrintWriter pw = new PrintWriter(nombreXML)){
			pw.println("<personas>");
			for (Persona p : listaPersonas) {
				pw.println("\t<persona id=\"" + p.getNombre() + "\">");
				pw.println("\t\t<nombre>" + p.getNombre() + "</nombre>");
				pw.println("\t\t<email>" + p.getEmail() + "</email>");
				pw.println("\t\t<edad>" + p.getEdad() + "</edad>");
				pw.println("\t\t<comentarios>" + p.getComentarios() +
						"</comentarios>");
				
				pw.println("\t</persona>");
			}		
			pw.println("</personas>");
			
			System.out.println("Fichero friends.xml creado correctamente");
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	// Importar la lista de personas desde el fichero friends.xml
	private static List<Persona> importarDesdeXML(){
		List<Persona> listaPersonas = new ArrayList<Persona>();
		String nombreFicheroXML = "friends.xml";
		
		if (new File(nombreFicheroXML).exists()) {
			Path path = Paths.get(nombreFicheroXML);			
			
			try (BufferedReader br = new BufferedReader(new FileReader(
					new File(nombreFicheroXML)))){
				
				String linea = br.readLine();
				if (linea.startsWith("<personas>")) {
					while ((linea = br.readLine()) != null) {
						
						if (linea != null && linea.startsWith("\t<persona")) {
							linea = br.readLine();
							String nombre = linea.substring(linea.indexOf(">")+1,
									linea.lastIndexOf("<"));
							linea = br.readLine();
							String email = linea.substring(linea.indexOf(">")+1,
									linea.lastIndexOf("<"));
							linea = br.readLine();
							String edad = linea.substring(linea.indexOf(">")+1,
									linea.lastIndexOf("<"));
							linea = br.readLine();
							String comentarios = linea.substring(
									linea.indexOf(">")+1,
									linea.lastIndexOf("<"));
							
							listaPersonas.add(new Persona(nombre, email, 
									Integer.parseInt(edad),	comentarios));
						}						
					}	
				}					
						
				
				System.out.println("Fichero exportado correctamente");
				System.out.println("Datos exportados");
				listaPersonas.forEach(System.out::println);
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}			
			
		}else {
			System.out.println("El fichero friends.xml no existe");
		}
		
		
		return listaPersonas;
	}
	
}