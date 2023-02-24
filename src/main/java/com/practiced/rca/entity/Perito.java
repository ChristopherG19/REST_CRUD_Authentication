package com.practiced.rca.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERITOS", schema = "SEGUNI2")
public class Perito implements Serializable{
	
	private static final long serialVersionUID = -8911871826469653441L;

	@Id
	@Column(name="DPIPERITO")
	private String dpiPerito;
	
	@Column(name="NOMBREPERITO")
	private String nombrePerito;
	
	@Column(name="APELLIDOP")
	private String apellidoP;

	@Column(name="APELLIDOM")
	private String apellidoM;
	
	@Column(name="TELEFONOCONTACTO")
	private String telefonoContacto;
	
	@Column(name="TELEFONOOFICINA")
	private String telefonoOficina;
	
	@Column(name="CLASEVIA")
	private String claseVia;
	
	@Column(name="NOMBREVIA")
	private String nombreVia;
	
	@Column(name="NUMEROVIA")
	private Integer numeroVia;
	
	@Column(name="CODIGOPOSTAL")
	private String codigoPostal;
	
	@Column(name="CIUDAD")
	private String ciudad;

	public String getDpiPerito() {
		return dpiPerito;
	}

	public void setDpiPerito(String dpiPerito) {
		this.dpiPerito = dpiPerito;
	}

	public String getNombrePerito() {
		return nombrePerito;
	}

	public void setNombrePerito(String nombrePerito) {
		this.nombrePerito = nombrePerito;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getTelefonoOficina() {
		return telefonoOficina;
	}

	public void setTelefonoOficina(String telefonoOficina) {
		this.telefonoOficina = telefonoOficina;
	}

	public String getClaseVia() {
		return claseVia;
	}

	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public Integer getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(Integer numeroVia) {
		this.numeroVia = numeroVia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
