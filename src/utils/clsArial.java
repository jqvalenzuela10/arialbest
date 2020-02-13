package utils;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.axis.StandardTickUnitSource;
import org.omg.CORBA.PUBLIC_MEMBER;

import model.RoundedCornerBorder;
import vista.IntCobranza;
import vista.IntFinanzas;
import vista.IntUsuario;

public  class clsArial    {

	public static String colorCeleste="#0f95ec";
	public static String colorMenu="#2D363F";
	public static String colorHover="#232b37";
	public static String colorBlancoHumo="#f0f0f0";
	public static String colorBlancoHumoClaro="#FAFAFA";
	public static String colorGrisOscuro="#959595";
	
	public clsArial() {
		// TODO Auto-generated constructor stub
	}

	
	/*--- METODO ICONOS PERSONALIZADOS -- */
	public   void modifiedIcon(String url,int with,int heigh,JLabel label) {
		ImageIcon imgIcon = new ImageIcon(getClass().getResource(url));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(with, heigh, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label.setIcon(iconoEscalado);
	}
	
	
	/*--- METODO DEFINIR INTERNAL FRAME Y SUB INTERAL FRAME -- */
	public static void setInternalFrame(JDesktopPane Desktop,JInternalFrame Internalframe,JDesktopPane subDesktop,JInternalFrame subInternalFrame) {
		Desktop.removeAll();
		Desktop.repaint();
	
		Desktop.add(Internalframe);
		try {
			Internalframe.setMaximum(true);
			Internalframe.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
			Internalframe.show(); 
			
			if (subInternalFrame!=null) {
				

				IntFinanzas.lblPagos.setForeground(Color.decode(IntFinanzas.colorNegro));
			
				IntFinanzas.rayaPago.setVisible(true);
				
				IntFinanzas.lblCobranza.setForeground(Color.decode(IntFinanzas.colorPlomo));
				IntFinanzas.rayaUsu.setVisible(false);
				subDesktop.removeAll();
				subDesktop.repaint();
			
				subDesktop.add(subInternalFrame);
				try {
					subInternalFrame.setMaximum(true);
					subInternalFrame.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
					subInternalFrame.show(); 
				
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}

	
	

		
		
		
	}
	

	
}
