package vista;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import javax.swing.JTextField;

import model.Clientes;
import model.Empleados;
import model.HintTextField;
import model.Privilegios;
import model.RoundedCornerBorder;
import model.Tabla;
import model.Tipo_documento;

import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionClientes;
import mantenimientos.GestionEmpledos;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class JdialogRegistroUsuario extends JDialog {
	private JTextField txtNombre;
	private JPanel btnRegistrar;
	private HintTextField txtDni;
	private HintTextField txtApeMat;
	private HintTextField txtApePat;
	private HintTextField txtSueldo;
	private HintTextField txtTelf;
	private HintTextField txtCorreo;
	private HintTextField txtCell;
	private HintTextField txtDomicilio;
	private HintTextField txtLogin;
	private HintTextField txtPsw;
	private JComboBox cboCargo;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
private  ButtonGroup genero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogRegistroUsuario dialog = new JdialogRegistroUsuario();
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

	public JdialogRegistroUsuario() {
		setModal(true);
		setTitle("Registro Usuario");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 914, 585);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBackground(Color.decode("#F7F9F9"));
		panel.setBounds(59, 48, 193, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtNombre = new HintTextField("Nombre Usuario") ;
		txtNombre.setBackground(Color.decode("#F7F9F9"));
		txtNombre.setBounds(59, 4, 124, 32);
		panel.add(txtNombre);
		txtNombre.setBorder(null);
		txtNombre.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(3, 4, 42, 32);
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/img/user.png"));
		Image i = iconSearch.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		label.setIcon(ic);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(48, 0, 1, 49);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_2.setBackground(Color.decode("#F7F9F9"));
		panel_2.setBounds(59, 99, 193, 40);
		getContentPane().add(panel_2);
		
		txtApePat = new HintTextField("Apellido Paterno");
		txtApePat.setBackground(Color.decode("#F7F9F9"));
		txtApePat.setColumns(10);
		txtApePat.setBorder(null);
		txtApePat.setBounds(59, 4, 124, 32);
		panel_2.add(txtApePat);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(3, 4, 42, 32);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(48, 0, 1, 49);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_4.setBackground(Color.decode("#F7F9F9"));
		panel_4.setBounds(283, 48, 193, 40);
		getContentPane().add(panel_4);
		
		txtApeMat = new HintTextField("Apellido Materno");
		txtApeMat.setBackground(Color.decode("#F7F9F9"));
		txtApeMat.setColumns(10);
		txtApeMat.setBorder(null);
		txtApeMat.setBounds(59, 4, 124, 32);
		panel_4.add(txtApeMat);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(3, 4, 42, 32);
		panel_4.add(label_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(48, 0, 1, 49);
		panel_4.add(panel_5);
		
		JLabel lblNombresYApellidos = new JLabel("Nombres y Apellidos");
		lblNombresYApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNombresYApellidos.setForeground(new Color(15, 149, 236));
		lblNombresYApellidos.setBounds(59, 11, 143, 14);
		getContentPane().add(lblNombresYApellidos);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setForeground(new Color(15, 149, 236));
		lblGenero.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblGenero.setBounds(59, 173, 164, 14);
		getContentPane().add(lblGenero);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setActionCommand("H");
		rdbtnHombre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnHombre.setBackground(Color.WHITE);
		rdbtnHombre.setBounds(59, 214, 82, 23);
		getContentPane().add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setActionCommand("M");
		rdbtnMujer.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnMujer.setBackground(Color.WHITE);
		rdbtnMujer.setBounds(156, 214, 82, 23);
		getContentPane().add(rdbtnMujer);
		
		
		genero=new ButtonGroup();
		genero.add(rdbtnHombre);
		genero.add(rdbtnMujer);
		
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setForeground(new Color(15, 149, 236));
		lblIdentificacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIdentificacion.setBounds(59, 273, 164, 14);
		getContentPane().add(lblIdentificacion);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_6.setBackground(Color.decode("#F7F9F9"));
		panel_6.setBounds(59, 309, 193, 40);
		getContentPane().add(panel_6);
		
		txtDni = new HintTextField("DNI");
		txtDni.setBackground(Color.decode("#F7F9F9"));
		txtDni.setColumns(10);
		txtDni.setBorder(null);
		txtDni.setBounds(59, 4, 124, 32);
		panel_6.add(txtDni);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(3, 4, 42, 32);
		panel_6.add(label_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(48, 0, 1, 49);
		panel_6.add(panel_7);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setForeground(new Color(15, 149, 236));
		lblContacto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblContacto.setBounds(59, 384, 164, 14);
		getContentPane().add(lblContacto);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_8.setBackground(Color.decode("#F7F9F9"));
		panel_8.setBounds(59, 417, 193, 40);
		getContentPane().add(panel_8);
		
		txtCorreo = new HintTextField("Correo Electronico");
		txtCorreo.setBackground(Color.decode("#F7F9F9"));
		txtCorreo.setColumns(10);
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(59, 4, 124, 32);
		panel_8.add(txtCorreo);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(3, 4, 42, 32);
		panel_8.add(label_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setBounds(48, 0, 1, 49);
		panel_8.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_10.setBackground(Color.decode("#F7F9F9"));
		panel_10.setBounds(283, 417, 193, 40);
		getContentPane().add(panel_10);
		
		txtTelf = new HintTextField("Telefono");
		txtTelf.setBackground(Color.decode("#F7F9F9"));
		txtTelf.setColumns(10);
		txtTelf.setBorder(null);
		txtTelf.setBounds(59, 4, 124, 32);
		panel_10.add(txtTelf);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(3, 4, 42, 32);
		panel_10.add(label_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.LIGHT_GRAY);
		panel_11.setBounds(48, 0, 1, 49);
		panel_10.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_12.setBackground(Color.decode("#F7F9F9"));
		panel_12.setBounds(59, 468, 193, 40);
		getContentPane().add(panel_12);
		
		txtCell = new HintTextField("Celular");
		txtCell.setBackground(Color.decode("#F7F9F9"));
		txtCell.setColumns(10);
		txtCell.setBorder(null);
		txtCell.setBounds(59, 4, 124, 32);
		panel_12.add(txtCell);
		
		JLabel label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(3, 4, 42, 32);
		panel_12.add(label_6);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.LIGHT_GRAY);
		panel_13.setBounds(48, 0, 1, 49);
		panel_12.add(panel_13);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setForeground(new Color(15, 149, 236));
		lblSueldo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSueldo.setBounds(283, 275, 164, 14);
		getContentPane().add(lblSueldo);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_14.setBackground(Color.decode("#F7F9F9"));
		panel_14.setBounds(283, 309, 193, 40);
		getContentPane().add(panel_14);
		
		txtSueldo = new HintTextField("Sueldo");
		txtSueldo.setBackground(Color.decode("#F7F9F9"));
		txtSueldo.setColumns(10);
		txtSueldo.setBorder(null);
		txtSueldo.setBounds(59, 4, 124, 32);
		panel_14.add(txtSueldo);
		
		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(3, 4, 42, 32);
		panel_14.add(label_7);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_15.setBounds(48, 0, 1, 49);
		panel_14.add(panel_15);
		
		JLabel lblTuCuenta = new JLabel("Tu Cuenta");
		lblTuCuenta.setForeground(new Color(15, 149, 236));
		lblTuCuenta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTuCuenta.setBounds(628, 13, 164, 14);
		getContentPane().add(lblTuCuenta);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_16.setBackground(Color.decode("#F7F9F9"));
		panel_16.setBounds(628, 48, 193, 40);
		getContentPane().add(panel_16);
		
		txtLogin = new HintTextField("Usuario");
		txtLogin.setBackground(Color.decode("#F7F9F9"));
		txtLogin.setColumns(10);
		txtLogin.setBorder(null);
		txtLogin.setBounds(59, 4, 124, 32);
		panel_16.add(txtLogin);
		
		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(3, 4, 42, 32);
		panel_16.add(label_8);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.LIGHT_GRAY);
		panel_17.setBounds(48, 0, 1, 49);
		panel_16.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_18.setBackground(Color.decode("#F7F9F9"));
		panel_18.setBounds(628, 124, 193, 40);
		getContentPane().add(panel_18);
		
		txtPsw = new HintTextField("Contraseña");
		txtPsw.setBackground(Color.decode("#F7F9F9"));
		txtPsw.setColumns(10);
		txtPsw.setBorder(null);
		txtPsw.setBounds(59, 4, 124, 32);
		panel_18.add(txtPsw);
		
		JLabel label_9 = new JLabel("");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(3, 4, 42, 32);
		panel_18.add(label_9);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.LIGHT_GRAY);
		panel_19.setBounds(48, 0, 1, 49);
		panel_18.add(panel_19);
		
		cboCargo = new JComboBox();
		cboCargo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		cboCargo.setBackground(Color.WHITE);
		cboCargo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Vendedor"}));
		cboCargo.setBounds(630, 209, 191, 40);
		getContentPane().add(cboCargo);
		
		btnRegistrar = new JPanel() {
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setBackground(new Color(15, 149, 236));
		btnRegistrar.setBounds(643, 417, 164, 40);
		getContentPane().add(btnRegistrar);
		btnRegistrar.setLayout(null);
		
		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setForeground(Color.WHITE);
		lblRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRegistrar.setBounds(41, 0, 80, 40);
		btnRegistrar.add(lblRegistrar);
		
		JPanel panel_20 = new JPanel();
		panel_20.setLayout(null);
		panel_20.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_20.setBackground(new Color(247, 249, 249));
		panel_20.setBounds(283, 468, 193, 40);
		getContentPane().add(panel_20);
		
		txtDomicilio = new HintTextField("Domicilio");
		txtDomicilio.setColumns(10);
		txtDomicilio.setBorder(null);
		txtDomicilio.setBackground(new Color(247, 249, 249));
		txtDomicilio.setBounds(59, 4, 124, 32);
		panel_20.add(txtDomicilio);
		
		JLabel label_10 = new JLabel("");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(3, 4, 42, 32);
		panel_20.add(label_10);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.LIGHT_GRAY);
		panel_21.setBounds(48, 0, 1, 49);
		panel_20.add(panel_21);

	}
	
	
	
	void registrar() {

		ArrayList<Privilegios> e=new ArrayList<>();
		
		
		int id;
		String nom, apePat,apeMat,sex,email,estado, direc, telf,cell, dni,login,psw,tipUsu;
		
		double sueldo;
		ArrayList<Empleados>list=new GestionEmpledos().listado();
		
		Empleados ultimo=list.get(list.size() -1 );
		System.out.println("la cantidad :"+list.get(list.size() -1 ));
		id=ultimo.getId_emp()+1;

		nom = txtNombre.getText();
		apePat = txtApePat.getText();
		apeMat = txtApeMat.getText();
		sex = genero.getSelection().getActionCommand();
		email = txtDni.getText();
		sueldo=Double.parseDouble(txtSueldo.getText());
	    direc=txtDomicilio.getText();
	    telf=txtTelf.getText();
	    cell=txtCell.getText();
	    dni=txtDni.getText();
	    login=txtLogin.getText();
	    psw=txtPsw.getText();
	    tipUsu=Integer.toString(cboCargo.getSelectedIndex()+1);
	    System.out.println(tipUsu);
	    String usu=cboCargo.getSelectedItem().toString();
	  
	    if (usu.equals("Vendedor")) {
	    	e.add(new Privilegios(("ventas"),true));
			e.add(new Privilegios(("compras"),true));
			e.add(new Privilegios(("almacen"),false));
			e.add(new Privilegios(("usuarios"),false));
			System.out.println("entro al vendor");
		}
	    if (usu.equals("Administrador")) {
	    	e.add(new Privilegios(("ventas"),true));
			e.add(new Privilegios(("compras"),true));
			e.add(new Privilegios(("almacen"),true));
			e.add(new Privilegios(("usuarios"),true));
			System.out.println("entro al admi");
		}

	  


	 
	    
			Empleados c = new Empleados();
			c.setId_emp(id);
			c.setNom_emp(nom);
			c.setApe_pat_emp(apePat);
			c.setApe_mat_emp(apeMat);
			c.setSex_emp(sex);
			c.setEmail_emp(email);
			c.setSueldo_emp(sueldo);
			c.setEstado_emp("ACTIVO");
			c.setDirec_emp(direc);
			c.setTelf_emp(telf);
			c.setCell_emp(cell);
			c.setDni_emp(dni);
			c.setLogin_emp(login);
			c.setPsw_emp(psw);
			c.setId_tip_emp(tipUsu);

			GestionEmpledos gc = new GestionEmpledos();

			int ok = gc.registrar(c,e);
			
			if (ok == 0) {
				
			} else {
				JOptionPane.showMessageDialog(null, "registro correcto");
				dispose();
				Tabla.model.setRowCount(0);
			
				Tabla.listar();
			}
			
			

		}
		
		

		
			
}
