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

public class IntReportesCobranza extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntReportesCobranza frame = new IntReportesCobranza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Tabla t=new Tabla();
	private JTextField textField;
	private JTextField textField_1;
	private JLabel iconoVistaPrevia;
	private JLabel iconoExel;
	/**
	 * Create the frame.
	 */
	public IntReportesCobranza() {
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		setBounds(0, 68, 1642, 851);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		
		JLabel lblCobranzasPendientes = new JLabel("Cobranzas Pendientes");
		lblCobranzasPendientes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		lblCobranzasPendientes.setBounds(114, 215, 293, 24);
		getContentPane().add(lblCobranzasPendientes);
		
		JCheckBox chckbxTodas = new JCheckBox("General");
		chckbxTodas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxTodas.setBounds(31, 306, 111, 23);
		getContentPane().add(chckbxTodas);
		
		JCheckBox chckbxPorVendedor = new JCheckBox("Por Vendedor");
		chckbxPorVendedor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxPorVendedor.setBounds(31, 348, 111, 23);
		getContentPane().add(chckbxPorVendedor);
		
		JCheckBox chckbxPorAgente = new JCheckBox("Por Agente");
		chckbxPorAgente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxPorAgente.setBounds(31, 394, 111, 23);
		getContentPane().add(chckbxPorAgente);
		
		JCheckBox chckbxMostrarDetalle = new JCheckBox("Mostrar Detalle");
		chckbxMostrarDetalle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxMostrarDetalle.setBounds(31, 499, 136, 23);
		getContentPane().add(chckbxMostrarDetalle);
		
		textField = new JTextField();
		textField.setBounds(241, 397, 331, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 351, 331, 20);
		getContentPane().add(textField_1);
		
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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(31, 485, 594, 1);
		getContentPane().add(panel_1_1);
		
		

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
