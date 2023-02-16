package com.practiced.rca.dto;

import java.util.Date;

import com.practiced.rca.entity.Perito;

public class DtoSiniestro {
	private Integer idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private String aceptado;
	private Integer indemnizacion;
	private Integer numeroPoliza;
	private Perito perito;
	
	public Integer getIdSiniestro() {
		return idSiniestro;
	}
	public void setIdSiniestro(Integer idSiniestro) {
		this.idSiniestro = idSiniestro;
	}
	public Date getFechaSiniestro() {
		return fechaSiniestro;
	}
	public void setFechaSiniestro(Date fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}
	public String getCausas() {
		return causas;
	}
	public void setCausas(String causas) {
		this.causas = causas;
	}
	public String getAceptado() {
		return aceptado;
	}
	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}
	public Integer getIndemnizacion() {
		return indemnizacion;
	}
	public void setIndemnizacion(Integer indemnizacion) {
		this.indemnizacion = indemnizacion;
	}
	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	public Perito getPerito() {
		return perito;
	}
	public void setPerito(Perito perito) {
		this.perito = perito;
	}
	
}
