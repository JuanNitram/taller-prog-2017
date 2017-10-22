package presentacion2;

import java.awt.EventQueue;


import dataTypes.DtColaboracion;
import logica.ICtrlPropuesta;

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
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CancelarColaboracion2 extends JInternalFrame {

	private ICtrlPropuesta ICP;
	private JComboBox listColaboraciones;
	private JTextPane infoColaboracion;
	
	public CancelarColaboracion2(ICtrlPropuesta iCP) {
		this.ICP = iCP;
		
		setTitle("Cancelar Colaboracion");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{110, 150, 150, 30, 0};
		gbl_panel.rowHeights = new int[]{30, 30, 144, 37, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.5, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Colaboraci�n");
		label.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		listColaboraciones = new JComboBox();
		
		GridBagConstraints gbc_listColaboraciones = new GridBagConstraints();
		gbc_listColaboraciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_listColaboraciones.gridwidth = 2;
		gbc_listColaboraciones.insets = new Insets(0, 0, 5, 5);
		gbc_listColaboraciones.gridx = 1;
		gbc_listColaboraciones.gridy = 1;
		panel.add(listColaboraciones, gbc_listColaboraciones);
		
		infoColaboracion = new JTextPane();
		infoColaboracion.setEditable(false);
		GridBagConstraints gbc_infoColaboraciones = new GridBagConstraints();
		gbc_infoColaboraciones.fill = GridBagConstraints.BOTH;
		gbc_infoColaboraciones.gridwidth = 2;
		gbc_infoColaboraciones.insets = new Insets(0, 0, 5, 5);
		gbc_infoColaboraciones.gridx = 1;
		gbc_infoColaboraciones.gridy = 2;
		panel.add(infoColaboracion, gbc_infoColaboraciones);
		
		JButton btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		GridBagConstraints gbc_btn_aceptar = new GridBagConstraints();
		gbc_btn_aceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_aceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btn_aceptar.gridx = 1;
		gbc_btn_aceptar.gridy = 3;
		panel.add(btn_aceptar, gbc_btn_aceptar);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btn_cancelar = new GridBagConstraints();
		gbc_btn_cancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_cancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btn_cancelar.gridx = 2;
		gbc_btn_cancelar.gridy = 3;
		panel.add(btn_cancelar, gbc_btn_cancelar);

	}

	public void cargarColaboraciones() {
		ArrayList<DtColaboracion> colaboraciones = ICP.listarColaboraciones();
		DtColaboracion dtC;
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		String s;
		for(int i = 0; i < colaboraciones.size(); i++) {
			dtC = colaboraciones.get(i);
			s = dtC.getTitulo() + " (" + dtC.getNickname() + ")"; 
			model.addElement(s);
		}
		listColaboraciones.setModel(model);
		try {
		DtColaboracion dtFirst = ICP.infoColaboracion(colaboraciones.get(0).getId());
		String sFirst = "Propuesta: " + dtFirst.getTitulo() + "\n"
				+ "Colaborador: " + dtFirst.getNickname() + "\n"
				+ "Fecha: " + dtFirst.getFechaRealizacion().toString() + "\n"
				+ "Aporte: " + dtFirst.getMontoAporte() + "\n"
				+ "Tipo de retorno: " + dtFirst.getRetorno().name();
		infoColaboracion.setText(sFirst);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"No se pudo cancelar la colaboracion" , "Culturarte", JOptionPane.ERROR_MESSAGE);
		}
		
		
		listColaboraciones.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					DtColaboracion dtC = ICP.infoColaboracion(colaboraciones.get(listColaboraciones.getSelectedIndex()).getId());
					String s = "Propuesta: " + dtC.getTitulo() + "\n"
							+ "Colaborador: " + dtC.getNickname() + "\n"
							+ "Fecha: " + dtC.getFechaRealizacion().toString() + "\n"
							+ "Aporte: " + dtC.getMontoAporte() + "\n"
							+ "Tipo de retorno: " + dtC.getRetorno().name();
					infoColaboracion.setText(s);
				} catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"No se pudo cancelar la colaboracion" , "Culturarte", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
	}
	
	
	protected void cancelar() {
		//Se asegura de que elija un item
		if(listColaboraciones.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this,
				"Debes elegir una colaboracion",
				"Culturarte",
	            JOptionPane.WARNING_MESSAGE);
		} else {
			int opcion = JOptionPane.showConfirmDialog(this, "�Confirma que desea cancelar la colaboraci�n?", "Culturarte",
					JOptionPane.OK_CANCEL_OPTION);
			if(opcion == JOptionPane.OK_OPTION) {
				ICP.cancelarColaboracion();
				JOptionPane.showMessageDialog(this, 
					"La colaboracion se ha cancelado con exito", 
					"Culturarte",
					JOptionPane.INFORMATION_MESSAGE);
				ICP.finalizarCancelarColaboracionPropuesta();
				setVisible(false);
			}
		}
	}
}
