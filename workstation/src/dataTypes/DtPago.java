package dataTypes;

public abstract class DtPago {
	private float monto;
	private String nombreTitular;
	
	public DtPago(float monto, String nombreTitular) {
		super();
		this.monto = monto;
		this.nombreTitular = nombreTitular;
	}
	
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
