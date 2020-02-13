package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;

import mantenimientos.GestionProductos;
import model.HintTextField;
import model.Producto;
import model.Tabla;
import model.Tabla_Reutilizable;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JdialogEditarProducto extends JDialog {
	public static JTextField textField;
	public static JTextField txtPrecioVenta;
	public static HintTextField txtCodigoBarra;
	public static HintTextField txtDescripcion;
	public static JLabel btnGuardar;
	public static JRadioButton rdbLote;
	public static HintTextField txtCodigoSanitario;
	public static HintTextField txtCodigoSunat;
	public static  HintTextField txtPrecioCompra;
	public static JComboBox cboUnidadCompra;
	public static JComboBox cboUnidadVenta;
	public static HintTextField txtFactor;
	public static HintTextField txtCategoria;
	public static HintTextField txtMarca;
	public static HintTextField txtStock;
	public static JLabel lblCodigo;
	public static int numeroProducto;
	public static String nombrePro;
	public static int codProducto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdialogEditarProducto dialog = new JdialogEditarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdialogEditarProducto() {
		setModal(true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblCodigoBarra = new JLabel("Codigo Barra");
		lblCodigoBarra.setForeground(new Color(15, 149, 236));
		lblCodigoBarra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCodigoBarra.setBounds(10, 40, 143, 14);
		getContentPane().add(lblCodigoBarra);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBackground(new Color(247, 249, 249));
		panel.setBounds(10, 57, 193, 40);
		getContentPane().add(panel);
		
		txtCodigoBarra = new HintTextField("Barra");
		txtCodigoBarra.setColumns(10);
		txtCodigoBarra.setBorder(null);
		txtCodigoBarra.setBackground(new Color(247, 249, 249));
		txtCodigoBarra.setBounds(59, 4, 124, 32);
		panel.add(txtCodigoBarra);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(3, 4, 42, 32);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(48, 0, 1, 49);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("Descripcion");
		label_2.setForeground(new Color(15, 149, 236));
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_2.setBounds(10, 125, 143, 14);
		getContentPane().add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_2.setBackground(new Color(247, 249, 249));
		panel_2.setBounds(10, 143, 440, 40);
		getContentPane().add(panel_2);
		
		txtDescripcion = new HintTextField("Descripcion");
		txtDescripcion.setColumns(10);
		txtDescripcion.setBorder(null);
		txtDescripcion.setBackground(new Color(247, 249, 249));
		txtDescripcion.setBounds(59, 4, 371, 32);
		panel_2.add(txtDescripcion);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(3, 4, 42, 32);
		panel_2.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(48, 0, 1, 49);
		panel_2.add(panel_3);
		
		JLabel label_4 = new JLabel("Categoria");
		label_4.setForeground(new Color(15, 149, 236));
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_4.setBounds(666, 38, 143, 14);
		getContentPane().add(label_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_4.setBackground(new Color(247, 249, 249));
		panel_4.setBounds(666, 57, 193, 40);
		getContentPane().add(panel_4);
		
		txtCategoria = new HintTextField("Categoria");
		txtCategoria.setColumns(10);
		txtCategoria.setBorder(null);
		txtCategoria.setBackground(new Color(247, 249, 249));
		txtCategoria.setBounds(59, 4, 124, 32);
		panel_4.add(txtCategoria);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(3, 4, 42, 32);
		panel_4.add(label_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(48, 0, 1, 49);
		panel_4.add(panel_5);
		
		JLabel label_6 = new JLabel("Precio Compra");
		label_6.setForeground(new Color(15, 149, 236));
		label_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_6.setBounds(10, 282, 143, 14);
		getContentPane().add(label_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_6.setBackground(new Color(247, 249, 249));
		panel_6.setBounds(10, 301, 193, 40);
		getContentPane().add(panel_6);
		
		txtPrecioCompra = new HintTextField("");
		txtPrecioCompra.setColumns(10);
		txtPrecioCompra.setBorder(null);
		txtPrecioCompra.setBackground(new Color(247, 249, 249));
		txtPrecioCompra.setBounds(59, 4, 124, 32);
		panel_6.add(txtPrecioCompra);
		
		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(3, 4, 42, 32);
		panel_6.add(label_7);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(48, 0, 1, 49);
		panel_6.add(panel_7);
		
		JLabel lblEditarProducto = new JLabel("Editar Producto");
		lblEditarProducto.setForeground(Color.BLACK);
		lblEditarProducto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEditarProducto.setBounds(10, 0, 143, 14);
		getContentPane().add(lblEditarProducto);
		
		JLabel label_9 = new JLabel("Marca");
		label_9.setForeground(new Color(15, 149, 236));
		label_9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_9.setBounds(327, 40, 143, 14);
		getContentPane().add(label_9);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_8.setBackground(new Color(247, 249, 249));
		panel_8.setBounds(327, 57, 193, 40);
		getContentPane().add(panel_8);
		
		txtMarca = new HintTextField("Marca");
		txtMarca.setColumns(10);
		txtMarca.setBorder(null);
		txtMarca.setBackground(new Color(247, 249, 249));
		txtMarca.setBounds(59, 4, 124, 32);
		panel_8.add(txtMarca);
		
		JLabel label_10 = new JLabel("");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(3, 4, 42, 32);
		panel_8.add(label_10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setBounds(48, 0, 1, 49);
		panel_8.add(panel_9);
		
		JLabel label_11 = new JLabel("Precio Compra Sin Impuestos");
		label_11.setForeground(new Color(15, 149, 236));
		label_11.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_11.setBounds(257, 282, 214, 14);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("% Utilidad");
		label_12.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_12.setBounds(11, 421, 82, 32);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("Precio Venta");
		label_13.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_13.setBounds(10, 476, 113, 29);
		getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("Precio Venta Neto ");
		label_14.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_14.setBounds(10, 529, 143, 32);
		getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("Precio1");
		label_15.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_15.setBounds(159, 385, 70, 14);
		getContentPane().add(label_15);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(247, 249, 249));
		textField.setBounds(159, 424, 198, 32);
		getContentPane().add(textField);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBackground(new Color(247, 249, 249));
		txtPrecioVenta.setBounds(159, 529, 198, 32);
		getContentPane().add(txtPrecioVenta);
		
		btnGuardar = new JLabel("    Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int stock=Integer.parseInt(txtStock.getText());
				int codProd=Integer.parseInt(lblCodigo.getText());
				String descripcion=txtDescripcion.getText();
				if(stock>0) {
					 numeroProducto=stock;
					nombrePro=descripcion;
					codProducto=codProd;
					JdialogAgregarLotes1 j=new JdialogAgregarLotes1();
					j.setVisible(true);
					j.setLocationRelativeTo(null);
					
					
				}
				else {
					
				actualizar();
				Tabla_Reutilizable.model.setRowCount(0);
				
				ArrayList<Producto> listado =new GestionProductos().listado();
				Tabla_Reutilizable.listar(listado);
				dispose();

				}
			}
		});
		btnGuardar.setOpaque(true);
		btnGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnGuardar.setBorder(new LineBorder(Color.decode("#28a745")));
		btnGuardar.setBackground(new Color(0, 84, 164));
		btnGuardar.setBounds(450, 590, 143, 40);
		getContentPane().add(btnGuardar);
		
		JLabel label_17 = new JLabel("   Cancelar");
		label_17.setOpaque(true);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.BLACK);
		label_17.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		label_17.setBorder(new LineBorder(Color.decode("#28a745")));
		label_17.setBackground(SystemColor.scrollbar);
		label_17.setBounds(257, 590, 143, 40);
		getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("Precios de Venta");
		label_18.setForeground(Color.BLACK);
		label_18.setFont(new Font("Segoe UI", Font.BOLD, 15));
		label_18.setBounds(10, 247, 143, 14);
		getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel("Unidad Compra");
		label_19.setForeground(new Color(15, 149, 236));
		label_19.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_19.setBounds(497, 125, 113, 14);
		getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("Unidad Venta");
		label_20.setForeground(new Color(15, 149, 236));
		label_20.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_20.setBounds(666, 125, 113, 14);
		getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel("Factor");
		label_21.setForeground(new Color(15, 149, 236));
		label_21.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_21.setBounds(835, 127, 82, 14);
		getContentPane().add(label_21);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_10.setBackground(new Color(247, 249, 249));
		panel_10.setBounds(831, 143, 92, 40);
		getContentPane().add(panel_10);
		
		txtFactor = new HintTextField("");
		txtFactor.setColumns(10);
		txtFactor.setBorder(null);
		txtFactor.setBackground(new Color(247, 249, 249));
		txtFactor.setBounds(10, 4, 72, 32);
		panel_10.add(txtFactor);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(489, 247, 5, 314);
		getContentPane().add(panel_11);
		
		JLabel label_22 = new JLabel("Datos Adicionales");
		label_22.setForeground(Color.BLACK);
		label_22.setFont(new Font("Segoe UI", Font.BOLD, 15));
		label_22.setBounds(511, 250, 143, 14);
		getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel("Codigo Sanitario");
		label_23.setForeground(new Color(15, 149, 236));
		label_23.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_23.setBounds(509, 282, 143, 14);
		getContentPane().add(label_23);
		
		JLabel label_24 = new JLabel("Codigo Sunat");
		label_24.setForeground(new Color(15, 149, 236));
		label_24.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_24.setBounds(741, 282, 143, 14);
		getContentPane().add(label_24);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_12.setBackground(new Color(247, 249, 249));
		panel_12.setBounds(509, 301, 193, 40);
		getContentPane().add(panel_12);
		
		txtCodigoSanitario = new HintTextField("");
		txtCodigoSanitario.setColumns(10);
		txtCodigoSanitario.setBorder(null);
		txtCodigoSanitario.setBackground(new Color(247, 249, 249));
		txtCodigoSanitario.setBounds(59, 4, 124, 32);
		panel_12.add(txtCodigoSanitario);
		
		JLabel label_25 = new JLabel("");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setBounds(3, 4, 42, 32);
		panel_12.add(label_25);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.LIGHT_GRAY);
		panel_13.setBounds(48, 0, 1, 49);
		panel_12.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_14.setBackground(new Color(247, 249, 249));
		panel_14.setBounds(741, 301, 193, 40);
		getContentPane().add(panel_14);
		
		txtCodigoSunat = new HintTextField("");
		txtCodigoSunat.setColumns(10);
		txtCodigoSunat.setBorder(null);
		txtCodigoSunat.setBackground(new Color(247, 249, 249));
		txtCodigoSunat.setBounds(59, 4, 124, 32);
		panel_14.add(txtCodigoSunat);
		
		JLabel label_26 = new JLabel("");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setBounds(3, 4, 42, 32);
		panel_14.add(label_26);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_15.setBounds(48, 0, 1, 49);
		panel_14.add(panel_15);
		
		rdbLote = new JRadioButton("Lote");
		rdbLote.setBackground(Color.WHITE);
		rdbLote.setBounds(511, 406, 83, 37);
		getContentPane().add(rdbLote);
		
		JLabel label_27 = new JLabel("Lote?");
		label_27.setForeground(new Color(15, 149, 236));
		label_27.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_27.setBounds(514, 392, 92, 14);
		getContentPane().add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(257, 310, 193, 31);
		getContentPane().add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setBounds(159, 477, 198, 32);
		getContentPane().add(label_29);
		
		cboUnidadCompra = new JComboBox();
		cboUnidadCompra.setModel(new DefaultComboBoxModel(new String[] {"Selecciona", "Caja", "Unidad"}));
		cboUnidadCompra.setBounds(497, 146, 96, 37);
		getContentPane().add(cboUnidadCompra);
		
		cboUnidadVenta = new JComboBox();
		cboUnidadVenta.setModel(new DefaultComboBoxModel(new String[] {"Selecciona", "Caja", "Unidad"}));
		cboUnidadVenta.setBounds(666, 146, 96, 37);
		getContentPane().add(cboUnidadVenta);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(new Color(15, 149, 236));
		lblStock.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblStock.setBounds(511, 465, 143, 14);
		getContentPane().add(lblStock);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_16.setBackground(new Color(247, 249, 249));
		panel_16.setBounds(509, 502, 193, 40);
		getContentPane().add(panel_16);
		
		txtStock = new HintTextField("");
		txtStock.setColumns(10);
		txtStock.setBorder(null);
		txtStock.setBackground(new Color(247, 249, 249));
		txtStock.setBounds(59, 4, 124, 32);
		panel_16.add(txtStock);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(3, 4, 42, 32);
		panel_16.add(label);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.LIGHT_GRAY);
		panel_17.setBounds(48, 0, 1, 49);
		panel_16.add(panel_17);
		
		lblCodigo = new JLabel("");
		lblCodigo.setBounds(931, 11, 21, 14);
		getContentPane().add(lblCodigo);
		setBounds(100, 100, 978, 717);
	}
	public static void actualizar() {
		
		
		
		int codBarra,factor,codigoSunat,stock,idProd;
		String descripcion,marca,unidadCompra,unidadVenta,categoria,codRegistroSanitario;
		double precio_compra,precio_venta;
		boolean lote;
		
		codBarra=Integer.parseInt(txtCodigoBarra.getText());
		descripcion=txtDescripcion.getText();
		marca=txtMarca.getText();
		precio_compra=Double.parseDouble(txtPrecioCompra.getText());
		precio_venta=Double.parseDouble(txtPrecioVenta.getText());
		unidadCompra=cboUnidadCompra.getSelectedItem().toString();
		unidadVenta=cboUnidadVenta.getSelectedItem().toString();
		factor=Integer.parseInt(txtFactor.getText());
		categoria=txtCategoria.getText();
		codRegistroSanitario=txtCodigoSanitario.getText();
		codigoSunat=Integer.parseInt(txtCodigoSunat.getText());
		Boolean valor=rdbLote.isSelected()?true:false;
		lote=valor;
		System.out.println("el lote1 es : "+lote);
		stock=Integer.parseInt(txtStock.getText());
		idProd=Integer.parseInt(lblCodigo.getText());
		
		
		Producto reg=new Producto();
		reg.setCodbarra(codBarra);
		reg.setDescripcion(descripcion);
		reg.setMarca(marca);
		reg.setPrecioProCom(precio_compra);
		reg.setPrecioProVen(precio_venta);
		reg.setUnidadCompra(unidadCompra);
		reg.setUnidadVenta(unidadVenta);
		reg.setFactor(factor);
		reg.setNomCat(categoria);
		reg.setCodregistrosani(codRegistroSanitario);
		reg.setCodSunat(codigoSunat);
		reg.setLote(lote);
		reg.setStock(stock);
		reg.setCodigo(idProd);
		
		int ok=new GestionProductos().actualizar(reg);
		
		if(ok!=0) {
			JOptionPane.showMessageDialog(null, "actualizacion exitosa");
		}
		else {
			JOptionPane.showMessageDialog(null, " error al actualizar");
		}
		
	}
}
