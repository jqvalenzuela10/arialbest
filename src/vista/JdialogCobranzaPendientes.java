package vista;

import java.awt.EventQueue;

import javax.mail.internet.NewsAddress;
import javax.swing.JButton;
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

import componentes.boton;
import mantenimientos.GestionFinanzas;
import model.Abono;
import model.Celda_CheckBox;
import model.Cobranza;
import model.Render_CheckBox;
import model.Tabla_Reutilizable;
import model.prueba;
import utils.FormatoTablaMain;
import utils.clsArial;

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
	public static String idVenta;
	private JScrollPane scrollPane;

	private JLabel lbIiconlEmpresa;
	private JLabel lbliconAbonar;
	private JLabel lblTotalSaldo;
	private JTable tblAbonos;
	
	

	DefaultTableModel model=new DefaultTableModel();
	DefaultTableModel model2=new DefaultTableModel();
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
		setTitle("                                                                                                                     PENDIENTES DE COBRO");
		addWindowListener(new WindowAdapter() {
		
			public void windowActivated(WindowEvent arg0) {
                mostrarTablaCreditos();
                mostrarTablaAbonos();
				lblTotalSaldo.setText("Total :     S./ " + Double.toString(sumarColumna()));
			}
		});
		model2.addColumn("Fecha");
		model2.addColumn("F.P");
		model2.addColumn("Observación");
		model2.addColumn("Monto");

		
		
		setModal(true);
		
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		setBounds(100, 100, 945, 681);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panelheader = new JPanel();
		panelheader.setBackground(Color.WHITE);
		panelheader.setBounds(0, 0, 929, 138);
		getContentPane().add(panelheader);
		panelheader.setLayout(null);
		
		lblNomCliente = new JLabel("");
		lblNomCliente.setForeground(Color.BLACK);
		lblNomCliente.setFont(new Font("Segoe UI Semibold", Font.BOLD, 23));
		lblNomCliente.setBounds(208, 11, 334, 38);
		panelheader.add(lblNomCliente);
		
		lbIiconlEmpresa = new JLabel("");
		lbIiconlEmpresa.setBounds(46, 28, 125, 93);
		new clsArial().modifiedIcon("/img/empresa.png", 120, 120, lbIiconlEmpresa);
		panelheader.add(lbIiconlEmpresa);
		
		lblCelular_1 = new JLabel("");
		lblCelular_1.setBounds(208, 83, 108, 15);
		panelheader.add(lblCelular_1);
		lblCelular_1.setForeground(Color.decode(clsArial.colorGrisOscuro));
		lblCelular_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		lblCorreo_1 = new JLabel("");
		lblCorreo_1.setBounds(208, 106, 119, 15);
		panelheader.add(lblCorreo_1);
		lblCorreo_1.setForeground(Color.decode(clsArial.colorGrisOscuro));
		lblCorreo_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		lblTelfono_1 = new JLabel("");
		lblTelfono_1.setBounds(208, 60, 108, 15);
		panelheader.add(lblTelfono_1);
		lblTelfono_1.setForeground(Color.decode(clsArial.colorGrisOscuro));
		lblTelfono_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		model.addColumn("ID");
		model.addColumn("Tipo");
		model.addColumn("Numero");
		model.addColumn("Vencimiento");
		model.addColumn("Mora");
		model.addColumn("Deuda");
		model.addColumn("Abono");
		model.addColumn("Saldo");
		model.addColumn("Seleccionar");
		
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.WHITE);
		separator.setBounds(666, 193, -1, 318);
		getContentPane().add(separator);
		
		lblnomCli2 = new JLabel("");
		lblnomCli2.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblnomCli2.setForeground(Color.decode("#707070"));
		lblnomCli2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblnomCli2.setBounds(691, 113, 334, 21);
		getContentPane().add(lblnomCli2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 211, 929, 219);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPendientesDeCobranza = new JLabel("Lista de Creditos");
		lblPendientesDeCobranza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPendientesDeCobranza.setBounds(368, 0, 159, 21);
		panel_2.add(lblPendientesDeCobranza);
		lblPendientesDeCobranza.setForeground(Color.BLACK);
		lblPendientesDeCobranza.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 24, 908, 150);
		panel_2.add(scrollPane);
		tblPendientesCobranza = new JTable();
		tblPendientesCobranza.setBackground(Color.WHITE);
		tblPendientesCobranza.addMouseListener(new MouseAdapter() {
			
		
			@Override
			public void mouseClicked(MouseEvent e) {
				// int column = tblPendientesCobranza.getColumnModel().getColumnIndexAtX(e.getX());
			        int row = e.getY()/tblPendientesCobranza.getRowHeight();
			        
			           idVenta = tblPendientesCobranza.getValueAt(row, 0).toString();
			            System.out.println(idVenta);
			            mostrarTablaAbonos();
			            
			            
			            int column = tblPendientesCobranza.getColumnModel().getColumnIndexAtX(e.getX());
				       
				        if(row < tblPendientesCobranza.getRowCount() && row >= 0 && column < tblPendientesCobranza.getColumnCount() && column >= 0){
				            Object value = tblPendientesCobranza.getValueAt(row, column);
				            if(value instanceof JButton){
				                ((JButton)value).doClick();
				                JButton boton = (JButton) value;

				                if(boton.getName().equals("p")){
				                	
				                	 int fila1 = tblPendientesCobranza.getSelectedRow();
					                  System.out.println("el codigo A VER es :"+tblPendientesCobranza.getValueAt(fila1, 0).toString());
					                  JdialogRegistroAbono cobranzaPendientes=new JdialogRegistroAbono();
					                  JdialogRegistroAbono.txtSaldo.setText(tblPendientesCobranza.getValueAt(fila1, 7).toString());
					                  JdialogRegistroAbono.idVenta=(tblPendientesCobranza.getValueAt(fila1, 0).toString());
					                  
				                	 
				                	 cobranzaPendientes.setVisible(true);
				              
			            
				                }
				                }
			}}
		});
		scrollPane.setViewportView(tblPendientesCobranza);
		
		lblTotalSaldo = new JLabel();
		lblTotalSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalSaldo.setForeground(Color.BLACK);
		lblTotalSaldo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTotalSaldo.setBounds(702, 181, 216, 38);
		panel_2.add(lblTotalSaldo);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(0, 441, 929, 229);
		getContentPane().add(panel_2_1);
		
		JLabel lblPendientesDeCobranza_1 = new JLabel("Lista de Abonos");
		lblPendientesDeCobranza_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPendientesDeCobranza_1.setForeground(Color.BLACK);
		lblPendientesDeCobranza_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblPendientesDeCobranza_1.setBounds(370, 0, 159, 21);
		panel_2_1.add(lblPendientesDeCobranza_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 909, 170);
		panel_2_1.add(scrollPane_1);
		
		tblAbonos = new JTable();
		scrollPane_1.setViewportView(tblAbonos);
		
		lbliconAbonar = new JLabel("");
		lbliconAbonar.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconAbonar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbliconAbonar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JdialogRegistroAbono pago=new  JdialogRegistroAbono();
				JdialogRegistroAbono.txtSaldo.setText( Double.toString(sumarSaldoCheck()));
				pago.setVisible(true);
				
				
				
				 
				
				
				
			}
		});
		new clsArial().modifiedIcon("/img/billete.png", 50, 50, lbliconAbonar);
		lbliconAbonar.setBounds(10, 149, 51, 36);
		getContentPane().add(lbliconAbonar);
		
		JLabel lblNewLabel = new JLabel("Abonar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 186, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lbliconAbonar_1 = new JLabel("");
		lbliconAbonar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbliconAbonar_1.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/calendario.png", 35, 30, lbliconAbonar_1);
		lbliconAbonar_1.setBounds(93, 149, 51, 36);
		getContentPane().add(lbliconAbonar_1);
		
		JLabel lblPagare = new JLabel("Pagar\u00E9");
		lblPagare.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagare.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPagare.setBounds(95, 186, 46, 18);
		getContentPane().add(lblPagare);
		
		JLabel lbliconEstCuenta = new JLabel("");
		lbliconEstCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JdialogEnvioEstadoCuenta envioEstadoCuenta=new JdialogEnvioEstadoCuenta();
				envioEstadoCuenta.setVisible(true);
			}
		});
		lbliconEstCuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbliconEstCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconEstCuenta.setBounds(205, 149, 51, 36);
		new clsArial().modifiedIcon("/img/correo.png", 50, 30, lbliconEstCuenta);
		getContentPane().add(lbliconEstCuenta);
		
		JLabel lblEstadoDeCuenta = new JLabel("Estado de Cuenta");
		lblEstadoDeCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoDeCuenta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEstadoDeCuenta.setBounds(176, 186, 108, 18);
		
		getContentPane().add(lblEstadoDeCuenta);

		
	}
	public  double sumarColumna() {
		
		int contador=tblPendientesCobranza.getRowCount();
		double suma=0;
		for (int i = 0; i < contador; i++) {
			
				suma=suma+Double.parseDouble((tblPendientesCobranza.getValueAt(i, 7).toString()));
				
			
			
		}
		return suma;
	
	}
	
	public double sumarSaldoCheck() {
		
		int contador=tblPendientesCobranza.getRowCount();
		
		double suma=0;
		boolean select;
		for (int i = 0; i < contador; i++) {
			select=(boolean)tblPendientesCobranza.getValueAt(i, 8);
			System.out.println(select);
			if (select==true) {
				System.out.println(i);
				suma+=Double.parseDouble((tblPendientesCobranza.getValueAt(i, 7).toString()));
			}
			
				
				
			
			
		}
		System.out.println(suma);
		return suma;
	}
	
	
	void mostrarTablaCreditos (){
		
	
		  /* TABLA COBRANZA PENDIENTES*/
				FormatoTablaMain.formatoTabla(tblPendientesCobranza);
						ArrayList<DefaultTableModel>listaCli=new ArrayList<>();
						listaCli.add(model);
						
						Tabla_Reutilizable ta=new Tabla_Reutilizable();
						ta.ver_tabla(tblPendientesCobranza,  listaCli,model.getColumnCount());
						
						System.out.println("el cliente es : "+cliente);
						ArrayList<Cobranza> listadocoHoy = new GestionFinanzas().listadoxCliente(cliente);
						System.out.println("el listado es :"+listadocoHoy);
						Tabla_Reutilizable.listarCobranzaCliente(listadocoHoy);
		
						
						
						for (Cobranza c: listadocoHoy) {
							lblTelfono_1.setText(c.getTelf_cli());
							lblCelular_1.setText(c.getCell_cli());
							lblCorreo_1.setText(c.getCorreo_cli());
						}
						
	}
	
	void mostrarTablaAbonos (){
		
		
		  /* TABLA COBRANZA PENDIENTES*/
				FormatoTablaMain.formatoTabla(tblAbonos);
						ArrayList<DefaultTableModel>listaCli=new ArrayList<>();
						listaCli.add(model2);
						
						Tabla_Reutilizable ta=new Tabla_Reutilizable();
						ta.ver_otraTabla(tblAbonos,  listaCli,model2.getColumnCount());
						
						
						ArrayList<Abono> listadocoHoy = new GestionFinanzas().listadoAbonos(idVenta);
						
						Tabla_Reutilizable.listarAbonos(listadocoHoy);
		
				
	}
}
