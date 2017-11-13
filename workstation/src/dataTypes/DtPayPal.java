package dataTypes;

public class DtPayPal extends DtPago {
	private String nroCuenta;

	public DtPayPal(float monto, String nombreTitular, String nroCuenta) {
		super(monto, nombreTitular);
		this.nroCuenta = nroCuenta;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	
}
