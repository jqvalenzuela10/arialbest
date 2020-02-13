package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.mail.internet.NewsAddress;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionEmpledos;
import model.Clientes;
import model.Empleados;
import model.HintTextField;
import model.RoundedCornerBorder;
import model.TipoEmpleado;
import utils.clsArial;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class FrmLogin extends javax.swing.JFrame  {
public String colorPrincipal="#232f43";
private JPanel Jpanel_menu_login;
private JPasswordField txtClaveUsu;
public static HintTextField txtIngUsu;
public static Empleados e;
private JPanel btnIniciarSecin;
private JPanel btnLogin;
private JPanel btnRegistrar;
private JLabel lblRegistrar;
private JLabel lblLogin;
private JLabel lblOlvidoContraseña;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
FrmLogin frame = new FrmLogin();
frame.setVisible(true);

frame.setLocationRelativeTo(null);
/**/

/*NOSE PORQUE FUNCIONA LO DE ENFOCAR EL TEXFIELD "INGRESE USUARIO" AQUI SI NO LO PONGO EN OTRO LADO NO SE ENFOCA*/
txtIngUsu.requestFocus();// <---------- ENFOCA EL TEXFIELD PARA
//FUNCIONALIDAD DEL SETCARETPOSITION
txtIngUsu.setCaretPosition(0); 
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**/
/**
* Create the frame.
*/
public FrmLogin() {
setUndecorated(true);
setVisible(true);


setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 983, 509);

Jpanel_menu_login = new JPanel();
Jpanel_menu_login.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(Jpanel_menu_login);
Jpanel_menu_login.setLayout(null);

JPanel jPanel_banner = new JPanel();
jPanel_banner.setBounds(0, 0, 575, 509);
Jpanel_menu_login.add(jPanel_banner);
jPanel_banner.setLayout(null);

JLabel lblBanner = new JLabel("");
lblBanner.setBounds(0, 0, 576, 509);
jPanel_banner.add(lblBanner);


JMenuBar menuBar = new JMenuBar();
menuBar.setBounds(6, 157, 306, 0);
jPanel_banner.add(menuBar);

JMenu mnEnter = new JMenu("Enter");

menuBar.add(mnEnter);

JMenuItem mntmPressEnter = new JMenuItem("Press Enter");
mntmPressEnter.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
validarLogin();
}
});
mntmPressEnter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
mnEnter.add(mntmPressEnter);

/*-----------------------> FUNCIONALIDAD DEL GIF (BANNER)<----------------------------*/

addComponentListener(new ComponentAdapter() {
@Override
public void componentResized(ComponentEvent ev) {
Image imgFondo = new ImageIcon(getClass().getResource("/img/pastillas.gif")).getImage();
lblBanner.setIcon(new ImageIcon(imgFondo.getScaledInstance(576	, 509, Image.SCALE_DEFAULT)));
}
});
/*-------------------------------------------------------------------------------*/

JPanel Jpanel_Login = new JPanel();
Jpanel_Login.setBorder(null);
Jpanel_Login.setBackground(Color.WHITE);
Jpanel_Login.setBounds(575, 29, 408, 480);
Jpanel_menu_login.add(Jpanel_Login);
Jpanel_Login.setLayout(null);

JLabel lblIniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
lblIniciarSesion.setBounds(115, 128, 212, 35);
lblIniciarSesion.setFont(new Font("Candara", Font.PLAIN, 34));
lblIniciarSesion.setForeground(Color.decode(clsArial.colorGrisOscuro));
lblIniciarSesion.setBackground(Color.WHITE);
Jpanel_Login.add(lblIniciarSesion);
btnIniciarSecin = new JPanel() {
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
btnIniciarSecin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
btnIniciarSecin.setLayout(null);
btnIniciarSecin.setBackground(new Color(51, 51, 51));
btnIniciarSecin.setBounds(145, 354, 132, 35);
Jpanel_Login.add(btnIniciarSecin);
JLabel lblIngresar = new JLabel("Ingresar");
lblIngresar.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		validarLogin();
	}
});
lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
lblIngresar.setForeground(Color.WHITE);
lblIngresar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
lblIngresar.setBounds(0, 0, 132, 35);
btnIniciarSecin.add(lblIngresar);
lblOlvidoContraseña = new JLabel("Olvidaste Tu Contrase\u00F1a ?");
lblOlvidoContraseña.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JdialogOlvidateContraseña olvidateContraseña=new JdialogOlvidateContraseña();
		olvidateContraseña.setVisible(true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		lblOlvidoContraseña.setForeground(Color.GRAY);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		lblOlvidoContraseña.setForeground(Color.LIGHT_GRAY);
	}
});
lblOlvidoContraseña.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
lblOlvidoContraseña.setForeground(Color.LIGHT_GRAY);
lblOlvidoContraseña.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
lblOlvidoContraseña.setHorizontalAlignment(SwingConstants.CENTER);
lblOlvidoContraseña.setBounds(115, 441, 198, 14);
Jpanel_Login.add(lblOlvidoContraseña);
JPanel panel = new JPanel() {
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
panel.setBackground(Color.WHITE);
panel.setBounds(60, 215, 311, 40);
Jpanel_Login.add(panel);
panel.setLayout(null);

JLabel lblUser = new JLabel("");
lblUser.setHorizontalAlignment(SwingConstants.CENTER);
lblUser.setBounds(10, 2, 36, 35);
panel.add(lblUser);
lblUser.setForeground(Color.BLACK);
clsArial clsArial=new clsArial();
 clsArial.modifiedIcon("/img/user.png", 20, 25,lblUser);
 
txtIngUsu = new HintTextField("Ingrese Su Usuario");
txtIngUsu.setBounds(56, 1, 212, 35);

txtIngUsu.setBorder(null);
txtIngUsu.setHorizontalAlignment(SwingConstants.CENTER);
txtIngUsu.setCaretColor(Color.LIGHT_GRAY);
txtIngUsu.setAlignmentY(Component.TOP_ALIGNMENT);
txtIngUsu.setBackground(Color.WHITE);
txtIngUsu.setForeground(Color.LIGHT_GRAY);
txtIngUsu.setFont(new Font("Segoe UI", Font.PLAIN, 17));
txtIngUsu.setColumns(10);
txtIngUsu.requestFocus();// <---------- ENFOCA EL TEXFIELD PARA
// FUNCIONALIDAD DEL SETCARETPOSITION
txtIngUsu.setCaretPosition(0);
panel.add(txtIngUsu);
JPanel panel_3 = new JPanel() {
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
panel_3.setLayout(null);
panel_3.setBackground(Color.WHITE);
panel_3.setBounds(60, 276, 311, 40);
Jpanel_Login.add(panel_3);

JLabel lblPadlock = new JLabel("");
lblPadlock.setHorizontalAlignment(SwingConstants.CENTER);
lblPadlock.setBounds(10, 2, 36, 35);
panel_3.add(lblPadlock);
clsArial.modifiedIcon("/img/candado.png", 23, 30,lblPadlock);

txtClaveUsu = new JPasswordField();
txtClaveUsu.setText("Ingrese Su Clave");
txtClaveUsu.setBounds(54, 1, 190, 35);
panel_3.add(txtClaveUsu);
txtClaveUsu.setCaretColor(Color.GRAY);
txtClaveUsu.setBackground(Color.WHITE);
txtClaveUsu.setHorizontalAlignment(SwingConstants.CENTER);
txtClaveUsu.setForeground(Color.LIGHT_GRAY);
txtClaveUsu.setFont(new Font("Segoe UI", Font.ITALIC, 17));
txtClaveUsu.setEchoChar((char) 0);// <--------- QUITA LA OPCION DEL *
txtClaveUsu.setCaretPosition(0);
txtClaveUsu.setBorder(null);
btnLogin = new JPanel(){
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
btnLogin.setBounds(186, 33, 90, 35);
Jpanel_Login.add(btnLogin);
btnLogin.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		lblLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.decode(clsArial.colorCeleste));
		
		lblRegistrar.setForeground(Color.GRAY);
		btnRegistrar.setBackground(Color.WHITE);
	}
});
btnLogin.setBackground(Color.decode(clsArial.colorCeleste));
btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
btnLogin.setLayout(null);
lblLogin = new JLabel("Comercial");
lblLogin.setBounds(10, 0, 70, 35);
btnLogin.add(lblLogin);
lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
lblLogin.setForeground(Color.WHITE);
lblLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
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
btnRegistrar.setBackground(Color.WHITE);
btnRegistrar.setBounds(281, 33, 90, 35);
Jpanel_Login.add(btnRegistrar);
btnRegistrar.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		FrmMenuPrincipalContable contable=new FrmMenuPrincipalContable();
		contable.setVisible(true);
	}
});
btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
btnRegistrar.setLayout(null);
lblRegistrar = new JLabel("Contable");
lblRegistrar.setBounds(11, 0, 68, 35);
btnRegistrar.add(lblRegistrar);
lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
lblRegistrar.setForeground(Color.GRAY);
lblRegistrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
JLabel lblRegistrate = new JLabel("Registrarse");
lblRegistrate.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseEntered(MouseEvent arg0) {
		lblRegistrate.setForeground(Color.GRAY);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		lblRegistrate.setForeground(Color.LIGHT_GRAY);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		lblLogin.setForeground(Color.GRAY);
		btnLogin.setBackground(Color.WHITE);
		
		lblRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.decode(clsArial.colorCeleste));
	String claveAdmin=	JOptionPane.showInputDialog(null,"clave del administrador","Acceso Restringido",JOptionPane.INFORMATION_MESSAGE);
		if (claveAdmin.equals("0")) {
			
		}
		JdialogRegistroUsuario registroUsuario=new JdialogRegistroUsuario();
		registroUsuario.setVisible(true);

	}
});
lblRegistrate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
lblRegistrate.setHorizontalAlignment(SwingConstants.CENTER);
lblRegistrate.setForeground(Color.LIGHT_GRAY);
lblRegistrate.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
lblRegistrate.setBounds(115, 409, 198, 21);
Jpanel_Login.add(lblRegistrate);
txtClaveUsu.requestFocus();

txtClaveUsu.addKeyListener(new KeyAdapter() {

/*----------> FUNCIONALIDAD  AL SOLTAR LA TECLA  <------------*/
@SuppressWarnings("deprecation")
public void keyReleased(KeyEvent e) {
if (txtClaveUsu.getText().equals("")) {
txtClaveUsu.setEchoChar((char) 0);

txtClaveUsu.setText("Ingrese Su Clave");
txtClaveUsu.setCaretPosition(0);// <---------- COLOCA EL
// CURSOR AL COMIENZO
txtClaveUsu.setForeground(Color.LIGHT_GRAY);
txtClaveUsu.setFont(new Font("Segoe UI", Font.ITALIC, 17));

}

}

/*----------> FUNCIONALIDAD  AL PULSAR LA TECLA  <------------*/
@SuppressWarnings("deprecation")
public void keyPressed(KeyEvent e) {
if (txtClaveUsu.getText().equals("Ingrese Su Clave")) {
txtClaveUsu.setEchoChar('*');
txtClaveUsu.setText("");
txtClaveUsu.setForeground(Color.black);
txtClaveUsu.setFont(new Font("Segoe UI", Font.ITALIC, 17));
}

}
});
txtIngUsu.addKeyListener(new KeyAdapter() {

public void keyReleased(KeyEvent e) {

validacionUsuario();
if (txtIngUsu.getText().equals("")) {


txtIngUsu.setCaretPosition(0);// <---------- COLOCA EL
// CURSOR AL COMIENZO
txtIngUsu.setForeground(Color.LIGHT_GRAY);
txtIngUsu.setFont(new Font("Segoe UI", Font.ITALIC, 17));
}

}

/*----------> FUNCIONALIDAD  AL PULSAR LA TECLA  <------------*/
public void keyPressed(KeyEvent e) {
if (txtIngUsu.getText().equals("Ingrese Su Usuario")) {
txtIngUsu.setForeground(Color.black);

txtIngUsu.setFont(new Font("Segoe UI", Font.ITALIC, 17));
}

}
});

JPanel jPanel_Barra = new JPanel();
jPanel_Barra.setBackground(Color.WHITE);
jPanel_Barra.setBounds(575, 0, 408, 32);
Jpanel_menu_login.add(jPanel_Barra);
jPanel_Barra.setLayout(null);

JLabel lblCerrar = new JLabel("");
lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
lblCerrar.setBackground(new Color(51, 51, 51));
lblCerrar.setBounds(372, 0, 36, 30);
jPanel_Barra.add(lblCerrar);
lblCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 clsArial.modifiedIcon("/img/close.png", 28, 28,lblCerrar);

/*-----------------------> FUNCIONALIDAD CERRAR FRAME  CON OPCIONES <----------------------------*/

lblCerrar.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent arg0) {

int dialog = JOptionPane.YES_NO_OPTION;


int result = JOptionPane.showConfirmDialog(null, "Desea salir del Login ?", "Salir", dialog);
if (result == 0) {
System.exit(0);
}
}
});

/*-------------------------------------------------------------------------------*/

/*-----------------------> FUNCIONALIDAD  TECLA USUARIO <----------------------------*/

/*----------> FUNCIONALIDAD  AL SOLTAR LA TECLA  <------------*/

/*-------------------------------------------------------------------------------------*/

/*-----------------------> FUNCIONALIDAD  TECLA CLAVE <----------------------------*/


}

/*----------> METODO PARA HABILITAR/DESABILITAR JBUTON INICIAR SECION------------*/

void validacionUsuario() {

if (txtIngUsu.getText().isEmpty()) {
btnIniciarSecin.setEnabled(false);

btnIniciarSecin.setBackground(new Color(51, 51, 51));
btnIniciarSecin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));

} else {

btnIniciarSecin.setEnabled(true);

btnIniciarSecin.setBackground(Color.decode(clsArial.colorCeleste));
btnIniciarSecin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));

}

}
/*-------------------------------------------------------------------------------------*/




/*--------- VALIDAR USURAIO Y CONTRASEÑA E INGRESAR AL MENU PRINCIPAL ---*/

void validarLogin() {
String usu,psw;


usu = txtIngUsu.getText();
psw = txtClaveUsu.getText();

GestionEmpledos emp = new GestionEmpledos();
e = emp.ValidaAcceso2(usu, psw);



if (e == null) {	

JOptionPane.showMessageDialog(null, "algo incorrecto");

} else {
	/*
Frame a=new Frame();
new alert.AlertSuccess(a,true).setVisible(true);*/
JOptionPane.showMessageDialog(null, " Bienvenido " + e.getNom_emp() + "  " + e.getApe_pat_emp());
FrmMenuPrincipal p = new FrmMenuPrincipal(); 
FrmMenuPrincipal.lblUsuario.setText(e.getNom_emp()+" "+e.getApe_pat_emp());
//METODO PARA VALIDAR RESTRICCION DE GUIS
if (e.getId_tip_emp().equals("1")) {

p.setVisible(true);
p.setLocationRelativeTo(null);
FrmMenuPrincipal.lblCargo.setText("Administrador");

FrmMenuPrincipal.lblUser2.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/user2.png")));
FrmMenuPrincipal.lblIconoUsu.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/user2.png")));
dispose(); 
}

if (e.getId_tip_emp().equals("2")) {

p.setVisible(true);

FrmMenuPrincipal.panelCompras.setVisible(false);
FrmMenuPrincipal.panelAlmacen.setVisible(false);


p.setLocationRelativeTo(null);
FrmMenuPrincipal.lblCargo.setText("Vendedor");

FrmMenuPrincipal.lblUser2.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/vendedor.png")));
FrmMenuPrincipal.lblIconoUsu.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/vendedor.png")));
dispose();
}
} }
}
