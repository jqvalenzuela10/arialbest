package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCaja;
import mantenimientos.GestionProductos;
import model.Caja;
import model.Producto;
import model.Tabla_Reutilizable;
import utils.FormatoTablaMain;

import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JdialogCambiarCaja extends JDialog {
	private JTable table;
	DefaultTableModel model=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogCambiarCaja dialog = new JdialogCambiarCaja();
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
	public JdialogCambiarCaja() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				listar();
			}
		});
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		model.addColumn("codigo");
		model.addColumn("nombre caja");
		model.addColumn("saldo");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 385, 159);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila=table.getSelectedRow();
				int codigo=Integer.parseInt(table.getValueAt(fila, 0).toString());
				String caja=(String) table.getValueAt(fila, 1);
				String saldo=table.getValueAt(fila, 2).toString();
				
				FrmMenuPrincipal.lblCodCaja.setText(codigo+"");
				FrmMenuPrincipal.lblCaja_1.setText(caja);
			FrmMenuPrincipal.lblSaldo.setText(saldo);
				dispose();
				
			}
		});
		
		FormatoTablaMain.formatoTabla(table);
table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		
		
		
		setTitle("Seleccionar Caja");
		setBounds(100, 100, 421, 252);
		setLocationRelativeTo(null);
		setModal(true);

	}
	void listar() {
		ArrayList<Caja> lista=new GestionCaja().listado();
	
		for (Caja c : lista) {
			
			Object datos[]={c.getCodCaja(),c.getNomCaja(),c.getSaldo()};
			model.addRow(datos);
		}
	}
}
