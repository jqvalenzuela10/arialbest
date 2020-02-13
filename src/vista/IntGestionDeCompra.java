package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import componentes.boton;
import mantenimientos.GestionCompra;
import mantenimientos.GestionProveedor;
import model.Celda_CheckBox;
import model.DetalleCompra;

import model.OrdenRegistroCompra;
import model.Proveedores;
import model.Render_CheckBox;
import model.RoundedCornerBorder;
import utils.FormatoTabla;
import utils.FormatoTablaMain;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;

public class IntGestionDeCompra extends JInternalFrame {
	private JTextField txtBusquedad;
	private String colorFondo = "#ebf0f4";
	public static DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1 = new DefaultTableModel();
	public static JTable tblCompra;
	private JScrollPane scrollPane_1;
	private JTable tblProducto;
	private JComboBox cboFiltro;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntGestionDeCompra frame = new IntGestionDeCompra();
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
	public IntGestionDeCompra() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				listadoRegistroCompra();
				
			}
		});

		getContentPane().setBounds(new Rectangle(0, 0, 1626, 901));
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("Codigo Registro Compra");
		model.addColumn("Tipo");
		model.addColumn("Fecha Registro");
		model.addColumn("Proveedor");
		model.addColumn("Forma pago");
		model.addColumn("Vencimiento");
		model.addColumn("Caja");
		
		model.addColumn("Total");
		model.addColumn("Pagado");
		model.addColumn("Anulado");
		model.addColumn("Recibido");

		model1.setRowCount(0);
		model1.setColumnCount(0);
		
		model1.addColumn("Producto");
		model1.addColumn("Cantidad");
		model1.addColumn("Precio");
	
		model1.addColumn("Descuento");
		model1.addColumn("Total");
	
		
		setBounds(223, 79, 1626, 811);
		getContentPane().setLayout(null);
		
	
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBounds(-6, 0, 1610, 781);
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image is = iconSearchs.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);

		
		  txtBusquedad = new JTextField(10) ;
		txtBusquedad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				String nombre = txtBusquedad.getText();
				String filtro = (String)cboFiltro.getSelectedItem();
			
				ArrayList<OrdenRegistroCompra> lista = null;

			

					GestionCompra gc = new GestionCompra();
					model.getDataVector().removeAllElements();
					lista = gc.listadoXFiltro(filtro,nombre);
					for (OrdenRegistroCompra cl : lista) {
						Object o[] = { cl.getCodigo(), cl.getComprovante(), cl.getFechaRegisCom(),
								cl.getNomProveedor(), cl.getFormaPago(), cl.getFechaVenCom(),"",  cl.getTotal() };
						model.addRow(o);

					
					
					
				}

				
			}
		});
		txtBusquedad.setToolTipText("");
		txtBusquedad.setBackground(new Color(239, 244, 249));
		txtBusquedad.setBounds(1168, 32, 345, 30);
		panel.add(txtBusquedad);

		JLabel label_3 = new JLabel("");
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		label_3.setIcon(ic);
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(1523, 32, 28, 27);
		panel.add(label_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 94, 1517, 345);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(Color.WHITE);
		panel.add(scrollPane);

		tblCompra = new JTable();
		tblCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				model1.setRowCount(0);

				int fila = tblCompra.getSelectedRow();

				int codigo = Integer.parseInt(tblCompra.getValueAt(fila, 0).toString());

				ArrayList<OrdenRegistroCompra> lista = new GestionCompra().listadoXcodigoRegisCompra(codigo);

				for (OrdenRegistroCompra cl : lista) {

					/* precio bruto cantidad*precio */
					int cantidad = lista.get(0).getCantidad();
					double precio = lista.get(0).getPrecio();
					double total = cantidad * precio;
					
					Object o[] = { cl.getNomPro(), cl.getCantidad(), cl.getPrecio(),0,
							 total };
					model1.addRow(o);
				}

			}
		});
		
		scrollPane.setViewportView(tblCompra);
		FormatoTablaMain.formatoTabla(tblCompra);
		tblCompra.setModel(model);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 484, 1517, 225);
		scrollPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1.getViewport().setBackground(Color.WHITE);
		panel.add(scrollPane_1);

		tblProducto = new JTable();
		tblProducto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane_1.setViewportView(tblProducto);

		tblProducto.getTableHeader().setOpaque(false);
		tblProducto.getTableHeader().setBackground(Color.decode("#005f80"));
		tblProducto.getTableHeader().setForeground(Color.decode("#F4F5F7"));
		tblProducto.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblProducto.getTableHeader().setSize(WIDTH, 100);
		tblProducto.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		tblProducto.setRowHeight(30);
		tblProducto.setDefaultRenderer(Object.class, new FormatoTabla());
		tblProducto.setForeground(Color.decode("#39393C"));
		tblProducto.setModel(model1);

		JLabel lblNewLabel = new JLabel("FILTRO");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(952, 29, 65, 30);
		panel.add(lblNewLabel);

		cboFiltro = new JComboBox();
		cboFiltro.setOpaque(false);
		cboFiltro.setBackground(Color.WHITE);
		cboFiltro.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONA", "TIPO DOCUMENTO", "PERIODO" }));
		cboFiltro.setBounds(1020, 32, 138, 30);
		cboFiltro.setUI(CustomUI.createUI(this));
		panel.add(cboFiltro);
		
		panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmRegistroCompra f=new FrmRegistroCompra();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		boton.mibotonAgregar(panel_1);
		panel_1.setBounds(45, 32, 164, 35);
		panel.add(panel_1);

		
	
		
	}

	public static void listadoRegistroCompra() {

		ArrayList<OrdenRegistroCompra> lista = new GestionCompra().listadoRegistroCompra();

		for (OrdenRegistroCompra cl : lista) {

			Object o[] = { cl.getCodigo(), cl.getComprovante(), cl.getFechaRegisCom(),
					cl.getNomProveedor(), cl.getFormaPago(), cl.getFechaVenCom(), "", cl.getTotal() ,true,true,false};
			model.addRow(o);
		}
		tblCompra.getColumnModel().getColumn( 8 ).setCellEditor( new Celda_CheckBox() );
        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
		tblCompra.getColumnModel().getColumn( 8 ).setCellRenderer(new Render_CheckBox());
		tblCompra.getColumnModel().getColumn( 9 ).setCellEditor( new Celda_CheckBox() );
        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
		tblCompra.getColumnModel().getColumn( 9 ).setCellRenderer(new Render_CheckBox());
		tblCompra.getColumnModel().getColumn( 10 ).setCellEditor( new Celda_CheckBox() );
        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
		tblCompra.getColumnModel().getColumn( 10).setCellRenderer(new Render_CheckBox());
	}
}
