package presentacion2;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dataTypes.DtColaboracion;
import dataTypes.DtColaborador;
import dataTypes.DtPropuesta;
import Logica.ICtrlPropuesta;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;

public class ConsultaColaboracion2 extends JInternalFrame {
	
	private ICtrlPropuesta ICP;
	private JPanel contentPane;
	private JTextField nickNameTextField;
	private JComboBox colaboradoresComboBox;
	private List <DtColaborador> colaboradores; 
	private List<DtColaboracion> colaboraciones;
	private JList colaboracionesList;
	private DefaultListModel model;
	private VerColaboracion2 vercolaboracion2;
	
	public ConsultaColaboracion2(ICtrlPropuesta iCP) {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		setTitle("Consultar colaboraciones");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 488, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.ICP = iCP;
		
		JLabel lblNewLabel = new JLabel("Seleccione colaborador");
		lblNewLabel.setBounds(15, 11, 153, 14);
		contentPane.add(lblNewLabel);
	
		colaboradoresComboBox = new JComboBox();
		colaboradoresComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String nickColaborador = colaboradores.get(colaboradoresComboBox.getSelectedIndex()).getNickName();
				nickNameTextField.setText(nickColaborador);
				colaboraciones = new ArrayList<DtColaboracion>();
				colaboraciones = ICP.listarColaboraciones();
				
				model = new DefaultListModel<String>();
				    for(DtColaboracion d : colaboraciones) {
				    	if(d.getNickname().equals(nickColaborador)) 
				    		model.addElement(d.getTitulo());
				    }
				    colaboracionesList.setModel(model);        
			}
		});
		
		colaboradoresComboBox.setBounds(178, 11, 278, 20);
		contentPane.add(colaboradoresComboBox);
		
		JLabel lblColaboraciones = new JLabel("Colaboraciones");
		lblColaboraciones.setBounds(15, 70, 121, 14);
		contentPane.add(lblColaboraciones);
		
		colaboracionesList = new JList();
		colaboracionesList.setBounds(178, 72, 278, 149);
		contentPane.add(colaboracionesList);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setBounds(15, 45, 121, 14);
		contentPane.add(lblNickname);
		
		nickNameTextField = new JTextField();
		nickNameTextField.setEditable(false);
		nickNameTextField.setBounds(178, 45, 278, 20);
		contentPane.add(nickNameTextField);
		nickNameTextField.setColumns(10);
		
		 
		colaboracionesList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
			    	try {
			    		String tituloProp = colaboracionesList.getSelectedValue().toString();
			    		String nickname = nickNameTextField.getText();
			    		int id = 0;
			    		for(int i = 0; i < colaboraciones.size() && id == 0; i++) {
			    			if(colaboraciones.get(i).getTitulo().equals(tituloProp) && colaboraciones.get(i).getNickname().equals(nickname))
			    				id = colaboraciones.get(i).getId();
			    		}
			    		DtColaboracion dtC = ICP.infoColaboracion(id);
			    		vercolaboracion2 = new VerColaboracion2();
			    		vercolaboracion2.setResizable(false);
			    		getParent().add(vercolaboracion2);
			    		vercolaboracion2.cargarColaboracion(dtC);
			    		vercolaboracion2.setVisible(true);
			    		colaboracionesList.clearSelection();
			    	} catch(Exception ex) {
			    		ex.printStackTrace();
			    	}
				}
			}
		});
	}
	 
	public void cargarDatos() {
		colaboradores = ICP.listarColaboradores();
		DtColaborador dtC;
		colaboradoresComboBox.removeAllItems();
		for(int i = 0; i < colaboradores.size(); i++) {
			dtC = colaboradores.get(i);
			String s = dtC.getNombre() + " " + dtC.getApellido();
			colaboradoresComboBox.addItem(s);
		};
	}
}
