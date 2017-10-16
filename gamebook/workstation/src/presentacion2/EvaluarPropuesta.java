package presentacion2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.ICtrlPropuesta;
import dataTypes.DtPropuesta;
import dataTypes.TEstado;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EvaluarPropuesta extends JInternalFrame {
	
	private ICtrlPropuesta ICP;
	
	private JPanel contentPane;	
	
	private JLabel lblNewLabel;
	private JRadioButton rdbtnPublicar;
	private JRadioButton rdbtnCancelar;
	private JButton btnAceptar;
	private JButton btnCerrar;
	private JComboBox<String> comboBox;

	public EvaluarPropuesta(ICtrlPropuesta iCP) {
		
		ICP = iCP;
		
		setTitle("Evaluar Propuesta");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 608, 185);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 0, 0, 0, 0, 0, 30};
		gbl_contentPane.rowHeights = new int[] {30, 0, 30};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.25, 0.25, 0.25, 0.25, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Elige una propuesta");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		contentPane.add(comboBox, gbc_comboBox);
		
		rdbtnPublicar = new JRadioButton("Publicar");
		GridBagConstraints gbc_rdbtnPublicar = new GridBagConstraints();
		gbc_rdbtnPublicar.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPublicar.gridx = 3;
		gbc_rdbtnPublicar.gridy = 1;
		contentPane.add(rdbtnPublicar, gbc_rdbtnPublicar);
		
		rdbtnCancelar = new JRadioButton("Cancelar");
		GridBagConstraints gbc_rdbtnCancelar = new GridBagConstraints();
		gbc_rdbtnCancelar.gridwidth = 2;
		gbc_rdbtnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCancelar.gridx = 4;
		gbc_rdbtnCancelar.gridy = 1;
		contentPane.add(rdbtnCancelar, gbc_rdbtnCancelar);
		
		ButtonGroup grupoRadioBoton = new ButtonGroup();
		grupoRadioBoton.add(rdbtnPublicar);
		grupoRadioBoton.add(rdbtnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				evaluar();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 2;
		contentPane.add(btnAceptar, gbc_btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridx = 2;
		gbc_btnCerrar.gridy = 2;
		contentPane.add(btnCerrar, gbc_btnCerrar);
		
	}
	
	public void evaluar() {
		try {
			String item = (String)comboBox.getSelectedItem();
			String titulo = item.substring(0, item.lastIndexOf(" ("));
			ICP.infoPropuesta(titulo);
			String evaluacion = null;
			if(rdbtnPublicar.isSelected()) evaluacion = new String("p");
			if(rdbtnCancelar.isSelected()) evaluacion = new String("c");
			if(evaluacion == null)
				JOptionPane.showMessageDialog(this, "Debe elegir una opción", "Evaluar Propuesta", JOptionPane.ERROR_MESSAGE);
			else
				ICP.evaluar(evaluacion);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarPropuestas() {
		ArrayList<DtPropuesta> propuestas = ICP.listarPropuestaPorEstado(TEstado.INGRESADA);
		
		String[] datos = new String[propuestas.size()];
		for(int i = 0; i < propuestas.size(); i++) {
			datos[i] = propuestas.get(i).getTitulo() + " (" + propuestas.get(i).getNickProponente() + ")";
		}
		
		ComboBoxModel<String> modelo = new DefaultComboBoxModel<String>(datos);
		comboBox.setModel(modelo);
	}
}
