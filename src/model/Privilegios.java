package model;

public class Privilegios {

	
String	nom_privilegio;
boolean estado_privilegio;
public String getNom_privilegio() {
	return nom_privilegio;
}
public void setNom_privilegio(String nom_privilegio) {
	this.nom_privilegio = nom_privilegio;
}
public boolean isEstado_privilegio() {
	return estado_privilegio;
}
public void setEstado_privilegio(boolean estado_privilegio) {
	this.estado_privilegio = estado_privilegio;
}
public Privilegios(String nom_privilegio, boolean estado_privilegio) {
	
	this.nom_privilegio = nom_privilegio;
	this.estado_privilegio = estado_privilegio;
}
}
