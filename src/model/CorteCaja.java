package model;

public class CorteCaja {
String nomUsu,descripcion;
	public String getNomUsu() {
	return nomUsu;
}
public void setNomUsu(String nomUsu) {
	this.nomUsu = nomUsu;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
	int codCorteCaja,codCaja;
	public int getCodCorteCaja() {
		return codCorteCaja;
	}
	public void setCodCorteCaja(int codCorteCaja) {
		this.codCorteCaja = codCorteCaja;
	}
	double contado,calculado,diferencia,retirado;
	public int getCodCaja() {
		return codCaja;
	}
	public void setCodCaja(int codCaja) {
		this.codCaja = codCaja;
	}
	public double getContado() {
		return contado;
	}
	public void setContado(double contado) {
		this.contado = contado;
	}
	public double getCalculado() {
		return calculado;
	}
	public void setCalculado(double calculado) {
		this.calculado = calculado;
	}
	public double getDiferencia() {
		return diferencia;
	}
	public void setDiferencia(double diferencia) {
		this.diferencia = diferencia;
	}
	public double getRetirado() {
		return retirado;
	}
	public void setRetirado(double retirado) {
		this.retirado = retirado;
	}
	
}
