package com.javier.ejercicio0126;

import com.javier.ejercicio0126.utilidades.LecturaXmlConDom;

/**
 * Lectura del fichero coches.xml con dom mostrando los modelos Seat
 * @author Javi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	LecturaXmlConDom lecturaXmlDom = new LecturaXmlConDom();
    	lecturaXmlDom.leerXmlConDom("", "coches.xml");        
    }
}
