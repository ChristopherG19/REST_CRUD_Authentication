package com.practiced.rca.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTES", schema = "SEGUNI")
public class Cliente implements Serializable{

	private static final long serialVersionUID = -3630605027551015154L;

	@Id
	@Column(name="DPI")
	private String dpi;

	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDOP")
	private String apellidoP;

	@Column(name="APELLIDOM")
	private String apellidoM;
	
	@Column(name="CLASEVIA")
	private String claseVia;
	
	@Column(name="NOMBREVIA")
	private String nombreVia;
	
	@Column(name="NUMEROVIA")
	private Integer numeroVia;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@Column(name="CODIGOPOSTAL")
	private String codigoPostal;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
