package presentacion2;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
/*import dataTypes.DtProponente;
import dataTypes.DtPropuesta;
import dataTypes.DtUsuario;
import javax.swing.JList;*/
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dataTypes.DtProponente;
import Logica.ICtrlUsuario;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultaProponente2 extends JInternalFrame {
	
	private ICtrlUsuario ICU;
	
	private JPanel contentPane;	
	private JScrollPane scrollPane;
	private JList listaProponentes;
	
	private VerProponente2 verproponente2;
	private JLabel lblSeleccioneUnProponente;
	private JButton btnAceptar;

	public ConsultaProponente2(ICtrlUsuario iCU) {
		
		ICU = iCU;
		
		setTitle("Consulta proponente");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 680, 327);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 0, 30};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		lblSeleccioneUnProponente = new JLabel("Seleccione un Proponente");
		GridBagConstraints gbc_lblSeleccioneUnProponente = new GridBagConstraints();
		gbc_lblSeleccioneUnProponente.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccioneUnProponente.gridx = 1;
		gbc_lblSeleccioneUnProponente.gridy = 0;
		contentPane.add(lblSeleccioneUnProponente, gbc_lblSeleccioneUnProponente);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		listaProponentes = new JList();
		scrollPane.setViewportView(listaProponentes);
		
		btnAceptar = new JButton("Cerrar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 4;
		contentPane.add(btnAceptar, gbc_btnAceptar);
		
	
	}
	
	public void cargarProponentes() {
		ArrayList<DtProponente> proponentes = ICU.listarProponentes();
		DtProponente dtP;
		String[] model = new String[proponentes.size()];
		for(int i = 0; i < proponentes.size(); i++) {
			dtP = proponentes.get(i);
			model[i] = dtP.getNickName();
		}
		
		listaProponentes = new JList(model);
		scrollPane.setViewportView(listaProponentes);
		listaProponentes.addMouseListener(new MouseAdapter() {
		       @Override
		       public void mouseClicked(MouseEvent e) {
		    	   if(e.getClickCount() == 2) {
			    	   try {
			    		   verproponente2 = new VerProponente2();
			    		   verproponente2.setResizable(false);
			    		   getParent().add(verproponente2);
			    		   String nickname = model[listaProponentes.getSelectedIndex()];
			    		   DtProponente dtP = ICU.infoProponente(nickname);
			    		   verproponente2.cargarProponente(dtP);
				    	   verproponente2.setVisible(true);
				    	   verproponente2.toFront();
			    	   } catch(Exception ex) {}
		    	   }
		       }
		});
	}

}
