package com.javier.ejercicio0129.utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.javier.ejercicio0129.entidades.Noticia;

public class LeerMarca {

	static URL dir = null;
	public static List<Noticia> obtenerNoticiasMarca(List<Noticia> listaNoticias) {		
		
		if (listaNoticias == null)
			listaNoticias = new ArrayList<>();
			
		List<String> listaUrl = obtenerXmls();
		
		if (listaUrl != null) {			
			
	        try {        	
	        	//System.out.println("Imprimiendo noticias..."); 
	        	
	        	for (String url : listaUrl) {
	        		
	        		//String nombreUrl = extraerNombreUrl(url);
	        		//System.out.println(nombreUrl.toUpperCase());
	        	
		            DocumentBuilderFactory dbFactory 
		                = DocumentBuilderFactory.newInstance();
		            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
		            dir = new URL(url);
		            Document doc = dBuilder.parse(dir.openStream());
		            doc.getDocumentElement().normalize();
		            NodeList nList = doc.getElementsByTagName("item");
		            
		            List<String> categoryList = new ArrayList<>();		
                    
		            for (int temp = 0; temp < nList.getLength(); temp++) {
		                Node nNode = nList.item(temp);
		                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                    Element eElement = (Element) nNode;
		                    
		                    String title = eElement.getElementsByTagName("title")
		                            .item(0).getTextContent();  
		                    String description = 
		                    		eElement.getElementsByTagName("description")
		                    		.item(0).getTextContent();
		                    String creator = 
		                    		eElement.getElementsByTagName("dc:creator")
		                    		.item(0).getTextContent();
		                    
		                    int numItems = 
		                    		eElement.getElementsByTagName("category")
		                    			.getLength();
		                    for (int i = 0; i < numItems; i++) {
		                    	categoryList.add(
		                    			eElement.getElementsByTagName("category")
		                    			.item(i).getTextContent());
		                    }
		                    
		                    String guid = eElement.getElementsByTagName("guid")
		                    		.item(0).getTextContent();
		                    String pubDate = eElement.getElementsByTagName("pubDate")
		                    		.item(0).getTextContent();
		                    
		                    
		                    if (!existeNoticiaConGuid(listaNoticias, guid))	 {                   
			                    Noticia n = new Noticia(title, description,
			                    		creator, categoryList, guid, pubDate);
			                    listaNoticias.add(n);
			                    //System.out.println(n);
			                    //System.out.println();			                    
		                    }
		                    categoryList.clear();
		                }
		            }
		            //hacerPausa(); hace una pausa tras cada url de noticias
	        	}
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	        
		}
		
        return listaNoticias;    		
	}
	
	
	// funcion para obtener todos los XML de noticias del Marca desde 
	// la direccion https://www.marca.com/rss.html
	public static List<String> obtenerXmls() {
		
		List<String> lines = null;
		
		try {
			
			URL url = new URL("https://www.marca.com/rss.html");
			URLConnection uc = url.openConnection();
			uc.connect();

			lines = new BufferedReader(new InputStreamReader(
					uc.getInputStream(), StandardCharsets.UTF_8))
					.lines()
					.filter(line -> line.contains(".xml")
							&& !line.contains("link"))
					.map(t->
                    { 	int inicio = t.indexOf("href");
                    	int fin = t.indexOf("xml");     
                    	String urldepurada =t.substring(inicio + 6, fin+3);   
                    	
                    	return urldepurada;})
					.collect(Collectors.toList());

			/*
			 for (String line : lines) {	
				 System.out.println(line);
			 }*/
			 
			
		}catch (MalformedURLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}	
		return lines;
	}

	public static void hacerPausa() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Pulsa una tecla para continuar");
		sc.nextLine();
	}
	
	public static boolean existeNoticiaConGuid(List<Noticia> listaNoticias,
			String guid) {
		
		boolean existeNoticia = false;
		int i = 0;
		
		while (listaNoticias.size() > i && !existeNoticia)
		{
			if (listaNoticias.get(i).contieneGuid(guid))
				existeNoticia = true;
			
			i++;
		}		
		
		return existeNoticia;
	}
	
	public static String extraerNombreUrl(String url) {
		int inicio = url.lastIndexOf('/');
	 	int fin = url.lastIndexOf(".xml");
	 	return url.substring(inicio+1, fin);
	}	
	
	public static boolean pedirHacerPausa() {
		Scanner sc = new Scanner(System.in);
		System.out.print("¿Deseas hacer pausa tras cada noticia? (s/n) ");
		String respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase("s"))
			return true;
		else
			return false;
	}
}
