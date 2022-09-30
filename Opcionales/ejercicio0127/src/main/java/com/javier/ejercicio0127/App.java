package com.javier.ejercicio0127;

import java.util.List;
import java.util.Scanner;

import com.javier.ejercicio0127.entidades.Coche;
import com.javier.ejercicio0127.utilidades.LecturaXmlConDom;

/**
 * Leer los datos del fichero coches.xml con dom
 * se muestran el modelo de los coches cuya marca es introducida por el usuario,
 * seguido de su cilindrada y ordenados descedentemente por cilindrada
 * @author Javi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Introduce la marca a filtrar: ");
    	String marca = sc.nextLine();
    	
        LecturaXmlConDom lecturaXmlConDom = new LecturaXmlConDom();
        List<Coche> listaCoches = lecturaXmlConDom.leerXmlConDom("", 
        		"coches.xml", marca);
        
        if (listaCoches.size() > 0) {
        	System.out.println("Listado de coches de la marca " + marca + ":");
        	listaCoches.stream().sorted((c1, c2) -> 
        		Integer.compare(c2.getCilindrada(), c1.getCilindrada()))
        		.forEach(System.out::println);
        		
        }else {
        	System.out.println("No se han encontrado coincidencias");
        }
    }
}
