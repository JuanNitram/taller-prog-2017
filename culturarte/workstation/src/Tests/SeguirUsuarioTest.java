package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import logica.Fabrica;
import logica.ICtrlUsuario;
import dataTypes.DtUsuario;

public class SeguirUsuarioTest {

	@Test
	public void test() {
		Fabrica fabrica = Fabrica.getInstance();
		ICtrlUsuario ICU = fabrica.getICtrlUsuario();
		
		ICU.altaProponente("JuanNitram","Contrasenia", "Juan", "Vargas", "libres", "juanmvg2006", "Soy un galan", "badoo.com", "C:/perfil.jpg", new Date(20,06,1994));
		ICU.altaProponente("peterAlfons","Contrasenia", "Pedro", "alfonso", "joaquin suarez", "peter2006", "Soy un feo", "badoo.com", "C:/perfil.jpg", new Date(20,06,1994));
		ICU.altaColaborador("EnriqueCMG","Contrasenia", "Enrique", "Telechea", "Elenriqueparavos_94", "C:/perfil.jpg", new Date(25,07,1994));
		
		ICU.elegirSeguidor("JuanNitram");
		ICU.elegirSeguido("EnriqueCMG");
		ICU.seguir();
		
		// Verifica si se agrego correctamente el seguidor JuanNitram a EnriqueCMG
		List<DtUsuario> seguidoresEnriqueCMG = ICU.listarSeguidores("EnriqueCMG");
		assertTrue(seguidoresEnriqueCMG.size() == 1);
		
		ICU.elegirSeguidor("peterAlfons");
		ICU.elegirSeguido("EnriqueCMG");
		ICU.seguir();
		
		// Verifica si se agrego correctamente el seguidor peterAlfons a EnriqueCMG (Enrique debe tener 2 seguidores)
		seguidoresEnriqueCMG = ICU.listarSeguidores("EnriqueCMG");
		assertTrue(seguidoresEnriqueCMG.size() == 2);
	}

}
