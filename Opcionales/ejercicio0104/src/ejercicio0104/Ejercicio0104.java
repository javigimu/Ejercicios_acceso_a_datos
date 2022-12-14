package ejercicio0104;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Javi
 * escribe un rectangulo hueco en el fichero rectangle.txt
 */

public class Ejercicio0104 {

	public static void main(String[] args) {
		int ancho, alto;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Datos del rectangulo");
		System.out.print("Ancho: ");
		ancho = sc.nextInt();
		System.out.print("Alto: ");
		alto = sc.nextInt();
		
		int espacios = ancho-2;	
		int asteriscos = ancho;
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("rectangle.txt");
			
			for (int fila = 0; fila < alto; fila++) {
				if (fila == 0 || fila == alto-1) {
					for (int colAst=0; colAst<asteriscos; colAst++)
						pw.print('*');
				}else {
					pw.print('*');
					for (int colEspacios=0; colEspacios<espacios; colEspacios++)
						pw.print(' ');
					pw.print('*');
				}
				pw.println();
			}
			System.out.println("Rectangulo creado correctamente");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (pw != null)
				pw.close();
		}
	}

}
