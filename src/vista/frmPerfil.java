package vista;



import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;


import mantenimientos.GestionEmpledos;
import model.Empleados;
import model.JPanelConFondo;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.Cursor;
import java.awt.Dialog;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Toolkit;

public class frmPerfil extends JDialog {
	public static JLabel lblimagenUsu;
	public static JLabel lblNombre_1;
	public static JLabel lblCargo;
	public static JTextField txtNombre_2;
	public static JTextField txtApePat;
	public static JTextField txtDireccion;
	public static JTextField txtTelf;
	public static JTextField txtCell;
	public static JTextField txtUsu;
	public static JTextField txtApeMat;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public frmPerfil(JFrame jFrame) {
		
		super(jFrame);

		setIconImage(Toolkit.getDefaultToolkit().getImage(frmPerfil.class.getResource("/img/user2.png")));
		setTitle("Perfil");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 472, 621);
		
		
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);
	
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblNombre.setBounds(49, 256, 66, 14);
			getContentPane().add(lblNombre);
	
			JLabel lblNewLabel = new JLabel("Apellido Paterno");
			lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblNewLabel.setBounds(49, 291, 114, 14);
			getContentPane().add(lblNewLabel);
		
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblDireccion.setBounds(49, 362, 66, 14);
			getContentPane().add(lblDireccion);
		
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblTelefono.setBounds(49, 397, 66, 14);
			getContentPane().add(lblTelefono);
		
			JLabel lblCelular = new JLabel("Celular");
			lblCelular.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblCelular.setBounds(49, 432, 66, 14);
			getContentPane().add(lblCelular);
		
		
			JLabel lblNewLabel_1 = new JLabel("Usuario");
			lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblNewLabel_1.setBounds(49, 468, 66, 14);
			getContentPane().add(lblNewLabel_1);
		
		
			JLabel lblGrabar = new JLabel("Grabar");
			lblGrabar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String nombre,apePat,apeMat,direccion,telf,cell,login;
					
					nombre=txtNombre_2.getText();
					apePat=txtApePat.getText();
					apeMat=txtApeMat.getText();
					direccion=txtDireccion.getText();
					telf=txtTelf.getText();
					cell=txtCell.getText();
					login=txtUsu.getText();
					
					
					
					Empleados c=new Empleados();
					c.setNom_emp(nombre);
					c.setApe_pat_emp(apePat);
					c.setApe_mat_emp(apeMat);
					c.setDirec_emp(direccion);
					c.setTelf_emp(telf);
					c.setCell_emp(cell);
					c.setLogin_emp(login);
					c.setId_emp(FrmLogin.e.getId_emp());
					
				int i=new GestionEmpledos().actualizarPerfilEmp(c);
				
				if (i!=0) {
					JOptionPane.showMessageDialog(null, i + " Datos Actualizados");
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Problemas al Actualizar");
				}
				}
			});
		
			lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
			lblGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblGrabar.setFont(new Font("Perpetua", Font.PLAIN, 25));
			lblGrabar.setBounds(181, 513, 86, 30);
			getContentPane().add(lblGrabar);
		
		
		JLabel lblCambiarContrasea = new JLabel("Cambiar Contrase\u00F1a");
		lblCambiarContrasea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JdialogCambiarContraseña c=new JdialogCambiarContraseña();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		lblCambiarContrasea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCambiarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambiarContrasea.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCambiarContrasea.setForeground(Color.decode("#0f95ec"));
		lblCambiarContrasea.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblCambiarContrasea.setBounds(173, 551, 112, 30);
		getContentPane().add(lblCambiarContrasea);
		
		JPanelConFondo panel = new JPanelConFondo();
		panel.setBounds(0, 0, 466, 224);
		panel.setImagen("/img/fondoPerfil.jpg");//  LLAMO METODO PARA INTRODUCIR IMAGEN (CLASE)
		getContentPane().add(panel);
		panel.setLayout(null);
		
			lblNombre_1 = new JLabel("");
			lblNombre_1.setBounds(173, 134, 107, 22);
			panel.add(lblNombre_1);
			lblNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		
		
			lblCargo = new JLabel("");
			lblCargo.setBounds(173, 165, 107, 22);
			panel.add(lblCargo);
			lblCargo.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
			lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
			lblimagenUsu = new JLabel("");
			lblimagenUsu.setBounds(173, 37, 107, 91);
			panel.add(lblimagenUsu);
		
		
		txtNombre_2 = new JTextField();
		txtNombre_2.setBounds(170, 253, 178, 25);
		getContentPane().add(txtNombre_2);
		txtNombre_2.setColumns(10);
		
		txtApePat = new JTextField();
		txtApePat.setColumns(10);
		txtApePat.setBounds(170, 287, 178, 25);
		getContentPane().add(txtApePat);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(170, 358, 178, 25);
		getContentPane().add(txtDireccion);
		
		txtTelf = new JTextField();
		txtTelf.setColumns(10);
		txtTelf.setBounds(170, 393, 178, 25);
		getContentPane().add(txtTelf);
		
		txtCell = new JTextField();
		txtCell.setColumns(10);
		txtCell.setBounds(170, 428, 178, 25);
		getContentPane().add(txtCell);
		
		txtUsu = new JTextField();
		txtUsu.setColumns(10);
		txtUsu.setBounds(170, 464, 178, 25);
		getContentPane().add(txtUsu);
		
			txtApeMat = new JTextField();
			txtApeMat.setColumns(10);
			txtApeMat.setBounds(170, 322, 178, 25);
			getContentPane().add(txtApeMat);
		
		
			JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
			lblApellidoMaterno.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblApellidoMaterno.setBounds(49, 327, 114, 14);
			getContentPane().add(lblApellidoMaterno);
		
		
	}
}
