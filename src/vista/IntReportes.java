package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import model.Tabla;
import utils.clsArial;

import javax.swing.SwingConstants;

public class IntReportes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntReportes frame = new IntReportes();
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
	public static String colorNegro="#38383c";
	public static String colorPlomo="#808793";
	public static DefaultTableModel model = new DefaultTableModel();
	Tabla t=new Tabla();
	public static JDesktopPane dkFinanzas;
	public static JPanel rayaPago;
	public static JPanel rayaUsu;
	public static JLabel lblPagos;
	public static JLabel lblCobranza;
	private JLabel lblVentas;
	private JLabel lblCompras;
	public IntReportes() {
		setBounds(100, 100, 1642, 940);
		getContentPane().setLayout(null);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		addInternalFrameListener(new InternalFrameAdapter() {
		@Override
		public void internalFrameOpened(InternalFrameEvent arg0) {
			dkFinanzas.removeAll();
			dkFinanzas.repaint();
			IntReportesCobranza cobranza=new IntReportesCobranza();
			dkFinanzas.add(cobranza);
			try {
				cobranza.setMaximum(true);
				cobranza.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
				cobranza.show(); 
				
			
		
			
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	});
	
	
	
	
	JPanel panelHeader = new JPanel();
	panelHeader.setBackground(Color.WHITE);
	panelHeader.setBounds(0, 0, 1642, 69);
	getContentPane().add(panelHeader);
	panelHeader.setLayout(null);
	
	lblCobranza = new JLabel("Cobranzas");
	lblCobranza.setHorizontalAlignment(SwingConstants.CENTER);
	lblCobranza.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			lblPagos.setForeground(Color.decode(colorPlomo));
			
			rayaPago.setVisible(false);
			
			lblCobranza.setForeground(Color.decode(colorNegro));
			rayaUsu.setVisible(true);
			clsArial.setInternalFrame(dkFinanzas, new IntReportesCobranza(), null, null);
			
		}
		
	});
	lblCobranza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblCobranza.setForeground(Color.decode("#808793"));
	lblCobranza.setFont(new Font("Segoe UI", Font.BOLD, 14));
	lblCobranza.setBounds(92, 33, 73, 25);
	panelHeader.add(lblCobranza);
	
	lblPagos = new JLabel("Utilidades");
	lblPagos.setHorizontalAlignment(SwingConstants.CENTER);
	lblPagos.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			lblPagos.setForeground(Color.decode(colorNegro));
		
			rayaPago.setVisible(true);
			
			lblCobranza.setForeground(Color.decode(colorPlomo));
			rayaUsu.setVisible(false);
			new clsArial().setInternalFrame(dkFinanzas,new IntReportesUtilidades(), null, null);
			
		}
	});
	lblPagos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblPagos.setForeground(new Color(128, 135, 147));
	lblPagos.setFont(new Font("Segoe UI", Font.BOLD, 14));
	lblPagos.setBounds(188, 35, 73, 23);
	panelHeader.add(lblPagos);
	
	rayaUsu = new JPanel();
	rayaUsu.setBounds(97, 63, 62, 3);
	rayaUsu.setBackground(Color.decode("#1493e1"));
	panelHeader.add(rayaUsu);
	
	rayaPago = new JPanel();
	rayaPago.setVisible(false);
	rayaPago.setBounds(196, 63, 60, 3);
	rayaPago.setBackground(Color.decode("#1493e1"));
	panelHeader.add(rayaPago);
	
	lblVentas = new JLabel("Ventas");
	lblVentas.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			new clsArial().setInternalFrame(dkFinanzas, new IntReportesVentas(), null, null);
		}
	});
	lblVentas.setHorizontalAlignment(SwingConstants.CENTER);
	lblVentas.setForeground(new Color(128, 135, 147));
	lblVentas.setFont(new Font("Segoe UI", Font.BOLD, 14));
	lblVentas.setBounds(287, 35, 73, 23);
	panelHeader.add(lblVentas);
	
	lblCompras = new JLabel("Compras");
	lblCompras.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			new clsArial().setInternalFrame(dkFinanzas, new IntReportesCompras(), null, null);
		}
	});
	lblCompras.setHorizontalAlignment(SwingConstants.CENTER);
	lblCompras.setForeground(new Color(128, 135, 147));
	lblCompras.setFont(new Font("Segoe UI", Font.BOLD, 14));
	lblCompras.setBounds(384, 35, 73, 23);
	
	panelHeader.add(lblCompras);
	
	JPanel rayaUsu_1 = new JPanel();
	rayaUsu_1.setBackground(new Color(20, 147, 225));
	rayaUsu_1.setBounds(295, 63, 62, 3);
	panelHeader.add(rayaUsu_1);
	
	JPanel rayaUsu_2 = new JPanel();
	rayaUsu_2.setBackground(new Color(20, 147, 225));
	rayaUsu_2.setBounds(390, 63, 62, 3);
	panelHeader.add(rayaUsu_2);
	
	dkFinanzas = new JDesktopPane();
	dkFinanzas.setBackground(Color.decode("#ebf0f4"));
	dkFinanzas.setBounds(0, 67, 1642, 846);
	getContentPane().add(dkFinanzas);
	
	
	


}
}
