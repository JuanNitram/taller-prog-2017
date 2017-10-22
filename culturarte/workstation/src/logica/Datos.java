package logica;

import java.util.Calendar; 

import javax.swing.tree.TreePath;

import logica.clases.Estado;
import logica.controladores.CtrlPropuesta;
import logica.controladores.CtrlUsuario;
import dataTypes.DtCategoria;
import dataTypes.TEstado;
import dataTypes.TRetorno;

public class Datos {

	public Datos() {
		
		CtrlUsuario cUsuario = CtrlUsuario.getInstance();
		CtrlPropuesta cPropuesta = CtrlPropuesta.getInstance();
		
		Calendar fecha = Calendar.getInstance();
		
		//HR
		fecha.set(1962,  01,  25);
		cUsuario.altaProponente("hrubino", "K6keGZEx",  "Horacio",  "Rubino",  "18 de Julio 1234",  "horacio.rubino@guambia.com.uy",  
		"Horacio Rubino Torres nace el 25 de febrero de 1962,  es conductor,  actor y libretista. Debuta en 1982 en carnaval "
		+ "en Los \"Klaper�s\",  donde estuvo cuatro a�os,  actuando y libretando. Luego para \"Gaby�s\" (6 a�os),  escribi� en "
		+ "categor�a revistas y humoristas y desde el comienzo y hasta el presente en su propio conjunto Momosapiens.",  
		"https://twitter.com/horaciorubino",  "hr",  fecha.getTime());
		//MB
		fecha.set(1972, 05, 14);
		cUsuario.altaProponente("mbusca", "aL4aNcYF",  "Mart�n",  "Buscaglia",  "Colonia 4321",  "Martin.bus@agadu.org.uy",  
		"Mart�n Buscaglia (Montevideo,  1972) es un artista,  m�sico,  compositor y productor uruguayo. Tanto con su banda"
		+ "	(�Los Bochamakers�) como en su formato �Hombre orquesta�,  o solo con su guitarra,  ha recorrido el mundo"
		+ "	tocando entre otros pa�ses en Espa�a,  Estados Unidos,  Inglaterra,  Francia,  Australia,  Brasil,  Colombia,  Argentina,  "
		+ "Chile,  Paraguay,  M�xico y Uruguay. (Actualmente los Bochamakers son Mat�as Rada,  Mart�n Ibarburu,  Mateo "
		+ "Moreno,  Herman Klang) Paralelamente,  tiene proyectos a d�o con el espa�ol Kiko Veneno,  la cubana Yusa,  el "
		+ "argentino Lisandro Aristimu�o,  su compatriota Antol�n,  y a tr�o junto a los brasileros Os Mulheres Negras.",  
		"http://www.martinbuscaglia.com/",  "mb",  fecha.getTime());
		//HG
		fecha.set(1954, 00, 07);
		cUsuario.altaProponente("hectorg", "dcUCulNa",  "H�ctor",  "Guido",  "Gral. Flores 5645",  "hector.gui@elgalpon.org.uy",  
		"En 1972 ingres� a la Escuela de Arte Dram�tico del teatro El Galp�n. Particip� en m�s de treinta obras teatrales y "
		+ "varios largometrajes. Integr� el elenco estable de Radioteatro del Sodre,  y en 2006 fue asesor de su Consejo	"
		+ "Directivo. Como actor recibi� m�ltiples reconocimientos: cuatro premios Florencio,  premio al mejor actor	"
		+ "extranjero del Festival de Miami y premio Mejor Actor de Cine 2008. Durante varios per�odos fue directivo del "
		+ "teatro El Galp�n y dirigente de la Sociedad Uruguaya de Actores (SUA); integr� tambi�n la Federaci�n Uruguaya "
		+ "de Teatros Independientes (FUTI). Form� parte del equipo de gesti�n de la refacci�n de los teatros La M�scara,  "
		+ "Astral y El Galp�n,  y del equipo de gesti�n en la construcci�n del teatro De la Candela y de la sala Atahualpa de El "
		+ "Galp�n.",  "",  "hg",  fecha.getTime());
		//TC
		fecha.set(1971, 06, 24);
		cUsuario.altaProponente("tabarec", "od5CX5gS",  "Tabar�",  "Cardozo",  "Santiago Rivas 1212",  "tabare.car@agadu.org.uy",  
		"Tabar� Cardozo (Montevideo,  24 de julio de 1971) es un cantante,  compositor y murguista uruguayo; conocido por	"
		+ "su participaci�n en la murga Agarrate Catalina,  conjunto que fund� junto a su hermano Yamand� y Carlos "
		+ "Tanco en el a�o 2001.",  
		"https://www.facebook.com/Tabar%C3%A9-Cardozo-55179094281/?ref=br_rs",  "tc",  fecha.getTime());
		//CS
		fecha.set(1947, 00, 01);
		cUsuario.altaProponente("cachilas", "JGgqYPTS",  "Waldemar �Cachila�",  "Silva",  "Br. Artigas 4567",  "Cachila.sil@c1080.org.uy",  
		"Nace en el a�o 1947 en el conventillo \"Medio Mundo\" ubicado en pleno Barrio Sur. Es heredero parcialmentejunto	"
		+ "al resto de sus hermanos- de la Comparsa \"Morenada\" (inactiva desde el fallecimiento de Juan �ngel Silva),  "
		+ "en 1999 forma su propia Comparsa de negros y lubolos \"Cuareim 1080\". Director responsable,  compositor y cantante de la misma.",  
		"https://www.facebook.com/C1080?ref=br_rs",  "cs",  fecha.getTime());
		//JB
		fecha.set(1967, 02, 16);
		cUsuario.altaProponente("juliob", "9FpNxvih",  "Julio",  "Bocca",  "Benito Blanco 4321",  "juliobocca@sodre.com.uy",  "",  "",  "",  fecha.getTime());
		//DP
		fecha.set(1975, 00, 01);
		cUsuario.altaProponente("diegop", "s7L8BpKG",  "Diego",  "Parodi",  "Emilio Frugoni 1138",  "diego@efectocine.com",  "",  "http://www.efectocine.com",  "", 
		fecha.getTime());
		//KH
		fecha.set(1840, 03, 25);
		cUsuario.altaProponente("kairoh", "Xa0GPWZA",  "Kairo",  "Herrera",  "Paraguay 1423",  "kairoher@pilsenrock.com.uy",  "",  "",  
		"kh",  fecha.getTime());
		//LB
		fecha.set(1980, 10, 31);
		cUsuario.altaProponente("losBardo", "r8b16VnQ",  "Los",  "Bardo",  "8 de Octubre 1429",  "losbardo@bardocientifico.com",  
		"Queremos ser vistos y reconocidos como una organizaci�n: referente en divulgaci�n cient�fica con un fuerte	"
		+ "esp�ritu did�ctico y divertido,  a trav�s de acciones coordinadas con otros divulgadores cient�ficos,  que permitan "
		+ "establecer puentes de comunicaci�n. Impulsora en la generaci�n de espacios de democratizaci�n y apropiaci�n "
		+ "social del conocimiento cient�fico.",  "https://bardocientifico.com/",  "lb",  fecha.getTime());
				
		//RH
		fecha.set(1940, 8, 03);
		cUsuario.altaColaborador("robinh", "V1sPsIpl",  "Robin",  "Henderson",  "Robin.h@tinglesa.com.uy",  "",  fecha.getTime());
		//MT
		fecha.set(1960, 03, 01);
		cUsuario.altaColaborador("marcelot", "S0E8vCK2",  "Marcelo",  "Tinelli",  "marcelot@ideasdelsur.com.ar",  "mt",  fecha.getTime());
		//EN
		fecha.set(1952, 06, 17);
		cUsuario.altaColaborador("novick", "kZIwfxnV",  "Edgardo",  "Novick",  "edgardo@novick.com.uy",  "en",  fecha.getTime());
		//SP
		fecha.set(1950, 00, 28);
		cUsuario.altaColaborador("sergiop", "Fld4hEtI",  "Sergio",  "Puglia",  "puglia@alpanpan.com.uy",  "sp",  fecha.getTime());
		//AR
		fecha.set(1976, 02, 17);
		cUsuario.altaColaborador("chino", "1BAoBp1r",  "Alvaro",  "Recoba",  "chino@trico.org.uy",  "",  fecha.getTime());
		//AP
		fecha.set(1955, 01, 14);
		cUsuario.altaColaborador("tonyp", "9ovUu61d",  "Antonio",  "Pacheco",  "eltony@manya.org.uy",  "ap",  fecha.getTime());
		//NJ
		fecha.set(1960, 8, 9);
		cUsuario.altaColaborador("nicoJ", "c9ogZ9r4",  "Nicol�s",  "Jodal",  "jodal@artech.com.uy",  "nj",  fecha.getTime());
		//JP
		fecha.set(1970, 00, 01);
		cUsuario.altaColaborador("juanP", "aDJvvrJm",  "Juan",  "Perez",  "juanp@elpueblo.com",  "",  fecha.getTime());
		//MG
		fecha.set(1982, 01, 02);
		cUsuario.altaColaborador("Mengano", "bfEWtrqQ",  "Mengano",  "G�mez",  "menganog@elpueblo.com",  "",  fecha.getTime());
		//PL
		fecha.set(1985, 02, 03);
		cUsuario.altaColaborador("Perengano", "m5nbaRBV",  "Perengano",  "L�pez",  "pere@elpueblo.com",  "",  fecha.getTime());
		//TJ
		fecha.set(1990, 03, 04);
		cUsuario.altaColaborador("Tiajaci", "uIo1s1GR",  "T�a",  "Jacinta",  "jacinta@elpueblo.com",  "",  fecha.getTime());
		
		cUsuario.elegirSeguidor("hrubino");
		cUsuario.elegirSeguido("hectorg");
		cUsuario.seguir();
		cUsuario.elegirSeguido("diegop");
		cUsuario.seguir();
		cUsuario.elegirSeguido("losBardo");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("mbusca");
		cUsuario.elegirSeguido("tabarec");
		cUsuario.seguir();
		cUsuario.elegirSeguido("cachilas");
		cUsuario.seguir();
		cUsuario.elegirSeguido("kairoh");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("hectorg");
		cUsuario.elegirSeguido("mbusca");
		cUsuario.seguir();
		cUsuario.elegirSeguido("juliob");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("tabarec");
		cUsuario.elegirSeguido("hrubino");
		cUsuario.seguir();
		cUsuario.elegirSeguido("cachilas");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("cachilas");
		cUsuario.elegirSeguido("hrubino");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("juliob");
		cUsuario.elegirSeguido("mbusca");
		cUsuario.seguir();
		cUsuario.elegirSeguido("diegop");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("diegop");
		cUsuario.elegirSeguido("hectorg");
		cUsuario.seguir();
		cUsuario.elegirSeguido("losBardo");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("kairoh");
		cUsuario.elegirSeguido("sergiop");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("losBardo");
		cUsuario.elegirSeguido("hrubino");
		cUsuario.seguir();
		cUsuario.elegirSeguido("nicoJ");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("robinh");
		cUsuario.elegirSeguido("hectorg");
		cUsuario.seguir();
		cUsuario.elegirSeguido("juliob");
		cUsuario.seguir();
		cUsuario.elegirSeguido("diegop");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("marcelot");
		cUsuario.elegirSeguido("cachilas");
		cUsuario.seguir();
		cUsuario.elegirSeguido("juliob");
		cUsuario.seguir();
		cUsuario.elegirSeguido("kairoh");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("novick");
		cUsuario.elegirSeguido("hrubino");
		cUsuario.seguir();
		cUsuario.elegirSeguido("tabarec");
		cUsuario.seguir();
		cUsuario.elegirSeguido("cachilas");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("sergiop");
		cUsuario.elegirSeguido("mbusca");
		cUsuario.seguir();
		cUsuario.elegirSeguido("juliob");
		cUsuario.seguir();
		cUsuario.elegirSeguido("diegop");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("chino");
		cUsuario.elegirSeguido("tonyp");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("tonyp");
		cUsuario.elegirSeguido("chino");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("nicoJ");
		cUsuario.elegirSeguido("diegop");
		cUsuario.seguir();
		cUsuario.elegirSeguido("losBardo");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("juanP");
		cUsuario.elegirSeguido("tabarec");
		cUsuario.seguir();
		cUsuario.elegirSeguido("cachilas");
		cUsuario.seguir();
		cUsuario.elegirSeguido("kairoh");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("Mengano");
		cUsuario.elegirSeguido("hectorg");
		cUsuario.seguir();
		cUsuario.elegirSeguido("juliob");
		cUsuario.seguir();
		cUsuario.elegirSeguido("chino");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("Perengano");
		cUsuario.elegirSeguido("diegop");
		cUsuario.seguir();
		cUsuario.elegirSeguido("tonyp");
		cUsuario.seguir();

		cUsuario.elegirSeguidor("Tiajaci");
		cUsuario.elegirSeguido("juliob");
		cUsuario.seguir();
		cUsuario.elegirSeguido("kairoh");
		cUsuario.seguir();
		cUsuario.elegirSeguido("sergiop");
		
		
		String[] ruta = new String[]{"Categor�a"};
		cPropuesta.crearCategoria(new TreePath(ruta),  "Teatro");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Literatura");
		cPropuesta.crearCategoria(new TreePath(ruta),  "M�sica");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Cine");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Danza");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Carnaval");
		ruta = new String[]{"Categor�a", "Teatro"};
		cPropuesta.crearCategoria(new TreePath(ruta),  "Teatro Dram�tico");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Teatro Musical");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Comedia");
		ruta = new String[]{"Categor�a", "Teatro", "Comedia"};
		cPropuesta.crearCategoria(new TreePath(ruta),  "Stand-up");
		ruta = new String[]{"Categor�a", "M�sica"};
		cPropuesta.crearCategoria(new TreePath(ruta),  "Festival");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Concierto");
		ruta = new String[]{"Categor�a", "Cine"};
		cPropuesta.crearCategoria(new TreePath(ruta),  "Cine al Aire Libre");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Cine a Pedal");
		ruta = new String[]{"Categor�a", "Danza"};
		cPropuesta.crearCategoria(new TreePath(ruta),  "Ballet");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Flamenco");
		ruta = new String[]{"Categor�a", "Carnaval"};
		cPropuesta.crearCategoria(new TreePath(ruta),  "Murga");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Humoristas");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Parodistas");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Lubolos");
		cPropuesta.crearCategoria(new TreePath(ruta),  "Revista");

		
		Estado est;
		fecha.set(2017, 8, 16);
		cPropuesta.altaPropuesta("diegop",  "Cine en el Bot�nico",  new DtCategoria("Cine al Aire Libre"),  "El 16 de Diciembre a la hora 20 se proyectar� la pel�cula \"Clever\", "
		+ " en el Jard�n Bot�nico (Av. 19 de Abril 1181) en el marco de las actividades realizadas por el ciclo Cultura al Aire Libre."
		+ " El largometraje uruguayo de ficci�n Clever es dirigido por Federico Borgia y Guillermo Madeiro. Es apto para mayores de 15 a�os.",  
		"Jard�n Bot�nico",  fecha.getTime(),  150000,  TRetorno.PORCENTAJE_GANANCIA,  200,  "");
		cPropuesta.borrarPrimerEstado("Cine en el Bot�nico");
		fecha.set(2017, 04, 15, 15, 30);
		est = new Estado(TEstado.INGRESADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Cine en el Bot�nico",  est);
		fecha.set(2017, 04, 17, 8, 30);
		est = new Estado(TEstado.PUBLICADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Cine en el Bot�nico",  est);
		fecha.set(2017, 04, 20, 14, 30);
		est = new Estado(TEstado.EN_FINANCIACION,  fecha.getTime());
		cPropuesta.cambiarEstado("Cine en el Bot�nico",  est);
		fecha.set(2017, 04, 30, 18, 30);
		est = new Estado(TEstado.FINANCIADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Cine en el Bot�nico",  est);
		fecha.set(2017, 05, 15, 14, 50);
		est = new Estado(TEstado.CANCELADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Cine en el Bot�nico",  est);
		
		fecha.set(2017, 9, 07);
		cPropuesta.altaPropuesta("hrubino",  "Religiosamente",  new DtCategoria("Parodistas"),  "MOMOSAPIENS presenta \"Religiosamente\". Mediante dos parodias y un hilo conductor "
		+ "que aborda la tem�tica de la religi�n Momosapiens,  mediante el humor y la reflexi�n,  hilvana una historia que muestra al hombre "
		+ "inmerso en el tema religioso. El libreto est� escrito utilizando diferentes lenguajes de humor,  dando una visi�n sat�rica y reflexiva "
		+ "desde distintos puntos de vista,  logrando mediante situaciones par�dicas armar una propuesta plena de arte carnavalero.",  
		"Teatro de Verano",  fecha.getTime(),  300000,  TRetorno.PORCENTAJE_Y_ENTRADAS,  300,  "mom");
		cPropuesta.borrarPrimerEstado("Religiosamente");
		fecha.set(2017, 05, 18, 4, 28);
		est = new Estado(TEstado.INGRESADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Religiosamente",  est);
		fecha.set(2017, 05, 20, 4, 56);
		est = new Estado(TEstado.PUBLICADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Religiosamente",  est);
		fecha.set(2017, 05, 30, 14, 25);
		est = new Estado(TEstado.EN_FINANCIACION,  fecha.getTime());
		cPropuesta.cambiarEstado("Religiosamente",  est);
		fecha.set(2017, 06, 15, 9, 45);
		est = new Estado(TEstado.FINANCIADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Religiosamente",  est);
		
		fecha.set(2017, 9, 19);
		cPropuesta.altaPropuesta("mbusca",  "El Pimiento Indomable",  new DtCategoria("Concierto"),  "El Pimiento Indomable,  formaci�n compuesta por Kiko Veneno y el uruguayo "
		+ "Mart�n Buscaglia,  presentar� este 19 de Octubre,  su primer trabajo. Bajo un t�tulo hom�nimo al del grupo,  es un disco que seg�n "
		+ "los propios protagonistas �no se parece al de ninguno de los dos por separado. Entre los t�tulos que se podr�n escuchar se encuentran "
		+ "�Nadador salvador�,  �Am�rica es m�s grande�,  �Pescaito Enroscado� o �La reina del placer�. ",  
		"Teatro Sol�s",  fecha.getTime(),  400000,  TRetorno.PORCENTAJE_GANANCIA,  400,  "pim");
		cPropuesta.borrarPrimerEstado("El Pimiento Indomable");
		fecha.set(2017, 06, 26, 15, 30);
		est = new Estado(TEstado.INGRESADA,  fecha.getTime());
		cPropuesta.cambiarEstado("El Pimiento Indomable",  est);
		fecha.set(2017, 06, 31, 8, 30);
		est = new Estado(TEstado.PUBLICADA,  fecha.getTime());
		cPropuesta.cambiarEstado("El Pimiento Indomable",  est);
		fecha.set(2017, 7, 01, 07, 40);
		est = new Estado(TEstado.EN_FINANCIACION,  fecha.getTime());
		cPropuesta.cambiarEstado("El Pimiento Indomable",  est);
		
		fecha.set(2017, 9, 21);
		cPropuesta.altaPropuesta("kairoh",  "Pilsen Rock",  new DtCategoria("Festival"),  "La edici�n 2017 del Pilsen Rock se celebrar� el 21 de Octubre en la Rural del Prado y contar� "
		+ "con la participaci�n de m�s de 15 bandas nacionales. Quienes no puedan trasladarse al lugar,  tendr�n la posibilidad de disfrutar los shows "
		+ "a trav�s de Internet,  as� como entrevistas en vivo a los m�sicos una vez finalizados los conciertos. ",  
		"Rural de Prado",  fecha.getTime(),  900000,  TRetorno.PORCENTAJE_Y_ENTRADAS,  1000,  "pil");
		cPropuesta.borrarPrimerEstado("Pilsen Rock");
		fecha.set(2017, 06, 30, 15, 40);
		est = new Estado(TEstado.INGRESADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Pilsen Rock",  est);
		fecha.set(2017, 7, 01, 14, 30);
		est = new Estado(TEstado.PUBLICADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Pilsen Rock",  est);
		fecha.set(2017, 7, 05, 16, 50);
		est = new Estado(TEstado.EN_FINANCIACION,  fecha.getTime());
		cPropuesta.cambiarEstado("Pilsen Rock",  est);
		
		fecha.set(2017, 10, 05);
		cPropuesta.altaPropuesta("juliob",  "Romeo y Julieta",  new DtCategoria("Ballet"),  "Romeo y Julieta de Kenneth MacMillan,  uno de los ballets favoritos del director art�stico "
		+ "Julio Bocca,  se presentar� nuevamente el 5 de Noviembre en el Auditorio Nacional del Sodre. Basada en la obra hom�nima de William Shakespeare,  "
		+ "Romeo y Julieta es considerada la coreograf�a maestra del MacMillan. La producci�n de vestuario y escenograf�a se realiz� en los Talleres del "
		+ "Auditorio Adela Reta,  sobre los dise�os originales.",  
		"Auditorio Nacional del Sodre",  fecha.getTime(),  750000,  TRetorno.PORCENTAJE_GANANCIA,  800,  "ryj");
		cPropuesta.borrarPrimerEstado("Romeo y Julieta");
		fecha.set(2017, 7, 04, 12, 20);
		est = new Estado(TEstado.INGRESADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Romeo y Julieta",  est);
		fecha.set(2017, 7, 10, 10, 25);
		est = new Estado(TEstado.PUBLICADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Romeo y Julieta",  est);
		fecha.set(2017, 7, 13, 04, 58);
		est = new Estado(TEstado.EN_FINANCIACION,  fecha.getTime());
		cPropuesta.cambiarEstado("Romeo y Julieta",  est);
		
		fecha.set(2017, 10, 16);
		cPropuesta.altaPropuesta("tabarec",  "Un d�a de Julio",  new DtCategoria("Murga"),  "La Catalina presenta el espect�culo \"Un D�a de Julio\" en Landia. Un hombre misterioso "
		+ "y solitario vive encerrado entre las cuatro paredes de su casa. Intenta,  con sus teor�as extravagantes,  cambiar el mundo exterior que le "
		+ "resulta inhabitable. Un d�a de Julio suceder� algo que cambiar� su vida y la de su entorno para siempre. ",  
		"Landia",  fecha.getTime(),  300000,  TRetorno.PORCENTAJE_Y_ENTRADAS,  650,  "udj");
		cPropuesta.borrarPrimerEstado("Un d�a de Julio");
		fecha.set(2017, 7, 06, 02, 00);
		est = new Estado(TEstado.INGRESADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Un d�a de Julio",  est);
		fecha.set(2017, 7, 12, 04, 50);
		est = new Estado(TEstado.PUBLICADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Un d�a de Julio",  est);
		fecha.set(2017, 7, 15, 04, 48);
		est = new Estado(TEstado.EN_FINANCIACION,  fecha.getTime());
		cPropuesta.cambiarEstado("Un d�a de Julio",  est);
		
		fecha.set(2017, 11, 03);
		cPropuesta.altaPropuesta("hectorg",  "El Lazarillo de Tormes",  new DtCategoria("Teatro Dram�tico"),  "Vuelve unas de las producciones de El Galp�n m�s aclamadas de los �ltimos tiempos. "
		+ "Esta obra se ha presentado en Miami,  Nueva York,  Washington,  M�xico,  Guadalajara,  R�o de Janeiro y La Habana. En nuestro pa�s,  El "
		+ "Lazarillo de Tormes fue nominado en los rubros mejor espect�culo y mejor direcci�n a los Premios Florencio 1995,  obteniendo su "
		+ "protagonista H�ctor Guido el Florencio a Mejor actor de ese a�o. ",  
		"Teatro el Galp�n",  fecha.getTime(),  175000,  TRetorno.ENTRADA_GRATIS,  350,  "");
		cPropuesta.borrarPrimerEstado("El Lazarillo de Tormes");
		fecha.set(2017, 7, 18, 02, 40);
		est = new Estado(TEstado.INGRESADA,  fecha.getTime());
		cPropuesta.cambiarEstado("El Lazarillo de Tormes",  est);
		fecha.set(2017, 7, 20, 21, 58);
		est = new Estado(TEstado.PUBLICADA,  fecha.getTime());
		cPropuesta.cambiarEstado("El Lazarillo de Tormes",  est);
		
		fecha.set(2017, 11, 10);
		cPropuesta.altaPropuesta("losBardo",  "Bardo en la FING",  new DtCategoria("Stand-up"),  "El 10 de Diciembre se presentar� Bardo Cient�fico en la FING. El humor puede ser usado "
		+ "como una herramienta importante para el aprendizaje y la democratizaci�n de la ciencia,  los mon�logos cient�ficos son una forma did�ctica de "
		+ "apropiaci�n del conocimiento cient�fico y contribuyen a que el p�blico aprenda ciencia de forma amena. Los invitamos a "
		+ "pasar un rato divertido,  en un espacio en el cual aprender�n cosas de la ciencia que los sorprender�n. �Los esperamos! ",  
		"Anfiteatro Edificio \"Jos� Luis Massera\"",  fecha.getTime(),  100000,  TRetorno.ENTRADA_GRATIS,  200,  "");
		cPropuesta.borrarPrimerEstado("Bardo en la FING");
		fecha.set(2017, 7, 23, 2, 12);
		est = new Estado(TEstado.INGRESADA,  fecha.getTime());
		cPropuesta.cambiarEstado("Bardo en la FING",  est);
		
		int idActual = cPropuesta.getIdActualColab();
		cPropuesta.infoPropuesta("Cine en el Botánico");
		cPropuesta.agregarColaboracion("novick",  50000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 04, 20, 14, 30);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("robinh",  50000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 04, 24, 17, 25);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("nicoJ",  50000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 04, 30, 18, 30);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.infoPropuesta("Religiosamente");
		cPropuesta.agregarColaboracion("marcelot",  200000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 05, 30, 14, 25);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("Tiajaci",  500,  TRetorno.ENTRADA_GRATIS);
		fecha.set(2017, 06, 01, 18, 05);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("Mengano",  600,  TRetorno.ENTRADA_GRATIS);
		fecha.set(2017, 06, 07, 17, 45);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("novick",  50000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 06, 10, 14, 35);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("sergiop",  50000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 06, 15, 9, 45);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.infoPropuesta("El Pimiento Indomable");
		cPropuesta.agregarColaboracion("marcelot",  200000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 7, 01, 07, 40);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("sergiop",  80000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 7, 03, 9, 25);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.infoPropuesta("Pilsen Rock");
		cPropuesta.agregarColaboracion("chino",  50000,  TRetorno.ENTRADA_GRATIS);
		fecha.set(2017, 8, 25, 16, 50);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("novick",  120000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 8, 30, 15, 50);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("tonyp",  120000,  TRetorno.ENTRADA_GRATIS);
		fecha.set(2017, 9, 5, 19, 30);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.infoPropuesta("Romeo y Julieta");
		cPropuesta.agregarColaboracion("sergiop",  100000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 9, 8, 04, 58);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("marcelot",  200000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 9, 9, 11, 25);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.infoPropuesta("Un d�a de Julio");
		cPropuesta.agregarColaboracion("tonyp",  30000,  TRetorno.ENTRADA_GRATIS);
		fecha.set(2017, 9, 8, 04, 48);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		cPropuesta.agregarColaboracion("marcelot",  150000,  TRetorno.PORCENTAJE_GANANCIA);
		fecha.set(2017, 9, 9, 15, 30);
		cPropuesta.cambiarFechaColaboracion(idActual++,  fecha.getTime());
		
		cPropuesta.agregarComentario("novick", "Cine en el Botánico", "Muy buena propuesta.");
		cPropuesta.agregarComentario("robinh", "Cine en el Botánico", "Realmente una pena que la propuesta haya sido cancelada.");
		cPropuesta.agregarComentario("nicoJ", "Cine en el Botánico", "No se lo pueden perder!");
		cPropuesta.agregarComentario("marcelot", "Religiosamente", "Todos al teatro de verano este 7 de Octubre!");
		cPropuesta.agregarComentario("Mengano", "Religiosamente", "Arriba Momosapiens!!!");
		cPropuesta.agregarComentario("sergiop", "Religiosamente", "Los conmino a todos a ir!");
		cPropuesta.agregarComentario("novick", "Religiosamente", "Excelente propuesta. Ahí estaremos.");
	 
		
		cPropuesta.agregarFavorita("hrubino", "Religiosamente");
		cPropuesta.agregarFavorita("hrubino", "El Pimiento Indomable");
		cPropuesta.agregarFavorita("hrubino", "Un día de Julio");
		cPropuesta.agregarFavorita("mbusca", "Cine en el Botánico");
		cPropuesta.agregarFavorita("mbusca", "El Pimiento Indomable");
		cPropuesta.agregarFavorita("mbusca", "Pilsen Rock");
		cPropuesta.agregarFavorita("hectorg", "Romeo y Julieta");
		cPropuesta.agregarFavorita("hectorg", "El Lazarillo de Tormes");
		cPropuesta.agregarFavorita("tabarec", "Religiosamente");
		cPropuesta.agregarFavorita("tabarec", "Un día de Julio");
		cPropuesta.agregarFavorita("cachilas", "Religiosamente");
		cPropuesta.agregarFavorita("juliob", "Romeo y Julieta");
		cPropuesta.agregarFavorita("juliob", "El Lazarillo de Tormes");
		cPropuesta.agregarFavorita("diegop", "Cine en el Botánico");
		cPropuesta.agregarFavorita("diegop", "El Lazarillo de Tormes");
		cPropuesta.agregarFavorita("kairoh", "Religiosamente");
		cPropuesta.agregarFavorita("kairoh", "Pilsen Rock");
		cPropuesta.agregarFavorita("losBardo", "Bardo en la FING");
		cPropuesta.agregarFavorita("robinh", "Cine en el Botánico");
		cPropuesta.agregarFavorita("marcelot", "Religiosamente");
		cPropuesta.agregarFavorita("marcelot", "El Pimiento Indomable");
		cPropuesta.agregarFavorita("novick", "Religiosamente");
		cPropuesta.agregarFavorita("novick", "Pilsen Rock");
		cPropuesta.agregarFavorita("sergiop", "El Pimiento Indomable");
		cPropuesta.agregarFavorita("sergiop", "Romeo y Julieta");
		cPropuesta.agregarFavorita("chino", "Pilsen Rock");
		cPropuesta.agregarFavorita("tonyp", "Pilsen Rock");
		cPropuesta.agregarFavorita("tonyp", "Un día de Julio");
		cPropuesta.agregarFavorita("nicoJ", "Cine en el Botánico");
		cPropuesta.agregarFavorita("juanP", "Pilsen Rock");
		cPropuesta.agregarFavorita("Mengano", "Religiosamente");
		cPropuesta.agregarFavorita("Mengano", "Un día de Julio");
		cPropuesta.agregarFavorita("Perengano", "Pilsen Rock");
		cPropuesta.agregarFavorita("Perengano", "Un día de Julio");
		cPropuesta.agregarFavorita("Tiajaci", "Religiosamente");
		cPropuesta.agregarFavorita("Tiajaci", "El Lazarillo de Tormes");

		System.out.println("Datos cargados. \n"
						+ "Cantidad de Proponentes: " + cUsuario.listarProponentes().size() +"\n"
						+ "Cantidad de Colaboradores: " + cUsuario.listarColaboradores().size() + "\n"
						+ "Cantidad de Propuestas: " + cPropuesta.listarPropuestas().size() + "\n"
						+ "Cantidad de Colaboraciones: " + cPropuesta.listarColaboraciones().size() + "\n"
						+ "Cantidad de Categorías: " + cPropuesta.listarCategorias().getLeafCount() + "\n");
	}
}
