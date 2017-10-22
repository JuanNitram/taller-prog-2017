package presentacion2;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;

import dataTypes.DtProponente;
import dataTypes.DtUsuario;
import logica.Fabrica;
import logica.ICtrlUsuario;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

public class VerProponente2 extends JInternalFrame {
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtFechaNac;
	private JTextField txtDireccion;
	private JTextField txtLinkSitio;
	private JTextArea txtBiografia;
	private JScrollPane panelscroll;
	private JLabel imgLabel; 
	private JScrollPane scrollPane;
	private JList listSeguidores;

	public VerProponente2() {
		setTitle("Informacion Proponente");
		setClosable(true);
		setBounds(100, 100, 450, 543);
		
		JPanel panel = new JPanel();
		panel.setEnabled(false);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{164, 95, 95, 79, 0};
		gbl_panel.rowHeights = new int[]{31, 0, 0, 18, 0, 0, 0, 0, 73, 33, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 6.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
		imgLabel = new JLabel("", (Icon) null, SwingConstants.CENTER);
		panel_1.add(imgLabel);
		
		JLabel label_1 = new JLabel("Nickname");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		txtNick = new JTextField("");
		txtNick.setEditable(false);
		txtNick.setColumns(10);
		GridBagConstraints gbc_txtNick = new GridBagConstraints();
		gbc_txtNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNick.gridwidth = 2;
		gbc_txtNick.insets = new Insets(0, 0, 5, 0);
		gbc_txtNick.gridx = 2;
		gbc_txtNick.gridy = 0;
		panel.add(txtNick, gbc_txtNick);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		panel.add(txtNombre, gbc_txtNombre);
		
		JLabel label_3 = new JLabel("Apellido");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 2;
		panel.add(label_3, gbc_label_3);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridwidth = 2;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 2;
		panel.add(txtApellido, gbc_txtApellido);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 4;
		panel.add(label_4, gbc_label_4);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridwidth = 3;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 4;
		panel.add(txtEmail, gbc_txtEmail);
		
		JLabel label_5 = new JLabel("Fecha de nacimiento");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 5;
		panel.add(label_5, gbc_label_5);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setEditable(false);
		txtFechaNac.setColumns(10);
		GridBagConstraints gbc_txtFechaNac = new GridBagConstraints();
		gbc_txtFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaNac.gridwidth = 3;
		gbc_txtFechaNac.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaNac.gridx = 1;
		gbc_txtFechaNac.gridy = 5;
		panel.add(txtFechaNac, gbc_txtFechaNac);
		
		JLabel label_6 = new JLabel("Direccion");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 6;
		panel.add(label_6, gbc_label_6);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridwidth = 3;
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_txtDireccion.gridx = 1;
		gbc_txtDireccion.gridy = 6;
		panel.add(txtDireccion, gbc_txtDireccion);
		
		JLabel label_7 = new JLabel("Link del sitio");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 7;
		panel.add(label_7, gbc_label_7);
		
		txtLinkSitio = new JTextField();
		txtLinkSitio.setEditable(false);
		txtLinkSitio.setColumns(10);
		GridBagConstraints gbc_txtLinkSitio = new GridBagConstraints();
		gbc_txtLinkSitio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLinkSitio.gridwidth = 3;
		gbc_txtLinkSitio.insets = new Insets(0, 0, 5, 0);
		gbc_txtLinkSitio.gridx = 1;
		gbc_txtLinkSitio.gridy = 7;
		panel.add(txtLinkSitio, gbc_txtLinkSitio);
		
		JLabel label_8 = new JLabel("Biografia");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 8;
		panel.add(label_8, gbc_label_8);
		
		
		txtBiografia = new JTextArea();
		txtBiografia.setRows(5);
		txtBiografia.setTabSize(5);
		txtBiografia.setLineWrap(true);
		txtBiografia.setWrapStyleWord(true);
		txtBiografia.setEditable(false);
		txtBiografia.setColumns(1);
		GridBagConstraints gbc_txtBiografia = new GridBagConstraints();
		gbc_txtBiografia.fill = GridBagConstraints.BOTH;
		gbc_txtBiografia.gridwidth = 3;
		gbc_txtBiografia.insets = new Insets(0, 0, 5, 0);
		gbc_txtBiografia.gridx = 1;
		gbc_txtBiografia.gridy = 8;
		panelscroll = new JScrollPane(txtBiografia);
		panelscroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(panelscroll, gbc_txtBiografia);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblSeguidores = new JLabel("Seguidores");
		lblSeguidores.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeguidores.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSeguidores = new GridBagConstraints();
		gbc_lblSeguidores.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSeguidores.gridheight = 3;
		gbc_lblSeguidores.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeguidores.gridx = 0;
		gbc_lblSeguidores.gridy = 9;
		panel.add(lblSeguidores, gbc_lblSeguidores);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		panel.add(scrollPane, gbc_scrollPane);
		
		listSeguidores = new JList();
		scrollPane.setViewportView(listSeguidores);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 12;
		panel.add(btnNewButton, gbc_btnNewButton);

	}
	
	public void cargarProponente(DtProponente dtP) {
			txtNick.setText(dtP.getNickName());
			txtNombre.setText(dtP.getNombre());
			txtApellido.setText(dtP.getApellido());
			txtEmail.setText(dtP.getEmail());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String fechaNac = df.format(dtP.getFechaNacimiento());
			txtFechaNac.setText(fechaNac);
			txtDireccion.setText(dtP.getDireccion());
			txtLinkSitio.setText(dtP.getLinkSitio());
			txtBiografia.setText(dtP.getBiografia());
			txtBiografia.setCaretPosition(0);
			
			String ruta = "imagenes/usuarios/proponentes/" + dtP.getRutaImg();
			File f1 = new File(ruta+".png");
			File f2 = new File(ruta+".jpg");
			if(f1.isFile()) {
				System.out.println("archivo: "+f1.getAbsolutePath());
				 ImageIcon img = new ImageIcon(new ImageIcon(f1.getAbsolutePath())
						  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
				 imgLabel.setIcon(img);
			} else if(f2.isFile()) {
				 ImageIcon img = new ImageIcon(new ImageIcon(f2.getAbsolutePath())
						  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
				 imgLabel.setIcon(img);
			} else {
				 ImageIcon img = new ImageIcon(new ImageIcon("recursos/no_imagen_proponente.png")
						  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
				 imgLabel.setIcon(img);
			}
			
			
			//Seguidores
			ICtrlUsuario ICU = Fabrica.getInstance().getICtrlUsuario();
			List<DtUsuario> array = ICU.listarSeguidores(dtP.getNickName());
			Object[] objs;
			String[] segs;
			objs = array.toArray();
			segs = new String[objs.length];
			DtUsuario dtU;
			for(int i = 0; i < array.size(); i++) {
				dtU = (DtUsuario) objs[i];
				segs[i] = dtU.getNickName();
			}
			listSeguidores = new JList(segs);
			scrollPane.setViewportView(listSeguidores);
		}

	
	}
