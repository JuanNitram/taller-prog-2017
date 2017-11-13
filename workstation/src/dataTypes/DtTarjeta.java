package dataTypes;

import java.util.Date;

import dataTypes.TTarjeta;

public class DtTarjeta extends DtPago {
	private String numero;
	private TTarjeta tipo;
	private Date vencimiento;
	private String cvc;

	public DtTarjeta(float monto, String nombreTitular, String numero, TTarjeta tipo, Date vencimiento, String cvc) {
		super(monto, nombreTitular);
		this.numero = numero;
		this.tipo = tipo;
		this.vencimiento = vencimiento;
		this.cvc = cvc;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public TTarjeta getTipo() {
		return tipo;
	}
	
	public void setTipo(TTarjeta tipo) {
		this.tipo = tipo;
	}
	
	public Date getVencimiento() {
		return vencimiento;
	}
	
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	
	public String getCvc() {
		return cvc;
	}
	
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
}
