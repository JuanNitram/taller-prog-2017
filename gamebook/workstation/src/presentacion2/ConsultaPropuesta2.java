package presentacion2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Logica.ICtrlPropuesta;
import dataTypes.DtPropuesta;

public class ConsultaPropuesta2 extends JInternalFrame {

	private ICtrlPropuesta ICP;
	private VerPropuesta2 verpropuesta2;
	private JList list;
	private JScrollPane scrollPane;
	
	private String[] props;
	private Object[] objs;
	
	public ConsultaPropuesta2(ICtrlPropuesta iCP) {
		this.ICP = iCP;
		
		setTitle("Consulta Propuesta");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 628, 324);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblSeleccioneUnaPropuesta = new JLabel("Seleccione una Propuesta haciendo doble click");
		GridBagConstraints gbc_lblSeleccioneUnaPropuesta = new GridBagConstraints();
		gbc_lblSeleccioneUnaPropuesta.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneUnaPropuesta.gridx = 0;
		gbc_lblSeleccioneUnaPropuesta.gridy = 1;
		panel.add(lblSeleccioneUnaPropuesta, gbc_lblSeleccioneUnaPropuesta);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.gridwidth = 2;
		gbc_btnCerrar.gridx = 0; 
		gbc_btnCerrar.gridy = 3;
		panel.add(btnCerrar, gbc_btnCerrar);
		
		
	}
	
	public void cargarPropuestas() {
		ArrayList<DtPropuesta> array = ICP.listarPropuestas();
		objs = array.toArray();
		props = new String[objs.length];
		DtPropuesta dtP;
		for(int i = 0; i < array.size(); i++) {
			dtP = (DtPropuesta) objs[i];
			props[i] = dtP.getTitulo();
		}
		list = new JList(props);
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					try {
						String titulo = props[list.getSelectedIndex()];
						DtPropuesta dtP = ICP.infoPropuesta(titulo);
						verpropuesta2 = new VerPropuesta2(ICP);
						verpropuesta2.setResizable(false);
		    		  	verpropuesta2.cargarPropuesta(dtP);
		    		  	verpropuesta2.toFront();
		    		  	getParent().add(verpropuesta2);
		    		  	verpropuesta2.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "No se ha podido cargar la propuesta","Culturarte",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

}
