package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.Inflater;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import hilos.Hilo_Tiempo;
import mantenimientos.GestionCategorias;
import mantenimientos.GestionCompra;
import mantenimientos.GestionEmpledos;
import mantenimientos.GestionProveedor;
import model.Categoria;
import model.DetalleCompra;
import model.Empleados;
import model.OrdenCompra;
import model.Proveedores;
import model.RoundedCornerBorder;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.Cursor;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Rectangle;

public class FrmOrdenDeCompra extends JDialog {
	/*model para los productos*/
	public  static DefaultTableModel model1=new DefaultTableModel();

public static ArrayList<DetalleCompra> carrito=new ArrayList<DetalleCompra>();

	public static JLabel lblReloj;
	public static JLabel lblFecha;
	private JTextField txtRazonSocial;
	private JTextField txtDireccion;
	private JTextField txtContacto;
	private JTextField txtTelefono;
	private JTextField txtCorreo;

	/*model para los proveedores*/
	DefaultTableModel model = new DefaultTableModel();
	

	
	public static JTable tblProducto;
	private JTextField txtDireccionEntrega;
	private JTextField txtDireccionFactura;
	private JTextField txtBusquedad;

	/* para la busquedad de proveedores */
	 DefaultTableModel modelBusquedad = new DefaultTableModel();
	private JScrollPane scroll;
	private JPanel panel_1;
	private JTable table_1;
	private JLabel txtCodigo;
	private JPanel panel_5;
	private JLabel lblAgregar;
	public static JTextField txtSubtotal;
	public  static  JTextField txtIGV;
	public static JTextField txtTotal;
	private JDateChooser dtmFecha;
	private JComboBox cboCondicionPago;
	private JLabel txtUsuario;

	GestionCompra g=new GestionCompra();
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			FrmOrdenDeCompra dialog = new FrmOrdenDeCompra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param b
	 * @param f
	 */
	public FrmOrdenDeCompra() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				txtUsuario.setText(FrmLogin.e.getNom_emp());
			
				
			}
			
		});
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scroll.setVisible(false);
			}
		});
		setModal(true);
		model1.setColumnCount(0);
		model1.setRowCount(0);
		model1.addColumn("Codigo");
		model1.addColumn("Producto");
		model1.addColumn("Cantidad");
		model1.addColumn("Precio");
		model1.addColumn("Importe");
		model1.addColumn("Eliminar");
		/*para la busqueda de proveedores*/
		modelBusquedad.addColumn("");

		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1180, 979);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1164, 66);
		panel.setBackground(Color.decode("#2D363F"));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblOrdenDe = new JLabel("ORDEN DE COMPRA");
		lblOrdenDe.setForeground(Color.WHITE);
		lblOrdenDe.setBounds(45, 0, 182, 66);
		panel.add(lblOrdenDe);
		lblOrdenDe.setFont(new Font("Segoe UI", Font.BOLD, 17));

		JLabel lblNumeroDeOrdenCompra;
		
		String numeroCompra;
		numeroCompra ="N°0000"+g.ObtenerNumero();
		
		lblNumeroDeOrdenCompra= new JLabel(numeroCompra);
		lblNumeroDeOrdenCompra.setForeground(Color.WHITE);
		lblNumeroDeOrdenCompra.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNumeroDeOrdenCompra.setBounds(1034, 30, 84, 14);
		panel.add(lblNumeroDeOrdenCompra);

		JLabel label = new JLabel(
				"________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		label.setBounds(0, 96, 1181, 14);
		getContentPane().add(label);

		lblReloj = new JLabel("");
		lblReloj.setForeground(Color.BLACK);
		lblReloj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblReloj.setBounds(1055, 77, 46, 29);
		getContentPane().add(lblReloj);

		lblFecha = new JLabel("");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFecha.setBounds(959, 77, 91, 29);
		getContentPane().add(lblFecha);

		panel_1 = new JPanel();
		panel_1.setBounds(45, 130, 522, 305);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		scroll = new JScrollPane();
		scroll.setBackground(Color.RED);
		scroll.setBounds(135, 38, 220, 149);
		scroll.setVisible(false);
		panel_1.add(scroll);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				try {
					int fila=table_1.getSelectedRow();
					String nombre=(String)table_1.getValueAt(fila, 0);
				
					
					
					GestionProveedor n=new GestionProveedor();
					ArrayList<Proveedores> lista=n.listadoVenta(nombre);
					
					
					
					txtRazonSocial.setText(lista.get(0).getNom_prov());
					txtDireccion.setText(lista.get(0).getDirec_prov());
					txtTelefono.setText(lista.get(0).getTelf_prov());
					txtCorreo.setText(lista.get(0).getEmail_prov());
					txtCodigo.setText(lista.get(0).getId_prov()+"");
					scroll.setVisible(false);
				} catch (Exception e2) {
					System.out.println("error al buscar un proveedor "+e2.getMessage());
				}
				
			}
		});
		scroll.setViewportView(table_1);
		table_1.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 0));
		table_1.setBorder(null);
		table_1.setShowGrid(false);
		table_1.setModel(modelBusquedad);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 522, 50);
		panel_2.setBackground(Color.decode("#2D363F"));
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPro = new JLabel("Proveedor");
		lblPro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPro.setForeground(Color.WHITE);
		lblPro.setBounds(10, 0, 73, 50);
		panel_2.add(lblPro);

		txtBusquedad = new JTextField();

		txtBusquedad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				buscar();
				if (txtBusquedad.getText().isEmpty()) {
					scroll.setVisible(false);
				} else {

					if (txtBusquedad.getText().contains(" ")) {
						scroll.setVisible(false);
						arg0.consume();

					} else {

						scroll.setVisible(true);
					}
				}
				
				
				
			}
		});
		txtBusquedad.setBounds(133, 17, 222, 20);
		panel_2.add(txtBusquedad);
		txtBusquedad.setColumns(10);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(365, 17, 20, 20);
		panel_2.add(label_1);
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(ic);
		
		txtCodigo = new JLabel("");
		txtCodigo.setForeground(Color.WHITE);
		txtCodigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtCodigo.setBounds(466, 0, 56, 50);
		panel_2.add(txtCodigo);

		JLabel lblRazonSocial = new JLabel("Razon Social  :");
		lblRazonSocial.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblRazonSocial.setBounds(10, 77, 115, 14);
		panel_1.add(lblRazonSocial);

		JLabel lblDireccion = new JLabel("Direccion       :");
		lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDireccion.setBounds(10, 122, 115, 14);
		panel_1.add(lblDireccion);

		JLabel lblContacto = new JLabel("Contacto        :");
		lblContacto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContacto.setBounds(10, 175, 115, 14);
		panel_1.add(lblContacto);

		JLabel lblContacto_1 = new JLabel("Telefono         :");
		lblContacto_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContacto_1.setBounds(10, 220, 115, 14);
		panel_1.add(lblContacto_1);

		JLabel lblCorreo = new JLabel("Correo           :");
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 259, 115, 14);
		panel_1.add(lblCorreo);

		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(135, 214, 221, 20);
		panel_1.add(txtTelefono);

		txtCorreo = new JTextField();
		txtCorreo.setOpaque(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(135, 253, 221, 20);
		panel_1.add(txtCorreo);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setOpaque(false);
		txtRazonSocial.setBounds(135, 74, 221, 20);
		panel_1.add(txtRazonSocial);
		txtRazonSocial.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setOpaque(false);
		txtDireccion.setBounds(135, 120, 221, 20);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);

		txtContacto = new JTextField();
		txtContacto.setOpaque(false);
		txtContacto.setColumns(10);
		txtContacto.setBounds(135, 169, 221, 20);
		panel_1.add(txtContacto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 526, 1072, 305);
		getContentPane().add(scrollPane);

		tblProducto = new JTable();
		tblProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila=tblProducto.getSelectedRow();
				int columna=tblProducto.getSelectedColumn();
				
				
				String dato=String.valueOf(tblProducto.getValueAt(fila, columna));
				
				
				if(dato.equals("eliminar")) {
					
					JOptionPane.showMessageDialog(null, "quieres eliminar ?"+fila);
					
					model1.removeRow(fila);
					
					/*una vez eliminado agregamos los poducos que sobran al detalle compra en el grabarCompra*/
					
					
				}
				
				
			}
		});
		scrollPane.setViewportView(tblProducto);

		tblProducto.getTableHeader().setOpaque(false);
		tblProducto.getTableHeader().setBackground(Color.decode("#005f80"));
		tblProducto.getTableHeader().setForeground(Color.decode("#f7edd7"));
		tblProducto.getTableHeader().setFont(new Font("Arial", 1, 12));
		tblProducto.getTableHeader().setSize(WIDTH, 100);
		tblProducto.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
tblProducto.setModel(model1);
		

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(596, 130, 522, 305);
		getContentPane().add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(45, 54, 63));
		panel_4.setBounds(0, 0, 522, 50);
		panel_3.add(panel_4);

		JLabel lblOtros = new JLabel("Otros");
		lblOtros.setForeground(Color.WHITE);
		lblOtros.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblOtros.setBounds(10, 0, 73, 50);
		panel_4.add(lblOtros);

		JLabel lblDireccionEn = new JLabel("Direccion de entrega :");
		lblDireccionEn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDireccionEn.setBounds(10, 73, 136, 20);
		panel_3.add(lblDireccionEn);

		txtDireccionEntrega = new JTextField();
		txtDireccionEntrega.setColumns(10);
		txtDireccionEntrega.setBounds(156, 73, 221, 20);
		panel_3.add(txtDireccionEntrega);

		JLabel lblDireccionDeFactura = new JLabel("Direccion de factura  :");
		lblDireccionDeFactura.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDireccionDeFactura.setBounds(10, 121, 136, 14);
		panel_3.add(lblDireccionDeFactura);

		txtDireccionFactura = new JTextField();
		txtDireccionFactura.setColumns(10);
		txtDireccionFactura.setBounds(156, 119, 221, 20);
		panel_3.add(txtDireccionFactura);

		JLabel lblCondicionesDePago = new JLabel("Condiciones de Pago");
		lblCondicionesDePago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblCondicionesDePago.setBounds(10, 201, 136, 14);
		panel_3.add(lblCondicionesDePago);

		cboCondicionPago = new JComboBox();
		cboCondicionPago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		cboCondicionPago.setModel(new DefaultComboBoxModel(new String[] {"Credito 30", "Credito 90"}));
		cboCondicionPago.setBounds(156, 198, 109, 20);
		panel_3.add(cboCondicionPago);

		JLabel lblFecha_1 = new JLabel("Fecha de entrega");
		lblFecha_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFecha_1.setBounds(10, 249, 136, 14);
		panel_3.add(lblFecha_1);

		dtmFecha = new JDateChooser();
		dtmFecha.setBounds(156, 243, 109, 20);
		
		
		dtmFecha.setDateFormatString("yyyy/MM/dd");
		dtmFecha.setDate(new Date()); 
		panel_3.add(dtmFecha);
		
		panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmBuscarProducto b=new FrmBuscarProducto();
				b.setLocationRelativeTo(null);
				b.setVisible(true);
			
			}
		});
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(20, 147, 225));
		panel_5.setBounds(45, 461, 106, 27);
		getContentPane().add(panel_5);
		
		JLabel label_2 = new JLabel("");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setBounds(13, 3, 30, 23);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label_2.setIcon(iconoEscalado);
		panel_5.add(label_2);
		
		lblAgregar = new JLabel("Agregar");
		lblAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregar.setForeground(new Color(253, 254, 254));
		lblAgregar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblAgregar.setBounds(41, 0, 59, 28);
		panel_5.add(lblAgregar);
		
		JLabel lblSubtotal = new JLabel("Sub total");
		lblSubtotal.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSubtotal.setBounds(317, 870, 91, 25);
		getContentPane().add(lblSubtotal);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setEditable(false);
		txtSubtotal.setBounds(401, 869, 86, 25);
		getContentPane().add(txtSubtotal);
		txtSubtotal.setColumns(10);
		
		JLabel lblImpuesto = new JLabel("Impuesto(18%)");
		lblImpuesto.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblImpuesto.setBounds(541, 870, 106, 25);
		getContentPane().add(lblImpuesto);
		
		txtIGV = new JTextField();
		txtIGV.setEditable(false);
		txtIGV.setBounds(652, 869, 86, 25);
		getContentPane().add(txtIGV);
		txtIGV.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTotal.setBounds(780, 870, 46, 25);
		getContentPane().add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(838, 869, 86, 25);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(1000, 869, 118, 25);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Grabar");
		lblNewLabel.setBorder(new LineBorder(Color.decode("#28a745")));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBackground(Color.decode("#28a745"));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setOpaque(true);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(txtTelefono.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "eliga un proveedor");
				}
				else if(txtDireccionEntrega.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "llene la direccion de entrega");
				}
				else if(txtDireccionFactura.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "llene la direccion de factura");
				}
				else if(tblProducto.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "escoja algun producto");
				}
				
	
				else {
					
				
				
				grabarOrdenCompra();
				
				IntGestionOrdenDeCompra.model.setRowCount(0);
				IntGestionOrdenDeCompra.listaOrdeCompra();
				FrmOrdenDeCompra j=new FrmOrdenDeCompra();
				j.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
				}
			
				
				
			}
		});
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 118, 25);
		panel_6.add(lblNewLabel);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(1029, 473, 89, 26);
		getContentPane().add(btnLimpiar);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuario.setBounds(45, 81, 64, 14);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JLabel("");
		txtUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		txtUsuario.setBounds(114, 75, 100, 25);
		getContentPane().add(txtUsuario);

		iniciaReloj();
		
	}
	
	
	
	double total = 0; // <----------------VARIABLE GLOBAL PARA EL TOTAL DE LA 	 VENTA
	void iniciaReloj() {

		// INSTANCIAMOS LA CLASE HILO RELOJ
		Hilo_Tiempo r = new Hilo_Tiempo();

		// INICIA EL HILO
		r.start();
	}

	/* lista proveedores */

	public void listar() {

		try {

			String busquedad = txtBusquedad.getText();

			GestionProveedor gc = new GestionProveedor();

			ArrayList<Proveedores> lista = gc.listado();

			modelBusquedad.getDataVector().removeAllElements();
			for (Proveedores c : lista) {

				Object datos[] = { c.getNom_prov() };
				modelBusquedad.addRow(datos);

			}

		} catch (Exception e) {
			System.out.println("error al listar el proveedoer");
		}

	}

	public void buscar() {

		 String busquedad = txtBusquedad.getText();

		GestionProveedor gc = new GestionProveedor();
		modelBusquedad.getDataVector().removeAllElements();

		ArrayList<Proveedores> list = gc.listado(busquedad);
		for (Proveedores cl : list) {
			Object datos[] = { cl.getNom_prov() };
			modelBusquedad.addRow(datos);

		}
	}
	

	
	/*grabar la orden de compra*/
	void grabarOrdenCompra() {
		/*Orden Compra*/
		int idProve,idUsu;
		String fechaEntregaCompra,direcEntrega,direcFactura,conPago,contacto;
		
		idProve=Integer.parseInt(txtCodigo.getText());
		
		Date fecha1=dtmFecha.getDate();
		String formato = dtmFecha.getDateFormatString();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		
		String fecha=String.valueOf(sdf.format(fecha1));

		
		
		fechaEntregaCompra=	fecha;
		direcEntrega=txtDireccionEntrega.getText();
		direcFactura=txtDireccionFactura.getText();
		conPago=(String)cboCondicionPago.getSelectedItem();
		contacto=txtContacto.getText();
		idUsu=FrmLogin.e.getId_emp();
		
		
		
		OrdenCompra o=new OrdenCompra();
		o.setCodProveedor(idProve);
	
		o.setFechaEntrega(fechaEntregaCompra);
		o.setDirecEntrega(direcEntrega);
		o.setDirecFactura(direcFactura);
		o.setCondicionPago(conPago);
		o.setContacto(contacto);
		o.setCodUsuario(idUsu);
		
		for(int i=0;i<tblProducto.getRowCount();i++) {
			
		
		
		DetalleCompra dv = new DetalleCompra();
		
		
		dv.setNroCompra(g.ObtenerNumero());
		dv.setIdprodu(Integer.parseInt(tblProducto.getValueAt(i,0).toString()));
		dv.setCantidad(Integer.parseInt(tblProducto.getValueAt(i, 2).toString()));
		dv.setPrecio(Double.parseDouble(tblProducto.getValueAt(i,3).toString()));
		
		
		carrito.add(dv);
		}
		System.out.println("en el buscar es "+carrito);
	
		
		
		
		
		
		System.out.println("en el frmOrden Compra es "+carrito);
	
		int ok=g.ordenCompra(o, carrito);
		
		
		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "Error al Grabar la Compra");
		} else {
			JOptionPane.showMessageDialog(null, "Compra Exitosa");
		}
	
		
		
		
	}
}
