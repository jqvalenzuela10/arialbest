package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;

import mantenimientos.GestionFinanzas;
import mantenimientos.GestionMovimiento;
import model.Abono;
import model.Movimiento;
import utils.clsArial;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JdialogRegistroAbono extends JDialog {
	public static JTextField txtSaldo;
	private JTextField txtAbono;
	private JTextField txtObservaciones;
	private JLabel lbliconoRegiAbono;
	private JComboBox cboFormaPago;

	public static String idVenta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogRegistroAbono dialog = new JdialogRegistroAbono();
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
	public JdialogRegistroAbono() {
		setModal(true);
		
		setTitle("   Registro de Abono");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 505, 479);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		txtSaldo = new JTextField();
		txtSaldo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtSaldo.setBounds(38, 140, 166, 29);
		getContentPane().add(txtSaldo);
		txtSaldo.setColumns(10);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblSaldo.setBounds(38, 122, 46, 14);
		getContentPane().add(lblSaldo);
		
		JLabel lblNewLabel = new JLabel("Abono a Cr\u00E9dito");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(184, 79, 120, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFormaDePago = new JLabel("Forma de Pago");
		lblFormaDePago.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblFormaDePago.setBounds(38, 192, 85, 21);
		getContentPane().add(lblFormaDePago);
		
		cboFormaPago = new JComboBox();
		cboFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "cheque", "tarjeta"}));
		cboFormaPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cboFormaPago.setBounds(38, 215, 166, 28);
		getContentPane().add(cboFormaPago);
		
		txtAbono = new JTextField();
		txtAbono.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtAbono.setColumns(10);
		txtAbono.setBounds(38, 271, 166, 29);
		getContentPane().add(txtAbono);
		
		JLabel lblAbono = new JLabel("Abono");
		lblAbono.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblAbono.setBounds(38, 254, 46, 14);
		getContentPane().add(lblAbono);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblObservaciones.setBounds(38, 323, 85, 14);
		getContentPane().add(lblObservaciones);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtObservaciones.setColumns(10);
		txtObservaciones.setBounds(38, 339, 426, 29);
		getContentPane().add(txtObservaciones);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(235, 240, 244));
		panel_1_1.setBounds(10, 180, 469, 1);
		getContentPane().add(panel_1_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Abono a=new Abono();
				a.setForma_pago(cboFormaPago.getSelectedItem().toString());
				a.setMonto_abono(txtAbono.getText());
				a.setObserv_abono(txtObservaciones.getText());
				a.setId_venta(idVenta);
			System.out.println("numero de venta en abono"+idVenta);
			System.out.println("numero de venta en abono"+txtAbono.getText());
			System.out.println("numero de venta en abono  "+cboFormaPago.getSelectedItem().toString());
				int i=new GestionFinanzas().registrarAbono(a);
				if (i!=0) {
					Movimiento m =new Movimiento();
					m.setComentario(txtObservaciones.getText());
					m.setTipo_movimiento(cboFormaPago.getSelectedItem().toString());
					m.setNro_ven(Integer.parseInt(idVenta));
					m.setCod_regis_com(0);
					m.setEntrada(Double.parseDouble(txtAbono.getText()));
					double saldo=Double.parseDouble(FrmMenuPrincipal.lblSaldo.getText());
					double abono=Double.parseDouble(txtAbono.getText());
					m.setSaldo(saldo+abono);
					m.setIdUsu(Integer.toString(FrmLogin.e.getId_emp()));
					m.setCodcaja(Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText()));
					int im=new GestionMovimiento().insertar(m);
					if (im!=0) {
						JOptionPane.showMessageDialog(null, "movimiento ingresado");
					}
					JOptionPane.showMessageDialog(null, "registro correcto");
					dispose();
				}
				
			}
		});
		btnGuardar.setBounds(198, 401, 106, 29);
		getContentPane().add(btnGuardar);
		
		lbliconoRegiAbono = new JLabel("");
		lbliconoRegiAbono.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/abonar.png", 60, 60, lbliconoRegiAbono);
		lbliconoRegiAbono.setBounds(185, 11, 119, 67);
		getContentPane().add(lbliconoRegiAbono);
		
		JLabel lbliconBandera = new JLabel("");
		lbliconBandera.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/bandera.png", 20, 15, lbliconBandera);
		lbliconBandera.setBounds(227, 142, 34, 22);
		getContentPane().add(lbliconBandera);
		
		JLabel lblPen = new JLabel("PEN");
		lblPen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblPen.setBounds(268, 146, 35, 14);
		getContentPane().add(lblPen);
		
		JLabel lbliconBandera2 = new JLabel("");
		lbliconBandera2.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/bandera.png", 20, 15, lbliconBandera2);
		lbliconBandera2.setBounds(320, 273, 34, 22);
		getContentPane().add(lbliconBandera2);
		
		JLabel lblPen_1 = new JLabel("PEN");
		lblPen_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblPen_1.setBounds(360, 278, 35, 14);
		getContentPane().add(lblPen_1);
		
		JCheckBox chckbxSaldarTotal = new JCheckBox("Saldar Total");
		chckbxSaldarTotal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		chckbxSaldarTotal.setBackground(Color.WHITE);
		chckbxSaldarTotal.setBounds(217, 275, 87, 23);
		getContentPane().add(chckbxSaldarTotal);

	}
}
