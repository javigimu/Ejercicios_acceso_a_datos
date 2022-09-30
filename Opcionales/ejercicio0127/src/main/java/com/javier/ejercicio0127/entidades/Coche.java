package com.javier.ejercicio0127.entidades;

public class Coche {
	private String marca;
	private String modelo;
	private int cilindrada;
	/**
	 * @param marca
	 * @param modelo
	 * @param cilindrada
	 */
	public Coche(String marca, String modelo, int cilindrada) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
	}
	
	public String getMarca() { return marca; }
	
	public String getModelo() {	return modelo; }

	public int getCilindrada() { return cilindrada; }	
	
	@Override
	public String toString() {
		return marca + " " + modelo + " (" + cilindrada + ")";
	}
}
