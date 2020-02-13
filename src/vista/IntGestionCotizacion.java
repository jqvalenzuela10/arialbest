package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntGestionCotizacion extends JInternalFrame {
	private JTable table;
	private JTable table_1;
	private JTextField txtDatosGenerales;
	private JTextField txtEntregasDocumentosRelacionados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntGestionCotizacion frame = new IntGestionCotizacion();
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
	public IntGestionCotizacion() {
		setTitle("Gestion De Cotizaciones /Presupuestos");
		setBounds(100, 100, 1331, 731);
		getContentPane().setLayout(null);
		
		JLabel lblEstablecimiento = new JLabel("Establecimiento");
		lblEstablecimiento.setBounds(24, 23, 84, 14);
		getContentPane().add(lblEstablecimiento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(24, 56, 108, 20);
		getContentPane().add(comboBox);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(22, 100, 46, 14);
		getContentPane().add(lblPeriodo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(100, 97, 84, 20);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(194, 97, 94, 20);
		getContentPane().add(comboBox_2);
		
		JCheckBox chckbxNuevo = new JCheckBox("Nuevo");
		chckbxNuevo.setBounds(273, 19, 76, 23);
		getContentPane().add(chckbxNuevo);
		
		JCheckBox chckbxEnviado = new JCheckBox("Enviado");
		chckbxEnviado.setBounds(273, 55, 76, 23);
		getContentPane().add(chckbxEnviado);
		
		JCheckBox chckbxPorFacturar = new JCheckBox("Por Facturar");
		chckbxPorFacturar.setBounds(373, 19, 94, 23);
		getContentPane().add(chckbxPorFacturar);
		
		JCheckBox chckbxFinalizado = new JCheckBox("Finalizado");
		chckbxFinalizado.setBounds(373, 55, 97, 23);
		getContentPane().add(chckbxFinalizado);
		
		JCheckBox chckbxSoloFacturado = new JCheckBox("solo facturado");
		chckbxSoloFacturado.setBounds(509, 19, 97, 23);
		getContentPane().add(chckbxSoloFacturado);
		
		JCheckBox chckbxSoloAnulados = new JCheckBox("solo anulados");
		chckbxSoloAnulados.setBounds(509, 53, 97, 23);
		getContentPane().add(chckbxSoloAnulados);
		
		JLabel lblFinalizan = new JLabel("finalizan");
		lblFinalizan.setBounds(660, 23, 46, 14);
		getContentPane().add(lblFinalizan);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(660, 54, 115, 20);
		getContentPane().add(comboBox_3);
		
		table = new JTable();
		table.setBounds(10, 133, 956, 347);
		getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(10, 496, 956, 194);
		getContentPane().add(table_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panel.setBackground(SystemColor.text);
		panel.setBounds(986, 19, 381, 671);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtDatosGenerales = new JTextField();
		txtDatosGenerales.setBorder(new LineBorder(SystemColor.inactiveCaption));
		txtDatosGenerales.setBackground(SystemColor.activeCaption);
		txtDatosGenerales.setText("Datos Generales");
		txtDatosGenerales.setBounds(0, 178, 380, 20);
		panel.add(txtDatosGenerales);
		txtDatosGenerales.setColumns(10);
		
		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setBounds(121, 22, 105, 14);
		panel.add(lblGeneral);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 128, 46, 14);
		panel.add(lblFecha);
		
		JLabel lblVence = new JLabel("Vence");
		lblVence.setBounds(10, 153, 46, 14);
		panel.add(lblVence);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago");
		lblFormaDePago.setBounds(145, 128, 91, 14);
		panel.add(lblFormaDePago);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(145, 153, 46, 14);
		panel.add(lblTotal);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(266, 128, 46, 14);
		panel.add(lblN);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 209, 46, 14);
		panel.add(lblCliente);
		
		JLabel lblRuc = new JLabel("Ruc");
		lblRuc.setBounds(10, 234, 46, 14);
		panel.add(lblRuc);
		
		JLabel lblVerHistorialDe = new JLabel("ver historial de ventas");
		lblVerHistorialDe.setForeground(SystemColor.textHighlight);
		lblVerHistorialDe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVerHistorialDe.setBounds(39, 276, 122, 14);
		panel.add(lblVerHistorialDe);
		
		JLabel lblCalificacionCrediticia = new JLabel("calificacion crediticia");
		lblCalificacionCrediticia.setForeground(SystemColor.textHighlight);
		lblCalificacionCrediticia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCalificacionCrediticia.setBounds(210, 276, 116, 14);
		panel.add(lblCalificacionCrediticia);
		
		txtEntregasDocumentosRelacionados = new JTextField();
		txtEntregasDocumentosRelacionados.setText("Entregas Documentos relacionados");
		txtEntregasDocumentosRelacionados.setColumns(10);
		txtEntregasDocumentosRelacionados.setBorder(new LineBorder(SystemColor.inactiveCaption));
		txtEntregasDocumentosRelacionados.setBackground(SystemColor.activeCaption);
		txtEntregasDocumentosRelacionados.setBounds(0, 494, 380, 20);
		panel.add(txtEntregasDocumentosRelacionados);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JdialogCotizacion c=new JdialogCotizacion();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
				
			}
		});
		btnNuevo.setBounds(862, 55, 89, 23);
		getContentPane().add(btnNuevo);

	}
}
