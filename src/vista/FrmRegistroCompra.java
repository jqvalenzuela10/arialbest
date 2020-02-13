
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.LabelUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import hilos.Hilo_Tiempo;
import mantenimientos.GestionCaja;
import mantenimientos.GestionCompra;
import mantenimientos.GestionMovimiento;
import model.Caja;
import model.DetalleCompra;
import model.JDateChooserEditor;
import model.Movimiento;
import model.OrdenCompra;
import model.Proveedores;
import model.RegistroCompra;
import model.Render;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

import componentes.boton;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class FrmRegistroCompra extends JDialog {
	private JTextField txtProveedor;
	private JTextField txtRuc;
	public static JLabel lblReloj;
	public static JLabel lblFecha;
	private JTextField txtOrdenCompra;
	public static DefaultTableModel model=new DefaultTableModel();
	public static JTable tblRegistroCompra;
	private JTextField txtTotal;
	public static double importe;
	public static double subtotal;
	public static double igv;
	public static double total;
	private JComboBox cboComprovante;
	private JDateChooser dtmEmision;
	private JDateChooser dtmVencimiento;
	public String numeroCompra;
	public int numero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmRegistroCompra dialog = new FrmRegistroCompra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRegistroCompra() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				lblUsuario.setText(FrmLogin.e.getNom_emp());
			
				
			}
		});
		
		
		setModal(true);
		
		/*model para el registro de compra*/
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Codigo");
		model.addColumn("Descripcion");
		model.addColumn("Cantidad");
	
		model.addColumn("precio");
	
		
		/*el precio unitario es el valor unitario mas el impuesto */
		/*model.addColumn("Precion unitario");*/
		
		
		
	
		model.addColumn("importe");
		model.addColumn("eliminar");
	/*	model.addColumn("fecha Caducidad");*/
		
		
		setBounds(100, 100, 1370, 830);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(45, 54, 63));
		panel.setBounds(0, 0, 1354, 66);
		getContentPane().add(panel);
		
		JLabel lblRegistroDeCompra = new JLabel("REGISTRO DE COMPRA");
		lblRegistroDeCompra.setForeground(Color.WHITE);
		lblRegistroDeCompra.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblRegistroDeCompra.setBounds(34, 0, 194, 66);
		panel.add(lblRegistroDeCompra);
		
		GestionCompra g=new GestionCompra();
		 numero=g.ObtenerNumeroRegistroCompra();
		numeroCompra ="N°0000"+numero;
		
		lblNumeroOrden = new JLabel(numeroCompra);
		lblNumeroOrden.setForeground(Color.WHITE);
		lblNumeroOrden.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNumeroOrden.setBounds(1216, 27, 78, 14);
		panel.add(lblNumeroOrden);
		
		JLabel label = new JLabel("Usuario :");
		label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label.setBounds(34, 83, 64, 14);
		getContentPane().add(label);
		
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsuario.setBounds(104, 77, 100, 20);
		getContentPane().add(lblUsuario);
		
		JLabel label_2 = new JLabel("________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		label_2.setBounds(0, 96, 1367, 14);
		getContentPane().add(label_2);
		
		
		lblFecha = new JLabel("");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFecha.setBounds(1057, 77, 91, 29);
		getContentPane().add(lblFecha);
		
		 lblReloj = new JLabel("");
		lblReloj.setForeground(Color.BLACK);
		lblReloj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblReloj.setBounds(1158, 77, 46, 29);
		getContentPane().add(lblReloj);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(34, 130, 358, 245);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_8 = new JLabel("Razon Social  :");
		label_8.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		label_8.setBounds(10, 63, 115, 14);
		panel_1.add(label_8);
		
		JLabel lblRuc = new JLabel("RUC              :     ");
		lblRuc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblRuc.setBounds(10, 107, 115, 14);
		panel_1.add(lblRuc);
		
		JLabel lblDireccion = new JLabel("Direccion       :");
		lblDireccion.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDireccion.setBounds(10, 154, 115, 14);
		panel_1.add(lblDireccion);
		
		txtProveedor = new JTextField();
		txtProveedor.setOpaque(false);
		txtProveedor.setColumns(10);
		txtProveedor.setBounds(135, 61, 184, 20);
		panel_1.add(txtProveedor);
		
		txtRuc = new JTextField();
		txtRuc.setOpaque(false);
		txtRuc.setColumns(10);
		txtRuc.setBounds(135, 105, 184, 20);
		panel_1.add(txtRuc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(45, 54, 63));
		panel_2.setBounds(0, 0, 389, 50);
		panel_1.add(panel_2);
		
		JLabel label_1 = new JLabel("Proveedor");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_1.setBounds(10, 0, 73, 50);
		panel_2.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(93, 17, 222, 20);
		panel_2.add(textField);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(314, 17, 20, 20);
		panel_2.add(label_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_5.setBounds(466, 0, 56, 50);
		panel_2.add(label_5);
		
		txtCodigo = new JLabel("");
		txtCodigo.setForeground(Color.WHITE);
		txtCodigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtCodigo.setBounds(340, 0, 49, 50);
		panel_2.add(txtCodigo);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(135, 152, 184, 20);
		txtDireccion.setOpaque(false);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblContacto = new JLabel("Contacto       :");
		lblContacto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblContacto.setBounds(10, 195, 115, 14);
		panel_1.add(lblContacto);
		
		txtContacto = new JTextField();
		txtContacto.setOpaque(false);
		txtContacto.setColumns(10);
		txtContacto.setBounds(135, 193, 184, 20);
		panel_1.add(txtContacto);
		
		JLabel lblComprobante = new JLabel("Comprobante");
		lblComprobante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblComprobante.setBounds(507, 74, 95, 33);
		getContentPane().add(lblComprobante);
		
		cboComprovante = new JComboBox();
		cboComprovante.setModel(new DefaultComboBoxModel(new String[] {"BOLETA", "FACTURA"}));
		cboComprovante.setBounds(628, 82, 128, 20);
		getContentPane().add(cboComprovante);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(507, 130, 358, 245);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(45, 54, 63));
		panel_4.setBounds(0, 0, 358, 50);
		panel_3.add(panel_4);
		
		JLabel lblCondicionesDePago = new JLabel("Condiciones de pago");
		lblCondicionesDePago.setForeground(Color.WHITE);
		lblCondicionesDePago.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCondicionesDePago.setBounds(10, 0, 141, 50);
		panel_4.add(lblCondicionesDePago);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(365, 17, 20, 20);
		panel_4.add(label_4);
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_9.setBounds(466, 0, 56, 50);
		panel_4.add(label_9);
		
		JLabel lblFechaDeEmision = new JLabel("fecha de emision  :");
		lblFechaDeEmision.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaDeEmision.setBounds(10, 61, 115, 14);
		panel_3.add(lblFechaDeEmision);
		
		JLabel lblFormaDePago = new JLabel("Forma de pago     :");
		lblFormaDePago.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFormaDePago.setBounds(10, 112, 115, 14);
		panel_3.add(lblFormaDePago);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de vencimiento    :");
		lblFechaDeVencimiento.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblFechaDeVencimiento.setBounds(10, 160, 125, 14);
		panel_3.add(lblFechaDeVencimiento);
		cboFormaPago= new JComboBox();
		cboFormaPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selected=cboFormaPago.getSelectedItem().toString();
				Date fecha=new Date();
				
				 Calendar calendar = Calendar.getInstance();
			      calendar.setTime(fecha); 
				 if(selected.equals("credito 30")) {
					
				      calendar.add(Calendar.DAY_OF_YEAR, 30);  
					dtmVencimiento.setDate(calendar.getTime());
				}
				 else if(selected.equals("credito 60")) {
					   calendar.add(Calendar.DAY_OF_YEAR, 60);  
					   dtmVencimiento.setDate(calendar.getTime());
				 }
				 else if(selected.equals("credito 90")) {
					   calendar.add(Calendar.DAY_OF_YEAR, 90);  
					   dtmVencimiento.setDate(calendar.getTime());
				 }
				 else {
					 System.out.println("efectivo");
				 }
			}
		});
		cboFormaPago.setModel(new DefaultComboBoxModel(new String[] {"seleccione", "efectivo", "credito 30 ", "credito 90", "credito 120"}));
		
		cboFormaPago.setBounds(146, 110, 94, 20);
		panel_3.add(cboFormaPago);
		
		dtmEmision = new JDateChooser();
		dtmEmision.setBounds(145, 61, 95, 20);
		panel_3.add(dtmEmision);
		
		dtmVencimiento = new JDateChooser();
		dtmVencimiento.setBounds(145, 154, 95, 20);
		panel_3.add(dtmVencimiento);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(975, 130, 358, 245);
		getContentPane().add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(45, 54, 63));
		panel_8.setBounds(0, 0, 358, 50);
		panel_7.add(panel_8);
		
		JLabel lblDatosAdicionales = new JLabel("Datos adicionales");
		lblDatosAdicionales.setForeground(Color.WHITE);
		lblDatosAdicionales.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDatosAdicionales.setBounds(10, 0, 141, 50);
		panel_8.add(lblDatosAdicionales);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(365, 17, 20, 20);
		panel_8.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label_12.setBounds(466, 0, 56, 50);
		panel_8.add(label_12);
		
		JLabel lblOrdenDeCompra = new JLabel("Orden de compra");
		lblOrdenDeCompra.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblOrdenDeCompra.setBounds(10, 72, 115, 14);
		panel_7.add(lblOrdenDeCompra);
		
	
		
		
		
		
	
		
		txtOrdenCompra = new JTextField();
		txtOrdenCompra.setBounds(134, 70, 95, 20);
		panel_7.add(txtOrdenCompra);
		txtOrdenCompra.setColumns(10);
		
		JButton btnPoner = new JButton("poner");
		btnPoner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model.setRowCount(0);
				int codigoOrdenCompra=Integer.parseInt(txtOrdenCompra.getText());
				
				ArrayList<OrdenCompra>datosProducto= g.listaOrdenCompra(codigoOrdenCompra);
				ArrayList<OrdenCompra>lista= g.obtenerDatosOrdenCompra(codigoOrdenCompra);
				if(lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "el numero de orden no existe");
				}
				else {
					
				int codigoProve=lista.get(0).getCodProveedor();
				
				lblUsuario.setText(lista.get(0).getNomUsuario());
				txtCodigo.setText(codigoProve+"");
				txtProveedor.setText(lista.get(0).getNomProveedor());
				txtRuc.setText(lista.get(0).getRuc());
				txtDireccion.setText(lista.get(0).getDirecProveedor());
				cboFormaPago.setSelectedItem(lista.get(0).getCondicionPago());
				
				
				/*tblRegistroCompra.getColumnModel().getColumn(7).setCellEditor(new JDateChooserEditor(new JCheckBox()));
					DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
					tblRegistroCompra.getColumnModel().getColumn(7).setCellRenderer(renderer);*/
				
				int total=0;
				
				for (OrdenCompra cl : datosProducto) {
					double subtotal=cl.getCantidad()*cl.getPrecio();
					
					Object datos[] = { cl.getIdprodu(),cl.getNomProd(),cl.getCantidad(),cl.getPrecio(),subtotal};
					model.addRow(datos);
					total+=subtotal;

				}
				
				
				txtTotal.setText(""+total);
				/* calcular el importe */
			/*
				double precio = Double.parseDouble(tblRegistroCompra.getValueAt(1, 4).toString());
				double cantidad = Double.parseDouble(tblRegistroCompra.getValueAt(1, 3).toString());
				importe = precio * cantidad;

				
				subtotal = subtotal + importe;
				

				
				igv = subtotal * 0.18;

				
				total = subtotal + igv;
				
				txtSubtotal.setText(subtotal + "");

				txtImpuesto.setText(igv + "");
*/
				txtTotal.setText(total + "");
				
				
				}
			}
		});
		btnPoner.setBounds(10, 111, 89, 23);
		panel_7.add(btnPoner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(507, 466, 826, 235);
		getContentPane().add(scrollPane);
		
		tblRegistroCompra = new JTable();
		tblRegistroCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				int fila=tblRegistroCompra.getSelectedRow();
			
				
				String dato=String.valueOf(tblRegistroCompra.getValueAt(fila, 5));
			System.out.println(dato);
				 if(dato.toString().equals("eliminar")) {
					 JOptionPane.showMessageDialog(null, "eliminado");
					 model.removeRow(fila);
				 }
				 else {
					 
					 
				String codigo=tblRegistroCompra.getValueAt(fila, 0).toString();
				String descripcion=tblRegistroCompra.getValueAt(fila, 1).toString();
				String cantidad=tblRegistroCompra.getValueAt(fila, 2).toString();
				String precio=tblRegistroCompra.getValueAt(fila, 3).toString();
				
				lblcodigo.setText(codigo);
				lbldescripcion.setText(descripcion);
				txtCantidad.setText(cantidad);
				lblprecio.setText(precio);
			}}
		});
		tblRegistroCompra.setModel(model);
		scrollPane.setColumnHeaderView(tblRegistroCompra);
		
		JLabel label_19 = new JLabel("Total");
		label_19.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_19.setBounds(1158, 687, 46, 14);
		getContentPane().add(label_19);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(1247, 708, 86, 20);
		getContentPane().add(txtTotal);
		
		label_6 = new JLabel("Grabar");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			grabar();
			
			IntGestionDeCompra.model.setRowCount(0);
			IntGestionDeCompra.listadoRegistroCompra();
			dispose();
			
			}
		});
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_6.setBorder(new LineBorder(Color.decode("#28a745")));
		label_6.setBackground(new Color(40, 167, 69));
		label_6.setBounds(1233, 739, 100, 25);
		getContentPane().add(label_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(34, 426, 358, 275);
		getContentPane().add(panel_6);
		
		JLabel label_7 = new JLabel("Codigo");
		label_7.setBounds(10, 69, 46, 14);
		panel_6.add(label_7);
		
		JLabel label_10 = new JLabel("Descripcion");
		label_10.setBounds(10, 105, 65, 14);
		panel_6.add(label_10);
		
		JLabel label_13 = new JLabel("Cantidad");
		label_13.setBounds(10, 184, 46, 14);
		panel_6.add(label_13);
		
		JLabel label_14 = new JLabel("Precio");
		label_14.setBounds(10, 143, 46, 14);
		panel_6.add(label_14);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(81, 181, 86, 20);
		panel_6.add(txtCantidad);
		
		lblcodigo = new JLabel("");
		lblcodigo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblcodigo.setBounds(87, 69, 80, 14);
		panel_6.add(lblcodigo);
		
		lbldescripcion = new JLabel("");
		lbldescripcion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lbldescripcion.setBounds(85, 105, 80, 14);
		panel_6.add(lbldescripcion);
		
		lblprecio = new JLabel("");
		lblprecio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblprecio.setBounds(87, 143, 80, 14);
		panel_6.add(lblprecio);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if(lblcodigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "busque un producto");
				}
				
				else if(txtCantidad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ingrese la cantidad");
				}else {
					
					int fila=validar();
					
					/*valida para ver si quiere agregar un producto que ya existe si es -1 no existe sino si existe*/
					if(fila!=-1) {
						tblRegistroCompra.setValueAt(txtCantidad.getText(), fila, 2);
						int cantidad=Integer.parseInt(txtCantidad.getText());
						double precio=Double.parseDouble(lblprecio.getText());
						
						
						/*cambiar el importe*/
						tblRegistroCompra.setValueAt(precio*cantidad, fila, 4);
						
						
						/*cambiar el total */
						double tota=calcularTotal();
						txtTotal.setText(tota+"");
						
					}
					else {
						
					String codigo=lblcodigo.getText();
					String descripcion=lbldescripcion.getText();
					double precio=Double.parseDouble(lblprecio.getText());
					int cantidad=Integer.parseInt(txtCantidad.getText());
					double importe=precio*cantidad;
				 
					
				
				Object[] filas = new Object[6];

				filas[0] = codigo;
				filas[1] = descripcion;
				filas[2]=cantidad;
				filas[3] = precio;
				filas[4]=importe;
				
				FrmRegistroCompra.tblRegistroCompra.setDefaultRenderer(Object.class, new Render());
				 
				 
				 
				
				 
				 	JButton btnEliminar = new JButton("eliminar");
			        ImageIcon delete = new ImageIcon(getClass().getResource("/img/eliminar.png"));
			    	Image i = delete.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
			    	Icon ic = new ImageIcon(i);
			    	btnEliminar.setIcon(ic);
			    	btnEliminar.setName("eliminar");
			
			    
				filas[5]=btnEliminar;
				
				model.addRow(filas);
				double tota=calcularTotal();
				txtTotal.setText(tota+"");
				
				lblcodigo.setText("");
				lbldescripcion.setText("");
				lblprecio.setText("");
				txtCantidad.setText("");
			}}}
		});
	
		btnAceptar.setBounds(10, 241, 89, 23);
		panel_6.add(btnAceptar);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 17, 166, 29);
		panel_6.add(panel_5);
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmBuscarProductoRegistroCompra f=new FrmBuscarProductoRegistroCompra();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		
		boton.mibotonAgregar(panel_5);
		
		JLabel lblProductoACompra = new JLabel("Producto A Comprar");
		lblProductoACompra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblProductoACompra.setBounds(507, 426, 146, 29);
		getContentPane().add(lblProductoACompra);
		
		iniciaReloj();
	}
	
	ArrayList<DetalleCompra> carrito = new ArrayList<>();
	private JLabel lblUsuario;
	private JTextField textField;
	private JTextField txtDireccion;
	private JLabel label_6;
	private JTextField txtContacto;
	private JLabel lblNumeroOrden;
	private JLabel txtCodigo;
	private JComboBox cboFormaPago;
	private JTextField txtCantidad;
	public static  JLabel lblcodigo;
	public static JLabel lblprecio;
	public static JLabel lbldescripcion;
	private JButton btnAceptar;
	
	
	
	void iniciaReloj() {
		Hilo_Tiempo h=new Hilo_Tiempo();
		h.start();
	}
	
void grabar() {
		
		int nroOrdenCompra,idProve,idUsu,nroRegistroCompra;
		String comprovante,fechaRegis,fechaVenci,formaPago,contacto;
		
		GestionCompra c=new GestionCompra();
		
		System.out.println(numero);
		nroRegistroCompra=numero;
		
		String texto=txtOrdenCompra.getText();
		
		if(texto.isEmpty()) {
			nroOrdenCompra=0;
		}else {
			
		nroOrdenCompra=Integer.parseInt(txtOrdenCompra.getText());
		}
		
		
		comprovante=cboComprovante.getSelectedItem().toString();
		idProve=1;
		idUsu=FrmLogin.e.getId_emp();
		formaPago=cboFormaPago.getSelectedItem().toString();
		contacto=txtContacto.getText();
		/*para la fecha*/
		Date fecha1=dtmEmision.getDate();
		Date fecha2=dtmVencimiento.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		System.out.println(sdf.format(fecha1).toString());
		fechaRegis=sdf.format(fecha1).toString();
		fechaVenci=sdf.format(fecha2).toString();
		
		
		RegistroCompra r=new RegistroCompra();
		r.setCodRegisCompra(nroRegistroCompra);
		r.setNroOrdenCompra(nroOrdenCompra);
		r.setComprovante(comprovante);
		r.setFechaRegisCompra(fechaRegis);
		r.setFechaVenCompra(fechaVenci);
		
		r.setCondicionesPago(formaPago);
		r.setContacto(contacto);
		r.setIdProve(idProve);
		r.setIdUsu(idUsu);
		
		double importe=0;
		double total=0;
		for(int i=0;i<tblRegistroCompra.getRowCount();i++) {
			DetalleCompra deta=new DetalleCompra();
			
			deta.setIdprodu(Integer.parseInt(tblRegistroCompra.getValueAt(i, 0).toString()));
			deta.setCantidad(Integer.parseInt(tblRegistroCompra.getValueAt(i, 2).toString()));
			deta.setPrecio(Double.parseDouble(tblRegistroCompra.getValueAt(i, 3).toString()));
			
			
			double precio=Double.parseDouble(tblRegistroCompra.getValueAt(i, 3).toString());
			int can=Integer.parseInt(tblRegistroCompra.getValueAt(i, 2).toString());
			importe=precio*can;
			total+=importe;
			carrito.add(deta);
		}
		
		int ok=c.realizaCompra(r, carrito);
		
		
		if(formaPago.equals("efectivo")) {
			
			
			/*para la tabla movimiento*/
			int codCaja=Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText().toString());
			double saldoTotal=Double.parseDouble(FrmMenuPrincipal.lblSaldo.getText());
			int codigo=new GestionCompra().ObtenerNumero();
			Movimiento m=new Movimiento();
			m.setComentario("nada por mientras");
			m.setTipo_movimiento("compra");
			m.setNro_ven(0);
			m.setCod_regis_com(codigo);
		
			m.setSalida(total);
			m.setSaldo(saldoTotal-total);
			m.setCodcaja(Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText().toString()));
			
			/*para actualizar la caja*/
			Caja ca=new Caja();
			
			ca.setCodCaja(codCaja);
			ca.setSaldo(saldoTotal-total);
			FrmMenuPrincipal.lblSaldo.setText(saldoTotal-total+"");
			int ok1=new GestionCaja().actualizar(ca);
			int okey=new GestionMovimiento().insertar(m);
			System.out.println(":b"+okey);
			
			int okey2=new GestionMovimiento().insertar(m);
			System.out.println(":b"+okey2);

			
			
			
			}
		
		
		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "Error al Grabar la Compra");
		} else {
			JOptionPane.showMessageDialog(null, "registro Exitosa");
		}
	
}	

public int validar() {
	int fila=-1;
	
	for(int i=0;i<tblRegistroCompra.getRowCount();i++) {
	String codigo=tblRegistroCompra.getValueAt(i, 0).toString();
	if(lblcodigo.getText().equals(codigo)) {
		fila=i;
		return fila;
	}else {
		fila=-1;
	}
		
	}
	
	return fila;
}
double tot=0;
double imp=0;

public double calcularTotal() {
	if(tot!=0) {
		tot=0;
		for(int i=0;i<tblRegistroCompra.getRowCount();i++) {
			
			imp=Double.parseDouble(tblRegistroCompra.getValueAt(i, 4).toString());
			tot+=imp;
			
		}
	}else {
		
	for(int i=0;i<tblRegistroCompra.getRowCount();i++) {
		
		imp=Double.parseDouble(tblRegistroCompra.getValueAt(i, 4).toString());
		tot+=imp;
		
	}
	
	}return tot;
	
}
}

