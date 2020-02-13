package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import mantenimientos.GestionClientes;
import model.Clientes;
import utils.FormatoTablaMain;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmBuscarLClienteCotizacion extends JDialog {
	private JTable tblCliente;
	DefaultTableModel model =new DefaultTableModel() {
		public boolean isCellEditable(int filas,int columnas) {
			
			if(columnas==3) {
				return true;
			}
			else {
				return false;
			}
		}
	};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmBuscarLClienteCotizacion dialog = new FrmBuscarLClienteCotizacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmBuscarLClienteCotizacion() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				listar();
			}
		});
		
		model.setRowCount(0);
		model.setColumnCount(0);
		model.addColumn("Codigo");
	
		model.addColumn("nombre comercial");
	model.addColumn("forma pago");
	
	
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado de Cliente");
		lblNewLabel.setBounds(189, 24, 90, 14);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(39, 48, 411, 2);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/user.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
		label.setBounds(294, 24, 30, 20);
		getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 110, 288, 322);
		getContentPane().add(scrollPane);
		
		tblCliente = new JTable();
		tblCliente.setCellSelectionEnabled(true);
		tblCliente.setFillsViewportHeight(true);
		tblCliente.setFocusTraversalKeysEnabled(false);
		
		FormatoTablaMain.formatoTabla(tblCliente);
		
		tblCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				
				
					
					int fila=tblCliente.getSelectedRow();
					JdialogCotizacion.lblCodigoCli.setText(""+tblCliente.getValueAt(fila, 0));
					JdialogCotizacion.txtCliente.setText(""+tblCliente.getValueAt(fila, 1));
					
					dispose();
				
			}
		});
		scrollPane.setViewportView(tblCliente);
		tblCliente.setModel(model);
		setBounds(100, 100, 506, 497);
		TableColumn col = tblCliente.getColumnModel().getColumn(0);
		col.setPreferredWidth(10);
	}
	/*listado en la tabla cliente*/
	void listar() {
		ArrayList<Clientes> listado=new GestionClientes().listado();
		model.getDataVector().removeAllElements();
		for (Clientes cl : listado) {
			
			Object o[]= {cl.getId_cli(),cl.getNom_comercial(),cl.getFormaPago_cli()
					};
			model.addRow(o);
		}
		
	}
}
