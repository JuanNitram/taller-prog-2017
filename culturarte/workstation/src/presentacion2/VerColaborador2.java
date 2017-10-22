package presentacion2;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import dataTypes.DtColaborador;
import dataTypes.DtPropuesta;
import dataTypes.DtUsuario;
import logica.Fabrica;
import logica.ICtrlUsuario;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class VerColaborador2 extends JInternalFrame {
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtFechaNac;
	private JLabel imgLabel;
	private JList listSeguidores;
	private JScrollPane scrollPane;
	
	public VerColaborador2() {
		setClosable(true);
		setTitle("Informacion Colaborador");
		setBounds(100, 100, 502, 420);
		
		JPanel panel = new JPanel();
		panel.setEnabled(false);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{159, 97, 95, 79, 0};
		gbl_panel.rowHeights = new int[]{31, 0, 0, 18, 0, 0, 33, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel imgPanel = new JPanel();
		GridBagConstraints gbc_imgPanel = new GridBagConstraints();
		gbc_imgPanel.fill = GridBagConstraints.BOTH;
		gbc_imgPanel.gridheight = 5;
		gbc_imgPanel.insets = new Insets(0, 0, 5, 5);
		gbc_imgPanel.gridx = 0;
		gbc_imgPanel.gridy = 0;
		panel.add(imgPanel, gbc_imgPanel);
		 
		imgLabel = new JLabel("", null, SwingConstants.CENTER);
		imgPanel.add(imgLabel);
		
		 
		JLabel label_1 = new JLabel("Nickname");
		label_1.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		txtNick = new JTextField();
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
		label_2.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		panel.add(label_2, gbc_label_2);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		panel.add(txtNombre, gbc_txtNombre);
		
		JLabel label_3 = new JLabel("Apellido");
		label_3.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 3;
		panel.add(label_3, gbc_label_3);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridwidth = 2;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 3;
		panel.add(txtApellido, gbc_txtApellido);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 6;
		panel.add(label_4, gbc_label_4);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridwidth = 3;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 6;
		panel.add(txtEmail, gbc_txtEmail);
		
		JLabel label_5 = new JLabel("Fecha de nacimiento");
		label_5.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 7;
		panel.add(label_5, gbc_label_5);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setEditable(false);
		txtFechaNac.setColumns(10);
		GridBagConstraints gbc_txtFechaNac = new GridBagConstraints();
		gbc_txtFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFechaNac.gridwidth = 3;
		gbc_txtFechaNac.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaNac.gridx = 1;
		gbc_txtFechaNac.gridy = 7;
		panel.add(txtFechaNac, gbc_txtFechaNac);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblSeguidores = new JLabel("Seguidores");
		lblSeguidores.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_lblSeguidores = new GridBagConstraints();
		gbc_lblSeguidores.anchor = GridBagConstraints.WEST;
		gbc_lblSeguidores.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeguidores.gridx = 0;
		gbc_lblSeguidores.gridy = 9;
		panel.add(lblSeguidores, gbc_lblSeguidores);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		panel.add(scrollPane, gbc_scrollPane);
		
		listSeguidores = new JList();
		scrollPane.setViewportView(listSeguidores);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 12;
		panel.add(btnNewButton, gbc_btnNewButton);

	}
	
	public void cargarColaborador(DtColaborador dtC) {
		txtNick.setText(dtC.getNickName());
		txtNombre.setText(dtC.getNombre());
		txtApellido.setText(dtC.getApellido());
		txtEmail.setText(dtC.getEmail());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fechaNac = df.format(dtC.getFechaNacimiento());
		txtFechaNac.setText(fechaNac);
		
		String ruta = "imagenes/usuarios/colaboradores/" + dtC.getRutaImg();
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
			 ImageIcon img = new ImageIcon(new ImageIcon("recursos/no_imagen_colaborador.png")
					  .getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
			 imgLabel.setIcon(img);
		}
		
		
		//Seguidores
		ICtrlUsuario ICU = Fabrica.getInstance().getICtrlUsuario();
		List<DtUsuario> array = ICU.listarSeguidores(dtC.getNickName());
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
