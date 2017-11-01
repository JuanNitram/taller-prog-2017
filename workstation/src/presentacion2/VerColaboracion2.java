package presentacion2;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import dataTypes.DtColaboracion;
import dataTypes.TRetorno;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class VerColaboracion2 extends JInternalFrame {
	private JTextField txtColaborador;
	private JTextField txtMonto;
	private JTextField txtFechaRealizacion;
	private JTextField txtNombre;
	private JTextField txtRetorno;
	
	public VerColaboracion2() {
		setTitle("Detalles Colaboracion");
		setClosable(true);
		setBounds(100, 100, 516, 233);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Colaborador:");
		label.setBounds(10, 11, 157, 20);
		panel.add(label);
		
		txtColaborador = new JTextField();
		txtColaborador.setEditable(false);
		txtColaborador.setColumns(10);
		txtColaborador.setBounds(177, 11, 307, 20);
		panel.add(txtColaborador);
		
		JLabel label_1 = new JLabel("Monto aportado:");
		label_1.setBounds(10, 74, 148, 26);
		panel.add(label_1);
		
		txtMonto = new JTextField();
		txtMonto.setEditable(false);
		txtMonto.setColumns(10);
		txtMonto.setBounds(177, 75, 74, 20);
		panel.add(txtMonto);
		
		JLabel label_2 = new JLabel("$");
		label_2.setBounds(168, 76, 11, 20);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Fecha de realización:");
		label_3.setBounds(10, 103, 157, 26);
		panel.add(label_3);
		
		txtFechaRealizacion = new JTextField();
		txtFechaRealizacion.setEditable(false);
		txtFechaRealizacion.setColumns(10);
		txtFechaRealizacion.setBounds(177, 106, 307, 20);
		panel.add(txtFechaRealizacion);
		
		JLabel label_4 = new JLabel("Nombre propuesta:");
		label_4.setBounds(10, 42, 157, 26);
		panel.add(label_4);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(177, 43, 307, 20);
		panel.add(txtNombre);
		
		JLabel label_5 = new JLabel("Tipo de retorno:");
		label_5.setBounds(10, 137, 157, 26);
		panel.add(label_5);
		
		txtRetorno = new JTextField();
		txtRetorno.setEditable(false);
		txtRetorno.setColumns(10);
		txtRetorno.setBounds(177, 140, 307, 20);
		panel.add(txtRetorno);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCerrar.setBounds(401, 171, 89, 23);
		panel.add(btnCerrar);

	}
	
	public void cargarColaboracion(DtColaboracion colaboracion) {
		txtColaborador.setText(colaboracion.getNickname());
		txtMonto.setText(colaboracion.getMontoAporte()+"");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String fechaRealiz = df.format(colaboracion.getFechaRealizacion());
		txtFechaRealizacion.setText(fechaRealiz);
		txtNombre.setText(colaboracion.getTitulo());
		if(colaboracion.getRetorno() == TRetorno.ENTRADA_GRATIS)
			txtRetorno.setText("Entradas gratis");
		else
			txtRetorno.setText("Porcentaje de ganancia");
	}
}
