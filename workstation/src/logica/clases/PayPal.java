package logica.clases;

import dataTypes.DtPago;
import dataTypes.DtPayPal;

public class PayPal extends Pago {
	private String nroCuenta;
	
	public PayPal() {
		super();
	}

	public PayPal(float monto, String nombreTitular, String nroCuenta) {
		super(monto,nombreTitular);
		this.nroCuenta = nroCuenta;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	@Override
	public DtPago infoPago() {
		return new DtPayPal(
				this.getMonto(),
				this.getNombreTitular(),
				this.getNroCuenta()
			);
	}
	
}
