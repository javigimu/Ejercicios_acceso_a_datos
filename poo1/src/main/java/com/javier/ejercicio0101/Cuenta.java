package com.javier.ejercicio0101;

public class Cuenta {
	private String nombre;
	private String numeroCuenta;
	private double tipoInteres;
	private double saldo;
	
	public Cuenta() {}
	
	public Cuenta(String nombre, String numCuenta, double tipoInteres, 
			double saldo){
		this.nombre = nombre;
		this.numeroCuenta = numCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;
	}
	
	// constructor copia
	public Cuenta(Cuenta cuenta) {
		nombre = cuenta.nombre;
		numeroCuenta = cuenta.numeroCuenta;
		tipoInteres = cuenta.tipoInteres;
		saldo = cuenta.saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean ingreso(double cantidad) {
		if (cantidad > 0) {
			saldo += cantidad;
			return true;
		}else
			return false;
	}
	
	public boolean reintegro(double cantidad) {
		if (cantidad > 0 && saldo >= cantidad) {
			saldo -= cantidad;
			return true;
		}else 
			return false;
	}
	
	public boolean transferencia(Cuenta cuentaDestino, double importe) {
		boolean transferenciaCorrecta = false;
		
		if (saldo >= importe) {
			saldo -= importe;
			cuentaDestino.saldo += importe;
			transferenciaCorrecta = true;
		}
		return transferenciaCorrecta;
	}
}
