package Interfaces;

import java.util.ArrayList;

import model.Cobranza;
import model.Producto;

public interface InterfaceFinanzas {
	
	public ArrayList<Cobranza>listado(); 
	public ArrayList<Cobranza>listadoxFecha(String año,String mes); 
	public ArrayList<Cobranza>listadoCobranzaHoy(); 
	public ArrayList<Cobranza>listadoxCliente(String nombre); 

}
