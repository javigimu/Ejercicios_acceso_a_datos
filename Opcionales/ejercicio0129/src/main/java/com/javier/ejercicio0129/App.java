package com.javier.ejercicio0129;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.javier.ejercicio0129.entidades.Noticia;
import com.javier.ejercicio0129.utilidades.LeerMarca;
import com.javier.ejercicio0129.utilidades.SerializacionUtils;

/**
 * Captura todas las noticias del Marca utilizando una clase Noticia con la 
 * estructura xml recogida de una noticia, por ejemplo:
 * https://e00-marca.uecdn.es/rss/futbol/primera-division.xml
 * Cada noticia está basada en el contenido de un "item"
 *  
 * @author Javi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String directorioTrabajo = obtenerDirectorioTrabajoActual();
    	String nombreArchivoSerializado = "noticias.dat";
    	List<Noticia> listaNoticias = new ArrayList<>();
    	
    	if (new File(
    			directorioTrabajo + "/" + nombreArchivoSerializado).exists()) {
    		System.out.println("Deserializando...");
    		listaNoticias = SerializacionUtils.desSerializarListaObjetos(
    			directorioTrabajo, nombreArchivoSerializado);
    	}
    	
    	System.out.println("Leyendo Marca...");
        listaNoticias = LeerMarca.obtenerNoticiasMarca(listaNoticias);        
        
        System.out.println("Serializando...");
        SerializacionUtils.serializarListaObjetos(directorioTrabajo, 
        		nombreArchivoSerializado, listaNoticias);        
        
        boolean hacerPausa = LeerMarca.pedirHacerPausa();   
        
        System.out.println("Imprimiendo noticias...");
        listaNoticias.stream().forEach(n -> {
        	System.out.println(n + "\n");        	
        	if (hacerPausa)
        		LeerMarca.hacerPausa();
        });
        System.out.println("Noticias leidas: " + listaNoticias.size());
        
        System.out.println("Noticias volcadas a \"noticias.txt\"");
        escribirFichero(obtenerDirectorioTrabajoActual() + "/noticias.txt", 
    			listaNoticias);
    }
    
    public static String obtenerDirectorioTrabajoActual() {
		return System.getProperty("user.dir");
	}
    
    public static void escribirFichero(String rutaCompleta,List<Noticia> noticias){
		try {
			List<String> lineas = new ArrayList<>();
			noticias.stream().forEach(n -> lineas.add(n.toString() + "\n"));
			
			Files.write(Paths.get(rutaCompleta), lineas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
