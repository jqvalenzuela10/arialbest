package model;

public class RegistroCompra {

	private int codRegisCompra,nroOrdenCompra,idProve,idUsu,nroRegistroCompra;
	private boolean pagado,anulado,recibido;
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public boolean isAnulado() {
		return anulado;
	}
	public void setAnulado(boolean anulado) {
		this.anulado = anulado;
	}
	public boolean isRecibido() {
		return recibido;
	}
	public void setRecibido(boolean recibido) {
		this.recibido = recibido;
	}
	public int getNroRegistroCompra() {
		return nroRegistroCompra;
	}
	public void setNroRegistroCompra(int nroRegistroCompra) {
		this.nroRegistroCompra = nroRegistroCompra;
	}
	private String comprovante,fechaRegisCompra,fechaVenCompra,condicionesPago,contacto;
	
	

	public int getIdProve() {
		return idProve;
	}
	public void setIdProve(int idProve) {
		this.idProve = idProve;
	}
	public int getIdUsu() {
		return idUsu;
	}
	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	public String getCondicionesPago() {
		return condicionesPago;
	}
	public void setCondicionesPago(String condicionesPago) {
		this.condicionesPago = condicionesPago;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public int getCodRegisCompra() {
		return codRegisCompra;
	}
	public void setCodRegisCompra(int codRegisCompra) {
		this.codRegisCompra = codRegisCompra;
	}
	public int getNroOrdenCompra() {
		return nroOrdenCompra;
	}
	public void setNroOrdenCompra(int nroOrdenCompra) {
		this.nroOrdenCompra = nroOrdenCompra;
	}
	public String getComprovante() {
		return comprovante;
	}
	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
	}
	public String getFechaRegisCompra() {
		return fechaRegisCompra;
	}
	public void setFechaRegisCompra(String fechaRegisCompra) {
		this.fechaRegisCompra = fechaRegisCompra;
	}
	public String getFechaVenCompra() {
		return fechaVenCompra;
	}
	public void setFechaVenCompra(String fechaVenCompra) {
		this.fechaVenCompra = fechaVenCompra;
	}
	
	
}
