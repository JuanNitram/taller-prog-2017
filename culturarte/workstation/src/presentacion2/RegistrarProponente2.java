package presentacion2;

import java.awt.EventQueue;

import logica.ICtrlUsuario;
import utils.ValidarEmail;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class RegistrarProponente2 extends JInternalFrame {
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JTextField txtLinkSitio;
	private JDateChooser txtFechaNac;
	private JTextArea txtBiografia;
	private ICtrlUsuario ICU;
	private ValidarEmail validar;
	
	private boolean customImg;
	private JLabel lblImageLabel;
	private File archivoDestino;
	private JPanel imgPanel;
	private JPasswordField contr;
	private JPasswordField rptcontr;
	
	
	public RegistrarProponente2(ICtrlUsuario iCU) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarCampos();
			}
		});
		
		this.ICU = iCU;
		
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 499, 397);
		
		JPanel panel = new JPanel();
		panel.setEnabled(false);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{127, 95, 95, 79, 0};
		gbl_panel.rowHeights = new int[]{31, 0, 0, 18, 0, 0, 0, 0, 0, 73, 33, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 6.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		imgPanel = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridheight = 5;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(imgPanel, gbc_panel_1);
		

		ImageIcon image = new ImageIcon("recursos/addpicture.png");
		lblImageLabel = new JLabel("", image, SwingConstants.CENTER);
		imgPanel.add(lblImageLabel, BorderLayout.NORTH); 
		imgPanel.setToolTipText("Agrega una nueva imagen de perfil de proponente"); 
		customImg = false;
		
		imgPanel.add(lblImageLabel, BorderLayout.NORTH);
		
		imgPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				 setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				 fileChooser.setAcceptAllFileFilterUsed(false);
				 fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png"));
		            int returnValue = fileChooser.showOpenDialog(null);
		            if (returnValue == JFileChooser.APPROVE_OPTION) {
		            	  File selectedFile = fileChooser.getSelectedFile();
		            	  archivoDestino = new File("imagenes/usuarios/proponentes/tmp."+selectedFile.getName()
		            	  		.substring(selectedFile.getName().lastIndexOf(".") + 1));	//obtiene la extensiÃ³n
		            	  archivoDestino.mkdirs();
		            	  try {
		            		  Files.copy(selectedFile.toPath(),archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
		            		  ImageIcon img = new ImageIcon(new ImageIcon(archivoDestino.getAbsolutePath())
		            				  .getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		            		 
		            		  lblImageLabel.setIcon(img);
		            		  customImg = true;
		            		  } catch (IOException ioe) {
		            			  //Establece una imagen predeterminada del sistema
		            			  lblImageLabel.setIcon(new ImageIcon("recursos/no_imagen_proponente"));
		            			  customImg = false;
		            	  }
		            }
				
			}
		});
		
		JLabel label_1 = new JLabel("Nickname");
		label_1.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		txtNick = new JTextField("");
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
		gbc_label_2.gridy = 1;
		panel.add(label_2, gbc_label_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		panel.add(txtNombre, gbc_txtNombre);
		
		JLabel label_3 = new JLabel("Apellido");
		label_3.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 2;
		panel.add(label_3, gbc_label_3);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridwidth = 2;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 2;
		panel.add(txtApellido, gbc_txtApellido);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 3;
		panel.add(lblContrasea, gbc_lblContrasea);
		
		contr = new JPasswordField();
		GridBagConstraints gbc_contr = new GridBagConstraints();
		gbc_contr.gridwidth = 2;
		gbc_contr.insets = new Insets(0, 0, 5, 5);
		gbc_contr.fill = GridBagConstraints.HORIZONTAL;
		gbc_contr.gridx = 2;
		gbc_contr.gridy = 3;
		panel.add(contr, gbc_contr);
		contr.setColumns(10);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a");
		lblRepetirContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblRepetirContrasea = new GridBagConstraints();
		gbc_lblRepetirContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblRepetirContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepetirContrasea.gridx = 1;
		gbc_lblRepetirContrasea.gridy = 4;
		panel.add(lblRepetirContrasea, gbc_lblRepetirContrasea);
		
		rptcontr = new JPasswordField();
		GridBagConstraints gbc_rptcontr = new GridBagConstraints();
		gbc_rptcontr.gridwidth = 2;
		gbc_rptcontr.insets = new Insets(0, 0, 5, 5);
		gbc_rptcontr.fill = GridBagConstraints.HORIZONTAL;
		gbc_rptcontr.gridx = 2;
		gbc_rptcontr.gridy = 4;
		panel.add(rptcontr, gbc_rptcontr);
		rptcontr.setColumns(10);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 5;
		panel.add(label_4, gbc_label_4);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridwidth = 3;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 5;
		panel.add(txtEmail, gbc_txtEmail);
		
		JLabel label_5 = new JLabel("Fecha de nacimiento");
		label_5.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 6;
		panel.add(label_5, gbc_label_5);
		
		txtFechaNac = new JDateChooser();
		GridBagConstraints gbc_txtFechaNac = new GridBagConstraints();
		gbc_txtFechaNac.gridwidth = 3;
		gbc_txtFechaNac.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaNac.fill = GridBagConstraints.BOTH;
		gbc_txtFechaNac.gridx = 1;
		gbc_txtFechaNac.gridy = 6;
		txtFechaNac.getDateEditor().setEnabled(false);
		panel.add(txtFechaNac, gbc_txtFechaNac);
		
		JLabel label_6 = new JLabel("Direccion");
		label_6.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 7;
		panel.add(label_6, gbc_label_6);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridwidth = 3;
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_txtDireccion.gridx = 1;
		gbc_txtDireccion.gridy = 7;
		panel.add(txtDireccion, gbc_txtDireccion);
		
		JLabel label_7 = new JLabel("Link del sitio");
		label_7.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 8;
		panel.add(label_7, gbc_label_7);
		
		txtLinkSitio = new JTextField();
		txtLinkSitio.setColumns(10);
		GridBagConstraints gbc_txtLinkSitio = new GridBagConstraints();
		gbc_txtLinkSitio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLinkSitio.gridwidth = 3;
		gbc_txtLinkSitio.insets = new Insets(0, 0, 5, 0);
		gbc_txtLinkSitio.gridx = 1;
		gbc_txtLinkSitio.gridy = 8;
		panel.add(txtLinkSitio, gbc_txtLinkSitio);
		
		JLabel label_8 = new JLabel("Biografia");
		label_8.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 9;
		panel.add(label_8, gbc_label_8);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar = new ValidarEmail();
				String ruta = "";
				if(txtNick.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe ingresar el NickName");
				else if(txtNombre.getText().trim().isEmpty())
					 JOptionPane.showMessageDialog(null, "Debe ingresar el Nombre");
				else if(txtApellido.getText().trim().isEmpty())
					 JOptionPane.showMessageDialog(null, "Debe ingresar el Apellido");
				else if(txtEmail.getText().trim().isEmpty())
					 JOptionPane.showMessageDialog(null, "Debe ingresar el Email");
				else if(txtFechaNac.getDate() == null)
					 JOptionPane.showMessageDialog(null, "Debe ingresar una Fecha");
				else if(txtDireccion.getText().trim().isEmpty())
					 JOptionPane.showMessageDialog(null, "Debe ingresar una Direccion");
				else if(txtLinkSitio.getText().trim().isEmpty())
					 JOptionPane.showMessageDialog(null, "Debe ingresar un Link a un Sitio");
				else if(ICU.existeUsuario(txtNick.getText().toString().trim(), txtEmail.getText().toString().trim()))
					JOptionPane.showMessageDialog(null, "Ya existe un proponente registrado con el mismo nick","Culturarte",
							JOptionPane.WARNING_MESSAGE);
				else if(!Arrays.equals(contr.getPassword(), rptcontr.getPassword()))
				JOptionPane.showMessageDialog(null, "Sus contraseñas no coinciden","Culturarte",
						JOptionPane.WARNING_MESSAGE);
				else{
					if(customImg) ruta = txtNick.getText().toString().trim().hashCode() + "";
					ICU.altaProponente(txtNick.getText().trim(),contr.getPassword().toString(), txtNombre.getText().trim(), txtApellido.getText().trim(), txtDireccion.getText().trim(), txtEmail.getText().trim(), txtBiografia.getText().trim(), txtLinkSitio.getText().trim(), ruta , txtFechaNac.getDate());
					JOptionPane.showMessageDialog(null, "El usuario proponente ha sido registrado exitosamente", "Culturarte",
							JOptionPane.INFORMATION_MESSAGE);
					if(customImg)
						guardarImagen(ruta);
					
					setVisible(false);
					limpiarCampos();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		panel.add(scrollPane, gbc_scrollPane);
		
		txtBiografia = new JTextArea();
		scrollPane.setViewportView(txtBiografia);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 10;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 10;
		panel.add(btnCancelar, gbc_btnCancelar);

	}

	private void limpiarCampos(){
		txtNick.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEmail.setText("");
		txtBiografia.setText("");
		txtFechaNac.setDate(null);
		txtDireccion.setText("");
		txtLinkSitio.setText(""); 
		ImageIcon img = new ImageIcon(new ImageIcon("recursos/addpicture.png")
				  .getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		lblImageLabel.setIcon(img);

		contr.setText("");
		rptcontr.setText("");
	}
	
	private void guardarImagen(String codigo) {
		try {
		Path source = archivoDestino.toPath();
		String newPath = archivoDestino.getAbsolutePath().replace("tmp", codigo);
		Path newdir = new File(newPath).toPath();
		Files.move(source, newdir, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
