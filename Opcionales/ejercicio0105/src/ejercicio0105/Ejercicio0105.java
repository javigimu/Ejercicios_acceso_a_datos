package ejercicio0105;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * En cada ejecución añadirá al log que contendrá la fecha 
 * (en formato 19-09-2019), la hora (17:02:09) y el texto introducción 
 * por el usuario
 * @author Javi
 *
 */

public class Ejercicio0105 {

	public static void main(String[] args) {
		DateTimeFormatter formatFecha = 
				DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter formatHora =
				DateTimeFormatter.ofPattern("HH:mm:ss");
		
		LocalDate fecha = LocalDate.now();
		LocalTime hora = LocalTime.now();
		String textoLog;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce el texto del log: ");
		textoLog = sc.nextLine();
		
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(
				new FileWriter("log.txt", true)))) {			
			
			pw.println(formatFecha.format(fecha) + " " +
			formatHora.format(hora) + " " + textoLog);			
		}catch (FileNotFoundException fne) {
			fne.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// Escribir en el fichero log2.txt usando streams
		String linea = formatFecha.format(fecha) + " " + formatHora.format(hora)
			+ " " + textoLog;
		Path path = Paths.get("log2.txt");
		
		if (!new File("log2.txt").exists()) {
			try (BufferedWriter bw = Files.newBufferedWriter(path, 
					Charset.defaultCharset(), StandardOpenOption.CREATE)){
				bw.append(linea);
				bw.newLine();
				
				System.out.println("Logs creados correctamente");
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else {
			try (BufferedWriter bw = Files.newBufferedWriter(path, 
					Charset.defaultCharset(), StandardOpenOption.APPEND)){
				bw.write(linea);
				bw.newLine();
				
				System.out.println("Logs creados correctamente");
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
