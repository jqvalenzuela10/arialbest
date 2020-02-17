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
import java.beans.PropertyVetoException;
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
	public static  JTable tblProducto;
	public static DefaultTableModel model=new DefaultTableModel(){
		public boolean isCellEditable(int filas,int columnas) {
			
			if(columnas==7) {
				return true;
			}
			else {
				return false;
			}
		}
	};;
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
				
				
			}
		});
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("codigo");
		model.addColumn("descripcion");
		model.addColumn("cantidad");
		model.addColumn("precio");
		model.addColumn("descuento");
		model.addColumn("importe");
		model.addColumn("eliminar");

		clsArial clsArial=new clsArial();
		
		setBackground(Color.RED);
		setBounds(100, 100, 1626, 901);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(140, 11, 1317, 734);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(45, 54, 63));
		panel_1.setBounds(0, 0, 1316, 66);
		panel.add(panel_1);
		
		String numeroCompra;
		GestionVentas g=new GestionVentas();
		numeroCompra ="N°0000"+g.ObtenerNumero();
		
		lblNumeroVenta = new JLabel(numeroCompra);
		lblNumeroVenta.setForeground(Color.WHITE);
		lblNumeroVenta.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNumeroVenta.setBounds(1093, 0, 78, 66);
		panel_1.add(lblNumeroVenta);
	
		lblSale = new JLabel("");
		clsArial.modifiedIcon("/iconos/sale.png", 50, 50, lblSale);
		lblSale.setBounds(155, 11, 72, 44);
		
		panel_1.add(lblSale);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 322, 706, 285);
		panel.add(scrollPane);
		
		tblProducto = new JTable();
		tblProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 int column = tblProducto.getColumnModel().getColumnIndexAtX(arg0.getX());
			        int row = arg0.getY()/tblProducto.getRowHeight();
			        
			        if(row < tblProducto.getRowCount() && row >= 0 && column < tblProducto.getColumnCount() && column >= 0){
			            Object value = tblProducto.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;
			                if(boton.getName().equals("eliminar")){
			                	JOptionPane.showMessageDialog(null, "eliminado");
								 model.removeRow(fila);
			    				
			                   
			                }
			                
			               
			            }
			            
			          /*  if(value instanceof JCheckBox){
			                //((JCheckBox)value).doClick();
			                JCheckBox ch = (JCheckBox)value;
			                if(ch.isSelected()==true){
			                    ch.setSelected(false);
			                }
			                if(ch.isSelected()==false){
			                    ch.setSelected(true);
			                }
			                
			            }*/
			            else  {
							 
							 
		    				String codigo=tblProducto.getValueAt(fila, 0).toString();
		    				String descripcion=tblProducto.getValueAt(fila, 1).toString();
		    				String cantidad=tblProducto.getValueAt(fila, 2).toString();
		    				String precio=tblProducto.getValueAt(fila, 3).toString();
		    				String descuento=tblProducto.getValueAt(fila, 4).toString();
		    				lblcodigo.setText(codigo);
		    				lbldescripcion.setText(descripcion);
		    				txtCantidad.setText(cantidad);
		    				lblprecio.setText(precio);
		    				txtDescuento.setText(descuento);
		    			}
			        }
			    
			
				
			 }
		});
	
		tblProducto.setModel(model);
		scrollPane.setViewportView(tblProducto);
		
		FormatoTablaMain.formatoTabla(tblProducto);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBounds(453, 127, 19, 14);
		panel.add(lblCodigo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(158, 322, 293, 285);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo_1.setBounds(10, 57, 46, 14);
		panel_2.add(lblCodigo_1);
		
		JLabel lblNombre = new JLabel("Descripcion");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(10, 105, 65, 14);
		panel_2.add(lblNombre);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidad.setBounds(10, 184, 65, 14);
		panel_2.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
						double descuento=Double.parseDouble(txtDescuento.getText());
						tblProducto.setValueAt( (precio*cantidad)-(descuento*((precio*cantidad)/100)), fila, 5);
						
						double tota=calcularTotal();
						lblTotal.setText(tota+"");
						
					}
					else {
						
					String codigo=lblcodigo.getText();
					String descripcion=lbldescripcion.getText();
					double precio=Double.parseDouble(lblprecio.getText());
					int cantidad=Integer.parseInt(txtCantidad.getText());
					double descuento=Double.parseDouble(txtDescuento.getText());
					double importe=(precio*cantidad)-(descuento*((precio*cantidad)/100));
				 
					
				
				Object[] filas = new Object[7];

				filas[0] = codigo;
				filas[1] = descripcion;
				filas[2]=cantidad;
				filas[3] = precio;
				filas[4]=descuento;
				filas[5]=importe;
				
				 IntVentasWindow.tblProducto.setDefaultRenderer(Object.class, new Render());
				 
				 
				 
				
				 
				 	JButton btnEliminar = new JButton();
			        ImageIcon delete = new ImageIcon(getClass().getResource("/img/eliminar.png"));
			    	Image i = delete.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
			    	Icon ic = new ImageIcon(i);
			    	btnEliminar.setIcon(ic);
			    	btnEliminar.setName("eliminar");
			
			    
				filas[6]=btnEliminar;
				
				model.addRow(filas);
				double tota=calcularTotal();
				lblTotal.setText(tota+"");
				
				lblcodigo.setText("");
				lbldescripcion.setText("");
				lblprecio.setText("");
				txtCantidad.setText("");
txtDescuento.setText("");
				}
				}
			}
		});
		btnAceptar.setBounds(10, 251, 89, 23);
		panel_2.add(btnAceptar);
		
		panel_agregar = new JPanel();
		panel_agregar.setBounds(50, 12, 121, 29);
		panel_2.add(panel_agregar);
		panel_agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmBuscarProductoVenta f=new FrmBuscarProductoVenta();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		boton.mibotonAgregar(panel_agregar);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(10, 11, 30, 30);
		panel_2.add(label_6);
		clsArial.modifiedIcon("/iconos/product.png", 20, 20, label_6);
		
		JLabel descuento = new JLabel("Descuento");
		descuento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		descuento.setBounds(10, 226, 65, 14);
		panel_2.add(descuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(81, 220, 86, 20);
		panel_2.add(txtDescuento);
		
		JLabel label = new JLabel("%");
		label.setBounds(177, 220, 30, 21);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(45, 54, 63));
		panel_3.setBounds(0, 696, 1316, 38);
		panel.add(panel_3);
		
		JLabel lblTot = new JLabel("Total   S/");
		lblTot.setForeground(Color.WHITE);
		lblTot.setBounds(1055, 11, 54, 20);
		panel_3.add(lblTot);
		lblTot.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblTotal = new JLabel("0.00");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBounds(1119, 11, 71, 20);
		panel_3.add(lblTotal);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(1217, 11, 89, 23);
		panel_3.add(btnGrabar);
		btnGrabar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				grabar();
				
				IntVenta.dk.removeAll();
				IntVenta.dk.repaint();
				IntVentasWindow cliente=new IntVentasWindow();
				IntVenta.dk.add(cliente);
				
				try {
					cliente.setMaximum(true);
					cliente.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					cliente.show(); 
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(158, 96, 284, 187);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(222, 39, 20, 20);
		panel_4.add(label_5);
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmBuscarLCiente c=new FrmBuscarLCiente();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
			}
		});
		label_5.setBackground(Color.BLACK);
		clsArial.modifiedIcon("/iconos/search.png", 20, 20, label_5);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(10, 39, 199, 20);
		panel_4.add(txtCliente);
		txtCliente.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 285, 28);
		panel_6.setBackground(Color.decode(new clsArial().colorMenu));
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblD = new JLabel("Datos del Cliente");
		lblD.setForeground(Color.WHITE);
		lblD.setBounds(10, 0, 117, 25);
		panel_6.add(lblD);
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(125, 5, 30, 20);
		panel_6.add(label_4);
		clsArial.modifiedIcon("/iconos/user.png", 30, 30, label_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(479, 96, 706, 187);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		cboTipoDeComprovante = new JComboBox();
		cboTipoDeComprovante.setBounds(188, 56, 140, 20);
		panel_5.add(cboTipoDeComprovante);
		cboTipoDeComprovante.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Factura", "Boleta"}));
		
		JLabel lblTipoPago = new JLabel("Tipo pago");
		lblTipoPago.setBounds(37, 58, 83, 14);
		panel_5.add(lblTipoPago);
		lblTipoPago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblFormaPago = new JLabel("Forma pago");
		lblFormaPago.setBounds(37, 92, 83, 20);
		panel_5.add(lblFormaPago);
		lblFormaPago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cboFormaPago = new JComboBox();
		cboFormaPago.setBounds(188, 93, 145, 20);
		panel_5.add(cboFormaPago);
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
			
			JLabel lblFechaVencimiento = new JLabel("fecha vencimiento");
			lblFechaVencimiento.setBounds(37, 127, 113, 30);
			panel_5.add(lblFechaVencimiento);
			lblFechaVencimiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			dtmFechaVencimineto = new JDateChooser();
			dtmFechaVencimineto.setBounds(188, 137, 109, 20);
			panel_5.add(dtmFechaVencimineto);
			
			dtmFechaVencimineto.setDateFormatString("yyyy/MM/dd");
			
			JPanel panel_7 = new JPanel();
			panel_7.setBackground(Color.decode(new clsArial().colorMenu));
			panel_7.setBounds(0, 0, 706, 30);
			panel_5.add(panel_7);
			panel_7.setLayout(null);
			
			JLabel lblOtrosDatos = new JLabel("Otros Datos");
			lblOtrosDatos.setForeground(Color.WHITE);
			lblOtrosDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblOtrosDatos.setBounds(34, 0, 117, 25);
			panel_7.add(lblOtrosDatos);
			
			JLabel lblCotizacion = new JLabel("Cotizacion");
			lblCotizacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCotizacion.setBounds(421, 58, 83, 14);
			panel_5.add(lblCotizacion);
			
			lblCoti = new JLabel("");
			lblCoti.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			lblCoti.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCoti.setBounds(499, 59, 83, 20);
			panel_5.add(lblCoti);
			
			JLabel lblBuscarCotizacion = new JLabel("");
			lblBuscarCotizacion.setOpaque(true);
			lblBuscarCotizacion.setBackground(Color.BLACK);
			lblBuscarCotizacion.setBounds(591, 59, 20, 20);
			panel_5.add(lblBuscarCotizacion);
		
	
	

	}
	ArrayList<DetalleVentas> carrito = new ArrayList<>();
	private JDateChooser dtmFechaVencimineto;

	private JButton btnAceptar;
	
	
	void grabar() {
		int ok;
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
		if(lblCoti.getText().isEmpty()) {
			ve.setNroCotizacion(0);
		}
		else {
			ve.setNroCotizacion(Integer.parseInt(lblCoti.getText()));
		}
		
		/*el numero de compra viene de la gestion ventas del metodo obtenerNumero()*/
		ve.setNro_ven(Integer.parseInt(numeroCompra));
		ve.setId_cli(id_cli);
		ve.setId_emp(id_usu);
		ve.setDoc_ven(tipo_comprovante);
		ve.setNumeroComprovante(numero_comprovante);
		ve.setFecha_vencimiento(dtmFechaVencimiento);
		ve.setFormaPago(formaPago);
		ve.setEstado("vigente");
		/*---------------------*/
		
		
		double importe=0;
		double total=0;
		/*para la tabla detalle*/
		for(int i=0;i<tblProducto.getRowCount();i++) {
			DetalleVentas deta=new DetalleVentas();
			
			deta.setId_prod(Integer.parseInt(tblProducto.getValueAt(i, 0).toString()));
			deta.setPrecioUnidad(Double.parseDouble(tblProducto.getValueAt(i, 3).toString()));
			deta.setCantxUnidad(Integer.parseInt(tblProducto.getValueAt(i, 2).toString()));
			deta.setDescuento(Double.parseDouble(tblProducto.getValueAt(i, 4).toString()));
			importe=(Double.parseDouble(tblProducto.getValueAt(i, 5).toString()));
			total+=importe;
			carrito.add(deta);
		}
		
		/*---------------------*/

		
		GestionVentas v=new GestionVentas();
	
		if(formaPago.equals("efectivo")) {
			ve.setEstado("finalizado");
			ok=v.realizaVenta(ve, carrito);
		/*para la tabla movimiento*/
		int codCaja=Integer.parseInt(FrmMenuPrincipal.lblCodCaja.getText().toString());
		double saldoTotal=Double.parseDouble(FrmMenuPrincipal.lblSaldo.getText());
		Movimiento m=new Movimiento();
		m.setComentario("nada por mientras");
		m.setTipo_movimiento("venta");
		System.out.println("el numero de compra es : "+numeroCompra);
		m.setNro_ven(Integer.parseInt(numeroCompra));
		m.setCod_regis_com(0);
		m.setEntrada(total);
		m.setIdUsu(id_usu+"");
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
		else {
			ok=v.realizaVenta(ve, carrito);
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
	private JLabel lblSale;
	private JTextField txtDescuento;
	private JLabel lblCoti;

	public double calcularTotal() {
		if(tot!=0) {
			tot=0;
			for(int i=0;i<tblProducto.getRowCount();i++) {
				
				imp=Double.parseDouble(tblProducto.getValueAt(i, 5).toString());
				tot+=imp;
				
			}
		}else {
			
		for(int i=0;i<tblProducto.getRowCount();i++) {
			
			imp=Double.parseDouble(tblProducto.getValueAt(i, 5).toString());
			tot+=imp;
			
		}
		
		}return tot;
		
	}
}
