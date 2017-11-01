package dataTypes;

import java.util.Date;

public class DtColaboracion {

	private int id;
	private String nickname;
	private String titulo;
	private float montoAporte; 
	private Date fechaRealizacion;
	private TRetorno retorno;
	
	public DtColaboracion() {
		super();
	}

	public DtColaboracion(int id, String nickname, String titulo, float montoAporte, Date fechaRealizacion, TRetorno retorno) {
		this.id = id;
		this.nickname = nickname;
		this.titulo = titulo;
		this.montoAporte = montoAporte;
		this.fechaRealizacion = fechaRealizacion;
		this.retorno = retorno;
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

}
