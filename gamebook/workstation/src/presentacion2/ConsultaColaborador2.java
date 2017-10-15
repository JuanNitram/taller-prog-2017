package presentacion2;

import java.awt.GridBagConstraints;


import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Logica.ICtrlUsuario;
import dataTypes.DtColaborador;
import dataTypes.DtProponente;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ConsultaColaborador2 extends JInternalFrame {
	
	private ICtrlUsuario ICU;
	
	private JPanel contentPane;	
	private JScrollPane scrollPane;
	private JList listaColaboradores;
	
	private VerColaborador2 vercolaborador2;
	private JLabel lblSeleccioneUnColaborador;
	private JButton btnAceptar;

	public ConsultaColaborador2(ICtrlUsuario iCU) {
		
		ICU = iCU;
		
		setTitle("Consulta colaborador");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 660, 295);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 0, 30};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		
		
		lblSeleccioneUnColaborador = new JLabel("Seleccione un Colaborador");
		GridBagConstraints gbc_lblSeleccioneUnColaborador = new GridBagConstraints();
		gbc_lblSeleccioneUnColaborador.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneUnColaborador.gridx = 1;
		gbc_lblSeleccioneUnColaborador.gridy = 0;
		contentPane.add(lblSeleccioneUnColaborador, gbc_lblSeleccioneUnColaborador);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		listaColaboradores = new JList();
		scrollPane.setViewportView(listaColaboradores);
		
		btnAceptar = new JButton("Cerrar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 4;
		contentPane.add(btnAceptar, gbc_btnAceptar);
		
	}
	
	public void cargarColaboradores() {
		ArrayList<DtColaborador> colaboradores = ICU.listarColaboradores();
		DtColaborador dtC;
		String[] model = new String[colaboradores.size()];
		for(int i = 0; i < colaboradores.size(); i++) {
			dtC = colaboradores.get(i);
			model[i] = dtC.getNickName();
		}
		
		listaColaboradores = new JList(model);
		scrollPane.setViewportView(listaColaboradores);
		listaColaboradores.addMouseListener(new MouseAdapter() {
		       @Override
		       public void mouseClicked(MouseEvent e) {
		    	   if(e.getClickCount() == 2) {
			    	   try {
			    		   	vercolaborador2 = new VerColaborador2();
			    			vercolaborador2.setResizable(false);
							getParent().add(vercolaborador2);
							DtColaborador dtC = ICU.infoColaborador(listaColaboradores.getSelectedValue().toString());
							vercolaborador2.cargarColaborador(dtC);
							vercolaborador2.setVisible(true);
							vercolaborador2.toFront();
			    	   } catch(Exception ex) {}
			    	   vercolaborador2.setVisible(true);
		    	   }
		       }
		});
	}

}
