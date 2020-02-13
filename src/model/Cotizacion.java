package model;

public class Cotizacion {
private int nroCoti,idUsu,idCli;
public int getNroCoti() {
	return nroCoti;
}
public void setNroCoti(int nroCoti) {
	this.nroCoti = nroCoti;
}
public int getIdUsu() {
	return idUsu;
}
public void setIdUsu(int idUsu) {
	this.idUsu = idUsu;
}
public int getIdCli() {
	return idCli;
}
public void setIdCli(int idCli) {
	this.idCli = idCli;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public String getFechaCoti() {
	return fechaCoti;
}
public void setFechaCoti(String fechaCoti) {
	this.fechaCoti = fechaCoti;
}
public String getFechaVenci() {
	return fechaVenci;
}
public void setFechaVenci(String fechaVenci) {
	this.fechaVenci = fechaVenci;
}
public boolean isFacturado() {
	return facturado;
}
public void setFacturado(boolean facturado) {
	this.facturado = facturado;
}
private double total;
private String fechaCoti,fechaVenci;	
	private boolean facturado;
	
}
