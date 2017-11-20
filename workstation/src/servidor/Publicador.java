package servidor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.xml.ws.Endpoint;

import dataTypes.DataDate;
import dataTypes.DataList;
import dataTypes.DtCategoria;
import dataTypes.DtColaboracion;
import dataTypes.DtColaborador;
import dataTypes.DtComentario;
import dataTypes.DtProponente;
import dataTypes.DtPropuesta;
import dataTypes.DtUsuario;
import dataTypes.TEstado;
import dataTypes.TRetorno;
import dataTypes.TTarjeta;
import logica.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
    private Endpoint endpoint = null;
    
	private void linealizarConNivel(DefaultMutableTreeNode tree, ArrayList<String> list, int k) {
		String guiones = "";
		for(int i = 0; i < tree.getLevel()-1; i++) guiones += "- ";
		list.add(guiones + tree.toString());
		for(int i = 0; i < tree.getChildCount(); i++) {
			linealizarConNivel((DefaultMutableTreeNode)tree.getChildAt(i),list,k+1);
		}
	}
    
    public Publicador() {
    }

    @WebMethod(exclude = true)
    public void publicar() {
    	Properties p = new Properties();
    	try {
    		String usr = System.getProperty("user.home");
			p.load(new FileReader(usr+"/.culturarte/culturarte.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	endpoint = Endpoint.publish("http://localhost:11115/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
    	return endpoint;
    }
    
    @WebMethod
    public void bajaProponente(String nickName){
    	Fabrica.getInstance().getICtrlUsuario().bajaProponente(nickName);
    }
    
    @WebMethod
    public boolean esFavorita(String nickName, String propuesta){
    	boolean res = false;
    	res = Fabrica.getInstance().getICtrlUsuario().esFavorita(nickName, propuesta);
    	return res;
    }
    
    @WebMethod
    public DataList listarFavoritos(String titulo){
    	DataList favoritos = new DataList();
    	favoritos.setDatos((ArrayList<String>)Fabrica.getInstance().getICtrlPropuesta().listarFavoritos(titulo));
    	return favoritos;
    }
    
    @WebMethod
    public DataList listarPropuestaPorCategoria(String filtro){
    	DataList dtP = new DataList();
    	dtP.setDatos((ArrayList<DtPropuesta>)Fabrica.getInstance().getICtrlPropuesta().listarPropuestaPorCategoria(filtro));
    	return dtP;
    }
    
    @WebMethod
    public DataList listarUsuarios() {
    	DataList users = new DataList();
    	users.setDatos((ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarUsuarios());
    	return users;
    }
	
    @WebMethod
	public DataList listarProponentes() {
    	DataList res = new DataList();
    	res.setDatos((ArrayList<DtProponente>) Fabrica.getInstance().getICtrlUsuario().listarProponentes());
    	return res;
	}
	
    @WebMethod
	public DataList listarColaboradores() {
    	DataList res = new DataList();
    	res.setDatos((ArrayList<DtColaborador>) Fabrica.getInstance().getICtrlUsuario().listarColaboradores());
    	return res;
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
			String rutaImg, DataDate fechaNacimiento) {
		Fabrica.getInstance().getICtrlUsuario().altaProponente(nickName, password, nombre, apellido, direccion, email, biografia, urlSitio, rutaImg, fechaNacimiento.getDate());
	}
	
    @WebMethod
	public void altaColaborador(String nickName, String password, String nombre, String apellido, String email, String rutaImg, DataDate fechaNacimiento) {
		Fabrica.getInstance().getICtrlUsuario().altaColaborador(nickName, password, nombre, apellido, email, rutaImg, fechaNacimiento.getDate());
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
	public DataList listarSeguidores(String nickName) {
    	DataList users = new DataList();
    	users.setDatos((ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarSeguidores(nickName));
    	return users;
	}
	
    @WebMethod
	public DataList listarSeguidos(String nickName) {
    	DataList users = new DataList();
    	users.setDatos((ArrayList<DtUsuario>)Fabrica.getInstance().getICtrlUsuario().listarSeguidos(nickName));
    	return users;
	}
	
    @WebMethod
	public boolean existeUsuario(String nickName, String email) {
		return Fabrica.getInstance().getICtrlUsuario().existeUsuario(nickName, email);
	}
	
	
    @WebMethod
	public void registrarAcceso(String ip, String url, String browser, String so) {
		Fabrica.getInstance().getICtrlUsuario().registrarAcceso(ip, url, browser, so);
	}
    
    public boolean existePropuesta(String nickName, String titulo) {
    	return Fabrica.getInstance().getICtrlPropuesta().existePropuesta(nickName, titulo);
    }
    
	@WebMethod
	public void altaPropuesta(String nickName, String titulo, DtCategoria categoria, String descripcion, String lugar, DataDate fechaRealizacion,
					float montoReunir, TRetorno tipoRetorno, float precioEntrada, String rutaImg) {
		Fabrica.getInstance().getICtrlPropuesta().altaPropuesta(nickName, titulo, categoria, descripcion, lugar, fechaRealizacion.getDate(), montoReunir, tipoRetorno, precioEntrada, rutaImg);
	}

	@WebMethod
	public void modificarPropuesta(String titulo, String descripcion, String lugar, DataDate fechaRealizacion,
					float montoReunir, float precioEntrada) {
		Fabrica.getInstance().getICtrlPropuesta().modificarPropuesta(titulo, descripcion, lugar, fechaRealizacion.getDate(), montoReunir, precioEntrada);
	}

	@WebMethod
	public DataList listarPropuestas() {
		DataList dtPs = new DataList();
		dtPs.setDatos((ArrayList<DtPropuesta>) Fabrica.getInstance().getICtrlPropuesta().listarPropuestas());
		return dtPs;
	} 

	@WebMethod
	public DataList listarColaboraciones() {
		DataList dtC = new DataList();
		dtC.setDatos((ArrayList<DtColaboracion>) Fabrica.getInstance().getICtrlPropuesta().listarColaboraciones());
		return dtC;
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
	public DataList listarCategorias() {
		DataList dtL = new DataList();
		ArrayList<String> categoriasLista = new ArrayList<String>();
		linealizarConNivel(Fabrica.getInstance().getICtrlPropuesta().listarCategorias(), categoriasLista, 0);
		categoriasLista.remove(0);
		dtL.setDatos(categoriasLista);
		return dtL;
	}

	@WebMethod
	public DataList listarEstados() {
		DataList res = new DataList();
		res.setDatos((ArrayList<String>) Fabrica.getInstance().getICtrlPropuesta().listarEstados());
		return res;
	}

	@WebMethod
	public DataList listarPropuestaPorEstado(TEstado estado) {
		DataList res = new DataList();
		res.setDatos((ArrayList<DtPropuesta>) Fabrica.getInstance().getICtrlPropuesta().listarPropuestaPorEstado(estado));
		return res;
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
	public void agregarPropuestaFavorita(String nickname, String propuesta) {
		Fabrica.getInstance().getICtrlPropuesta().agregarUsuarioFavorito(nickname, propuesta);
	}
	
	@WebMethod
	public void eliminarUsuarioFavorito(String nickname, String propuesta){
		Fabrica.getInstance().getICtrlPropuesta().eliminarUsuarioFavorito(nickname, propuesta);
	}

	@WebMethod
	public DataList listarComentarios(String titulo) {
		DataList res = new DataList();
		res.setDatos((ArrayList<DtComentario>) Fabrica.getInstance().getICtrlPropuesta().listarComentarios(titulo));
		return res;
	}
	
	@WebMethod
	public void pagarColabPayPal(float monto, String nombreTitular, String nroCuenta){
		Fabrica.getInstance().getICtrlPropuesta().pagarColabPayPal(monto, nombreTitular, nroCuenta);
	}
	
	@WebMethod
	public void pagarColabTarjeta(float monto, String nombreTitular, String numero, TTarjeta tipo, DataDate vencimiento, String cvc){
		Fabrica.getInstance().getICtrlPropuesta().pagarColabTarjeta(monto, nombreTitular, numero, tipo, vencimiento.getDate(), cvc);
	}
	
	
	@WebMethod
	public void pagarColabTransferencia(float monto, String nombreTitular, String nomBanco, String nroCuenta){
		Fabrica.getInstance().getICtrlPropuesta().pagarColabTransferencia(monto, nombreTitular, nomBanco, nroCuenta);
	}
	
	@WebMethod
	public DtComentario getDtComentario() {
		return null;
	}
	
}
