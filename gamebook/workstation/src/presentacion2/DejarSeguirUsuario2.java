package presentacion2;

import java.awt.EventQueue;
import Logica.ICtrlUsuario;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Arrays;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class DejarSeguirUsuario2 extends JInternalFrame {
	
	private ICtrlUsuario ICU;
	private JComboBox cmbUsuario;
	private JComboBox cmbDejarSeguir;
	private String seguidortxt;
	private String seguidotxt;
	
	public DejarSeguirUsuario2(ICtrlUsuario iCU) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent arg0) {
				cmbDejarSeguir.removeAllItems();
			}
		});
		setTitle("Dejar de seguir usuario");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.ICU = iCU;
		setResizable(false);
		setBounds(100, 100, 390, 225);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{385, 0};
		gbl_panel.rowHeights = new int[]{0, 72, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblUsuario = new JLabel("Elige un usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		cmbUsuario = new JComboBox();
		GridBagConstraints gbc_cmbUsuario = new GridBagConstraints();
		gbc_cmbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_cmbUsuario.gridx = 0;
		gbc_cmbUsuario.gridy = 1;
		panel.add(cmbUsuario, gbc_cmbUsuario);
		/// Muestro si el usuario hace clic
		cmbUsuario.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {
					seguidortxt = (String) cmbUsuario.getSelectedItem();
					String nickseguidor = seguidortxt.substring(seguidortxt.indexOf("(")+1, seguidortxt.indexOf(")")); 
					if (ICU.listarSeguidos(nickseguidor) != null){
						String[] datosCmb2 = new String[ICU.listarSeguidos(nickseguidor).size()];
						for(int i = 0 ; i < ICU.listarSeguidos(nickseguidor).size() ; i++)
							datosCmb2[i] = ICU.listarSeguidos(nickseguidor).get(i).getNombre() + " " + ICU.listarSeguidos(nickseguidor).get(i).getApellido() + " (" +  ICU.listarSeguidos(nickseguidor).get(i).getNickName()+")";
						Arrays.sort(datosCmb2);
						ComboBoxModel modelo2 = new DefaultComboBoxModel(datosCmb2);
						cmbDejarSeguir.setModel(modelo2);
					}else JOptionPane.showMessageDialog(null,"El usuario "+ seguidortxt + " no tiene seguidores.","Culturarte",
							JOptionPane.WARNING_MESSAGE);
		            
				}
				
			}
		});
		
		JLabel lblUsuarioADejar = new JLabel("Elige el usuario a dejar de seguir:");
		lblUsuarioADejar.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblUsuarioADejar = new GridBagConstraints();
		gbc_lblUsuarioADejar.anchor = GridBagConstraints.WEST;
		gbc_lblUsuarioADejar.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsuarioADejar.gridx = 0;
		gbc_lblUsuarioADejar.gridy = 2;
		panel.add(lblUsuarioADejar, gbc_lblUsuarioADejar);
		
		cmbDejarSeguir = new JComboBox();
		GridBagConstraints gbc_cmbDejarSeguir = new GridBagConstraints();
		gbc_cmbDejarSeguir.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDejarSeguir.insets = new Insets(0, 0, 5, 0);
		gbc_cmbDejarSeguir.gridx = 0;
		gbc_cmbDejarSeguir.gridy = 3;
		panel.add(cmbDejarSeguir, gbc_cmbDejarSeguir);
		cmbDejarSeguir.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					seguidotxt = cmbDejarSeguir.getSelectedItem().toString();
				}
				
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usrSeguidor = seguidortxt.substring(seguidortxt.indexOf("(")+1, seguidortxt.indexOf(")")); 
				String usrDejarSeguir = seguidotxt.substring(seguidotxt.indexOf("(")+1, seguidotxt.indexOf(")")); 
				System.out.println(usrSeguidor + " - " + usrDejarSeguir);
				if(usrDejarSeguir == null) {
					JOptionPane.showMessageDialog(null, "El usuario "+seguidortxt+" no sigue ning�n usuario.", "Culturarte",
							JOptionPane.WARNING_MESSAGE);
				} else {
					ICU.elegirSeguidor(usrSeguidor);
					ICU.elegirSeguido(usrDejarSeguir);
					ICU.dejarSeguir();
					cmbDejarSeguir.removeAllItems();
					JOptionPane.showMessageDialog(null, "El usuario "+seguidortxt+" ya no sigue a "+seguidotxt,
							"Culturarte", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				
				
				
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 5;
		panel.add(btnAceptar, gbc_btnAceptar);
		
	}
	
	public void cargar(){
		String[] datosCmb = new	String[ICU.listarUsuarios().size()];
		for(int i = 0 ; i < ICU.listarUsuarios().size() ; i++)
			datosCmb[i] = ICU.listarUsuarios().get(i).getNombre() + " " + ICU.listarUsuarios().get(i).getApellido() + " (" +  ICU.listarUsuarios().get(i).getNickName()+")";
		Arrays.sort(datosCmb);
		ComboBoxModel modelo = new DefaultComboBoxModel(datosCmb);
		cmbUsuario.setModel(modelo);
		
		
		// El primero siempre lo muestro
		seguidortxt = cmbUsuario.getItemAt(0).toString();
		String nickseguidor = seguidortxt.substring(seguidortxt.indexOf("(")+1, seguidortxt.indexOf(")")); 
		if (ICU.listarSeguidos(nickseguidor) != null){
			String[] datosCmb2 = new String[ICU.listarSeguidos(nickseguidor).size()];
			for(int i = 0 ; i < ICU.listarSeguidos(nickseguidor).size() ; i++)
				datosCmb2[i] = ICU.listarSeguidos(nickseguidor).get(i).getNombre() + " " + ICU.listarSeguidos(nickseguidor).get(i).getApellido() + " (" +  ICU.listarSeguidos(nickseguidor).get(i).getNickName()+")";
			Arrays.sort(datosCmb2);
			ComboBoxModel modelo2 = new DefaultComboBoxModel(datosCmb2);
			cmbDejarSeguir.setModel(modelo2);
			
			seguidotxt = cmbDejarSeguir.getItemAt(0).toString();
			
			
		}
		
		
		
		
		
	}
}

