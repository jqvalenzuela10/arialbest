
package vista;


import java.awt.EventQueue;
import hilos.Hilo_Tiempo;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.omg.CORBA.PUBLIC_MEMBER;

import Animacion.Animacion;
import AppPackage.AnimationClass;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Point;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Component;
import keeptoo.KGradientPanel;
import mantenimientos.GestionCaja;
import model.Caja;
import model.Empleados;
import utils.clsArial;

import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.jdesktop.core.animation.timing.triggers.TimingTrigger;
import org.jdesktop.swingx.JXList;


public class FrmMenuPrincipal extends JFrame {

	private JPanel contentPane;
	public static JLabel lblFecha;
	public static JLabel lblReloj;
	public static JLabel lblCargo;
	public static JLabel lblUsuario;
	
	
	private JLabel lblCompras;
	public static JDesktopPane dktBody;
	public static JLabel lblUser2;
	private JLabel lblAlmacen;
	private JLabel lblNewLabel_1;
	private JPanel panel_dashboard;
	public static JPanel panel_ventas;
	private JLabel label;
	public static JPanel panelCompras;
	public static JPanel panelAlmacen;
	private JLabel label_6;
	private JLabel lblArial;
	private JLabel label_4;
	private JPanel panel_4;
	private JLabel label_14;
	private JLabel label_15;
	private JPanel panel_9;
	private JPanel panelPerfil;
	private JLabel label_19;
	private JLabel lblDashboard;
	private JLabel lblComercial;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JPanel panel;
	private JLabel lblSeguridad;
	private JLabel label_2;
	private JLabel label_3;
	public static JLabel lblIconoUsu;
	private JPanel panel_2;
	private JPanel panel_3;

	
	clsArial clsIcono=new clsArial();
	static FrmMenuPrincipal frame ;
	private JPanel panel_1_2;
	public static JLabel lblCaja_1;
	public static JLabel lblCodCaja;
	public static JLabel lblSaldo;
	
	ArrayList<Caja> listado=new GestionCaja().listado();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new FrmMenuPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMenuPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				dktBody.removeAll();
				dktBody.repaint();
				IntDashBoard l=new IntDashBoard();
				dktBody.add(l);
				try {
					l.setMaximum(true);
					l.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					l.show(); 
			}catch (Exception ex) {
				// TODO: handle exception
			}
			
			}
		});
	
		setUndecorated(true);
		setBackground(Color.WHITE);
		try {
			FrmMenuPrincipal.setDefaultLookAndFeelDecorated(true);
		
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		setTitle("ARIAL PERU BIOFARMACEUTICA SAC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1865, 950);
		
		/*---------------------------------------------------*/
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
				panel_2 = new JPanel();
				panel_2.setBounds(223, 59, 1642, 1);
				contentPane.add(panel_2);
				panel_2.setBackground(Color.decode("#ebf0f4"));
				
				panel_4 = new JPanel();
				panel_4.setBounds(0, 0, 222, 950);
				panel_4.setBackground(Color.decode(new clsArial().colorMenu));
				contentPane.add(panel_4);
				panel_4.setLayout(null);
				
				lblArial = new JLabel("ARIAL");
				lblArial.setBounds(69, 11, 84, 44);
				panel_4.add(lblArial);
				
				lblArial.setForeground(Color.decode("#ffffff"));
				lblArial.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
				panel_dashboard = new JPanel();
				panel_dashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_dashboard.setEnabled(false);
				panel_dashboard.setBackground(Color.decode("#2D363F"));
				panel_dashboard.setBounds(1, 153, 222, 51);
			
				panel_4.add(panel_dashboard);
				panel_dashboard.addMouseListener(new MouseAdapter() {
					
					public void mouseEntered(MouseEvent e) {
						label_13.setBorder(new LineBorder(new Color(38, 162, 252), 4, true));
						panel_dashboard.setBackground(Color.decode(new clsArial().colorHover));
						
						lblDashboard.setForeground(Color.WHITE);
						label_13.setVisible(true);
					
					}
					@Override
					public void mouseExited(MouseEvent e) {
						label_13.setBorder(new LineBorder(new Color(38, 162, 252), 4, true));
						label_13.setForeground(Color.decode("#98a3af"));
						panel_dashboard.setBackground(Color.decode(new clsArial().colorMenu));
						label_13.setVisible(false);
						
					}
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dktBody.removeAll();
						dktBody.repaint();
						IntDashBoard l=new IntDashBoard();
						dktBody.add(l);
						try {
							l.setMaximum(true);
							l.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
							l.show(); 
					}catch (Exception ex) {
						// TODO: handle exception
					}
					}
				});
				
					panel_dashboard.setLayout(null);
					
					lblDashboard = new JLabel("DASHBOARD");
					lblDashboard.setBounds(58, 0, 125, 51);
					panel_dashboard.add(lblDashboard);
					lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
					lblDashboard.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
					lblDashboard.setForeground(Color.decode("#98a3af"));
					
				
					lblDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
					
					lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setBounds(0, 0, 59, 48);
					lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					panel_dashboard.add(lblNewLabel_1);
					lblNewLabel_1.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/iconos/IconoDashBoard.png")));
					
					label_13 = new JLabel("");
					label_13.setOpaque(false);
					label_13.setBackground(new Color(15, 149, 236));
					label_13.setBounds(218, -1, 3, 52);
					panel_dashboard.add(label_13);
					
					
			
					
					panel_ventas = new JPanel();
					panel_ventas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					panel_ventas.setBounds(1, 236, 222, 51);
					panel_4.add(panel_ventas);
					panel_ventas.addMouseListener(new MouseAdapter() {
						
						@Override
						public void mouseEntered(MouseEvent e) {
							

							label_11.setBorder(new LineBorder(new Color(38, 162, 252), 4, true));
							panel_ventas.setBackground(Color.decode(new clsArial().colorHover));
							lblComercial.setForeground(Color.white);
							label_11.setVisible(true);
							
							
						}
						@Override
						public void mouseExited(MouseEvent e) {
							label_11.setBorder(new LineBorder(new Color(38, 162, 252), 4, true));
							panel_ventas.setBackground(Color.decode(new clsArial().colorMenu));
							lblComercial.setForeground(Color.decode("#98a3af"));
							label_11.setVisible(false);
							
						}
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							dktBody.removeAll();
							dktBody.repaint();
							IntVenta venta=new IntVenta();
							dktBody.add(venta);
							try {
								venta.setMaximum(true);
								venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
								venta.show(); 
								
							
						
							
							
							} catch (Exception e) {
								// TODO: handle exception
							}
						
							
							
							
							
						}
					});
					panel_ventas.setBackground(Color.decode("#2D363F"));
					panel_ventas.setOpaque(true);
					panel_ventas.setLayout(null);
					
					
					
					lblComercial = new JLabel("VENTAS");
					lblComercial.setBounds(57, 0, 126, 51);
					
					panel_ventas.add(lblComercial);
					lblComercial.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
				
					lblComercial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					lblComercial.setForeground(Color.decode("#98a3af"));
					lblComercial.setBorder(null);
					lblComercial.setBackground(new Color(44, 57, 68));
					lblComercial.setHorizontalAlignment(SwingConstants.CENTER);
					lblComercial.setHorizontalTextPosition(SwingConstants.CENTER);
					
					label = new JLabel("");
					label.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/iconos/carrito1.png")));
					label.setHorizontalTextPosition(SwingConstants.CENTER);
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setBounds(0, 0, 59, 48);
					panel_ventas.add(label);
					
					label_11 = new JLabel("");
					label_11.setOpaque(false);
					label_11.setBackground(new Color(15, 149, 236));
					label_11.setBounds(218, 0, 3, 52);
					panel_ventas.add(label_11);
					
					
					panelCompras = new JPanel();
					panelCompras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					panelCompras.setBounds(1, 319, 222, 51);
					panel_4.add(panelCompras);
					panelCompras.addMouseListener(new MouseAdapter() {
					
						@Override
						public void mouseEntered(MouseEvent e) {
							
							label_12.setBorder(new LineBorder(new Color(38, 162, 252), 4, true));
							panelCompras.setBackground(Color.decode(new clsArial().colorHover));
							lblCompras.setForeground(Color.WHITE);
							label_12.setVisible(true);
							
							
						}
						@Override
						public void mouseExited(MouseEvent e) {
							
							label_12.setBorder(new LineBorder(new Color(38, 162, 252), 4, true));
							panelCompras.setBackground(Color.decode(new clsArial().colorMenu));
							lblCompras.setForeground(Color.decode("#98a3af"));
							label_12.setVisible(false);
							
						}
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							dktBody.removeAll();
							dktBody.repaint();
							IntpCompra compra=new IntpCompra();
							dktBody.add(compra);
							try {
								compra.setMaximum(true);
								compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
								compra.show(); 
								
							
						
							
							
							} catch (Exception e) {
								// TODO: handle exception
							}
						
							
						}
					});
					panelCompras.setBackground(Color.decode("#2D363F"));
					panelCompras.setLayout(null);
					lblCompras = new JLabel("COMPRAS");
					lblCompras.setBounds(70, 0, 98, 51);
					panelCompras.add(lblCompras);
					lblCompras.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
					lblCompras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					lblCompras.setForeground(Color.decode("#98a3af"));
					lblCompras.setHorizontalAlignment(SwingConstants.CENTER);
					lblCompras.setBackground(new Color(44, 57, 68));
					
					label_4 = new JLabel("");
					label_4.setHorizontalTextPosition(SwingConstants.CENTER);
					label_4.setHorizontalAlignment(SwingConstants.CENTER);
					label_4.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/iconos/reporte.png")));
					label_4.setBounds(0, 0, 59, 48);
					panelCompras.add(label_4);
					
					label_12 = new JLabel("");
					label_12.setOpaque(false);
					label_12.setBackground(new Color(15, 149, 236));
					label_12.setBounds(218, -1, 3, 52);
					panelCompras.add(label_12);
					
					panelAlmacen = new JPanel();
					panelAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					panelAlmacen.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							
							panelAlmacen.setBackground(Color.decode(new clsArial().colorHover));
						lblAlmacen.setForeground(Color.WHITE);
							
							label_14.setOpaque(true);
							
							
						}
						@Override
						public void mouseExited(MouseEvent e) {
							panelAlmacen.setBackground(Color.decode(new clsArial().colorMenu));
							lblAlmacen.setForeground(Color.decode("#98a3af"));
							
							label_14.setOpaque(false);
							
						}
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							dktBody.removeAll();
							dktBody.repaint();
							IntAlmacen venta=new IntAlmacen();
							dktBody.add(venta);
							try {
								venta.setMaximum(true);
								venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
								venta.show(); 
								
							
						
							
							
							} catch (Exception ex) {
								// TODO: handle exception
							}
						}
					});
					panelAlmacen.setBounds(1, 407, 222, 51);
					panel_4.add(panelAlmacen);
					panelAlmacen.setLayout(null);
					panelAlmacen.setBackground(Color.decode("#2D363F"));
					
					lblAlmacen = new JLabel("ALMACEN");
				
					lblAlmacen.setBounds(71, 0, 98, 52);
					panelAlmacen.add(lblAlmacen);
					lblAlmacen.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
					lblAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
					lblAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					lblAlmacen.setForeground(Color.decode("#98a3af"));
					lblAlmacen.setBackground(new Color(44, 57, 68));
					
					label_6 = new JLabel("");
					
					label_6.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/iconos/almacen.png")));
					label_6.setHorizontalTextPosition(SwingConstants.CENTER);
					label_6.setHorizontalAlignment(SwingConstants.CENTER);
					label_6.setBounds(2, 2, 59, 48);
					panelAlmacen.add(label_6);
					
					label_14 = new JLabel("");
					label_14.setBounds(218, 0, 3, 52);
					label_14.setBackground(Color.decode(new clsArial().colorCeleste));
					label_14.setOpaque(false);
					panelAlmacen.add(label_14);
					
					panel = new JPanel();
					panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					panel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							dktBody.removeAll();
							dktBody.repaint();
							IntUsuarios venta=new IntUsuarios();
							dktBody.add(venta);
							try {
								venta.setMaximum(true);
								venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
								venta.show(); 
								
							
						
							
							
							} catch (Exception ex) {
								// TODO: handle exception
							}
						}
					});
					panel.setLayout(null);
					panel.setBackground(new Color(45, 54, 63));
					panel.setBounds(1, 506, 222, 51);
					panel_4.add(panel);
					
					lblSeguridad = new JLabel("USUARIO");
					lblSeguridad.setHorizontalAlignment(SwingConstants.CENTER);
					lblSeguridad.setForeground(new Color(152, 163, 175));
					lblSeguridad.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
					lblSeguridad.setBackground(new Color(44, 57, 68));
					lblSeguridad.setBounds(71, 0, 98, 52);
					panel.add(lblSeguridad);
					
					label_2 = new JLabel("");
					label_2.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/lock.png")));
					label_2.setHorizontalTextPosition(SwingConstants.CENTER);
					label_2.setHorizontalAlignment(SwingConstants.CENTER);
					label_2.setBounds(2, 2, 59, 48);
					panel.add(label_2);
					
					label_3 = new JLabel("");
					label_3.setOpaque(false);
					label_3.setBackground(new Color(15, 149, 236));
					label_3.setBounds(218, 0, 3, 52);
					panel.add(label_3);
					
					lblUsuario = new JLabel("");
					lblUsuario.setForeground(Color.LIGHT_GRAY);
					lblUsuario.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
					lblUsuario.setBounds(68, 92, 142, 26);
					panel_4.add(lblUsuario);
					
					lblIconoUsu = new JLabel("");
					lblIconoUsu.setBounds(18, 87, 48, 38);
					panel_4.add(lblIconoUsu);
					
					panel_3 = new JPanel();
					panel_3.setBounds(0, 59, 223, 3);
					panel_3.setBackground(Color.decode("#2e314b"));
					panel_4.add(panel_3);
					
					JPanel panel_5 = new JPanel();
					panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					panel_5.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {

							
							clsArial.setInternalFrame(dktBody,new IntFinanzas(),null,null);
						}
					});
					panel_5.setLayout(null);
					panel_5.setBackground(new Color(45, 54, 63));
					panel_5.setBounds(1, 596, 222, 51);
					panel_4.add(panel_5);
					
					JLabel lblFinanzas = new JLabel("FINANZAS");
					lblFinanzas.setHorizontalAlignment(SwingConstants.CENTER);
					lblFinanzas.setForeground(new Color(152, 163, 175));
					lblFinanzas.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
					lblFinanzas.setBackground(new Color(44, 57, 68));
					lblFinanzas.setBounds(71, 0, 98, 52);
					panel_5.add(lblFinanzas);
					
					JLabel label_5 = new JLabel("");
					label_5.setHorizontalTextPosition(SwingConstants.CENTER);
					label_5.setHorizontalAlignment(SwingConstants.CENTER);
					label_5.setBounds(2, 2, 59, 48);
					ImageIcon imgIcon = new ImageIcon(getClass().getResource("/img/ico_Finanzas.png"));
					Image imgEscalada = imgIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
					Icon iconoEscalado = new ImageIcon(imgEscalada);
					label_5.setIcon(iconoEscalado);
					panel_5.add(label_5);
					
					JLabel label_7 = new JLabel("");
					label_7.setOpaque(false);
					label_7.setBackground(new Color(15, 149, 236));
					label_7.setBounds(218, 0, 3, 52);
					panel_5.add(label_7);
					
					JPanel panel_5_1 = new JPanel();
					panel_5_1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							new clsArial().setInternalFrame(dktBody	, new IntCaja(), null, null);
						}
					});
					panel_5_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					panel_5_1.setLayout(null);
					panel_5_1.setBackground(new Color(45, 54, 63));
					panel_5_1.setBounds(1, 682, 222, 51);
					panel_4.add(panel_5_1);
					
					JLabel lblCaja = new JLabel("CAJA");
					lblCaja.setHorizontalAlignment(SwingConstants.CENTER);
					lblCaja.setForeground(new Color(152, 163, 175));
					lblCaja.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
					lblCaja.setBackground(new Color(44, 57, 68));
					lblCaja.setBounds(71, 0, 98, 52);
					panel_5_1.add(lblCaja);
					
					JLabel label_5_1 = new JLabel("");
					label_5_1.setHorizontalTextPosition(SwingConstants.CENTER);
					label_5_1.setHorizontalAlignment(SwingConstants.CENTER);
					label_5_1.setBounds(2, 2, 59, 48);
					new clsArial().modifiedIcon("/img/caja.png", 29, 29, label_5_1);
					panel_5_1.add(label_5_1);
					
					JLabel label_7_1 = new JLabel("");
					label_7_1.setOpaque(false);
					label_7_1.setBackground(new Color(15, 149, 236));
					label_7_1.setBounds(218, 0, 3, 52);
					panel_5_1.add(label_7_1);
					
					JPanel panel_5_1_1 = new JPanel();
					panel_5_1_1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							clsArial.setInternalFrame(dktBody, new IntReportes(), null, null);
						}
					});
					panel_5_1_1.setLayout(null);
					panel_5_1_1.setBackground(new Color(45, 54, 63));
					panel_5_1_1.setBounds(1, 764, 222, 51);
					panel_4.add(panel_5_1_1);
					
					JLabel lblReportes = new JLabel("REPORTES");
					lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
					lblReportes.setForeground(new Color(152, 163, 175));
					lblReportes.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
					lblReportes.setBackground(new Color(44, 57, 68));
					lblReportes.setBounds(71, 0, 98, 52);
					panel_5_1_1.add(lblReportes);
					
					JLabel label_5_1_1 = new JLabel("");
					label_5_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
					label_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
					label_5_1_1.setBounds(2, 2, 59, 48);
					new clsArial().modifiedIcon("/img/reporte.png", 29, 29, label_5_1_1);
					panel_5_1_1.add(label_5_1_1);
					
					JLabel label_7_1_1 = new JLabel("");
					label_7_1_1.setOpaque(false);
					label_7_1_1.setBackground(new Color(15, 149, 236));
					label_7_1_1.setBounds(218, 0, 3, 52);
					panel_5_1_1.add(label_7_1_1);
					
					panel_9 = new JPanel();
					panel_9.setBounds(223, 0, 1356, 57);
					contentPane.add(panel_9);
					panel_9.setBackground(Color.decode("#FDFEFE"));
					panel_9.setLayout(null);
					
					lblFecha = new JLabel("");
					lblFecha.setFont(new Font("Verdana", Font.BOLD, 17));
					lblFecha.setBounds(211, 24, 138, 25);
					panel_9.add(lblFecha);
					lblFecha.setForeground(Color.BLACK);
					
					lblReloj = new JLabel("");
					lblReloj.setFont(new Font("Verdana", Font.PLAIN, 30));
					lblReloj.setBounds(86, 13, 138, 29);
					panel_9.add(lblReloj);
					lblReloj.setForeground(Color.BLACK);
					
					JPanel panelCaja = new JPanel();
					panelCaja.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							JdialogCambiarCaja caja=new JdialogCambiarCaja();
							caja.setVisible(true);
						}
					});
					panelCaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					panelCaja.setLayout(null);
					panelCaja.setBackground(Color.WHITE);
					panelCaja.setBounds(1191, 5, 155, 49);
					panel_9.add(panelCaja);
						
					String nomCaja=listado.get(0).getNomCaja();
					lblCaja_1 = new JLabel(nomCaja);
					
					lblCaja_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblCaja_1.setForeground(Color.BLACK);
					lblCaja_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
					lblCaja_1.setBounds(92, 1, 60, 20);
					panelCaja.add(lblCaja_1);
					
					JLabel lbliconCaja = new JLabel("");
					lbliconCaja.setHorizontalAlignment(SwingConstants.CENTER);
					new clsArial().modifiedIcon("/img/caja_color.png", 38, 38, lbliconCaja);
					lbliconCaja.setBounds(32, 1, 50, 48);
					panelCaja.add(lbliconCaja);
					
					
					int codigo=Integer.parseInt(listado.get(0).getCodCaja()+"");
					lblCodCaja = new JLabel(codigo+"");
					lblCodCaja.setBounds(0, 1, 19, 14);
					panelCaja.add(lblCodCaja);
					
					double saldo=Double.parseDouble(listado.get(0).getSaldo()+"");
					lblSaldo = new JLabel(saldo+"");
					lblSaldo.setBounds(102, 35, 50, 14);
					panelCaja.add(lblSaldo);
					
					panel_1_2 = new JPanel();
					panel_1_2.setBackground(new Color(235, 240, 244));
					panel_1_2.setBounds(1176, 0, 1, 57);
					panel_9.add(panel_1_2);
					
					dktBody = 	new JDesktopPane();
					contentPane.add(dktBody);

					dktBody.setBounds(new Rectangle(223, 60, 1642, 890));
					dktBody.setBackground(Color.WHITE);

					dktBody.setBorder(null);
					
					panelPerfil = new JPanel();
					panelPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					panelPerfil.setBounds(1589, 5, 204, 49);
					contentPane.add(panelPerfil);
					panelPerfil.setBackground(Color.WHITE);
					panelPerfil.addMouseListener(new MouseAdapter() {
						
						
						/*---- ABRIR Y ENVIAR TODOS LOS DATOS A DIALOG PERFIL -----------------------*/
						public void mouseClicked(MouseEvent arg0) {
							frmPerfil f=new frmPerfil(FrmMenuPrincipal.this);
							f.setVisible(true);
						
								
		
							
							
							if (FrmLogin.e.getId_tip_emp().equals("1")) {
								
								
								
								ImageIcon imgIcon = new ImageIcon(getClass().getResource("/img/user2.png"));
								Image imgEscalada = imgIcon.getImage().getScaledInstance(107, 91,
										Image.SCALE_SMOOTH);
								Icon iconoEscalado = new ImageIcon(imgEscalada);
								
								frmPerfil.lblimagenUsu.setIcon(iconoEscalado);
								frmPerfil.lblNombre_1.setText(FrmLogin.e.getNom_emp());
								frmPerfil.lblCargo.setText("Administrador");
								
								
								
								frmPerfil.txtNombre_2.setText("dd");
								frmPerfil.txtApePat.setText(FrmLogin.e.getApe_pat_emp());
								frmPerfil.txtApeMat.setText(FrmLogin.e.getApe_mat_emp());
								frmPerfil.txtDireccion.setText(FrmLogin.e.getDirec_emp());
								frmPerfil.txtTelf.setText(FrmLogin.e.getTelf_emp());
								frmPerfil.txtCell.setText(FrmLogin.e.getCell_emp());
								frmPerfil.txtUsu.setText(FrmLogin.e.getLogin_emp());
								
								
							}
						}
					});
					panelPerfil.setLayout(null);
					
					label_15 = new JLabel("");
					label_15.setBounds(162, 11, 32, 32);
					panelPerfil.add(label_15);
					
					label_15.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/iconos/arrowbot.png")));
					label_15.setCursor(new Cursor(12));
					
					lblCargo = new JLabel("");
					lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
					lblCargo.setBounds(52, 1, 100, 48);
					panelPerfil.add(lblCargo);
					lblCargo.setFont(new Font("Agency FB", Font.PLAIN, 14));
					lblCargo.setForeground(Color.BLACK);
					
					lblUser2 = new JLabel("");
					lblUser2.setHorizontalAlignment(SwingConstants.CENTER);
					lblUser2.setBounds(0, 1, 50, 48);
					panelPerfil.add(lblUser2);
					
					label_19 = new JLabel("");
					label_19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					label_19.setHorizontalAlignment(SwingConstants.CENTER);
					ImageIcon iconSearch = new ImageIcon(getClass().getResource("/img/apagar_rojo.png"));
					Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
					Icon ic = new ImageIcon(i);
					label_19.setIcon(ic);
					
					label_19.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
	                        FrmLogin frmLogin=new FrmLogin();
						
							frmLogin.setVisible(true);
							frmLogin.setLocationRelativeTo(null);
							dispose();
						}
					});
					label_19.setBounds(1805, 0, 60, 49);
					contentPane.add(label_19);
					
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(Color.decode("#ebf0f4"));
					panel_1.setBounds(1794, 0, 1, 57);
					contentPane.add(panel_1);
					
					JPanel panel_1_1 = new JPanel();
					panel_1_1.setBackground(new Color(235, 240, 244));
					panel_1_1.setBounds(1587, 0, 1, 57);
					contentPane.add(panel_1_1);
					UIManager.put("btnDashOpc1.selected", Color.RED);
				
			
				
				
			
				
		iniciaReloj();

	}
	void iniciaReloj() {
		
		//INSTANCIAMOS LA CLASE HILO RELOJ
		Hilo_Tiempo r = new Hilo_Tiempo();
		
		//INICIA EL HILO
		r.start();
	}
}

