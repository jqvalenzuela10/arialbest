package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import mantenimientos.GestionCaja;
import model.Caja;
import model.Tabla_Reutilizable;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JdialogCajaConfNuevo extends JDialog {
	private JTextField txtCaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogCajaConfNuevo dialog = new JdialogCajaConfNuevo();
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
	public JdialogCajaConfNuevo() {
		setResizable(false);
		setTitle("Nueva Caja");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNombre.setBounds(21, 27, 64, 14);
		getContentPane().add(lblNombre);
		
		txtCaja = new JTextField();
		txtCaja.setBounds(95, 26, 226, 20);
		getContentPane().add(txtCaja);
		txtCaja.setColumns(10);
		
		JButton btnGuardar = new JButton("Agregar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				agregar();
				IntCajaConfiguracion.model.setRowCount(0);
				ArrayList<Caja>listado=new GestionCaja().listado();
				Tabla_Reutilizable.listarCaja(listado);
				dispose();
			}
		});
		btnGuardar.setBounds(352, 25, 89, 23);
		getContentPane().add(btnGuardar);
		setBounds(100, 100, 457, 95);
		setModal(true);
		setLocationRelativeTo(null);

	}
void agregar() {
	String nomCaja;
	nomCaja=txtCaja.getText();
	
	Caja c=new Caja();
	c.setNomCaja(nomCaja);
	int ok=new GestionCaja().agregar(c);
	
	if(ok!=0) {
		JOptionPane.showMessageDialog(null, "Agregado");
	}
	else {
		JOptionPane.showMessageDialog(null, "error al agregar");
	}
}
}
