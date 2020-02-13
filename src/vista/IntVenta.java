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
	private JDesktopPane dk;
	public  static JPanel panel_2;
	private JPanel panel_3;

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
		JLabel opc1 = new JLabel("Venta");
		JLabel opc2 = new JLabel("Cliente");
		JPanel panel_11 = new JPanel();
		
		
		panel_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_11.setBorder(null);
		panel_11.setBackground(Color.decode("#f3f4f5"));

		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				opc1.setForeground(Color.decode(colorNegro));
				panel_2.setVisible(true);
				
				opc2.setForeground(Color.decode(colorPlomo));
				panel_3.setVisible(false);
				
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
	
		
		panel_11.setBounds(79, 33, 120, 45);
		panel_1.add(panel_11);
		panel_11.setLayout(null);
		
		
		
		opc1.setHorizontalAlignment(SwingConstants.CENTER);
		opc1.setForeground(Color.decode(colorPlomo));
		opc1.setBounds(1, 5, 118, 27);
		panel_11.add(opc1);
		
		opc1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		panel_2 = new JPanel();
		panel_2.setBounds(28, 40, 70, 3);
		panel_11.add(panel_2);
		panel_2.setBackground(Color.decode(colorCeleste));
		
		JPanel panel_12 = new JPanel();
		panel_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_12.setBackground(Color.decode("#f3f4f5"));
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				opc2.setForeground(Color.decode(colorNegro));
				panel_3.setVisible(true);
				
				opc1.setForeground(Color.decode(colorPlomo));
				panel_2.setVisible(false);
				
				
				dk.removeAll();
				dk.repaint();
				IntCliente venta=new IntCliente();
				dk.add(venta);
				try {
					venta.setMaximum(true);
					venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					venta.show(); 
					
				
			
				
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			
				
				
			}
			
		});
		
		
		
		panel_12.setBounds(405, 33, 120, 45);
		panel_1.add(panel_12);
		panel_12.setLayout(null);
		
		opc2.setHorizontalAlignment(SwingConstants.CENTER);
		opc2.setForeground(Color.decode(colorPlomo));
		opc2.setBounds(0, 0, 121, 29);
		panel_12.add(opc2);
		
		opc2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		panel_3 = new JPanel();
		panel_3.setBounds(32, 40, 70, 3);
		panel_12.add(panel_3);
		panel_3.setBackground(Color.decode(colorCeleste));
		
		JLabel lblCotizacion = new JLabel("Cotizacion");
		lblCotizacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		lblCotizacion.setBounds(241, 33, 121, 29);
		panel_1.add(lblCotizacion);
		panel_3.setVisible(false);
		panel_2.setVisible(false);
		
		

	}
}
