package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import logica.clases.Estado;
import logica.controladores.CtrlPropuesta;
import logica.controladores.CtrlUsuario;
import dataTypes.DtPropuesta;
import dataTypes.TEstado;
import dataTypes.TRetorno;

/**
 * Test Class para casos de uso CONSULTA PROPUESTA, REGISTRAR COLABORACIÓN y CANCELAR COLABORACIÓN.
 * 
 * @author Grupo 5
 *
 */
public class ConsultaPropuestaColaboraciones {

	@Test
	public void ConsultarPropuestas() {

			CtrlUsuario ICU = CtrlUsuario.getInstance();
			CtrlPropuesta ICP = CtrlPropuesta.getInstance();	
		
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
					new Estado(TEstado.INGRESADA, new Date(2017,05,15,15,30))	
			};
			
			
			Date fecha = new Date(20,07,1989);
			for(int i = 0; i<=2; i++) {
				ICP.altaPropuesta(nicknames[i], titulos[i], null, descripciones[i], lugares[i], fecha, precios[i], 
					TRetorno.ENTRADA_GRATIS,  precios[i], imagenes[i]);
				ICP.cambiarEstado(titulos[i], estados[i]);
			}
		
			/*
			 * Hasta acá se crean 3 proponentes y 3 propuestas.
			 * Las operaciones anteriores son testeadas en AltaPropuestaTest.
			 * 
			 * 
			 * Vamos ahora a registrar 3 colaboradores.
			 */
			
			String [] nicknamesCol = {"Charlie Moon", "Prino", "jaja"};
			String [] nombresCol = {"Carlos", "Martín", "Agustín"};
			String [] apellidosCol = {"Luna", "Prino", "Farías"};
			String [] direccionesCol = {"Por ahí", "Por allá", "Por el otro allá muy lejano"};
			String [] emailsCol = {"peace@gmail", "martin@gmail", "lautix@gmail"}; 
			String [] contraseniasCol = {"Contrasenia", "Contrasenia", "Contrasenia"};
			String [] rutaImgsCol = {"C:/+.jpg", "C:/+.jpg", "C:/+.jpg"};
			Date [] fechaNacimientosCol = {new Date(20,07,1989), 
					new Date(25,05,1988), new Date(10,06,1985), 
					new Date(10,07,1978), new Date(20,07,1988)};
			
			//Damos el alta de los colaboradores y registramos una colaboración a cada propuesta
			for(int i = 0; i<=2;i++) {
				ICU.altaColaborador(nicknamesCol[i],contraseniasCol[i], nombresCol[i], apellidosCol[i], 
						emailsCol[i], rutaImgsCol[i], fechaNacimientosCol[i]);
				ICP.infoPropuesta(titulos[i]);	//Recuerda la propuesta
				ICP.agregarColaboracion(nicknamesCol[i], 1754*i, TRetorno.PORCENTAJE_GANANCIA);
			}
		
			//Nos fijamos que las colaboraciones se hayan agregado correctamente
			for(int i = 0; i<=2; i++) {
				ICP.infoPropuesta(titulos[i]);	//Recuerda la propuesta
				try {
					assertEquals(ICP.infoColaboracion(i+1).getNickname(),nicknamesCol[i]);
					assertEquals(ICP.infoColaboracion(i+1).getRetorno(),TRetorno.PORCENTAJE_GANANCIA);
					assertEquals(ICP.infoColaboracion(i+1).getId(),i+1);
					assertEquals(ICP.infoColaboracion(i+1).getMontoAporte(),1754*i,0.0);
					assertEquals(ICP.infoColaboracion(i+1).getTitulo(),titulos[i]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			//Deberíamos tener al menos 3 colaboraciones hasta acá:
			assertEquals(ICP.listarColaboraciones().size()>=3,true);
			
			
			//Finalizamos el testeo del caso de uso REGISTRAR COLABORACIÓN
			ICP.finalizarRegistrarColaboracionPropuesta();
			
			//Cancelamos las colaboraciones creadas
			for(int i=0; i<2; i++) {
				try {
					ICP.infoColaboracion(i+1);
					ICP.cancelarColaboracion();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			//Chequeamos que las colaboraciones se hayan borrado según su estado.
			//Solo debería quedar una colaboración en la lista.
			assertEquals(ICP.listarColaboraciones().size(),1);
	
			//Finalizamos el testeo del caso de uso cancelar colaboración
			ICP.finalizarCancelarColaboracionPropuesta();
			
			
			//TAREA 2:
			//Listamos los estados de las propuestas
			List<String> estadosPropuesta = ICP.listarEstados();
			assertEquals(estadosPropuesta.size(),6);
			
			
			/*
			 * Evaluo una propuesta que está en estado INGRESADA, para cambiar su estado a "Publicada".
			 * 
			 */
			ICP.infoPropuesta("Una chiva para mi pais");
			ICP.evaluar("p");
			
			/* Listo las propuestas por estado PUBLICADA, dados los datos actuales
			   debería encontrar una sola propuesta. */
			boolean b = false;
			List<DtPropuesta> propuestas = ICP.listarPropuestaPorEstado(TEstado.PUBLICADA);
			for(DtPropuesta p : propuestas) {
				if(p.getTitulo().contains("Una chiva para mi pais")) {
					b = true;
					break;
				}
			}
			
			//Comprueba que efectivamente "Una chiva para mi país" esté en estado 'PUBLICADA'.
			assertEquals(b,true);
			
			
	}

}
