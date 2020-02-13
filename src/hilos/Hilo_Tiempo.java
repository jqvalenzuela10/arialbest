package hilos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IllegalFormatCodePointException;

import vista.FrmMenuPrincipal;
import vista.FrmOrdenDeCompra;
import vista.FrmRegistroCompra;
import vista.IntVentasWindow;
public class Hilo_Tiempo extends Thread{
	

	
		
		public void run() {
			while(true) {
				Date tiempo = new Date();
				SimpleDateFormat sdf1=new SimpleDateFormat("dd MMM .YYYY");
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				SimpleDateFormat seg=new SimpleDateFormat("ss");
				
				
				if(FrmMenuPrincipal.lblFecha!=null) {
					FrmMenuPrincipal.lblFecha.setText(sdf1.format(tiempo));//FECHA
					FrmMenuPrincipal.lblReloj.setText(sdf.format(tiempo));//HORA
				}
				
	
				
				if(FrmOrdenDeCompra.lblFecha!=null) {
				FrmOrdenDeCompra.lblReloj.setText(sdf.format(tiempo));
				FrmOrdenDeCompra.lblFecha.setText(sdf1.format(tiempo));
				}
				
				
				
				if(FrmRegistroCompra.lblFecha!=null) {					
					FrmRegistroCompra.lblReloj.setText(sdf.format(tiempo));
					FrmRegistroCompra.lblFecha.setText(sdf1.format(tiempo));
				}
				
				
				
				if(IntVentasWindow.lblFecha!=null) {
					IntVentasWindow.lblReloj.setText(sdf.format(tiempo));
					IntVentasWindow.lblFecha.setText(sdf1.format(tiempo));
				}
				
			}
			
			
		}	
	}


