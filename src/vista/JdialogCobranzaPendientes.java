package vista;

import java.awt.EventQueue;

import javax.mail.internet.NewsAddress;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionFinanzas;
import model.Celda_CheckBox;
import model.Cobranza;
import model.Render_CheckBox;
import model.Tabla_Reutilizable;
import utils.FormatoTablaMain;

import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JdialogCobranzaPendientes extends JDialog {
	public static JTable tblPendientesCobranza;
	public static JLabel lblTelfono_1;
	public static JLabel lblCelular_1;
	public static JLabel lblCorreo_1;
	public static JLabel lblNomCliente;
	public static JLabel lblnomCli2;
	public static String cliente;
	private JScrollPane scrollPane;

	DefaultTableModel model=new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogCobranzaPendientes dialog = new JdialogCobranzaPendientes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	
	
	public JdialogCobranzaPendientes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				mostrarTabla();
			}
		});
		setModal(true);
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1135, 561);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panelheader = new JPanel();
		panelheader.setBackground(Color.decode("#1493e1"));
		panelheader.setBounds(0, 0, 1119, 89);
		getContentPane().add(panelheader);
		panelheader.setLayout(null);
		
		JLabel lblPendientesDeCobro = new JLabel("PENDIENTES DE COBRO");
		lblPendientesDeCobro.setHorizontalAlignment(SwingConstants.CENTER);
		lblPendientesDeCobro.setForeground(new Color(240,240,240));
		lblPendientesDeCobro.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPendientesDeCobro.setBounds(384, 11, 334, 21);
		panelheader.add(lblPendientesDeCobro);
		
		lblNomCliente = new JLabel("");
		lblNomCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomCliente.setForeground(SystemColor.menu);
		lblNomCliente.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNomCliente.setBounds(384, 43, 334, 21);
		panelheader.add(lblNomCliente);
		
		JLabel lblPendientesDeCobranza = new JLabel("Pendientes de cobranza");
		lblPendientesDeCobranza.setForeground(Color.decode("#6ecbf0"));
		lblPendientesDeCobranza.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblPendientesDeCobranza.setBounds(10, 112, 159, 21);
		getContentPane().add(lblPendientesDeCobranza);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 646, 365);
		getContentPane().add(scrollPane);
		
		model.addColumn("Tipo");
		model.addColumn("Numero");
		model.addColumn("Vencimiento");
		model.addColumn("Mora");
		model.addColumn("Moneda");
		model.addColumn("Total");
		model.addColumn("Seleccionar");
		tblPendientesCobranza = new JTable();
		tblPendientesCobranza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		scrollPane.setViewportView(tblPendientesCobranza);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.WHITE);
		separator.setBounds(666, 100, 2, 411);
		getContentPane().add(separator);
		
		lblnomCli2 = new JLabel("");
		lblnomCli2.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblnomCli2.setForeground(Color.decode("#707070"));
		lblnomCli2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblnomCli2.setBounds(691, 113, 334, 21);
		getContentPane().add(lblnomCli2);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono :");
		lblTelfono.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblTelfono.setForeground(Color.decode("#b3b3b3"));
		lblTelfono.setBounds(691, 147, 59, 15);
		getContentPane().add(lblTelfono);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setForeground(new Color(179, 179, 179));
		lblCelular.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblCelular.setBounds(691, 173, 59, 15);
		getContentPane().add(lblCelular);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setForeground(new Color(179, 179, 179));
		lblCorreo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblCorreo.setBounds(691, 199, 59, 15);
		getContentPane().add(lblCorreo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(675, 225, 434, 2);
		getContentPane().add(separator_1);
		
		JLabel lblquDeseaHacer = new JLabel("\u00BFQu\u00E9 desea hacer con las cuentas seleccionadas?");
		lblquDeseaHacer.setHorizontalAlignment(SwingConstants.LEFT);
		lblquDeseaHacer.setForeground(new Color(112, 112, 112));
		lblquDeseaHacer.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblquDeseaHacer.setBounds(712, 238, 334, 21);
		getContentPane().add(lblquDeseaHacer);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JdialogCobranzaMediosPago pago=new  JdialogCobranzaMediosPago();
				pago.setVisible(true);
				pago.setLocationRelativeTo(null);
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBounds(698, 278, 388, 33);
		panel.setBackground(Color.decode("#1493e1"));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistrarCobro = new JLabel("Registrar Cobro");
		lblRegistrarCobro.setForeground(new Color(250,250,250));
		lblRegistrarCobro.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblRegistrarCobro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarCobro.setBounds(141, 11, 118, 14);
		panel.add(lblRegistrarCobro);
		
		JLabel lblFijar = new JLabel("Fijar Fecha de posible pago");
		lblFijar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFijar.setBorder(null);
		lblFijar.setHorizontalAlignment(SwingConstants.LEFT);
		lblFijar.setForeground(Color.decode("#1493e1"));
		lblFijar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblFijar.setBounds(700, 349, 196, 21);
		getContentPane().add(lblFijar);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JdialogEnvioEstadoCuenta envioEstadoCuenta=new JdialogEnvioEstadoCuenta();
				envioEstadoCuenta.setVisible(true);
			}
		});
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(20, 147, 225));
		panel_1.setBounds(522, 112, 134, 21);
		getContentPane().add(panel_1);
		
		JLabel lblEnviarEstadoDe = new JLabel("Enviar estado de cuenta");
		lblEnviarEstadoDe.setBounds(0, 0, 134, 21);
		panel_1.add(lblEnviarEstadoDe);
		lblEnviarEstadoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnviarEstadoDe.setForeground(new Color(250, 250, 250));
		lblEnviarEstadoDe.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		
		lblTelfono_1 = new JLabel("");
		lblTelfono_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelfono_1.setForeground(Color.GRAY);
		lblTelfono_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblTelfono_1.setBounds(760, 147, 159, 15);
		getContentPane().add(lblTelfono_1);
		
		lblCelular_1 = new JLabel("");
		lblCelular_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelular_1.setForeground(Color.GRAY);
		lblCelular_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblCelular_1.setBounds(760, 173, 159, 15);
		getContentPane().add(lblCelular_1);
		
		lblCorreo_1 = new JLabel("");
		lblCorreo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo_1.setForeground(Color.GRAY);
		lblCorreo_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblCorreo_1.setBounds(760, 199, 159, 15);
		getContentPane().add(lblCorreo_1);

		
	}
	
	void mostrarTabla (){
		
	
		  /* TABLA COBRANZA PENDIENTES*/
				FormatoTablaMain.formatoTabla(tblPendientesCobranza);
						ArrayList<DefaultTableModel>listaCli=new ArrayList<>();
						listaCli.add(model);
						
						Tabla_Reutilizable ta=new Tabla_Reutilizable();
						ta.ver_otraTabla(tblPendientesCobranza,  listaCli,model.getColumnCount());
						
						
						ArrayList<Cobranza> listadocoHoy = new GestionFinanzas().listadoxCliente(cliente);
						
						Tabla_Reutilizable.listarCobranzaCliente(listadocoHoy);
		
						
						
						for (Cobranza c: listadocoHoy) {
							lblTelfono_1.setText(c.getTelf_cli());
							lblCelular_1.setText(c.getCell_cli());
							lblCorreo_1.setText(c.getCorreo_cli());
						}
						tblPendientesCobranza.getColumnModel().getColumn(6).setCellEditor( new Celda_CheckBox() );
						tblPendientesCobranza.getColumnModel().getColumn( 6 ).setCellRenderer(new Render_CheckBox());
	}
}
