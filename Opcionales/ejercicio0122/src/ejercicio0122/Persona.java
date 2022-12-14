package ejercicio0122;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase para representar una persona implementado serializacion
 * @author Javi
 *
 */
public class Persona implements Serializable{
	private String nombre;
	private String email;
	private int edad;
	private String comentarios;

	/**
	 * @param nombre
	 * @param e-mail
	 * @param fechaNacimiento
	 */
	public Persona(String nombre, String mail, int edad, String comentarios) {
		this.nombre = nombre;
		this.email = mail;
		this.edad = edad;
		this.comentarios = comentarios;
	}
	
	public String getNombre() {	return nombre; }
	
	public void setNombre(String nombre) { this.nombre = nombre; }	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setComentarios(String comentarios) { 
		this.comentarios = comentarios;
	}
	
	public String getComentarios() { return comentarios; }
	
	
	@Override
	public String toString() {
		String texto = nombre + ", " + email + " (";
		if (edad < 0) 
			texto += "desconocida";
		else
			texto += edad;
		
		texto += ")\n\t" + comentarios;
		
		return texto;
	}
	
	public boolean contiene(String texto) {
		boolean encontrado = false;
		
		texto = texto.toUpperCase();
		if (nombre.toUpperCase().contains(texto) || 
				email.toUpperCase().contains(texto) ||
				comentarios.toUpperCase().contains(texto))
			encontrado = true;
		
		return encontrado;
	}
	
}
