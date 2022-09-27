package ejercicio0102;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Javi
 * @apiNote Escribir en fichero los numeros del 1 al 10
 */
public class Ejercicio0102 {

	public static void main(String[] args) {
		try (PrintWriter pw = new PrintWriter("datos.txt")) {
			for (int i=1; i<=10; i++)
			{
				if (i == 10)
					pw.print(i);
				else
					pw.println(i);
			}		
			System.out.println("Datos guardados correctamente en \"datos.txt\"");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
