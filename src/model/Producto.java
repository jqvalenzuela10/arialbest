package model;



public class Producto {
	
	private int codigo,codbarra,factor,stock;
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	private String descripcion,marca,unidadCompra,unidadVenta,codregistrosani,nomCat;
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	private double precioProCom,precioProVen;
	private boolean lote;
	private int codSunat;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodbarra() {
		return codbarra;
	}
	public void setCodbarra(int codbarra) {
		this.codbarra = codbarra;
	}
	public int getFactor() {
		return factor;
	}
	public void setFactor(int factor) {
		this.factor = factor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getUnidadCompra() {
		return unidadCompra;
	}
	public void setUnidadCompra(String unidadCompra) {
		this.unidadCompra = unidadCompra;
	}
	public String getUnidadVenta() {
		return unidadVenta;
	}
	public void setUnidadVenta(String unidadVenta) {
		this.unidadVenta = unidadVenta;
	}
	public String getCodregistrosani() {
		return codregistrosani;
	}
	public void setCodregistrosani(String codregistrosani) {
		this.codregistrosani = codregistrosani;
	}
	public double getPrecioProCom() {
		return precioProCom;
	}
	public void setPrecioProCom(double precioProCom) {
		this.precioProCom = precioProCom;
	}
	public double getPrecioProVen() {
		return precioProVen;
	}
	public void setPrecioProVen(double precioProVen) {
		this.precioProVen = precioProVen;
	}
	public boolean getLote() {
		return lote;
	}
	public void setLote(boolean lote) {
		this.lote = lote;
	}
	public int getCodSunat() {
		return codSunat;
	}
	public void setCodSunat(int codSunat) {
		this.codSunat = codSunat;
	}

	

	
	

	
	
	
}
