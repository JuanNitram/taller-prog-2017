package presentacion2;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import logica.ICtrlPropuesta;

public class AltaCategoria extends JInternalFrame {

	private ICtrlPropuesta ICP;
	private JTextField fieldCategoria;
	private JTree tree;
	
	public AltaCategoria(ICtrlPropuesta iCP) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarCampos();
			}
		});
		
		this.ICP = iCP;
		
		setTitle("Crear Categoría");
		setClosable(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 449, 321);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 80, 80, 80, 80, 10};
		gbl_panel.rowHeights = new int[]{30, 149, 26, 37};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblSeleccioneUnPadre = new JLabel("Seleccione un padre para la categor\u00EDa");
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
		
		JLabel lblIngreseUnNombre = new JLabel("Ingrese un nombre:");
		GridBagConstraints gbc_lblIngreseUnNombre = new GridBagConstraints();
		gbc_lblIngreseUnNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseUnNombre.anchor = GridBagConstraints.EAST;
		gbc_lblIngreseUnNombre.gridx = 1;
		gbc_lblIngreseUnNombre.gridy = 2;
		panel.add(lblIngreseUnNombre, gbc_lblIngreseUnNombre);
		
		fieldCategoria = new JTextField();
		GridBagConstraints gbc_fieldCategoria = new GridBagConstraints();
		gbc_fieldCategoria.gridwidth = 3;
		gbc_fieldCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_fieldCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCategoria.gridx = 2;
		gbc_fieldCategoria.gridy = 2;
		panel.add(fieldCategoria, gbc_fieldCategoria);
		fieldCategoria.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldCategoria.getText().trim().isEmpty()) JOptionPane.showMessageDialog(null, "Ingrese un nombre para la categoría", "Culturarte - Crear categoría", JOptionPane.ERROR_MESSAGE);
				else {
					fieldCategoria.setText(fieldCategoria.getText().trim());
					crearCategoria();
					setVisible(false);
					limpiarCampos();
				}
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridwidth = 2;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 3;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fieldCategoria.setText("");
				setVisible(false);
				limpiarCampos();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 3;
		panel.add(btnCancelar, gbc_btnCancelar);

	}

	protected void limpiarCampos() {
		fieldCategoria.setText(null);
	}

	protected void crearCategoria() {
		String nombreCat = fieldCategoria.getText();
		TreePath ruta = tree.getSelectionPath();
		ICP.crearCategoria(ruta,nombreCat);
	}

	public void cargarArbol() {
		tree.setModel(new DefaultTreeModel(ICP.listarCategorias()));
	}
}
