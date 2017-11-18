package presentacion2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataTypes.TEstado;
import logica.Datos;
import logica.Fabrica;
import logica.ICtrlPropuesta;
import logica.ICtrlUsuario;
import servidor.Publicador; 

public class Principal2 extends JFrame {

	private JPanel contentPane;
	private JDesktopPane escritorio;
	
	private ICtrlUsuario ICU;
	private ICtrlPropuesta ICP;
	
	private RegistrarPropuesta2 altapropuesta2;
	private RegistrarColaborador2 altacolaborador2;
	private RegistrarProponente2 altaproponente2;
	private CancelarColaboracion2 cancelarcolaboracion2;
	private ConsultaColaboracion2 consultacolaboracion2;
	private RegistrarColaboracion2 registrarcolaboracion2;
	private ConsultaProponente2 consultaproponente2;
	private ConsultaColaborador2 consultacolaborador2;
	private ConsultaPropuesta2 consultapropuesta2;
	private SeguirUsuario2 seguirusuario2;
	private DejarSeguirUsuario2 dejarseguirusuario2;
	private AltaCategoria altacategoria;
	private ModificarPropuesta modificarpropuesta;
	private ConsultaSeguidor consultaseguidor;
	private ConsultaPropuestaPorEstado consultapropuestaporestado;
	private EvaluarPropuesta evaluarpropuesta;
	private ControlAcceso controlacceso;
	private Clock2 clock;

	private Datos d = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			        Publicador p = new Publicador();
			        p.publicar();
					Principal2 frame = new Principal2();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal2() {
		
		setResizable(false);
		setTitle("Culturarte Server");
		setMinimumSize(new Dimension(990, 768));
		ImageIcon icono = new ImageIcon("src/recursos/icon.png");
		this.setIconImage(icono.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mntmBaja = new JMenuItem("Baja Proponente");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Prueba baja proponente");
				logica.Fabrica.getInstance().getICtrlUsuario().bajaProponente("hrubino");
			}
		});
		mnSistema.add(mntmBaja);
		
		JMenuItem mntmCargarDatosDe = new JMenuItem("Cargar datos de prueba");
		mntmCargarDatosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datosDePrueba();
			}
		});
		mnSistema.add(mntmCargarDatosDe);
		
		JMenuItem mntmClock = new JMenuItem("Reloj");
		mntmClock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clock.setVisible(true);
			}
		});
		mnSistema.add(mntmClock);
		
		JMenuItem mntmRegistroDeAcceso = new JMenuItem("Registro de acceso");
		mntmRegistroDeAcceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlacceso.cargarTabla();
				controlacceso.setVisible(true);
			}
		});
		mnSistema.add(mntmRegistroDeAcceso);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnSistema.add(mntmSalir);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenu mnNewMenu = new JMenu("Colaborador");
		mnUsuario.add(mnNewMenu);
		
		JMenuItem mntmAltaColaborador = new JMenuItem("Registrar Colaborador");
		mntmAltaColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altacolaborador2.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAltaColaborador);
		
		JMenuItem mntmConsultarColaborador = new JMenuItem("Consulta Colaborador");
		mntmConsultarColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ICU.listarColaboradores().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Actualmente no hay colaboradores registrados en el sistema", "Culturarte", JOptionPane.WARNING_MESSAGE);
				} else {
					consultacolaborador2.cargarColaboradores();
					consultacolaborador2.setVisible(true);	
				}
				
			}
		});
		mnNewMenu.add(mntmConsultarColaborador);
		
		JMenu mnNewMenu_1 = new JMenu("Proponente");
		mnUsuario.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Proponente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaproponente2.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmConsultaProponente = new JMenuItem("Consulta Proponente");
		mntmConsultaProponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ICU.listarProponentes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Actualmente no hay proponentes registrados en el sistema", "Culturarte", JOptionPane.WARNING_MESSAGE);
				} else {
				consultaproponente2.cargarProponentes();
				consultaproponente2.setVisible(true);
				}
			}
		});
		mnNewMenu_1.add(mntmConsultaProponente);
		
		JMenu mnSeguimiento = new JMenu("Seguimiento");
		mnUsuario.add(mnSeguimiento);
		
		JMenuItem mntmSeguirUsuario = new JMenuItem("Seguir Usuario");
		mnSeguimiento.add(mntmSeguirUsuario);
		
		JMenuItem mntmConsultaSeguidor = new JMenuItem("Consulta seguidor");
		mntmConsultaSeguidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ICU.listarUsuarios().isEmpty()){
					
					consultaseguidor = new ConsultaSeguidor(ICU);
					consultaseguidor.cargar();
				
					escritorio.add(consultaseguidor);
					consultaseguidor.setVisible(true);
					
				}
			}
		});
		mnSeguimiento.add(mntmConsultaSeguidor);
		
		JMenuItem mntmDejarSeguirUsuario = new JMenuItem("Dejar Seguir Usuario");
		mnSeguimiento.add(mntmDejarSeguirUsuario);
		mntmDejarSeguirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ICU.listarUsuarios().isEmpty()){
					dejarseguirusuario2 = new DejarSeguirUsuario2(ICU);
					escritorio.add(dejarseguirusuario2);
					dejarseguirusuario2.cargar();
					dejarseguirusuario2.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Actualmente no hay usuarios registrados en el sistema", "Culturarte", JOptionPane.WARNING_MESSAGE);
			}
		});
		mntmSeguirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ICU.listarUsuarios().isEmpty()){
					seguirusuario2 = new SeguirUsuario2(ICU);
					escritorio.add(seguirusuario2);
					
					seguirusuario2.cargar();
					
					seguirusuario2.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Actualmente no hay usuarios registrados en el sistema", "Culturarte", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		JMenu mnPropuesta = new JMenu("Propuesta");
		menuBar.add(mnPropuesta);
			
		JMenuItem mntmAltaPropuesta = new JMenuItem("Registrar Propuesta");
		mntmAltaPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] datosCmb = new	String[ICU.listarProponentes().size()];
				if(ICU.listarProponentes().size() != 0){
					for(int i = 0 ; i < ICU.listarProponentes().size() ; i++)
						datosCmb[i] = ICU.listarProponentes().get(i).getNickName();
					altapropuesta2.setComboProponentes(datosCmb);
					altapropuesta2.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Actualmente no hay proponentes registrados en el sistema", "Culturarte",
					JOptionPane.WARNING_MESSAGE);
			}
		});
		mnPropuesta.add(mntmAltaPropuesta);
		
		JMenuItem mntmConsultaPropuesta = new JMenuItem("Consulta Propuesta");
		mntmConsultaPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ICP.listarPropuestas().size() > 0) {
					consultapropuesta2.cargarPropuestas();
					consultapropuesta2.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Actualmente no hay propuestas registradas en el sistema", "Culturarte",
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		JMenuItem mntmConsultaPropuestaPorEstado = new JMenuItem("Consulta Propuesta por estado");
		mntmConsultaPropuestaPorEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ICP.listarPropuestas().size() > 0) {
					consultapropuestaporestado.cargarDatos();
					consultapropuestaporestado.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Actualmente no hay propuestas registradas en el sistema", "Culturarte",
							JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar Propuesta");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ICP.listarPropuestas().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No se puede modificar una propuesta porque no existe ninguna propuesta"
							+ " registrada en el sistema","Culturarte", JOptionPane.WARNING_MESSAGE);
					
				} else {
					modificarpropuesta.cargarPropuestas();
					modificarpropuesta.setVisible(true);	
				}
			}
		});
		
		JMenuItem mntmEvaluarPropuesta = new JMenuItem("Evaluar Propuesta");
		mntmEvaluarPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ICP.listarPropuestaPorEstado(TEstado.INGRESADA).isEmpty()) {
					JOptionPane.showMessageDialog(null, "No existen propuestas en estado Ingresada","Culturarte", JOptionPane.WARNING_MESSAGE);
				} else {
					evaluarpropuesta.cargarPropuestas();
					evaluarpropuesta.setVisible(true);	
				}
			}
		});
		
		mnPropuesta.add(mntmNewMenuItem_1);
		mnPropuesta.add(mntmConsultaPropuesta);
		mnPropuesta.add(mntmConsultaPropuestaPorEstado);
		mnPropuesta.add(mntmEvaluarPropuesta);
		
		
		JMenu mnColaboraciones = new JMenu("Colaboraciones");
		menuBar.add(mnColaboraciones);
		
		JMenuItem mntmRegistrarColaboracion = new JMenuItem("Registrar Colaboracion");
		mntmRegistrarColaboracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ICU.listarColaboradores().isEmpty())
					JOptionPane.showMessageDialog(null, "No se puede registrar una colaboraci�n porque no existen colaboradores en el sistema."
							, "Culturarte", JOptionPane.WARNING_MESSAGE);
				else if(ICP.listarPropuestas().isEmpty())
					JOptionPane.showMessageDialog(null, "No se puede registrar una colaboraci�n porque no existen propuestas en el sistema."
							, "Culturarte", JOptionPane.WARNING_MESSAGE);
				else {
					registrarcolaboracion2 = new RegistrarColaboracion2(ICP);
					escritorio.add(registrarcolaboracion2);
					registrarcolaboracion2.cargarDatos();
					registrarcolaboracion2.setVisible(true);	
				}
			}
		});
		mnColaboraciones.add(mntmRegistrarColaboracion);
		
		JMenuItem mntmConsultarColaboracion = new JMenuItem("Consulta Colaboracion");
		mntmConsultarColaboracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ICP.listarColaboraciones().isEmpty()) {
					JOptionPane.showMessageDialog(null,"No existen colaboraciones registradas en el sistema","Culturarte",
							JOptionPane.WARNING_MESSAGE);
				} else {
					consultacolaboracion2 = new ConsultaColaboracion2(ICP);
					escritorio.add(consultacolaboracion2);
					consultacolaboracion2.cargarDatos();
					consultacolaboracion2.setVisible(true);
				}
				
				
			}
		});
		mnColaboraciones.add(mntmConsultarColaboracion);
		
		JMenuItem mntmCancelarColaboracion = new JMenuItem("Cancelar Colaboracion");
		mntmCancelarColaboracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ICP.listarColaboraciones().isEmpty()) {
					JOptionPane.showMessageDialog(null,"No existen colaboraciones registradas en el sistema","Culturarte",
							JOptionPane.WARNING_MESSAGE);
				} else {
					cancelarcolaboracion2 = new CancelarColaboracion2(ICP);
					escritorio.add(cancelarcolaboracion2);
					cancelarcolaboracion2.cargarColaboraciones();
					cancelarcolaboracion2.setVisible(true);
				}
			}
		});
		mnColaboraciones.add(mntmCancelarColaboracion);
		
		JMenu mnCategoria = new JMenu("Categor\u00EDa");
		menuBar.add(mnCategoria);
		
		JMenuItem mntmCrearCategoria = new JMenuItem("Crear categor\u00EDa");
		mntmCrearCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altacategoria.cargarArbol();
				altacategoria.setVisible(true);
			}
		});
		mnCategoria.add(mntmCrearCategoria);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
	    ImageIcon icon = new ImageIcon("src/recursos/banner2.png");
	    Image image = icon.getImage();

	    Image newimage = image.getScaledInstance(999, 715, Image.SCALE_SMOOTH);
	    
	    
		escritorio = new JDesktopPane() {
		  @Override
			    protected void paintComponent(Graphics g)
			    {
			        super.paintComponent(g);
			        g.drawImage(newimage, 0, 0, this);
			    }
			  
		};
		
	
		contentPane.add(escritorio, BorderLayout.CENTER);
		initialize();
	}
	
	 
	
	
	private void initialize() {
		Fabrica fabrica = Fabrica.getInstance();
		this.ICU = fabrica.getICtrlUsuario();
		this.ICP = fabrica.getICtrlPropuesta();
		
		//Inicializo internal frames
		altapropuesta2 = new RegistrarPropuesta2(ICU, ICP);
		escritorio.add(altapropuesta2);
		
		altacolaborador2 = new RegistrarColaborador2(ICU);
		altacolaborador2.setTitle("Registrar colaborador");
		escritorio.add(altacolaborador2);
		
		altaproponente2 = new RegistrarProponente2(ICU);
		altaproponente2.setTitle("Registrar proponente");
		escritorio.add(altaproponente2);
		
		
		
		cancelarcolaboracion2 = new CancelarColaboracion2(ICP);
		escritorio.add(cancelarcolaboracion2);
		
		consultacolaboracion2 = new ConsultaColaboracion2(ICP);
		escritorio.add(consultacolaboracion2);
		
		registrarcolaboracion2 = new RegistrarColaboracion2(ICP);
		escritorio.add(registrarcolaboracion2);
		
		consultaproponente2 = new ConsultaProponente2(ICU);
		escritorio.add(consultaproponente2);
		
		consultacolaborador2 = new ConsultaColaborador2(ICU);
		escritorio.add(consultacolaborador2);
		
		consultapropuesta2 = new ConsultaPropuesta2(ICP);
		escritorio.add(consultapropuesta2);
		
		consultapropuestaporestado = new ConsultaPropuestaPorEstado(ICP);
		escritorio.add(consultapropuestaporestado);
		
		evaluarpropuesta = new EvaluarPropuesta(ICP);
		escritorio.add(evaluarpropuesta);
		
		
		altacategoria = new AltaCategoria(ICP);
		escritorio.add(altacategoria);

		modificarpropuesta = new ModificarPropuesta(ICP,ICU);
		escritorio.add(modificarpropuesta);
		
		controlacceso = new ControlAcceso(ICU);
		escritorio.add(controlacceso);
		
		clock = new Clock2();
		escritorio.add(clock);
	}
	
	public void datosDePrueba() {
		if(d == null) {
			d = new Datos();
			JOptionPane.showMessageDialog(this, "Los datos de prueba se cargaron correctamente.", "Cargar datos de prueba", JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(this, "Los datos de prueba ya estan cargados.", "Cargar datos de prueba", JOptionPane.INFORMATION_MESSAGE);
	}
}
