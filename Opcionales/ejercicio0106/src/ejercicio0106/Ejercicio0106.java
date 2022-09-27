package ejercicio0106;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;


/**
 * escribe un rectangulo en el fichero rectangulo.txt
 * @author Javi
 *
 */
public class Ejercicio0106 {

	public static void main(String[] args) {
		int filas, columnas;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce los datos del rectangulo");
		System.out.print("Filas: ");
		filas = sc.nextInt();
		System.out.println("Columnas: ");
		columnas = sc.nextInt();
		
		crearRectangulo(filas, columnas);		
	}
	
	public static void crearRectangulo(int filas, int columnas) {
		try (PrintWriter pw = new PrintWriter("rectangulo.txt")){
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					pw.print('*');
				}
				pw.println();
			}
			System.out.println("Rectangulo creado correctamente");			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
