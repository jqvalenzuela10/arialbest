package model;

public class CorteCajaListadito {

	String fecha,nomCaja,fechaCorteCaja,horaCorteCaja,nomUsu,desUsu;
	int codCaja;
	public int getCodCaja() {
		return codCaja;
	}

	public void setCodCaja(int codCaja) {
		this.codCaja = codCaja;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getDesUsu() {
		return desUsu;
	}

	public void setDesUsu(String desUsu) {
		this.desUsu = desUsu;
	}

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

	public String getFechaCorteCaja() {
		return fechaCorteCaja;
	}

	public void setFechaCorteCaja(String fechaCorteCaja) {
		this.fechaCorteCaja = fechaCorteCaja;
	}

	public String getHoraCorteCaja() {
		return horaCorteCaja;
	}

	public void setHoraCorteCaja(String horaCorteCaja) {
		this.horaCorteCaja = horaCorteCaja;
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



	double contado,calculado,diferencia,retirado;
	
	
}
