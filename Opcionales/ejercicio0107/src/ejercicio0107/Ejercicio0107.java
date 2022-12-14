package ejercicio0107;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * Invierte un fichero de texto utilizando una pila
 * @author Javi
 *
 */
public class Ejercicio0107 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fichero;
		
		System.out.print("Introduce el nombre del fichero a invertir: ");
		fichero = sc.nextLine();
		
		invertir(fichero);
	}
	
	public static void invertir(String fichero) {
		if (new File(fichero).exists()) {
			Stack lineas = new Stack();
			int extension = fichero.lastIndexOf('.');
			String ficheroInvertido = fichero.substring(0, extension) + 
					"_invertido.txt";
					
			try (BufferedReader br = new BufferedReader(new FileReader(
					fichero));
					PrintWriter pw = new PrintWriter(ficheroInvertido)){
				
				String linea = null;				
				while ((linea = br.readLine()) != null) {
					lineas.push(linea);
				}
				
				while (lineas.size() > 0) {
					pw.println(lineas.pop());
				}
				
				System.out.println("Fichero invertido correctamente");
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}		
		}else {
			System.out.println("El fichero no existe");
		}
	}
}
