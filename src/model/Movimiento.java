package model;

public class Movimiento {
	
	String comentario,tipo_movimiento,nomCaja,fecha;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNomCaja() {
		return nomCaja;
	}
	public void setNomCaja(String nomCaja) {
		this.nomCaja = nomCaja;
	}
	int codMovi,Nro_ven,cod_regis_com,codcaja;
	public int getCodMovi() {
		return codMovi;
	}
	public void setCodMovi(int codMovi) {
		this.codMovi = codMovi;
	}
	double entrada,salida,saldo;
	boolean tiene_corte_caja;
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getTipo_movimiento() {
		return tipo_movimiento;
	}
	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}
	
	public int getCodcaja() {
		return codcaja;
	}
	public void setCodcaja(int codcaja) {
		this.codcaja = codcaja;
	}
	public int getNro_ven() {
		return Nro_ven;
	}
	public void setNro_ven(int nro_ven) {
		Nro_ven = nro_ven;
	}
	public int getCod_regis_com() {
		return cod_regis_com;
	}
	public void setCod_regis_com(int cod_regis_com) {
		this.cod_regis_com = cod_regis_com;
	}
	public double getEntrada() {
		return entrada;
	}
	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}
	public double getSalida() {
		return salida;
	}
	public void setSalida(double salida) {
		this.salida = salida;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isTiene_corte_caja() {
		return tiene_corte_caja;
	}
	public void setTiene_corte_caja(boolean tiene_corte_caja) {
		this.tiene_corte_caja = tiene_corte_caja;
	}
	
}
