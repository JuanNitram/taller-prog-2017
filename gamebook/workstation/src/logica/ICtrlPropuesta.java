package Logica;

import java.util.Date;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import dataTypes.DtCategoria;
import dataTypes.DtColaboracion;
import dataTypes.DtColaborador;
import dataTypes.DtPropuesta;
import dataTypes.TEstado;
import dataTypes.TRetorno;

import java.util.ArrayList;

public interface ICtrlPropuesta {

	boolean existePropuesta(String nickName, String titulo);
	
	void altaPropuesta(String nickName, String titulo,DtCategoria categoria, String descripcion, String lugar, Date fechaRealizacion,
			float montoReunir, TRetorno tipoRetorno, float precioEntrada, String rutaImg);

	void modificarPropuesta(String titulo, String descripcion, String lugar, Date fechaRealizacion,
			float montoReunir, float precioEntrada);
	
	ArrayList<DtPropuesta> listarPropuestas(); 
	ArrayList<DtColaborador> listarColaboradores();

	ArrayList<DtColaboracion> listarColaboraciones();
	
	DtPropuesta infoPropuesta(String titulo) throws Exception;
	
	DtColaboracion infoColaboracion(int id) throws Exception;
	
	void agregarColaboracion(String nickname, float monto, TRetorno retorno);
	
	void cancelarColaboracion();
	
	void finalizarRegistrarColaboracionPropuesta();
	
	void finalizarCancelarColaboracionPropuesta();

	void crearCategoria(TreePath ruta, String nombreCat);

	DefaultMutableTreeNode listarCategorias();
	
	ArrayList<String> listarEstados();
	
	ArrayList<DtPropuesta> listarPropuestaPorEstado(TEstado estado);

	void evaluar(String evaluacion);
	
	void agregarComentario(String nickname, String titulo, String comentario);	
}
