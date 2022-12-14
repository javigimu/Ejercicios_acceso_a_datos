package ejercicio0112;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Copia un fichero binario guardando el fichero inicial en un solo bloque del
 * tamaño del fichero
 * @author Javi
 *
 */
public class Ejercicio0112 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombreFicheroInicial, nombreFicheroFinal;
		
		System.out.print("Nombre del fichero a copiar: ");
		nombreFicheroInicial = sc.nextLine();
		System.out.print("Nombre del fichero de destino: ");
		nombreFicheroFinal = sc.nextLine();
		
		if (new File(nombreFicheroInicial).exists()) {
			File fInicial = new File(nombreFicheroInicial);
			File fSalida = new File(nombreFicheroFinal);
			
			try (InputStream fIn = new FileInputStream(fInicial);
					OutputStream fOut = new FileOutputStream(fSalida)) {
				int tamanyoFichero = (int)fInicial.length();
				byte[] datos = new byte[tamanyoFichero];				
				int cantidadLeida;
				
				while ((cantidadLeida = fIn.read(datos, 0, tamanyoFichero)) > 0) {
					fOut.write(datos, 0, cantidadLeida);
				}
				
				System.out.println("Fichero copiado correctamente");
			} catch (IOException ioe) {
				System.err.println("Error de lectura de fichero: " 
						+ ioe.getMessage());
			} catch (Exception e) {
				System.err.println("Error inesperado: " + e.getMessage());
			}
		} else {
			System.out.println("El fichero no existe");
		}
		
	}
}
