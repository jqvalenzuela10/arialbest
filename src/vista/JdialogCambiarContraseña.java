package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionEmpledos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JdialogCambiarContraseña extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtPswActual;
	private JPasswordField txtPswNueva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdialogCambiarContraseña dialog = new JdialogCambiarContraseña();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdialogCambiarContraseña() {
		
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JdialogCambiarContraseña.class.getResource("/img/llave.png")));
		setTitle("cambiar contrase\u00F1a");
		setBounds(100, 100, 468, 256);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblContraseaActual = new JLabel("Contrase\u00F1a Actual");
			lblContraseaActual.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			lblContraseaActual.setBounds(10, 28, 120, 14);
			contentPanel.add(lblContraseaActual);
		}
		{
			JLabel lblNuevaContrasea = new JLabel("Nueva Contrase\u00F1a");
			lblNuevaContrasea.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			lblNuevaContrasea.setBounds(10, 97, 120, 14);
			contentPanel.add(lblNuevaContrasea);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					char[] arrayC = txtPswActual.getPassword();
					String pass = new String(arrayC);
					String p=FrmLogin.e.getPsw_emp();
				System.out.println(pass);
				System.out.println(p);
					if (pass.equals(p)) {
						char[] array = txtPswNueva.getPassword();
						String pas = new String(array);
						int i=new GestionEmpledos().cambiarContraseña(FrmLogin.e.getId_emp(),pas );
						if (i!=0) {
							JOptionPane.showMessageDialog(null, "se cambio la contraseña correctamente");
							
							System.exit(0);
							
							FrmLogin login=new FrmLogin();
							login.setVisible(true);
							login.setLocationRelativeTo(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "error al cambiar contraseña");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "contraseña actual incorrecta");
					}
				
				}
			});
			btnAceptar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			btnAceptar.setBounds(169, 170, 106, 36);
			contentPanel.add(btnAceptar);
		}
		
		txtPswActual = new JPasswordField();
		txtPswActual.setBounds(10, 54, 275, 20);
		contentPanel.add(txtPswActual);
		
		txtPswNueva = new JPasswordField();
		txtPswNueva.setBounds(10, 122, 275, 20);
		contentPanel.add(txtPswNueva);
	}
}
