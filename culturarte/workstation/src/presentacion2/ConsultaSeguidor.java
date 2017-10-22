package presentacion2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import logica.ICtrlUsuario;
import dataTypes.DtUsuario;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaSeguidor extends JInternalFrame {

	private ICtrlUsuario ICU;
	private JComboBox comboBox;
	private JList list;
	private JButton btnNewButton;
	private JLabel lblSeguidores_1;
	
	public ConsultaSeguidor(ICtrlUsuario iCU) {
		setClosable(true);
		this.ICU = iCU;
		setTitle("Consulta seguidor");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{113, 0, 175, 0};
		gridBagLayout.rowHeights = new int[]{39, 5, 29, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("Seleccione seguidor:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		getContentPane().add(label, gbc_label);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String textocombo = (String) comboBox.getSelectedItem();
					String dentroParent = textocombo.substring(textocombo.indexOf("(")+1, textocombo.indexOf(")")); 
					if (ICU.listarSeguidos(dentroParent) != null){
		            String[] datosCmb2 = new String[ICU.listarSeguidos(dentroParent).size()];
		            for(int i = 0 ; i < ICU.listarSeguidos(dentroParent).size() ; i++)
		            	datosCmb2[i] = (ICU.listarSeguidos(dentroParent).get(i).getNombre() + " " + ICU.listarSeguidos(dentroParent).get(i).getApellido() + " (" +  ICU.listarSeguidos(dentroParent).get(i).getNickName()+")");
		            Arrays.sort(datosCmb2);
		            ComboBoxModel modelo2 = new DefaultComboBoxModel(datosCmb2);
		    		list.setModel(modelo2);
					}else 
						JOptionPane.showMessageDialog(null,"El usuario "+ textocombo + " no tiene seguidores.","Culturarte",
								JOptionPane.WARNING_MESSAGE);
		             
				}
			}
		});
		
		JLabel lblSeguidores = new JLabel("Seguidores:");
		lblSeguidores.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSeguidores = new GridBagConstraints();
		gbc_lblSeguidores.anchor = GridBagConstraints.WEST;
		gbc_lblSeguidores.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeguidores.gridx = 0;
		gbc_lblSeguidores.gridy = 2;
		
		lblSeguidores_1 = new JLabel("Seguidores:");
		lblSeguidores_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSeguidores_1 = new GridBagConstraints();
		gbc_lblSeguidores_1.anchor = GridBagConstraints.WEST;
		gbc_lblSeguidores_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeguidores_1.gridx = 0;
		gbc_lblSeguidores_1.gridy = 2;
		getContentPane().add(lblSeguidores_1, gbc_lblSeguidores_1);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridwidth = 3;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 3;
		getContentPane().add(list, gbc_list);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		getContentPane().add(btnNewButton, gbc_btnNewButton);

	}
	public void cargar(){
		
		String[] datosCmb = new	String[ICU.listarUsuarios().size()];
		for(int i = 0 ; i < ICU.listarUsuarios().size() ; i++)
			datosCmb[i] = ICU.listarUsuarios().get(i).getNombre() + " " + ICU.listarUsuarios().get(i).getApellido() + " (" +  ICU.listarUsuarios().get(i).getNickName()+")";
		Arrays.sort(datosCmb);
		ComboBoxModel modelo = new DefaultComboBoxModel(datosCmb);
		comboBox.setModel(modelo);
		
		/// Muestro el primero default
		String textocombo = comboBox.getItemAt(0).toString();
		String dentroParent = textocombo.substring(textocombo.indexOf("(")+1, textocombo.indexOf(")")); 
		if (ICU.listarSeguidos(dentroParent) != null){
        String[] datosCmb2 = new String[ICU.listarSeguidos(dentroParent).size()];
        for(int i = 0 ; i < ICU.listarSeguidos(dentroParent).size() ; i++)
        	datosCmb2[i] = (ICU.listarSeguidos(dentroParent).get(i).getNombre() + " " + ICU.listarSeguidos(dentroParent).get(i).getApellido() + " (" +  ICU.listarSeguidos(dentroParent).get(i).getNickName()+")");
        Arrays.sort(datosCmb2);
        ComboBoxModel modelo2 = new DefaultComboBoxModel(datosCmb2);
		list.setModel(modelo2);
		}
		
		
		
		
	}

}
