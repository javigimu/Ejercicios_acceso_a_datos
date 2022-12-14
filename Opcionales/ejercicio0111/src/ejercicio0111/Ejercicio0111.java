package ejercicio0111;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Javi
 * Extrae el contenido imprimible del fichero program.cs
 */

public class Ejercicio0111 {

	public static void main(String[] args) {
		ExtraerDatosImprimibles();
	}
	
	private static void ExtraerDatosImprimibles( ) {
		String ficheroEntrada = "program.cs";
		String ficheroSalida = "datosImprimibles.txt";
		
		if (new File(ficheroEntrada).exists()) {
			try (FileInputStream fIn = new FileInputStream(ficheroEntrada);
					PrintWriter pw = new PrintWriter(ficheroSalida)) {
				int data;
				
				while ((data = fIn.read()) != -1) {
					if (data == 10) // 10 es un salto de linea
						pw.println();
					if (data >= 32 && data <= 127)  {						
						pw.print((char)data);
					}
				}
				
				System.out.println("Datos extraidos correctamente");
			} catch (IOException ioe) {
				System.err.println("Error leyendo el fichero: " 
			+ ioe.getMessage());
			} catch (Exception e) {
				System.err.println("Error generico: " + e.getMessage());
			}			
			
		} else {
			System.out.println("El fichero \"program.cs\" no existe");
		}		
	}
}
