package utils;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

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
	
	
}
