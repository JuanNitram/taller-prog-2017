package Logica;

import java.util.Calendar;
import java.util.Date;

import javax.swing.tree.TreePath;

import Logica.clases.Estado;
import Logica.controladores.CtrlPropuesta;
import Logica.controladores.CtrlUsuario;
import dataTypes.DtCategoria;
import dataTypes.TEstado;
import dataTypes.TRetorno;

public class Datos {

	public Datos() {
		
		CtrlUsuario cu = CtrlUsuario.getInstance();
		CtrlPropuesta cp = CtrlPropuesta.getInstance();
		
		Calendar fecha = Calendar.getInstance();
		
		//HR
		fecha.set(1962,01,25);
		cu.altaProponente("hrubino","K6keGZEx", "Horacio", "Rubino", "18 de Julio 1234", "horacio.rubino@guambia.com.uy", 
		"Horacio Rubino Torres nace el 25 de febrero de 1962, es conductor, actor y libretista. Debuta en 1982 en carnaval "
		+ "en Los \"Klaper�s\", donde estuvo cuatro a�os, actuando y libretando. Luego para \"Gaby�s\" (6 a�os), escribi� en "
		+ "categor�a revistas y humoristas y desde el comienzo y hasta el presente en su propio conjunto Momosapiens.", 
		"https://twitter.com/horaciorubino", "hr", fecha.getTime());
		//MB
		fecha.set(1972,05,14);
		cu.altaProponente("mbusca","aL4aNcYF", "Mart�n", "Buscaglia", "Colonia 4321", "Martin.bus@agadu.org.uy", 
		"Mart�n Buscaglia (Montevideo, 1972) es un artista, m�sico, compositor y productor uruguayo. Tanto con su banda"
		+ "	(�Los Bochamakers�) como en su formato �Hombre orquesta�, o solo con su guitarra, ha recorrido el mundo"
		+ "	tocando entre otros pa�ses en Espa�a, Estados Unidos, Inglaterra, Francia, Australia, Brasil, Colombia, Argentina, "
		+ "Chile, Paraguay, M�xico y Uruguay. (Actualmente los Bochamakers son Mat�as Rada, Mart�n Ibarburu, Mateo "
		+ "Moreno, Herman Klang) Paralelamente, tiene proyectos a d�o con el espa�ol Kiko Veneno, la cubana Yusa, el "
		+ "argentino Lisandro Aristimu�o, su compatriota Antol�n, y a tr�o junto a los brasileros Os Mulheres Negras.", 
		"http://www.martinbuscaglia.com/", "mb", fecha.getTime());
		//HG
		fecha.set(1954,00,07);
		cu.altaProponente("hectorg","dcUCulNa", "H�ctor", "Guido", "Gral. Flores 5645", "hector.gui@elgalpon.org.uy", 
		"En 1972 ingres� a la Escuela de Arte Dram�tico del teatro El Galp�n. Particip� en m�s de treinta obras teatrales y "
		+ "varios largometrajes. Integr� el elenco estable de Radioteatro del Sodre, y en 2006 fue asesor de su Consejo	"
		+ "Directivo. Como actor recibi� m�ltiples reconocimientos: cuatro premios Florencio, premio al mejor actor	"
		+ "extranjero del Festival de Miami y premio Mejor Actor de Cine 2008. Durante varios per�odos fue directivo del "
		+ "teatro El Galp�n y dirigente de la Sociedad Uruguaya de Actores (SUA); integr� tambi�n la Federaci�n Uruguaya "
		+ "de Teatros Independientes (FUTI). Form� parte del equipo de gesti�n de la refacci�n de los teatros La M�scara, "
		+ "Astral y El Galp�n, y del equipo de gesti�n en la construcci�n del teatro De la Candela y de la sala Atahualpa de El "
		+ "Galp�n.", "", "hg", fecha.getTime());
		//TC
		fecha.set(1971,06,24);
		cu.altaProponente("tabarec","od5CX5gS", "Tabar�", "Cardozo", "Santiago Rivas 1212", "tabare.car@agadu.org.uy", 
		"Tabar� Cardozo (Montevideo, 24 de julio de 1971) es un cantante, compositor y murguista uruguayo; conocido por	"
		+ "su participaci�n en la murga Agarrate Catalina, conjunto que fund� junto a su hermano Yamand� y Carlos "
		+ "Tanco en el a�o 2001.", 
		"https://www.facebook.com/Tabar%C3%A9-Cardozo-55179094281/?ref=br_rs", "tc", fecha.getTime());
		//CS
		fecha.set(1947,00,01);
		cu.altaProponente("cachilas","JGgqYPTS", "Waldemar �Cachila�", "Silva", "Br. Artigas 4567", "Cachila.sil@c1080.org.uy", 
		"Nace en el a�o 1947 en el conventillo \"Medio Mundo\" ubicado en pleno Barrio Sur. Es heredero parcialmentejunto	"
		+ "al resto de sus hermanos- de la Comparsa \"Morenada\" (inactiva desde el fallecimiento de Juan �ngel Silva), "
		+ "en 1999 forma su propia Comparsa de negros y lubolos \"Cuareim 1080\". Director responsable, compositor y cantante de la misma.", 
		"https://www.facebook.com/C1080?ref=br_rs", "cs", fecha.getTime());
		//JB
		fecha.set(1967,02,16);
		cu.altaProponente("juliob","9FpNxvih", "Julio", "Bocca", "Benito Blanco 4321", "juliobocca@sodre.com.uy", "", "", "", fecha.getTime());
		//DP
		fecha.set(1975,00,01);
		cu.altaProponente("diegop","s7L8BpKG", "Diego", "Parodi", "Emilio Frugoni 1138", "diego@efectocine.com", "", "http://www.efectocine.com", "",
		fecha.getTime());
		//KH
		fecha.set(1840,03,25);
		cu.altaProponente("kairoh","Xa0GPWZA", "Kairo", "Herrera", "Paraguay 1423", "kairoher@pilsenrock.com.uy", "", "", 
		"kh", fecha.getTime());
		//LB
		fecha.set(1980,10,31);
		cu.altaProponente("losBardo","r8b16VnQ", "Los", "Bardo", "8 de Octubre 1429", "losbardo@bardocientifico.com", 
		"Queremos ser vistos y reconocidos como una organizaci�n: referente en divulgaci�n cient�fica con un fuerte	"
		+ "esp�ritu did�ctico y divertido, a trav�s de acciones coordinadas con otros divulgadores cient�ficos, que permitan "
		+ "establecer puentes de comunicaci�n. Impulsora en la generaci�n de espacios de democratizaci�n y apropiaci�n "
		+ "social del conocimiento cient�fico.", "https://bardocientifico.com/", "lb", fecha.getTime());
				
		//RH
		fecha.set(1940,8,03);
		cu.altaColaborador("robinh","V1sPsIpl", "Robin", "Henderson", "Robin.h@tinglesa.com.uy", "", fecha.getTime());
		//MT
		fecha.set(1960,03,01);
		cu.altaColaborador("marcelot","S0E8vCK2", "Marcelo", "Tinelli", "marcelot@ideasdelsur.com.ar", "mt", fecha.getTime());
		//EN
		fecha.set(1952,06,17);
		cu.altaColaborador("novick","kZIwfxnV", "Edgardo", "Novick", "edgardo@novick.com.uy", "en", fecha.getTime());
		//SP
		fecha.set(1950,00,28);
		cu.altaColaborador("sergiop","Fld4hEtI", "Sergio", "Puglia", "puglia@alpanpan.com.uy", "sp", fecha.getTime());
		//AR
		fecha.set(1976,02,17);
		cu.altaColaborador("chino","1BAoBp1r", "Alvaro", "Recoba", "chino@trico.org.uy", "", fecha.getTime());
		//AP
		fecha.set(1955,01,14);
		cu.altaColaborador("tonyp","9ovUu61d", "Antonio", "Pacheco", "eltony@manya.org.uy", "ap", fecha.getTime());
		//NJ
		fecha.set(1960,8,9);
		cu.altaColaborador("nicoJ","c9ogZ9r4", "Nicol�s", "Jodal", "jodal@artech.com.uy", "nj", fecha.getTime());
		//JP
		fecha.set(1970,00,01);
		cu.altaColaborador("juanP","aDJvvrJm", "Juan", "Perez", "juanp@elpueblo.com", "", fecha.getTime());
		//MG
		fecha.set(1982,01,02);
		cu.altaColaborador("Mengano","bfEWtrqQ", "Mengano", "G�mez", "menganog@elpueblo.com", "", fecha.getTime());
		//PL
		fecha.set(1985,02,03);
		cu.altaColaborador("Perengano","m5nbaRBV", "Perengano", "L�pez", "pere@elpueblo.com", "", fecha.getTime());
		//TJ
		fecha.set(1990,03,04);
		cu.altaColaborador("Tiajaci","uIo1s1GR", "T�a", "Jacinta", "jacinta@elpueblo.com", "", fecha.getTime());
		
		cu.elegirSeguidor("hrubino");
		cu.elegirSeguido("hectorg");
		cu.seguir();
		cu.elegirSeguido("diegop");
		cu.seguir();
		cu.elegirSeguido("losBardo");
		cu.seguir();

		cu.elegirSeguidor("mbusca");
		cu.elegirSeguido("tabarec");
		cu.seguir();
		cu.elegirSeguido("cachilas");
		cu.seguir();
		cu.elegirSeguido("kairoh");
		cu.seguir();

		cu.elegirSeguidor("hectorg");
		cu.elegirSeguido("mbusca");
		cu.seguir();
		cu.elegirSeguido("juliob");
		cu.seguir();

		cu.elegirSeguidor("tabarec");
		cu.elegirSeguido("hrubino");
		cu.seguir();
		cu.elegirSeguido("cachilas");
		cu.seguir();

		cu.elegirSeguidor("cachilas");
		cu.elegirSeguido("hrubino");
		cu.seguir();

		cu.elegirSeguidor("juliob");
		cu.elegirSeguido("mbusca");
		cu.seguir();
		cu.elegirSeguido("diegop");
		cu.seguir();

		cu.elegirSeguidor("diegop");
		cu.elegirSeguido("hectorg");
		cu.seguir();
		cu.elegirSeguido("losBardo");
		cu.seguir();

		cu.elegirSeguidor("kairoh");
		cu.elegirSeguido("sergiop");
		cu.seguir();

		cu.elegirSeguidor("losBardo");
		cu.elegirSeguido("hrubino");
		cu.seguir();
		cu.elegirSeguido("nicoJ");
		cu.seguir();

		cu.elegirSeguidor("robinh");
		cu.elegirSeguido("hectorg");
		cu.seguir();
		cu.elegirSeguido("juliob");
		cu.seguir();
		cu.elegirSeguido("diegop");
		cu.seguir();

		cu.elegirSeguidor("marcelot");
		cu.elegirSeguido("cachilas");
		cu.seguir();
		cu.elegirSeguido("juliob");
		cu.seguir();
		cu.elegirSeguido("kairoh");
		cu.seguir();

		cu.elegirSeguidor("novick");
		cu.elegirSeguido("hrubino");
		cu.seguir();
		cu.elegirSeguido("tabarec");
		cu.seguir();
		cu.elegirSeguido("cachilas");
		cu.seguir();

		cu.elegirSeguidor("sergiop");
		cu.elegirSeguido("mbusca");
		cu.seguir();
		cu.elegirSeguido("juliob");
		cu.seguir();
		cu.elegirSeguido("diegop");
		cu.seguir();

		cu.elegirSeguidor("chino");
		cu.elegirSeguido("tonyp");
		cu.seguir();

		cu.elegirSeguidor("tonyp");
		cu.elegirSeguido("chino");
		cu.seguir();

		cu.elegirSeguidor("nicoJ");
		cu.elegirSeguido("diegop");
		cu.seguir();
		cu.elegirSeguido("losBardo");
		cu.seguir();

		cu.elegirSeguidor("juanP");
		cu.elegirSeguido("tabarec");
		cu.seguir();
		cu.elegirSeguido("cachilas");
		cu.seguir();
		cu.elegirSeguido("kairoh");
		cu.seguir();

		cu.elegirSeguidor("Mengano");
		cu.elegirSeguido("hectorg");
		cu.seguir();
		cu.elegirSeguido("juliob");
		cu.seguir();
		cu.elegirSeguido("chino");
		cu.seguir();

		cu.elegirSeguidor("Perengano");
		cu.elegirSeguido("diegop");
		cu.seguir();
		cu.elegirSeguido("tonyp");
		cu.seguir();

		cu.elegirSeguidor("Tiajaci");
		cu.elegirSeguido("juliob");
		cu.seguir();
		cu.elegirSeguido("kairoh");
		cu.seguir();
		cu.elegirSeguido("sergiop");
		
		
		String[] ruta = new String[]{"Categor�a"};
		cp.crearCategoria(new TreePath(ruta), "Teatro");
		cp.crearCategoria(new TreePath(ruta), "Literatura");
		cp.crearCategoria(new TreePath(ruta), "M�sica");
		cp.crearCategoria(new TreePath(ruta), "Cine");
		cp.crearCategoria(new TreePath(ruta), "Danza");
		cp.crearCategoria(new TreePath(ruta), "Carnaval");
		ruta = new String[]{"Categor�a","Teatro"};
		cp.crearCategoria(new TreePath(ruta), "Teatro Dram�tico");
		cp.crearCategoria(new TreePath(ruta), "Teatro Musical");
		cp.crearCategoria(new TreePath(ruta), "Comedia");
		ruta = new String[]{"Categor�a","Teatro","Comedia"};
		cp.crearCategoria(new TreePath(ruta), "Stand-up");
		ruta = new String[]{"Categor�a","M�sica"};
		cp.crearCategoria(new TreePath(ruta), "Festival");
		cp.crearCategoria(new TreePath(ruta), "Concierto");
		ruta = new String[]{"Categor�a","Cine"};
		cp.crearCategoria(new TreePath(ruta), "Cine al Aire Libre");
		cp.crearCategoria(new TreePath(ruta), "Cine a Pedal");
		ruta = new String[]{"Categor�a","Danza"};
		cp.crearCategoria(new TreePath(ruta), "Ballet");
		cp.crearCategoria(new TreePath(ruta), "Flamenco");
		ruta = new String[]{"Categor�a","Carnaval"};
		cp.crearCategoria(new TreePath(ruta), "Murga");
		cp.crearCategoria(new TreePath(ruta), "Humoristas");
		cp.crearCategoria(new TreePath(ruta), "Parodistas");
		cp.crearCategoria(new TreePath(ruta), "Lubolos");
		cp.crearCategoria(new TreePath(ruta), "Revista");

		
		Estado e;
		fecha.set(2017,8,16);
		cp.altaPropuesta("diegop", "Cine en el Bot�nico", new DtCategoria("Cine al Aire Libre"), "El 16 de Diciembre a la hora 20 se proyectar� la pel�cula \"Clever\","
		+ " en el Jard�n Bot�nico (Av. 19 de Abril 1181) en el marco de las actividades realizadas por el ciclo Cultura al Aire Libre."
		+ " El largometraje uruguayo de ficci�n Clever es dirigido por Federico Borgia y Guillermo Madeiro. Es apto para mayores de 15 a�os.", 
		"Jard�n Bot�nico", fecha.getTime(), new Date(), 150000, TRetorno.PORCENTAJE_GANANCIA, 200, "");
		cp.borrarPrimerEstado("Cine en el Bot�nico");
		fecha.set(2017,04,15,15,30);
		e = new Estado(TEstado.INGRESADA, fecha.getTime());
		cp.cambiarEstado("Cine en el Bot�nico", e);
		fecha.set(2017,04,17,8,30);
		e = new Estado(TEstado.PUBLICADA, fecha.getTime());
		cp.cambiarEstado("Cine en el Bot�nico", e);
		fecha.set(2017,04,20,14,30);
		e = new Estado(TEstado.EN_FINANCIACION, fecha.getTime());
		cp.cambiarEstado("Cine en el Bot�nico", e);
		fecha.set(2017,04,30,18,30);
		e = new Estado(TEstado.FINANCIADA, fecha.getTime());
		cp.cambiarEstado("Cine en el Bot�nico", e);
		fecha.set(2017,05,15,14,50);
		e = new Estado(TEstado.CANCELADA, fecha.getTime());
		cp.cambiarEstado("Cine en el Bot�nico", e);
		
		fecha.set(2017,9,07);
		cp.altaPropuesta("hrubino", "Religiosamente", new DtCategoria("Parodistas"), "MOMOSAPIENS presenta \"Religiosamente\". Mediante dos parodias y un hilo conductor "
		+ "que aborda la tem�tica de la religi�n Momosapiens, mediante el humor y la reflexi�n, hilvana una historia que muestra al hombre "
		+ "inmerso en el tema religioso. El libreto est� escrito utilizando diferentes lenguajes de humor, dando una visi�n sat�rica y reflexiva "
		+ "desde distintos puntos de vista, logrando mediante situaciones par�dicas armar una propuesta plena de arte carnavalero.", 
		"Teatro de Verano", fecha.getTime(), new Date(), 300000, TRetorno.PORCENTAJE_Y_ENTRADAS, 300, "mom");
		cp.borrarPrimerEstado("Religiosamente");
		fecha.set(2017,05,18,4,28);
		e = new Estado(TEstado.INGRESADA, fecha.getTime());
		cp.cambiarEstado("Religiosamente", e);
		fecha.set(2017,05,20,4,56);
		e = new Estado(TEstado.PUBLICADA, fecha.getTime());
		cp.cambiarEstado("Religiosamente", e);
		fecha.set(2017,05,30,14,25);
		e = new Estado(TEstado.EN_FINANCIACION, fecha.getTime());
		cp.cambiarEstado("Religiosamente", e);
		fecha.set(2017,06,15,9,45);
		e = new Estado(TEstado.FINANCIADA, fecha.getTime());
		cp.cambiarEstado("Religiosamente", e);
		
		fecha.set(2017,9,19);
		cp.altaPropuesta("mbusca", "El Pimiento Indomable", new DtCategoria("Concierto"), "El Pimiento Indomable, formaci�n compuesta por Kiko Veneno y el uruguayo "
		+ "Mart�n Buscaglia, presentar� este 19 de Octubre, su primer trabajo. Bajo un t�tulo hom�nimo al del grupo, es un disco que seg�n "
		+ "los propios protagonistas �no se parece al de ninguno de los dos por separado. Entre los t�tulos que se podr�n escuchar se encuentran "
		+ "�Nadador salvador�, �Am�rica es m�s grande�, �Pescaito Enroscado� o �La reina del placer�. ", 
		"Teatro Sol�s", fecha.getTime(), new Date(), 400000, TRetorno.PORCENTAJE_GANANCIA, 400, "pim");
		cp.borrarPrimerEstado("El Pimiento Indomable");
		fecha.set(2017,06,26,15,30);
		e = new Estado(TEstado.INGRESADA, fecha.getTime());
		cp.cambiarEstado("El Pimiento Indomable", e);
		fecha.set(2017,06,31,8,30);
		e = new Estado(TEstado.PUBLICADA, fecha.getTime());
		cp.cambiarEstado("El Pimiento Indomable", e);
		fecha.set(2017,7,01,07,40);
		e = new Estado(TEstado.EN_FINANCIACION, fecha.getTime());
		cp.cambiarEstado("El Pimiento Indomable", e);
		
		fecha.set(2017,9,21);
		cp.altaPropuesta("kairoh", "Pilsen Rock", new DtCategoria("Festival"), "La edici�n 2017 del Pilsen Rock se celebrar� el 21 de Octubre en la Rural del Prado y contar� "
		+ "con la participaci�n de m�s de 15 bandas nacionales. Quienes no puedan trasladarse al lugar, tendr�n la posibilidad de disfrutar los shows "
		+ "a trav�s de Internet, as� como entrevistas en vivo a los m�sicos una vez finalizados los conciertos. ", 
		"Rural de Prado", fecha.getTime(), new Date(), 900000, TRetorno.PORCENTAJE_Y_ENTRADAS, 1000, "pil");
		cp.borrarPrimerEstado("Pilsen Rock");
		fecha.set(2017,06,30,15,40);
		e = new Estado(TEstado.INGRESADA, fecha.getTime());
		cp.cambiarEstado("Pilsen Rock", e);
		fecha.set(2017,7,01,14,30);
		e = new Estado(TEstado.PUBLICADA, fecha.getTime());
		cp.cambiarEstado("Pilsen Rock", e);
		fecha.set(2017,7,05,16,50);
		e = new Estado(TEstado.EN_FINANCIACION, fecha.getTime());
		cp.cambiarEstado("Pilsen Rock", e);
		
		fecha.set(2017,10,05);
		cp.altaPropuesta("juliob", "Romeo y Julieta", new DtCategoria("Ballet"), "Romeo y Julieta de Kenneth MacMillan, uno de los ballets favoritos del director art�stico "
		+ "Julio Bocca, se presentar� nuevamente el 5 de Noviembre en el Auditorio Nacional del Sodre. Basada en la obra hom�nima de William Shakespeare, "
		+ "Romeo y Julieta es considerada la coreograf�a maestra del MacMillan. La producci�n de vestuario y escenograf�a se realiz� en los Talleres del "
		+ "Auditorio Adela Reta, sobre los dise�os originales.", 
		"Auditorio Nacional del Sodre", fecha.getTime(), new Date(), 750000, TRetorno.PORCENTAJE_GANANCIA, 800, "ryj");
		cp.borrarPrimerEstado("Romeo y Julieta");
		fecha.set(2017,7,04,12,20);
		e = new Estado(TEstado.INGRESADA, fecha.getTime());
		cp.cambiarEstado("Romeo y Julieta", e);
		fecha.set(2017,7,10,10,25);
		e = new Estado(TEstado.PUBLICADA, fecha.getTime());
		cp.cambiarEstado("Romeo y Julieta", e);
		fecha.set(2017,7,13,04,58);
		e = new Estado(TEstado.EN_FINANCIACION, fecha.getTime());
		cp.cambiarEstado("Romeo y Julieta", e);
		
		fecha.set(2017,10,16);
		cp.altaPropuesta("tabarec", "Un d�a de Julio", new DtCategoria("Murga"), "La Catalina presenta el espect�culo \"Un D�a de Julio\" en Landia. Un hombre misterioso "
		+ "y solitario vive encerrado entre las cuatro paredes de su casa. Intenta, con sus teor�as extravagantes, cambiar el mundo exterior que le "
		+ "resulta inhabitable. Un d�a de Julio suceder� algo que cambiar� su vida y la de su entorno para siempre. ", 
		"Landia", fecha.getTime(), new Date(), 300000, TRetorno.PORCENTAJE_Y_ENTRADAS, 650, "udj");
		cp.borrarPrimerEstado("Un d�a de Julio");
		fecha.set(2017,7,06,02,00);
		e = new Estado(TEstado.INGRESADA, fecha.getTime());
		cp.cambiarEstado("Un d�a de Julio", e);
		fecha.set(2017,7,12,04,50);
		e = new Estado(TEstado.PUBLICADA, fecha.getTime());
		cp.cambiarEstado("Un d�a de Julio", e);
		fecha.set(2017,7,15,04,48);
		e = new Estado(TEstado.EN_FINANCIACION, fecha.getTime());
		cp.cambiarEstado("Un d�a de Julio", e);
		
		fecha.set(2017,11,03);
		cp.altaPropuesta("hectorg", "El Lazarillo de Tormes", new DtCategoria("Teatro Dram�tico"), "Vuelve unas de las producciones de El Galp�n m�s aclamadas de los �ltimos tiempos. "
		+ "Esta obra se ha presentado en Miami, Nueva York, Washington, M�xico, Guadalajara, R�o de Janeiro y La Habana. En nuestro pa�s, El "
		+ "Lazarillo de Tormes fue nominado en los rubros mejor espect�culo y mejor direcci�n a los Premios Florencio 1995, obteniendo su "
		+ "protagonista H�ctor Guido el Florencio a Mejor actor de ese a�o. ", 
		"Teatro el Galp�n", fecha.getTime(), new Date(), 175000, TRetorno.ENTRADA_GRATIS, 350, "");
		cp.borrarPrimerEstado("El Lazarillo de Tormes");
		fecha.set(2017,7,18,02,40);
		e = new Estado(TEstado.INGRESADA, fecha.getTime());
		cp.cambiarEstado("El Lazarillo de Tormes", e);
		fecha.set(2017,7,20,21,58);
		e = new Estado(TEstado.PUBLICADA, fecha.getTime());
		cp.cambiarEstado("El Lazarillo de Tormes", e);
		
		fecha.set(2017,11,10);
		cp.altaPropuesta("losBardo", "Bardo en la FING", new DtCategoria("Stand-up"), "El 10 de Diciembre se presentar� Bardo Cient�fico en la FING. El humor puede ser usado "
		+ "como una herramienta importante para el aprendizaje y la democratizaci�n de la ciencia, los mon�logos cient�ficos son una forma did�ctica de "
		+ "apropiaci�n del conocimiento cient�fico y contribuyen a que el p�blico aprenda ciencia de forma amena. Los invitamos a "
		+ "pasar un rato divertido, en un espacio en el cual aprender�n cosas de la ciencia que los sorprender�n. �Los esperamos! ", 
		"Anfiteatro Edificio \"Jos� Luis Massera\"", fecha.getTime(), new Date(), 100000, TRetorno.ENTRADA_GRATIS, 200, "");
		cp.borrarPrimerEstado("Bardo en la FING");
		fecha.set(2017,7,23,2,12);
		e = new Estado(TEstado.INGRESADA, fecha.getTime());
		cp.cambiarEstado("Bardo en la FING", e);
		
		int i = cp.getIdActualColab();
		cp.infoPropuesta("Cine en el Bot�nico");
		cp.agregarColaboracion("novick", 50000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,04,20,14,30);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("robinh", 50000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,04,24,17,25);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("nicoJ", 50000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,04,30,18,30);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.infoPropuesta("Religiosamente");
		cp.agregarColaboracion("marcelot", 200000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,05,30,14,25);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("Tiajaci", 500, TRetorno.ENTRADA_GRATIS);
		fecha.set(2017,06,01,18,05);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("Mengano", 600, TRetorno.ENTRADA_GRATIS);
		fecha.set(2017,06,07,17,45);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("novick", 50000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,06,10,14,35);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("sergiop", 50000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,06,Cine en el Bot�nico15,9,45);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.infoPropuesta("El Pimiento Indomable");
		cp.agregarColaboracion("marcelot", 200000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,7,01,07,40);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("sergiop", 80000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,7,03,9,25);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.infoPropuesta("Pilsen Rock");
		cp.agregarColaboracion("chino", 50000, TRetorno.ENTRADA_GRATIS);
		fecha.set(2017,7,05,16,50);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("novick", 120000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,7,10,15,50);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("tonyp", 120000, TRetorno.ENTRADA_GRATIS);
		fecha.set(2017,7,15,19,30);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.infoPropuesta("Romeo y Julieta");
		cp.agregarColaboracion("sergiop", 100000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,7,13,04,58);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("marcelot", 200000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,7,14,11,25);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.infoPropuesta("Un d�a de Julio");
		cp.agregarColaboracion("tonyp", 30000, TRetorno.ENTRADA_GRATIS);
		fecha.set(2017,7,15,04,48);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		cp.agregarColaboracion("marcelot", 150000, TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017,7,17,15,30);
		cp.cambiarFechaColaboracion(i++, fecha.getTime());
		
		cp.agregarComentario("novick","Cine en el Bot�nico","Muy buena propuesta.");
		cp.agregarComentario("robinh","Cine en el Bot�nico","Realmente una pena que la propuesta haya sido cancelada.");
		cp.agregarComentario("nicoJ","Cine en el Bot�nico","No se lo pueden perder!");
		cp.agregarComentario("marcelot","Religiosamente","Todos al teatro de verano este 7 de Octubre!");
		cp.agregarComentario("Mengano","Religiosamente","Arriba Momosapiens!!!");
		cp.agregarComentario("sergiop","Religiosamente","Los conmino a todos a ir!");
		cp.agregarComentario("novick","Religiosamente","Excelente propuesta. Ahí estaremos.");
	 
		
		cu.agregarFavorita("hrubino","Religiosamente");
		cu.agregarFavorita("hrubino","El Pimiento Indomable");
		cu.agregarFavorita("hrubino","Un día de Julio");
		cu.agregarFavorita("mbusca","Cine en el Botánico");
		cu.agregarFavorita("mbusca","El Pimiento Indomable");
		cu.agregarFavorita("mbusca","Pilsen Rock");
		cu.agregarFavorita("hectorg","Romeo y Julieta");
		cu.agregarFavorita("hectorg","El Lazarillo de Tormes");
		cu.agregarFavorita("tabarec","Religiosamente");
		cu.agregarFavorita("tabarec","Un día de Julio");
		cu.agregarFavorita("cachilas","Religiosamente");
		cu.agregarFavorita("juliob","Romeo y Julieta");
		cu.agregarFavorita("juliob","El Lazarillo de Tormes");
		cu.agregarFavorita("diegop","Cine en el Botánico");
		cu.agregarFavorita("diegop","El Lazarillo de Tormes");
		cu.agregarFavorita("kairoh","Religiosamente");
		cu.agregarFavorita("kairoh","Pilsen Rock");
		cu.agregarFavorita("losBardo","Bardo en la FING");
		cu.agregarFavorita("robinh","Cine en el Botánico");
		cu.agregarFavorita("marcelot","Religiosamente");
		cu.agregarFavorita("marcelot","El Pimiento Indomable");
		cu.agregarFavorita("novick","Religiosamente");
		cu.agregarFavorita("novick","Pilsen Rock");
		cu.agregarFavorita("sergiop","El Pimiento Indomable");
		cu.agregarFavorita("sergiop","Romeo y Julieta");
		cu.agregarFavorita("chino","Pilsen Rock");
		cu.agregarFavorita("tonyp","Pilsen Rock");
		cu.agregarFavorita("tonyp","Un día de Julio");
		cu.agregarFavorita("nicoJ","Cine en el Botánico");
		cu.agregarFavorita("juanP","Pilsen Rock");
		cu.agregarFavorita("Mengano","Religiosamente");
		cu.agregarFavorita("Mengano","Un día de Julio");
		cu.agregarFavorita("Perengano","Pilsen Rock");
		cu.agregarFavorita("Perengano","Un día de Julio");
		cu.agregarFavorita("Tiajaci","Religiosamente");
		cu.agregarFavorita("Tiajaci","El Lazarillo de Tormes");

		System.out.println("Datos cargados. \n"
						+ "Cantidad de Proponentes: " + cu.listarProponentes().size() +"\n"
						+ "Cantidad de Colaboradores: " + cu.listarColaboradores().size() + "\n"
						+ "Cantidad de Propuestas: " + cp.listarPropuestas().size() + "\n"
						+ "Cantidad de Colaboraciones: " + cp.listarColaboraciones().size() + "\n"
						+ "Cantidad de Categor�as: " + cp.listarCategorias().getLeafCount() + "\n");
	}
}
