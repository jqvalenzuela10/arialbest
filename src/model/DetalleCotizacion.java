package model;

public class DetalleCotizacion {

	private int nroCoti,idPro,cantidad;
	double precio,descuento;
	public int getNroCoti() {
		return nroCoti;
	}
	public void setNroCoti(int nroCoti) {
		this.nroCoti = nroCoti;
	}
	public int getIdPro() {
		return idPro;
	}
	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
}
