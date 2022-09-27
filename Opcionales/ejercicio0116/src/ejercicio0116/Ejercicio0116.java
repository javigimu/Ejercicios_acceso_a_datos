package ejercicio0116;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * muestra la información contenida en las etiquetas de un fichero mp3
 * @author Javi
 *
 */
public class Ejercicio0116 {

	public static void main(String[] args) {
		
		String nombreFichero = "mp3.mp3";
		
		if (new File(nombreFichero).exists()) {
			try (RandomAccessFile raf = 
					new RandomAccessFile(nombreFichero, "r")){
				
				/* ID3 version 1 tiene la cabecera de 128 bytes al final
				 * 3 primeros bytes TAG
				 * titulo 30 caracteres
				 * artista 30 caracteres
				 * album 30 caracteres
				 * año 4 caracteres
				 * comentario 30 caracteres
				 * genero musical 1 caracter				
				*/
				
				raf.seek(raf.length() - 128);
				char[] tag = new char[3];
				for (int i = 0; i < 3; i++)
					tag[i] = (char)raf.read();					
						
				String datoTag = String.valueOf(tag);
				if (datoTag.equals("TAG")) {		
					char[] datos = new char[30];
					for (int i = 0; i < 30; i++) {							
						datos[i] = (char)raf.read();
					}
					
					String titulo = "";					
					for (char c : datos) {
						if ((byte)c != 0)
							titulo += c;
					}
					
					for (int i = 0; i < 30; i++)
						datos[i] = (char)raf.read();
					
					String artista = "";					
					for (char c : datos) {
						if ((byte)c != 0)
							artista += c;
					}
					
					for (int i = 0; i < 30; i++)
						datos[i] = (char)raf.read();	
					
					String album = "";					
					for (char c : datos) {
						if ((byte)c != 0)
							album += c;
					}
					
					datos = new char[4];
					for (int i = 0; i < 4; i++)
						datos[i] = (char)raf.read();
					
					String anyo = "";					
					for (char c : datos) {
						if ((byte)c != 0)
							anyo += c;
					}
					
					datos = new char[30];
					for (int i = 0; i < 30; i++)
						datos[i] = (char)raf.read();
					
					String comentario = "";					
					for (char c : datos) {
						if ((byte)c != 0)
							comentario += c;
					}
						
					char genero = (char)raf.read();
					
					System.out.println("Titulo: " + titulo);
					System.out.println("Artista: " + artista);
					System.out.println("Album: " + album);
					System.out.println("Año: " + anyo);
					System.out.println("Comentario: " + comentario);
					System.out.print("Genero musical: ");
					if ((int)genero != 0)
						System.out.println("Genero musical: " + genero);				
					
					
				}else {
					System.out.println("No es un fichero mp3 ID3 version 1");
				}
				
			}catch (IOException ioe) {
				ioe.printStackTrace();
			}			
		}
	}
}
