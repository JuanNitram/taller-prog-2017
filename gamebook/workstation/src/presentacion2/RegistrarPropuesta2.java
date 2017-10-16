package presentacion2;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import dataTypes.DtCategoria;
import Logica.ICtrlPropuesta;
import Logica.ICtrlUsuario;
import dataTypes.TRetorno;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RegistrarPropuesta2 extends JInternalFrame {
	private JTextField txtTitulo;
	private JTextField txtLugar;
	private JTextField txtMonto;
	private JTextField txtFechaPublicacion;
	private JTextField txtPrecio;
	private JTextArea txtDescripcion;
	private JComboBox cmbProponentes;
	private Date fechaPublicacion;
	private JDateChooser txtFechaRealizacion;
	private JTextField fieldCategoria;
	private SelectCategoria selectCategoria;

	private ICtrlPropuesta ICP;
	private ICtrlUsuario ICU;
	 
	private boolean customImg;
	private JLabel lblImageLabel;
	private File archivoDestino;
	private JPanel imgPanel;
	
	
	public RegistrarPropuesta2(ICtrlUsuario Iu, ICtrlPropuesta Ip) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {

			}
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarCampos();
			}
		});
		this.ICU = Iu;
		this.ICP = Ip;
		
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registrar Propuesta");
		setClosable(true);
		setBounds(100, 100, 582, 386);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{146, 105, 105, 90, 0, 103};
		gbl_panel.rowHeights = new int[]{40, 0, 12, 24, 29, 0, 0, 0, 0, 68, 31, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		imgPanel = new JPanel((LayoutManager) null);
		GridBagConstraints gbc_imgPanel = new GridBagConstraints();
		gbc_imgPanel.gridheight = 4;
		gbc_imgPanel.insets = new Insets(0, 0, 5, 5);
		gbc_imgPanel.gridx = 0;
		gbc_imgPanel.gridy = 0;
		panel.add(imgPanel, gbc_imgPanel);
		imgPanel.setLayout(new BorderLayout());
		 
		ImageIcon image = new ImageIcon("recursos/addpicture.png");
		lblImageLabel = new JLabel("", image, SwingConstants.CENTER);
		imgPanel.add(lblImageLabel, BorderLayout.NORTH); 
		imgPanel.setToolTipText("Agrega una nueva imagen para la propuesta");  
		
		image = new ImageIcon("recursos/addpicture.png");
		lblImageLabel = new JLabel("", image, SwingConstants.CENTER);
		imgPanel.add(lblImageLabel, BorderLayout.NORTH);  
		customImg = false;
		
		imgPanel.add(lblImageLabel, BorderLayout.NORTH);
		
		imgPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				 fileChooser.setAcceptAllFileFilterUsed(false);
				 fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png"));
		            int returnValue = fileChooser.showOpenDialog(null);
		            if (returnValue == JFileChooser.APPROVE_OPTION) {
		            	  File selectedFile = fileChooser.getSelectedFile();
		            	  archivoDestino = new File("imagenes/propuestas/tmp."+selectedFile.getName()
		            	  		.substring(selectedFile.getName().lastIndexOf(".") + 1));	//obtiene la extensión
		            	  archivoDestino.mkdirs();
		            	  try {
		            		  Files.copy(selectedFile.toPath(),archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
		            		  ImageIcon img = new ImageIcon(new ImageIcon(archivoDestino.getAbsolutePath())
		            				  .getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		            		 
		            		  lblImageLabel.setIcon(img);
		            		  customImg = true;
		            		  } catch (IOException ioe) {
		            			  //Establece una imagen predeterminada del sistema
		            			  lblImageLabel.setIcon(new ImageIcon("recursos/no_imagen_propuesta"));
		            			  customImg = false;
		            	  }
		            }
				
			}
		});
		
		
		JLabel label = new JLabel("Titulo");
		label.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		txtTitulo = new JTextField("");
		txtTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtTItulo = new GridBagConstraints();
		gbc_txtTItulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTItulo.gridwidth = 4;
		gbc_txtTItulo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTItulo.gridx = 2;
		gbc_txtTItulo.gridy = 0;
		panel.add(txtTitulo, gbc_txtTItulo);
		
		JLabel label_1 = new JLabel("Lugar");
		label_1.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		txtLugar = new JTextField();
		txtLugar.setHorizontalAlignment(SwingConstants.LEFT);
		txtLugar.setColumns(30);
		GridBagConstraints gbc_txtLugar = new GridBagConstraints();
		gbc_txtLugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLugar.gridwidth = 4;
		gbc_txtLugar.insets = new Insets(0, 0, 5, 5);
		gbc_txtLugar.gridx = 2;
		gbc_txtLugar.gridy = 1;
		panel.add(txtLugar, gbc_txtLugar);
		
		JLabel label_2 = new JLabel("Monto a reunir");
		label_2.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);
		
		txtMonto = new JTextField();
		txtMonto.setColumns(10);
		GridBagConstraints gbc_txtMonto = new GridBagConstraints();
		gbc_txtMonto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMonto.gridwidth = 4;
		gbc_txtMonto.insets = new Insets(0, 0, 5, 5);
		gbc_txtMonto.gridx = 2;
		gbc_txtMonto.gridy = 2;
		panel.add(txtMonto, gbc_txtMonto);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_lblCategora = new GridBagConstraints();
		gbc_lblCategora.anchor = GridBagConstraints.WEST;
		gbc_lblCategora.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategora.gridx = 1;
		gbc_lblCategora.gridy = 3;
		panel.add(lblCategora, gbc_lblCategora);
		
		fieldCategoria = new JTextField();
		fieldCategoria.setEditable(false);
		GridBagConstraints gbc_fieldCategoria = new GridBagConstraints();
		gbc_fieldCategoria.gridwidth = 2;
		gbc_fieldCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_fieldCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCategoria.gridx = 2;
		gbc_fieldCategoria.gridy = 3;
		panel.add(fieldCategoria, gbc_fieldCategoria);
		fieldCategoria.setColumns(10);
		
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove cuando sale??
				selectCategoria = new SelectCategoria(ICP);
				getParent().add(selectCategoria);
				selectCategoria.pasarField(fieldCategoria);
				selectCategoria.cargarArbol();
				selectCategoria.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSeleccionar.gridwidth = 2;
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeleccionar.gridx = 4;
		gbc_btnSeleccionar.gridy = 3;
		panel.add(btnSeleccionar, gbc_btnSeleccionar);
		
		JLabel label_3 = new JLabel("Proponente");
		label_3.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 4;
		panel.add(label_3, gbc_label_3);
		
		cmbProponentes = new JComboBox();
		GridBagConstraints gbc_cmbProponentes = new GridBagConstraints();
		gbc_cmbProponentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbProponentes.gridwidth = 5;
		gbc_cmbProponentes.insets = new Insets(0, 0, 5, 5);
		gbc_cmbProponentes.gridx = 1;
		gbc_cmbProponentes.gridy = 4;
		panel.add(cmbProponentes, gbc_cmbProponentes);
		
		JLabel label_4 = new JLabel("Fecha publicacion");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 5;
		panel.add(label_4, gbc_label_4);
		
		txtFechaPublicacion = new JTextField();
		txtFechaPublicacion.setHorizontalAlignment(SwingConstants.LEFT);
		txtFechaPublicacion.setColumns(10);
		GridBagConstraints gbc_txtFechaPublicacion = new GridBagConstraints();
		gbc_txtFechaPublicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaPublicacion.gridwidth = 5;
		gbc_txtFechaPublicacion.insets = new Insets(0, 0, 5, 5);
		gbc_txtFechaPublicacion.gridx = 1;
		gbc_txtFechaPublicacion.gridy = 5;
		panel.add(txtFechaPublicacion, gbc_txtFechaPublicacion);
		
		JLabel label_5 = new JLabel("Fecha realizacion");
		label_5.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 6;
		panel.add(label_5, gbc_label_5);
		
		txtFechaRealizacion = new JDateChooser();
		txtFechaRealizacion.getDateEditor().setEnabled(false);
		
		
		GridBagConstraints gbc_txtFechaRealizacion = new GridBagConstraints();
		gbc_txtFechaRealizacion.gridwidth = 5;
		gbc_txtFechaRealizacion.insets = new Insets(0, 0, 5, 5);
		gbc_txtFechaRealizacion.fill = GridBagConstraints.BOTH;
		gbc_txtFechaRealizacion.gridx = 1;
		gbc_txtFechaRealizacion.gridy = 6;
		txtFechaRealizacion.setDateFormatString("dd/MM/YYYY"); 
		panel.add(txtFechaRealizacion, gbc_txtFechaRealizacion);
		
		JLabel label_6 = new JLabel("Precio entrada");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 7;
		panel.add(label_6, gbc_label_6);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridwidth = 5;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.gridx = 1;
		gbc_txtPrecio.gridy = 7;
		panel.add(txtPrecio, gbc_txtPrecio);
		
		JLabel label_7 = new JLabel("Tipo de retorno");
		label_7.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 8;
		panel.add(label_7, gbc_label_7);
		
		JCheckBox retEntradas = new JCheckBox("Entradas gratis");
		GridBagConstraints gbc_retEntradas = new GridBagConstraints();
		gbc_retEntradas.gridwidth = 2;
		gbc_retEntradas.insets = new Insets(0, 0, 5, 5);
		gbc_retEntradas.gridx = 1;
		gbc_retEntradas.gridy = 8;
		panel.add(retEntradas, gbc_retEntradas);
		
		JCheckBox retPorcentaje = new JCheckBox("Porcentaje de ganancia");
		GridBagConstraints gbc_retPorcentaje = new GridBagConstraints();
		gbc_retPorcentaje.gridwidth = 3;
		gbc_retPorcentaje.insets = new Insets(0, 0, 5, 5);
		gbc_retPorcentaje.gridx = 3;
		gbc_retPorcentaje.gridy = 8;
		panel.add(retPorcentaje, gbc_retPorcentaje);
		
		JLabel label_9 = new JLabel("Descripcion");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_9.gridheight = 2;
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 9;
		panel.add(label_9, gbc_label_9);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		
		txtFechaPublicacion.setText(reportDate);
		txtFechaPublicacion.setEditable(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				limpiarCampos();
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String rutaImg ="";
					DtCategoria categoria = new DtCategoria(fieldCategoria.getText());
					Date fechaP = new Date();
					TRetorno retorno = null;
					
					if(retPorcentaje.isSelected() && !retEntradas.isSelected())
						retorno = TRetorno.PORCENTAJE_GANANCIA;
					else if (!retPorcentaje.isSelected() && retEntradas.isSelected())
						retorno = TRetorno.ENTRADA_GRATIS;
					else if(retPorcentaje.isSelected() && retEntradas.isSelected())
						retorno = TRetorno.PORCENTAJE_Y_ENTRADAS; 
					
					float montoTrim = Float.parseFloat(String.valueOf(txtMonto.getText()).replace(" ", ""));
					float precioTrim = Float.parseFloat(String.valueOf(txtPrecio.getText()).replace(" ", ""));
					
					if(txtTitulo.getText().trim().isEmpty())
						JOptionPane.showMessageDialog(null, "Debe ingresar el titulo","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(txtLugar.getText().trim() == "")
						JOptionPane.showMessageDialog(null, "Debe ingresar el lugar","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(txtMonto.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Debe ingresar el monto","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(montoTrim < 0 )
						JOptionPane.showMessageDialog(null, "El valor designado para 'monto' no puede ser negativo","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(txtPrecio.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Debe ingresar el precio de la entrada","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(precioTrim < 0 )
						JOptionPane.showMessageDialog(null, "El valor designado para 'precio' no puede ser negativo","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(txtFechaRealizacion.getDate() == null)
						JOptionPane.showMessageDialog(null, "Debe ingresar una fecha de realizaci�n valida","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(retorno == null)
						JOptionPane.showMessageDialog(null, "Debe ingresar por lo menos un tipo de retorno","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if (ICU.existeUsuario(cmbProponentes.getSelectedItem().toString(), "") 
							&& ICP.existePropuesta(cmbProponentes.getSelectedItem().toString(), txtTitulo.getText().toString())){
						
						if(customImg) rutaImg = txtTitulo.getText().toString().hashCode() + "";
						
						ICP.altaPropuesta(cmbProponentes.getSelectedItem().toString(), txtTitulo.getText().trim(), categoria, txtDescripcion.getText().trim(), txtLugar.getText().trim(), txtFechaRealizacion.getDate(), 
							fechaP, montoTrim, retorno, precioTrim, rutaImg);
							
						if(customImg)
							guardarImagen(rutaImg);
							
							
						JOptionPane.showMessageDialog(null, "La propuesta ha sido registrada correctamente", "Culturarte",
							JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						limpiarCampos();	
					}
					
				} catch (NumberFormatException npe) {
						JOptionPane.showMessageDialog(null,"No se puede registrar la propuesta. "
								+ "Aseg�rese de que los campos 'monto' y 'precio' tengan valores num�ricos no negativos", "Culturarte",
								JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		panel.add(scrollPane, gbc_scrollPane);
		
		txtDescripcion = new JTextArea();
		scrollPane.setViewportView(txtDescripcion);
		

		
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridwidth = 2;
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 10;
		panel.add(btnAceptar, gbc_btnAceptar);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 3;
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 10;
		panel.add(btnCancelar, gbc_btnCancelar);
		
	}
	
	private void limpiarCampos() {
		txtTitulo.setText("");
		txtLugar.setText("");
		txtMonto.setText("");
		txtPrecio.setText("");
		txtDescripcion.setText("");
		txtFechaRealizacion.setCalendar(null);
		fieldCategoria.setText("");
		
		ImageIcon img = new ImageIcon(new ImageIcon("recursos/addpicture.png")
				  .getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		lblImageLabel.setIcon(img);
	}
	
	public void setComboProponentes(String[] datosCmb){
		ComboBoxModel modelo = new DefaultComboBoxModel(datosCmb);
		cmbProponentes.setModel(modelo);
	}
	
	private void guardarImagen(String codigo) {
		try {
			Path source = archivoDestino.toPath();
			String newPath = archivoDestino.getAbsolutePath().replace("tmp", codigo);
			Path newdir = new File(newPath).toPath();
			Files.move(source, newdir, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
}
