package ejercicio0105b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


/**
 * muestra un fichero de log y si no existe se lo pide al usuario
 * @author Javi
 *
 */
public class Ejercicio0105b {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fichero = "log.txt";
		
		if (!(new File(fichero).exists())) {			
			System.out.println("El fichero no existe");
			System.out.print("Introduce el nombre del fichero de logs: ");
			fichero = sc.nextLine();
		}
		if (new File(fichero).exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(
					fichero))){
				String linea = null;
				
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}				
				
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}		
			
			
			// Lectura del fichero log.txt usando streams
			System.out.println();
			System.out.println("Fichero log.txt usando streams");
			Path path = Paths.get(fichero);
			
			try (Stream<String> stream = Files.lines(path)) {
				stream.forEach(System.out::println);				
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			
			// Lectura del fichero usando readAllLines(path, charset)
			System.out.println();
			System.out.println("Fichero log.txt usando readAllLines");
			
			try {
				List<String> lineas = Files.readAllLines(path, 
					StandardCharsets.UTF_8);
				lineas.stream().forEach(System.out::println);
				
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			
			
		}else {
			System.out.println("El fichero no existe");
		}
	}
}
