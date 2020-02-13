package model;

public class Caja {
	private int codCaja;
	private String nomCaja;
	private double saldo;
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getCodCaja() {
		return codCaja;
	}
	public void setCodCaja(int codCaja) {
		this.codCaja = codCaja;
	}
	public String getNomCaja() {
		return nomCaja;
	}
	public void setNomCaja(String nomCaja) {
		this.nomCaja = nomCaja;
	}

}
