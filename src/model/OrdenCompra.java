package model;

public class OrdenCompra {
	
	int nroOrdenCompra,codProveedor,codUsuario;
	double total;
	
	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getNroOrdenCompra() {
		return nroOrdenCompra;
	}


	public void setNroOrdenCompra(int nroOrdenCompra) {
		this.nroOrdenCompra = nroOrdenCompra;
	}


	public int getCodProveedor() {
		return codProveedor;
	}


	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}


	public int getCodUsuario() {
		return codUsuario;
	}


	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}


	public String getNomUsuario() {
		return nomUsuario;
	}


	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}


	public String getFechaOrdenCompra() {
		return fechaOrdenCompra;
	}


	public void setFechaOrdenCompra(String fechaOrdenCompra) {
		this.fechaOrdenCompra = fechaOrdenCompra;
	}


	public String getNomProveedor() {
		return nomProveedor;
	}


	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}


	public String getContacto() {
		return contacto;
	}


	public void setContacto(String contacto) {
		this.contacto = contacto;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public String getDirecEntrega() {
		return direcEntrega;
	}


	public void setDirecEntrega(String direcEntrega) {
		this.direcEntrega = direcEntrega;
	}


	public String getDirecFactura() {
		return direcFactura;
	}


	public void setDirecFactura(String direcFactura) {
		this.direcFactura = direcFactura;
	}


	public String getCondicionPago() {
		return condicionPago;
	}


	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}


	String nomUsuario,fechaOrdenCompra,nomProveedor,contacto,telefono,email,fechaEntrega;
	
	
	/*para registrar*/
	String direcEntrega,direcFactura,condicionPago;
	
	int idprodu,cantidad;
	public int getIdprodu() {
		return idprodu;
	}


	public void setIdprodu(int idprodu) {
		this.idprodu = idprodu;
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


	double precio;
	
	private String nomProd;
	public String getNomProd() {
		return nomProd;
	}


	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	
	private String ruc,direcProveedor;
	public String getDirecProveedor() {
		return direcProveedor;
	}


	public void setDirecProveedor(String direcProveedor) {
		this.direcProveedor = direcProveedor;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
}



