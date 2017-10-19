package presentacion2;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeModel;

import logica.ICtrlPropuesta;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class SelectCategoria extends JInternalFrame {

	private ICtrlPropuesta ICP;
	public JTree tree;
	private JTextField fieldCategoria;
	
	public SelectCategoria(ICtrlPropuesta iCP) {
		
		this.ICP = iCP;
		
		setTitle("Seleccionar categor\u00EDa");
		setClosable(true);
		setBounds(100, 100, 438, 316);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 80, 80, 80, 80, 10};
		gbl_panel.rowHeights = new int[]{40, 200, 40};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblSeleccioneUnPadre = new JLabel("Seleccione una categor\u00EDa");
		GridBagConstraints gbc_lblSeleccioneUnPadre = new GridBagConstraints();
		gbc_lblSeleccioneUnPadre.gridwidth = 4;
		gbc_lblSeleccioneUnPadre.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneUnPadre.gridx = 1;
		gbc_lblSeleccioneUnPadre.gridy = 0;
		panel.add(lblSeleccioneUnPadre, gbc_lblSeleccioneUnPadre);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		tree = new JTree();
		tree.setModel(new DefaultTreeModel(ICP.listarCategorias()));
		scrollPane.setViewportView(tree);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fieldCategoria.setText(tree.getSelectionPath().getLastPathComponent().toString());
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridwidth = 2;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 2;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 2;
		panel.add(btnCancelar, gbc_btnCancelar);

	}

	public void cargarArbol() {
		tree.setModel(new DefaultTreeModel(ICP.listarCategorias()));
	}

	public void pasarField(JTextField fieldCategoria) {
		this.fieldCategoria = fieldCategoria;
	}
}
