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
import utils.FocusJpanel;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Cursor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JDesktopPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroProducto extends JDialog {
	private JDesktopPane dkRegisProdu;
	private JPanel panelDatosProdu;
	ArrayList<JPanel>lista;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroProducto dialog = new RegistroProducto();
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
	public RegistroProducto() {
		
		dkRegisProdu = new JDesktopPane();
		dkRegisProdu.setBackground(Color.WHITE);
		dkRegisProdu.setBounds(57, 90, 964, 705);
		getContentPane().add(dkRegisProdu);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				/*para cambiar de internal*/
				dkRegisProdu.removeAll();
				dkRegisProdu.repaint();
				IntRegisProduDatos compra=new IntRegisProduDatos();
				dkRegisProdu.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
				
			}
		});
		setModal(true);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 13));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1037, 834);
		getContentPane().setLayout(null);
		ImageIcon iconSearchs = new ImageIcon(getClass().getResource("/iconos/save.png"));
		Image is = iconSearchs.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico = new ImageIcon(is);
		ImageIcon iconSearchs1 = new ImageIcon(getClass().getResource("/img/eliminar.png"));
		Image is1 = iconSearchs1.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico1 = new ImageIcon(is1);
		
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
		
		panelDatosProdu = new JPanel();
		
		panelDatosProdu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				/*para cambiar de internal*/
				dkRegisProdu.removeAll();
				dkRegisProdu.repaint();
				IntRegisProduDatos compra=new IntRegisProduDatos();
				dkRegisProdu.add(compra);
				try {
					compra.setMaximum(true);
					compra.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					compra.show(); 
					
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		panelDatosProdu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelDatosProdu.setBounds(0, 0, 59, 55);
		panel_9.add(panelDatosProdu);
		
		JLabel lblProducto = new JLabel("");
		panelDatosProdu.add(lblProducto);
		lblProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblProducto.setIcon(ico3);
		ImageIcon iconSearchs4 = new ImageIcon(getClass().getResource("/iconos/lotes.png"));
		Image is4 = iconSearchs4.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico4 = new ImageIcon(is4);
		ImageIcon iconSearchs5 = new ImageIcon(getClass().getResource("/iconos/picture.png"));
		Image is5 = iconSearchs5.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		Icon ico5 = new ImageIcon(is5);
		
	

	}
	
	void acomodarImagen(String ruta,int ancho,int alto,JLabel label) {
		ImageIcon iconSearchs2 = new ImageIcon(getClass().getResource(ruta));
		Image is2 = iconSearchs2.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		Icon ico2 = new ImageIcon(is2);
		label.setIcon(ico2);
	}
}
