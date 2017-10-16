package Tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Logica.Datos;

@RunWith(Suite.class)
@SuiteClasses({ RegistrarUsuarioTest.class, SeguirUsuarioTest.class, AltaPropuestaTest.class, 
	ConsultaPropuestaColaboraciones.class, CategoriasTest.class, DatosTest.class })
public class AllTests {

}
