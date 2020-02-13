package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Base64.Decoder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JdialogCobranzaMediosPago extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogCobranzaMediosPago dialog = new JdialogCobranzaMediosPago();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public JdialogCobranzaMediosPago() {
		setModal(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 521, 550);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1493e1"));
		panel.setBounds(0, 0, 508, 63);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCobranzaMedios = new JLabel("COBRANZA - MEDIOS DE PAGO");
		lblCobranzaMedios.setForeground(new Color(240,240,240));
		lblCobranzaMedios.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCobranzaMedios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCobranzaMedios.setBounds(148, 11, 248, 14);
		panel.add(lblCobranzaMedios);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setOpaque(true);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 65, 505, 391);
		getContentPane().add(tabbedPane);
		
		JPanel panelEfectivo = new JPanel();
		panelEfectivo.setBackground(Color.WHITE);
		tabbedPane.addTab("EFECTIVO", null, panelEfectivo, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelEfectivo.setLayout(null);
		
		JLabel lblDato = new JLabel("Datos de cobro");
		lblDato.setForeground(new Color(110, 203, 240));
		lblDato.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblDato.setBounds(10, 23, 159, 21);
		panelEfectivo.add(lblDato);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.decode("#777777"));
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblFecha.setBounds(10, 63, 98, 21);
		panelEfectivo.add(lblFecha);
		
		JLabel lblCajaDestino = new JLabel("Caja destino");
		lblCajaDestino.setForeground(Color.decode("#777777"));
		lblCajaDestino.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCajaDestino.setBounds(10, 95, 98, 21);
		panelEfectivo.add(lblCajaDestino);
		
		JLabel lblControlInterno = new JLabel("Control interno");
		lblControlInterno.setForeground(new Color(110, 203, 240));
		lblControlInterno.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblControlInterno.setBounds(10, 139, 159, 21);
		panelEfectivo.add(lblControlInterno);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(240,240,240));
		separator.setBackground(new Color(240,240,240));
		separator.setBounds(108, 35, 360, 1);
		panelEfectivo.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(240,240,240));
		separator_1.setBackground(new Color(240,240,240));
		separator_1.setBounds(108, 151, 360, 1);
		panelEfectivo.add(separator_1);
		
		JLabel lblSerieYNmero = new JLabel("Serie y n\u00FAmero del documento");
		lblSerieYNmero.setForeground(new Color(119, 119, 119));
		lblSerieYNmero.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblSerieYNmero.setBounds(10, 171, 175, 21);
		panelEfectivo.add(lblSerieYNmero);
		
		JLabel lblInternoDeCobranza = new JLabel("interno de cobranza");
		lblInternoDeCobranza.setForeground(new Color(119, 119, 119));
		lblInternoDeCobranza.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblInternoDeCobranza.setBounds(10, 188, 175, 21);
		panelEfectivo.add(lblInternoDeCobranza);
		
		textField = new JTextField();
		textField.setBounds(212, 179, 86, 28);
		panelEfectivo.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(308, 179, 113, 28);
		panelEfectivo.add(textField_1);
		
		JLabel lblAgenteDeCobranza = new JLabel("Agente de cobranza");
		lblAgenteDeCobranza.setForeground(new Color(119, 119, 119));
		lblAgenteDeCobranza.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAgenteDeCobranza.setBounds(10, 234, 175, 21);
		panelEfectivo.add(lblAgenteDeCobranza);
		
		JLabel lblImportes = new JLabel("Importes");
		lblImportes.setForeground(new Color(110, 203, 240));
		lblImportes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblImportes.setBounds(10, 282, 159, 21);
		panelEfectivo.add(lblImportes);
		
		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setForeground(new Color(119, 119, 119));
		lblImporte.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblImporte.setBounds(10, 314, 80, 21);
		panelEfectivo.add(lblImporte);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.menu);
		separator_2.setBackground(SystemColor.menu);
		separator_2.setBounds(108, 293, 360, 1);
		panelEfectivo.add(separator_2);
		
		JPanel panelDeposito = new JPanel();
		panelDeposito.setBackground(Color.WHITE);
		panelDeposito.setToolTipText("");
		tabbedPane.addTab("DEP\u00D3SITO EN CUENTA", null, panelDeposito, null);
		panelDeposito.setLayout(null);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales");
		lblDatosGenerales.setForeground(new Color(110, 203, 240));
		lblDatosGenerales.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblDatosGenerales.setBounds(10, 24, 159, 21);
		panelDeposito.add(lblDatosGenerales);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(SystemColor.menu);
		separator_3.setBackground(SystemColor.menu);
		separator_3.setBounds(108, 36, 360, 1);
		panelDeposito.add(separator_3);
		
		JLabel lblCuentaDeDestino = new JLabel("Cuenta de destino");
		lblCuentaDeDestino.setForeground(new Color(119, 119, 119));
		lblCuentaDeDestino.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCuentaDeDestino.setBounds(10, 56, 106, 21);
		panelDeposito.add(lblCuentaDeDestino);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 84, 282, 20);
		panelDeposito.add(comboBox);
		
		JLabel lblFechaDeDesposito = new JLabel("Fecha de desposito");
		lblFechaDeDesposito.setForeground(new Color(119, 119, 119));
		lblFechaDeDesposito.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblFechaDeDesposito.setBounds(10, 115, 112, 21);
		panelDeposito.add(lblFechaDeDesposito);
		
		JLabel lblNDeOperacin = new JLabel("n\u00BA de operaci\u00F3n");
		lblNDeOperacin.setForeground(new Color(119, 119, 119));
		lblNDeOperacin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNDeOperacin.setBounds(10, 144, 112, 21);
		panelDeposito.add(lblNDeOperacin);
		
		JLabel lblAgenteDeCobranza_1 = new JLabel("Agente de cobranza");
		lblAgenteDeCobranza_1.setForeground(new Color(119, 119, 119));
		lblAgenteDeCobranza_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAgenteDeCobranza_1.setBounds(10, 176, 112, 21);
		panelDeposito.add(lblAgenteDeCobranza_1);
		
		JLabel lblImporte_1 = new JLabel("Importe");
		lblImporte_1.setForeground(new Color(110, 203, 240));
		lblImporte_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblImporte_1.setBounds(10, 215, 159, 21);
		panelDeposito.add(lblImporte_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(SystemColor.menu);
		separator_4.setBackground(SystemColor.menu);
		separator_4.setBounds(108, 227, 360, 1);
		panelDeposito.add(separator_4);
		
		JLabel lblImporte_2 = new JLabel("Importe");
		lblImporte_2.setForeground(new Color(119, 119, 119));
		lblImporte_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblImporte_2.setBounds(10, 247, 112, 21);
		panelDeposito.add(lblImporte_2);
		
		JLabel lblDetraccin = new JLabel("Detracci\u00F3n");
		lblDetraccin.setForeground(new Color(119, 119, 119));
		lblDetraccin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDetraccin.setBounds(10, 271, 112, 21);
		panelDeposito.add(lblDetraccin);
		
		JLabel lblRentencin = new JLabel("Rentenci\u00F3n");
		lblRentencin.setForeground(new Color(119, 119, 119));
		lblRentencin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblRentencin.setBounds(10, 293, 112, 21);
		panelDeposito.add(lblRentencin);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setForeground(new Color(119, 119, 119));
		lblTotal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTotal.setBounds(10, 331, 112, 21);
		panelDeposito.add(lblTotal);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(new Color(240,240,240));
		btnAceptar.setBounds(200, 477, 89, 23);
		getContentPane().add(btnAceptar);

	}
}
