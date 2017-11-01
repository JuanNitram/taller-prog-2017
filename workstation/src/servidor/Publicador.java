package servidor;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import logica.Fabrica;
import logica.ICtrlPropuesta;
import logica.ICtrlUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
    private Endpoint endpoint = null;
    
    public Publicador() {
    	
    }

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:10005/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public ICtrlUsuario getICtrlUsuario() {
    	return Fabrica.getInstance().getICtrlUsuario();
    }
    
    @WebMethod
    public ICtrlPropuesta getICtrlPropuesta() {
    	return Fabrica.getInstance().getICtrlPropuesta();
    }
}
