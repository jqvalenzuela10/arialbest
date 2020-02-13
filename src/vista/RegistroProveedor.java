package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import mantenimientos.GestionProveedor;
import model.HintTextField;
import model.Proveedores;
import model.RoundedCornerBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroProveedor extends JDialog {
	private HintTextField txtNombreProve;
	private HintTextField txtRuc;
	private HintTextField txtDireccion;
	private HintTextField txtTelefono;
	private HintTextField txtCelular;
	private HintTextField txtEmail;
	private HintTextField txtEstado;
	private HintTextField txtNroCuenta;
	private JLabel lblAviso;
	private JLabel lblAvisoTelefono;
	private JLabel lblCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroProveedor dialog = new RegistroProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroProveedor() {
		setModal(true);
		setBounds(100, 100,914, 621);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBackground(new Color(247, 249, 249));
		panel.setBounds(65, 152, 193, 40);
		getContentPane().add(panel);
		
		txtNombreProve = new HintTextField("Nombre Proveedor");
		txtNombreProve.setColumns(10);
		txtNombreProve.setBorder(null);
		txtNombreProve.setBackground(new Color(247, 249, 249));
		txtNombreProve.setBounds(59, 4, 124, 32);
		panel.add(txtNombreProve);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(3, 4, 42, 32);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(48, 0, 1, 49);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_2.setBackground(new Color(247, 249, 249));
		panel_2.setBounds(65, 299, 193, 40);
		getContentPane().add(panel_2);
		
		txtDireccion = new HintTextField("Direccion");
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(null);
		txtDireccion.setBackground(new Color(247, 249, 249));
		txtDireccion.setBounds(59, 4, 124, 32);
		panel_2.add(txtDireccion);
		
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
		panel_4.setBackground(new Color(247, 249, 249));
		panel_4.setBounds(65, 227, 193, 40);
		getContentPane().add(panel_4);
		
		txtRuc = new HintTextField("RUC");
		txtRuc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c=arg0.getKeyChar();
				System.err.print(c);
				if(Character.isAlphabetic(c)) {
					getToolkit().beep();
					lblAviso.setText("solo numeros");
					arg0.consume();
				}
				else {
					lblAviso.setText("");
				}
				
			}
		});
		txtRuc.setColumns(10);
		txtRuc.setBorder(null);
		txtRuc.setBackground(new Color(247, 249, 249));
		txtRuc.setBounds(59, 4, 124, 32);
		panel_4.add(txtRuc);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(3, 4, 42, 32);
		panel_4.add(label_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(48, 0, 1, 49);
		panel_4.add(panel_5);
		
		JLabel lblDatosProveedor = new JLabel("Datos Proveedor");
		lblDatosProveedor.setForeground(Color.BLACK);
		lblDatosProveedor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDatosProveedor.setBounds(65, 117, 143, 14);
		getContentPane().add(lblDatosProveedor);
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/proveedor.jpg"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel_6.setBackground(new Color(45, 54, 63));
		panel_6.setBounds(0, 0, 898, 90);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNuevoProveedor = new JLabel("Nuevo Proveedor");
		lblNuevoProveedor.setBounds(128, 26, 176, 53);
		panel_6.add(lblNuevoProveedor);
		lblNuevoProveedor.setForeground(Color.WHITE);
		lblNuevoProveedor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(52, 26, 66, 50);
		label_3.setIcon(ico);
		panel_6.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_8.setBackground(new Color(247, 249, 249));
		panel_8.setBounds(65, 526, 193, 40);
		getContentPane().add(panel_8);
		
		txtEmail = new HintTextField("Email");
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(247, 249, 249));
		txtEmail.setBounds(59, 4, 124, 32);
		panel_8.add(txtEmail);
		
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
		panel_10.setBackground(new Color(247, 249, 249));
		panel_10.setBounds(65, 445, 193, 40);
		getContentPane().add(panel_10);
		
		txtCelular = new HintTextField("Celular");
		txtCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				System.err.print(c);
				if(Character.isAlphabetic(c)) {
					getToolkit().beep();
					lblCelular.setText("solo numeros");
					e.consume();
				}
				else {
					lblCelular.setText("");
				}
			}
		});
		txtCelular.setColumns(10);
		txtCelular.setBorder(null);
		txtCelular.setBackground(new Color(247, 249, 249));
		txtCelular.setBounds(59, 4, 124, 32);
		panel_10.add(txtCelular);
		
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
		panel_12.setBackground(new Color(247, 249, 249));
		panel_12.setBounds(65, 370, 193, 40);
		getContentPane().add(panel_12);
		
		txtTelefono = new HintTextField("Telefono");
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c=arg0.getKeyChar();
				System.err.print(c);
				if(Character.isAlphabetic(c)) {
					getToolkit().beep();
					lblAvisoTelefono.setText("solo numeros");
					arg0.consume();
				}
				else {
					lblAvisoTelefono.setText("");
				}
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBackground(new Color(247, 249, 249));
		txtTelefono.setBounds(59, 4, 124, 32);
		panel_12.add(txtTelefono);
		
		JLabel label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(3, 4, 42, 32);
		panel_12.add(label_6);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.LIGHT_GRAY);
		panel_13.setBounds(48, 0, 1, 49);
		panel_12.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_14.setBackground(new Color(247, 249, 249));
		panel_14.setBounds(452, 152, 193, 40);
		getContentPane().add(panel_14);
		
		txtEstado = new HintTextField("Estado");
		txtEstado.setColumns(10);
		txtEstado.setBorder(null);
		txtEstado.setBackground(new Color(247, 249, 249));
		txtEstado.setBounds(59, 4, 124, 32);
		panel_14.add(txtEstado);
		
		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(3, 4, 42, 32);
		panel_14.add(label_7);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_15.setBounds(48, 0, 1, 49);
		panel_14.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_16.setBackground(new Color(247, 249, 249));
		panel_16.setBounds(452, 227, 193, 40);
		getContentPane().add(panel_16);
		
		txtNroCuenta = new HintTextField("Nro Cuenta");
		txtNroCuenta.setColumns(10);
		txtNroCuenta.setBorder(null);
		txtNroCuenta.setBackground(new Color(247, 249, 249));
		txtNroCuenta.setBounds(59, 4, 124, 32);
		panel_16.add(txtNroCuenta);
		
		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(3, 4, 42, 32);
		panel_16.add(label_8);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.LIGHT_GRAY);
		panel_17.setBounds(48, 0, 1, 49);
		panel_16.add(panel_17);
		
		JPanel btnRegistrar = new JPanel() {
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}
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
				
				IntProveedor.model.setRowCount(0);
				IntProveedor.listado();
				dispose();
				
			}
		});
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setLayout(null);
		btnRegistrar.setBackground(new Color(15, 149, 236));
		btnRegistrar.setBounds(452, 526, 193, 40);
		getContentPane().add(btnRegistrar);
		
		JLabel label_9 = new JLabel("Registrar");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		label_9.setBounds(62, 0, 80, 40);
		btnRegistrar.add(label_9);
		
		lblAviso = new JLabel("");
		lblAviso.setBounds(65, 271, 193, 17);
		lblAviso.setForeground(Color.decode("#dc3545"));
		getContentPane().add(lblAviso);
		
		lblAvisoTelefono = new JLabel("");
		lblAvisoTelefono.setForeground(new Color(220, 53, 69));
		lblAvisoTelefono.setBounds(66, 411, 193, 17);
		getContentPane().add(lblAvisoTelefono);
		
		lblCelular = new JLabel("");
		lblCelular.setForeground(new Color(220, 53, 69));
		lblCelular.setBounds(65, 487, 193, 17);
		getContentPane().add(lblCelular);
		
	}
	
	void registrar() {
		
		String nombre,ruc,direc,tel,cel,email,estado,cuenta;
		
		nombre=txtNombreProve.getText();
		ruc=txtRuc.getText();
		direc=txtDireccion.getText();
		tel=txtTelefono.getText();
		cel=txtCelular.getText();
		email=txtEmail.getText();
		estado=txtEstado.getText();
		cuenta=txtNroCuenta.getText();
		
		Proveedores p=new Proveedores();
		p.setNom_prov(nombre);
		p.setRuc_prov(ruc);
		p.setDirec_prov(direc);
		p.setTelf_prov(tel);
		p.setCell_prov(cel);
		p.setEmail_prov(email);
		p.setEstado_prov(estado);
		p.setNro_cuenta_prov(cuenta);
		
		int ok=new GestionProveedor().registrar(p);
		if(ok!=0) {
			JOptionPane.showMessageDialog(null, "registro exitoso");
			
		}
		else {
			JOptionPane.showMessageDialog(null, "error al registrar un proveedor");
		}
		
	}
	
}
