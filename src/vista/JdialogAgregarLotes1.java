package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import componentes.boton;
import mantenimientos.GestionLotes;
import model.Lotes;
import model.Tabla_Reutilizable;
import utils.FormatoTabla;
import utils.FormatoTablaMain;
import utils.clsArial;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Cursor;

public class JdialogAgregarLotes1 extends JDialog {
	private JTextField txtDescripcion;
	private JTextField txtCantidad;
	private JLabel lblAgregar;
	private JLabel lblEliminar;
	private JTable tblLotes;
	public static DefaultTableModel model=new DefaultTableModel();
	private JLabel lblCan;
	public static JLabel lbla;
	public static JLabel lblUnidadesSinLotes;
	private JLabel lblCodigoPro;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdialogAgregarLotes1 dialog = new JdialogAgregarLotes1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdialogAgregarLotes1() {
		setModal(true);
		setTitle("Lote");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		
		model.addColumn("Nº Lote");
		model.addColumn("Fecha Produccion");
		model.addColumn("Fecha Caducidad");
		model.addColumn("Existencia Inicial");
		model.addColumn("Existencia Actual");
		JLabel lblNewLabel = new JLabel("");
		clsArial clsArial=new clsArial();
		clsArial.modifiedIcon("/iconos/product.png", 25, 25, lblNewLabel);
		lblNewLabel.setBounds(38, 40, 29, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblProdcuto = new JLabel("Producto");
		lblProdcuto.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblProdcuto.setBounds(80, 11, 70, 14);
		getContentPane().add(lblProdcuto);
		
		txtDescripcion = new JTextField(JdialogEditarProducto.nombrePro);
		txtDescripcion.setBounds(77, 40, 387, 30);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCantidad.setBounds(80, 91, 70, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField(JdialogEditarProducto.numeroProducto+"");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(77, 120, 327, 30);
		getContentPane().add(txtCantidad);
		
		lblAgregar = new JLabel("");
		lblAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JdialogNuevoLote2 j=new JdialogNuevoLote2();
				j.setVisible(true);
				j.setLocationRelativeTo(null);
			}
		});
		lblAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAgregar.setOpaque(true);
		lblAgregar.setBackground(Color.WHITE);
		clsArial.modifiedIcon("/iconos/more.png", 25, 25, lblAgregar);
		lblAgregar.setBounds(425, 120, 29, 30);
		getContentPane().add(lblAgregar);
		
		lblEliminar = new JLabel("");
		lblEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEliminar.setBackground(Color.WHITE);
		clsArial.modifiedIcon("/iconos/borrar.png", 37, 37, lblEliminar);
		lblEliminar.setOpaque(true);
		lblEliminar.setBounds(458, 120, 34, 30);
		getContentPane().add(lblEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(38, 179, 468, 165);
		getContentPane().add(scrollPane);
		
		tblLotes = new JTable();
	
	FormatoTablaMain.formatoTabla(tblLotes);
	ArrayList<DefaultTableModel>lista=new ArrayList<>();
	lista.add(model);
	

	
	Tabla_Reutilizable t=new Tabla_Reutilizable();
	t.ver_tabla(tblLotes,  lista,model.getColumnCount());
	
	
	
		scrollPane.setViewportView(tblLotes);
		
		lblCan = new JLabel("");
		lblCan.setBounds(38, 120, 29, 24);
		clsArial.modifiedIcon("/iconos/cantidad.png", 25, 25, lblCan);
		getContentPane().add(lblCan);
		
		lbla = new JLabel("Unidades Sin Lote");
		lbla.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbla.setBounds(38, 367, 112, 14);
		getContentPane().add(lbla);
		int unidadesSinLotes=JdialogEditarProducto.numeroProducto;
		lblUnidadesSinLotes = new JLabel(unidadesSinLotes+"");
		lblUnidadesSinLotes.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		lblUnidadesSinLotes.setBounds(154, 367, 51, 14);
		getContentPane().add(lblUnidadesSinLotes);
			
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				agregar();
				JdialogEditarProducto.actualizar();
			}
		});
		panel.setBounds(371, 355, 131, 30);
		boton.mibotonAgregar(panel);
		getContentPane().add(panel);
		
		lblCodigoPro = new JLabel(JdialogEditarProducto.codProducto+"");
		lblCodigoPro.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCodigoPro.setBounds(472, 40, 34, 30);
		getContentPane().add(lblCodigoPro);
		setBounds(100, 100, 540, 449);
	}
	ArrayList<Lotes> listado=new ArrayList<>();
	void agregar() {
		int codLote,existenciaInicial,existenciaActual,idPro;
		String fechaProduccion,fechaCaducidad;
		
		
		
		
		for(int i=0;i<tblLotes.getRowCount();i++) {
			Lotes l=new Lotes();
			codLote=Integer.parseInt(tblLotes.getValueAt(i, 0).toString());
			fechaProduccion=tblLotes.getValueAt(i, 1).toString();
			fechaCaducidad=tblLotes.getValueAt(i, 2).toString();
			existenciaInicial=Integer.parseInt(tblLotes.getValueAt(i, 3).toString());
			existenciaActual=Integer.parseInt(tblLotes.getValueAt(i, 4).toString());
			idPro=Integer.parseInt(lblCodigoPro.getText());
			
			l.setCod_lote(codLote);
			l.setFecha_produccion(fechaProduccion);
			l.setFecha_caducidad(fechaCaducidad);
			l.setExistenciaInicial(existenciaInicial);
			l.setExistenciaActual(existenciaActual);
			l.setIdPro(idPro);
			listado.add(l);
			
			
		}	
		
		int ok=new GestionLotes().registrar(listado);
		if(ok!=0) {
			JOptionPane.showMessageDialog(null, "registro exitoso");
		}
		else {
			JOptionPane.showMessageDialog(null, "no registro :c");
		}
	}
}
