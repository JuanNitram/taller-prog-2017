package presentacion2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.border.EmptyBorder;

import Logica.ICtrlUsuario;
import utils.ValidarEmail;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Arrays;
import java.util.Date;

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
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistrarColaborador2 extends JInternalFrame {
	private JTextField txtNick;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private Date fecha;
	private ICtrlUsuario ICU;
	private	JDateChooser txtFechaNac;
	private JLabel lblImageLabel;
	private File archivoDestino;
	private boolean customImg;
	private ValidarEmail validar;
	private JPasswordField  contr;
	private JPasswordField  rptcontr;
	
	public RegistrarColaborador2(ICtrlUsuario iCU) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarCampos();			
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ICU = iCU;
		
		
		setClosable(true);
		setTitle("Alta colaborador");
		setBounds(100, 100, 536, 262);
		
		JPanel panel = new JPanel();
		panel.setEnabled(false);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{127, 95, 95, 79, 0};
		gbl_panel.rowHeights = new int[]{31, 0, 0, 18, 0, 0,33, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
		ImageIcon image = new ImageIcon("recursos/addpicture.png");
		lblImageLabel = new JLabel("", image, SwingConstants.CENTER);
		panel_1.add(lblImageLabel, BorderLayout.NORTH);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setToolTipText("Agrega una nueva imagen de perfil de colaborador");
		
		image = new ImageIcon("recursos/addpicture.png");
		lblImageLabel = new JLabel("", image, SwingConstants.CENTER);
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
		            	  archivoDestino = new File("imagenes/usuarios/colaboradores/tmp."+selectedFile.getName()
		            	  		.substring(selectedFile.getName().lastIndexOf(".") + 1));	//obtiene la extensión
		            	  archivoDestino.mkdirs();
		            	  try {
		            		  Files.copy(selectedFile.toPath(),archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
		            		  ImageIcon img = new ImageIcon(new ImageIcon(archivoDestino.getAbsolutePath())
		            				  .getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		            		 
		            		  lblImageLabel.setIcon(img);
		            		  customImg = true;
		            		  } catch (IOException ioe) {
		            			  //Establece una imagen predeterminada del sistema
		            			  lblImageLabel.setIcon(new ImageIcon("recursos/no_imagen_colaborador"));
		            			  customImg = false;
		            	  }
		            }
				
			}
		});
		GridBagConstraints gbc_imgPanel = new GridBagConstraints();
		gbc_imgPanel.fill = GridBagConstraints.BOTH;
		gbc_imgPanel.gridheight = 5;
		gbc_imgPanel.insets = new Insets(0, 0, 5, 5);
		gbc_imgPanel.gridx = 0;
		gbc_imgPanel.gridy = 0;
		panel.add(imgPanel, gbc_imgPanel);

		
		
		JLabel label_1 = new JLabel("Nickname");
		label_1.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		txtNick = new JTextField();
		txtNick.setColumns(10);
		GridBagConstraints gbc_txtNick = new GridBagConstraints();
		gbc_txtNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNick.gridwidth = 2;
		gbc_txtNick.insets = new Insets(0, 0, 5, 0);
		gbc_txtNick.gridx = 2;
		gbc_txtNick.gridy = 0;
		panel.add(txtNick, gbc_txtNick);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ruta = "";
				if(txtNick.getText().trim().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe ingresar el NickName");
				else if(txtNombre.getText().trim().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe ingresar el Nombre");
				else if(txtApellido.getText().trim().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe ingresar el Apellido");
				else if(txtEmail.getText().trim().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe ingresar el Email");
				else if(txtFechaNac.getDate() == null)
					JOptionPane.showMessageDialog(null, "Debe ingresar una Fecha");
				else if(ICU.existeUsuario(txtNick.getText().toString(), txtEmail.getText().toString()))
					JOptionPane.showMessageDialog(null, "Ya existe un colaborador registrado con el mismo nick","Culturarte",
							JOptionPane.WARNING_MESSAGE);
				else if (!Arrays.equals(contr.getPassword(), rptcontr.getPassword()))
					JOptionPane.showMessageDialog(null, "Sus contraseñas no coinciden","Culturarte",
							JOptionPane.WARNING_MESSAGE);
				else{
					if(customImg) ruta = txtNick.getText().toString().trim().hashCode() + "";
					ICU.altaColaborador(txtNick.getText().trim(),contr.getPassword().toString(), txtNombre.getText().trim(), txtApellido.getText().trim(), txtEmail.getText().trim(), ruta, txtFechaNac.getDate());
					JOptionPane.showMessageDialog(null, "El usuario colaborador ha sido registrado exitosamente", "Culturarte",
							JOptionPane.INFORMATION_MESSAGE);
					if(customImg)
							guardarImagen(ruta);
					setVisible(false);
					limpiarCampos();
				}
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
		});
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 1;
		panel.add(lblContrasea, gbc_lblContrasea);
		
		contr = new JPasswordField();
		GridBagConstraints gbc_contr = new GridBagConstraints();
		gbc_contr.gridwidth = 2;
		gbc_contr.insets = new Insets(0, 0, 5, 5);
		gbc_contr.fill = GridBagConstraints.HORIZONTAL;
		gbc_contr.gridx = 2;
		gbc_contr.gridy = 1;
		panel.add(contr, gbc_contr);
		contr.setColumns(10);
		
		JLabel lblContrasea_1 = new JLabel("Repetir contrase\u00F1a");
		lblContrasea_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblContrasea_1 = new GridBagConstraints();
		gbc_lblContrasea_1.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea_1.gridx = 1;
		gbc_lblContrasea_1.gridy = 2;
		panel.add(lblContrasea_1, gbc_lblContrasea_1);
		
		rptcontr = new JPasswordField ();
		GridBagConstraints gbc_rptcontr = new GridBagConstraints();
		gbc_rptcontr.gridwidth = 2;
		gbc_rptcontr.insets = new Insets(0, 0, 5, 5);
		gbc_rptcontr.fill = GridBagConstraints.HORIZONTAL;
		gbc_rptcontr.gridx = 2;
		gbc_rptcontr.gridy = 2;
		panel.add(rptcontr, gbc_rptcontr);
		rptcontr.setColumns(10);
		

		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		panel.add(label_2, gbc_label_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 3;
		panel.add(txtNombre, gbc_txtNombre);
		
		JLabel label_3 = new JLabel("Apellido");
		label_3.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 4;
		panel.add(label_3, gbc_label_3);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridwidth = 2;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 4;
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
		
		txtFechaNac = new JDateChooser();
		GridBagConstraints gbc_txtFechaNac = new GridBagConstraints();
		gbc_txtFechaNac.gridwidth = 3;
		gbc_txtFechaNac.insets = new Insets(0, 0, 5, 0);
		gbc_txtFechaNac.fill = GridBagConstraints.BOTH;
		gbc_txtFechaNac.gridx = 1;
		gbc_txtFechaNac.gridy = 7;
		txtFechaNac.getDateEditor().setEnabled(false);
		panel.add(txtFechaNac, gbc_txtFechaNac);
		
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 8;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 8;
		panel.add(btnCancelar, gbc_btnCancelar);

	}
	
	private void limpiarCampos(){
		txtNick.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEmail.setText("");
		txtFechaNac.setDate(null);
		contr.setText("");
		rptcontr.setText("");
	}
}
