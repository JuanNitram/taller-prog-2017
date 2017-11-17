package presentacion2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.ICtrlUsuario;
import logica.clases.Acceso;

public class ControlAcceso extends JInternalFrame {

	private ICtrlUsuario ICU;
	private JTable table;
	
	public ControlAcceso(ICtrlUsuario iCU) {
		
		this.ICU = iCU;
		
		setTitle("Registro de Acceso de Usuarios");
		setClosable(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setMinimumSize(new Dimension(700,250));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 80, 80, 80, 80, 10};
		gbl_panel.rowHeights = new int[]{10, 150, 10, 35};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.gridwidth = 2;
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizar.gridx = 2;
		gbc_btnActualizar.gridy = 3;
		panel.add(btnActualizar, gbc_btnActualizar);
		
		JButton btnCancelar = new JButton("Cerrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 3;
		panel.add(btnCancelar, gbc_btnCancelar);

	}


	public void cargarTabla() {
		ArrayList<Acceso> accesos = ICU.listarAccesos();
		Object[][] data = new String[accesos.size()][5];
		for(int i = 0; i < accesos.size(); i++) {
			data[i][0] = Integer.toString(i+1);
			data[i][1] = accesos.get(i).getIp();
			data[i][2] = accesos.get(i).getUrl();
			data[i][3] = accesos.get(i).getBrowser();
			data[i][4] = accesos.get(i).getSo();
		}
		
	    String[] columnNames = {"#", "IP", "URL", "Browser", "SO"};
	    DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
	    table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		
	}
}
