package com.practiced.rca.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERITOS", schema = "SEGUNI")
public class Perito implements Serializable{
	
	private static final long serialVersionUID = -8911871826469653441L;

	@Id
	@Column(name="DNI_PERITO")
	private String dniPerito;
	
	@Column(name="NOMBRE_PERITO")
	private String nombrePerito;
	
	@Column(name="APELLIDO_PERITO1")
	private String apellidoPerito1;
	
	@Column(name="APELLIDO_PERITO2")
	private String apellidoPerito2;
	
	@Column(name="TELEFONO_CONTACTO")
	private String telefonoContacto;
	
	@Column(name="TELEFONO_OFICINA")
	private String telefonoOficina;
	
	@Column(name="CLASE_VIA")
	private String claseVia;
	
	@Column(name="NOMBRE_VIA")
	private String nombreVia;
	
	@Column(name="NUMERO_VIA")
	private Integer numeroVia;
	
	@Column(name="COD_POSTAL")
	private Integer codPostal;
	
	@Column(name="CIUDAD")
	private String ciudad;

	
	public String getNombrePerito() {
		return nombrePerito;
	}

	public void setNombrePerito(String nombrePerito) {
		this.nombrePerito = nombrePerito;
	}



	public String getDniPerito() {
		return dniPerito;
	}

	public void setDniPerito(String dniPerito) {
		this.dniPerito = dniPerito;
	}

	public String getApellidoPerito1() {
		return apellidoPerito1;
	}

	public void setApellidoPerito1(String apellidoPerito1) {
		this.apellidoPerito1 = apellidoPerito1;
	}

	public String getApellidoPerito2() {
		return apellidoPerito2;
	}

	public void setApellidoPerito2(String apellidoPerito2) {
		this.apellidoPerito2 = apellidoPerito2;
	}

	public Integer getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(Integer codPostal) {
		this.codPostal = codPostal;
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


	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
