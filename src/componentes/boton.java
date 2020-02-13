package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import vista.FrmRegistroCompra;


public class boton extends JButton{

	
public static void  mibotonAgregar(JPanel panel ) {
	
	JLabel texto=new JLabel("Agregar");
	texto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
	texto.setForeground(Color.white);
	texto.setVerticalTextPosition(CENTER);
	
	panel.setBorder(null);
	
	
	panel.setBackground(Color.decode("#28a745"));
	
	panel.setSize(130,30);
	panel.add(texto);
	
	
	

}



}
