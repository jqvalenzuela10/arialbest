package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.clsArial;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import model.Tabla_Reutilizable;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JdialogNuevoLote2 extends JDialog {
	private JTextField txtLote;
	private JTextField txtProducto;
	public static JTextField txtCantidad;
	private JDateChooser dtmFabricacion;
	private JDateChooser dtmCaducidad;
	public static int cantidadVariable=0;
	public static  int unidadesSinLotes=JdialogEditarProducto.numeroProducto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdialogNuevoLote2 dialog = new JdialogNuevoLote2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdialogNuevoLote2() {
		setModal(true);
		setTitle("Nuevo Lote");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		clsArial clsArial=new clsArial();
		JLabel lblLote = new JLabel("Lote");
		lblLote.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblLote.setBounds(81, 15, 70, 14);
		getContentPane().add(lblLote);
		
		txtLote = new JTextField((String) null);
		txtLote.setColumns(10);
		txtLote.setBounds(81, 40, 248, 30);
		getContentPane().add(txtLote);
		
		JLabel label_1 = new JLabel("Producto");
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(81, 109, 70, 14);
		getContentPane().add(label_1);
		
		txtProducto = new JTextField(JdialogEditarProducto.nombrePro);
		txtProducto.setColumns(10);
		txtProducto.setBounds(81, 134, 423, 30);
		getContentPane().add(txtProducto);
		
		JLabel label = new JLabel("Cantidad");
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(385, 15, 70, 14);
		getContentPane().add(label);
		
	
		cantidadVariable=JdialogEditarProducto.numeroProducto;
		txtCantidad = new JTextField(cantidadVariable+"");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(385, 40, 119, 30);
		getContentPane().add(txtCantidad);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(42, 134, 29, 24);
		clsArial.modifiedIcon("/iconos/product.png", 25, 25, label_2);
		getContentPane().add(label_2);
		
		JLabel Fabricacion = new JLabel("Fabricacion");
		Fabricacion.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Fabricacion.setBounds(50, 198, 70, 14);
		getContentPane().add(Fabricacion);
		
		JLabel Caducidad = new JLabel("Caducidad");
		Caducidad.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Caducidad.setBounds(184, 198, 70, 14);
		getContentPane().add(Caducidad);
		
		dtmFabricacion = new JDateChooser();
		dtmFabricacion.setBounds(50, 223, 95, 20);
		getContentPane().add(dtmFabricacion);
		
		dtmCaducidad = new JDateChooser();
		dtmCaducidad.setBounds(184, 223, 95, 20);
		getContentPane().add(dtmCaducidad);
		
		JLabel lblAceptar = new JLabel("    Aceptar");
		lblAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] filas = new Object[5];
				
				/*para la fecha*/
				Date frabricacion=dtmFabricacion.getDate();
				Date caducidad=dtmCaducidad.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				
			
				String fechaFabricacion=sdf.format(frabricacion).toString();
				String fechaCaducidad=sdf.format(caducidad).toString();
				
				
				filas[0]=txtLote.getText();
				filas[1]=fechaFabricacion;
				filas[2]=fechaCaducidad;
				filas[3]=txtCantidad.getText();
				filas[4]=txtCantidad.getText();
				
				unidadesSinLotes=unidadesSinLotes-Integer.parseInt(txtCantidad.getText());
				JdialogAgregarLotes1.lblUnidadesSinLotes.setText(unidadesSinLotes+"");
				Tabla_Reutilizable.model.addRow(filas);
				dispose();
			}
		});
		lblAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clsArial.modifiedIcon("/iconos/save.png", 20, 20, lblAceptar);
		lblAceptar.setOpaque(true);
		lblAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAceptar.setForeground(Color.WHITE);
		lblAceptar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAceptar.setBorder(new LineBorder(Color.decode("#28a745")));
		lblAceptar.setBackground(new Color(0, 84, 164));
		lblAceptar.setBounds(409, 213, 95, 30);
		getContentPane().add(lblAceptar);
		
		JLabel label_4 = new JLabel("   Cancelar");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clsArial.modifiedIcon("/img/eliminar.png", 20, 20, label_4);
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_4.setBorder(new LineBorder(Color.decode("#28a745")));
		label_4.setBackground(SystemColor.scrollbar);
		label_4.setBounds(302, 213, 95, 30);
		getContentPane().add(label_4);
		setBounds(100, 100, 606, 317);
	}
}
