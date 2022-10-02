package com.javier.ejercicio0129.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * noticia del periódico Marca basada en los contenidos de un "item"
 * @author Javi
 *
 */
public class Noticia implements Serializable {
	
	private String title;
	private String description;
	private String creator;
	private List<String> categorylist;
	private String guid;
	private String pubDate;
	/**
	 * @param title
	 * @param description
	 * @param creator
	 * @param categorylist
	 * @param guid
	 * @param pubDate
	 */
	public Noticia(String title, String description, String creator, 
			List<String> categorylist, String guid, String pubDate) {

		this.title = title;
		this.description = description;
		this.creator = creator;
		
		this.categorylist = new ArrayList();
		categorylist.stream().forEach(this.categorylist::add);
		
		this.guid = guid;
		this.pubDate = pubDate;
	}
	public String getTitle() { return title; }
	
	public String getDescription() { return description; }
	
	public String getCreator() { return creator; }
	
	public List<String> getCategorylist() { return categorylist; }
	
	public String getGuid() { return guid; }
	
	public String getPubDate() { return pubDate; }
	
	
	@Override
	public String toString() {
		String noticia =  "Noticia: " + title + "\n" + description 
				+ "\nCreador: " + creator
				+ "\nCategorias:\n";
		for (String c : categorylist) {
			noticia += "\t" + c + "\n";
		}
		noticia += "guid: " + guid + "\n" + "Fecha publicacion: " + pubDate;
		return noticia;
	}
	
	public boolean contieneGuid(String guid) {
		return this.guid.equals(guid);
	}
}
