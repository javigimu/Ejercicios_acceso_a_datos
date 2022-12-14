package ejercicio0113;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parte en trozos de un tamaño prefijado un fichero pedido al usuario
 * @author Javi
 *
 */
public class Ejercicio0113 {

	public static void main(String[] args) {
		int tamanyoTrozo = 512; // 512 bytes
		Scanner sc = new Scanner(System.in);
		String nombreFichero, nombreNuevoFichero;
		
		System.out.print("Nombre del fichero a trocear: ");
		nombreFichero = sc.nextLine();
		System.out.print("Nombre del fichero a crear: ");
		nombreNuevoFichero = sc.nextLine();
		
		if (new File(nombreFichero).exists()) {
			File fichero = new File(nombreFichero);
			File fichero2 = new File(nombreNuevoFichero);
			
			try (InputStream fIn = new FileInputStream(fichero);
					OutputStream fOut = new FileOutputStream(fichero2)){
				int cantidadLeida;
				int numeroDeTrozos = (int)fichero.length() / tamanyoTrozo;
				List<byte[]> listaDatos = new ArrayList<>();
				byte[] datos = new byte[tamanyoTrozo];
				
				while ((cantidadLeida = fIn.read(datos, 0, tamanyoTrozo)) > 0) {
					listaDatos.add(datos);
				}
				
				/* comprobación de lectura de trozos correcta
				for (byte[] dato : listaDatos) {
					for (byte d : dato)
						System.out.print((char)d + "");
					System.out.println();
				}
				*/
				
				// ahora genero un segundo fichero uniendo los trozos
				for (byte[] dato : listaDatos) {
					fOut.write(dato, 0, tamanyoTrozo);
				}
								
				System.out.println("Fichero troceado correctamente");	
				
			} catch (IOException ioe) {
				System.err.println("Error de lectura: " + ioe.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("El fichero no existe");
		}

	}

}
