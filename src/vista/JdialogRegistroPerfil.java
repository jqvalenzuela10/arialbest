package vista;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JTextField;

import model.Clientes;
import model.Empleados;
import model.HintTextField;
import model.PerfilUsuario;
import model.Privilegios;
import model.RoundedCornerBorder;
import model.Tabla;
import model.TablaPerfiles;
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


public class JdialogRegistroPerfil extends JDialog {
	private JTextField txtNombre;
	private JPanel btnRegistrar;
private  ButtonGroup genero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogRegistroPerfil dialog = new JdialogRegistroPerfil();
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

	public JdialogRegistroPerfil() {
		setModal(true);
		setTitle("Registro Perfil");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 410, 246);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBackground(Color.decode("#F7F9F9"));
		panel.setBounds(95, 55, 193, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtNombre = new HintTextField("Nombre Perfil") ;
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
		
		JLabel lblNombresYApellidos = new JLabel("Nuevo Perfil");
		lblNombresYApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombresYApellidos.setForeground(new Color(15, 149, 236));
		lblNombresYApellidos.setBounds(128, 11, 143, 14);
		getContentPane().add(lblNombresYApellidos);
		
		
		genero=new ButtonGroup();
		
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
		btnRegistrar.setBounds(107, 142, 164, 40);
		getContentPane().add(btnRegistrar);
		btnRegistrar.setLayout(null);
		
		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setForeground(Color.WHITE);
		lblRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRegistrar.setBounds(41, 0, 80, 40);
		btnRegistrar.add(lblRegistrar);

	}
	
	
	
	void registrar() {

	
		
		
		
		String nom;
		
		
		
		
	

		nom = txtNombre.getText();
	
	  
	    

	  


	 
	    
			PerfilUsuario c = new PerfilUsuario();
			
			c.setDescPerfil(nom);
			
			GestionEmpledos gc = new GestionEmpledos();

			int ok = gc.registrarPerfil(c);
			
			if (ok == 0) {
				
			} else {
				JOptionPane.showMessageDialog(null, "registro correcto");
				dispose();
				TablaPerfiles.model.setRowCount(0);
			
				TablaPerfiles.listar();
			}
			
			

		}
		
		

		
			
}
