package logica.controladores;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import logica.Fabrica;
import logica.ICtrlPropuesta;
import logica.clases.Categoria;
import logica.clases.Colaboracion;
import logica.clases.Colaborador;
import logica.clases.Comentario;
import logica.clases.Estado;
import logica.clases.Proponente;
import logica.clases.Propuesta;
import dataTypes.DtCategoria;
import dataTypes.DtColaboracion;
import dataTypes.DtColaborador;
import dataTypes.DtComentario;
import dataTypes.DtPropuesta;
import dataTypes.TEstado;
import dataTypes.TRetorno;
import presentacion2.Clock2;

public class CtrlPropuesta implements ICtrlPropuesta {
	
	private static final CtrlPropuesta instance = new CtrlPropuesta();
	private Map<String, Propuesta> propuestas;
	private Map<Integer, Colaboracion> colaboraciones;
	private Propuesta propRecordada;
	private Colaboracion colabRecordada;
	private Categoria categoria;
	
	private CtrlPropuesta() {
		this.propuestas = new HashMap<String, Propuesta>();
		this.colaboraciones = new HashMap<Integer, Colaboracion>();
		this.propRecordada = null;
		this.colabRecordada = null;
		this.categoria = new Categoria("Categoria");
	}
	
	public static CtrlPropuesta getInstance() {
		return instance;
	}
	 
	public boolean existePropuesta(String nickName, String titulo){/*Retorna true si existe nickname y no existe titulo */
		boolean res = false;
		CtrlUsuario usuarioControlador = CtrlUsuario.getInstance();
		if (this.propuestas.get(titulo) == null && usuarioControlador.existeUsuario(nickName, "")) /* No existe la propuesta con titulo = titulo y existe nickName = nickName */
				res = true;
		return res;
	}
	
	
	public void altaPropuesta(String nickName, String titulo, DtCategoria categoria, String descripcion, String lugar, Date fechaRealizacion,
			float montoReunir, TRetorno tipoRetorno, float precioEntrada, String rutaImg){
		
		Propuesta prop = new Propuesta(titulo, descripcion, categoria , lugar, fechaRealizacion, montoReunir, tipoRetorno, precioEntrada, rutaImg, nickName);
		Estado est = new Estado(TEstado.INGRESADA, new Date());
		prop.setEstado(est);
		this.propuestas.put(titulo, prop);
		CtrlUsuario usuarioControlador = CtrlUsuario.getInstance();
		Proponente proponente = (Proponente) usuarioControlador.getUsuario(nickName);
		proponente.setNewPropuesta(titulo, prop);
	}
	
	public void modificarPropuesta(String titulo, String descripcion, String lugar, Date fechaRealizacion,
			float montoRequerido, float precioEntrada){
		Propuesta prop = propuestas.get(titulo);
		prop.setDescripcion(descripcion);
		prop.setLugar(lugar);
		prop.setFechaRealizacion(fechaRealizacion);
		prop.setMontoRequerido(montoRequerido);
		prop.setPrecioEntrada(precioEntrada);
	}
	
	public List<DtColaborador> listarColaboradores() {
		return CtrlUsuario.getInstance().listarColaboradores();
	}
	
	public List<DtPropuesta> listarPropuestas() {
		ArrayList<DtPropuesta> res = new ArrayList<DtPropuesta>();
		if (!propuestas.isEmpty()) {
            Collection<Propuesta> props = propuestas.values();
            Object[] objs = props.toArray();
            for (int i = 0; i < props.size(); i++) {
            	res.add(((Propuesta) objs[i]).getInfoPropuesta());
            }
		}
        return res;
	}
	
	public List<DtColaboracion> listarColaboraciones() {
		ArrayList<DtColaboracion> res = new ArrayList<DtColaboracion>();
		if (!colaboraciones.isEmpty()) {
            Collection<Colaboracion> colabs = colaboraciones.values();
            Object[] objs = colabs.toArray();
            for (int i = 0; i < colabs.size(); i++) {
            	res.add(((Colaboracion) objs[i]).getInfoColaboracion());
            }
		}
        return res;
	}
	
	public DtPropuesta infoPropuesta(String titulo) throws NullPointerException {
		Propuesta prop = propuestas.get(titulo);
		if (prop == null) throw new NullPointerException("No existe una propuesta con el t�tulo " + titulo);
		else {
			propRecordada = prop;
			return prop.getInfoPropuesta();
		}
	}
	
	public DtColaboracion infoColaboracion(int identif) throws NullPointerException {
		Colaboracion colab = colaboraciones.get((Integer) identif);
		if (colab == null) throw new NullPointerException("No existe una colaboraci�n con id " + identif);
		else {
			colabRecordada = colab;
			return colab.getInfoColaboracion();
		}
	}
	
	public void agregarColaboracion(String nickname, float monto, TRetorno retorno) {
		Colaboracion colab = new Colaboracion(nickname, monto, retorno);
		colab.agregarPropuesta(propRecordada);
		CtrlUsuario usuarioControlador = CtrlUsuario.getInstance();
		Colaborador colaborador = (Colaborador) usuarioControlador.getUsuario(nickname);
		colaborador.agregarColaboracion(colab);
		propRecordada.setMontoReunido(propRecordada.getMontoReunido() + monto);
		colaboraciones.put((Integer) colab.getId(), colab);
		if (propRecordada.getEstados().get(0).getEstado() == TEstado.PUBLICADA) {
			Date fecha = new Date();
			Estado estado = new Estado(TEstado.EN_FINANCIACION, fecha);
			propRecordada.setEstado(estado);
		}
		if (propRecordada.getEstados().get(0).getEstado() == TEstado.EN_FINANCIACION
			&& propRecordada.getMontoReunido() >= propRecordada.getMontoRequerido())
			propRecordada.setEstado(new Estado(TEstado.FINANCIADA, new Date()));
	}
	
	public void cancelarColaboracion() {
		Estado estado = colabRecordada.getPropuesta().getEstados().get(0);
		if (estado.getEstado() != TEstado.FINANCIADA || estado.getEstado() != TEstado.CANCELADA) {
			colabRecordada.getPropuesta().setMontoReunido(colabRecordada.getPropuesta().getMontoReunido() - colabRecordada.getMontoAporte());
			CtrlUsuario usuarioControlador = CtrlUsuario.getInstance();
			Colaborador colaborador = (Colaborador) usuarioControlador.getUsuario(colabRecordada.getNickNameColab());
			colaborador.quitarColaboracion(colabRecordada);
			colaboraciones.remove(colabRecordada.getId());
		}
	}
	
	public void finalizarRegistrarColaboracionPropuesta() {
		propRecordada = null;
	}
	
	public void finalizarCancelarColaboracionPropuesta() {
		colabRecordada = null;
	}
	
	@Override
	public DefaultMutableTreeNode listarCategorias() {
		DefaultMutableTreeNode res = new DefaultMutableTreeNode("Categoria");
		recursivo(categoria, res);
        return res;
	}
	
	private void recursivo(Categoria categoria, DefaultMutableTreeNode raiz) {
		if (categoria.hijos().size() != 0) {
			DefaultMutableTreeNode nodo;
			Collection<Categoria> categorias = categoria.hijos().values();
            Object[] objs = categorias.toArray();
            for (int i = 0; i < categorias.size(); i++) {
            	String etiqueta = ((Categoria) objs[i]).getNombre();
            	nodo = new DefaultMutableTreeNode(etiqueta);
            	recursivo((Categoria) objs[i], nodo);
            	raiz.add(nodo);
            }
		}
	}

	@Override
	public void crearCategoria(TreePath ruta, String nombreCat) {
		Object[] o_ruta;
		if (ruta == null) o_ruta = new String[]{"Categoria"}; 
		else o_ruta = ruta.getPath();
		Categoria actual = categoria;
		for (int i = 1; i < o_ruta.length; i++) {
			actual = actual.hijos().get(o_ruta[i].toString());
		}
		if (actual.hijos().get(nombreCat) == null) {
			Categoria categoria = new Categoria(nombreCat);
			actual.agregar(categoria);
		}
	}
	
	public List<String> listarEstados() {
		ArrayList<String> res = new ArrayList<>();
		res.add("Ingresada");
		res.add("Publicada");
		res.add("En financiaci�n");
		res.add("Financiada");
		res.add("No financiada");
		res.add("Cancelada");
		return res;
	}
	
	public List<DtPropuesta> listarPropuestaPorEstado(TEstado estado) {
		ArrayList<DtPropuesta> res = new ArrayList<>();
		if (!propuestas.isEmpty()) {
            Collection<Propuesta> props = propuestas.values();
            Object[] objs = props.toArray();
            for (int i = 0; i < props.size(); i++) {
            	if (((Propuesta) objs[i]).getEstados().get(0).getEstado() == estado)
            		res.add(((Propuesta) objs[i]).getInfoPropuesta());
            }
		}
		return res;
	}
	
	public List<DtPropuesta> listarPropuestaPorCategoria(String categoria) {
		ArrayList<DtPropuesta> res = new ArrayList<>();
		if (!propuestas.isEmpty()) {
            Collection<Propuesta> props = propuestas.values();
            Object[] objs = props.toArray();
            for (int i = 0; i < props.size(); i++) {
            	if (((Propuesta) objs[i]).getCategoria().getNombre().equals(categoria))
            		res.add(((Propuesta) objs[i]).getInfoPropuesta());
            }
		}
		return res;
	}
	
	public void evaluar(String evaluacion) {
		if (evaluacion.equals("p")) {
			propRecordada.setEstado(new Estado(TEstado.PUBLICADA, new Date()));
			propRecordada.setFechaPublicacion(new Date());
		}
		else if (evaluacion.equals("c"))
			propRecordada.setEstado(new Estado(TEstado.CANCELADA, new Date()));
	}
	
	public boolean extenderFinanciacion(String titulo) {
		if(propuestas.get(titulo) != null) {
			if(propuestas.get(titulo).getEstados().get(0).getEstado() == TEstado.PUBLICADA ||
					propuestas.get(titulo).getEstados().get(0).getEstado() == TEstado.EN_FINANCIACION)
				if(propuestas.get(titulo).getFechaExtension() == null) {
					propuestas.get(titulo).setFechaExtension(new Date());
					return true;
				}
		}
		return false;
	}

	public void cancelarPropuesta(String titulo){
		Estado est = new Estado(TEstado.CANCELADA,new Date());
		propuestas.get(titulo).setEstado(est);
	}
	
	public void agregarComentario(String nickname, String titulo, String comentario) {
		propuestas.get(titulo).comentar(nickname, comentario);
	}
	
	public List<DtComentario> listarComentarios(String titulo){
		ArrayList<DtComentario> res = new ArrayList<>();
		List<Comentario> comentarios = propuestas.get(titulo).getComentarios();
		for(int i = 0; i < comentarios.size(); i++){
			res.add(new DtComentario(comentarios.get(i).getNickname(),comentarios.get(i).getComentario()));
		}
		return res;
	}
	

	//Herramientas utiles para cargar los datos de prueba.
	//No estn definidas en la Interface, por lo tanto son invisibles para la Presentacin
	public void cambiarEstado(String titulo, Estado estado) {
		propuestas.get(titulo).setEstado(estado);
		if (estado.getEstado() == TEstado.PUBLICADA) propuestas.get(titulo).setFechaPublicacion(estado.getFecha());
	}
	
	public void borrarPrimerEstado(String titulo) {
		propuestas.get(titulo).borrarPrimerEstado();
	}
	
	public int getIdActualColab() {
		return Colaboracion.getIdActual();
	}

	public void cambiarFechaColaboracion(int identif, Date date) {
		colaboraciones.get(identif).setFechaRealizacion(date);
	}
	
	public void actualizarPropuestas() {
		Object[] objs = propuestas.values().toArray();
		for (int i = 0; i < objs.length; i++) {
			Propuesta prop = (Propuesta) objs[i];
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(prop.getFechaPublicacion());
			calendar.add(Calendar.DAY_OF_YEAR, 30);
			if(prop.getFechaExtension() != null) {
				calendar.setTime(prop.getFechaExtension());
				calendar.add(Calendar.DAY_OF_YEAR, 30);
				if((prop.getEstados().get(0).getEstado() == TEstado.PUBLICADA ||
						prop.getEstados().get(0).getEstado() == TEstado.EN_FINANCIACION) &&
						calendar.getTime().getTime() <= Clock2.getFecha().getTime())
					prop.setEstado(new Estado(TEstado.NO_FINANCIADA, Clock2.getFecha()));
			} else
				if ((prop.getEstados().get(0).getEstado() == TEstado.PUBLICADA ||
						prop.getEstados().get(0).getEstado() == TEstado.EN_FINANCIACION) &&
						calendar.getTime().getTime() <= Clock2.getFecha().getTime())
					prop.setEstado(new Estado(TEstado.NO_FINANCIADA, Clock2.getFecha()));
			
		}
	}

	@Override
	public List<String> listarFavoritos(String titulo) {
		// TODO Auto-generated method stub
		return propuestas.get(titulo).listarUsuariosFavorito();

	}
	
	public void agregarUsuarioFavorito(String nickname, String propuesta){
		CtrlUsuario.getInstance().agregarPropuestaFavorita(nickname, propuesta);
		propuestas.get(propuesta).agregarUsuarioFavorito(nickname);
	}
	
	public void eliminarUsuarioFavorito(String nickname, String propuesta){
		CtrlUsuario.getInstance().eliminarPropuestaFavorita(nickname, propuesta);
		propuestas.get(propuesta).eliminarUsuarioFavorito(nickname);
	}

}
