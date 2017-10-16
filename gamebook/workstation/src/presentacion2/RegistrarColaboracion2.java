package presentacion2;

import dataTypes.DtColaborador;
import dataTypes.DtPropuesta;
import Logica.ICtrlPropuesta;
import dataTypes.TRetorno;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JScrollPane;

public class RegistrarColaboracion2 extends JInternalFrame {

	private ICtrlPropuesta ICP;
	private JTextField txtMonto;
	private JComboBox listaColaboradores;
	private JComboBox listaPropuestas;
	private JComboBox cmbRetorno;
	private JTextPane txtDatosPropuesta;
	private JScrollPane txtDatosScroll;
	
	public RegistrarColaboracion2(ICtrlPropuesta iCP) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				txtDatosPropuesta.setText("");
			}
		});
		
		this.ICP = iCP;		
		
		setTitle("Registrar Colaboracion");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 465, 416);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Colaborador");
		label.setBounds(80, 11, 79, 14);
		label.setFont(new Font("Dialog", Font.BOLD, 11));
		panel.add(label);
		
		listaColaboradores = new JComboBox();
		listaColaboradores.setBounds(164, 6, 284, 24);
		panel.add(listaColaboradores);
		
		JLabel label_1 = new JLabel("Propuesta");
		label_1.setBounds(94, 40, 65, 14);
		label_1.setFont(new Font("Dialog", Font.BOLD, 11));
		panel.add(label_1);
		
		listaPropuestas = new JComboBox();
		listaPropuestas.setBounds(164, 35, 284, 24);
		panel.add(listaPropuestas);
		
		JLabel label_2 = new JLabel("Datos de la Propuesta");
		label_2.setBounds(17, 90, 142, 14);
		label_2.setFont(new Font("Dialog", Font.BOLD, 11));
		panel.add(label_2);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(164, 346, 132, 25);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		
		txtDatosScroll = new JScrollPane();
		txtDatosScroll.setBounds(164, 64, 279, 217);
		panel.add(txtDatosScroll);
		
		txtDatosPropuesta = new JTextPane();
		txtDatosPropuesta.setEditable(false);
		txtDatosScroll.setViewportView(txtDatosPropuesta);
		
 
		      
		      
		JLabel label_3 = new JLabel("Tipo de retorno");
		label_3.setBounds(60, 291, 99, 14);
		label_3.setFont(new Font("Dialog", Font.BOLD, 11));
		panel.add(label_3);
		
		cmbRetorno = new JComboBox();
		cmbRetorno.setBounds(164, 286, 284, 24);
		panel.add(cmbRetorno);
		
		JLabel label_4 = new JLabel("Monto");
		label_4.setBounds(119, 317, 40, 14);
		label_4.setFont(new Font("Dialog", Font.BOLD, 11));
		panel.add(label_4);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(164, 315, 284, 19);
		txtMonto.setText("0.00");
		txtMonto.setColumns(10);
		panel.add(txtMonto);
		panel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(308, 346, 135, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				setVisible(false);
			}
		});
		panel.add(btnCancelar);
		
	}
	
	private void registrar() {
		float montoTrim = Float.parseFloat(String.valueOf(txtMonto.getText()).replace(" ", ""));
		if(listaColaboradores.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this,
				"Debes elegir un colaborador",
				"Registrar Colaboracion a Propuesta",
                JOptionPane.WARNING_MESSAGE);
			return;
		} else if(listaPropuestas.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this,
				"Debes elegir una propuesta",
				"Registrar Colaboracion a Propuesta",
                JOptionPane.WARNING_MESSAGE);
			return;
		} else if(montoTrim < 0) {
			JOptionPane.showMessageDialog(this, "El monto de la colaboración debe ser positivo", "Registrar Colaboracion a Propuesta", JOptionPane.ERROR_MESSAGE);
		} else {
			ArrayList<DtColaborador> colaboradores = ICP.listarColaboradores();
			String nickColaborador = colaboradores.get(listaColaboradores.getSelectedIndex()).getNickName();
			TRetorno retorno;
			try {
				if(cmbRetorno.getSelectedItem().toString() == "Entradas gratis") retorno = TRetorno.ENTRADA_GRATIS;
				else retorno = TRetorno.PORCENTAJE_GANANCIA;
				int opcion = JOptionPane.showConfirmDialog(this, "Confirma el registro", "Registrar Colaboracion a Propuesta", JOptionPane.OK_CANCEL_OPTION);
				if(opcion == JOptionPane.OK_OPTION) {
					
					
					
					ICP.agregarColaboracion(nickColaborador.trim(), montoTrim, retorno);
					JOptionPane.showMessageDialog(this, "La colaboracion se ha registrado con exito", "Registrar Colaboracion a Propuesta", JOptionPane.INFORMATION_MESSAGE);
					ICP.finalizarRegistrarColaboracionPropuesta();
					setVisible(false);
				}
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "El monto de la colaboración debe ser un numero real", "Registrar Colaboracion a Propuesta", JOptionPane.ERROR_MESSAGE);
			} catch(NullPointerException npe) {
				JOptionPane.showMessageDialog(this, "Debe elegir un tipo de retorno", "Registrar Colaboracion a Propuesta", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		limpiarCampos();
		
	}
	
	public boolean cargarDatos() {
		ArrayList<DtColaborador> colaboradores = ICP.listarColaboradores();
		DtColaborador dtC;
		listaColaboradores.removeAllItems();
		for(int i = 0; i < colaboradores.size(); i++) {
			dtC = colaboradores.get(i);
			String s = "" + dtC.getNickName() + " (" + dtC.getNombre() + " " + dtC.getApellido() + ")";
			listaColaboradores.addItem(s);
		};
		
		ArrayList<DtPropuesta> propuestas = ICP.listarPropuestas();
		DtPropuesta dtP;
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.removeAllElements();
		for(int i = 0; i < propuestas.size(); i++) {
			dtP = propuestas.get(i);
			String s = "" + dtP.getTitulo() + " (" + dtP.getNickProponente() + ")";
			model.addElement(s);;
		}
		listaPropuestas.setModel(model);
		
		
		try{ //Tener recordada la primer propuesta de la lista, si no se selecciona nada
			DtPropuesta primeraProp = ICP.infoPropuesta(propuestas.get(listaPropuestas.getSelectedIndex()).getTitulo());
    		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    		txtDatosPropuesta.setText("Titulo: " + primeraProp.getTitulo() + "\n"
						//+ "Categoria: " + primeraProp.getCategoria().getNombre() + "\n"
						+ "Descripcion: " + primeraProp.getDescripcion() + "\n"
						+ "Lugar: " + primeraProp.getLugar() + "\n"
						+ "Fecha de Realizacion: " + dateFormat.format(primeraProp.getFechaRealizacion()) + "\n"
						+ "Fecha de Publicacion: " + dateFormat.format(primeraProp.getFechaPublicacion()) + "\n"
						+ "Monto a reunir: " + primeraProp.getMontoRequerido() + "\n"
						+ "Tipo de retorno: " + primeraProp.getTipoRetorno() + "\n"
        				+ "Estado de la Propuesta: " + primeraProp.getEstado().name());
    		
    		if(primeraProp.getTipoRetorno() == TRetorno.ENTRADA_GRATIS) {
    			cmbRetorno.setModel(new DefaultComboBoxModel(new String[] {"Entradas Gratis"}));	
    		} else if(primeraProp.getTipoRetorno() == TRetorno.PORCENTAJE_GANANCIA) {
    			cmbRetorno.setModel(new DefaultComboBoxModel(new String[] {"Porcentaje de ganancia"}));
    		} else {
    			cmbRetorno.setModel(new DefaultComboBoxModel(new String[] {"Entradas Gratis, Porcentaje de ganancia"}));
    		}
    		
    		
		} catch(Exception e) {e.printStackTrace();}
		
		listaPropuestas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            		
            	 
            		String s = propuestas.get(listaPropuestas.getSelectedIndex()).getTitulo();
            		DtPropuesta dtP = ICP.infoPropuesta(s);
            		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            		txtDatosPropuesta.setText("Titulo: " + dtP.getTitulo() + "\n"
        					//	+ "Categoria: " + dtP.getCategoria().getNombre() + "\n"
        						+ "Descripcion: " + dtP.getDescripcion() + "\n"
        						+ "Lugar: " + dtP.getLugar() + "\n"
        						+ "Fecha de Realizacion: " + dateFormat.format(dtP.getFechaRealizacion()) + "\n"
        						+ "Fecha de Publicacion: " + dateFormat.format(dtP.getFechaPublicacion()) + "\n"
        						+ "Monto a reunir: " + dtP.getMontoRequerido() + "\n"
        						+ "Tipo de retorno: " + dtP.getTipoRetorno() + "\n"
                				+ "Estado de la Propuesta: " + dtP.getEstado().name());
            		
            		if(dtP.getTipoRetorno() == TRetorno.ENTRADA_GRATIS) {
            			cmbRetorno.setModel(new DefaultComboBoxModel(new String[] {"Entradas Gratis"}));	
            		} else if(dtP.getTipoRetorno() == TRetorno.PORCENTAJE_GANANCIA) {
            			cmbRetorno.setModel(new DefaultComboBoxModel(new String[] {"Porcentaje de ganancia"}));
            		} else {
            			cmbRetorno.setModel(new DefaultComboBoxModel(new String[] {"Porcentaje de ganancia", "Entradas Gratis"}));
            		}
            		
            	} catch(NullPointerException e1) {
            		e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se pude registrar la colaboraci�n", "Registrar Colaboracion a Propuesta", JOptionPane.ERROR_MESSAGE);
            	} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
		
		
		return true;
	}
	
	
	private void limpiarCampos() {
		txtMonto.setText("0.00");
	}
	
	
	
}
