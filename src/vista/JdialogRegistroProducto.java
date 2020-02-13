package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import model.HintTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Cursor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class JdialogRegistroProducto extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JdialogRegistroProducto dialog = new JdialogRegistroProducto();
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
	public JdialogRegistroProducto() {
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 13));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1037, 834);
		getContentPane().setLayout(null);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setForeground(new Color(15, 149, 236));
		lblClave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblClave.setBounds(129, 139, 143, 14);
		getContentPane().add(lblClave);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBackground(new Color(247, 249, 249));
		panel.setBounds(129, 156, 193, 40);
		getContentPane().add(panel);
		
		HintTextField hintTextField = new HintTextField("Clave");
		hintTextField.setColumns(10);
		hintTextField.setBorder(null);
		hintTextField.setBackground(new Color(247, 249, 249));
		hintTextField.setBounds(59, 4, 124, 32);
		panel.add(hintTextField);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(3, 4, 42, 32);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(48, 0, 1, 49);
		panel.add(panel_1);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(new Color(15, 149, 236));
		lblDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDescripcion.setBounds(129, 224, 143, 14);
		getContentPane().add(lblDescripcion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_2.setBackground(new Color(247, 249, 249));
		panel_2.setBounds(129, 242, 849, 40);
		getContentPane().add(panel_2);
		
		HintTextField hintTextField_1 = new HintTextField("Descripcion");
		hintTextField_1.setColumns(10);
		hintTextField_1.setBorder(null);
		hintTextField_1.setBackground(new Color(247, 249, 249));
		hintTextField_1.setBounds(59, 4, 124, 32);
		panel_2.add(hintTextField_1);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(3, 4, 42, 32);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(48, 0, 1, 49);
		panel_2.add(panel_3);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(new Color(15, 149, 236));
		lblCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCategoria.setBounds(785, 137, 143, 14);
		getContentPane().add(lblCategoria);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_4.setBackground(new Color(247, 249, 249));
		panel_4.setBounds(785, 156, 193, 40);
		getContentPane().add(panel_4);
		
		HintTextField hintTextField_2 = new HintTextField("Categoria");
		hintTextField_2.setColumns(10);
		hintTextField_2.setBorder(null);
		hintTextField_2.setBackground(new Color(247, 249, 249));
		hintTextField_2.setBounds(59, 4, 124, 32);
		panel_4.add(hintTextField_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(3, 4, 42, 32);
		panel_4.add(label_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(48, 0, 1, 49);
		panel_4.add(panel_5);
		
		JLabel lblPrecioCompra = new JLabel("Precio Compra");
		lblPrecioCompra.setForeground(new Color(15, 149, 236));
		lblPrecioCompra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPrecioCompra.setBounds(129, 329, 143, 14);
		getContentPane().add(lblPrecioCompra);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_6.setBackground(new Color(247, 249, 249));
		panel_6.setBounds(129, 348, 193, 40);
		getContentPane().add(panel_6);
		
		HintTextField hintTextField_3 = new HintTextField("");
		hintTextField_3.setColumns(10);
		hintTextField_3.setBorder(null);
		hintTextField_3.setBackground(new Color(247, 249, 249));
		hintTextField_3.setBounds(59, 4, 124, 32);
		panel_6.add(hintTextField_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(3, 4, 42, 32);
		panel_6.add(label_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(48, 0, 1, 49);
		panel_6.add(panel_7);
		
		JLabel lblDatosProducto = new JLabel("Datos Producto");
		lblDatosProducto.setForeground(Color.BLACK);
		lblDatosProducto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDatosProducto.setBounds(129, 114, 143, 14);
		getContentPane().add(lblDatosProducto);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(new Color(15, 149, 236));
		lblMarca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMarca.setBounds(446, 139, 143, 14);
		getContentPane().add(lblMarca);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_10.setBackground(new Color(247, 249, 249));
		panel_10.setBounds(446, 156, 193, 40);
		getContentPane().add(panel_10);
		
		HintTextField hintTextField_5 = new HintTextField("Marca");
		hintTextField_5.setColumns(10);
		hintTextField_5.setBorder(null);
		hintTextField_5.setBackground(new Color(247, 249, 249));
		hintTextField_5.setBounds(59, 4, 124, 32);
		panel_10.add(hintTextField_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(3, 4, 42, 32);
		panel_10.add(label_6);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.LIGHT_GRAY);
		panel_11.setBounds(48, 0, 1, 49);
		panel_10.add(panel_11);
		
		JLabel lblPrecioDeCompra = new JLabel("Precio Compra Sin Impuestos");
		lblPrecioDeCompra.setForeground(new Color(15, 149, 236));
		lblPrecioDeCompra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPrecioDeCompra.setBounds(376, 329, 214, 14);
		getContentPane().add(lblPrecioDeCompra);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_12.setBackground(new Color(247, 249, 249));
		panel_12.setBounds(376, 348, 193, 40);
		getContentPane().add(panel_12);
		
		HintTextField hintTextField_6 = new HintTextField("");
		hintTextField_6.setColumns(10);
		hintTextField_6.setBorder(null);
		hintTextField_6.setBackground(new Color(247, 249, 249));
		hintTextField_6.setBounds(59, 4, 124, 32);
		panel_12.add(hintTextField_6);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(3, 4, 42, 32);
		panel_12.add(label_2);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.LIGHT_GRAY);
		panel_13.setBounds(48, 0, 1, 49);
		panel_12.add(panel_13);
		
		JLabel lblUtilidad = new JLabel("% Utilidad");
		lblUtilidad.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblUtilidad.setBounds(130, 478, 82, 32);
		getContentPane().add(lblUtilidad);
		
		JLabel lblPrecioVenta_1 = new JLabel("Precio Venta");
		lblPrecioVenta_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPrecioVenta_1.setBounds(129, 533, 113, 29);
		getContentPane().add(lblPrecioVenta_1);
		
		JLabel lblPrecioVenta_2 = new JLabel("Precio Venta Neto ");
		lblPrecioVenta_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPrecioVenta_2.setBounds(129, 586, 125, 32);
		getContentPane().add(lblPrecioVenta_2);
		
		JLabel lblPrecio = new JLabel("Precio1");
		lblPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblPrecio.setBounds(278, 442, 70, 14);
		getContentPane().add(lblPrecio);
		
		textField = new JTextField();
		textField.setBackground(new Color(247, 249, 249));
		textField.setBounds(278, 481, 198, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(247, 249, 249));
		textField_1.setBounds(278, 533, 198, 32);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(247, 249, 249));
		textField_2.setBounds(278, 586, 198, 32);
		getContentPane().add(textField_2);
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/save.png"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		
		JLabel lblGuardar = new JLabel("    Guardar");
		lblGuardar.setIcon(ico);
		lblGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGuardar.setOpaque(true);
		lblGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardar.setForeground(Color.WHITE);
		lblGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblGuardar.setBorder(new LineBorder(Color.decode("#28a745")));
		lblGuardar.setBackground(Color.decode("#0054a4"));
		lblGuardar.setBounds(569, 689, 143, 40);
		getContentPane().add(lblGuardar);
		
		JLabel lblCancelar = new JLabel("   Cancelar");
		lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImageIcon iconSearchs1 = new ImageIcon(getClass().getResource("/img/eliminar.png"));
		Image is1 = iconSearchs1.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico1 = new ImageIcon(is1);
		lblCancelar.setIcon(ico1);
		lblCancelar.setOpaque(true);
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setForeground(Color.black);
		lblCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCancelar.setBorder(new LineBorder(Color.decode("#28a745")));
		lblCancelar.setBackground(Color.decode("#c8c8c8"));
		lblCancelar.setBounds(376, 689, 143, 40);
		getContentPane().add(lblCancelar);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel_8.setBackground(new Color(45, 54, 63));
		panel_8.setBounds(0, 0, 1021, 90);
		getContentPane().add(panel_8);
		
		JLabel lblNuevoProducto = new JLabel("Nuevo Producto");
		lblNuevoProducto.setForeground(Color.WHITE);
		lblNuevoProducto.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNuevoProducto.setBounds(198, 0, 176, 90);
		panel_8.add(lblNuevoProducto);
		
		JLabel label_7 = new JLabel("");
		ImageIcon iconSearchs2 = new ImageIcon(getClass().getResource("/iconos/Productos.png"));
		Image is2 = iconSearchs2.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
		Icon ico2 = new ImageIcon(is2);
		label_7.setIcon(ico2);
		
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(114, 0, 74, 90);
		panel_8.add(label_7);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 90, 59, 705);
		getContentPane().add(panel_9);
		panel_9.setLayout(null);
		ImageIcon iconSearchs3 = new ImageIcon(getClass().getResource("/iconos/information.png"));
		Image is3 = iconSearchs3.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico3 = new ImageIcon(is3);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 0, 59, 55);
		panel_9.add(panel_14);
		
		JLabel lblProducto = new JLabel("");
		panel_14.add(lblProducto);
		lblProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblProducto.setIcon(ico3);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(0, 66, 59, 55);
		panel_9.add(panel_15);
		
		JLabel lblLotes = new JLabel("");
		ImageIcon iconSearchs4 = new ImageIcon(getClass().getResource("/iconos/lotes.png"));
		Image is4 = iconSearchs4.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico4 = new ImageIcon(is4);
		lblLotes.setIcon(ico4);
		lblLotes.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel_15.add(lblLotes);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(0, 130, 59, 55);
		panel_9.add(panel_16);
		
		JLabel lblPicture = new JLabel("");
		ImageIcon iconSearchs5 = new ImageIcon(getClass().getResource("/iconos/picture.png"));
		Image is5 = iconSearchs5.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico5 = new ImageIcon(is5);
		lblPicture.setIcon(ico5);
		lblPicture.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel_16.add(lblPicture);

	}
	
	void acomodarImagen(String ruta,int ancho,int alto,JLabel label) {
		ImageIcon iconSearchs2 = new ImageIcon(getClass().getResource(ruta));
		Image is2 = iconSearchs2.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		Icon ico2 = new ImageIcon(is2);
		label.setIcon(ico2);
	}

}
