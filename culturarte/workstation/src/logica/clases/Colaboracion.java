package logica.clases;

import java.util.Date;

import dataTypes.DtColaboracion;
import dataTypes.TRetorno;

public class Colaboracion {
	
	private static int ultId = 1;
	private int idColaboracion;
	private String nickNameColab;
	private float montoAporte; 
	private Date fechaRealizacion;
	private TRetorno retorno;
	private Propuesta pColaborada;
	
	public Colaboracion(String nickName, float montoAporte, TRetorno retorno) {
		this.idColaboracion = Colaboracion.ultId++;
		this.nickNameColab = nickName;
		this.montoAporte = montoAporte;
		this.fechaRealizacion = new Date();
		this.retorno = retorno;
	}

	public int getId() {
		return idColaboracion;
	}
	
	public String getNickNameColab() {
		return nickNameColab;
	}
	
	public float getMontoAporte() {
		return montoAporte;
	}
	
	public void setMontoAporte(float montoAporte) {
		this.montoAporte = montoAporte;
	}
	
	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}
	
	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	
	public TRetorno getRetorno() {
		return retorno;
	}
	
	public void setRetorno(TRetorno retorno) {
		this.retorno = retorno;
	}

	public void agregarPropuesta(Propuesta propuesta) {
		pColaborada = propuesta;
	}
	
	public Propuesta getPropuesta() {
		return pColaborada;
	}

	public DtColaboracion getInfoColaboracion() {
		return new DtColaboracion(idColaboracion, nickNameColab, pColaborada.getTitulo(), montoAporte, fechaRealizacion, retorno);
	}

	public static int getIdActual() {
		return ultId;
	}
	
}
