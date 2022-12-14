package ejercicio0109;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fusionar dos ficheros de texto en un tercer fichero
 * @author Javi
 *
 */
public class Ejercicio0109 {
	public static void main(String[] args) {
		if (args.length == 3) {
			String fEntrada1 = args[0];
			String fEntrada2 = args[1];
			String fSalida = args[2];
			
			if (new File(fEntrada1).exists() && new File(fEntrada2).exists()) {
				
				List<String> datosf1 = leerFichero(fEntrada1);
				List<String> datosf2 = leerFichero(fEntrada2);
				List<String> datosSalida = datosf1;				
				
				for (String linea : datosf2)
					datosSalida.add(linea);
				
				Collections.sort(datosSalida);
				
				try (PrintWriter pw = new PrintWriter(fSalida)){
					for (String linea : datosSalida)
						pw.println(linea);
					
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("Ficheros combinados correctamente");
			}else {
				System.out.println("Error en los ficheros de entrada");
			}	
		}else {
			System.out.println("Los parametros no son correctos");
		}
	}
	
	private static List<String> leerFichero(String fichero){
		List<String> datos = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(
				fichero))){
			String linea = null;
			
			while ((linea = br.readLine()) != null) {
				datos.add(linea);
			}			
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return datos;
	}
}
