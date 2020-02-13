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
import com.toedter.calendar.JDateChooser;
import java.awt.ComponentOrientation;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JCheckBox;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;

public class IntReportesVentas extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntReportesVentas frame = new IntReportesVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Tabla t=new Tabla();
	private JLabel iconoVistaPrevia;
	private JLabel iconoExel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 */
	public IntReportesVentas() {
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		setBounds(0, 68, 1642, 851);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		
		JLabel lblCobranzasPendientes = new JLabel("Ventas");
		lblCobranzasPendientes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		lblCobranzasPendientes.setBounds(114, 215, 293, 24);
		getContentPane().add(lblCobranzasPendientes);
		
		JCheckBox chckbxMostrarDetalle = new JCheckBox("Mostrar Detalle de cada Venta");
		chckbxMostrarDetalle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		chckbxMostrarDetalle.setBounds(31, 567, 246, 23);
		getContentPane().add(chckbxMostrarDetalle);
		
		iconoVistaPrevia = new JLabel("");
		iconoVistaPrevia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconoVistaPrevia.setHorizontalAlignment(SwingConstants.CENTER);
		iconoVistaPrevia.setBounds(44, 64, 50, 50);
	     new clsArial().modifiedIcon("/img/vista_previa.png", 60, 60, iconoVistaPrevia);
		getContentPane().add(iconoVistaPrevia);
		
		iconoExel = new JLabel("");
		iconoExel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconoExel.setHorizontalAlignment(SwingConstants.CENTER);
		iconoExel.setBounds(152, 64, 50, 50);
		new clsArial().modifiedIcon("/iconos/exel.png", 50, 50, iconoExel);
		getContentPane().add(iconoExel);
		
		JLabel lblExcel = new JLabel("Previa");
		lblExcel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblExcel.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcel.setBounds(44, 125, 46, 14);
		getContentPane().add(lblExcel);
		
		JLabel lblExcel_1 = new JLabel("Excel");
		lblExcel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcel_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblExcel_1.setBounds(156, 125, 46, 14);
		getContentPane().add(lblExcel_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(127, 304, 136, 20);
		getContentPane().add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Fecha Inicial");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(31, 308, 96, 14);
		getContentPane().add(lblNewLabel);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(378, 304, 136, 20);
		getContentPane().add(dateChooser_1);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblFechaFinal.setBounds(294, 308, 74, 14);
		getContentPane().add(lblFechaFinal);
		
		JCheckBox chckbxPorCategoria = new JCheckBox("Por Cliente");
		chckbxPorCategoria.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		chckbxPorCategoria.setBounds(31, 396, 143, 23);
		getContentPane().add(chckbxPorCategoria);
		
		JCheckBox chckbxPorLinea = new JCheckBox("Por Linea");
		chckbxPorLinea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		chckbxPorLinea.setBounds(31, 430, 143, 23);
		getContentPane().add(chckbxPorLinea);
		
		JCheckBox chckbxPorMarca = new JCheckBox("Por Marca");
		chckbxPorMarca.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		chckbxPorMarca.setBounds(31, 466, 143, 23);
		getContentPane().add(chckbxPorMarca);
		
		JCheckBox chckbxPorProducto = new JCheckBox("General");
		chckbxPorProducto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		chckbxPorProducto.setBounds(31, 361, 143, 23);
		getContentPane().add(chckbxPorProducto);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(31, 540, 594, 1);
		getContentPane().add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1_1.setBounds(31, 335, 594, 1);
		getContentPane().add(panel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(211, 396, 417, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(211, 430, 417, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(211, 466, 417, 20);
		getContentPane().add(textField_2);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBackground(Color.LIGHT_GRAY);
		panel_1_1_2.setBounds(31, 618, 594, 1);
		getContentPane().add(panel_1_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fecha", "Cliente", "Total"}));
		comboBox.setBounds(151, 650, 129, 20);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Ascendente", "Descendente"}));
		comboBox_1.setBounds(309, 650, 129, 20);
		getContentPane().add(comboBox_1);
		
		JCheckBox chckbxPorVendedor = new JCheckBox("Por Vendedor");
		chckbxPorVendedor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		chckbxPorVendedor.setBounds(31, 505, 143, 23);
		getContentPane().add(chckbxPorVendedor);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(211, 505, 417, 20);
		getContentPane().add(textField_3);
		
		JCheckBox chckbxOrdenarPor = new JCheckBox("Ordenar Por");
		chckbxOrdenarPor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		chckbxOrdenarPor.setBounds(31, 647, 143, 23);
		getContentPane().add(chckbxOrdenarPor);
		
		

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
