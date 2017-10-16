package presentacion2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Logica.ICtrlPropuesta;
import dataTypes.DtColaboracion;
import dataTypes.DtPropuesta;
import dataTypes.TRetorno;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class VerPropuesta2 extends JInternalFrame {
	private JTextField txtTitulo;
	private JTextField txtLugar;
	private JTextField txtMonto;
	private JTextField txtProponente;
	private JTextField txtFechaPublicacion;
	private JTextField txtFechaRealizacion;
	private JTextField txtPrecio;
	private JTextField txtRetorno;
	private JList colaboracionesList;
	private VerColaboracion2 vercolaboracion2;
	private ICtrlPropuesta ICP;
	private List<DtColaboracion> colaboraciones;
	private JTextField txtCategoria;
	private JLabel imgLabel;
	private JTextField montoreunidotxt;
	private JTextArea biografia;
	
	
	public VerPropuesta2(ICtrlPropuesta ICP) {
		setTitle("Informacion Propuesta");
		setClosable(true);
		setBounds(100, 100, 481, 562);
		
		this.ICP = ICP;
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{146, 107, 0, 103, 145, 0};
		gbl_panel.rowHeights = new int[]{40, 0, 12, 25, 24, 29, 0, 0, 0, 0, 25, 55, 0, 91, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel((LayoutManager) null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout());
		
		imgLabel = new JLabel("");
		panel_1.add(imgLabel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Titulo");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		txtTitulo = new JTextField("");
		txtTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		txtTitulo.setEditable(false);
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.gridwidth = 2;
		gbc_txtTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_txtTitulo.gridx = 3;
		gbc_txtTitulo.gridy = 0;
		panel.add(txtTitulo, gbc_txtTitulo);
		
		JLabel label_1 = new JLabel("Lugar");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		txtLugar = new JTextField();
		txtLugar.setHorizontalAlignment(SwingConstants.LEFT);
		txtLugar.setEditable(false);
		txtLugar.setColumns(30);
		GridBagConstraints gbc_txtLugar = new GridBagConstraints();
		gbc_txtLugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLugar.gridwidth = 2;
		gbc_txtLugar.insets = new Insets(0, 0, 5, 0);
		gbc_txtLugar.gridx = 3;
		gbc_txtLugar.gridy = 1;
		panel.add(txtLugar, gbc_txtLugar);
		
		JLabel label_2 = new JLabel("Monto a reunir");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.gridwidth = 2;
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);
		
		txtMonto = new JTextField();
		txtMonto.setEditable(false);
		txtMonto.setColumns(10);
		GridBagConstraints gbc_txtMonto = new GridBagConstraints();
		gbc_txtMonto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMonto.gridwidth = 2;
		gbc_txtMonto.insets = new Insets(0, 0, 5, 0);
		gbc_txtMonto.gridx = 3;
		gbc_txtMonto.gridy = 2;
		panel.add(txtMonto, gbc_txtMonto);
		
		JLabel lblMontoReunido = new JLabel("Monto reunido");
		lblMontoReunido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMontoReunido.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblMontoReunido = new GridBagConstraints();
		gbc_lblMontoReunido.anchor = GridBagConstraints.WEST;
		gbc_lblMontoReunido.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontoReunido.gridx = 1;
		gbc_lblMontoReunido.gridy = 3;
		panel.add(lblMontoReunido, gbc_lblMontoReunido);
		
		montoreunidotxt = new JTextField();
		montoreunidotxt.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 3;
		panel.add(montoreunidotxt, gbc_textField);
		montoreunidotxt.setColumns(10);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCategora = new GridBagConstraints();
		gbc_lblCategora.anchor = GridBagConstraints.WEST;
		gbc_lblCategora.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategora.gridx = 0;
		gbc_lblCategora.gridy = 4;
		panel.add(lblCategora, gbc_lblCategora);
		
		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setColumns(10);
		GridBagConstraints gbc_txtCategoria = new GridBagConstraints();
		gbc_txtCategoria.gridwidth = 4;
		gbc_txtCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_txtCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCategoria.gridx = 1;
		gbc_txtCategoria.gridy = 4;
		panel.add(txtCategoria, gbc_txtCategoria);
		
		JLabel label_3 = new JLabel("Proponente");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 5;
		panel.add(label_3, gbc_label_3);
		
		txtProponente = new JTextField();
		txtProponente.setEditable(false);
		txtProponente.setColumns(10);
		GridBagConstraints gbc_txtProponente = new GridBagConstraints();
		gbc_txtProponente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProponente.gridwidth = 4;
		gbc_txtProponente.insets = new Insets(0, 0, 5, 0);
		gbc_txtProponente.gridx = 1;
		gbc_txtProponente.gridy = 5;
		panel.add(txtProponente, gbc_txtProponente);
		
		JLabel label_4 = new JLabel("Fecha publicacion");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 6;
		panel.add(label_4, gbc_label_4);
		
		txtFechaPublicacion = new JTextField();
		txtFechaPublicacion.setHorizontalAlignment(SwingConstants.LEFT);
		txtFechaPublicacion.setEditable(false);
		txtFechaPublicacion.setColumns(10);
		GridBagConstraints gbc_txtFechaPublicacion = new GridBagConstraints();
		gbc_txtFechaPublicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaPublicacion.gridwidth = 4;
		gbc_txtFechaPublicacion.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaPublicacion.gridx = 1;
		gbc_txtFechaPublicacion.gridy = 6;
		panel.add(txtFechaPublicacion, gbc_txtFechaPublicacion);
		
		JLabel label_5 = new JLabel("Fecha realizacion");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 7;
		panel.add(label_5, gbc_label_5);
		
		txtFechaRealizacion = new JTextField();
		txtFechaRealizacion.setHorizontalAlignment(SwingConstants.LEFT);
		txtFechaRealizacion.setEditable(false);
		txtFechaRealizacion.setColumns(10);
		GridBagConstraints gbc_txtFechaRealizacion = new GridBagConstraints();
		gbc_txtFechaRealizacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaRealizacion.gridwidth = 4;
		gbc_txtFechaRealizacion.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaRealizacion.gridx = 1;
		gbc_txtFechaRealizacion.gridy = 7;
		panel.add(txtFechaRealizacion, gbc_txtFechaRealizacion);
		
		JLabel label_6 = new JLabel("Precio entrada");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 8;
		panel.add(label_6, gbc_label_6);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridwidth = 4;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_txtPrecio.gridx = 1;
		gbc_txtPrecio.gridy = 8;
		panel.add(txtPrecio, gbc_txtPrecio);
		
		JLabel label_7 = new JLabel("Tipo de retorno");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 9;
		panel.add(label_7, gbc_label_7);
		
		txtRetorno = new JTextField();
		txtRetorno.setEditable(false);
		txtRetorno.setColumns(10);
		GridBagConstraints gbc_txtRetorno = new GridBagConstraints();
		gbc_txtRetorno.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRetorno.gridwidth = 4;
		gbc_txtRetorno.insets = new Insets(0, 0, 5, 0);
		gbc_txtRetorno.gridx = 1;
		gbc_txtRetorno.gridy = 9;
		panel.add(txtRetorno, gbc_txtRetorno);
		
		JLabel lblBiografia = new JLabel("Biografia");
		lblBiografia.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBiografia = new GridBagConstraints();
		gbc_lblBiografia.anchor = GridBagConstraints.WEST;
		gbc_lblBiografia.insets = new Insets(0, 0, 5, 5);
		gbc_lblBiografia.gridx = 0;
		gbc_lblBiografia.gridy = 10;
		panel.add(lblBiografia, gbc_lblBiografia);
		

		biografia = new JTextArea();
		biografia.setRows(5);
		biografia.setTabSize(5);
		biografia.setLineWrap(true);
		biografia.setWrapStyleWord(true);
		biografia.setEditable(false);
		biografia.setColumns(1);
		
		JScrollPane scrollPane_1 = new JScrollPane(biografia);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 10;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		JLabel lblColaboraciones = new JLabel("Colaboradores");
		lblColaboraciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblColaboraciones = new GridBagConstraints();
		gbc_lblColaboraciones.anchor = GridBagConstraints.WEST;
		gbc_lblColaboraciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblColaboraciones.gridx = 0;
		gbc_lblColaboraciones.gridy = 12;
		panel.add(lblColaboraciones, gbc_lblColaboraciones);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 13;
		panel.add(scrollPane, gbc_scrollPane);
		
		colaboracionesList = new JList();
		colaboracionesList.setVisibleRowCount(5);
		colaboracionesList.setValueIsAdjusting(true);
		colaboracionesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		colaboracionesList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		colaboracionesList.setSelectedIndex(1);
		scrollPane.setColumnHeaderView(colaboracionesList);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridwidth = 3;
		gbc_btnCerrar.gridx = 1;
		gbc_btnCerrar.gridy = 14;
		panel.add(btnCerrar, gbc_btnCerrar);

	}
	
	public void cargarPropuesta(DtPropuesta dtP) {
		txtTitulo.setText(dtP.getTitulo());
		txtLugar.setText(dtP.getLugar());
		txtCategoria.setText(dtP.getCategoria().getNombre());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String fechaPub = (dtP.getFechaPublicacion() != null)?df.format(dtP.getFechaPublicacion()):"No se ha publicado";
		String fechaRealiz = df.format(dtP.getFechaRealizacion());
		txtFechaPublicacion.setText(fechaPub);
		txtFechaRealizacion.setText(fechaRealiz);
		txtMonto.setText("" + dtP.getMontoRequerido());
		txtPrecio.setText(String.valueOf(dtP.getPrecioEntrada()));
		txtProponente.setText(dtP.getNickProponente());
		biografia.setText(dtP.getDescripcion());
		biografia.setCaretPosition(0);
		if(dtP.getTipoRetorno() == TRetorno.ENTRADA_GRATIS)
			txtRetorno.setText("Entradas gratis");
		else if(dtP.getTipoRetorno() == TRetorno.PORCENTAJE_GANANCIA)
			txtRetorno.setText("Porcentaje de ganancia");
		else
			txtRetorno.setText("Porcentaje de ganancia y Entradas gratis");
		
		
		colaboraciones = new ArrayList<DtColaboracion>();
		colaboraciones = ICP.listarColaboraciones();
		float totalreunido=0;
		DefaultListModel model = new DefaultListModel<String>();
	    montoreunidotxt.setText("" + dtP.getMontoReunido());
		colaboracionesList.setModel(model);
		colaboracionesList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					try {
						String nickname = colaboracionesList.getSelectedValue().toString();
						int id = 0;
						for(int i = 0; i < colaboraciones.size() && id == 0; i++) {
							DtColaboracion d = colaboraciones.get(i);
					    	if(d.getNickname().equals(nickname))
					    		id = d.getId();
					    }
						DtColaboracion dtC = ICP.infoColaboracion(id);
						vercolaboracion2 = new VerColaboracion2();
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
	 
		  //Carga la imagen
		String ruta = "imagenes/propuestas/"+dtP.getRutaImg();
		File f1 = new File(ruta+".png");
		File f2 = new File(ruta+".jpg");
		if(f1.isFile()) {
			 ImageIcon img = new ImageIcon(new ImageIcon(f1.getAbsolutePath())
					  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
			 imgLabel.setIcon(img);
		} else if(f2.isFile()) {
			 ImageIcon img = new ImageIcon(new ImageIcon(f2.getAbsolutePath())
					  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
			 imgLabel.setIcon(img);
		} else {
			 ImageIcon img = new ImageIcon(new ImageIcon("recursos/no_imagen_propuesta.png")
					  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
			 imgLabel.setIcon(img);
		}
	}
	 
}


