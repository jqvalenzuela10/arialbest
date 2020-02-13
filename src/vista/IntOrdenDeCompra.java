package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class IntOrdenDeCompra extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntOrdenDeCompra frame = new IntOrdenDeCompra();
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
	public IntOrdenDeCompra() {
		setBounds(100, 100, 1600, 686);
		getContentPane().setLayout(null);
		
		JLabel lblOrdenDeCompra = new JLabel("Orden De Compra");
		lblOrdenDeCompra.setBounds(10, 25, 115, 14);
		getContentPane().add(lblOrdenDeCompra);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 60, 768, 285);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDatosDelProveedor = new JLabel("Datos del proveedor");
		lblDatosDelProveedor.setBounds(29, 21, 104, 14);
		panel.add(lblDatosDelProveedor);
		
		textField = new JTextField();
		textField.setBounds(103, 40, 104, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("...");
		button.setBounds(217, 39, 31, 23);
		panel.add(button);
		
		JLabel lblRazonSocial = new JLabel("Razon social");
		lblRazonSocial.setBounds(29, 43, 66, 14);
		panel.add(lblRazonSocial);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(29, 77, 66, 14);
		panel.add(lblDireccion);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(29, 111, 66, 14);
		panel.add(lblContacto);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(29, 152, 66, 14);
		panel.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(29, 191, 66, 14);
		panel.add(lblCorreo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(103, 71, 104, 20);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 149, 104, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 188, 104, 20);
		panel.add(textField_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 108, 102, 20);
		panel.add(comboBox);
		
		JLabel lblCotizacion = new JLabel("Cotizacion");
		lblCotizacion.setBounds(29, 222, 66, 14);
		panel.add(lblCotizacion);
		
		JLabel lblN = new JLabel("N.");
		lblN.setBounds(29, 244, 46, 14);
		panel.add(lblN);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 241, 104, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(217, 244, 46, 14);
		panel.add(lblFecha);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(257, 238, 95, 20);
		panel.add(dateChooser);

	}
}
