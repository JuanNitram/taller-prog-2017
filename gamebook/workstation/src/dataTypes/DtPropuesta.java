package dataTypes;

import java.util.Date;

public class DtPropuesta {

	private String nickProponente;
	private String titulo;
	private String descripcion;
	private DtCategoria categoria;
	private String lugar;
	private Date fechaRealizacion;
	private Date fechaPublicacion;
	private float montoReunir;
	private TRetorno tipoRetorno; 
	private String rutaImg;
	private float precioEntrada;
	private TEstado estado; 
		
	public DtPropuesta(String nick, String titulo, String descripcion, DtCategoria categoria, String lugar, Date fechaRealizacion,
			Date fechaPublicacion, float montoReunir, TRetorno tipoRetorno,float precioEntrada, String rutaImg, TEstado estado) {
		this.nickProponente = nick;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.lugar = lugar;
		this.fechaRealizacion = fechaRealizacion;
		this.fechaPublicacion = fechaPublicacion;
		this.montoReunir = montoReunir;
		this.tipoRetorno = tipoRetorno;
		this.precioEntrada = precioEntrada;
		this.rutaImg = rutaImg;
		this.estado = estado;
	}
	
	public String getNickProponente() {
		return nickProponente;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public DtCategoria getCategoria() {
		return categoria;
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}
	
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public float getMontoReunir() {
		return montoReunir;
	}
	
	public TRetorno getTipoRetorno() {
		return tipoRetorno;
	}
	
	public String getRutaImg() {
		return rutaImg;
	}

	public TEstado getEstado() {
		return estado;
	}
	public float getPrecioEntrada(){
		return precioEntrada;
	}
}
