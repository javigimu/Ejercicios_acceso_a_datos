package ejercicio0114;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * valida si un fichero binario es un bmp válido, dos primeros bytes: B y M
 * @author Javi
 *
 */
public class Ejercicio0114 {

	public static void main(String[] args) {
		if (new File("welcome8.bmp").exists()) {
			File fichero = new File("welcome8.bmp");

			try(InputStream fIn = new FileInputStream(fichero)){
				byte[] datos = new byte[2];
				fIn.read(datos, 0, 2);
				
				if ((char)datos[0] == 'B' && (char)datos[1] == 'M')
					System.out.println("Es un fichero BMP valido");
				else
					System.out.println("No es un fichero BMP valido");
				
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		}else {
			System.out.println("El fichero no existe");
		}
	}
}
