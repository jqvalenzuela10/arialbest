package vista;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import mantenimientos.GestionClientes;
import mantenimientos.GestionEmpledos;
import mantenimientos.GestionProductos;
import mantenimientos.GestionProveedor;
import model.Clientes;
import model.Empleados;
import model.Producto;
import model.RoundedCornerBorder;
import model.Tabla_Reutilizable;
import utils.FormatoTablaMain;

import javax.swing.UIManager;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.Shape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.io.LineNumberInputStream;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntGestionProducto extends JInternalFrame {
	private String colorLetra="#000000";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntGestionProducto frame = new IntGestionProducto();
					frame.setVisible(true);
					IntGestionProducto a=new IntGestionProducto();
					a.listar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static DefaultTableModel model = new DefaultTableModel() {
public boolean isCellEditable(int filas,int columnas) {
			
			if(columnas==7) {
				return true;
			}
			else {
				return false;
			}
		}
	};
	private JTable tblProductos;
	private JTextField textField;
	private JLabel label_1;
	
	
	
	public IntGestionProducto() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				listar();
			}
		});
		getContentPane().setBackground(Color.WHITE);
		/*---------------------------------- > QUITAR BORDES DEL JINTERNALFRAME <--------------------*/
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*---------------------------------------------------------------------------------------*/

		
		
		

		model.setColumnCount(0);
		model.setRowCount(0);

	model.addColumn("clave");
		model.addColumn("Descripcion");
		
		model.addColumn("Unidades Existencia");
		
		
		model.addColumn("Precio Compra");
		model.addColumn("Precio Lista");
		
		
	
		model.addColumn("Codigo registro sanitario");
		model.addColumn("modificar");

		model.addColumn("eliminar");
		
	
		
		setTitle("Gestion Productos");
		setBounds(100, 100, 1626, 731);
		getContentPane().setLayout(null);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 93, 1040, 529);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 int column = tblProductos.getColumnModel().getColumnIndexAtX(e.getX());
			        int row = e.getY()/tblProductos.getRowHeight();
			        
			        if(row < tblProductos.getRowCount() && row >= 0 && column < tblProductos.getColumnCount() && column >= 0){
			            Object value = tblProductos.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;

			                if(boton.getName().equals("m")){
			               	 JdialogEditarProducto j=new JdialogEditarProducto();
			                	 int fila1 = tblProductos.getSelectedRow();
			                	 int codigo=Integer.parseInt(tblProductos.getValueAt(fila1, 0).toString());
			                	  System.out.println("el codigo el modficar es :"+codigo);
			                	  
			                	 ArrayList<Producto> lista=new GestionProductos().listadoXcodigo(codigo);
			                	  System.out.println("la lista es : "+lista.get(0).getCodbarra());
			                	  System.out.println("la lista es : "+lista.get(0).getDescripcion());
			                	  JdialogEditarProducto.lblCodigo.setText(lista.get(0).getCodigo()+"");
			                	 JdialogEditarProducto.txtCodigoBarra.setText(lista.get(0).getCodbarra()+"");
			                	 JdialogEditarProducto.txtDescripcion.setText(lista.get(0).getDescripcion());
			                	 JdialogEditarProducto.txtMarca.setText(lista.get(0).getMarca());
			                	 JdialogEditarProducto.txtPrecioCompra.setText(lista.get(0).getPrecioProCom()+"");
			                	 JdialogEditarProducto.txtPrecioVenta.setText(lista.get(0).getPrecioProVen()+"");
			                	 JdialogEditarProducto.cboUnidadCompra.getModel().setSelectedItem(lista.get(0).getUnidadCompra());
			                	 JdialogEditarProducto.cboUnidadVenta.getModel().setSelectedItem(lista.get(0).getUnidadVenta());
			                	 JdialogEditarProducto.txtFactor.setText(lista.get(0).getFactor()+"");
			                	 JdialogEditarProducto.txtCategoria.setText(lista.get(0).getNomCat());
			                	 JdialogEditarProducto.txtCodigoSanitario.setText(lista.get(0).getCodregistrosani());
			                	 JdialogEditarProducto.txtCodigoSunat.setText(lista.get(0).getCodSunat()+"");
			                	 JdialogEditarProducto.rdbLote.setSelected(lista.get(0).getLote());
			                	 JdialogEditarProducto.txtStock.setText(lista.get(0).getStock()+"");
			                	 
			                
			                	 j.setVisible(true);
			                	 j.setLocationRelativeTo(null);
			                	 
			                }
			                if(boton.getName().equals("e")){
			                	JOptionPane.showMessageDialog(null, "elimino");
			    				
			                   
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
			        }
				
				
				
			}
		});
		/*----------formato tabla-----------------*/
		
		FormatoTablaMain.formatoTabla(tblProductos);
		scrollPane.setViewportView(tblProductos);
		
		ArrayList<DefaultTableModel>lista=new ArrayList<>();
		lista.add(model);
		
	
		
		Tabla_Reutilizable t=new Tabla_Reutilizable();
		t.ver_tabla(tblProductos,  lista,model.getColumnCount());
		
		
		ArrayList<Producto> listado = new GestionProductos().listado();
		Tabla_Reutilizable.listar(listado);
		/*-----------------------------------------*/
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(1143, 0, 4, 704);
		getContentPane().add(lblNewLabel);
		
		JLabel lblArticuloSel = new JLabel("Articulo Seleccionado");
		lblArticuloSel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblArticuloSel.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticuloSel.setBounds(1157, 11, 469, 67);
		getContentPane().add(lblArticuloSel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1263, 114, 268, 269);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField(10) {
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		textField.setToolTipText("");
		textField.setBackground(new Color(239, 244, 249));
		textField.setBounds(691, 44, 345, 38);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("");
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		label.setIcon(ico);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(1046, 44, 44, 38);
		getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			RegistroProducto regis=new RegistroProducto();
			regis.setLocationRelativeTo(null);
			regis.setVisible(true);
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setLayout(null);
		panel.setBackground(new Color(20, 147, 225));
		panel.setBounds(50, 33, 160, 46);
		getContentPane().add(panel);
		
		label_1 = new JLabel("");
		label_1.setBounds(10, 3, 33, 43);
		ImageIcon imgIcon1 = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada1 = imgIcon1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado1 = new ImageIcon(imgEscalada1);
		label_1.setIcon(iconoEscalado1);
		panel.add(label_1);
		
		
		JLabel label_2 = new JLabel("Agregar");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(253, 254, 254));
		label_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		label_2.setBounds(56, 3, 80, 43);
		panel.add(label_2);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		
	}
	
	 public static void listar() {
		
		GestionProductos gc = new GestionProductos();
		ArrayList<Producto> lista = gc.listado();
		model.getDataVector().removeAllElements();
		
		for (Producto cl : lista) {
			Object datos[] = { cl.getCodbarra(), cl.getDescripcion(),cl.getStock(), cl.getPrecioProCom(),cl.getPrecioProVen()
					,cl.getCodregistrosani() };

			model.addRow(datos);

		}
		
	}
}
