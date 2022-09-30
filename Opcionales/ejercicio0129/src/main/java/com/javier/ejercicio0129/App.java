package com.javier.ejercicio0129;

import java.util.List;

import com.javier.ejercicio0129.entidades.Noticia;
import com.javier.ejercicio0129.utilidades.LeerMarca;

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
        List<Noticia> listaNoticias = LeerMarca.obtenerNoticiasMarca();
        
        // TO DO serializar la lista de noticias
    }
}
