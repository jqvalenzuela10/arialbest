package Interfaces;

import java.util.ArrayList;

import model.Caja;

public interface InterfaceCaja {
	
	public ArrayList<Caja> listado();
	
	public int agregar(Caja c);
	
	
	public int actualizar(Caja c);
}
