package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.RoundedCornerBorder;
import utils.FocusJpanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class IntpCompra extends JInternalFrame {

	DefaultTableModel model1 = new DefaultTableModel();
	
	private String colorCeleste="#0f95ec";
	private String colorMenu="#2D363F";
	private String colorHover="#232b37";
	private String colorNegro="#38383c";
	private String colorPlomo="#808793";
	private String colorFondo="#ebf0f4";
	private JLabel lblGestionDeCompra;
	private JLabel lblOrdenDeCompra;
	private JLabel lblProveedores;
	private String colorLetra="#000000";
	private JDesktopPane dkpane;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntpCompra frame = new IntpCompra();
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
	public IntpCompra() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				dkpane.removeAll();
				dkpane.repaint();
				IntGestionOrdenDeCompra compra=new IntGestionOrdenDeCompra();
				dkpane.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				
			
				
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		});
		setBounds(223, 79, 1644, 901);
		getContentPane().setLayout(null);
		getContentPane().setBounds(223,79,1626,832);
		setBorder(null);
		setBackground(Color.decode("#EFF4F9"));
		
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		/*TABLA*/
		
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		
		dkpane = new JDesktopPane();
		dkpane.setBackground(Color.WHITE);
		dkpane.setBounds(0, 80, 1642, 794);
		getContentPane().add(dkpane);
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#f3f4f5"));
		panel_1.setBounds(0, 0, 1642, 77);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblOrdenDeCompra = new JLabel("Gestion Orden Compra");
		ArrayList<JPanel>listado=null;
		
		lblOrdenDeCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(panel_2);
				listado.add(panel_3);
				FocusJpanel.lanzarFoco(panel, listado);
				
				dkpane.removeAll();
				dkpane.repaint();
				IntGestionOrdenDeCompra cobranza=new IntGestionOrdenDeCompra();
				dkpane.add(cobranza);
				try {
					cobranza.setMaximum(true);
					cobranza.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					cobranza.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		lblOrdenDeCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOrdenDeCompra.setFocusable(true);
		
			
		

		
		lblOrdenDeCompra.setBounds(30, 35, 174, 31);
		panel_1.add(lblOrdenDeCompra);
		lblOrdenDeCompra.setForeground(Color.decode(colorPlomo));
		lblOrdenDeCompra.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblGestionDeCompra = new JLabel("Gestion de Compra");
		lblGestionDeCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(panel);
				listado.add(panel_3);
				FocusJpanel.lanzarFoco(panel_2, listado);
				
				
				/*para cambiar de internal*/
				dkpane.removeAll();
				dkpane.repaint();
				IntGestionDeCompra compra=new IntGestionDeCompra();
				dkpane.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		lblGestionDeCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGestionDeCompra.setFocusable(true);
		
		lblGestionDeCompra.setBounds(232, 31, 137, 35);
		panel_1.add(lblGestionDeCompra);
		lblGestionDeCompra.setForeground(Color.decode(colorPlomo));
		lblGestionDeCompra.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblProveedores = new JLabel("Proveedores");
		lblProveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*para el focus */
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(panel);
				listado.add(panel_2);
				FocusJpanel.lanzarFoco(panel_3, listado);
				
				/*para cambiar de internal*/
				dkpane.removeAll();
				dkpane.repaint();
				IntProveedor compra=new IntProveedor();
				dkpane.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		lblProveedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProveedores.setBounds(449, 31, 86, 35);
		panel_1.add(lblProveedores);
		lblProveedores.setForeground(Color.decode(colorPlomo));
		lblProveedores.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		panel = new JPanel();
		panel.setBackground(new Color(20, 147, 225));
		panel.setBounds(77, 67, 60, 3);
		panel.setVisible(true);
		panel_1.add(panel);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(20, 147, 225));
		panel_2.setBounds(262, 66, 60, 3);
		panel_2.setVisible(false);
		panel_1.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(20, 147, 225));
		panel_3.setBounds(464, 67, 60, 3);
		panel_3.setVisible(false);
		panel_1.add(panel_3);
		
		
		

	}
	

	




}