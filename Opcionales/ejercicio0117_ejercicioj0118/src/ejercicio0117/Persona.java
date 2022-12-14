package ejercicio0117;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase para representar una persona implementado serializacion
 * @author Javi
 *
 */
public class Persona implements Serializable{
	private String nombre;
	private String e_mail;
	private LocalDate fechaNacimiento;

	/**
	 * @param nombre
	 * @param e-mail
	 * @param fechaNacimiento
	 */
	public Persona(String nombre, String mail, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.e_mail = mail;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public String getMail() { return e_mail; }
	
	public void setMail(String mail) { this.e_mail = mail; }
	
	public LocalDate getFechaNacimiento() {	return fechaNacimiento; }
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public String toString() {
		return nombre + ", " + e_mail + " (" + fechaNacimiento + ")";
	}
	
}
