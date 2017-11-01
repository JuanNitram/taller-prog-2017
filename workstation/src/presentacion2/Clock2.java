package presentacion2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.Timer;

import logica.controladores.CtrlPropuesta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class Clock2 extends JInternalFrame {
	private JTextField fieldMes;
	private JTextField fieldAnio;
	private JTextField fieldDia;
	private JTextField fieldHora;
	private JTextField fieldMinuto;
	private JButton btnCambiar;
	private JLabel lblReloj;
	
	static Calendar calendario; 
	int dia, mes, anio, hora, minutos, segundos; 
	private Date fecha;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock2 frame = new Clock2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clock2() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Configuración del Reloj");
		setBounds(100, 100, 450, 232);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		reloj();
		fecha = new Date();
	
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		lblReloj = new JLabel("00/00/00 - 00:00:00");
		lblReloj.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblReloj);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		fieldMes = new JTextField();
		fieldMes.setBounds(169, 22, 86, 20);
		panel_1.add(fieldMes);
		fieldMes.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(160, 25, 11, 14);
		panel_1.add(label);
		
		fieldAnio = new JTextField();
		fieldAnio.setColumns(10);
		fieldAnio.setBounds(265, 22, 86, 20);
		panel_1.add(fieldAnio);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(259, 25, 11, 14);
		panel_1.add(label_1);
		
		fieldDia = new JTextField();
		fieldDia.setColumns(10);
		fieldDia.setBounds(67, 22, 86, 20);
		panel_1.add(fieldDia);
		
		fieldHora = new JTextField();
		fieldHora.setColumns(10);
		fieldHora.setBounds(302, 53, 20, 20);
		panel_1.add(fieldHora);
		
		fieldMinuto = new JTextField();
		fieldMinuto.setColumns(10);
		fieldMinuto.setBounds(331, 53, 20, 20);
		panel_1.add(fieldMinuto);
		
		JLabel label_2 = new JLabel(":");
		label_2.setBounds(326, 56, 11, 14);
		panel_1.add(label_2);
		
	
		
		btnCambiar = new JButton("Modificar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(!fieldAnio.getText().toString().isEmpty()) fecha.setYear(Integer.parseInt(fieldAnio.getText()) - 1900);
					if(!fieldMes.getText().toString().isEmpty()) fecha.setMonth(Integer.parseInt(fieldMes.getText()) - 1);
					if(!fieldDia.getText().toString().isEmpty()) fecha.setDate(Integer.parseInt(fieldDia.getText()));					
					if(!fieldHora.getText().toString().isEmpty()) fecha.setHours(Integer.parseInt(fieldHora.getText()));
					if(!fieldMinuto.getText().toString().isEmpty()) fecha.setMinutes(Integer.parseInt(fieldMinuto.getText()));
				} catch(NumberFormatException nfe) {
					JOptionPane.showInternalMessageDialog(getParent(), "Por favor introduzca valores numéricos válidos.", "Culturarte", JOptionPane.ERROR_MESSAGE);
				}
				if(fecha.getYear()+1900 > 2100)
					JOptionPane.showInternalMessageDialog(getParent(), "No se permiten años mayores a 2100", "Culturarte", JOptionPane.ERROR_MESSAGE);
				else if(fecha.getMonth() <= 0 && fecha.getMonth() > 12){
					JOptionPane.showInternalMessageDialog(getParent(), "Introduzca un mes válido", "Culturarte", JOptionPane.ERROR_MESSAGE);
				} 
				else if(fecha.getDate() <= 0 && fecha.getDate() > 31){
					JOptionPane.showInternalMessageDialog(getParent(), "Introduzca un día válido", "Culturarte", JOptionPane.ERROR_MESSAGE);
				} 
				else if(fecha.getHours() < 0 && fecha.getHours() >= 24){
					JOptionPane.showInternalMessageDialog(getParent(), "Introduzca una hora válida", "Culturarte", JOptionPane.ERROR_MESSAGE);
				} 
				else if(fecha.getMinutes() < 0 && fecha.getMinutes() >= 60){
					JOptionPane.showInternalMessageDialog(getParent(), "Introduzca minutos válidos", "Culturarte", JOptionPane.ERROR_MESSAGE);
				} 
				else {
					calendario.setTime(fecha);
					CtrlPropuesta.getInstance().actualizarPropuestas();
				}
			}
		});
		btnCambiar.setBounds(67, 94, 286, 32);
		panel_1.add(btnCambiar);
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
				lblReloj.setText("<html><center>" + hour + "<br>" + date);
			} 
		}); 
		timer.start(); 
	} 
	
	public static Date getFecha() {
		return calendario.getTime();
	}
}
