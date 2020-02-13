package Interfaces;

import java.util.ArrayList;

import model.Cotizacion;
import model.DetalleCotizacion;

public interface InterfaceCotizacion {

	public int ObtenerNumero();
	public int agregar(Cotizacion c,ArrayList<DetalleCotizacion>deta);
	
}
