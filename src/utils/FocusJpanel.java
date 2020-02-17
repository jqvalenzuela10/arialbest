package utils;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class FocusJpanel {

	
	public static void lanzarFoco(JPanel encendido,ArrayList<JPanel> listaApagado) {
		encendido.setVisible(true);
		
		for (JPanel jLabel : listaApagado) {
			jLabel.setVisible(false);
		}
	}
	
	public static void cambiarFondo(JPanel encendido,ArrayList<JPanel> listaApagado) {
		encendido.setBackground(Color.decode("#9CA5B8"));
		
		for (JPanel jLabel : listaApagado) {
			jLabel.setBackground(Color.decode("#F0F0F0"));;
		}
	}
public static void lanzarFocoDashBoard(JPanel encendido,ArrayList<JPanel> listaApagago) {
	encendido.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(15, 149, 236)));
	
	for (JPanel jLabel : listaApagago) {
		jLabel.setBorder(null);
	
	}
	
}
	
}
