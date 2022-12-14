package ejercicio0119;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * Comprobar fichero bmp y mostrar el ancho y alto de la imagen
 * cabecera de 54 bytes 
 * 2 primeros bytes son B y M
 * ancho: 18 a 21
 * alto: 22 a 25
 * 
 * @author Javi
 *
 */
public class Ejercicio0119 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombreFichero;
		
		System.out.print("Nombre del fichero bmp: ");
		nombreFichero = sc.nextLine();
		
		if (new File(nombreFichero).exists()) {
			byte[] cabecera = new byte[54];
			
			try (RandomAccessFile raf = new RandomAccessFile(nombreFichero, "r")) {
				char cabecera1 = (char)raf.read();
				char cabecera2 = (char)raf.read();
				
				if (cabecera1 == 'B' && cabecera2 == 'M') {
					raf.seek(18);
					
					/* la informacion de ancho y alto se almancenan en formato
					 * little endian pero el metodo readInt lee en formato
					 * big endian, por lo que hay que invertir el dato 
					 * utilizando Integer.reverseBytes(valor)
					 */
					int ancho = raf.readInt();
					ancho = Integer.reverseBytes(ancho);
					int alto = raf.readInt();
					alto = Integer.reverseBytes(alto);
					
					System.out.println("Ancho x alto: " + ancho + " x " + alto);
					
				}else {
					System.out.println("No es un fichero bmp valido");
				}				
				
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
			
		}else {
			System.out.println("El fichero no existe");
		}
	}

}
