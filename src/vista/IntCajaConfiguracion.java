package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCaja;
import mantenimientos.GestionEmpledos;
import mantenimientos.GestionProductos;
import model.Caja;
import model.Empleados;
import model.HintTextField;
import model.Producto;
import model.RoundedCornerBorder;
import model.Tabla;
import model.TablaPerfiles;
import model.Tabla_Reutilizable;
import utils.FormatoTabla;
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
import java.util.ArrayList;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

import javax.mail.internet.NewsAddress;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Cursor;

public class IntCajaConfiguracion extends JInternalFrame {
 public static DefaultTableModel model=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntCajaConfiguracion frame = new IntCajaConfiguracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Tabla t=new Tabla();
	private JTable tblCaja;
	/**
	 * Create the frame.
	 */
	public IntCajaConfiguracion() {
		model.addColumn("codigo");
		model.addColumn("caja");
		model.addColumn("modificar");
		model.addColumn("eliminar");
		getContentPane().setBackground(Color.WHITE);
		setBounds(0, 68, 1642, 851);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel() {
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
			public void mouseClicked(MouseEvent arg0) {
				JdialogCajaConfNuevo confNuevo=new JdialogCajaConfNuevo();
				confNuevo.setVisible(true);
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setLayout(null);
		panel.setBackground(Color.decode(new clsArial().colorHover));
		panel.setBounds(26, 34, 87, 30);
		getContentPane().add(panel);
		
		JLabel lblNuevo = new JLabel("Nuevo");
		lblNuevo.setBounds(34, 7, 48, 15);
		panel.add(lblNuevo);
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setForeground(Color.WHITE);
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		
		JLabel lbliconoNuevo = new JLabel("");
		lbliconoNuevo.setBounds(10, 5, 23, 22);
		panel.add(lbliconoNuevo);
		new clsArial().modifiedIcon("/iconos/sumar.png", 17, 17, lbliconoNuevo);
		lbliconoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(26, 114, 679, 547);
		getContentPane().add(scrollPane);
		
		tblCaja = new JTable();
		tblCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column = tblCaja.getColumnModel().getColumnIndexAtX(e.getX());
		        int row = e.getY()/tblCaja.getRowHeight();
		        
		        if(row < tblCaja.getRowCount() && row >= 0 && column < tblCaja.getColumnCount() && column >= 0){
		            Object value = tblCaja.getValueAt(row, column);
		            if(value instanceof JButton){
		                ((JButton)value).doClick();
		                JButton boton = (JButton) value;

		                if(boton.getName().equals("m")){
		               	 JdialogEditarProducto j=new JdialogEditarProducto();
		                	JOptionPane.showMessageDialog(null, "entro al modificar");
		                	 
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
		/*esto es solo para darle diseño*/
		FormatoTablaMain.formatoTabla(tblCaja);
		
		/*ahora para agregar el modelo*/
		
		ArrayList<DefaultTableModel>lista=new ArrayList<>();
		lista.add(model);
		
		Tabla_Reutilizable t=new Tabla_Reutilizable();
		t.ver_tabla(tblCaja,  lista,model.getColumnCount());
		
		ArrayList<Caja> listado = new GestionCaja().listado();
		Tabla_Reutilizable.listarCaja(listado);
		/*----------------*/
		scrollPane.setViewportView(tblCaja);
		
		

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
}
