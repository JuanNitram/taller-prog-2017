package Tests;

import static org.junit.Assert.*;

import javax.swing.tree.TreePath;

import org.junit.Test;

import logica.controladores.CtrlPropuesta;

public class CategoriasTest {

	@Test
	public void test() {
		
		CtrlPropuesta cp = CtrlPropuesta.getInstance();

		String[] ruta = new String[]{"Categoría"};
		cp.crearCategoria(new TreePath(ruta), "Teatro");
		cp.crearCategoria(new TreePath(ruta), "Literatura");
		cp.crearCategoria(new TreePath(ruta), "Música");
		cp.crearCategoria(new TreePath(ruta), "Cine");
		cp.crearCategoria(new TreePath(ruta), "Danza");
		cp.crearCategoria(new TreePath(ruta), "Carnaval");
		ruta = new String[]{"Categoría","Teatro"};
		cp.crearCategoria(new TreePath(ruta), "Teatro Dramático");
		cp.crearCategoria(new TreePath(ruta), "Teatro Musical");
		cp.crearCategoria(new TreePath(ruta), "Comedia");
		ruta = new String[]{"Categoría","Teatro","Comedia"};
		cp.crearCategoria(new TreePath(ruta), "Stand-up");
		ruta = new String[]{"Categoría","Música"};
		cp.crearCategoria(new TreePath(ruta), "Festival");
		cp.crearCategoria(new TreePath(ruta), "Concierto");
		ruta = new String[]{"Categoría","Cine"};
		cp.crearCategoria(new TreePath(ruta), "Cine al Aire Libre");
		cp.crearCategoria(new TreePath(ruta), "Cine a Pedal");
		ruta = new String[]{"Categoría","Danza"};
		cp.crearCategoria(new TreePath(ruta), "Ballet");
		cp.crearCategoria(new TreePath(ruta), "Flamenco");
		ruta = new String[]{"Categoría","Carnaval"};
		cp.crearCategoria(new TreePath(ruta), "Murga");
		cp.crearCategoria(new TreePath(ruta), "Humoristas");
		cp.crearCategoria(new TreePath(ruta), "Parodistas");
		cp.crearCategoria(new TreePath(ruta), "Lubolos");
		cp.crearCategoria(new TreePath(ruta), "Revista");
		
		assertEquals(cp.listarCategorias().getLeafCount(),15);
		assertEquals(cp.listarCategorias().getChildCount(),6);
		assertEquals(cp.listarCategorias().getDepth(),3);

	}

}
