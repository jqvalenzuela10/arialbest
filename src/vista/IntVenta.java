package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

import javax.imageio.ImageTypeSpecifier;
import javax.print.DocFlavor.URL;
import javax.print.attribute.IntegerSyntax;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import model.RoundedCornerBorder;
import utils.FocusJpanel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import com.toedter.calendar.JDateChooser;


public class IntVenta extends JInternalFrame {
	private String colorCeleste="#0f95ec";
	private String colorMenu="#2D363F";
	private String colorHover="#232b37";
	private String colorNegro="#38383c";
	private String colorPlomo="#808793";
	private String colorFondo="#ebf0f4";
	public static  JDesktopPane dk;
	public  static JPanel rayaVenta;
	private JPanel rayaCliente;
	private JPanel rayaCotizacion;
	private JLabel panelCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntVenta frame = new IntVenta();
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
	public IntVenta() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				dk.removeAll();
				dk.repaint();
				IntVentasWindow venta=new IntVentasWindow();
				dk.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		setBorder(null);
		setBounds(223, 79, 1644, 915);
		getContentPane().setLayout(null);
		
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		dk = new JDesktopPane();
		dk.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(220, 225, 229)));
		dk.setBackground(Color.WHITE);
		dk.setBounds(0, 77, 1642, 811);
		getContentPane().add(dk);
	
	
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
        Image imgEscalada = imgIcon.getImage().getScaledInstance(25,
                25, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
		ImageIcon iconExecel = new ImageIcon(getClass().getResource("/iconos/exel.png"));
        Image imgEsca = iconExecel.getImage().getScaledInstance(45,
                45, Image.SCALE_SMOOTH);
        Icon iconoEscalados = new ImageIcon(imgEsca);
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
        Image i = iconSearch.getImage().getScaledInstance(38,
                38, Image.SCALE_SMOOTH);
        Icon ic = new ImageIcon(i);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#f3f4f5"));
		panel_1.setBounds(0, 0, 1642, 79);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCotizacion = new JLabel("Cotizacion");
		lblCotizacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCotizacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaVenta);
				listado.add(rayaCliente);
				
				FocusJpanel.lanzarFoco(rayaCotizacion, listado);
				dk.removeAll();
				dk.repaint();
				IntGestionCotizacion coti=new IntGestionCotizacion();
				dk.add(coti);
				try {
					coti.setMaximum(true);
					coti.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					coti.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			
				
			}
		});
		lblCotizacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCotizacion.setForeground(new Color(128, 135, 147));
		lblCotizacion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCotizacion.setBounds(241, 33, 121, 35);
		panel_1.add(lblCotizacion);
		panelCliente = new JLabel("Venta");
		panelCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		

				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaCotizacion);
				listado.add(rayaCliente);
				
				FocusJpanel.lanzarFoco(rayaVenta, listado);
				
				
				
				dk.removeAll();
				dk.repaint();
				IntVentasWindow cliente=new IntVentasWindow();
				dk.add(cliente);
				
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
		panelCliente.setBounds(67, 33, 118, 35);
		panel_1.add(panelCliente);
		
		
		
		panelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		panelCliente.setForeground(Color.decode(colorPlomo));
		
		panelCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		rayaVenta = new JPanel();
		rayaVenta.setBounds(94, 71, 70, 3);
		panel_1.add(rayaVenta);
		rayaVenta.setBackground(Color.decode(colorCeleste));
		
		rayaCotizacion = new JPanel();
		rayaCotizacion.setBackground(new Color(15, 149, 236));
		rayaCotizacion.setBounds(267, 73, 68, 3);
		rayaCotizacion.setVisible(false);
		panel_1.add(rayaCotizacion);
		JLabel opc2 = new JLabel("Cliente");
		opc2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		opc2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<JPanel>listado=new ArrayList<>();
				listado.add(rayaCotizacion);
				listado.add(rayaVenta);
				
				FocusJpanel.lanzarFoco(rayaCliente, listado);
				
				dk.removeAll();
				dk.repaint();
				IntCliente cliente=new IntCliente();
				dk.add(cliente);
				
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
		opc2.setBounds(414, 33, 121, 35);
		panel_1.add(opc2);
		
		opc2.setHorizontalAlignment(SwingConstants.CENTER);
		opc2.setForeground(Color.decode(colorPlomo));
		
		opc2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		rayaCliente = new JPanel();
		rayaCliente.setBounds(441, 71, 70, 3);
		panel_1.add(rayaCliente);
		rayaCliente.setBackground(Color.decode(colorCeleste));
		rayaCliente.setVisible(false);
		
		
		

	}
}
