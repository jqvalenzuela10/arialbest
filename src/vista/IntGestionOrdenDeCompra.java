package vista;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Clientes;
import model.Compra;
import model.OrdenCompra;
import model.OrdenRegistroCompra;
import model.RoundedCornerBorder;
import utils.FormatoTabla;
import utils.FormatoTablaMain;
import utils.clsArial;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.rollover.TableRolloverController;

import componentes.boton;
import mantenimientos.GestionCompra;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class IntGestionOrdenDeCompra extends JInternalFrame {
	
	private JTextField txtBusquedad;
	public static DefaultTableModel model=new DefaultTableModel();
	public static JTable table;
	private JLabel lblAprovada;
	private JLabel lblGenerada;
	private JLabel lblEmitida;
	private JLabel lblCerrada;
	private JLabel lblAnulada;
	private JComboBox cboFiltro;
	private JPanel panelBoton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntGestionOrdenDeCompra frame = new IntGestionOrdenDeCompra();
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
	public IntGestionOrdenDeCompra() {
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				
				/*listar gestion orden de compra internal*/
				listaOrdeCompra();
			
				
			}
		});
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Fecha de orden");
		model.addColumn("Usuario");
	
		model.addColumn("Proveedor");
	
		
		
	
		model.addColumn("Fecha de entrega");
		model.addColumn("Total");
		
		
		
		setBounds(100, 100, 1600, 708);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		txtBusquedad = new JTextField(10) ;
		txtBusquedad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				String nombre = txtBusquedad.getText();
				String filtro = (String)cboFiltro.getSelectedItem();
			
				ArrayList<OrdenCompra> lista = null;

			

					GestionCompra gc = new GestionCompra();
					model.getDataVector().removeAllElements();
					lista = gc.listadoXFiltroOrden(filtro, nombre);
					for (OrdenCompra cl : lista) {
						Object o[] = {  cl.getFechaOrdenCompra(),cl.getNomUsuario(),cl.getNomProveedor()
								,cl.getFechaEntrega(),cl.getTotal()};
						model.addRow(o);

					
					
					
				}
				
			}
		});
		txtBusquedad.setToolTipText("");
		txtBusquedad.setBackground(new Color(239, 244, 249));
		txtBusquedad.setBounds(1178, 19, 345, 30);
		getContentPane().add(txtBusquedad);
		
		
		
		
		ImageIcon iconSearch = new ImageIcon(getClass().getResource("/iconos/search.png"));
		Image i = iconSearch.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ic = new ImageIcon(i);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		
		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		/*icono*/
		clsArial c=new clsArial();
		c.modifiedIcon("/iconos/search.png", 38, 38, label_1);
		/*--*/
		
		label_1.setBounds(1526, 21, 44, 30);
		getContentPane().add(label_1);
		label_1.setVerticalAlignment(SwingConstants.TOP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 66, 1186, 519);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		FormatoTablaMain.formatoTabla(table);
		
		
		table.setModel(model);
		
		JPanel panel_1 = new JPanel();
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(Color.decode("#2D363F"));
				lblGenerada.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {

				panel_1.setBackground(Color.white);
				lblGenerada.setForeground(Color.black);
			}
		});
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(13, 183, 308, 57);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblGenerada = new JLabel("Generada");
		lblGenerada.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblGenerada.setBounds(27, 0, 80, 57);
		panel_1.add(lblGenerada);
		
		JPanel panel_2 = new JPanel();
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				panel_2.setBackground(Color.decode("#2D363F"));
				lblAprovada.setForeground(Color.WHITE);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(Color.white);
				lblAprovada.setForeground(Color.black);
			}
		});
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(13, 71, 308, 57);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblAprovada = new JLabel("Aprovada");
		lblAprovada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblAprovada.setBounds(27, 0, 80, 57);
		panel_2.add(lblAprovada);
		
		JPanel panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(Color.decode("#2D363F"));
				lblEmitida.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(Color.white);
				lblEmitida.setForeground(Color.black);
			}
		});
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(13, 299, 308, 57);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		lblEmitida = new JLabel("Emitida");
		lblEmitida.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblEmitida.setBounds(27, 0, 80, 57);
		panel_3.add(lblEmitida);
		
		JPanel panel_4 = new JPanel();
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(Color.decode("#2D363F"));
				lblCerrada.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(Color.white);
				lblCerrada.setForeground(Color.black);
			}
		});
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(13, 410, 308, 57);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		lblCerrada = new JLabel("Cerrada");
		lblCerrada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblCerrada.setBounds(27, 0, 80, 57);
		panel_4.add(lblCerrada);
		
		JPanel panel_5 = new JPanel();
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(Color.decode("#2D363F"));
				lblAnulada.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(Color.white);
				lblAnulada.setForeground(Color.black);
			}
		});
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(13, 528, 308, 57);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		lblAnulada = new JLabel("Anulada");
		lblAnulada.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblAnulada.setBounds(27, 0, 80, 57);
		panel_5.add(lblAnulada);
		
		cboFiltro = new JComboBox();
		cboFiltro.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONA", "USUARIO", "FECHA ORDEN", "PROVEEDOR"}));
		cboFiltro.setOpaque(false);
		cboFiltro.setBackground(Color.WHITE);
		cboFiltro.setBounds(1026, 18, 138, 30);
		cboFiltro.setUI(CustomUI.createUI(this));
		getContentPane().add(cboFiltro);
		
		JLabel label_3 = new JLabel("FILTRO");
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		label_3.setBounds(953, 11, 65, 38);
		getContentPane().add(label_3);
		
		
		
		
		
	
		
		
		
		
/*los componentes agregados*/
		
		boton boton=new boton();
		FrmOrdenDeCompra frmOrdenCompra=new FrmOrdenDeCompra();
		
		panelBoton = new JPanel();
		panelBoton.setBounds(388, 19, 150, 30);
		boton.mibotonAgregar(panelBoton);
		panelBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmOrdenDeCompra o=new FrmOrdenDeCompra();
			
			o.setVisible(true);
			o.setLocationRelativeTo(null);
			}
		});
		
		
	
		getContentPane().add(panelBoton);
		/*--------------------------*/

	}
	
	public static void listaOrdeCompra() {
		ArrayList<OrdenCompra> lista=new ArrayList<>();
		GestionCompra gui=new GestionCompra();
		lista=gui.listadoOrdenCompra();
	
model.getDataVector().removeAllElements();
		
		for (OrdenCompra cl : lista) {
			Object datos[] = {  cl.getFechaOrdenCompra(),cl.getNomUsuario(),cl.getNomProveedor()
								,cl.getFechaEntrega(),cl.getTotal()};

			model.addRow(datos);
			
		}
		
	}
}
