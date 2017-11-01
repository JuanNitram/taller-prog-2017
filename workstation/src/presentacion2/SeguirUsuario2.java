package presentacion2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ICtrlUsuario;
import logica.clases.Usuario;
import dataTypes.DtUsuario;

public class SeguirUsuario2 extends JInternalFrame {
	
	private ICtrlUsuario ICU;
	private JComboBox cmbSeguidor;
	private JComboBox cmbSeguido;
	private String seguidortxt;
	private String seguidotxt;
	
	public SeguirUsuario2(ICtrlUsuario iCU) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.ICU = iCU;
		setResizable(false);
		setTitle("Seguir usuario");
		setClosable(true);
		setBounds(100, 100, 355, 268);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{385, 324, 324, 324, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 72, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Seleccione seguidor:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		cmbSeguidor = new JComboBox();
		GridBagConstraints gbc_cmbSeguidor = new GridBagConstraints();
		gbc_cmbSeguidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSeguidor.gridwidth = 5;
		gbc_cmbSeguidor.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSeguidor.gridx = 0;
		gbc_cmbSeguidor.gridy = 1;
		panel.add(cmbSeguidor, gbc_cmbSeguidor);
		cmbSeguidor.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					seguidortxt = (String) cmbSeguidor.getSelectedItem();
					String nickseguidor = seguidortxt.substring(seguidortxt.indexOf("(")+1, seguidortxt.indexOf(")")); 
					
					
					List<DtUsuario> usuarios = ICU.listarUsuarios();
					List<DtUsuario> seguidos = ICU.listarSeguidos(nickseguidor);
					List<String> datosCmb2 = new ArrayList<String>();
					boolean esta = false;
					for(int i = 0 ; i < usuarios.size() ; i++){
						esta = false;
						if(!nickseguidor.equals(usuarios.get(i).getNickName())){ 
							for (int j = 0; j < seguidos.size(); j++){
								if (usuarios.get(i).getNickName() == seguidos.get(j).getNickName())
									esta = true;
							}
							if (!esta)
								datosCmb2.add(ICU.listarUsuarios().get(i).getNombre() + " " + ICU.listarUsuarios().get(i).getApellido() + " (" +  ICU.listarUsuarios().get(i).getNickName()+")");
						}
					}
					String[] datosenstring = new String[datosCmb2.size()];
					for (int h = 0 ; h < datosCmb2.size(); h++)
						datosenstring[h] = datosCmb2.get(h);
					Arrays.sort(datosenstring);
					ComboBoxModel modelo2 = new DefaultComboBoxModel(datosenstring);
					cmbSeguido.setModel(modelo2);
					seguidotxt = cmbSeguido.getItemAt(0).toString();  
					}
				}
			});
		
		
		JLabel label_1 = new JLabel("Seleccione seguido:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 2;
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		panel.add(label_1, gbc_label_1);
		
		cmbSeguido = new JComboBox();
		GridBagConstraints gbc_cmbSeguido = new GridBagConstraints();
		gbc_cmbSeguido.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSeguido.gridwidth = 5;
		gbc_cmbSeguido.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSeguido.gridx = 0;
		gbc_cmbSeguido.gridy = 4;
		panel.add(cmbSeguido, gbc_cmbSeguido);
		cmbSeguido.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					seguidotxt = (String) cmbSeguido.getSelectedItem();
				}
				
			}
		});
		
		JButton button = new JButton("Aceptar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(seguidortxt + " - " + seguidotxt);
				if(!seguidortxt.equals(seguidotxt)){
					ICU.elegirSeguidor(seguidortxt.substring(seguidortxt.indexOf("(")+1, seguidortxt.indexOf(")")));
					ICU.elegirSeguido(seguidotxt.substring(seguidotxt.indexOf("(")+1, seguidotxt.indexOf(")")));
					ICU.seguir();
					JOptionPane.showMessageDialog(null, "El usuario "+seguidortxt+" ahora sigue a "+seguidotxt, 
							"Culturarte",JOptionPane.INFORMATION_MESSAGE);
					
				}
				dispose();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 6;
		panel.add(button, gbc_button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridwidth = 3;
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 6;
		panel.add(button_1, gbc_button_1);

	}
	
	public void cargar(){
		
		String[] datosCmb = new	String[ICU.listarUsuarios().size()];
		for(int i = 0 ; i < ICU.listarUsuarios().size() ; i++)
			datosCmb[i] = ICU.listarUsuarios().get(i).getNombre() + " " + ICU.listarUsuarios().get(i).getApellido() + " (" +  ICU.listarUsuarios().get(i).getNickName()+")";
		Arrays.sort(datosCmb);
		ComboBoxModel modelo = new DefaultComboBoxModel(datosCmb);
		cmbSeguidor.setModel(modelo);
		
		
		seguidortxt = cmbSeguidor.getItemAt(0).toString();
		String nickseguidor = seguidortxt.substring(seguidortxt.indexOf("(")+1, seguidortxt.indexOf(")")); 
		
		List<DtUsuario> usuarios = ICU.listarUsuarios();
		List<DtUsuario> seguidos = ICU.listarSeguidos(nickseguidor);
		List<String> datosCmb2 = new ArrayList<String>();
		boolean esta = false;
		for(int i = 0 ; i < usuarios.size() ; i++){
			esta = false;
			if(!nickseguidor.equals(usuarios.get(i).getNickName())){ 
			for (int j = 0; j < seguidos.size(); j++){
				if (usuarios.get(i).getNickName() == seguidos.get(j).getNickName())
					esta = true;
			}
			if (!esta)
				datosCmb2.add(ICU.listarUsuarios().get(i).getNombre() + " " + ICU.listarUsuarios().get(i).getApellido() + " (" +  ICU.listarUsuarios().get(i).getNickName()+")");
			}
		}
		String[] datosenstring = new String[datosCmb2.size()];
		for (int h = 0 ; h < datosCmb2.size(); h++)
			datosenstring[h] = datosCmb2.get(h);
		Arrays.sort(datosenstring);
		ComboBoxModel modelo2 = new DefaultComboBoxModel(datosenstring);
		cmbSeguido.setModel(modelo2);
		seguidotxt = cmbSeguido.getItemAt(0).toString();  
		
	}
	
}
