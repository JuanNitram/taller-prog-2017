package dataTypes;

public class DtTansferencia extends DtPago {
	private String nroBanco;
	private String nroCuenta;

	public DtTansferencia(float monto, String nombreTitular, String nroBanco, String nroCuenta) {
		super(monto, nombreTitular);
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
}
