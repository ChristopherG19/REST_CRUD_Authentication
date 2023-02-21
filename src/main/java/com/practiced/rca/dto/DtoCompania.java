package com.practiced.rca.dto;

public class DtoCompania {

	private String nombreCompania;
	private String claseVia;
	private String nombreVia;
	private Integer numeroVia;
	private Integer codigoPostal;
	private String telefonoContratacion;
	private String telefonoSiniestros;
	private String notas;

	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public String getClaseVia() {
		return claseVia;
	}
	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}
	public Integer getNumeroVia() {
		return numeroVia;
	}
	public void setNumeroVia(Integer numeroVia) {
		this.numeroVia = numeroVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getTelefonoContratacion() {
		return telefonoContratacion;
	}
	public void setTelefonoContratacion(String telefonoContratacion) {
		this.telefonoContratacion = telefonoContratacion;
	}
	public String getTelefonoSiniestros() {
		return telefonoSiniestros;
	}
	public void setTelefonoSiniestros(String telefonoSiniestros) {
		this.telefonoSiniestros = telefonoSiniestros;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
}
