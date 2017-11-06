package dataTypes;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPropuesta {

	private String nickProponente;
	private String titulo;
	private String descripcion;
	private DtCategoria categoria;
	private String lugar;
	private Date fechaRealizacion;
	private Date fechaPublicacion;
	private Date fechaExtension;
	private float montoRequerido;
	private float montoReunido;
	private TRetorno tipoRetorno; 
	private String rutaImg;
	private float precioEntrada;
	private TEstado estado;
	private List<String> favoritos;
	
	public DtPropuesta() {
		super();
	}
		
	public DtPropuesta(String nick, String titulo, String descripcion, DtCategoria categoria, String lugar, Date fechaRealizacion,
			Date fechaPublicacion, Date fechaExtension, float montoRequerido, float montoReunido, TRetorno tipoRetorno,float precioEntrada, String rutaImg, TEstado estado, List<String>favoritos) {
		this.nickProponente = nick;
		this.favoritos = favoritos;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.lugar = lugar;
		this.fechaRealizacion = fechaRealizacion;
		this.fechaPublicacion = fechaPublicacion;
		this.fechaExtension = fechaExtension;
		this.montoRequerido = montoRequerido;
		this.montoReunido = montoReunido;
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
	
	public List<String> listarFavoritos(){
		return favoritos;
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
	
	public Date getFechaExtension() {
		return fechaExtension;
	}
	
	public float getMontoRequerido() {
		return montoRequerido;
	}
	
	public float getMontoReunido() {
		return montoReunido;
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
