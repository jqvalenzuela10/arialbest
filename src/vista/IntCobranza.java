package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.data.time.Month;

import mantenimientos.GestionEmpledos;
import mantenimientos.GestionFinanzas;
import mantenimientos.GestionProductos;
import model.Cobranza;
import model.Empleados;
import model.HintTextField;
import model.Producto;
import model.RoundedCornerBorder;
import model.Tabla;
import model.TablaPerfiles;
import model.Tabla_Reutilizable;
import utils.FormatoTablaMain;
import utils.clsArial;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.ComponentOrientation;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class IntCobranza extends JInternalFrame {
	private JTable tblCobranza;
public static DefaultTableModel model=new DefaultTableModel();
public static DefaultTableModel model2=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntCobranza frame = new IntCobranza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	private JTextField txtBusqUsu;
	private JTable tblCobranzaHoy;
	private JMonthChooser spinMes;
	private JYearChooser spinAño;
	/**
	 * Create the frame.
	 */
	public IntCobranza() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
	             /* TABLA COBRANZA HOY*/
				FormatoTablaMain.formatoTabla(tblCobranzaHoy);
						ArrayList<DefaultTableModel>listaHoy=new ArrayList<>();
						listaHoy.add(model2);
						
						Tabla_Reutilizable ta=new Tabla_Reutilizable();
						ta.ver_otraTabla(tblCobranzaHoy,  listaHoy,model2.getColumnCount());
						
						
						ArrayList<Cobranza> listadocoHoy = new GestionFinanzas().listadoCobranzaHoy();
						Tabla_Reutilizable.listarCobranzaHoy(listadocoHoy);
			}
		});
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		setBounds(0, 68, 1642, 851);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(){
			
			/* -------------REDONDEO BORDES JPANEL -----------*/
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JdialogRegistroUsuario registroUsuario=new JdialogRegistroUsuario();
				registroUsuario.setVisible(true);
				registroUsuario.setLocationRelativeTo(null);
			}
		});
		
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("cliente");
		model.addColumn("tipo Doc.");
		model.addColumn("Doc. Id");
		model.addColumn("Tipo");
		model.addColumn("Numero");
		model.addColumn("Condiciones");
		model.addColumn("Emision");
		model.addColumn("Vencimiento");
		model.addColumn("Vendedor");
		model.addColumn("Moneda");
		model.addColumn("Total");
		model.addColumn("Abono");
		model.addColumn("Saldo");
		model.addColumn("Vence(dias)");
		model.addColumn("Dias mora");
		model.addColumn("");
		
		model2.setRowCount(0);
		model2.setColumnCount(0);
		model2.addColumn("Cliente");
		model2.addColumn("Moneda");
		model2.addColumn("Pendiente");
		model2.addColumn("");
	
		panel.setBackground(Color.decode("#1493e1"));
		panel.setBounds(1500, 11, 132, 35);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbliconoNuevo = new JLabel("");
		lbliconoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconoNuevo.setBounds(0, 0, 51, 35);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		lbliconoNuevo.setIcon(iconoEscalado);
		panel.add(lbliconoNuevo);
		
		JLabel lblNuevo = new JLabel("Nuevo");
		lblNuevo.setForeground(Color.WHITE);
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setBounds(56, 0, 76, 35);
		panel.add(lblNuevo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(442, 70, 1190, 752);
		getContentPane().add(scrollPane);
		
		tblCobranza = new JTable();
		
		tblCobranza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				 int column = tblCobranza.getColumnModel().getColumnIndexAtX(e.getX());
			        int row = e.getY()/tblCobranza.getRowHeight();
			        
			        if(row < tblCobranza.getRowCount() && row >= 0 && column < tblCobranza.getColumnCount() && column >= 0){
			            Object value = tblCobranza.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;

			                if(boton.getName().equals("v")){
			                	
				                
				                  
			                	 JdialogCobranzaPendientes cobranzaPendientes=new JdialogCobranzaPendientes();
			                  /*eNVIANDO DATOS DEL USUARIO PARA EDITAR*/
			                  int fila1 = tblCobranza.getSelectedRow();
			                  System.out.println("el codigo A VER es :"+tblCobranza.getValueAt(fila1, 0).toString());
			                  JdialogCobranzaPendientes.lblNomCliente.setText(tblCobranza.getValueAt(fila1, 0).toString());
			                  JdialogCobranzaPendientes.lblnomCli2.setText(tblCobranza.getValueAt(fila1, 0).toString());
			                  JdialogCobranzaPendientes.cliente=(tblCobranza.getValueAt(fila1, 0).toString());
			                  JdialogCobranzaPendientes.cliente=(tblCobranza.getValueAt(fila1, 0).toString());
			          	 
			                  //JdialogCobranzaPendientes.tblPendientesCobranza.setValueAt(tblCobranza.getValueAt(fila1, column), row, column);
			          		cobranzaPendientes.setVisible(true);
			                  
			                }
			                if(boton.getName().equals("e")){
			                	int fila1 = tblCobranza.getSelectedRow();
			                	System.out.println("en eliminar es :"+tblCobranza.getValueAt(fila1, 0).toString());
			    				String id=tblCobranza.getValueAt(fila1, 0).toString();	// <-- SE CAPTURA DNI DE LA FILA PA ELIMINAR
			    			
			    				eliminar(id);
			    				
			                   
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
	
		FormatoTablaMain.formatoTabla(tblCobranza);
	
		scrollPane.setViewportView(tblCobranza);
		
		ArrayList<DefaultTableModel>lista=new ArrayList<>();
		lista.add(model);
		
		Tabla_Reutilizable t=new Tabla_Reutilizable();
		t.ver_tabla(tblCobranza,  lista,model.getColumnCount());
		
		
		ArrayList<Cobranza> listado = new GestionFinanzas().listado();
		Tabla_Reutilizable.listarCobranza(listado);
		
		
		
		txtBusqUsu =new HintTextField("Search") {
			
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		
		};
		txtBusqUsu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				System.out.println("entro al keyreelease");
				
				String nombre=txtBusqUsu.getText();
				
				GestionEmpledos gc = new GestionEmpledos();
				Tabla.model.getDataVector().removeAllElements();
				ArrayList<Empleados> lista = gc.listado(nombre);
				
				
				Tabla.listarNombre(lista);
			}
		});
		txtBusqUsu.setBounds(1027, 11, 396, 35);
		getContentPane().add(txtBusqUsu);
		txtBusqUsu.setColumns(10);
		
		JPanel panelConbranzaHoy = new JPanel();
		panelConbranzaHoy.setBackground(Color.decode(new clsArial().colorMenu));
		panelConbranzaHoy.setBounds(30, 11, 378, 812);
		getContentPane().add(panelConbranzaHoy);
		panelConbranzaHoy.setLayout(null);
		
		JLabel lblHoy = new JLabel("HOY");
		lblHoy.setForeground(new Color(240,240,240,240));
		lblHoy.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblHoy.setBounds(150, 17, 52, 37);
		panelConbranzaHoy.add(lblHoy);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 70, 378, 644);
		panelConbranzaHoy.add(scrollPane_1);
		
		tblCobranzaHoy = new JTable();
		tblCobranzaHoy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 int column = tblCobranzaHoy.getColumnModel().getColumnIndexAtX(arg0.getX());
			        int row = arg0.getY()/tblCobranzaHoy.getRowHeight();
			        
			        if(row < tblCobranzaHoy.getRowCount() && row >= 0 && column < tblCobranzaHoy.getColumnCount() && column >= 0){
			            Object value = tblCobranzaHoy.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;

			                if(boton.getName().equals("v")){
			                	
			                
			                  
			                	 JdialogCobranzaPendientes cobranzaPendientes=new JdialogCobranzaPendientes();
			                  /*eNVIANDO DATOS DEL USUARIO PARA EDITAR*/
			                  int fila1 = tblCobranzaHoy.getSelectedRow();
			                  System.out.println("el codigo A VER es :"+tblCobranzaHoy.getValueAt(fila1, 0).toString());
			                  JdialogCobranzaPendientes.lblNomCliente.setText(tblCobranzaHoy.getValueAt(fila1, 0).toString());
			                  JdialogCobranzaPendientes.lblnomCli2.setText(tblCobranzaHoy.getValueAt(fila1, 0).toString());
			                  JdialogCobranzaPendientes.cliente=(tblCobranzaHoy.getValueAt(fila1, 0).toString());
			                
			          	 
			          		cobranzaPendientes.setVisible(true);
			                  
			                }
			                if(boton.getName().equals("e")){
			                	int fila1 = tblCobranza.getSelectedRow();
			                	System.out.println("en eliminar es :"+tblCobranza.getValueAt(fila1, 0).toString());
			    				String id=tblCobranza.getValueAt(fila1, 0).toString();	// <-- SE CAPTURA DNI DE LA FILA PA ELIMINAR
			    			
			    				eliminar(id);
			    				
			                   
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
FormatoTablaMain.formatoTabla(tblCobranza);
		
scrollPane_1.setViewportView(tblCobranzaHoy);
		
 
	
		
		JLabel lblTotalCobraHoy = new JLabel("1400");
		lblTotalCobraHoy.setForeground(new Color(240,240,240));
		lblTotalCobraHoy.setBounds(150, 747, 74, 45);
		panelConbranzaHoy.add(lblTotalCobraHoy);
		lblTotalCobraHoy.setFont(new Font("Segoe UI", Font.BOLD, 27));
		
		JLabel lblS = new JLabel("S/.");
		lblS.setForeground(new Color(240,240,240));
		lblS.setBounds(114, 748, 34, 45);
		panelConbranzaHoy.add(lblS);
		lblS.setFont(new Font("Segoe UI", Font.BOLD, 26));
		
		JLabel lblT = new JLabel("Total");
		lblT.setForeground(new Color(240,240,240));
		lblT.setBounds(27, 747, 75, 45);
		panelConbranzaHoy.add(lblT);
		lblT.setFont(new Font("Segoe UI", Font.BOLD, 25));
	
		
		spinMes = new JMonthChooser();
		spinMes.getComboBox().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				spinAño.addPropertyChangeListener(new PropertyChangeListener() {

					/*------------------------AÑO --------------------------------------*/
					@Override
					public void propertyChange(PropertyChangeEvent arg0) {
				
						
						try {
							Tabla_Reutilizable t=new Tabla_Reutilizable();
							t.ver_tabla(tblCobranza,  lista,model.getColumnCount());
							System.out.println(spinMes.getMonth());
							ArrayList<Cobranza> listado = new GestionFinanzas().listadoxFecha( arg0.getNewValue().toString(),Integer.toString(spinMes.getMonth()) );
							Tabla_Reutilizable.listarCobranza(listado);
						} catch (Exception e) {
							// TODO: handle exception
						}
				        
						
					}
					});
				
				
				/*------------------------ MES --------------------------------------*/
				spinMes.addPropertyChangeListener(new PropertyChangeListener() {
					
					
					   

					@Override
					public void propertyChange(PropertyChangeEvent arg0) {
				

						
						
							
						
						
						try {
							Tabla_Reutilizable t=new Tabla_Reutilizable();
							t.ver_tabla(tblCobranza,  lista,model.getColumnCount());
							System.out.println(spinAño.getYear());
							ArrayList<Cobranza> listado = new GestionFinanzas().listadoxFecha(Integer.toString(spinAño.getYear()),  arg0.getNewValue().toString());
							Tabla_Reutilizable.listarCobranza(listado);
						} catch (Exception e) {
							// TODO: handle exception
						}
				        
						
					}
					});
			}
		});
		spinMes.setMonth(0);
		
		spinMes.setBackground(Color.WHITE);
		spinMes.getSpinner().setForeground(Color.WHITE);
		spinMes.getSpinner().setBackground(Color.WHITE);
		spinMes.getComboBox().setBackground(Color.WHITE);
		spinMes.getComboBox().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		spinMes.setBounds(581, 11, 91, 35);
		
		getContentPane().add(spinMes);
		
		spinAño = new JYearChooser();
		
		spinAño.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		spinAño.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spinAño.getSpinner().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 30));
		
		spinAño.setBounds(442, 11, 103, 35);
		getContentPane().add(spinAño);
		

			}

void eliminar(String id) {

	GestionEmpledos gc = new GestionEmpledos();

	int ok = gc.eliminar(id);

	if (ok == 0) {
		
	} else {
		JOptionPane.showMessageDialog(null, ok + " Registro eliminado");
		Tabla.model.setRowCount(0);  // <--------- LIMPIA LA TABLA
		Tabla.listar();
	}

}
void MostrarTabla() {
    /* TABLA COBRANZA HOY*/
FormatoTablaMain.formatoTabla(tblCobranzaHoy);
ArrayList<DefaultTableModel>listaHoy=new ArrayList<>();
listaHoy.add(model2);

Tabla_Reutilizable ta=new Tabla_Reutilizable();
ta.ver_otraTabla(tblCobranzaHoy,  listaHoy,model2.getColumnCount());


ArrayList<Cobranza> listadocoHoy = new GestionFinanzas().listadoCobranzaHoy();
Tabla_Reutilizable.listarCobranzaHoy(listadocoHoy);
}

  }
