package logica.clases;

import dataTypes.DtPago;

public abstract class Pago {
	private float monto;
	private String nombreTitular;
	
	public Pago() {
		super();
	}
	
	public Pago(float monto, String nombreTitular) {
		super();
		this.monto = monto;
		this.nombreTitular = nombreTitular;
	}

	public abstract DtPago infoPago();
	
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
}
