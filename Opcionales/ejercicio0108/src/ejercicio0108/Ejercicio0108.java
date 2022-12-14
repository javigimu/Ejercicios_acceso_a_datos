package ejercicio0108;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Cuenta las vocales que hay en un fichero de texto
 * @author Javi
 *
 */
public class Ejercicio0108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fichero;
		
		System.out.print("Introduce el nombre del fichero a invertir: ");
		fichero = sc.nextLine();
		
		if (new File(fichero).exists())
			System.out.println("cantidad de vocales: " + contarVocales(fichero));
		else
			System.out.println("El fichero no existe");
	}

	private static int contarVocales(String fichero) {	
		int cantidadVocales = 0;
		List<String> datos = new ArrayList();
		
		if (new File(fichero).exists()) {
		
			try (BufferedReader br = new BufferedReader(new FileReader(
					fichero))){
				String linea = null;
				
				while ((linea = br.readLine()) != null) {
					datos.add(linea);
				}		
				
			}catch(IOException ioe){
				ioe.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			for (String linea : datos){
				for (int i = 0; i < linea.length(); i++) {
					if (esVocal(linea.charAt(i))) {
						cantidadVocales++;
					}
				}
			}		
		}
		return cantidadVocales;
	}

	private static boolean esVocal(char letra) {
		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' ||
				letra == 'u')
			return true;
		else
			return false;
	}
}
