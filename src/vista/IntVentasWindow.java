package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import componentes.boton;
import mantenimientos.GestionCaja;
import mantenimientos.GestionClientes;
import mantenimientos.GestionCorteCaja;
import mantenimientos.GestionMovimiento;
import mantenimientos.GestionVentas;
import model.Caja;
import model.Clientes;
import model.DetalleCompra;
import model.DetalleVentas;
import model.Movimiento;
import model.Render;
import model.Ventas;
import utils.FormatoTablaMain;
import utils.clsArial;

import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntVentasWindow extends JInternalFrame {
	private String colorFondo="#ebf0f4";
	public String ColorMain ="#2D363F";
	public static JTextField txtCliente;
	private JLabel lblUser;
	public static  JTable tblProducto;
	public static DefaultTableModel model=new DefaultTableModel();
	public static JLabel lblReloj;
	public static JLabel lblFecha;
	private JLabel lblTotal;
	public static JLabel lblCodigo;
	private JComboBox cboTipoDeComprovante;
	private JLabel lblNumeroVenta;
	private JPanel panel_agregar;
	public static JComboBox cboFormaPago;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
	
	public static JLabel lblcodigo;
	public static JLabel lbldescripcion;
	public static JLabel lblprecio;
	public static JTextField txtCantidad;
	public int fila;
	public double total;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntVentasWindow frame = new IntVentasWindow();
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
	public IntVentasWindow() {
		
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				lblUser.setText(FrmLogin.e.getNom_emp());
				
			}
		});
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("codigo");
		model.addColumn("descripcion");
		model.addColumn("cantidad");
		model.addColumn("precio");
		model.addColumn("importe");
		model.addColumn("eliminar");

		
		
		setBackground(Color.RED);
		setBounds(100, 100, 1626, 901);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(140, 11, 1317, 849);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(45, 54, 63));
		panel_1.setBounds(0, 0, 1316, 66);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Usuario");
		label.setForeground(Color.WHITE);
		label.setBounds(10, 28, 78, 14);
		panel_1.add(label);
		
		lblUser = new JLabel("");
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(85, 28, 58, 14);
		panel_1.add(lblUser);
		
		lblFecha = new JLabel("");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFecha.setBounds(805, 19, 91, 29);
		panel_1.add(lblFecha);
		
		lblReloj = new JLabel("");
		lblReloj.setForeground(Color.WHITE);
		lblReloj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblReloj.setBounds(916, 19, 46, 29);
		panel_1.add(lblReloj);
		
		String numeroCompra;
		GestionVentas g=new GestionVentas();
		numeroCompra ="N°0000"+g.ObtenerNumero();
		
		lblNumeroVenta = new JLabel(numeroCompra);
		lblNumeroVenta.setForeground(Color.WHITE);
		lblNumeroVenta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNumeroVenta.setBounds(1209, 28, 78, 14);
		panel_1.add(lblNumeroVenta);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(148, 121, 30, 20);
		clsArial clsArial=new clsArial();
		clsArial.modifiedIcon("/iconos/user.png", 30, 30, label_4);
		panel.add(label_4);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(188, 121, 199, 20);
		panel.add(txtCliente);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmBuscarLCiente c=new FrmBuscarLCiente();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(397, 121, 20, 20);
		clsArial.modifiedIcon("/iconos/search.png", 20, 20, label_5);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		clsArial.modifiedIcon("/iconos/product.png", 20, 20, label_6);
		label_6.setBounds(158, 208, 30, 30);
		panel.add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 277, 706, 285);
		panel.add(scrollPane);
		
		tblProducto = new JTable();
		tblProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				int fila=tblProducto.getSelectedRow();
			
				
				String dato=String.valueOf(tblProducto.getValueAt(fila, 5));
			System.out.println(dato);
				 if(dato.toString().equals("eliminar")) {
					 JOptionPane.showMessageDialog(null, "eliminado");
					 model.removeRow(fila);
				 }
				 else {
					 
					 
				String codigo=tblProducto.getValueAt(fila, 0).toString();
				String descripcion=tblProducto.getValueAt(fila, 1).toString();
				String cantidad=tblProducto.getValueAt(fila, 2).toString();
				String precio=tblProducto.getValueAt(fila, 3).toString();
				
				lblcodigo.setText(codigo);
				lbldescripcion.setText(descripcion);
				txtCantidad.setText(cantidad);
				lblprecio.setText(precio);
			}
			 }
		});
	
		tblProducto.setModel(model);
		scrollPane.setViewportView(tblProducto);
		
		FormatoTablaMain.formatoTabla(tblProducto);
		
		JLabel lblTot = new JLabel("Total");
		lblTot.setBounds(1001, 604, 54, 20);
		panel.add(lblTot);
		
		lblTotal = new JLabel("");
		lblTotal.setBounds(1102, 604, 83, 20);
		panel.add(lblTotal);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				grabar();
				
			}
		});
		btnGrabar.setBounds(779, 674, 89, 23);
		panel.add(btnGrabar);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBounds(453, 127, 46, 14);
		panel.add(lblCodigo);
		
		cboTipoDeComprovante = new JComboBox();
		cboTipoDeComprovante.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Factura", "Boleta"}));
		cboTipoDeComprovante.setBounds(1045, 121, 140, 30);
		panel.add(cboTipoDeComprovante);
		
		JLabel lblFechaVencimiento = new JLabel("fecha vencimiento");
		lblFechaVencimiento.setBounds(901, 214, 113, 30);
		panel.add(lblFechaVencimiento);
		
		dtmFechaVencimineto = new JDateChooser();
		
		dtmFechaVencimineto.setDateFormatString("yyyy/MM/dd");
		dtmFechaVencimineto.setBounds(1076, 224, 109, 20);
		panel.add(dtmFechaVencimineto);
		
		panel_agregar = new JPanel();
		panel_agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmBuscarProductoVenta f=new FrmBuscarProductoVenta();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		panel_agregar.setBounds(198, 208, 121, 29);
		boton.mibotonAgregar(panel_agregar);
		panel.add(panel_agregar);
		
		cboFormaPago = new JComboBox();
		cboFormaPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selected=cboFormaPago.getSelectedItem().toString();
				Date fecha=new Date();
				
				 Calendar calendar = Calendar.getInstance();
			      calendar.setTime(fecha); 
				 if(selected.equals("credito 30")) {
					
				      calendar.add(Calendar.DAY_OF_YEAR, 30);  
					dtmFechaVencimineto.setDate(calendar.getTime());
				}
				 else if(selected.equals("credito 60")) {
					   calendar.add(Calendar.DAY_OF_YEAR, 60);  
						dtmFechaVencimineto.setDate(calendar.getTime());
				 }
				 else if(selected.equals("credito 90")) {
					   calendar.add(Calendar.DAY_OF_YEAR, 90);  
						dtmFechaVencimineto.setDate(calendar.getTime());
				 }
				 else {
					 System.out.println("efectivo");
				 }
			}
		});
	
		
		
		cboFormaPago.setModel(new DefaultComboBoxModel(new String[] {"seleccione", "efectivo", "credito 30", "credito 60", "credito 90"}));
		cboFormaPago.setBounds(1040, 176, 145, 20);
		panel.add(cboFormaPago);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(158, 277, 293, 285);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(10, 57, 46, 14);
		panel_2.add(lblCodigo_1);
		
		JLabel lblNombre = new JLabel("Descripcion");
		lblNombre.setBounds(10, 105, 65, 14);
		panel_2.add(lblNombre);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 184, 46, 14);
		panel_2.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 143, 46, 14);
		panel_2.add(lblPrecio);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(81, 181, 86, 20);
		panel_2.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		 lblcodigo = new JLabel("");
		 lblcodigo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblcodigo.setBounds(87, 57, 80, 14);
		panel_2.add(lblcodigo);
		
		 lbldescripcion = new JLabel("");
		 lbldescripcion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lbldescripcion.setBounds(85, 105, 80, 14);
		panel_2.add(lbldescripcion);
		
		lblprecio = new JLabel("");
		lblprecio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblprecio.setBounds(87, 143, 80, 14);
		panel_2.add(lblprecio);
		
		btnAceptar = new JButton("Aceptar");
		
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				
				
				if(lblcodigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "busque un producto");
				}
				
				else if(txtCantidad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ingrese la cantidad");
				}else {
					
					int fila=validar();
					
					if(fila!=-1) {
						tblProducto.setValueAt(txtCantidad.getText(), fila, 2);
						int cantidad=Integer.parseInt(txtCantidad.getText());
						double precio=Double.parseDouble(lblprecio.getText());
						
						tblProducto.setValueAt(precio*cantidad, fila, 4);
						
						double tota=calcularTotal();
						lblTotal.setText(tota+"");
						
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
				
				 IntVentasWindow.tblProducto.setDefaultRenderer(Object.class, new Render());
				 
				 
				 
				
				 
				 	JButton btnEliminar = new JButton("eliminar");
			        ImageIcon delete = new ImageIcon(getClass().getResource("/img/eliminar.png"));
			    	Image i = delete.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
			    	Icon ic = new ImageIcon(i);
			    	btnEliminar.setIcon(ic);
			    	btnEliminar.setName("eliminar");
			
			    
				filas[5]=btnEliminar;
				
				model.addRow(filas);
				double tota=calcularTotal();
				lblTotal.setText(tota+"");
				
				lblcodigo.setText("");
				lbldescripcion.setText("");
				lblprecio.setText("");
				txtCantidad.setText("");

				}
				}
			}
		});
		btnAceptar.setBounds(10, 251, 89, 23);
		panel_2.add(btnAceptar);
		
		JLabel lblFormaPago = new JLabel("Forma pago");
		lblFormaPago.setBounds(901, 179, 83, 20);
		panel.add(lblFormaPago);
		
		JLabel lblTipoPago = new JLabel("Tipo pago");
		lblTipoPago.setBounds(901, 127, 54, 14);
		panel.add(lblTipoPago);
		
	
	

	}
	ArrayList<DetalleVentas> carrito = new ArrayList<>();
	private JDateChooser dtmFechaVencimineto;

	private JButton btnAceptar;
	
	
	void grabar() {
		
		int id_cli,id_usu;
		String tipo_comprovante,numero_comprovante,dtmFechaVencimiento,numeroCompra,formaPago;
	
		
		
		tipo_comprovante=cboTipoDeComprovante.getSelectedItem().toString();
		formaPago=cboFormaPago.getSelectedItem().toString();
		/*el sdf lo saca del simpledateformat que esta arriba*/
		dtmFechaVencimiento=sdf.format(dtmFechaVencimineto.getDate());

		GestionVentas g=new GestionVentas();
		numeroCompra =""+g.ObtenerNumero();
		
		
		
		
		 if(tipo_comprovante==null || tipo_comprovante=="Seleccione") {
			JOptionPane.showMessageDialog(null, "ingrese el tipo de comprobante");
		}
		else if(dtmFechaVencimineto.getDate()==null) {
			JOptionPane.showMessageDialog(null, "ingrese la fecha de vencimiento");
		}
		else {
			
	
		
		id_cli=Integer.parseInt(lblCodigo.getText());
		id_usu=FrmLogin.e.getId_emp();
		
		numero_comprovante=lblNumeroVenta.getText();
		
		
		/*para la tabla ventas*/
		Ventas ve=new Ventas();
		/*el numero de compra viene de la gestion ventas del metodo obtenerNumero()*/
		ve.setNro_ven(Integer.parseInt(numeroCompra));
		ve.setId_cli(id_cli);
		ve.setId_emp(id_usu);
		ve.setDoc_ven(tipo_comprovante);
		ve.setNumeroComprovante(numero_comprovante);
		ve.setFecha_vencimiento(dtmFechaVencimiento);
		ve.setFormaPago(formaPago);
		/*---------------------*/
		
		
		double importe=0;
		double total=0;
		/*para la tabla detalle*/
		for(int i=0;i<tblProducto.getRowCount();i++) {
			DetalleVentas deta=new DetalleVentas();
			
			deta.setId_prod(Integer.parseInt(tblProducto.getValueAt(i, 0).toString()));
			deta.setPrecioUnidad(Double.parseDouble(tblProducto.getValueAt(i, 3).toString()));
			deta.setCantxUnidad(Integer.parseInt(tblProducto.getValueAt(i, 2).toString()));
			
			double precio=Double.parseDouble(tblProducto.getValueAt(i, 3).toString());
			int can=Integer.parseInt(tblProducto.getValueAt(i, 2).toString());
			importe=precio*can;
			total+=importe;
			carrito.add(deta);
		}
		
		/*---------------------*/

		
		GestionVentas v=new GestionVentas();
		System.err.println(carrito);
		int ok=v.realizaVenta(ve, carrito);
		
		
		if(formaPago.equals("efectivo")) {
			
		
		/*para la tabla movimiento*/
		int codCaja=Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText().toString());
		double saldoTotal=Double.parseDouble(FrmMenuPrincipal.lblSaldo.getText());
		Movimiento m=new Movimiento();
		m.setComentario("nada por mientras");
		m.setTipo_movimiento("venta");
		m.setNro_ven(Integer.parseInt(numeroCompra));
		m.setCod_regis_com(0);
		m.setEntrada(total);
		
		m.setSaldo(total+saldoTotal);
		m.setCodcaja(codCaja);
		
		
		/*para actualizar la caja*/
		Caja c=new Caja();
		c.setCodCaja(codCaja);
		c.setSaldo(total+saldoTotal);
		FrmMenuPrincipal.lblSaldo.setText(total+saldoTotal+"");
		int ok1=new GestionCaja().actualizar(c);
		int okey=new GestionMovimiento().insertar(m);
		System.out.println(":b"+okey);

		}
		
		
		if(ok!=0) {
			JOptionPane.showMessageDialog(null, "se realizo la venta");
		}
		else {
			JOptionPane.showMessageDialog(null, "hubo errores");
		}
		

		}
		
	
		
		
	}
	public int validar() {
		int fila=-1;
		
		for(int i=0;i<tblProducto.getRowCount();i++) {
		String codigo=tblProducto.getValueAt(i, 0).toString();
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
			for(int i=0;i<tblProducto.getRowCount();i++) {
				
				imp=Double.parseDouble(tblProducto.getValueAt(i, 4).toString());
				tot+=imp;
				
			}
		}else {
			
		for(int i=0;i<tblProducto.getRowCount();i++) {
			
			imp=Double.parseDouble(tblProducto.getValueAt(i, 4).toString());
			tot+=imp;
			
		}
		
		}return tot;
		
	}
}
