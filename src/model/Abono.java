package model;

public class Abono {

	String fecha_abono,forma_pago,observ_abono,monto_abono,id_venta,id_usuario;

	public String getId_venta() {
		return id_venta;
	}

	public void setId_venta(String id_venta) {
		this.id_venta = id_venta;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getFecha_abono() {
		return fecha_abono;
	}

	public void setFecha_abono(String fecha_abono) {
		this.fecha_abono = fecha_abono;
	}

	public String getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}

	public String getObserv_abono() {
		return observ_abono;
	}

	public void setObserv_abono(String observ_abono) {
		this.observ_abono = observ_abono;
	}

	public String getMonto_abono() {
		return monto_abono;
	}

	public void setMonto_abono(String monto_abono) {
		this.monto_abono = monto_abono;
	}
}
