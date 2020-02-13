package model;

public class Ventas {
	private int Nro_ven ,id_cli,id_emp;
	private String doc_ven,fech_ven,numeroComprovante,fecha_vencimiento,formaPago;
	
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public String getNumeroComprovante() {
		return numeroComprovante;
	}
	public void setNumeroComprovante(String numeroComprovante) {
		this.numeroComprovante = numeroComprovante;
	}
	public int getNro_ven() {
		return Nro_ven;
	}
	public void setNro_ven(int nro_ven) {
		Nro_ven = nro_ven;
	}
	public int getId_cli() {
		return id_cli;
	}
	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}
	public String getDoc_ven() {
		return doc_ven;
	}
	public void setDoc_ven(String doc_ven) {
		this.doc_ven = doc_ven;
	}
	public String getFech_ven() {
		return fech_ven;
	}
	public void setFech_ven(String fech_ven) {
		this.fech_ven = fech_ven;
	}
	
	
	
}
