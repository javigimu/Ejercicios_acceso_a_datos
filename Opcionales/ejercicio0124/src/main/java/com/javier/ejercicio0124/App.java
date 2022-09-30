package com.javier.ejercicio0124;

import com.javier.utilidades.LecturaXmlConDom;

/**
 * Extraer datos de asignaturas.xml con dom
 * @author Javi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	LecturaXmlConDom.leerXmlConDom(
    			"C:\\DAM\\2\\Acceso a Datos\\Ejercicios\\Opcionales", 
    			"asignaturas.xml");   
    	
    	System.out.println();
    	System.out.println("Lectura indicando solo el nombre del fichero");
    	LecturaXmlConDom.leerXmlConDom("", "asignaturas.xml");
    }
}
