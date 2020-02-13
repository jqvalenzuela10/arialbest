package model;

public class Clientes {

	private int  id_cli ;
	private String nomb_cli,num_doc_cli_,nom_comercial ,departamento_cli,telf_cli,direc_cli,Distrito_cli,tip_doc_cli,formaPago_cli,tip_persona_cli,correo,celular,estado;

	double limite_credito;

	public double getLimite_credito() {
		return limite_credito;
	}
	public void setLimite_credito(double limite_credito) {
		this.limite_credito = limite_credito;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCelular() {
		return celular;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getNum_doc_cli_() {
	 return num_doc_cli_;
	}
	public void setNum_doc_cli_(String num_doc_cli_) {
	 this.num_doc_cli_ = num_doc_cli_;
	}
	public String getTip_doc_cli() {
	 return tip_doc_cli;
	}
	public void setTip_doc_cli(String tip_doc_cli) {
	 this.tip_doc_cli = tip_doc_cli;
	}
	public int getId_cli() {
	 return id_cli;
	}
	public void setId_cli(int id_cli) {
	 this.id_cli = id_cli;
	}
	public String getNomb_cli() {
	 return nomb_cli;
	}
	public void setNomb_cli(String nomb_cli) {
	 this.nomb_cli = nomb_cli;
	}


	public String getNom_comercial() {
	 return nom_comercial;
	}
	public void setNom_comercial(String nom_comercial) {
	 this.nom_comercial = nom_comercial;
	}
	public String getDepartamento_cli() {
	 return departamento_cli;
	}
	public void setDepartamento_cli(String departamento_cli) {
	 this.departamento_cli = departamento_cli;
	}
	public String getDistrito_cli() {
	 return Distrito_cli;
	}
	public void setDistrito_cli(String distrito_cli) {
	 Distrito_cli = distrito_cli;
	}

	public String getFormaPago_cli() {
	 return formaPago_cli;
	}
	public void setFormaPago_cli(String formaPago_cli) {
	 this.formaPago_cli = formaPago_cli;
	}
	public String getTip_persona_cli() {
	 return tip_persona_cli;
	}
	public void setTip_persona_cli(String tip_persona_cli) {
	 this.tip_persona_cli = tip_persona_cli;
	}
	public String getTelf_cli() {
	 return telf_cli;
	}
	public void setTelf_cli(String telf_cli) {
	 this.telf_cli = telf_cli;
	}
	public String getDirec_cli() {
	 return direc_cli;
	}
	public void setDirec_cli(String direc_cli) {
	 this.direc_cli = direc_cli;
	}
	
}
