package logica;

import logica.controladores.CtrlPropuesta;
import logica.controladores.CtrlUsuario;

public class Fabrica {
	private static final Fabrica instance = new Fabrica();
	
	private Fabrica(){}
	
	public static Fabrica getInstance(){
		return instance;
	}
	
	public ICtrlUsuario getICtrlUsuario(){
		return CtrlUsuario.getInstance();
	}
	
	public ICtrlPropuesta getICtrlPropuesta(){
		return CtrlPropuesta.getInstance();
	}
}
