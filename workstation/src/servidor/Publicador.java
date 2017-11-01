package servidor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.xml.ws.Endpoint;

import dataTypes.DtCategoria;
import dataTypes.DtColaboracion;
import dataTypes.DtColaborador;
import dataTypes.DtComentario;
import dataTypes.DtProponente;
import dataTypes.DtPropuesta;
import dataTypes.DtUsuario;
import dataTypes.TEstado;
import dataTypes.TRetorno;
import logica.Fabrica;
import logica.clases.Acceso;
import logica.clases.Propuesta;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
    private Endpoint endpoint = null;
    
    public Publicador() {
    	
    }

    @WebMethod(exclude = true)
    public void publicar() {
         endpoint = Endpoint.publish("http://localhost:11105/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public ArrayList<DtUsuario> listarUsuarios() {
    	return (ArrayList<DtUsuario>) Fabrica.getInstance().getICtrlUsuario().listarUsuarios();
    }
	
    @WebMethod
	public ArrayList<DtProponente> listarProponentes() {
    	return (ArrayList<DtProponente>) Fabrica.getInstance().getICtrlUsuario().listarProponentes();
	}
	
    @WebMethod
	public ArrayList<DtColaborador> listarColaboradores() {
    	return (ArrayList<DtColaborador>) Fabrica.getInstance().getICtrlUsuario().listarColaboradores();
	}
	
    @WebMethod
	public void elegirSeguidor(String nickName) {
    	Fabrica.getInstance().getICtrlUsuario().elegirSeguidor(nickName);
	}
	 
    @WebMethod
	public void elegirSeguido(String nickName) {
		Fabrica.getInstance().getICtrlUsuario().elegirSeguido(nickName);
	}
	
    @WebMethod
	public void dejarSeguir() {
		Fabrica.getInstance().getICtrlUsuario().dejarSeguir();
	}
	
    @WebMethod
	public void seguir() {
		Fabrica.getInstance().getICtrlUsuario().seguir();
	}
	
    @WebMethod
	public boolean esProponente(String nickname) {
		return Fabrica.getInstance().getICtrlUsuario().esProponente(nickname);
	}
	
    @WebMethod
	public boolean checkPassword(String nickname, String password) {
		return Fabrica.getInstance().getICtrlUsuario().checkPassword(nickname, password);
	}
	
    @WebMethod
	public void altaProponente(String nickName, String password, String nombre, String apellido, String direccion, String email, String biografia, String urlSitio,
			String rutaImg, Date fechaNacimiento) {
		Fabrica.getInstance().getICtrlUsuario().altaProponente(nickName, password, nombre, apellido, direccion, email, biografia, urlSitio, rutaImg, fechaNacimiento);
	}
	
    @WebMethod
	public void altaColaborador(String nickName, String password, String nombre, String apellido, String email, String rutaImg, Date fechaNacimiento) {
		Fabrica.getInstance().getICtrlUsuario().altaColaborador(nickName, password, nombre, apellido, email, rutaImg, fechaNacimiento);
	}
	
    @WebMethod
	public DtProponente infoProponente(String nickName) {
		return Fabrica.getInstance().getICtrlUsuario().infoProponente(nickName);
	}
	
    @WebMethod
	public DtColaborador infoColaborador(String nickName) {
		return Fabrica.getInstance().getICtrlUsuario().infoColaborador(nickName);
	}
	
    @WebMethod
	public ArrayList<DtUsuario> listarSeguidores(String nickName) {
		return (ArrayList<DtUsuario>) Fabrica.getInstance().getICtrlUsuario().listarSeguidores(nickName);
	}
	
    @WebMethod
	public ArrayList<DtUsuario> listarSeguidos(String nickName) {
		return (ArrayList<DtUsuario>) Fabrica.getInstance().getICtrlUsuario().listarSeguidos(nickName);
	}
	
    @WebMethod
	public boolean existeUsuario(String nickName, String email) {
		return Fabrica.getInstance().getICtrlUsuario().existeUsuario(nickName, email);
	}
	
    @WebMethod
	public void agregarFavorita(String nickname, Propuesta propFavorita) {
		Fabrica.getInstance().getICtrlUsuario().agregarFavorita(nickname, propFavorita);
	}
	
    @WebMethod
	public void registrarAcceso(String ip, String url, String browser, String so) {
		Fabrica.getInstance().getICtrlUsuario().registrarAcceso(ip, url, browser, so);
	}
    
    public boolean existePropuesta(String nickName, String titulo) {
    	return Fabrica.getInstance().getICtrlPropuesta().existePropuesta(nickName, titulo);
    }
    
	@WebMethod
	public void altaPropuesta(String nickName, String titulo, DtCategoria categoria, String descripcion, String lugar, Date fechaRealizacion,
					float montoReunir, TRetorno tipoRetorno, float precioEntrada, String rutaImg) {
		Fabrica.getInstance().getICtrlPropuesta().altaPropuesta(nickName, titulo, categoria, descripcion, lugar, fechaRealizacion, montoReunir, tipoRetorno, precioEntrada, rutaImg);
	}

	@WebMethod
	public void modificarPropuesta(String titulo, String descripcion, String lugar, Date fechaRealizacion,
					float montoReunir, float precioEntrada) {
		Fabrica.getInstance().getICtrlPropuesta().modificarPropuesta(titulo, descripcion, lugar, fechaRealizacion, montoReunir, precioEntrada);
	}

	@WebMethod
	public ArrayList<DtPropuesta> listarPropuestas() {
		return (ArrayList<DtPropuesta>) Fabrica.getInstance().getICtrlPropuesta().listarPropuestas();
	} 

	@WebMethod
	public ArrayList<DtColaboracion> listarColaboraciones() {
		return (ArrayList<DtColaboracion>) Fabrica.getInstance().getICtrlPropuesta().listarColaboraciones();
	}

	@WebMethod
	public DtPropuesta infoPropuesta(String titulo) throws NullPointerException {
		return Fabrica.getInstance().getICtrlPropuesta().infoPropuesta(titulo);
	}

	@WebMethod
	public DtColaboracion infoColaboracion(int idColaboracion) throws NullPointerException {
		return Fabrica.getInstance().getICtrlPropuesta().infoColaboracion(idColaboracion);
	}

	@WebMethod
	public void agregarColaboracion(String nickname, float monto, TRetorno retorno) {
		Fabrica.getInstance().getICtrlPropuesta().agregarColaboracion(nickname, monto, retorno);
	}

	@WebMethod
	public void cancelarColaboracion() {
		Fabrica.getInstance().getICtrlPropuesta().cancelarColaboracion();
	}

	@WebMethod
	public void finalizarRegistrarColaboracionPropuesta() {
		Fabrica.getInstance().getICtrlPropuesta().finalizarRegistrarColaboracionPropuesta();
	}

	@WebMethod
	public void finalizarCancelarColaboracionPropuesta() {
		Fabrica.getInstance().getICtrlPropuesta().finalizarCancelarColaboracionPropuesta();
	}

	@WebMethod
	public void crearCategoria(TreePath ruta, String nombreCat) {
		Fabrica.getInstance().getICtrlPropuesta().crearCategoria(ruta, nombreCat);
	}

	@WebMethod
	public DefaultMutableTreeNode listarCategorias() {
		return Fabrica.getInstance().getICtrlPropuesta().listarCategorias();
	}

	@WebMethod
	public ArrayList<String> listarEstados() {
		return (ArrayList<String>) Fabrica.getInstance().getICtrlPropuesta().listarEstados();
	}

	@WebMethod
	public ArrayList<DtPropuesta> listarPropuestaPorEstado(TEstado estado) {
		return (ArrayList<DtPropuesta>) Fabrica.getInstance().getICtrlPropuesta().listarPropuestaPorEstado(estado);
	}

	@WebMethod
	public void evaluar(String evaluacion) {
		Fabrica.getInstance().getICtrlPropuesta().evaluar(evaluacion);
	}

	@WebMethod
	public boolean extenderFinanciacion(String titulo) {
		return Fabrica.getInstance().getICtrlPropuesta().extenderFinanciacion(titulo);
	}

	@WebMethod
	public void cancelarPropuesta(String titulo) {
		Fabrica.getInstance().getICtrlPropuesta().cancelarPropuesta(titulo);
	}

	@WebMethod
	public void agregarComentario(String nickname, String titulo, String comentario) {
		Fabrica.getInstance().getICtrlPropuesta().agregarComentario(nickname, titulo, comentario);
	}

	@WebMethod
	public ArrayList<DtComentario> listarComentarios(String titulo) {
		return (ArrayList<DtComentario>) Fabrica.getInstance().getICtrlPropuesta().listarComentarios(titulo);
	}
}
