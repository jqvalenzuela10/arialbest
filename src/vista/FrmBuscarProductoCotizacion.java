package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.chart.axis.StandardTickUnitSource;
import org.omg.CORBA.PUBLIC_MEMBER;

import mantenimientos.GestionClientes;
import mantenimientos.GestionCompra;
import mantenimientos.GestionProductos;
import model.Clientes;
import model.DetalleCompra;
import model.JDateChooserEditor;
import model.Producto;
import model.Render;
import utils.FormatoTablaMain;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmBuscarProductoCotizacion extends JDialog {
	private JTextField textField;
	private JTable tblProducto;

	

	
	public static JButton btnEliminar;
	/* listado productos */
	DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			FrmBuscarProductoCotizacion dialog = new FrmBuscarProductoCotizacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmBuscarProductoCotizacion() {
		/*agregar al carrito*/
		
		setModal(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				listar();
			}
		});

		/* agregar columnas de productos */
		model.addColumn("Codigo");
		
		model.addColumn("Descripcion");
		
		model.addColumn("Precio Compra");

		model.addColumn("Stock");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblProductos.setBounds(76, 23, 97, 28);
		getContentPane().add(lblProductos);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmBuscarProductoCotizacion.class.getResource("/iconos/Producto.png")));
		lblNewLabel.setBounds(20, 11, 46, 56);
		getContentPane().add(lblNewLabel);

		Panel panel = new Panel();
		panel.setBounds(0, 92, 687, 68);
		panel.setBackground(Color.decode("#2D363F"));
		getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField(10);

		textField.setToolTipText("");
		textField.setBackground(new Color(239, 244, 249));
		textField.setBounds(181, 29, 207, 25);
		panel.add(textField);

		JLabel label = new JLabel("");
		label.setBounds(138, 25, 38, 29);
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(32, 28, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		label.setIcon(ic);
		panel.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(140, 191, 388, 374);
		getContentPane().add(scrollPane);

		/*arraylist para agregar productos al carrito*/
		
	
		 
		tblProducto = new JTable();
	
		tblProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int fila = tblProducto.getSelectedRow();

				String codigo=tblProducto.getValueAt(fila,0).toString();
				String descripcion=tblProducto.getValueAt(fila, 1).toString();
				String precio=tblProducto.getValueAt(fila, 2).toString();
				
				JdialogCotizacion.lblCodigo.setText(codigo);
				JdialogCotizacion.lblDescripcion.setText(descripcion);
				JdialogCotizacion.lblPrecio.setText(precio);
				
				
				
				
				/*
				Object[] filas = new Object[6];

				filas[0] = tblProducto.getValueAt(fila, 0);
				filas[1] = tblProducto.getValueAt(fila, 1);
				filas[3] = tblProducto.getValueAt(fila, 2);
				
				
			
				
				--le envio el boton eliminar
				 IntVentasWindow.tblProducto.setDefaultRenderer(Object.class, new Render());
				 
				 
				 
				
				 
				btnEliminar = new JButton("eliminar");
			        ImageIcon delete = new ImageIcon(getClass().getResource("/img/eliminar.png"));
			    	Image i = delete.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
			    	Icon ic = new ImageIcon(i);
			    	btnEliminar.setIcon(ic);
			    	btnEliminar.setName("eliminar");
			
			    
				filas[5]=btnEliminar;
				
				IntVentasWindow.model.addRow(filas);
			*/

				

				

			
				

				
				
				
				
				dispose();
			}
		});
		FormatoTablaMain.formatoTabla(tblProducto);
		tblProducto.setModel(model);

		scrollPane.setViewportView(tblProducto);

		setBounds(100, 100, 703, 614);
		TableColumn col = tblProducto.getColumnModel().getColumn(0);
		col.setPreferredWidth(5);
		TableColumn col1 = tblProducto.getColumnModel().getColumn(3);
		col1.setPreferredWidth(5);
	}

	void listar() {
		GestionProductos gc = new GestionProductos();
		ArrayList<Producto> lista = gc.listado();
		model.getDataVector().removeAllElements();

		for (Producto cl : lista) {
			Object datos[] = { cl.getCodigo(),cl.getDescripcion(),cl.getPrecioProCom(),cl.getStock() };

			model.addRow(datos);

		}

	}
}
