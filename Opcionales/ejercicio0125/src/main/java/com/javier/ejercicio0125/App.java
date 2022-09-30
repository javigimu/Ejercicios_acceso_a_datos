package com.javier.ejercicio0125;

import com.javier.ejercicio0125.utilidades.ReadXml;

/**
 * Lectura del fichero coches.xml con SAX filtrando por marca Seat
 * @author Javi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReadXml ficheroXml = new ReadXml();
        ficheroXml.procesarXml("coches.xml");
    }
}
