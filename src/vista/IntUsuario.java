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

import mantenimientos.GestionEmpledos;
import model.Empleados;
import model.HintTextField;
import model.RoundedCornerBorder;
import model.Tabla;
import model.TablaPerfiles;
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
import java.awt.Cursor;

public class IntUsuario extends JInternalFrame {
	private JTable tblUsuarios;
	clsArial clsIcono=new clsArial();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntUsuario frame = new IntUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Tabla t=new Tabla();
	private JTextField txtBusqUsu;
	/**
	 * Create the frame.
	 */
	public IntUsuario() {
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		setBounds(0, 68, 1642, 806);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 203, 1467, 550);
		getContentPane().add(scrollPane);
		
		tblUsuarios = new JTable();
		t.ver_tabla(tblUsuarios);
		tblUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				 int column = tblUsuarios.getColumnModel().getColumnIndexAtX(e.getX());
			        int row = e.getY()/tblUsuarios.getRowHeight();
			        
			        if(row < tblUsuarios.getRowCount() && row >= 0 && column < tblUsuarios.getColumnCount() && column >= 0){
			            Object value = tblUsuarios.getValueAt(row, column);
			            if(value instanceof JButton){
			                ((JButton)value).doClick();
			                JButton boton = (JButton) value;

			                if(boton.getName().equals("m")){
			                	
			                
			                  
			                	 JdialogEditarUsu editarUsu=new JdialogEditarUsu();
			                  /*eNVIANDO DATOS DEL USUARIO PARA EDITAR*/
			                  int fila1 = tblUsuarios.getSelectedRow();
			                  System.out.println("el codigo el modficar es :"+tblUsuarios.getValueAt(fila1, 0).toString());
			                  JdialogEditarUsu.txtIdUsu.setText(tblUsuarios.getValueAt(fila1, 0).toString());
			                  JdialogEditarUsu.txtNomUsu.setText(tblUsuarios.getValueAt(fila1, 1).toString());
			                  JdialogEditarUsu.txtApellidoPat.setText(tblUsuarios.getValueAt(fila1, 2).toString());
			                  JdialogEditarUsu.txtApeMat.setText(tblUsuarios.getValueAt(fila1, 3).toString());
			    				//sex_emp=tblUsuarios.getValueAt(fila1, 4).toString();
			                  JdialogEditarUsu.txtEmail.setText(tblUsuarios.getValueAt(fila1, 5).toString());
			                  JdialogEditarUsu.txtSueldo.setText( tblUsuarios.getValueAt(fila1,6).toString());
			    				//estado_emp=tblUsuarios.getValueAt(fila1, 7).toString();
			                  JdialogEditarUsu.txtDirecUsu.setText(tblUsuarios.getValueAt(fila1, 8).toString());
			                  JdialogEditarUsu.txtTelf.setText(tblUsuarios.getValueAt(fila1, 9).toString());
			                  JdialogEditarUsu.txtCell.setText(tblUsuarios.getValueAt(fila1, 10).toString());
			                  JdialogEditarUsu.txtDniUsu.setText(tblUsuarios.getValueAt(fila1, 11).toString());
			                  JdialogEditarUsu.txtLogeo.setText(tblUsuarios.getValueAt(fila1, 12).toString());
			                  JdialogEditarUsu.txtPswUsu.setText(tblUsuarios.getValueAt(fila1, 13).toString());
			    			//	id_tip_emp=tblUsuarios.getValueAt(fila1, 9).toString();
			                  
			                 /*----PRIVILEGIOS DEL USUARIO ----*/ 
			                  ArrayList<Empleados> list=new GestionEmpledos().privilegios(tblUsuarios.getValueAt(fila1, 0).toString());
			          		for (Empleados cl : list) {
			          		
			          			if ("ventas".equals(cl.getNom_privilegio())) {
			          				
			          				JdialogEditarUsu.chckbxVentas.setSelected(cl.isEstadoPrivilegio());
			          			}
			                      if ("compras".equals(cl.getNom_privilegio())) {
			          				
			                    	  JdialogEditarUsu.chckbxCompras.setSelected(cl.isEstadoPrivilegio());
			          			}
			                      if ("usuarios".equals(cl.getNom_privilegio())) {
			          				
			                    	  JdialogEditarUsu.chckbxUsuarios.setSelected(cl.isEstadoPrivilegio());
			          			}
			                     if ("almacen".equals(cl.getNom_privilegio())) {
			          				
			                    	 JdialogEditarUsu.chckbxAlmacn.setSelected(cl.isEstadoPrivilegio());
			          			}

			          		}
			          	 
		                  editarUsu.setVisible(true);
			                  
			                }
			                if(boton.getName().equals("e")){
			                	int fila1 = tblUsuarios.getSelectedRow();
			                	System.out.println("en eliminar es :"+tblUsuarios.getValueAt(fila1, 0).toString());
			    				String id=tblUsuarios.getValueAt(fila1, 0).toString();	// <-- SE CAPTURA DNI DE LA FILA PA ELIMINAR
			    			
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
		scrollPane.setViewportView(tblUsuarios);
		
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
		txtBusqUsu.setBounds(543, 90, 541, 35);
		getContentPane().add(txtBusqUsu);
		txtBusqUsu.setColumns(10);
		
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
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JdialogRegistroUsuario registroUsuario=new JdialogRegistroUsuario();
				registroUsuario.setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.setBackground(new Color(35, 43, 55));
		panel.setBounds(1480, 95, 87, 30);
		getContentPane().add(panel);
		
		JLabel lblNuevo = new JLabel("Nuevo");
		lblNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevo.setForeground(Color.WHITE);
		lblNuevo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lblNuevo.setBounds(34, 7, 48, 15);
		panel.add(lblNuevo);
		
		JLabel lbliconoNuevo = new JLabel("");
		lbliconoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/iconos/sumar.png", 17, 17, lbliconoNuevo);
		lbliconoNuevo.setBounds(10, 5, 23, 22);
		panel.add(lbliconoNuevo);
		

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
