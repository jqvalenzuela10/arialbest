package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;

import com.itextpdf.text.pdf.PdfPublicKeySecurityHandler;

import mantenimientos.GestionEmpledos;
import model.DetalleCompra;
import model.Empleados;
import model.Privilegios;
import model.Tabla;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JdialogEditarUsu extends JDialog {
	public static JTextField txtNomUsu;
	public static JTextField txtApellidoPat;
	public static JTextField txtApeMat;
	public static JTextField txtEmail;
	public static JTextField txtSueldo;
	public static JTextField txtDirecUsu;
	public static JTextField txtTelf;
	public static JTextField txtCell;
	public static JTextField txtDniUsu;
	public static JTextField txtLogeo;
	static JTextField txtPswUsu;
	public static JTextField txtIdUsu;
	public static JCheckBox chckbxVentas;
	public static JCheckBox chckbxCompras;
	public static JCheckBox chckbxUsuarios;
	public static JCheckBox chckbxAlmacn;
	public static JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogEditarUsu dialog = new JdialogEditarUsu();
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
	public JdialogEditarUsu() {
		setModal(true);
		setTitle("Editar Usuario");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 761, 506);
		getContentPane().setLayout(null);
		
		txtNomUsu = new JTextField();
		txtNomUsu.setBounds(156, 89, 107, 20);
		getContentPane().add(txtNomUsu);
		txtNomUsu.setColumns(10);
		
		txtApellidoPat = new JTextField();
		txtApellidoPat.setColumns(10);
		txtApellidoPat.setBounds(156, 120, 107, 20);
		getContentPane().add(txtApellidoPat);
		
		txtApeMat = new JTextField();
		txtApeMat.setColumns(10);
		txtApeMat.setBounds(156, 151, 107, 20);
		getContentPane().add(txtApeMat);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(156, 182, 107, 20);
		getContentPane().add(txtEmail);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(156, 213, 107, 20);
		getContentPane().add(txtSueldo);
		txtSueldo.setColumns(10);
		
		txtDirecUsu = new JTextField();
		txtDirecUsu.setColumns(10);
		txtDirecUsu.setBounds(542, 58, 107, 20);
		getContentPane().add(txtDirecUsu);
		
		txtTelf = new JTextField();
		txtTelf.setColumns(10);
		txtTelf.setBounds(542, 89, 107, 20);
		getContentPane().add(txtTelf);
		
		txtCell = new JTextField();
		txtCell.setColumns(10);
		txtCell.setBounds(542, 120, 107, 20);
		getContentPane().add(txtCell);
		
		txtDniUsu = new JTextField();
		txtDniUsu.setColumns(10);
		txtDniUsu.setBounds(542, 151, 107, 20);
		getContentPane().add(txtDniUsu);
		
		txtLogeo = new JTextField();
		txtLogeo.setColumns(10);
		txtLogeo.setBounds(542, 182, 107, 20);
		getContentPane().add(txtLogeo);
		
		txtPswUsu = new JTextField();
		txtPswUsu.setColumns(10);
		txtPswUsu.setBounds(542, 213, 107, 20);
		getContentPane().add(txtPswUsu);
		
		chckbxVentas = new JCheckBox("Ventas");
		chckbxVentas.setBounds(89, 322, 97, 23);
		getContentPane().add(chckbxVentas);
		
		chckbxCompras = new JCheckBox("Compras");
		chckbxCompras.setBounds(208, 322, 97, 23);
		getContentPane().add(chckbxCompras);
		
		chckbxUsuarios = new JCheckBox("Usuarios");
		chckbxUsuarios.setBounds(336, 322, 97, 23);
		getContentPane().add(chckbxUsuarios);
		
		chckbxAlmacn = new JCheckBox("Almac\u00E9n");
		chckbxAlmacn.setBounds(470, 322, 97, 23);
		getContentPane().add(chckbxAlmacn);
		
		JLabel lblPrivilegios = new JLabel("Privilegios");
		lblPrivilegios.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPrivilegios.setBounds(89, 279, 86, 20);
		getContentPane().add(lblPrivilegios);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 92, 56, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(50, 123, 96, 14);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(50, 154, 96, 14);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 185, 96, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(50, 216, 96, 14);
		getContentPane().add(lblSueldo);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(420, 61, 96, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(420, 92, 96, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(420, 123, 96, 14);
		getContentPane().add(lblCelular);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(420, 154, 96, 14);
		getContentPane().add(lblDni);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(420, 185, 96, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(420, 216, 96, 14);
		getContentPane().add(lblContrasea);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();
			}
		});
		btnGuardar.setBounds(314, 416, 89, 23);
		getContentPane().add(btnGuardar);
		
		txtIdUsu = new JTextField();
		txtIdUsu.setEditable(false);
		txtIdUsu.setColumns(10);
		txtIdUsu.setBounds(156, 58, 107, 20);
		getContentPane().add(txtIdUsu);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(50, 61, 56, 14);
		getContentPane().add(lblId);

	}
	ArrayList<Empleados> permisos = new ArrayList<>();
	
	void actualizar() {

		ArrayList<Privilegios> e=new ArrayList<>();
		e.add(new Privilegios(("ventas"),chckbxVentas.isSelected()));
		e.add(new Privilegios(("compras"),chckbxCompras.isSelected()));
		e.add(new Privilegios(("almacen"),chckbxAlmacn.isSelected()));
		e.add(new Privilegios(("usuarios"),chckbxUsuarios.isSelected()));

		String nom_emp ,ape_mat_emp,ape_pat_emp,sex_emp ,email_emp,estado_emp,	fech_nac ,direc_emp,telf_emp,cell_emp,
		dni_emp,login_emp,psw_emp,id_tip_emp;
		int idEmp;
	 Double sueldo_emp;
		
		 idEmp=Integer.parseInt((txtIdUsu.getText()));
		nom_emp = txtNomUsu.getText();
		ape_mat_emp=txtApeMat.getText();
		ape_pat_emp=txtApellidoPat.getText();
		email_emp=txtEmail.getText();
		sueldo_emp=Double.parseDouble(txtSueldo.getText());
		direc_emp=txtDirecUsu.getText();
		telf_emp=txtTelf.getText();
		cell_emp=txtCell.getText();
		dni_emp=txtDniUsu.getText();
		login_emp=txtLogeo.getText();
		psw_emp=txtPswUsu.getText();
	

		Empleados c = new Empleados();
	
		c.setId_emp(idEmp);
		c.setNom_emp(nom_emp);
		c.setApe_mat_emp(ape_mat_emp);
		c.setApe_pat_emp(ape_pat_emp);
		c.setEmail_emp(email_emp);
		c.setSueldo_emp(sueldo_emp);
		c.setDirec_emp(direc_emp);
		c.setTelf_emp(telf_emp);
		c.setCell_emp(cell_emp);
		c.setDni_emp(dni_emp);
		c.setLogin_emp(login_emp);
		c.setPsw_emp(psw_emp);
		
		
		GestionEmpledos gc = new GestionEmpledos();

		int ok = gc.actualizarEmp_Priv(c, e);

		JOptionPane.showMessageDialog(null, ok+ " "+"Datos actualizados");
		if (ok == 0) {
			dispose();
		} else {
			dispose();
			Tabla.model.setRowCount(0);
		
			Tabla.listar();
		}
	}

	
	
}
