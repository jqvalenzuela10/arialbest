package Interfaces;

import java.util.ArrayList;

import model.CorteCaja;
import model.CorteCajaListadito;
import model.DetalleCorteCaja;
import model.Movimiento;

public interface InterfaceCorteCaja {
	public int ObtenerNumero();
	
	
	/*public double obtenerSaldo(int codCaja);*/
	
	public ArrayList<CorteCaja> calcularCalculado(int codCaja);
	
	public int registrarCorteDeCaja(CorteCaja c,ArrayList<DetalleCorteCaja> detalle);
	
	public ArrayList<DetalleCorteCaja> listadoParaElDetalle(int codigoCaja);
	
	
	/*listado corte caja*/
	public ArrayList<CorteCajaListadito> listadito(int codCaja);
	
	public ArrayList<CorteCajaListadito> listaditoult();
	
	public ArrayList<Movimiento> listadoXmovimiento(int codCaja);
	
}
