package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class DialogEditPerfil extends JDialog {
	public static JTextField txtId;
	public static JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogEditPerfil dialog = new DialogEditPerfil();
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
	public DialogEditPerfil() {
		setModal(true);
		setTitle("Editar Perfil");
		setBounds(100, 100, 418, 243);
		getContentPane().setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(106, 40, 202, 27);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(106, 103, 202, 27);
		getContentPane().add(txtNombre);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(22, 46, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(22, 103, 46, 14);
		getContentPane().add(lblNombre);
		
		JButton btnActualizar = new JButton("Guardar");
		btnActualizar.setBounds(143, 156, 121, 37);
		getContentPane().add(btnActualizar);

	}
}
