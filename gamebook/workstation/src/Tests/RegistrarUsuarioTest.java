package Tests;

import static org.junit.Assert.*;

import java.util.Date;

import Logica.Fabrica;
import Logica.ICtrlUsuario;
import dataTypes.DtColaborador;
import dataTypes.DtProponente;

import org.junit.Test;
/**
 * 
 * Test Class para casos de uso Alta Proponente y Alta Colaborador
 * (en nuestro sistema, Registrar Proponente y Registrar Colaborador)
 * 
 * @author Grupo 5
 *
 */


public class RegistrarUsuarioTest {
	
	@Test
	public void RegistrarGalera() {
		Fabrica fabrica = Fabrica.getInstance(); 
		ICtrlUsuario ICU = fabrica.getICtrlUsuario();

		String [] nickNames = {"JuanNitram", "SebaPeace", "Flautarix", "JuanchoBax", "Gonzoooh'"};
		String [] nombres = {"Juan Vargas", "Sebastian", "Lautaro", "Juancho", "Gonzo"};
		String [] apellidos = {"Vargas", "Paz", "Cardozo", "Baz", "Hernandes"};
		String [] direcciones = {"Cerca de la torre", "Cerca de la catolica", "La nus cafundao", "Recien se muda", "El Pinar"};
		String [] emails = {"martin@gmail", "peace@gmail", "lautix@gmail", "juancho@gmail", "gonzo@gmail"};
		String [] biografias = {"EL DEBUGGER", "EL TESTER", "EL JARDINERO", "EL JUANCHO", "EL GONZOHH"};
		String [] urlSitios = {"facebook.com", "google.com", "instagram.com", "badoo.com", "netflix.com"};
		String [] contrasenias = {"Contrasenia", "Contrasenia", "Contrasenia", "Contrasenia", "Contrasenia"};
		String [] rutaImgs = {"C:/+.jpg", "C:/+.jpg", "C:/+.jpg", "C:/+.jpg", "C:/+.jpg"};
		Date [] fechaNacimientos = {new Date(20,07,1989), new Date(25,05,1988), new Date(10,06,1985), new Date(10,07,1978), new Date(20,07,1988)};
		
		for(int i = 0; i < nickNames.length; i++) {
			ICU.altaProponente(nickNames[i],contrasenias[i],nombres[i],apellidos[i],direcciones[i], emails[i],biografias[i],urlSitios[i],rutaImgs[i],fechaNacimientos[i]);
			DtProponente dtP = ICU.infoProponente(nickNames[i]);
			assertTrue(dtP.getNickName() == nickNames[i]);
			assertTrue(dtP.getNombre() == nombres[i]);
			assertTrue(dtP.getApellido() == apellidos[i]);
			assertTrue(dtP.getDireccion() == direcciones[i]);
			assertTrue(dtP.getEmail() == emails[i]);
			assertTrue(dtP.getBiografia() == biografias[i]);
			assertTrue(dtP.getLinkSitio() == urlSitios[i]);
			assertTrue(dtP.getRutaImg() == rutaImgs[i]);
			assertTrue(dtP.getFechaNacimiento() == fechaNacimientos[i]);
		}
			
		//Testea que hayan sido ingresados correctamente
		assertTrue(ICU.listarProponentes().size() == 5);
		
		String [] nickNames2 = {"JuanNitram", "SebaPeace", "Flautarix", "JuanchoBax", "Gonzoooh'"};
		String [] nombres2 = {"Juan Vargas", "Sebastian", "Lautaro", "Juancho", "Gonzo"};
		String [] apellidos2 = {"Vargas", "Paz", "Cardozo", "Baz", "Hernandes"};
		String [] emails2 = {"martin@gmail", "peace@gmail", "lautix@gmail", "juancho@gmail", "gonzo@gmail"};
		String [] rutaImgs2 = {"C:/+.jpg", "C:/+.jpg", "C:/+.jpg", "C:/+.jpg", "C:/+.jpg"};
		Date [] fechaNacimientos2 = {new Date(20,07,1989), new Date(25,05,1988), new Date(10,06,1985), new Date(10,07,1978), new Date(20,07,1988)};
		
		for(int i = 0; i < nickNames.length ; i++){
			ICU.altaColaborador(nickNames2[i],contrasenias[i], nombres2[i], apellidos[i], emails[i], rutaImgs2[i], fechaNacimientos2[i]);
			DtColaborador dtP = ICU.infoColaborador(nickNames2[i]);
			assertTrue(dtP.getNickName() == nickNames2[i]);
			assertTrue(dtP.getNombre() == nombres2[i]);
			assertTrue(dtP.getApellido() == apellidos2[i]);
			assertTrue(dtP.getEmail() == emails2[i]);
			assertTrue(dtP.getRutaImg() == rutaImgs2[i]);
			assertTrue(dtP.getFechaNacimiento() == fechaNacimientos2[i]);
			
		}
		//Testea que hayan sido ingresados correctamente. Los colaboradores se mantienen desde tests anteriores, por lo tanto
		//deben existir, a este punto de la verificación, si o si, al menos 5 colaboradores.
		assertTrue(ICU.listarColaboradores().size() >= 5);
		
		
		//Para terminar, verifica que se hayan efectivamente creado 10 usuarios
	//	assertTrue(ICU.listarUsuarios().size() == 10);
		
	}
	
	@Test
	public void verificarUsuarios(){
		Fabrica fabrica = Fabrica.getInstance(); 
		ICtrlUsuario ICU = fabrica.getICtrlUsuario();

		String [] nickNames = {"JuanNitram", "SebaPeace", "Flautarix", "JuanchoBax", "Gonzoooh'"};
		String [] nombres = {"Juan Vargas", "Sebastian", "Lautaro", "Juancho", "Gonzo"};
		String [] apellidos = {"Vargas", "Paz", "Cardozo", "Baz", "Hernandes"};
		String [] direcciones = {"Cerca de la torre", "Cerca de la catolica", "La nus cafundao", "Recien se muda", "El Pinar"};
		String [] emails = {"martin@gmail", "peace@gmail", "lautix@gmail", "juancho@gmail", "gonzo@gmail"};
		String [] biografias = {"EL DEBUGGER", "EL TESTER", "EL JARDINERO", "Juancho", "Gonzo"};
		String [] urlSitios = {"facebook.com", "google.com", "instagram.com", "badoo.com", "netflix.com"};
		String [] contraseniasCol = {"Contrasenia", "Contrasenia", "Contrasenia","Contrasenia","Contrasenia"};
		String [] rutaImgs = {"C:/+.jpg", "C:/+.jpg", "C:/+.jpg", "C:/+.jpg", "C:/+.jpg"};
		Date [] fechaNacimientos = {new Date(20,07,1989), new Date(25,05,1988), new Date(10,06,1985), new Date(10,07,1978), new Date(20,07,1988)};
		
		for(int i = 0; i < nickNames.length; i++) {
			ICU.altaProponente(nickNames[i],contraseniasCol[i],nombres[i],apellidos[i],direcciones[i], emails[i],biografias[i],urlSitios[i],rutaImgs[i],fechaNacimientos[i]);
			DtProponente dtP = ICU.infoProponente(nickNames[i]);
			assertTrue(dtP.getNickName() == nickNames[i]);
			assertTrue(dtP.getNombre() == nombres[i]);
			assertTrue(dtP.getApellido() == apellidos[i]);
			assertTrue(dtP.getDireccion() == direcciones[i]);
			assertTrue(dtP.getEmail() == emails[i]);
			assertTrue(dtP.getBiografia() == biografias[i]);
			assertTrue(dtP.getLinkSitio() == urlSitios[i]);
			assertTrue(dtP.getRutaImg() == rutaImgs[i]);
			assertTrue(dtP.getFechaNacimiento() == fechaNacimientos[i]);
		}
		 
		assertTrue(ICU.listarUsuarios().size() >= 5);
	}
}