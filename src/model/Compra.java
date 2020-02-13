package model;

public class Compra {

	int nroCompra,idProveCom;
	public int getNroCompra() {
		return nroCompra;
	}
	public void setNroCompra(int nroCompra) {
		this.nroCompra = nroCompra;
	}
	public int getIdProveCom() {
		return idProveCom;
	}
	public void setIdProveCom(int idProveCom) {
		this.idProveCom = idProveCom;
	}
	public String getDocumentocom() {
		return documentocom;
	}
	public void setDocumentocom(String documentocom) {
		this.documentocom = documentocom;
	}
	public String getFechaCom() {
		return fechaCom;
	}
	public void setFechaCom(String fechaCom) {
		this.fechaCom = fechaCom;
	}
	String documentocom,fechaCom;
	
}
