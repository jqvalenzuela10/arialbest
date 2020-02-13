package model;

public class Lotes {

	int cod_lote,existenciaInicial,existenciaActual,venceDias,idPro;
	String fecha_produccion,fecha_caducidad,fechaUltimoMovimiento;
	public int getCod_lote() {
		return cod_lote;
	}
	public void setCod_lote(int cod_lote) {
		this.cod_lote = cod_lote;
	}
	public int getExistenciaInicial() {
		return existenciaInicial;
	}
	public void setExistenciaInicial(int existenciaInicial) {
		this.existenciaInicial = existenciaInicial;
	}
	public int getExistenciaActual() {
		return existenciaActual;
	}
	public void setExistenciaActual(int existenciaActual) {
		this.existenciaActual = existenciaActual;
	}
	public int getVenceDias() {
		return venceDias;
	}
	public void setVenceDias(int venceDias) {
		this.venceDias = venceDias;
	}
	public String getFechaUltimoMovimiento() {
		return fechaUltimoMovimiento;
	}
	public void setFechaUltimoMovimiento(String fechaUltimoMovimiento) {
		this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	}
	public int getIdPro() {
		return idPro;
	}
	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
	public String getFecha_produccion() {
		return fecha_produccion;
	}
	public void setFecha_produccion(String fecha_produccion) {
		this.fecha_produccion = fecha_produccion;
	}
	public String getFecha_caducidad() {
		return fecha_caducidad;
	}
	public void setFecha_caducidad(String fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}
}
