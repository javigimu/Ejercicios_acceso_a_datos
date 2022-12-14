package ejercicio0115;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * comprueba si un fichero bmp es valido y está comprimido
 * @author Javi
 *
 */
public class Ejercicio0115 {

	public static void main(String[] args) {
		String nombreFichero;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nombre del fichero bmp: ");
		nombreFichero = sc.nextLine();
		
		if (new File(nombreFichero).exists()) {
			if (esUnBmpValidoComprimido(nombreFichero)) {
				System.out.println("Es un fichero bmp comprimido");
				
			}else {
				System.out.println("No es un fichero bmp comprimido");
			}
			
		}else {
			System.out.println("El fichero no existe");
		}
	}
	
	private static boolean esUnBmpValidoComprimido(String nombreFichero) {
		boolean esBmpValidoComprimido = false;
		
		if (new File(nombreFichero).exists()) {
			File fichero = new File(nombreFichero);

			try(RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw")){

				char cabecera1 = (char)raf.read();
				char cabecera2 = (char)raf.read();
				
				if (cabecera1 == 'B' && cabecera2 == 'M') {
					raf.seek(30);
					int compresion = raf.readInt();
					
					if (compresion == 0) 
						esBmpValidoComprimido = true;
				}					
				
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		}else {
			System.out.println("El fichero no existe");
		}
		return esBmpValidoComprimido;
	}
}
