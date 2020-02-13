package Interfaces;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

import model.Compra;
import model.DetalleCompra;
import model.OrdenCompra;
import model.OrdenRegistroCompra;


public interface InterfaceCompra {

	public int ObtenerNumero();
	public int ObtenerNumeroRegistroCompra();

	
	//REGISTRAR VENTA
	public int realizaCompra(Compra c,ArrayList<DetalleCompra>detalle);
	
	/*registrar orden de compra*/
	
	public int ordenCompra(OrdenCompra c,ArrayList<DetalleCompra> d);
	
	/*gestion orden de compra*/
	public ArrayList<OrdenCompra> listadoOrdenCompra();
	
	/*gestion orden de compra*/
	public ArrayList<OrdenCompra> listaOrdenCompra(int codigo);
	public ArrayList<OrdenCompra> obtenerDatosOrdenCompra(int codigo);
	
	/*gestion registro de compra*/
	public ArrayList<OrdenRegistroCompra> listadoRegistroCompra();
	
	/*gestion registro de compra*/
	public ArrayList<OrdenRegistroCompra> listadoXcodigoRegisCompra(int codigo);
	
	
	/*filtrar los registro de compra por ?*/
	public ArrayList<OrdenRegistroCompra> listadoXFiltro(String filtro,String busquedad);
	
	/*filtrar los ordenes de compra*/
	public ArrayList<OrdenCompra> listadoXFiltroOrden(String filtro,String busquedad);
}
