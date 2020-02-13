package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionEmpledos;
import mantenimientos.GestionProveedor;

import javax.lang.model.element.QualifiedNameable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import model.Empleados;
import model.HintTextField;
import model.Proveedores;
import model.RoundedCornerBorder;
import model.Tabla;
import utils.FormatoTabla;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class IntProveedor extends JInternalFrame {
	public static JTable tblProveedor;
	public static DefaultTableModel model=new DefaultTableModel();
 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntProveedor frame = new IntProveedor();
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
	public IntProveedor() {
		
	
		getContentPane().setBackground(Color.WHITE);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				listado();
			}
		});
		
		/*datos de la gestion de proveedores*/
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("Codigo");
		model.addColumn("Proveedor");
		model.addColumn("RUC");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		model.addColumn("Celular");
		model.addColumn("Email");
		model.addColumn("Estado");
		model.addColumn("NroCuenta");
		
		setBounds(100, 40, 1600, 708);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 42, 194, 50);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proveedores");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(66, 11, 128, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/proveedor.jpg"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		lblNewLabel_1.setIcon(ico);
		lblNewLabel_1.setBounds(0, 0, 66, 50);
		panel.add(lblNewLabel_1);
		
		HintTextField hintTextField = new HintTextField("Search") {
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
		hintTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
System.out.println("entro al keyreelease");
				
				String nombre=hintTextField.getText();
				
				GestionProveedor gc = new GestionProveedor();
				model.getDataVector().removeAllElements();
				ArrayList<Proveedores> lista = gc.listado(nombre);
				
				for (Proveedores cl : lista) {
					Object o[]={cl.getId_prov(),cl.getNom_prov(),cl.getRuc_prov(),cl.getDirec_prov(),cl.getTelf_prov(),cl.getCell_prov(),cl.getEmail_prov()
							,cl.getEstado_prov(),cl.getNro_cuenta_prov()};
					model.addRow(o);

				}
			
			}
		});
		hintTextField.setColumns(10);
		hintTextField.setBounds(267, 57, 541, 35);
		getContentPane().add(hintTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setOpaque(true);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 220, 1320, 408);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		tblProveedor = new JTable();
		tblProveedor.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tblProveedor.setBackground(Color.WHITE);
		tblProveedor.setOpaque(true);
		tblProveedor.getTableHeader().setOpaque(false);
		tblProveedor.getTableHeader().setBackground(Color.decode("#005f80"));
		tblProveedor.getTableHeader().setForeground(Color.decode("#F4F5F7"));
		tblProveedor.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblProveedor.getTableHeader().setSize(WIDTH, 100);
		tblProveedor.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		tblProveedor.setRowHeight(30);
		tblProveedor.setDefaultRenderer(Object.class, new FormatoTabla());
		tblProveedor.setForeground(Color.decode("#39393C"));
		tblProveedor.setModel(model);
		scrollPane.setViewportView(tblProveedor);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegistroProveedor r=new RegistroProveedor();
				r.setLocationRelativeTo(null);
				r.setVisible(true);
				
			}
		});
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(20, 147, 225));
		panel_1.setBounds(10, 156, 106, 27);
		getContentPane().add(panel_1);
		
		JLabel label = new JLabel("");
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(10, 3, 33, 23);
		panel_1.add(label);
		
		JLabel lblNuevo = new JLabel("Nuevo");
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setForeground(new Color(253, 254, 254));
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblNuevo.setBounds(41, 0, 59, 27);
		panel_1.add(lblNuevo);

	}
	

	public static void listado() {
		
		ArrayList<Proveedores> lista=new GestionProveedor().listado();
		
		for (Proveedores cl : lista) {
			
		
			Object o[]={cl.getId_prov(),cl.getNom_prov(),cl.getRuc_prov(),cl.getDirec_prov(),cl.getTelf_prov(),cl.getCell_prov(),cl.getEmail_prov()
					,cl.getEstado_prov(),cl.getNro_cuenta_prov()};
			model.addRow(o);
		}
		
		
	}
}
