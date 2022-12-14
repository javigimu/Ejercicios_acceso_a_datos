import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * clase para extraer datos de un fichero xml con SAX
 * @author Javi
 *
 */

public class ReadXml extends DefaultHandler{
	public void procesarXml() {
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			DefaultHandler manejadorEventos = new DefaultHandler(){
				
				String etiquetaActual = "";
				String nombreAsignatura = "";
				String contenido = "";
				
				// Método que se llama al encontrar inicio de etiqueta '<'
				public void startElement(String uri, String localName, 
						String qName, Attributes attributes)
					throws SAXException {
					
					// Si el nombre es "asignatura",
					// empieza una nueva y mostramos su id
					// Si no, memorizamos el nombre para mostrar después
					etiquetaActual = qName;	
															
					/* Para mostrar el id de la asignatura
					if (etiquetaActual == "asignatura")
						System.out.println("Asignatura: " 
								+ attributes.getValue("id"));*/
									
				}
				
				// Obtiene los datos entre '<' y '>'
				public void characters(char[] ch, int start, int length)
					throws SAXException {
					
					contenido = new String(ch, start, length);
				}
				
				// Llamado al encontrar fin de etiqueta: '>'
				public void endElement(String uri, String localName, 
						String qName)
					throws SAXException {
					
					// muestra el nombre de las asignatuas de segundo
					if (!etiquetaActual.equals("")) {
						if (etiquetaActual.equals("nombre")) {
							nombreAsignatura = contenido;
						} else if (etiquetaActual.equals("curso")) {
							if (contenido.equalsIgnoreCase("segundo")) {
								System.out.println("Nombre de asignatura: " +
										nombreAsignatura);
							}
						}
						etiquetaActual = "";
					}
				}
			};			
				
				
		// Cuerpo de la función: trata de analizar el fichero deseado
		// Llamará a startElement(), endElement() y character()
		saxParser.parse("asignaturas.xml", manejadorEventos);	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
