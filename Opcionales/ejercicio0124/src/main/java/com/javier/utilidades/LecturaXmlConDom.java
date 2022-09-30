package com.javier.utilidades;

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
			
			
			System.out.println("Asignaturas de segundo:");
			NodeList nList = doc.getElementsByTagName("asignatura");
			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					if (eElement.getElementsByTagName("curso")
							.item(0).getTextContent().equals("Segundo")){
						System.out.println(
								eElement.getElementsByTagName("nombre")
								.item(0).getTextContent());
					}
					
					leidoCorrectamente = true;
				}
			}
			
			/*
			 * Recorrer y mostrar todos los campos del fichero xml
			System.out.println("Elemento base: " + 
					doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("asignatura");
			System.out.println();
			
			System.out.println("Recorriendo asignaturas...");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					System.out.println("Codigo: " + 
							eElement.getAttribute("id"));
					System.out.println("Nombre: " +
							eElement.getElementsByTagName("nombre")
							.item(0).getTextContent());
					System.out.println("Ciclo: " + 
							eElement.getElementsByTagName("cicloFormativo")
							.item(0).getTextContent());
					System.out.println("Curso: " + 
							eElement.getElementsByTagName("curso")
							.item(0).getTextContent());
					System.out.println("Profesor: " + 
							eElement.getElementsByTagName("profesor")
							.item(0).getTextContent());
					System.out.println();				
					
					leidoCorrectamente = true;
				}				
			}		
			*/	
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return leidoCorrectamente;
	}
	
	public static String obtenerDirectorioTrabajoActual() {
		return System.getProperty("user.dir");
	}
}
