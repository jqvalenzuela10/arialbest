package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionCotizacion;
import mantenimientos.GestionVentas;
import model.Cotizacion;
import model.DetalleCotizacion;
import model.DetalleVentas;
import model.Render;
import utils.FormatoTablaMain;
import utils.clsArial;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JdialogCotizacion extends JDialog {
	public static JLabel lblCodigoCli;
	private JTextField txtCantidad;
	private JTextField txtDescuento;
	public static JLabel lblCodigo;
	public static JLabel lblPrecio;
	public static JLabel lblDescripcion;
	private JDateChooser dtmFechaVencimiento;
	private JTable tblCotizacion;
	private JLabel lblNroCotizacion;
	public String numeroCotizacion;
	public int fila;
	public int numero;
	public static JTextField txtCliente;
	DefaultTableModel model=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdialogCotizacion dialog = new JdialogCotizacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdialogCotizacion() {
	
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1626, 947);
		getContentPane().setLayout(null);
		
		
		model.addColumn("codigo");
		model.addColumn("descripcion");
		model.addColumn("cantidad");
		model.addColumn("precio");
		model.addColumn("descuento");
		model.addColumn("importe");
		model.addColumn("eliminar");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(41, 37, 1317, 775);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(45, 54, 63));
		panel_1.setBounds(1, 0, 1316, 66);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_2.setBounds(805, 19, 91, 29);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_3.setBounds(916, 19, 46, 29);
		panel_1.add(label_3);
		
		String numeroCotizacion;
		GestionCotizacion g=new GestionCotizacion();
		 numero=g.ObtenerNumero();
		numeroCotizacion ="N°0000"+numero;
		
		
		lblNroCotizacion = new JLabel(numeroCotizacion);
		lblNroCotizacion.setForeground(Color.WHITE);
		lblNroCotizacion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNroCotizacion.setBounds(1209, 28, 78, 14);
		panel_1.add(lblNroCotizacion);
		
		label = new JLabel("");
		label.setBounds(157, 11, 111, 44);
		clsArial c=new clsArial();
		c.modifiedIcon("/iconos/cotizacion.png", 80, 50, label);
		
		panel_1.add(label);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(148, 121, 30, 20);
		panel.add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 277, 706, 285);
		panel.add(scrollPane);
		
		tblCotizacion = new JTable();
		tblCotizacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				 int column = tblCotizacion.getColumnModel().getColumnIndexAtX(e.getX());
			        int row = e.getY()/tblCotizacion.getRowHeight();
			        
			        if(row < tblCotizacion.getRowCount() && row >= 0 && column < tblCotizacion.getColumnCount() && column >= 0){
			            Object value = tblCotizacion.getValueAt(row, column);
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
							 
							 
		    				String codigo=tblCotizacion.getValueAt(fila, 0).toString();
		    				String descripcion=tblCotizacion.getValueAt(fila, 1).toString();
		    				String cantidad=tblCotizacion.getValueAt(fila, 2).toString();
		    				String precio=tblCotizacion.getValueAt(fila, 3).toString();
		    				String descuento=tblCotizacion.getValueAt(fila, 4).toString();
		    				lblCodigo.setText(codigo);
		    				lblDescripcion.setText(descripcion);
		    				txtCantidad.setText(cantidad);
		    				lblPrecio.setText(precio);
		    				txtDescuento.setText(descuento);
		    			}
			        }
			    
			
				
			 }
			
			
		});
		tblCotizacion.setModel(model);
		scrollPane.setViewportView(tblCotizacion);
		
		FormatoTablaMain.formatoTabla(tblCotizacion);
		
		JLabel label_12 = new JLabel("fecha vencimiento");
		label_12.setBounds(894, 111, 113, 30);
		panel.add(label_12);
		
		dtmFechaVencimiento = new JDateChooser();
		dtmFechaVencimiento.setDateFormatString("yyyy/MM/dd");
		dtmFechaVencimiento.setBounds(1045, 121, 109, 20);
		panel.add(dtmFechaVencimiento);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(158, 277, 293, 285);
		panel.add(panel_3);
		
		JLabel label_13 = new JLabel("Codigo");
		label_13.setBounds(10, 57, 46, 14);
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("Descripcion");
		label_14.setBounds(10, 105, 65, 14);
		panel_3.add(label_14);
		
		JLabel label_15 = new JLabel("Cantidad");
		label_15.setBounds(10, 184, 46, 14);
		panel_3.add(label_15);
		
		JLabel label_16 = new JLabel("Precio");
		label_16.setBounds(10, 143, 46, 14);
		panel_3.add(label_16);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(81, 181, 86, 20);
		panel_3.add(txtCantidad);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblCodigo.setBounds(87, 57, 80, 14);
		panel_3.add(lblCodigo);
		
		lblDescripcion = new JLabel("");
		lblDescripcion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblDescripcion.setBounds(85, 105, 80, 14);
		panel_3.add(lblDescripcion);
		
		lblPrecio = new JLabel("");
		lblPrecio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblPrecio.setBounds(87, 143, 80, 14);
		panel_3.add(lblPrecio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				if(lblCodigo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "busque un producto");
				}
				
				else if(txtCantidad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ingrese la cantidad");
				}else {
					
					int fila=validar();
					
					if(fila!=-1) {
						tblCotizacion.setValueAt(txtCantidad.getText(), fila, 2);
						int cantidad=Integer.parseInt(txtCantidad.getText());
						double precio=Double.parseDouble(lblPrecio.getText());
						double descuento=Double.parseDouble(txtDescuento.getText());
						tblCotizacion.setValueAt( (precio*cantidad)-(descuento*((precio*cantidad)/100)), fila, 5);
						
						double tota=calcularTotal();
						lblTotal.setText(tota+"");
						
					}
					else {
						
					String codigo=lblCodigo.getText();
					String descripcion=lblDescripcion.getText();
					double precio=Double.parseDouble(lblPrecio.getText());
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
				
				 tblCotizacion.setDefaultRenderer(Object.class, new Render());
				 
				 
				 
				
				 
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
				
				lblCodigo.setText("");
				lblDescripcion.setText("");
				lblPrecio.setText("");
				txtCantidad.setText("");
txtDescuento.setText("");

				}
					
				}

				
				
				
			}
		});
		btnAceptar.setBounds(10, 251, 89, 23);
		panel_3.add(btnAceptar);
		
		JLabel label_20 = new JLabel("Descuento");
		label_20.setBounds(10, 222, 65, 14);
		panel_3.add(label_20);
		
		txtDescuento = new JTextField();
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(81, 220, 86, 20);
		panel_3.add(txtDescuento);
		
		JLabel label_21 = new JLabel("%");
		label_21.setBounds(177, 222, 32, 18);
		panel_3.add(label_21);
		
		JPanel btnAgregar = new JPanel();
		btnAgregar.setBounds(46, 11, 121, 29);
		panel_3.add(btnAgregar);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(10, 16, 30, 30);
		panel_3.add(label_8);
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmBuscarProductoCotizacion frm=new FrmBuscarProductoCotizacion();
				frm.setVisible(true);
				frm.setLocationRelativeTo(null);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(158, 77, 284, 187);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmBuscarLClienteCotizacion f=new FrmBuscarLClienteCotizacion();
				f.setVisible(true);
				f.setLocationRelativeTo(null);
			}
		});
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(222, 39, 20, 20);
		panel_2.add(label_1);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(10, 39, 199, 20);
		panel_2.add(txtCliente);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(45, 54, 63));
		panel_4.setBounds(0, 0, 285, 28);
		panel_2.add(panel_4);
		
		JLabel label_4 = new JLabel("Datos del Cliente");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(10, 0, 117, 25);
		panel_4.add(label_4);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(125, 5, 30, 20);
		panel_4.add(label_10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(45, 54, 63));
		panel_5.setBounds(1, 737, 1316, 38);
		panel.add(panel_5);
		
		JLabel label_7 = new JLabel("Total   S/");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(1055, 11, 54, 20);
		panel_5.add(label_7);
		
		lblTotal = new JLabel("0.00");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(1119, 11, 71, 20);
		panel_5.add(lblTotal);
		
		JButton button = new JButton("Grabar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grabar();
				dispose();
			}
		});
		button.setBounds(1217, 11, 89, 23);
		panel_5.add(button);
		
		lblCodigoCli = new JLabel("");
		lblCodigoCli.setBounds(479, 135, 35, 14);
		panel.add(lblCodigoCli);
	}

	ArrayList<DetalleCotizacion> carrito=new ArrayList<>();
	void grabar() {
		
		/*la tabla cotizacion*/
		int idUsu,idCli;
		String fechaVen;
	
		double total;
		
		idUsu=FrmLogin.e.getId_emp();
		total=Double.parseDouble(lblTotal.getText());
		idCli=Integer.parseInt(lblCodigoCli.getText());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		fechaVen=sdf.format(dtmFechaVencimiento.getDate());
		
		Cotizacion c=new Cotizacion();
		c.setNroCoti(numero);
		c.setIdUsu(idUsu);
		c.setTotal(total);
		c.setIdCli(idCli);
		c.setFechaVenci(fechaVen);
		
		/*ahora el detalle*/
		
		double importe=0;
		double totalito=0;
		/*para la tabla detalle*/
		for(int i=0;i<tblCotizacion.getRowCount();i++) {
			DetalleCotizacion deta=new DetalleCotizacion();
			
			deta.setIdPro(Integer.parseInt(tblCotizacion.getValueAt(i, 0).toString()));
			deta.setCantidad(Integer.parseInt(tblCotizacion.getValueAt(i, 2).toString()));
			deta.setPrecio(Double.parseDouble(tblCotizacion.getValueAt(i, 3).toString()));
			deta.setDescuento(Double.parseDouble(tblCotizacion.getValueAt(i, 4).toString()));
			
		 importe=Double.parseDouble(tblCotizacion.getValueAt(i, 5).toString());
			total+=importe;
			carrito.add(deta);
		}
		/*----------*/
		
		int ok=new GestionCotizacion().agregar(c, carrito);
		
		if(ok!=0) {
			JOptionPane.showConfirmDialog(null, "registro exitoso");
		}
		else {
			JOptionPane.showMessageDialog(null, "error al registrar la cotizacion");
		}
	}
	
	public int validar() {
		int fila=-1;
		
		for(int i=0;i<tblCotizacion.getRowCount();i++) {
		String codigo=tblCotizacion.getValueAt(i, 0).toString();
		if(lblCodigo.getText().equals(codigo)) {
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
	
	private JLabel lblTotal;
	private JLabel label;
	
	public double calcularTotal() {
		if(tot!=0) {
			tot=0;
			for(int i=0;i<tblCotizacion.getRowCount();i++) {
				
				imp=Double.parseDouble(tblCotizacion.getValueAt(i, 5).toString());
				tot+=imp;
				
			}
		}else {
			
		for(int i=0;i<tblCotizacion.getRowCount();i++) {
			
			imp=Double.parseDouble(tblCotizacion.getValueAt(i, 5).toString());
			tot+=imp;
			
		}
		
		}return tot;
		
	}
}
