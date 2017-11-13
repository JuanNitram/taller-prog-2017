package dataTypes;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtColaboracion {

	private int id;
	private String nickname;
	private String titulo;
	private float montoAporte; 
	private Date fechaRealizacion;
	private TRetorno retorno;
	private DtPago pago;
	
	public DtColaboracion() {
		super();
	}

	public DtColaboracion(int id, String nickname, String titulo, float montoAporte, Date fechaRealizacion, TRetorno retorno, DtPago pago) {
		this.id = id;
		this.nickname = nickname;
		this.titulo = titulo;
		this.montoAporte = montoAporte;
		this.fechaRealizacion = fechaRealizacion;
		this.retorno = retorno;
		this.pago = pago;
	}
	
	public int getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public float getMontoAporte() {
		return montoAporte;
	}
	
	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}
	
	public TRetorno getRetorno() {
		return retorno;
	}

	public DtPago getPago() {
		return pago;
	}
}
