package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionClientes;
import mantenimientos.GestionEmpledos;
import model.Clientes;
import model.Empleados;
import model.HintTextField;
import model.RoundedCornerBorder;
import model.Tabla;

import java.awt.Cursor;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class IntUsuarios extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntUsuarios frame = new IntUsuarios();
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
	private String colorNegro="#38383c";
	private String colorPlomo="#808793";
	public static DefaultTableModel model = new DefaultTableModel();
	Tabla t=new Tabla();
	private JDesktopPane dkUsuarios;
	private JPanel rsyaPerfil;
	private JPanel rayaUsu;
	private JLabel lblPerfiles;
	private JLabel lblUsu;
	public IntUsuarios() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				dkUsuarios.removeAll();
				dkUsuarios.repaint();
				IntUsuario venta=new IntUsuario();
				dkUsuarios.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		setBounds(100, 100, 1642, 901);
		getContentPane().setLayout(null);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(Color.WHITE);
		panelHeader.setBounds(0, 0, 1642, 69);
		getContentPane().add(panelHeader);
		panelHeader.setLayout(null);
		
		lblUsu = new JLabel("Usuarios");
		lblUsu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPerfiles.setForeground(Color.decode(colorPlomo));
				
				rsyaPerfil.setVisible(false);
				
				lblUsu.setForeground(Color.decode(colorNegro));
				rayaUsu.setVisible(true);
				dkUsuarios.removeAll();
				dkUsuarios.repaint();
				IntUsuario venta=new IntUsuario();
				dkUsuarios.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
			
		});
		lblUsu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUsu.setForeground(Color.decode("#808793"));
		lblUsu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsu.setBounds(92, 33, 73, 25);
		panelHeader.add(lblUsu);
		
		lblPerfiles = new JLabel("Perfiles");
		lblPerfiles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				lblPerfiles.setForeground(Color.decode(colorNegro));
			
				rsyaPerfil.setVisible(true);
				
				lblUsu.setForeground(Color.decode(colorPlomo));
				rayaUsu.setVisible(false);
				dkUsuarios.removeAll();
				dkUsuarios.repaint();
				IntPerfiles venta=new IntPerfiles();
				dkUsuarios.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		lblPerfiles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPerfiles.setForeground(new Color(128, 135, 147));
		lblPerfiles.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPerfiles.setBounds(188, 35, 73, 23);
		panelHeader.add(lblPerfiles);
		
		rayaUsu = new JPanel();
		rayaUsu.setBounds(90, 63, 60, 3);
		rayaUsu.setBackground(Color.decode("#1493e1"));
		panelHeader.add(rayaUsu);
		
		rsyaPerfil = new JPanel();
		rsyaPerfil.setVisible(false);
		rsyaPerfil.setBounds(188, 63, 60, 3);
		rsyaPerfil.setBackground(Color.decode("#1493e1"));
		panelHeader.add(rsyaPerfil);
		
		dkUsuarios = new JDesktopPane();
		dkUsuarios.setBackground(Color.decode("#ebf0f4"));
		dkUsuarios.setBounds(0, 68, 1642, 806);
		getContentPane().add(dkUsuarios);
		
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		
	

	}
	
	

	
	void eliminar(String id) {

		GestionEmpledos gc = new GestionEmpledos();

		int ok = gc.eliminar(id);

		if (ok == 0) {
			
		} else {
			JOptionPane.showMessageDialog(null, ok + " Registro eliminado");
			Tabla.model.setRowCount(0);  // <--------- LIMPIA LA TABLA
			Tabla.listar();
		}

	}
	
	
	

}
