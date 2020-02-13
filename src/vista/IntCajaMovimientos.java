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
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Cursor;

public class IntCajaMovimientos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntCajaMovimientos frame = new IntCajaMovimientos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Tabla t=new Tabla();
	private JTextField textField;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public IntCajaMovimientos() {
		getContentPane().setBackground(Color.decode("#ebf0f4"));
		setBounds(0, 68, 1642, 851);
		setBorder(null);
		/*-----BORDE SUPERIOR DISABLE ----*/
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		/*-----------------------------------------------------------------------------*/
		
		getContentPane().setLayout(null);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/iconos/sumar.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		
		JPanel pnlRegistroMovCaja = new JPanel();
		pnlRegistroMovCaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlRegistroMovCaja.setLayout(null);
		pnlRegistroMovCaja.setBackground(new Color(45, 54, 63));
		pnlRegistroMovCaja.setBounds(10, 11, 378, 802);
		getContentPane().add(pnlRegistroMovCaja);
		
		JLabel lblHoy = new JLabel("Movimiento de Caja");
		lblHoy.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoy.setForeground(new Color(240, 240, 240, 240));
		lblHoy.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblHoy.setBounds(92, 22, 204, 37);
		pnlRegistroMovCaja.add(lblHoy);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 83, 378, 719);
		pnlRegistroMovCaja.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMovimiento = new JLabel("Movimiento :");
		lblMovimiento.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblMovimiento.setBounds(45, 37, 102, 14);
		panel_1.add(lblMovimiento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Entrada", "Salida"}));
		comboBox.setBounds(153, 35, 129, 20);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Cheque"}));
		comboBox_1.setBounds(153, 93, 129, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTipo.setBounds(45, 92, 41, 20);
		panel_1.add(lblTipo);
		
		JLabel lblMonto = new JLabel("Monto :");
		lblMonto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblMonto.setBounds(45, 156, 58, 14);
		panel_1.add(lblMonto);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		textField.setBounds(153, 150, 129, 27);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblComentario = new JLabel("Comentario :");
		lblComentario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblComentario.setBounds(10, 246, 122, 14);
		panel_1.add(lblComentario);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 283, 358, 231);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lbliconMonto = new JLabel("");
		lbliconMonto.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/billete.png", 25, 25, lbliconMonto);
		lbliconMonto.setBounds(7, 153, 28, 22);
		panel_1.add(lbliconMonto);
		
		JPanel panel_3 = new JPanel() {
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
		panel_3.setBackground(Color.decode(new clsArial().colorHover));
		panel_3.setBounds(97, 581, 190, 43);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblT = new JLabel("Aceptar");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setBounds(28, 9, 133, 28);
		panel_3.add(lblT);
		lblT.setForeground(SystemColor.menu);
		lblT.setFont(new Font("Segoe UI", Font.BOLD, 17));
		
		JLabel lblPen = new JLabel("PEN");
		lblPen.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblPen.setBounds(333, 156, 35, 14);
		panel_1.add(lblPen);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/bandera.png", 20	, 17, label_1);
		label_1.setBounds(292, 153, 34, 22);
		panel_1.add(label_1);
		
		JLabel lbliconTipo = new JLabel("");
		lbliconTipo.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/tipo.png", 25, 25, lbliconTipo);
		lbliconTipo.setBounds(7, 93, 28, 22);
		panel_1.add(lbliconTipo);
		
		JLabel lbliconMovimiento = new JLabel("");
		lbliconMovimiento.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/movimiento.png", 25, 25, lbliconMovimiento);
		lbliconMovimiento.setBounds(7, 37, 28, 22);
		panel_1.add(lbliconMovimiento);
		
		JPanel pnlConsultMovCaja = new JPanel();
		pnlConsultMovCaja.setBackground(Color.WHITE);
		pnlConsultMovCaja.setBounds(417, 11, 1215, 802);
		getContentPane().add(pnlConsultMovCaja);
		pnlConsultMovCaja.setLayout(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_2.setBounds(68, 133, 169, 20);
		pnlConsultMovCaja.add(comboBox_2);
		
		JLabel lblCaja = new JLabel("Caja :");
		lblCaja.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCaja.setBounds(10, 134, 58, 18);
		pnlConsultMovCaja.add(lblCaja);
		
		table = new JTable();
		table.setBounds(10, 187, 1195, 594);
		pnlConsultMovCaja.add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(45, 54, 63));
		panel_2.setBounds(0, 0, 1215, 81);
		pnlConsultMovCaja.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblExcel_1 = new JLabel("Excel");
		lblExcel_1.setForeground(new Color(240, 240, 240, 240));
		lblExcel_1.setBounds(122, 61, 46, 14);
		panel_2.add(lblExcel_1);
		lblExcel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblExcel = new JLabel("Previa");
		lblExcel.setForeground(new Color(240, 240, 240, 240));
		lblExcel.setBounds(10, 61, 46, 14);
		panel_2.add(lblExcel);
		lblExcel.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lbliconPdf = new JLabel("PDF");
		lbliconPdf.setForeground(new Color(240, 240, 240, 240));
		lbliconPdf.setBounds(227, 61, 46, 14);
		panel_2.add(lbliconPdf);
		lbliconPdf.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconPdf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel iconoPdf = new JLabel("");
		iconoPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		new clsArial().modifiedIcon("/img/pdf.png", 40	, 40, iconoPdf);
		iconoPdf.setBounds(223, 11, 50, 50);
		panel_2.add(iconoPdf);
		iconoPdf.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel iconoExel = new JLabel("");
		iconoExel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		new clsArial().modifiedIcon("/iconos/exel.png", 45, 45, iconoExel);
		iconoExel.setBounds(118, 11, 50, 50);
		panel_2.add(iconoExel);
		iconoExel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel iconoVistaPrevia = new JLabel("");
		iconoVistaPrevia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconoVistaPrevia.setBounds(10, 11, 50, 50);
		panel_2.add(iconoVistaPrevia);
		iconoVistaPrevia.setHorizontalAlignment(SwingConstants.CENTER);
		new clsArial().modifiedIcon("/img/vista_previa.png", 45, 45, iconoVistaPrevia);
		

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
