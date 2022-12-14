package ejercicio0103;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * 
 * @author Javi
 * Escribir un triangulo en el fichero triangle.txt
 */
public class Ejercicio0103 {

	public static void main(String[] args) {
		try {
			dibujarTriangulo();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void dibujarTriangulo()
		throws IOException, Exception {
		PrintWriter pw = new PrintWriter("triangle.txt");
		int ancho, alto;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Datos del triangulo");
		System.out.print("Ancho: ");
		ancho = sc.nextInt();
		System.out.print("Alto: ");
		alto = sc.nextInt();
		
		int asteriscos = ancho;
		for (int fila=0; fila<alto; fila++) {
			for (int colAst=0; colAst < asteriscos; colAst++) {
				pw.print('*');
			}
			pw.println();
			asteriscos++;
		}
		pw.close();
		System.out.println("Triangulo creado correctamente");
	}
}
