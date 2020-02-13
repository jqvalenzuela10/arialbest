package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import utils.FocusJpanel;



public class IntAlmacen extends JInternalFrame {

	private String colorCeleste="#0f95ec";
	private String colorMenu="#2D363F";
	private String colorHover="#232b37";
	private String colorNegro="#38383c";
	private String colorPlomo="#808793";
	private JLabel lblProductos;
	private JLabel lblLotes;
	private JLabel lblInventario;
	private JLabel lblEntrada;
	private JLabel lblSalidas;
	private JLabel lblRemision;
	private JPanel rayaLotes;
	private JPanel rayaInventario;
	private JPanel rayaSalida;
	private JPanel rayaRemision;
	private JPanel rayaIngreso;
	private JDesktopPane dktIntGestionProd;
	private JPanel rayaProducto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntAlmacen frame = new IntAlmacen();
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
	public IntAlmacen() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntGestionProducto venta=new IntGestionProducto();
				dktIntGestionProd.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		setBounds(223, 122, 1626, 901);
		setBackground(Color.decode("#EFF4F9"));
		getContentPane().setLayout(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		setBorder(null);
		dktIntGestionProd = new JDesktopPane();
		dktIntGestionProd.setBackground(Color.WHITE);
		dktIntGestionProd.setBounds(0, 75, 1626, 799);
		getContentPane().add(dktIntGestionProd);
		
		JPanel JPanel = new JPanel();
		JPanel.setBackground(Color.decode("#f3f4f5"));
		JPanel.setBounds(0, 0, 1626, 77);
		getContentPane().add(JPanel);
		JPanel.setLayout(null);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaLotes);
				listado.add(rayaInventario);
				listado.add(rayaIngreso);
				listado.add(rayaSalida);
				listado.add(rayaRemision);
				FocusJpanel.lanzarFoco(rayaProducto, listado);
				
				

				/*para cambiar de internal*/
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntGestionProducto compra=new IntGestionProducto();
				dktIntGestionProd.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		lblProductos.setBounds(47, 34, 68, 32);
		JPanel.add(lblProductos);
		lblProductos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProductos.setForeground(Color.decode(colorPlomo));
	
		
		lblLotes = new JLabel("Lotes");
		lblLotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaProducto);
				listado.add(rayaInventario);
				listado.add(rayaIngreso);
				listado.add(rayaSalida);
				listado.add(rayaRemision);
				FocusJpanel.lanzarFoco(rayaLotes, listado);
				
				/*para cambiar de internal*/
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntLotes compra=new IntLotes();
				dktIntGestionProd.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		lblLotes.setBounds(183, 34, 84, 32);
		JPanel.add(lblLotes);
		lblLotes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLotes.setForeground(Color.decode(colorPlomo));
		
		rayaLotes = new JPanel();
		rayaLotes.setBounds(183, 71, 84, 3);
		JPanel.add(rayaLotes);
		rayaLotes.setBackground(Color.decode(colorCeleste));
		
		lblInventario = new JLabel("Inventario");
		lblInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaProducto);
				listado.add(rayaLotes);
				listado.add(rayaIngreso);
				listado.add(rayaSalida);
				listado.add(rayaRemision);
				FocusJpanel.lanzarFoco(rayaInventario, listado);
				

				/*para cambiar de internal*/
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntInventario compra=new IntInventario();
				dktIntGestionProd.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		lblInventario.setBounds(335, 34, 68, 32);
		JPanel.add(lblInventario);
		lblInventario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblInventario.setForeground(Color.decode(colorPlomo));
		
		rayaInventario = new JPanel();
		rayaInventario.setBounds(329, 71, 84, 3);
		JPanel.add(rayaInventario);
		rayaInventario.setBackground(Color.decode(colorCeleste));
		
		lblEntrada = new JLabel("Ingreso");
		lblEntrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaProducto);
				listado.add(rayaLotes);
				listado.add(rayaSalida);
				listado.add(rayaInventario);
				listado.add(rayaRemision);
				FocusJpanel.lanzarFoco(rayaIngreso, listado);
				
				/*para cambiar de internal*/
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntIngreso compra=new IntIngreso();
				dktIntGestionProd.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		lblEntrada.setBounds(516, 34, 74, 32);
		JPanel.add(lblEntrada);
		lblEntrada.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEntrada.setForeground(Color.decode(colorPlomo));
		
		rayaIngreso = new JPanel();
		rayaIngreso.setBounds(516, 71, 84, 3);
		JPanel.add(rayaIngreso);
		rayaIngreso.setBackground(Color.decode(colorCeleste));
		
		lblSalidas = new JLabel("Salida");
		lblSalidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSalidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaProducto);
				listado.add(rayaLotes);
				listado.add(rayaIngreso);
				listado.add(rayaInventario);
				listado.add(rayaRemision);
				FocusJpanel.lanzarFoco(rayaSalida, listado);
				
				/*para cambiar de internal*/
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntSalida compra=new IntSalida();
				dktIntGestionProd.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		lblSalidas.setBounds(676, 34, 84, 32);
		JPanel.add(lblSalidas);
		lblSalidas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSalidas.setForeground(Color.decode(colorPlomo));
		
		rayaSalida = new JPanel();
		rayaSalida.setBounds(676, 71, 84, 3);
		JPanel.add(rayaSalida);
		
		rayaSalida.setBackground(Color.decode(colorCeleste));
		
		lblRemision = new JLabel("Remision");
		lblRemision.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRemision.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaProducto);
				listado.add(rayaLotes);
				listado.add(rayaIngreso);
				listado.add(rayaSalida);
				listado.add(rayaInventario);
				FocusJpanel.lanzarFoco(rayaRemision, listado);
				
				/*para cambiar de internal*/
				dktIntGestionProd.removeAll();
				dktIntGestionProd.repaint();
				IntGuiaRemision compra=new IntGuiaRemision();
				dktIntGestionProd.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		lblRemision.setBounds(829, 34, 84, 32);
		JPanel.add(lblRemision);
		lblRemision.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRemision.setForeground(Color.decode(colorPlomo));
		
		rayaRemision = new JPanel();
		rayaRemision.setBounds(829, 71, 84, 3);
		JPanel.add(rayaRemision);
		rayaRemision.setBackground(Color.decode(colorCeleste));
		
		rayaProducto = new JPanel();
		rayaProducto.setBounds(57, 71, 68, 3);
		rayaProducto.setBackground(Color.decode(colorCeleste));
		JPanel.add(rayaProducto);
		rayaRemision.setVisible(false);
		rayaSalida.setVisible(false);
		rayaIngreso.setVisible(false);
		rayaInventario.setVisible(false);
		rayaLotes.setVisible(false);
		
		
	
		
		
		

	}
}
