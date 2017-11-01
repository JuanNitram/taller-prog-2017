package logica.clases;
import java.util.Date;

import dataTypes.TEstado;

public class Estado {
	private Date fecha;
	private TEstado estado;
	
	public Estado(TEstado est, Date fecha){
		this.fecha = fecha;
		this.estado = est; 
	}

	public Date getFecha() {
		return fecha;
	}

	public TEstado getEstado() {
		return estado;
	}

}
