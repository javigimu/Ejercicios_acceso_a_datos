package com.javier.ejercicio0126.utilidades;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXmlConDom {
	
	public static boolean leerXmlConDom(String directorio, String nombreArchivo) {		
		
		boolean leidoCorrectamente = false;
		try {
			if (directorio.equals("")) {
				directorio = obtenerDirectorioTrabajoActual();
			}
			
			File fichero = new File(directorio + "/" + nombreArchivo);
			DocumentBuilderFactory dbFactory = 
					DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fichero);
			doc.getDocumentElement().normalize();
			
			
			System.out.println("Coches de la marca Seat:");
			NodeList nList = doc.getElementsByTagName("coche");
			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					if (eElement.getElementsByTagName("marca")
							.item(0).getTextContent().equals("Seat")){
						System.out.println(
								eElement.getElementsByTagName("modelo")
								.item(0).getTextContent());
					}
					
					leidoCorrectamente = true;
				}
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return leidoCorrectamente;
	}
	
	public static String obtenerDirectorioTrabajoActual() {
		return System.getProperty("user.dir");
	}
}
