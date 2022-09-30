package com.javier.ejercicio0127.utilidades;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.javier.ejercicio0127.entidades.Coche;

public class LecturaXmlConDom {
	
	public static List<Coche> leerXmlConDom(String directorio,
			String nombreArchivo, String marcaFiltrada) {		
		
		List<Coche> listaCoches = new ArrayList<>();
		
		try {
			if (directorio.equals("")) {
				directorio = obtenerDirectorioTrabajoActual();
			}
			
			if (new File(directorio + "/" + nombreArchivo).exists()) {
				File fichero = new File(directorio + "/" + nombreArchivo);
				DocumentBuilderFactory dbFactory = 
						DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fichero);
				doc.getDocumentElement().normalize();			
				
				NodeList nList = doc.getElementsByTagName("coche");
				
				for (int i = 0; i < nList.getLength(); i++) {
					Node nNode = nList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element)nNode;
						if (eElement.getElementsByTagName("marca")
								.item(0).getTextContent()
								.equalsIgnoreCase(marcaFiltrada)){
							
							listaCoches.add(new Coche(
									eElement.getElementsByTagName("marca").item(0)
										.getTextContent(),
									eElement.getElementsByTagName("modelo").item(0)
										.getTextContent(),
									Integer.parseInt(
									eElement.getElementsByTagName("cilindrada")
										.item(0).getTextContent())));
							
						}					
					}
				}		
			} else {
				throw new Exception("El fichero no existe");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return listaCoches;
	}
	
	public static String obtenerDirectorioTrabajoActual() {
		return System.getProperty("user.dir");
	}
}
