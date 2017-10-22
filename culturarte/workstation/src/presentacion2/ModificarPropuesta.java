package presentacion2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;

import logica.ICtrlPropuesta;
import logica.ICtrlUsuario;
import dataTypes.DtPropuesta;
import dataTypes.TRetorno;
import dataTypes.DtCategoria;

import javax.swing.JFrame;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ModificarPropuesta extends JInternalFrame {
	private ICtrlPropuesta ICP;
	private ICtrlUsuario ICU;
	
	private JTextField txtMonto;
	private JTextField txtLugar;
	private JTextField txtTitulo;
	private JTextField txtFechaPublicacion;
	private JTextField txtPrecioEntrada;
	private JTextField txtProponente;
	private JTextArea txtDescripcion;
	private JComboBox cmbPropuestas;
	private JDateChooser txtFechaRealizacion;
	private JCheckBox chbEntrada;
	private JCheckBox chbPorcentaje;
	private JLabel lblimagen;

	public ModificarPropuesta(ICtrlPropuesta iCP,ICtrlUsuario iCU) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent arg0) {
				limpiarCampos();
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.ICP = iCP;
		this.ICU = iCU;
		setTitle("Modificar Propuesta");
		setClosable(true);
		setResizable(false);
		setBounds(100, 100, 511, 484);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPropuetaAModificar = new JLabel("Propuesta a Modificar");
		lblPropuetaAModificar.setBounds(10, 22, 155, 17);
		panel.add(lblPropuetaAModificar);
		
		cmbPropuestas = new JComboBox();
		cmbPropuestas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try{
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date today = Calendar.getInstance().getTime();
					String reportDate = df.format(today);
					txtFechaPublicacion.setText(reportDate);
					
					String propuestaSelected = (String)cmbPropuestas.getSelectedItem();
					DtPropuesta dtP = ICP.infoPropuesta(propuestaSelected);
					txtTitulo.setText(dtP.getTitulo());
					txtLugar.setText(dtP.getLugar());
					txtMonto.setText(String.valueOf(dtP.getMontoRequerido()));
					txtFechaRealizacion.setDate(dtP.getFechaRealizacion());
					txtPrecioEntrada.setText(String.valueOf(dtP.getPrecioEntrada()));
					txtDescripcion.setText(dtP.getDescripcion());
					txtProponente.setText(dtP.getNickProponente());
					
					TRetorno ret = dtP.getTipoRetorno();
					
					chbEntrada.setSelected(false);
					chbEntrada.setSelected(false);
					if(ret == TRetorno.ENTRADA_GRATIS)
						chbEntrada.setSelected(true);
					else if(ret == TRetorno.PORCENTAJE_GANANCIA)
						chbPorcentaje.setSelected(true);
					else{
						chbPorcentaje.setSelected(true);
						chbEntrada.setSelected(true);
					}
					
					String ruta = "imagenes/propuestas/"+dtP.getRutaImg();
					File f1 = new File(ruta+".png");
					File f2 = new File(ruta+".jpg");
					if(f1.isFile()) {
						 ImageIcon img = new ImageIcon(new ImageIcon(f1.getAbsolutePath())
								  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
						 lblimagen.setIcon(img);
					} else if(f2.isFile()) {
						 ImageIcon img = new ImageIcon(new ImageIcon(f2.getAbsolutePath())
								  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
						 lblimagen.setIcon(img);
					} else {
						 ImageIcon img = new ImageIcon(new ImageIcon("recursos/no_imagen_propuesta.png")
								  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
						 lblimagen.setIcon(img);
					}
					
					txtLugar.setEditable(true);
					txtMonto.setEditable(true);
					txtFechaRealizacion.setEnabled(true);
					txtPrecioEntrada.setEditable(true);
					txtDescripcion.setEditable(true);
			
				}
				catch(Exception e){}
			}
		});
		cmbPropuestas.setBounds(175, 19, 290, 20);
		panel.add(cmbPropuestas);
		
		txtMonto = new JTextField();
		txtMonto.setEditable(false);
		txtMonto.setBounds(253, 117, 212, 20);
		panel.add(txtMonto);
		txtMonto.setColumns(10);
		
		txtLugar = new JTextField();
		txtLugar.setEditable(false);
		txtLugar.setBounds(253, 92, 212, 20);
		panel.add(txtLugar);
		txtLugar.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setBounds(253, 67, 212, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblProponente = new JLabel("Proponente");
		lblProponente.setFont(new Font("Dialog", Font.BOLD, 11));
		lblProponente.setBounds(10, 178, 74, 14);
		panel.add(lblProponente);
		
		JLabel lblFechaPublicacion = new JLabel("Fecha Publicacion");
		lblFechaPublicacion.setFont(new Font("Dialog", Font.BOLD, 11));
		lblFechaPublicacion.setBounds(10, 204, 134, 17);
		panel.add(lblFechaPublicacion);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 11));
		lblTitulo.setBounds(203, 70, 74, 14);
		panel.add(lblTitulo);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setFont(new Font("Dialog", Font.BOLD, 11));
		lblLugar.setBounds(203, 94, 39, 14);
		panel.add(lblLugar);
		
		JLabel lblMontoAReunir = new JLabel("Monto a Reunir");
		lblMontoAReunir.setFont(new Font("Dialog", Font.BOLD, 11));
		lblMontoAReunir.setBounds(142, 119, 101, 14);
		panel.add(lblMontoAReunir);
		
		txtFechaPublicacion = new JTextField();
		txtFechaPublicacion.setEditable(false);
		txtFechaPublicacion.setBounds(169, 202, 296, 20);
		panel.add(txtFechaPublicacion);
		txtFechaPublicacion.setColumns(10);
		
		JLabel lblFechaRealizacion = new JLabel("Fecha Realizacion");
		lblFechaRealizacion.setFont(new Font("Dialog", Font.BOLD, 11));
		lblFechaRealizacion.setBounds(10, 229, 134, 14);
		panel.add(lblFechaRealizacion);
		
		JLabel lblPrecioEntrada = new JLabel("Precio Entrada");
		lblPrecioEntrada.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPrecioEntrada.setBounds(10, 262, 114, 14);
		panel.add(lblPrecioEntrada);
		
		txtPrecioEntrada = new JTextField();
		txtPrecioEntrada.setEditable(false);
		txtPrecioEntrada.setBounds(169, 260, 296, 20);
		panel.add(txtPrecioEntrada);
		txtPrecioEntrada.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDescripcion.setBounds(10, 343, 97, 14);
		panel.add(lblDescripcion);
		
		txtFechaRealizacion = new JDateChooser();
		txtFechaRealizacion.setEnabled(false);
		txtFechaRealizacion.setBounds(169, 229, 296, 20);
		panel.add(txtFechaRealizacion);
		
		JLabel lblTipoRetorno = new JLabel("Tipo Retorno");
		lblTipoRetorno.setFont(new Font("Dialog", Font.BOLD, 11));
		lblTipoRetorno.setBounds(10, 309, 97, 14);
		panel.add(lblTipoRetorno);
		
		chbEntrada = new JCheckBox("Entradas gratis");
		chbEntrada.setEnabled(false);
		chbEntrada.setBounds(117, 304, 139, 23);
		panel.add(chbEntrada);
		
		chbPorcentaje = new JCheckBox("Porcentaje de ganancia");
		chbPorcentaje.setEnabled(false);
		chbPorcentaje.setBounds(260, 304, 205, 23);
		panel.add(chbPorcentaje);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					float montoTrim = Float.parseFloat(String.valueOf(txtMonto.getText()).replace(" ", ""));
					float precioTrim = Float.parseFloat(String.valueOf(txtPrecioEntrada.getText()).replace(" ", ""));
					
					if(txtLugar.getText() == "")
						JOptionPane.showMessageDialog(null, "Debe ingresar el lugar","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(txtMonto.getText().trim().isEmpty())
						JOptionPane.showMessageDialog(null, "Debe ingresar el monto","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(Float.parseFloat(txtMonto.getText())<0 )
						JOptionPane.showMessageDialog(null, "El valor designado para 'monto' no puede ser negativo","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(txtPrecioEntrada.getText().trim().isEmpty())
						JOptionPane.showMessageDialog(null, "Debe ingresar el precio de la entrada","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(Float.parseFloat(txtPrecioEntrada.getText())<0 )
						JOptionPane.showMessageDialog(null, "El valor designado para 'precio' no puede ser negativo","Culturarte",JOptionPane.WARNING_MESSAGE);
					else if(txtFechaRealizacion.getDate() == null)
						JOptionPane.showMessageDialog(null, "Debe ingresar una fecha de realizaci�n valida","Culturarte",JOptionPane.WARNING_MESSAGE);
					else{
						ICP.modificarPropuesta((String)cmbPropuestas.getSelectedItem(), txtDescripcion.getText().trim(), txtLugar.getText().trim(), 
								txtFechaRealizacion.getDate(), montoTrim, precioTrim);
						setVisible(false);
					}
					}catch(Exception e){}
				limpiarCampos();
			}
		});
		btnAceptar.setBounds(142, 420, 114, 23);
		panel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(268, 420, 123, 23);
		panel.add(btnCancelar);
		
		txtProponente = new JTextField();
		txtProponente.setEditable(false);
		txtProponente.setColumns(10);
		txtProponente.setBounds(169, 176, 296, 20);
		panel.add(txtProponente);
		
		lblimagen = new JLabel("");
		lblimagen.setBounds(10, 50, 134, 115);
		panel.add(lblimagen);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(117, 343, 348, 62);
		panel.add(scrollPane_1);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setEditable(false);
		scrollPane_1.setViewportView(txtDescripcion);
		txtDescripcion.setRows(5);

	}
	
	public void cargarPropuestas(){
		String[] datosCmb = new	String[ICP.listarPropuestas().size()];
		for(int i = 0 ; i < ICP.listarPropuestas().size() ; i++)
			datosCmb[i] = ICP.listarPropuestas().get(i).getTitulo();
		ComboBoxModel modelo = new DefaultComboBoxModel(datosCmb);
		cmbPropuestas.setModel(modelo);
		
		ImageIcon img = new ImageIcon(new ImageIcon("recursos/addpicture.png")
				  .getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		lblimagen.setIcon(img);
	}
	
	private void limpiarCampos() {
		txtTitulo.setText("");
		txtLugar.setText("");
		txtMonto.setText("");
		txtPrecioEntrada.setText("");
		txtDescripcion.setText("");
		txtFechaRealizacion.setCalendar(null);
		chbEntrada.setSelected(false);
		chbPorcentaje.setSelected(false);
		ImageIcon img = new ImageIcon(new ImageIcon("recursos/addpicture.png")
				  .getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		lblimagen.setIcon(img);
	}
}
