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
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logica.ICtrlPropuesta;
import dataTypes.DtPropuesta;
import dataTypes.TEstado;

import javax.swing.JComboBox;

public class ConsultaPropuestaPorEstado extends JInternalFrame {

	private ICtrlPropuesta ICP;
	private VerPropuesta2 verpropuesta2;
	private JList list;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	
	private String[] props;
	private Object[] objs;
	
	public ConsultaPropuestaPorEstado(ICtrlPropuesta iCP) {
		this.ICP = iCP;
		
		setTitle("Consultar Propuesta por Estado");
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 466, 324);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 15, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 21, 26, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblSeleccioneUnEstado = new JLabel("Seleccione un estado");
		GridBagConstraints gbc_lblSeleccioneUnEstado = new GridBagConstraints();
		gbc_lblSeleccioneUnEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneUnEstado.gridx = 1;
		gbc_lblSeleccioneUnEstado.gridy = 1;
		panel.add(lblSeleccioneUnEstado, gbc_lblSeleccioneUnEstado);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblSeleccioneUnaPropuesta = new JLabel("Seleccione una propuesta");
		GridBagConstraints gbc_lblSeleccioneUnaPropuesta = new GridBagConstraints();
		gbc_lblSeleccioneUnaPropuesta.gridwidth = 3;
		gbc_lblSeleccioneUnaPropuesta.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneUnaPropuesta.gridx = 1;
		gbc_lblSeleccioneUnaPropuesta.gridy = 3;
		panel.add(lblSeleccioneUnaPropuesta, gbc_lblSeleccioneUnaPropuesta);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		panel.add(scrollPane, gbc_scrollPane);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.gridwidth = 5;
		gbc_btnCerrar.gridx = 0; 
		gbc_btnCerrar.gridy = 5;
		panel.add(btnCerrar, gbc_btnCerrar);
		
		
	}
	
	public void cargarDatos() {
		List<String> estados = ICP.listarEstados();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { estados.get(0), estados.get(1), estados.get(2), estados.get(3), estados.get(4), estados.get(5)}));
		List<DtPropuesta> array = ICP.listarPropuestaPorEstado(TEstado.INGRESADA);
		objs = array.toArray();
		props = new String[objs.length];
		DtPropuesta dtP;
		for(int i = 0; i < array.size(); i++) {
			dtP = (DtPropuesta) objs[i];
			props[i] = dtP.getTitulo();
		}
		list = new JList(props);
		scrollPane.setViewportView(list);
		
		comboBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				list = new JList();
				TEstado estado;
				switch(comboBox.getSelectedItem().toString()) {
				case "Ingresada":
					estado = TEstado.INGRESADA;
					break;
				case "Publicada":
					estado = TEstado.PUBLICADA;
					break;
				case "En financiaci�n":
					estado = TEstado.EN_FINANCIACION;
					break;
				case "Financiada":
					estado = TEstado.FINANCIADA;
					break;
				case "No financiada":
					estado = TEstado.NO_FINANCIADA;
					break;
				default:
					estado = TEstado.CANCELADA;
					break;
				}
				List<DtPropuesta> array = ICP.listarPropuestaPorEstado(estado);
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
			
		});
		
		
	}

}
