package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import mantenimientos.GestionProductos;
import model.Categoria;
import model.HintTextField;
import model.Producto;
import model.Tabla_Reutilizable;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class IntRegisProduDatos extends JInternalFrame {
	private JTextField txtUltilidad;
	private JTextField txtPrecioVentaNeto;
	private JLabel label_17;
	private HintTextField txtCodigoBarra;
	private HintTextField txtMarca;
	private HintTextField txtDescripcion;
	private HintTextField txtCategoria;
	private HintTextField txtFactor;
	private HintTextField txtCodigoSunat;
	private HintTextField txtCodigoSanitario;
	private JRadioButton rdbLote;
	private HintTextField txtPrecioCompra;
	private JLabel lblPrecioSinImpuesto;
	private JLabel lblPrecionVenta;
	private JComboBox cboUnidadCompra;
	private JComboBox cboUnidadVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntRegisProduDatos frame = new IntRegisProduDatos();
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
	public IntRegisProduDatos() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Clave");
		label.setForeground(new Color(15, 149, 236));
		label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label.setBounds(10, 51, 143, 14);
		getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBackground(new Color(247, 249, 249));
		panel.setBounds(10, 68, 193, 40);
		getContentPane().add(panel);
		
		txtCodigoBarra = new HintTextField("Clave");
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
		label_2.setBounds(10, 136, 143, 14);
		getContentPane().add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_2.setBackground(new Color(247, 249, 249));
		panel_2.setBounds(10, 154, 440, 40);
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
		label_4.setBounds(666, 49, 143, 14);
		getContentPane().add(label_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_4.setBackground(new Color(247, 249, 249));
		panel_4.setBounds(666, 68, 193, 40);
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
		label_6.setBounds(10, 293, 143, 14);
		getContentPane().add(label_6);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_6.setBackground(new Color(247, 249, 249));
		panel_6.setBounds(10, 312, 193, 40);
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
		
		JLabel label_8 = new JLabel("Datos Producto");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Segoe UI", Font.BOLD, 15));
		label_8.setBounds(10, 11, 143, 14);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Marca");
		label_9.setForeground(new Color(15, 149, 236));
		label_9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label_9.setBounds(327, 51, 143, 14);
		getContentPane().add(label_9);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_8.setBackground(new Color(247, 249, 249));
		panel_8.setBounds(327, 68, 193, 40);
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
		label_11.setBounds(257, 293, 214, 14);
		getContentPane().add(label_11);
		
		JLabel label_13 = new JLabel("% Utilidad");
		label_13.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_13.setBounds(11, 432, 82, 32);
		getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("Precio Venta");
		label_14.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_14.setBounds(10, 487, 113, 29);
		getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("Precio Venta Neto ");
		label_15.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_15.setBounds(10, 540, 143, 32);
		getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("Precio1");
		label_16.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_16.setBounds(159, 396, 70, 14);
		getContentPane().add(label_16);
		
		txtUltilidad = new JTextField();
		txtUltilidad.setColumns(10);
		txtUltilidad.setBackground(new Color(247, 249, 249));
		txtUltilidad.setBounds(159, 435, 198, 32);
		getContentPane().add(txtUltilidad);
		
		txtPrecioVentaNeto = new JTextField();
		txtPrecioVentaNeto.setColumns(10);
		txtPrecioVentaNeto.setBackground(new Color(247, 249, 249));
		txtPrecioVentaNeto.setBounds(159, 540, 198, 32);
		getContentPane().add(txtPrecioVentaNeto);
		
		label_17 = new JLabel("    Guardar");
		label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				registrar();
				
Tabla_Reutilizable.model.setRowCount(0);
				
				ArrayList<Producto> listado =new GestionProductos().listado();
				Tabla_Reutilizable.listar(listado);
				dispose();
				
			}
		});
		label_17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_17.setOpaque(true);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		label_17.setBorder(new LineBorder(Color.decode("#28a745")));
		label_17.setBackground(new Color(0, 84, 164));
		label_17.setBounds(450, 601, 143, 40);
		getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("   Cancelar");
		label_18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_18.setOpaque(true);
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.BLACK);
		label_18.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		label_18.setBorder(new LineBorder(Color.decode("#28a745")));
		label_18.setBackground(SystemColor.scrollbar);
		label_18.setBounds(257, 601, 143, 40);
		getContentPane().add(label_18);
		
		JLabel lblPreciosDeVenta = new JLabel("Precios de Venta");
		lblPreciosDeVenta.setForeground(Color.BLACK);
		lblPreciosDeVenta.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPreciosDeVenta.setBounds(10, 258, 143, 14);
		getContentPane().add(lblPreciosDeVenta);
		
		JLabel lblUnidadCompra = new JLabel("Unidad Compra");
		lblUnidadCompra.setForeground(new Color(15, 149, 236));
		lblUnidadCompra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblUnidadCompra.setBounds(497, 136, 113, 14);
		getContentPane().add(lblUnidadCompra);
		
		JLabel lblUnidadVenta = new JLabel("Unidad Venta");
		lblUnidadVenta.setForeground(new Color(15, 149, 236));
		lblUnidadVenta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblUnidadVenta.setBounds(666, 136, 113, 14);
		getContentPane().add(lblUnidadVenta);
		
		JLabel lblFactor = new JLabel("Factor");
		lblFactor.setForeground(new Color(15, 149, 236));
		lblFactor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblFactor.setBounds(835, 138, 82, 14);
		getContentPane().add(lblFactor);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_16.setBackground(new Color(247, 249, 249));
		panel_16.setBounds(831, 154, 92, 40);
		getContentPane().add(panel_16);
		
		txtFactor = new HintTextField("");
		txtFactor.setColumns(10);
		txtFactor.setBorder(null);
		txtFactor.setBackground(new Color(247, 249, 249));
		txtFactor.setBounds(10, 4, 72, 32);
		panel_16.add(txtFactor);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(489, 258, 5, 314);
		getContentPane().add(panel_13);
		
		JLabel lblDatosAdicionales = new JLabel("Datos Adicionales");
		lblDatosAdicionales.setForeground(Color.BLACK);
		lblDatosAdicionales.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDatosAdicionales.setBounds(511, 261, 143, 14);
		getContentPane().add(lblDatosAdicionales);
		
		JLabel lblCodigoSanitario = new JLabel("Codigo Sanitario");
		lblCodigoSanitario.setForeground(new Color(15, 149, 236));
		lblCodigoSanitario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCodigoSanitario.setBounds(509, 293, 143, 14);
		getContentPane().add(lblCodigoSanitario);
		
		JLabel lblCodigoSunat = new JLabel("Codigo Sunat");
		lblCodigoSunat.setForeground(new Color(15, 149, 236));
		lblCodigoSunat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCodigoSunat.setBounds(741, 293, 143, 14);
		getContentPane().add(lblCodigoSunat);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_15.setBackground(new Color(247, 249, 249));
		panel_15.setBounds(509, 312, 193, 40);
		getContentPane().add(panel_15);
		
		txtCodigoSanitario = new HintTextField("");
		txtCodigoSanitario.setColumns(10);
		txtCodigoSanitario.setBorder(null);
		txtCodigoSanitario.setBackground(new Color(247, 249, 249));
		txtCodigoSanitario.setBounds(59, 4, 124, 32);
		panel_15.add(txtCodigoSanitario);
		
		JLabel label_19 = new JLabel("");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(3, 4, 42, 32);
		panel_15.add(label_19);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.LIGHT_GRAY);
		panel_17.setBounds(48, 0, 1, 49);
		panel_15.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_18.setBackground(new Color(247, 249, 249));
		panel_18.setBounds(741, 312, 193, 40);
		getContentPane().add(panel_18);
		
		txtCodigoSunat = new HintTextField("");
		txtCodigoSunat.setColumns(10);
		txtCodigoSunat.setBorder(null);
		txtCodigoSunat.setBackground(new Color(247, 249, 249));
		txtCodigoSunat.setBounds(59, 4, 124, 32);
		panel_18.add(txtCodigoSunat);
		
		JLabel label_20 = new JLabel("");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(3, 4, 42, 32);
		panel_18.add(label_20);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.LIGHT_GRAY);
		panel_19.setBounds(48, 0, 1, 49);
		panel_18.add(panel_19);
		
		rdbLote = new JRadioButton("Lote");
		rdbLote.setBackground(Color.WHITE);
		rdbLote.setBounds(511, 417, 83, 37);
		getContentPane().add(rdbLote);
		
		JLabel lblLote = new JLabel("Lote?");
		lblLote.setForeground(new Color(15, 149, 236));
		lblLote.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblLote.setBounds(514, 403, 92, 14);
		getContentPane().add(lblLote);
		
		lblPrecioSinImpuesto = new JLabel("");
		lblPrecioSinImpuesto.setBounds(257, 321, 193, 31);
		getContentPane().add(lblPrecioSinImpuesto);
		
		lblPrecionVenta = new JLabel("");
		lblPrecionVenta.setBounds(159, 488, 198, 32);
		getContentPane().add(lblPrecionVenta);
		
		cboUnidadCompra = new JComboBox();
		cboUnidadCompra.setModel(new DefaultComboBoxModel(new String[] {"Selecciona", "Caja", "Unidad"}));
		cboUnidadCompra.setBounds(497, 157, 96, 37);
		getContentPane().add(cboUnidadCompra);
		
		cboUnidadVenta = new JComboBox();
		cboUnidadVenta.setModel(new DefaultComboBoxModel(new String[] {"Selecciona", "Caja", "Unidad"}));
		cboUnidadVenta.setBounds(666, 157, 96, 37);
		getContentPane().add(cboUnidadVenta);
		setBounds(100, 100, 971, 705);

	}
	
	
	void registrar() {
		
		 int codigo,codbarra,factor,stock;
		 String descripcion,marca,unidadCompra,unidadVenta,codregistrosani,nomcat;
		 double precioProCom,precioProVen;
		 boolean lote;
		 int codSunat;
		
		 codbarra=Integer.parseInt(txtCodigoBarra.getText());
		 
		 descripcion=txtDescripcion.getText();
		 
		 marca=txtMarca.getText();
		 
		 precioProCom=Double.parseDouble(txtPrecioCompra.getText());
		 
		 precioProVen=Double.parseDouble(txtPrecioVentaNeto.getText());
		 
		 unidadCompra=(String)cboUnidadCompra.getSelectedItem();
		 
		 unidadVenta=(String)cboUnidadVenta.getSelectedItem();
		
		 factor=Integer.parseInt(txtFactor.getText());
		 
		 nomcat=txtCategoria.getText();
		 
		 codregistrosani=txtCodigoSanitario.getText();
		 
		 codSunat=Integer.parseInt(txtCodigoSunat.getText());
		 Boolean valor=rdbLote.isSelected()?true:false;
		 
		 lote=valor;
		 System.out.println("el lote en registrar es : "+lote);
		 Producto p=new Producto();
		 p.setCodbarra(codbarra);
		 p.setDescripcion(descripcion);
		 p.setMarca(marca);
		 p.setPrecioProCom(precioProCom);
		 p.setPrecioProVen(precioProVen);
		 p.setUnidadCompra(unidadCompra);
		 p.setUnidadVenta(unidadVenta);
		 p.setFactor(factor);
		 p.setNomCat(nomcat);
		 p.setCodregistrosani(codregistrosani);
		 p.setCodSunat(codSunat);
		 p.setLote(lote);
		 
		int ok=new GestionProductos().Agregar(p);
	
		if(ok!=0) {
			JOptionPane.showMessageDialog(null, "registro exitoso");
			
		}
		else {
			JOptionPane.showMessageDialog(null, "no se pudo registrar");
		}
	}
}
