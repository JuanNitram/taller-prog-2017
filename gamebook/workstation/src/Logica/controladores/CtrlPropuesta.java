package Logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import Logica.ICtrlPropuesta;
import Logica.clases.Categoria;
import Logica.clases.Colaboracion;
import Logica.clases.Colaborador;
import Logica.clases.Estado;
import Logica.clases.Proponente;
import Logica.clases.Propuesta;
import dataTypes.DtCategoria;
import dataTypes.DtColaboracion;
import dataTypes.DtColaborador;
import dataTypes.DtPropuesta;
import dataTypes.TEstado;
import dataTypes.TRetorno;

public class CtrlPropuesta implements ICtrlPropuesta {
	
	private static final CtrlPropuesta instance = new CtrlPropuesta();
	private Map<String,Propuesta> propuestas;
	private Map<Integer,Colaboracion> colaboraciones;
	private Propuesta propRecordada;
	private Colaboracion colabRecordada;
	private Categoria categoria;
	
	private CtrlPropuesta() {
		this.propuestas = new HashMap<String,Propuesta>();
		this.colaboraciones = new HashMap<Integer,Colaboracion>();
		this.propRecordada = null;
		this.colabRecordada = null;
		this.categoria = new Categoria("Categoria");
	}
	
	public static CtrlPropuesta getInstance() {
		return instance;
	}
	 
	public boolean existePropuesta(String nickName, String titulo){/*Retorna true si existe nickname y no existe titulo */
		boolean res = false;
		CtrlUsuario Cu = CtrlUsuario.getInstance();
		if(this.propuestas.get(titulo) == null && Cu.existeUsuario(nickName, "")) /* No existe la propuesta con titulo = titulo y existe nickName = nickName */
				res = true;
		return res;
	}
	
	public void altaPropuesta(String nickName, String titulo,DtCategoria categoria, String descripcion, String lugar, Date fechaRealizacion, Date fechaPublicacion,
			float montoReunir, TRetorno tipoRetorno, float precioEntrada, String rutaImg){
		
		Propuesta prop = new Propuesta(titulo, descripcion,categoria , lugar, fechaRealizacion, fechaPublicacion, montoReunir, tipoRetorno, precioEntrada, rutaImg, nickName);
		//Date Fp = fechaPublicacion;
		Estado est = new Estado(TEstado.INGRESADA, fechaPublicacion);
		prop.setEstado(est);
		this.propuestas.put(titulo, prop);
		CtrlUsuario Cu = CtrlUsuario.getInstance();
		Proponente u = (Proponente) Cu.getUsuario(nickName);
		u.setNewPropuesta(titulo,prop);
		
		/*QUEDA REALIZAR LA NOTIFICACION*/
		
	}
	
	public void modificarPropuesta(String titulo, String descripcion, String lugar, Date fechaRealizacion,
			float montoReunir, float precioEntrada){
		Propuesta p = propuestas.get(titulo);
		p.setDescripcion(descripcion);
		p.setLugar(lugar);
		p.setFechaRealizacion(fechaRealizacion);
		p.setMontoReunir(montoReunir);
		p.setPrecioEntrada(precioEntrada);
	}
	
	public ArrayList<DtColaborador> listarColaboradores() {
		return CtrlUsuario.getInstance().listarColaboradores();
	}
	
	public ArrayList<DtPropuesta> listarPropuestas() {
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
	
	public ArrayList<DtColaboracion> listarColaboraciones() {
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
		Propuesta p = propuestas.get(titulo);
		if(p == null) throw new NullPointerException("No existe una propuesta con el t�tulo " + titulo);
		else {
			propRecordada = p;
			return p.getInfoPropuesta();
		}
	}
	
	public DtColaboracion infoColaboracion(int id) throws Exception {
		Colaboracion c = colaboraciones.get((Integer)id);
		if(c == null) throw new Exception("No existe una colaboraci�n con id " + id);
		else {
			colabRecordada = c;
			return c.getInfoColaboracion();
		}
	}
	
	public void agregarColaboracion(String nickname, float monto, TRetorno retorno) {
		Colaboracion c = new Colaboracion(nickname, monto, retorno);
		c.agregarPropuesta(propRecordada);
		CtrlUsuario cu = CtrlUsuario.getInstance();
		Colaborador u = (Colaborador)cu.getUsuario(nickname);
		u.agregarColaboracion(c);
		colaboraciones.put((Integer)c.getId(), c);
		if(propRecordada.getEstados().get(0).getEstado() == TEstado.PUBLICADA) {
			Date f = new Date();
			Estado e = new Estado(TEstado.EN_FINANCIACION, f);
			propRecordada.setEstado(e);
		}
	}
	
	public void cancelarColaboracion() {
		Estado e = colabRecordada.getPropuesta().getEstados().get(0);
		if(e.getEstado() != TEstado.FINANCIADA || e.getEstado() != TEstado.CANCELADA) {
			CtrlUsuario cu = CtrlUsuario.getInstance();
			Colaborador c = (Colaborador)cu.getUsuario(colabRecordada.getNickNameColab());
			c.quitarColaboracion(colabRecordada);
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
		recursivo(categoria,res);
        return res;
	}
	
	private void recursivo(Categoria c, DefaultMutableTreeNode raiz) {
		if(c.hijos().size() != 0) {
			DefaultMutableTreeNode nodo;
			Collection<Categoria> categorias = c.hijos().values();
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
		if(ruta == null) o_ruta = new String[]{"Categoria"}; 
		else o_ruta = ruta.getPath();
		Categoria actual = categoria;
		for(int i = 1; i < o_ruta.length; i++) {
			actual = actual.hijos().get(o_ruta[i].toString());
		}
		if(actual.hijos().get(nombreCat) == null) {
			Categoria c = new Categoria(nombreCat);
			actual.agregar(c);
		}
	}
	
	public ArrayList<String> listarEstados() {
		ArrayList<String> res = new ArrayList<>();
		res.add("Ingresada");
		res.add("Publicada");
		res.add("En financiaci�n");
		res.add("Financiada");
		res.add("No financiada");
		res.add("Cancelada");
		return res;
	}
	
	public ArrayList<DtPropuesta> listarPropuestaPorEstado(TEstado estado) {
		ArrayList<DtPropuesta> res = new ArrayList<>();
		if (!propuestas.isEmpty()) {
            Collection<Propuesta> props = propuestas.values();
            Object[] objs = props.toArray();
            for (int i = 0; i < props.size(); i++) {
            	if (((Propuesta)objs[i]).getEstados().get(0).getEstado() == estado)
            		res.add(((Propuesta) objs[i]).getInfoPropuesta());
            }
		}
		return res;
	}
	
	public void evaluar(String evaluacion) {
		if(evaluacion.equals("p"))
			propRecordada.setEstado(new Estado(TEstado.PUBLICADA, new Date()));
		else if(evaluacion.equals("c"))
			propRecordada.setEstado(new Estado(TEstado.CANCELADA, new Date()));
	}
	
	void agregarComentario(String nickname, String titulo, String comentario) {
		propuestas.get(titulo).comentar(nickname,comentario);
	}
	
	void agregarFavorita(String nickname, String titulo) {
		CtrlUsuario.getInstance().agregarFavorita(
				nickname,
				propuestas.get(titulo)
		);
	}

	//Herramientas tiles para cargar los datos de prueba.
	//No estn definidas en la Interface, por lo tanto son invisibles para la Presentacin
	public void cambiarEstado(String titulo, Estado e) {
		propuestas.get(titulo).setEstado(e);
	}
	
	public void borrarPrimerEstado(String titulo) {
		propuestas.get(titulo).borrarPrimerEstado();
	}
	
	public int getIdActualColab() {
		return Colaboracion.getIdActual();
	}

	public void cambiarFechaColaboracion(int id, Date d) {
		colaboraciones.get(id).setFechaRealizacion(d);
	}

}
