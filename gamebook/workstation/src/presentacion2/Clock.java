package presentacion2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Logica.controladores.CtrlPropuesta;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Clock extends JFrame { 
	static Calendar calendario; 
	int dia, mes, anio, hora, minutos, segundos; 
	private JPanel contentPane;
	private JLabel label; 
	private JButton btnCambiar;
	private JTextField fieldAnio;
	private JTextField fieldMes;
	private JTextField fieldDia;
	private JTextField fieldHora;
	private JTextField fieldMinuto;
	private boolean verInputs;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private Date fecha;
	
	public Clock() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false);
			}
		}); 
		setTitle("Reloj");
		inicio(); 
		reloj(); 
	}
	
	private void inicio() {
		verInputs = false;
		fecha = new Date();
		setBounds(100, 100, 421, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{30, 0, 30, 0, 30, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		label = new JLabel(); 
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		getContentPane().add(label, gbc_label); 
		label.setHorizontalAlignment(0);
		
		fieldAnio = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(fieldAnio, gbc_textField);
		fieldAnio.setColumns(10);
		fieldAnio.setText("");
		fieldAnio.setVisible(false);
		
		label_1 = new JLabel("/");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		contentPane.add(label_1, gbc_label_1);
		label_1.setVisible(false);
		
		fieldMes = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		contentPane.add(fieldMes, gbc_textField_1);
		fieldMes.setColumns(10);
		fieldMes.setText("");
		fieldMes.setVisible(false);
		
		label_2 = new JLabel("/");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		contentPane.add(label_2, gbc_label_2);
		label_2.setVisible(false);
		
		fieldDia = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 1;
		contentPane.add(fieldDia, gbc_textField_2);
		fieldDia.setColumns(10);
		fieldDia.setText("");
		fieldDia.setVisible(false);
		
		fieldHora = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 2;
		contentPane.add(fieldHora, gbc_textField_3);
		fieldHora.setColumns(10);
		fieldHora.setText("");
		fieldHora.setVisible(false);
		
		label_3 = new JLabel(":");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 2;
		contentPane.add(label_3, gbc_label_3);
		label_3.setVisible(false);
		
		fieldMinuto = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 2;
		contentPane.add(fieldMinuto, gbc_textField_4);
		fieldMinuto.setColumns(10);
		fieldMinuto.setText("");
		fieldMinuto.setVisible(false);
		
		JButton btnNewButton = new JButton("Cambiar hora");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verInputs) {
					try {
						if(!fieldAnio.getText().toString().isEmpty()) fecha.setYear(Integer.parseInt(fieldAnio.getText()) - 1900);
						if(!fieldMes.getText().toString().isEmpty()) fecha.setMonth(Integer.parseInt(fieldMes.getText()) - 1);
						if(!fieldDia.getText().toString().isEmpty()) fecha.setDate(Integer.parseInt(fieldDia.getText()));					
						if(!fieldHora.getText().toString().isEmpty()) fecha.setHours(Integer.parseInt(fieldHora.getText()));
						if(!fieldMinuto.getText().toString().isEmpty()) fecha.setMinutes(Integer.parseInt(fieldMinuto.getText()));
					} catch(NumberFormatException nfe) {
						nfe.getMessage();
					}
					if(fecha.getYear()+1900 > 2100)
						JOptionPane.showInternalMessageDialog(null, "Advertencia", "No se permiten años mayores a 2100", JOptionPane.INFORMATION_MESSAGE);
					else {
						calendario.setTime(fecha);
						fieldAnio.setText("");
						fieldMes.setText("");
						fieldDia.setText("");
						fieldHora.setText("");
						fieldMinuto.setText("");
						fieldAnio.setVisible(false);
						fieldMes.setVisible(false);
						fieldDia.setVisible(false);
						fieldHora.setVisible(false);
						fieldMinuto.setVisible(false);
						label_1.setVisible(false);
						label_2.setVisible(false);
						label_3.setVisible(false);
						verInputs = false;
						CtrlPropuesta.getInstance().actualizarPropuestas();
					}
				} else {
					fieldAnio.setVisible(true);
					fieldMes.setVisible(true);
					fieldDia.setVisible(true);
					fieldHora.setVisible(true);
					fieldMinuto.setVisible(true);
					label_1.setVisible(true);
					label_2.setVisible(true);
					label_3.setVisible(true);
					verInputs = true;
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 5;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		setBounds(0, 0, 421, 277); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	private void reloj() { 
		calendario = new GregorianCalendar(); 
		segundos = calendario.get(Calendar.SECOND); 
		Timer timer = new Timer(1000, new ActionListener() { 
			@ Override 
			public void actionPerformed(ActionEvent ae) {
				calendario.setTimeInMillis(calendario.getTimeInMillis() + 1000);
				dia = calendario.get(Calendar.DAY_OF_MONTH); 
				mes = (calendario.get(Calendar.MONTH) + 1); 
				anio = calendario.get(Calendar.YEAR); 
				hora = calendario.get(Calendar.HOUR_OF_DAY); 
				minutos = calendario.get(Calendar.MINUTE); 
				segundos = calendario.get(Calendar.SECOND); 
				String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos); 
				String date = String.format("%02d / %02d / %02d", dia, mes, anio); 
				label.setText("<html><center>" + hour + "<br>" + date);
			} 
		}); 
		timer.start(); 
	} 
	
	public static Date getFecha() {
		return calendario.getTime();
	}
	
	public static void main(String[] args) { 
		new Clock().setVisible(true); 
	}
} 

