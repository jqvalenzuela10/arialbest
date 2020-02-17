	package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

import javax.print.DocFlavor.URL;
import javax.print.attribute.IntegerSyntax;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.table.DefaultTableModel;

import model.Clientes;
import model.RoundedCornerBorder;
import utils.FormatoTablaMain;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


import mantenimientos.GestionClientes;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;

public class IntCliente extends JInternalFrame {
	public static DefaultTableModel model = new DefaultTableModel();
	private JDesktopPane dk;
	private JPanel panel;
	private JLabel label;
	private JLabel lblNuevo;
	private JLabel lblExcel;
	private JTextField txtBusqueda;
	private JLabel lblIconSearch;
	private JScrollPane scrollPane;
	private JTable tblClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntCliente frame = new IntCliente();
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
	public IntCliente() {
		
		
		addInternalFrameListener(new InternalFrameAdapter() {
			  @Override
			  public void internalFrameActivated(InternalFrameEvent arg0) {
			   listar();
			  }
			 });
		listar();
		setBorder(null);
		setBounds(100, 100, 1626, 832);
		getContentPane().setLayout(null);

		dk = new JDesktopPane();
		dk.setBackground(Color.decode("#EFF4F9"));

		dk.setBounds(0, 0, 1626, 701);
		getContentPane().add(dk);
		dk.setLayout(null);

		/* TABLA */
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("codigo");
		model.addColumn("Nombre");
		model.addColumn("nombre Comercial");
		
		model.addColumn("Forma Pago");
		
	
	
		/* model.addColumn("Pendiente Pago"); */
		model.addColumn("Direccion");
		model.addColumn("Distrito");
		model.addColumn("N.Telefono");
		model.addColumn("Celular");
		
		model.addColumn("Correo");
		model.addColumn("limite credito");
		/*-------*/
		panel = new JPanel() {
			@Override
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
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistroCliente reg=new RegistroCliente();
				reg.setVisible(true);
				reg.setLocationRelativeTo(null);
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBounds(1446, 11, 142, 41);
		panel.setBackground(Color.decode("#1493e1"));

		dk.add(panel);
		panel.setLayout(null);

		label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
		label.setBounds(20, 7, 25, 25);
		panel.add(label);

		lblNuevo = new JLabel("Nuevo");
		lblNuevo.setVerticalAlignment(SwingConstants.TOP);
		lblNuevo.setForeground(Color.decode("#FDFEFE"));
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setBounds(50, 7, 83, 30);
		panel.add(lblNuevo);

		lblExcel = new JLabel("");
		lblExcel.setBounds(92, 11, 45, 45);
		ImageIcon iconExecel = new ImageIcon(getClass().getResource("/iconos/exel.png"));
		Image imgEsca = iconExecel.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		Icon iconoEscalados = new ImageIcon(imgEsca);
		lblExcel.setIcon(iconoEscalados);
		dk.add(lblExcel);

		/*
		 * -------------------- BUSCADOR CON BORDE REDONDEADO (CLASE
		 * ROUNDEDCORNERBORDER) ----------------------
		 */
		txtBusqueda = new JTextField(20) {
			@Override
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
		txtBusqueda.setBounds(923, 11, 345, 38);
		/*
		 * -----------------------------------------------------------------------------
		 * -
		 */

		txtBusqueda.setBackground(Color.decode("#EFF4F9"));
		txtBusqueda.setToolTipText("");
		dk.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		lblIconSearch = new JLabel("");
		lblIconSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconSearch.setBounds(1278, 11, 38, 38);
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		lblIconSearch.setIcon(ic);
		dk.add(lblIconSearch);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 95, 1496, 606);
		dk.add(scrollPane);
		tblClientes = new JTable();
	
		
		
		scrollPane.setViewportView(tblClientes);
		FormatoTablaMain.formatoTabla(tblClientes);
		 tblClientes.setModel(model);

	}

	void imagenScalada() {

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/informatica.gif"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(),
				Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
	}

	public static void listar() {
		GestionClientes gc = new GestionClientes();
		ArrayList<Clientes> lista = gc.listado();
		model.getDataVector().removeAllElements();
		
		for (Clientes cl : lista) {
			double limite=cl.getLimite_credito();
			String cambiar=limite+"";
			String resultado="";
			System.out.println(cambiar.length());
			if(cambiar.length()==6) {
				resultado=cambiar.substring(0,1)+","+cambiar.substring(1,6);
			}
			else if(cambiar.length()==7) {
				resultado=cambiar.substring(0,2)+","+cambiar.substring(2,7);
			}
			else if(cambiar.length()==8) {
				resultado=cambiar.substring(0,3)+","+cambiar.substring(3,8);
			}
			else if(cambiar.length()==9) {
				resultado=cambiar.substring(0,1)+","+cambiar.substring(1,4)+","+cambiar.substring(4,9);
			}
			else {
				resultado=limite+"";
			}
			System.out.println(resultado);
			Object datos[] = {  cl.getId_cli(),cl.getNomb_cli(),cl.getNom_comercial(),cl.getFormaPago_cli(),
					cl.getDirec_cli(),cl.getDistrito_cli(),cl.getTelf_cli(),cl.getCelular(),cl.getCorreo(),resultado};

			model.addRow(datos);

		}
		
	}
}