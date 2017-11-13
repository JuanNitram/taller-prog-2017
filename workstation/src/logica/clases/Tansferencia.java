package logica.clases;

import dataTypes.DtPago;
import dataTypes.DtTansferencia;

public class Tansferencia extends Pago {
	private String nroBanco;
	private String nroCuenta;
	
	public Tansferencia() {
		super();
	}

	public Tansferencia(float monto, String nombreTitular, String nroBanco, String nroCuenta) {
		super(monto,nombreTitular);
		this.nroBanco = nroBanco;
		this.nroCuenta = nroCuenta;
	}

	public String getNroBanco() {
		return nroBanco;
	}

	public void setNroBanco(String nroBanco) {
		this.nroBanco = nroBanco;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	@Override
	public DtPago infoPago() {
		return new DtTansferencia(
				this.getMonto(),
				this.getNombreTitular(),
				this.getNroBanco(),
				this.getNroCuenta()
			);
	}
}
