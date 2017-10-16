package Tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Logica.Fabrica;
import Logica.ICtrlPropuesta;
import Logica.ICtrlUsuario;
import Logica.clases.Estado;
import Logica.controladores.CtrlPropuesta;
import Logica.controladores.CtrlUsuario;
import dataTypes.DtCategoria;
import dataTypes.TEstado;
import dataTypes.TRetorno;

public class AltaPropuestaTest {

	/**
	 *	Test Class para caso de uso ALTA PROPUESTA
	 *	(En nuestro sistema, Registrar Propuesta) 
	 *
	 *	@author Grupo 5
	 */
	
	@Test
	public void RegistrarPropuestas() {	
		
		//Obtengo instancias
		CtrlUsuario ICU = CtrlUsuario.getInstance();
		CtrlPropuesta ICP = CtrlPropuesta.getInstance();
		
		//Creo proponentes
		String [] nicknames = {"SebaPeace", "JuanNitram", "Flautarix"};
		String [] nombres = {"Sebastian", "Juan", "Lautaro"};
		String [] apellidos = {"Paz Pereira", "Vargas García", "Cardozo Ramírez"};
		String [] direcciones = {"Por ahí", "Por allá", "Por el otro allá muy lejano"};
		String [] emails = {"peace@gmail", "martin@gmail", "lautix@gmail"};
		String [] biografias = {"EL TESTER", "EL DEBUGGER", "EL GARDENER"};
		String [] urlSitios = {"facebook.com", "google.com", "instagram.com"};
		String [] contrasenias = {"Contrasenia", "Contrasenia", "Contrasenia"};
		
		String [] rutaImgs = {"C:/+.jpg", "C:/+.jpg", "C:/+.jpg"};
		Date [] fechaNacimientos = {new Date(20,07,1989), new Date(25,05,1988), new Date(10,06,1985)};
		for(int i = 0; i<=2; i++) 
			ICU.altaProponente(nicknames[i],contrasenias[i], nombres[i], apellidos[i], direcciones[i], emails[i], 
					biografias[i], urlSitios[i], rutaImgs[i], fechaNacimientos[i]);
			
		//Creo los datos para las propuestas
		Estado e;
		String [] titulos = {"La Gonzoneta!", "La nueva PC", "Una chiva para mi pais"};
		String [] descripciones = {
				"Una genial camioneta con forma de pan de molde! Entradas con menor precio que el boleto urbano.",
				"Quiero una PC Gamer. PC Master Race! Alquilo 24hs.",
				"Tremenda bici me vi el otro día. La quiero! Por $15 te la presto."
		};
		String[] lugares = {"Montevideo, Uruguay","Rivera, Uruguay","Montevideo, Uruguay" };
		String[] imagenes = {
				"C:/gonzonetaProyecto.jpg",
				"C:/i7-7700K-64gb-256gbssd-2tbhdd-gtx1080TI-thermaltakelvl9.jpg",
				"C:/miBMX.jpg"
		};
		float [] precios = {120000, 150000, 20000};
		Estado [] estados = {
				new Estado(TEstado.EN_FINANCIACION, new Date(2017,05,15,15,30)),
				new Estado(TEstado.PUBLICADA, new Date(2017,05,15,15,30)), 
				new Estado(TEstado.CANCELADA, new Date(2017,05,15,15,30))	
		};
	
		Date fecha = new Date(20,07,1989);
		
		//Creo las propuestas
		for(int i = 0; i<=2; i++) {
			ICP.altaPropuesta(nicknames[i], titulos[i], null, descripciones[i], lugares[i], fecha, fecha, precios[i], 
				TRetorno.ENTRADA_GRATIS,  precios[i], imagenes[i]);
			ICP.cambiarEstado(titulos[i], estados[i]);
		}
		
		//Chequeo que las propuestas existan y existan a su vez el usuario (según como está implementada existePropuesta,
		//resultado correcto es false si existe el usuario y no la propuesta, y true en cualquier otro caso contrario)
		assertEquals(ICP.existePropuesta("SebaPeace",  titulos[0]),false);
		assertEquals(ICP.existePropuesta("JuanNitram", titulos[1]),false);
		assertEquals(ICP.existePropuesta("Flautarix",  titulos[2]),false);
		assertEquals(ICP.existePropuesta("SebaPeace",  "Yo ordeño"),true);
		
		//Chequeo que la información devuelta por las propuestas sea la correcta
		for(int i = 0; i<=2; i++) {
			assertEquals(ICP.infoPropuesta(titulos[i]).getNickProponente(),nicknames[i]);
			assertEquals(ICP.infoPropuesta(titulos[i]).getTitulo(),titulos[i]);
			assertEquals(ICP.infoPropuesta(titulos[i]).getCategoria(),null);
			assertEquals(ICP.infoPropuesta(titulos[i]).getDescripcion(),descripciones[i]); 
			assertEquals(ICP.infoPropuesta(titulos[i]).getFechaPublicacion(),fecha);
			assertEquals(ICP.infoPropuesta(titulos[i]).getFechaRealizacion(),fecha);
			assertEquals(ICP.infoPropuesta(titulos[i]).getLugar(),lugares[i]);
			assertEquals(ICP.infoPropuesta(titulos[i]).getMontoReunir(),precios[i],1.0);
			assertEquals(ICP.infoPropuesta(titulos[i]).getPrecioEntrada(),precios[i],1.0);
			assertEquals(ICP.infoPropuesta(titulos[i]).getRutaImg(),imagenes[i]);
			assertEquals(ICP.infoPropuesta(titulos[i]).getTipoRetorno(),TRetorno.ENTRADA_GRATIS);
		}
		
		//Por último chequeo que se agregaron todas las propuestas
		assertEquals(ICP.listarPropuestas().size() >= 3, true);
		
		
		ICP.modificarPropuesta("La nueva PC", "", "", new Date(), 0, 0);
		
	}
}
